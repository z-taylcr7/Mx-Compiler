package undecimber.compiler.frontend.semantic;

import  undecimber.compiler.frontend.ast.nodes.ASTNode;
import  undecimber.compiler.frontend.ast.*;
import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.nodes.exprNode.*;
import undecimber.compiler.frontend.ast.nodes.stmtNode.*;
import undecimber.compiler.frontend.ast.nodes.exprNode.AtomExprNode;
import  undecimber.compiler.frontend.scope.*;
import  undecimber.compiler.frontend.registry.*;
import  undecimber.compiler.frontend.semantic.StackStation;
import utility.Mx;
import  utility.Position;
import  utility.types.*;
import  utility.errors.*;
import utility.errors.semantic.*;
import utility.errors.syntax.*;


import  java.util.Objects;

public class SemanticChecker implements ASTVisitor{
    private final StackStation station=new StackStation();
    @Override
    public  void visit(RootNode root){
        station.push(root.scope);
        root.sonNodes.forEach(sonnode->sonnode.accept(this));
        station.pop();
    }
    @Override
    public void visit(ClassDefNode node){
        station.push(node.classRegistry);
        assert node.constructorDefNode!=null;
        visit(node.constructorDefNode);
        node.varDefs.forEach(def->def.accept(this));
        node.funcDefs.forEach(def->def.accept(this));
        station.pop();
    }
    @Override
    public void visit(FuncDefNode node){
        station.push(node.funcRegistry.scope);
        for (VarRegistry registry : node.funcRegistry.funcArgs) {
            if (registry.type.basicType == MxBaseType.BasicType.CLASS &&
                    station.getClass(registry.type.className) == null) {
                throw new NameError(node.pos, NameError.undefine, registry.type.className);
            }
            station.register(registry);
        }

        assert node.packNode != null;
        visit(node.packNode);

        if (node.funcRegistry.scope.catchedRetTypeList.isEmpty()) { //no return statement
            if (!node.isValidMainFunc() && !node.funcRegistry.type.retType.match(MxBaseType.BasicType.VOID)) {
                throw new FuncReturnError(node.pos, FuncReturnError.noReturn);
            }
        }
        else {
            // check every return statement
            for (VarType catchedRetType : node.funcRegistry.scope.catchedRetTypeList) {
                // retType != null
                assert node.funcRegistry.type.retType != null;
                if (!node.funcRegistry.type.retType.match(catchedRetType)) {
                    throw new FuncReturnError(node.pos, FuncReturnError.retTypeNotMatch);
                }
            }
        }
        station.pop();
    }
    @Override
    public void visit(AtomExprNode node){
        if (node.ctx.IntLiteral() != null) {
            node.type = new VarType(MxBaseType.BasicType.INT);
        }
        else if (node.ctx.StringLiteral() != null) {
            node.type = new VarType(MxBaseType.BasicType.STRING);
        }
        else if (node.ctx.True() != null || node.ctx.False() != null) {
            node.type = new VarType(MxBaseType.BasicType.BOOL);
        }
        else if (node.ctx.Null() != null) {
            node.type = new VarType(MxBaseType.BasicType.NULL);
        }
        else if (node.ctx.This() != null) {
            ClassRegistry nowClass = station.getCurClass();
            if (nowClass == null) {
                throw new ScopeError(node.pos, ScopeError.wrongThis);
            }
            node.type = new VarType(nowClass.name);
        }
        else if(node.ctx.ID()!=null){
            VarRegistry varRegistry=station.getVarInStack(node.ctx.ID().getText());
            FuncRegistry funcRegistry=station.getFuncInStack(node.ctx.ID().getText());
            if(varRegistry!=null){
                node.type=varRegistry.type.copy();
            } else if (funcRegistry!=null) {
                node.type= funcRegistry.type.copy();
            }else{
                throw new NameError(node.pos, NameError.undefine, node.ctx.ID().getText());
            }
        }
    }
    @Override
    public void visit(VarDefSingleNode node) {
        // from right to left, init first, register after
        if (node.initExpNode != null) node.initExpNode.accept(this);

        if (node.varRegistry.type.basicType == MxBaseType.BasicType.CLASS &&
                station.getClass(node.varRegistry.type.className) == null) {
            throw new NameError(node.pos, NameError.undefine, node.varRegistry.type.className);
        }

        if (node.initExpNode != null) TypeMatcher.match(node);

        station.register(node.varRegistry);
    }
    @Override
    public void visit(PackNode node){
        station.push(node.scope);
        node.stmtNodes.forEach(sonnode->sonnode.accept(this));
        station.pop();
    }
    @Override
    public void visit(PackStmtNode node){
        visit(node.packNode);
    }
    @Override
    public void visit(WhileStmtNode node){
        station.push(node.scope);
        node.conditionExprNode.accept(this);
        TypeMatcher.match(node);
        if(node.bodyStmtNode!=null)node.bodyStmtNode.accept(this);
        station.pop();
    }
    @Override
    public void visit(IfStmtNode node) {
        node.condition.accept(this);

        TypeMatcher.match(node);

        station.push(node.thenScope);
        node.thenStmt.accept(this);
        station.pop();

        if (node.elseStmt != null) {
            station.push(node.elseScope);
            node.elseStmt.accept(this);
            station.pop();
        }
    }
    @Override
    public void visit (ForStmtNode node){
        station.push(node.scope);
        if(node.initExprNode!=null)node.initExprNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode->sonnode.accept(this));
        if(node.conditionExprNode!=null){
            node.conditionExprNode.accept(this);
            TypeMatcher.match(node);
        }
        if(node.incrExprNode!=null)node.incrExprNode.accept(this);
        assert node.bodyStmtNode!=null;
        node.bodyStmtNode.accept(this);
        station.pop();
    }
    @Override
    public void visit (ReturnStmtNode node){
        if(!station.isInFunc())throw new ScopeError(node.pos,ScopeError.wrongReturn);
        if(node.value!=null){
            node.value.accept(this);
            station.stackReturn((VarType)node.value.type);
        }else {
            station.stackReturn(new VarType(MxBaseType.BasicType.VOID));
        }
    }
    public void visit (ControlStmtNode node){
        if(!station.isInLoop())throw new ScopeError(node.pos,
                Objects.equals(node.controlKey, Mx.breakStr)?
                        ScopeError.wrongBreak:ScopeError.wrongContinue);

    }

    @Override
    public void visit(PureStmtNode node) {
        if(node.pure!=null)node.pure.accept(this);
    }

    @Override
    public void visit(AssignExprNode node){
        assert node.lhs!=null;
        assert node.rhs!=null;
        node.rhs.accept(this);
        node.lhs.accept(this);
        TypeMatcher.match(node);
        node.type=node.rhs.type.copy();

    }

    @Override
    public void visit(BinaryExprNode node) {
        assert node.lhsExprNode!=null;
        assert node.rhsExprNode!=null;
        node.rhsExprNode.accept(this);
        node.lhsExprNode.accept(this);
        TypeMatcher.match(node);
        if(Objects.equals(node.opType,Mx.compareOpType)||
        Objects.equals(node.opType,Mx.equalOpType)){
            node.type=new VarType(MxBaseType.BasicType.BOOL);
        }else node.type=node.rhsExprNode.type.copy();
    }

    @Override
    public void visit(FuncCallExprNode node) {
        node.callExprNode.accept(this);
        node.callArgExpNodes.forEach(son->son.accept(this));

        if (!(node.callExprNode.type instanceof MxFuncType)) {
            /*
            if(!(node.callExprNode instanceof  AtomExprNode)){
                throw new FuncCallError(node.pos,FuncCallError.expNotAFunc);
            }
             if(((AtomExprNode) node.callExprNode).ctx.ID()==null)
             throw new FuncCallError(node.pos,FuncCallError.expNotAFunc);
            FuncRegistry funcRegistry=station.getFuncInStack(((AtomExprNode)node.callExprNode).ctx.ID().getText());
            if(funcRegistry!=null){
                node.callExprNode.type=funcRegistry.type.copy();
            }
            else{
                throw new FuncCallError(node.pos,FuncCallError.expNotAFunc);
            }
            */
        }
        int result = ((MxFuncType) node.callExprNode.type).funcCallMatch(node.callArgExpNodes);

        if (result == -1) {
            throw new FuncCallError(node.pos, FuncCallError.argsNotMatch);
        } else if (result == -2) {
            throw new FuncCallError(node.pos, FuncCallError.argTypeNotMatch);
        }

        node.type = ((MxFuncType) node.callExprNode.type).retType.copy();
    }

    @Override
    public void visit(NewExprNode node) {
        node.DimLengthExprNodes.forEach(sonnode -> sonnode.accept(this));

        TypeMatcher.match(node);
    }

    @Override
    public void visit(UnaryExprNode node) {
        assert node.selfExprNode != null;
        node.selfExprNode.accept(this);

        TypeMatcher.match(node);

        node.type = node.selfExprNode.type.copy();
    }

    @Override
    public void visit(VarDefStmtNode node) {
        node.varDefSingleNodes.forEach(sonnode -> {sonnode.accept(this);});
    }

    @Override
    public void visit(PrefixExprNode node) {
        assert node.exprNode != null;
        node.exprNode.accept(this);

        TypeMatcher.match(node);

        node.type = node.exprNode.type.copy();
    }

    @Override
    public void visit(SuffixExprNode node) {
        assert node.exprNode!= null;
        node.exprNode.accept(this);

        TypeMatcher.match(node);

        node.type = node.exprNode.type.copy();
    }
    @Override
    public void visit(IndexExprNode node) {

        if (node.arrayExprNode != null) node.arrayExprNode.accept(this);
        if (node.indexExprNode != null) node.indexExprNode.accept(this);
        assert node.arrayExprNode != null;

        TypeMatcher.match(node);

        node.type = node.arrayExprNode.type.copy();
        ((VarType) node.type).dimension--;
    }

    @Override
    public void visit(LambdaExprNode node) {
        station.push(node.funcRegistry.scope);

        for (VarRegistry funcArg : node.funcRegistry.funcArgs) {
            if(funcArg.type.basicType==MxBaseType.BasicType.CLASS&&
            station.getClass(funcArg.type.className)==null)
                throw new NameError(node.pos,NameError.undefine,funcArg.type.className);
            station.register(funcArg);
        }

        assert node.packNode!=null;
        visit(node.packNode);

        node.callArgExprNodes.forEach(sonnode->sonnode.accept(this));
        int res=node.funcRegistry.type.funcCallMatch(node.callArgExprNodes);
        if(res==-1)throw new FuncCallError(node.pos,FuncCallError.argsNotMatch);
        else if (res==-2) {
            throw new FuncCallError(node.pos,FuncCallError.argTypeNotMatch);
        }

        if(node.funcRegistry.scope.catchedRetTypeList.isEmpty())node.type=new VarType(MxBaseType.BasicType.VOID);
        else{
            for (VarType varType : node.funcRegistry.scope.catchedRetTypeList) {
                if(node.type==null){
                    node.type=varType;
                    node.funcRegistry.type.retType=varType;
                } else if (!node.type.match(varType)) {
                    throw new FuncReturnError(node.pos,FuncReturnError.retTypeNotMatch);
                }
            }
        }
        station.pop();

    }

    @Override
    public void visit(MemberExprNode node) {
        if(node.supExprNode!=null)node.supExprNode.accept(this);
        assert node.supExprNode!=null;
        //check builtinMethods
        if(node.supExprNode.type.match(MxBaseType.BasicType.STRING)){
            if(StringBuiltInMethods.scope.funcTable.containsKey(node.name))
               node.type=StringBuiltInMethods.scope.getFunc(node.name).type.copy();
            return;
        }
        if(node.supExprNode.type.isArray()&&ArrayBuiltInMethods.scope.funcTable.containsKey(node.name)){
            node.type=ArrayBuiltInMethods.scope.getFunc(node.name).type.copy();
            return;
        }
        TypeMatcher.match(node);

        String className = ((VarType) node.supExprNode.type).className;
        ClassRegistry classRegistry = station.getClass(className);
        if (classRegistry == null) throw new NameError(node.pos, NameError.undefine, className);
        if (classRegistry.scope.funcTable.containsKey(node.name))
            node.type = classRegistry.scope.getFunc(node.name).type.copy();
        else if (classRegistry.scope.varTable.containsKey(node.name))
            node.type = classRegistry.scope.getVar(node.name).type.copy();
        else throw new NameError(node.pos, NameError.undefine, node.name);
    }

}
