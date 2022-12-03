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
    IRTranslator translator=new IRTranslator();
    StackStation station=new StackStation();
    CurrentInfo cur=new CurrentInfo();
    IRModule module=new IRModule();

public IRBuilder(RootNode node){
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
            if(sonNode instanceof FuncDefNode)funcDeclaration((FuncDefNode) sonNode); }
        for (ASTNode sonNode : node.sonNodes) {
            if(sonNode instanceof VarDefStmtNode)sonNode.accept(this);
        }
        cur.TerminateAll();
        for (ASTNode sonNode : node.sonNodes) {
            if(!(sonNode instanceof VarDefStmtNode))sonNode.accept(this);
        }
    }

    /**
     * @param node
     */
    @Override
    public void visit(ClassDefNode node) {
        ClassScope tmpScope=node.classRegistry.scope;
        station.push(tmpScope);
          for (VarDefStmtNode varDefStmtNode : node.varDefs) {
            varDefStmtNode.accept(this);
        }
          if(node.constructorDefNode!=null) this.visit(node.constructorDefNode);

        for (FuncDefNode funcDefNode : node.funcDefs) {
            funcDefNode.accept(this);
        }
        cur.classRegistry=null;
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
    public void visit(ReturnStmtNode node) {
        if(node.value!=null&&!node.value.type.match( MxBaseType.BasicType.VOID)){
            node.value.accept(this);

        }
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
        IRBlock thenBlock=new IRBlock(LLVM.IfTrueBlockLabel,cur.function);
        IRBlock elseBlock=new IRBlock(LLVM.IfFalseBlockLabel,cur.function);
        IRBlock exitBlock=new IRBlock(LLVM.IfExitBlockLabel,cur.function);
        node.condition.accept(this);
        new BrNode(node.condition.value,thenBlock,elseBlock,cur.block);
        if(node.elseStmt!=null){
            station.push(node.elseScope);
            node.elseStmt.accept(this);
            station.pop();
        }
        new BrNode(exitBlock,elseBlock);
        station.push(node.thenScope);node.thenStmt.accept(this);new BrNode(exitBlock,thenBlock);
        station.pop();

        cur.block=exitBlock;


    }

    /**
     * @param node
     */
    @Override
    public void visit(AssignExprNode node) {
        node.lhs.accept(this);
        node.rhs.accept(this);
        memStore(node.lhs.value.resolveFrom,node.rhs.value);//l <= r
        node.value=node.rhs.value;
        node.value.resolveFrom=node.lhs.value.resolveFrom;

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
            }
            else {
                allocaPtr = new GlobalVariable(node.varRegistry.name,
                        translator.translateAllocaType(node.varRegistry.type));
            }
        }else{
            allocaPtr= memAlloca(node.varRegistry.name,translator.translateVarType(node.varRegistry.type));
        }
        //normal int,bool,etc
        if (node.initExpNode != null) {
            //have init values
            node.initExpNode.accept(this);
            Value _value= node.initExpNode.value;
            memStore(allocaPtr,_value);

            if (allocaPtr instanceof GlobalVariable && (node.initExpNode.value instanceof IntConst || node.initExpNode.value instanceof BoolConst))
                ((GlobalVariable) allocaPtr).val = node.initExpNode.value;
        }
        else if (node.varRegistry.type.match(MxBaseType.BasicType.CLASS) || node.varRegistry.type.isArray()) {
            // array and class should init nullptr, string doesn't need init values
            memStore(allocaPtr, new NullConst());
        }
        else {
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
    public void visit(FuncDefNode node) {
        station.push(node.funcRegistry.scope);
        cur.function= (IRFunction) node.funcRegistry.value;
        cur.block=cur.function.entryBlock;
        if(!node.funcRegistry.type.retType.match(MxBaseType.BasicType.VOID)){
            cur.function.returnAddress = memAlloca(LLVM.RetReg, translator.translateAllocaType(node.funcRegistry.type.retType));
            new RetNode(memLoad(cur.function.returnAddress, cur.function.exitBlock), cur.function.exitBlock);
        } else {
            new RetNode(cur.function.exitBlock);
        }
        if (Objects.equals(node.funcRegistry.name, Mx.mainStr)) {
            // call init func
            new CallNode((IRFunction)station.getFuncInStack(LLVM.InitFuncName).value, cur.block, new ArrayList<>());
            memStore(cur.function.returnAddress, new IntConst(0));
        }

        for (int i = 0; i < cur.function.getArgNum(); i++) {
           VarRegistry varRegistry;
           if(cur.classRegistry==null)varRegistry=node.funcRegistry.funcArgs.get(1);
           else  {
               if(i==0){
                   cur.function.addArg(new Value(LLVM.ThisArg,new IRPointerType(cur.classRegistry.value.type)));
                   continue;
               }else {
                   varRegistry=node.funcRegistry.funcArgs.get(i-1);
               }
           }
            Value data = new Value (varRegistry.name, translator.translateVarType(varRegistry.type));
               Value ptr=memAlloca(varRegistry.name, translator.translateAllocaType(varRegistry.type));
               varRegistry.value=ptr;
               cur.function.addArg(data);
               memStore(ptr,data);

        }
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
        IRBlock incrBlock=new IRBlock(LLVM.ForIncrBlockLabel,cur.function);
        IRBlock condBlock=new IRBlock(LLVM.ForCondBlockLabel,cur.function);
        IRBlock bodyBlock=new IRBlock(LLVM.ForBodyBlockLabel,cur.function);
        IRBlock exitBlock=new IRBlock(LLVM.ForExitBlockLabel,cur.function);
        station.push(node.scope);
        if(node.initExprNode!=null){
            node.initExprNode.accept(this);
            for (VarDefSingleNode varDefSingleNode : node.initVarDefSingleNodes) {
                varDefSingleNode.accept(this);
            }
        }
        cur.block=condBlock;

        new BrNode(bodyBlock,cur.block);
        node.conditionExprNode.accept(this);
        new BrNode(node.conditionExprNode.value,bodyBlock,exitBlock,cur.block);

        cur.block=incrBlock;
        if(node.incrExprNode!=null)node.incrExprNode.accept(this);
        new BrNode(condBlock,cur.block);

        cur.block=bodyBlock;
        cur.addControlTarget(bodyBlock,exitBlock);
        node.bodyStmtNode.accept(this);
        new BrNode(incrBlock,cur.block);
        cur.deleteControlTarget();

        cur.block=exitBlock;

        station.pop();

    }


    /**
     * @param node
     */
    @Override
    public void visit(WhileStmtNode node) {
        IRBlock condBlock = new IRBlock(LLVM.WhCondBlockLabel,cur.function);
        IRBlock bodyBlock = new IRBlock(LLVM.WhBodyBlockLabel,cur.function);
        IRBlock exitBlock = new IRBlock(LLVM.WhExitBlockLabel,cur.function);
        new BrNode(condBlock,cur.block);

        cur.block=condBlock;
        station.push(node.scope);
        node.conditionExprNode.accept(this);Value condRes=node.conditionExprNode.value;
        new BrNode(condRes,bodyBlock,exitBlock,cur.block);
        cur.addControlTarget(bodyBlock,exitBlock);

        cur.block=bodyBlock;
        node.bodyStmtNode.accept(this);
        new BrNode(condBlock,cur.block);
        cur.block=exitBlock;
        cur.deleteControlTarget();

        station.pop();


    }

    /**
     * @param node
     */
    @Override
    public void visit(IndexExprNode node) {
        node.arrayExprNode.accept(this);
        node.indexExprNode.accept(this);
        node.value=memLoad(
                new GetElementPtrNode(
                    node.arrayExprNode.value.name+LLVM.ArrayElementSuffix,
                    node.arrayExprNode.value,
                    node.value.type,
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
            case Mx.AddOp:
                node.value = node.selfExprNode.value;break;
            case Mx.SubOp:
                node.value = new BinNode(LLVM.SubInst, IRTranslator.i32Type ,new IntConst(0), node.selfExprNode.value, cur.block);break;
            case Mx.BitNotOp:
                node.value = new BinNode(LLVM.XorInst, IRTranslator.i32Type, node.selfExprNode.value, new IntConst(-1), cur.block);break;
            case Mx.LogicNotOp:
                node.value = new BinNode(LLVM.XorInst, IRTranslator.boolType, node.selfExprNode.value, new BoolConst(true), cur.block);break;
            default: throw new InternalError("what's the fucking unary op you typed~");
        }
    }

    /**
     * @param node
     */
    @Override
    public void visit(BinaryExprNode node) {
        node.lhsExprNode.accept(this);
        node.rhsExprNode.accept(this);
        String _op=node.op;
        switch (_op){
            //shortcutNotYet
            //compare ops(bool)
            case Mx.EqualOp:case Mx.GreaterOp:case Mx.GreaterEqualOp:case Mx.LessEqualOp:case Mx.LessOp: case Mx.NotEqualOp:

                node.value=new ICmpNode(IRTranslator.translateOp(_op),node.lhsExprNode.value,node.rhsExprNode.value,cur.block);break;
            //int ops
            default: node.value=new BinNode(IRTranslator.translateOp(_op),IRTranslator.i32Type,node.lhsExprNode.value,node.rhsExprNode.value,cur.block);
        }
    }

    /**
     * @param node
     */
    @Override
    public void visit(AtomExprNode node) {
        //constants
        if(node.ctx.IntLiteral()!=null)node.value=new IntConst(Integer.parseInt(node.ctx.IntLiteral().toString()));
        else if (node.ctx.True()!=null) {node.value=new BoolConst(true);}
        else if (node.ctx.False()!=null) node.value=new BoolConst(false);
        else if (node.ctx.Null()!=null) {node.value=new NullConst();}
        else if(node.ctx.This()!=null)node.value=cur.getThis();
        else if(node.ctx.StringLiteral()!=null)node.value=new StringConst(node.ctx.StringLiteral().toString());
        else if(node.ctx.ID()!=null){
            if(node.type instanceof MxFuncType){
                node.value=station.getFuncInStack(node.ctx.ID().getText()).value;
            }else if(node.type instanceof VarType){

                Value val_addr;
                Pair<VarRegistry,Boolean> res=station.getVarInStack_IR(node.ctx.getText().toString());
                VarRegistry var=res.a;
                int index=-1;
                if (cur.classRegistry != null && res.b)
                    index = cur.classRegistry.getMemberVarIndex(var.name);
                Value varAddr=index>=0?
                        new GetElementPtrNode(var.name, cur.getThis(),
                            new IRPointerType(translator.translateAllocaType(var.type)),
                            cur.block, new IntConst(0), new IntConst(index))
                        :var.value;

            // variable resolve
            node.value = memLoad(varAddr, cur.block);
            }
        }


    }

    /**
     * @param node
     */
    @Override
    public void visit(FuncCallExprNode node) {
        node.callExprNode.accept(this);
        if(node.callExprNode.value instanceof IRFunction){
            ArrayList<Value>argV=new ArrayList<>();
            //this.function
            if((((IRFuncType)node.callExprNode.value.type).memberOf!=null)){
                if(node.callExprNode instanceof MemberExprNode)argV.add(((MemberExprNode)node.callExprNode).supExprNode.value);
            }else {
                //call in class(other function)
                assert cur.classRegistry!=null;
                argV.add(cur.getThis());
            }
            for (ExprNode callArgExpNode : node.callArgExpNodes) {
                callArgExpNode.accept(this);
                argV.add(callArgExpNode.value);
            }
            node.value=new CallNode((IRFunction) node.callExprNode.value,cur.block,argV);
        }else node.value=node.callExprNode.value;
    }

    /**
     * @param node
     */
    @Override
    public void visit(MemberExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(NewExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(SuffixExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(PrefixExprNode node) {
        node.exprNode.accept(this);
        String _op=node.op;
        Value _val=node.exprNode.value;
        switch (_op){
            case Mx.DecrementOp :node.value= new BinNode(Mx.AddOp,new IRIntType(32) , _val,new IntConst(-1),cur.block);break;
            case Mx.IncrementOp :node.value= new BinNode(Mx.AddOp,new IRIntType(32), _val,new IntConst(+1),cur.block);break;
        }
        node.value.resolveFrom=node.exprNode.value.resolveFrom;
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
    private void funcDeclaration(FuncDefNode node){
        FuncRegistry funcRegistry=node.funcRegistry;
        IRFunction fun=new IRFunction(funcRegistry.name,translator.translateFuncType(funcRegistry.type, null), module);
        module.functions.add(fun);
        funcRegistry.value=fun;
    }
    private void builtInFuncDeclaration(RootNode node){
        module.setBottomFunctions();
        for (FuncRegistry funcRegistry : node.scope.builtinFuncList) {
            IRFunction fun=new IRFunction(funcRegistry.name,translator.translateFuncType(funcRegistry.type, null), module);
            module.builtinFunctions.add(fun);
            funcRegistry.value=fun;
        }
        for (FuncRegistry builtinFuncRegistry : StringBuiltInMethods.scope.builtinFuncList) {
            IRFunction builtinFunc = new IRFunction(LLVM.StrMethodPrefix + builtinFuncRegistry.name,
                    translator.translateFuncType(builtinFuncRegistry.type, IRTranslator.stringType),
                    module);

            module.builtinFunctions.add(builtinFunc);
            builtinFuncRegistry.value = builtinFunc;
        }
    }
    private void classDeclaration(RootNode node){
        ArrayList <ClassRegistry> classes=new ArrayList<>();
        for (ASTNode sonNode : node.sonNodes) {
            if(sonNode instanceof ClassDefNode){
                IRStructType structType=new IRStructType(((ClassDefNode) sonNode).classRegistry.name);
                ((ClassDefNode) sonNode).classRegistry.value=structType.structProto;
                module.classArray.add(structType.structProto);
                classes.add(((ClassDefNode) sonNode).classRegistry);
            }
        }
        for (ClassRegistry aClass : classes) {
            IRStructType structType=(IRStructType)aClass.value.type;
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

}
