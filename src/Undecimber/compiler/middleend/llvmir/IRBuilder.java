package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.nodes.exprNode.*;
import undecimber.compiler.frontend.ast.nodes.stmtNode.*;
import undecimber.compiler.frontend.scope.ClassScope;
import undecimber.compiler.frontend.semantic.StackStation;
import undecimber.compiler.middleend.llvmir.irconst.GlobalVariable;
import utility.LLVM;

import java.util.Objects;

public class IRBuilder implements ASTVisitor {
    IRTranslator translator;
    StackStation station;
    CurrentInfo cur;


    /**
     * @param node
     */
    @Override
    public void visit(RootNode node) {
        this.visit(node);
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
        station.pop();
    }

    /**
     * @param node
     */
    @Override
    public void visit(VarDefStmtNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(ReturnStmtNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(PackStmtNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(PureStmtNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(IfStmtNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(AssignExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(BinaryExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(AtomExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(VarDefSingleNode node) {
        Value allocaPtr;

        // global variable
        if (Objects.equals(cur.function.name, LLVM.InitFuncName)) {
            if (cur.classRegistry != null) {
                allocaPtr = new GlobalVariable(cur.classRegistry.name + LLVM.Splitter + node.varRegistry.name,
                        translator.translateAllocaType(node.varRegistry.type));
            }
            else {
                allocaPtr = new GlobalVariable(node.varRegistry.name,
                        translator.translateAllocaType(node.varRegistry.type));
            }
        }
    }

    /**
     * @param node
     */
    @Override
    public void visit(FuncDefNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(PackNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(ControlStmtNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(ForStmtNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(FuncCallExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(IndexExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(LambdaExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(LocalLambdaExprNode node) {

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

    }

    /**
     * @param node
     */
    @Override
    public void visit(UnaryExprNode node) {

    }

    /**
     * @param node
     */
    @Override
    public void visit(WhileStmtNode node) {

    }
}
