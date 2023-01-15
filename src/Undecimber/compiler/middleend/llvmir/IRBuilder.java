package undecimber.compiler.middleend.llvmir;

import org.antlr.v4.runtime.misc.Pair;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.nodes.exprNode.*;
import undecimber.compiler.frontend.ast.nodes.stmtNode.*;
import undecimber.compiler.frontend.registry.ClassRegistry;
import undecimber.compiler.frontend.registry.FuncRegistry;
import undecimber.compiler.frontend.registry.VarRegistry;
import undecimber.compiler.frontend.scope.*;
import undecimber.compiler.frontend.semantic.StackStation;
import undecimber.compiler.frontend.semantic.StringBuiltInMethods;
import undecimber.compiler.middleend.llvmir.irconst.*;
import undecimber.compiler.middleend.llvmir.irnode.*;
import undecimber.compiler.middleend.llvmir.irtype.*;
import utility.LLVM;
import utility.Mx;
import utility.types.MxBaseType;
import utility.types.MxFuncType;
import utility.types.VarType;

import java.util.ArrayList;
import java.util.Objects;

public class IRBuilder implements ASTVisitor {
    public IRTranslator translator = new IRTranslator();
    public StackStation station = new StackStation();
    public CurrentInfo cur = new CurrentInfo();
    public IRModule module = new IRModule();

    public IRBuilder(RootNode node) {
        node.accept(this);
    }

    /**
     * @param node
     */
    @Override
    public void visit(RootNode node) {
        station.push(node.scope);
        translator.setGlobalScope(node.scope);
        builtInFuncDeclaration(node);
        createInitFunc();
        classDeclaration(node);
        for (ASTNode sonNode : node.sonNodes) {
            if (sonNode instanceof FuncDefNode) funcDeclaration((FuncDefNode) sonNode);
        }
        for (ASTNode sonNode : node.sonNodes) {
            if (sonNode instanceof VarDefStmtNode) sonNode.accept(this);
        }
        cur.TerminateAll();
        for (ASTNode sonNode : node.sonNodes) {
            if (!(sonNode instanceof VarDefStmtNode)) sonNode.accept(this);
        }
        station.pop();
    }

    /**
     * @param node
     */
    @Override
    public void visit(ClassDefNode node) {
        ClassScope tmpScope = node.classRegistry.scope;
        station.push(tmpScope);
        cur.classRegistry=node.classRegistry;
        for (VarDefStmtNode varDefStmtNode : node.varDefs) {
            varDefStmtNode.accept(this);
        }
        if (node.constructorDefNode != null) node.constructorDefNode.accept(this);

        for (FuncDefNode funcDefNode : node.funcDefs) {
            funcDefNode.accept(this);
        }
        cur.classRegistry = null;
        station.pop();
    }

    /**
     * @param node
     */
    @Override
    public void visit(VarDefStmtNode node) {
        for (VarDefSingleNode varDefSingleNode : node.varDefSingleNodes) {
            varDefSingleNode.accept(this);
        }
    }

    /**
     * @param node
     */
    @Override
    public void visit(VarDefSingleNode node) {
        Value allocaPtr;
        // global variables
        if (Objects.equals(cur.function.name, LLVM.InitFuncName)) {
            if (cur.classRegistry != null) {
                allocaPtr = new GlobalVariable(cur.classRegistry.name + LLVM.Splitter + node.varRegistry.name,
                        translator.translateAllocaType(node.varRegistry.type));
            } else {
                allocaPtr = new GlobalVariable(node.varRegistry.name,
                        translator.translateAllocaType(node.varRegistry.type));
                module.globalVarArray.add((GlobalVariable) allocaPtr);
            }
        } else {
            allocaPtr = memAlloca(node.varRegistry.name, translator.translateAllocaType(node.varRegistry.type));
        }
        node.value = allocaPtr;
        node.varRegistry.value = allocaPtr;
        //normal int,bool,etc
        if (node.initExpNode != null) {
            //have init values
            node.initExpNode.accept(this);
            Value _value = node.initExpNode.value;
            memStore(allocaPtr, _value);

            if (allocaPtr instanceof GlobalVariable && (node.initExpNode.value instanceof IntConst || node.initExpNode.value instanceof BoolConst))
                ((GlobalVariable) allocaPtr).val = node.initExpNode.value;
        } else if (node.varRegistry.type.match(MxBaseType.BasicType.CLASS) || node.varRegistry.type.isArray()) {
            // array and class should init nullptr, string doesn't need init values
            memStore(allocaPtr, new NullConst());
        } else {
            //have no init values, init 0
            if (allocaPtr instanceof GlobalVariable) {
                if (((GlobalVariable) allocaPtr).PointedType().match(IRTranslator.i32Type))
                    ((GlobalVariable) allocaPtr).val = new IntConst(0);
                else if (((GlobalVariable) allocaPtr).PointedType().match(IRTranslator.boolType))
                    ((GlobalVariable) allocaPtr).val = new BoolConst(false);
            }
        }
    }

    /**
     * @param node
     */
    @Override
    public void visit(ReturnStmtNode node) {
        if (node.value != null && !node.value.type.match(MxBaseType.BasicType.VOID)) {
            node.value.accept(this);
            //todo
            memStore(cur.function.returnAddress, node.value.value);
        }
        new BrNode(cur.function.exitBlock, cur.block);
    }

    /**
     * @param node
     */
    @Override
    public void visit(PackStmtNode node) {
        node.packNode.accept(this);
    }

    /**
     * @param node
     */
    @Override
    public void visit(PureStmtNode node) {
        if (node.pure != null) node.pure.accept(this);
    }

    /**
     * @param node
     */
    @Override
    public void visit(IfStmtNode node) {
        IRBlock thenBlock = new IRBlock(LLVM.IfTrueBlockLabel, cur.function);
        IRBlock elseBlock = new IRBlock(LLVM.IfFalseBlockLabel, cur.function);
        IRBlock exitBlock = new IRBlock(LLVM.IfExitBlockLabel, cur.function);
        node.condition.accept(this);
        new BrNode(node.condition.value, thenBlock, elseBlock, cur.block);
        cur.block = elseBlock;
        if (node.elseStmt != null) {
            station.push(node.elseScope);
            node.elseStmt.accept(this);
            station.pop();
        }
        new BrNode(exitBlock, cur.block);
        cur.block = thenBlock;
        station.push(node.thenScope);
        node.thenStmt.accept(this);
        new BrNode(exitBlock, cur.block);
        station.pop();
        cur.block = exitBlock;
    }

    /**
     * @param node
     */
    @Override
    public void visit(AssignExprNode node) {;
        node.lhs.accept(this);
        node.rhs.accept(this);
        memStore(node.lhs.value.resolveFrom, node.rhs.value);//l <= r
        node.value = node.rhs.value;
        node.value.resolveFrom = node.lhs.value.resolveFrom;

    }

    /**
     * @param node
     */
    @Override
    public void visit(FuncDefNode node) {
        station.push(node.funcRegistry.scope);
        cur.function = (IRFunction) node.funcRegistry.value;
        cur.block = cur.function.entryBlock;
        if (!node.funcRegistry.type.retType.match(MxBaseType.BasicType.VOID)) {
            cur.function.returnAddress = memAlloca(LLVM.RetReg, translator.translateAllocaType(node.funcRegistry.type.retType));
            new RetNode(memLoad(cur.function.returnAddress, cur.function.exitBlock), cur.function.exitBlock);
        } else {
            new RetNode(cur.function.exitBlock);
        }
        if (Objects.equals(node.funcRegistry.name, Mx.mainStr)) {
            // call init func
            new CallNode((IRFunction) station.getFuncInStack(LLVM.InitFuncName).value, cur.block, new ArrayList<>());
            memStore(cur.function.returnAddress, new IntConst(0));
        }

        for (int i = 0; i < cur.function.getArgNum(); i++) {
            VarRegistry varRegistry;
            if (cur.classRegistry == null) varRegistry = node.funcRegistry.funcArgs.get(i);
            else {
                if (i == 0) {
                    cur.function.addArg(new Value(LLVM.ThisArg, new IRPointerType(cur.classRegistry.value.type)));
                    continue;
                } else {
                    varRegistry = node.funcRegistry.funcArgs.get(i - 1);
                }
            }
            Value ptr = memAlloca(varRegistry.name, translator.translateAllocaType(varRegistry.type));
            Value data = new Value(varRegistry.name, translator.translateVarType(varRegistry.type));
            varRegistry.value = ptr;
            cur.function.addArg(data);
            memStore(ptr, data);

        }
        node.packNode.accept(this);
        cur.TerminateAll();
        station.pop();
    }

    /**
     * @param node
     */
    @Override
    public void visit(PackNode node) {
        station.push(node.scope);
        for (BaseStmtNode stmtNode : node.stmtNodes) {
            stmtNode.accept(this);
        }
        station.pop();
    }

    /**
     * @param node
     */
    @Override
    public void visit(ControlStmtNode node) {
        cur.getControlNode(node.controlKey);
    }

    /**
     * @param node
     */
    @Override
    public void visit(ForStmtNode node) {
        IRBlock condBlock = new IRBlock(LLVM.ForCondBlockLabel, cur.function);
        IRBlock incrBlock = new IRBlock(LLVM.ForIncrBlockLabel, cur.function);
        IRBlock bodyBlock = new IRBlock(LLVM.ForBodyBlockLabel, cur.function);
        IRBlock exitBlock = new IRBlock(LLVM.ForExitBlockLabel, cur.function);
        station.push(node.scope);
        if (node.initExprNode != null) {
            node.initExprNode.accept(this);
            for (VarDefSingleNode varDefSingleNode : node.initVarDefSingleNodes) {
                varDefSingleNode.accept(this);
            }
        }
        new BrNode(condBlock, cur.block);
        cur.block = condBlock;

        if(node.conditionExprNode==null)new BrNode(bodyBlock,cur.block);
        else{
            node.conditionExprNode.accept(this);
            new BrNode(node.conditionExprNode.value, bodyBlock, exitBlock, cur.block);
        }
        cur.block = incrBlock;
        if (node.incrExprNode != null) node.incrExprNode.accept(this);
        new BrNode(condBlock, cur.block);

        cur.block = bodyBlock;
        cur.addControlTarget(incrBlock, exitBlock);
        node.bodyStmtNode.accept(this);
        new BrNode(incrBlock, cur.block);
        cur.deleteControlTarget();

        cur.block = exitBlock;

        station.pop();

    }


    /**
     * @param node
     */
    @Override
    public void visit(WhileStmtNode node) {
        IRBlock condBlock = new IRBlock(LLVM.WhCondBlockLabel, cur.function);
        IRBlock bodyBlock = new IRBlock(LLVM.WhBodyBlockLabel, cur.function);
        IRBlock exitBlock = new IRBlock(LLVM.WhExitBlockLabel, cur.function);
        new BrNode(condBlock, cur.block);
        station.push(node.scope);


        cur.block = condBlock;
        node.conditionExprNode.accept(this);
        Value condRes = node.conditionExprNode.value;
        new BrNode(condRes, bodyBlock, exitBlock, cur.block);


        cur.block = bodyBlock;
        cur.addControlTarget(condBlock, exitBlock);
        node.bodyStmtNode.accept(this);
        new BrNode(condBlock, cur.block);

        cur.deleteControlTarget();
        cur.block = exitBlock;
        station.pop();


    }

    /**
     * @param node
     */
    @Override
    public void visit(IndexExprNode node) {
        node.indexExprNode.accept(this);
        node.arrayExprNode.accept(this);
        node.value = memLoad(
                new GetElementPtrNode(
                        node.arrayExprNode.value.name + LLVM.ArrayElementSuffix,
                        node.arrayExprNode.value,
                        node.arrayExprNode.value.type,
                        cur.block,
                        node.indexExprNode.value
                ),
                cur.block);
    }

    /**
     * @param node
     */
    @Override
    public void visit(UnaryExprNode node) {
        node.selfExprNode.accept(this);
        switch (node.op) {
            case Mx.AddOp -> node.value = node.selfExprNode.value;
            case Mx.SubOp ->
                    node.value = new BinNode(LLVM.SubInst, IRTranslator.i32Type, new IntConst(0), node.selfExprNode.value, cur.block);
            case Mx.BitNotOp ->
                    node.value = new BinNode(LLVM.XorInst, IRTranslator.i32Type, node.selfExprNode.value, new IntConst(-1), cur.block);
            case Mx.LogicNotOp ->
                    node.value = new BinNode(LLVM.XorInst, IRTranslator.boolType, node.selfExprNode.value, new BoolConst(true), cur.block);
            default -> throw new InternalError("what's the fucking unary op you typed~");
        }
    }

    /**
     * @param node
     */
    @Override
    public void visit(BinaryExprNode node) {
        node.lhsExprNode.accept(this);

        if(node.opType.equals(Mx.logicOpType)){
            IRBlock tempBlock=cur.block;


            if (funcDetect(node)) {
                node.rhsExprNode.accept(this);
                node.value = new BinNode(IRTranslator.logic_2Bit(node.op),
                        IRTranslator.boolType,
                        node.lhsExprNode.value,
                        node.rhsExprNode.value, cur.block);
            }else {
                if(node.op.equals(Mx.LogicAndOp)) {
                    IRBlock uncutBlock = new IRBlock(LLVM.LogicUncutBlockLabel, cur.function),
                            exitBlock = new IRBlock(LLVM.LogicExitBlockLabel, cur.function);

                    // a && b = if(a)b else a;
                    new BrNode(node.lhsExprNode.value, uncutBlock, exitBlock, cur.block);
                    cur.block = uncutBlock;
                    node.rhsExprNode.accept(this);
                    new BrNode(exitBlock, cur.block);
                    node.value = new PhiNode(IRTranslator.boolType, exitBlock, node.lhsExprNode.value, tempBlock, node.rhsExprNode.value, cur.block);
                    cur.block=exitBlock;
                } else if (node.op.equals(Mx.LogicOrOp)) {
                        IRBlock uncutBlock = new IRBlock(LLVM.LogicUncutBlockLabel, cur.function),
                                exitBlock = new IRBlock(LLVM.LogicExitBlockLabel, cur.function);

                        // a || b = if(!a) b else a;
                        new BrNode(node.lhsExprNode.value,exitBlock,uncutBlock,cur.block);
                        cur.block=uncutBlock;
                        node.rhsExprNode.accept(this);
                        new BrNode(exitBlock,cur.block);
                        node.value=new PhiNode(IRTranslator.boolType,exitBlock,node.lhsExprNode.value,tempBlock,node.rhsExprNode.value,cur.block);

                    cur.block=exitBlock;
                }


            }
            return;
        }

        node.rhsExprNode.accept(this);
        String _op = node.op;

        //string cat
        if (node.lhsExprNode.type.match(MxBaseType.BasicType.STRING)) {
            node.value = new CallNode(module.getStrMethod(IRTranslator.translateStrOp(node.op)), cur.block, node.lhsExprNode.value, node.rhsExprNode.value);
            return;
        }

        switch (_op) {
            //todo:shortcutNotYet

            //compare ops(bool)
            case Mx.EqualOp, Mx.GreaterOp, Mx.GreaterEqualOp, Mx.LessEqualOp, Mx.LessOp, Mx.NotEqualOp ->
                    node.value = new ICmpNode(IRTranslator.translateOp(_op), node.lhsExprNode.value, node.rhsExprNode.value, cur.block);
            //arithmetic ops
            case Mx.BitAndOp,Mx.BitOrOp,Mx.BitXorOp ->
                node.value=new BinNode(IRTranslator.translateOp(_op),IRTranslator.i32Type,node.lhsExprNode.value,node.rhsExprNode.value,cur.block);

            //int ops
            default ->
                    node.value = new BinNode(_op, IRTranslator.i32Type, node.lhsExprNode.value, node.rhsExprNode.value, cur.block);
        }
    }

    private boolean funcDetect(ExprNode node) {
        if(node instanceof AtomExprNode){
            return (node.type instanceof MxFuncType);
        }else if(node instanceof BinaryExprNode){
            return funcDetect(((BinaryExprNode)node).lhsExprNode) && funcDetect(((BinaryExprNode)node).rhsExprNode);
        }
        return false;

    }

    /**
     * @param node
     */
    @Override
    public void visit(AtomExprNode node) {
        //constants
        if (node.ctx.IntLiteral() != null)
            node.value = new IntConst(Integer.parseInt(node.ctx.IntLiteral().toString()));
        else if (node.ctx.True() != null) {
            node.value = new BoolConst(true);
        } else if (node.ctx.False() != null) node.value = new BoolConst(false);
        else if (node.ctx.Null() != null) {
            node.value = new NullConst();
        } else if (node.ctx.This() != null) node.value = cur.getThis();
        else if (node.ctx.StringLiteral() != null) {
            String rawString = node.ctx.StringLiteral().toString();
            String constString = rawString.substring(1, rawString.length() - 1)
                    .replace("\\\"", "\"")
                    .replace("\\n", "\n")
                    .replace("\\t", "\t")
                    .replace("\\\\", "\\");
            node.value = new GetElementPtrNode(module.getStringConst(constString),
                    IRTranslator.stringType, cur.block, new IntConst(0), new IntConst(0));
        } else if (node.ctx.ID() != null) {
            if (node.type instanceof MxFuncType) {
                node.value = station.getFuncInStack(node.ctx.ID().getText()).value;
            } else if (node.type instanceof VarType) {

                Value valAddr;
                String name = node.ctx.ID().getText();
                Pair<VarRegistry, Boolean> res = station.getVarInStack_IR(name);
                VarRegistry var = res.a;
                int index = -1;
                if (cur.classRegistry != null && res.b)
                    index = cur.classRegistry.getMemberVarIndex(var.name);
                valAddr = (index >= 0) ?
                        new GetElementPtrNode(var.name, cur.getThis(),
                                new IRPointerType(translator.translateAllocaType(var.type)),
                                cur.block, new IntConst(0), new IntConst(index))
                        : var.value;

                // variable resolve
                node.value = memLoad(valAddr, cur.block);
            }
        }


    }

    /**
     * @param node
     */
    @Override
    public void visit(FuncCallExprNode node) {
        node.callExprNode.accept(this);
        if (node.callExprNode.value instanceof IRFunction) {
            ArrayList<Value> argV = new ArrayList<>();
            //this.function
            if ((((IRFuncType) node.callExprNode.value.type).memberOf != null)) {
                if (node.callExprNode instanceof MemberExprNode)
                    argV.add(((MemberExprNode) node.callExprNode).supExprNode.value);
                else {
                    //call in class(other function)
                    assert cur.classRegistry != null;
                    argV.add(cur.getThis());
                }
            }
            for (ExprNode callArgExpNode : node.callArgExpNodes) {
                callArgExpNode.accept(this);
                argV.add(callArgExpNode.value);
            }
            node.value = new CallNode((IRFunction) node.callExprNode.value, cur.block, argV);
        } else node.value = node.callExprNode.value;
    }

    /**
     * @param node
     */
    @Override
    public void visit(MemberExprNode node) {
        node.supExprNode.accept(this);
        if (node.supExprNode.type.isArray()) {
            Value _ptr = new BitCastNode(node.supExprNode.value, IRTranslator.i32PointerType, cur.block);
            node.value=memLoad(new GetElementPtrNode(_ptr, IRTranslator.i32PointerType, cur.block, new IntConst(-1)),cur.block);

        } else if (node.supExprNode.type.match(MxBaseType.BasicType.STRING)) {
            node.value = StringBuiltInMethods.scope.getFunc(node.name).value;
        } else {
            String className = ((VarType) node.supExprNode.type).className;
            ClassRegistry myClass = station.getClass(className);
            if (node.type instanceof MxFuncType) {
                node.value = myClass.scope.getFunc(node.name).value;
            } else {
                VarRegistry reg = myClass.scope.getVar(node.name);
                Value addr = new GetElementPtrNode(node.name, node.supExprNode.value, new IRPointerType(translator.translateAllocaType(reg.type)), cur.block, new IntConst(0), new IntConst(myClass.getMemberVarIndex(reg.name)));
                node.value = memLoad(addr, cur.block);
            }
        }

    }

    /**
     * @param node
     */
    @Override
    public void visit(NewExprNode node) {
        assert node.type instanceof VarType;
        if (((VarType) node.type).dimension == 0) {
            //non array
            if (node.type.match(MxBaseType.BasicType.CLASS)) {
                ClassRegistry classRegistry = station.getClass(((VarType) node.type).className);
                node.value = classMalloc((IRStructType)classRegistry.value.type);
                new CallNode((IRFunction) classRegistry.scope.getFunc(((VarType) node.type).className).value,
                        cur.block, node.value);//construct
            } else throw new RuntimeException("UB");
        } else {

            ArrayList<Value> DimLengths = new ArrayList<>();
            for (ExprNode exprNode : node.DimLengthExprNodes) {
                exprNode.accept(this);
                DimLengths.add(exprNode.value);
            }
            if (DimLengths.size() == 0) node.value = new NullConst();
            else node.value = arrayMalloc(DimLengths, 0, ((IRPointerType)translator.translateAllocaType(node.type)).pointedType);
        }


    }

    /**
     * @param node
     */
    @Override
    public void visit(SuffixExprNode node) {
        //a++
        node.exprNode.accept(this);
        Value calculated = null, storePtr = node.exprNode.value.resolveFrom;
        switch (node.op) {
            case Mx.IncrementOp:
                calculated = new BinNode(LLVM.AddInst, IRTranslator.i32Type,  node.exprNode.value, new IntConst(1), cur.block);
                break;
            case Mx.DecrementOp:
                calculated = new BinNode(LLVM.SubInst, IRTranslator.i32Type, node.exprNode.value, new IntConst(1), cur.block);
                break;
            default: throw new InternalError("unknown postfix op");
        }
        memStore(storePtr, calculated);
        node.value = node.exprNode.value;
    }

    /**
     * @param node
     */
    @Override
    public void visit(PrefixExprNode node) {
        node.exprNode.accept(this);
        String _op = node.op;
        Value _val = node.exprNode.value;
        switch (_op) {
            case Mx.DecrementOp:
                node.value = new BinNode(Mx.AddOp, new IRIntType(32), _val, new IntConst(-1), cur.block);
                break;
            case Mx.IncrementOp:
                node.value = new BinNode(Mx.AddOp, new IRIntType(32), _val, new IntConst(+1), cur.block);
                break;
        }
        node.value.resolveFrom = node.exprNode.value.resolveFrom;
        memStore(node.value.resolveFrom, node.value);
    }

    /**
     * @param node
     */
    @Override
    public void visit(LambdaExprNode node) {
        //undefined behavior
    }

    /**
     * @param node
     */
    @Override
    public void visit(LocalLambdaExprNode node) {
        //nothing
    }


    //Into Bottom
    private Value memAlloca(String allocaName, IRBaseType allocaType) {
        return new AllocaNode(allocaName, allocaType, cur.function.entryBlock);
    }

    private Value memLoad(Value pointer, IRBlock parentBlock) {
        assert pointer.type instanceof IRPointerType;
        Value ret = new LoadNode(pointer, parentBlock);
        if (((IRPointerType) pointer.type).pointedType instanceof IRMemBoolType)
            ret = new TruncNode(ret, IRTranslator.boolType, parentBlock);
        ret.resolveFrom = pointer;
        return ret;
    }

    private void memStore(Value destPtr, Value assignData) {
        if (assignData.type instanceof IRBoolType) {
            assignData = new ZextNode(assignData, IRTranslator.memBoolType, cur.block);
        }
        assert destPtr.type instanceof IRPointerType;
        assert ((IRPointerType) destPtr.type).pointedType.match(assignData.type);
        new StoreNode(destPtr, assignData, cur.block);
    }

    private void createInitFunc() {
        FuncRegistry initRegistry = new FuncRegistry(LLVM.InitFuncName, MxBaseType.BasicType.VOID);
        initRegistry.isBasic = false;
        cur.function = new IRFunction(LLVM.InitFuncName,
                translator.translateFuncType(initRegistry.type, null),
                module);

        cur.block = cur.function.entryBlock;
        station.register(initRegistry);
        new RetNode(cur.function.exitBlock); // return void
        module.functions.add(cur.function);
        station.getFuncInStack(cur.function.name).value = cur.function;
    }

    private void funcDeclaration(FuncDefNode node) {
        FuncRegistry funcRegistry = node.funcRegistry;
        IRFunction fun = new IRFunction(funcRegistry.name, translator.translateFuncType(funcRegistry.type, null), module);
        module.functions.add(fun);
        funcRegistry.value = fun;
    }

    private void builtInFuncDeclaration(RootNode node) {
        module.setBottomFunctions();
        for (FuncRegistry funcRegistry : node.scope.builtinFuncList) {
            IRFunction fun = new IRFunction(funcRegistry.name, translator.translateFuncType(funcRegistry.type, null), module);
            module.builtinFunctions.add(fun);
            funcRegistry.value = fun;
        }
        for (FuncRegistry builtinFuncRegistry : StringBuiltInMethods.scope.builtinFuncList) {
            IRFunction builtinFunc = new IRFunction(LLVM.StrMethodPrefix + builtinFuncRegistry.name,
                    translator.translateFuncType(builtinFuncRegistry.type, IRTranslator.stringType),
                    module);

            module.builtinFunctions.add(builtinFunc);
            builtinFuncRegistry.value = builtinFunc;
        }
    }

    private void classDeclaration(RootNode node) {
        ArrayList<ClassRegistry> classes = new ArrayList<>();
        for (ASTNode sonNode : node.sonNodes) {
            if (sonNode instanceof ClassDefNode) {
                IRStructType structType = new IRStructType(((ClassDefNode) sonNode).classRegistry.name);
                ((ClassDefNode) sonNode).classRegistry.value = structType.structProto;
                module.classArray.add(structType.structProto);
                classes.add(((ClassDefNode) sonNode).classRegistry);
            }
        }
        for (ClassRegistry aClass : classes) {
            IRStructType structType = (IRStructType) aClass.value.type;
            for (VarRegistry memberVar : aClass.memberVars) {
                structType.memberVarTypes.add(translator.translateAllocaType(memberVar.type));
            }
            for (FuncRegistry memberFunc : aClass.memberFuncs) {
                IRFunction declareMemberFunc =
                        new IRFunction(memberFunc.name + LLVM.Splitter + memberFunc.name,
                                translator.translateFuncType(memberFunc.type, new IRPointerType(structType)),
                                module);
                module.functions.add(declareMemberFunc);
                memberFunc.value = declareMemberFunc;
            }
        }
    }

    private Value arrayMalloc(ArrayList<Value> eachDimLengths, int curDim, IRBaseType elementType) {
        // int[][][] a = new int [3][4][5];
        // curDim: from 0 to 2
        // elementType: now dim element. e.g. curDim = 0, elementType = i32**

        // step 1. malloc this dim.
        // size = (curDim+1) * elementTypeSize
        Value curDimSize = new BinNode(LLVM.MulInst, IRTranslator.i32Type,
                eachDimLengths.get(curDim), new IntConst(elementType.size()), cur.block);
        Value mallocSize = new BinNode(LLVM.AddInst, IRTranslator.i32Type, curDimSize, new IntConst(IRTranslator.i32Type.size()), cur.block);
        Value mallocPtr = new CallNode(module.getMalloc(), cur.block, mallocSize).noAlias();

        // step 2. store length at the before the array
        Value lengthDestPtr = new BitCastNode(mallocPtr, IRTranslator.i32PointerType, cur.block);
        memStore(lengthDestPtr, eachDimLengths.get(curDim));

        // step 3. get array head pointer and cast it to element type
        Value arrHeadPointer = new BitCastNode(
                new GetElementPtrNode(lengthDestPtr, IRTranslator.i32PointerType, cur.block, new IntConst(1)),
                new IRPointerType(elementType), cur.block);
        if (curDim < eachDimLengths.size() - 1) {
            // int* curDimPtr = 0; while (curDimPtr != tailDimPtr) {curDimPtr++;}
            IRBlock condBlock = new IRBlock(LLVM.WhCondBlockLabel, cur.function),
                    bodyBlock = new IRBlock(LLVM.WhBodyBlockLabel, cur.function),
                    exitBlock = new IRBlock(LLVM.WhExitBlockLabel, cur.function);

            PhiNode curDimPtr = new PhiNode(arrHeadPointer.type, null);
            curDimPtr.addBranch(arrHeadPointer, cur.block); // initial branch

            Value tailDimPtr = new GetElementPtrNode(arrHeadPointer, arrHeadPointer.type, cur.block, eachDimLengths.get(curDim));
            IRBaseNode incrPtr = new GetElementPtrNode(curDimPtr, curDimPtr.type, null, new IntConst(1));

            new BrNode(condBlock, cur.block);

            cur.block = condBlock;
            curDimPtr.setParentBlock(condBlock);
            Value condValue = new ICmpNode(LLVM.NotEqualArg, curDimPtr, tailDimPtr, cur.block);
            new BrNode(condValue, bodyBlock, exitBlock, cur.block);

            cur.block = bodyBlock;
            Value subMallocPtr = arrayMalloc(eachDimLengths, curDim + 1, ((IRPointerType) elementType).pointedType);
            memStore(curDimPtr, subMallocPtr);
            incrPtr.setParentBlock(cur.block);
            curDimPtr.addBranch(incrPtr, cur.block);
            new BrNode(condBlock, cur.block);

            cur.block = exitBlock;
        }
        return arrHeadPointer;
    }

    private Value classMalloc(IRStructType classType) {
        Value mallocPtr = new CallNode(module.getMalloc(), cur.block, new IntConst(classType.size())).noAlias();
        return new BitCastNode(mallocPtr, new IRPointerType(classType), cur.block);
    }

}
