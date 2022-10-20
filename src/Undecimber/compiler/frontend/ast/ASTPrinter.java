package undecimber.compiler.frontend.ast;
import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.nodes.exprNode.*;
import undecimber.compiler.frontend.ast.nodes.stmtNode.*;


import java.io.PrintStream;

public class ASTPrinter implements ASTVisitor {

    private static final String INDENT = "..";

    private int nowIndentNum = 0;
    private PrintStream ps;

    public ASTPrinter(PrintStream ps) {
        this.ps = ps;
    }

    @Override
    public void visit(RootNode node) {
        nowIndentNum++;
        //Log.info("AST Printer Start Sucess");
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- RootNode --- *\n");
        ps.println(node.scope);
        node.sonNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(ClassDefNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ClassDefNode --- *\n");
        ps.println(node.classRegistry);
        if (node.constructorDefNode != null) visit(node.constructorDefNode);
        node.varDefs.forEach(sonnode -> sonnode.accept(this));
        node.funcDefs.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(FuncDefNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- FuncDefNode --- *\n");
        ps.println(node.funcRegistry);
        if (node.packNode != null) visit(node.packNode);
        nowIndentNum--;
    }

    @Override
    public void visit(VarDefSingleNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- VarDefSingleNode --- *\n");
        ps.println(node.varRegistry);
        if (node.initExpNode != null) node.initExpNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(VarDefStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- VarDefStmtNode --- *\n");
        node.varDefSingleNodes.forEach(sonnode -> {sonnode.accept(this);});
        nowIndentNum--;
    }

    @Override
    public void visit(PackNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- packNode --- *\n");
        ps.println(node.scope);
        node.stmtNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(PackStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- SuiteStmtNode --- *\n");
        visit(node.packNode);
        nowIndentNum--;
    }

    @Override
    public void visit(IfStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- IfStmtNode --- *\n");
        ps.println("condi: ");
        node.condition.accept(this);
        ps.println("if true: ");
        node.thenStmt.accept(this);
        ps.println("else: ");
        if (node.elseStmt != null) node.elseStmt.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(WhileStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- WhileStmtNode --- *\n");
        ps.println("condi: ");
        if (node.conditionExprNode != null) node.conditionExprNode.accept(this);
        ps.println("body: ");
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ForStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ForStmtNode --- *\n");
        ps.println("init: ");
        if (node.initExprNode != null) node.initExprNode.accept(this);
        node.initVarDefSingleNodes.forEach(sonnode -> sonnode.accept(this));
        ps.println("condi: ");
        if (node.conditionExprNode != null) node.conditionExprNode.accept(this);
        ps.println("incr: ");
        if (node.incrExprNode != null) node.incrExprNode.accept(this);
        ps.println("body: ");
        if (node.bodyStmtNode != null) node.bodyStmtNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ReturnStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ReturnStmtNode --- *\n");
        if (node.value!= null) node.value.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(ControlStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- ControlStmtNode --- *\n");
        ps.println(node.controlKey);
        nowIndentNum--;
    }

    @Override
    public void visit(PureStmtNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PureStmtNode --- *\n");
        if (node.pure != null) node.pure.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(AssignExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- AssignExprNode --- *\n");
        ps.println("type: " + node.type);
        if (node.lhs != null) node.lhs .accept(this);
        if (node.rhs != null) node.rhs .accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(BinaryExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- BinaryExprNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("op: " + node.op);
        if (node.lhsExprNode != null) node.lhsExprNode.accept(this);
        if (node.rhsExprNode != null) node.rhsExprNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(FuncCallExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- FuncCallExprNode --- *\n");
        ps.println("type: " + node.type);
        node.accept(this);
        node.callArgExpNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(IndexExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- IndexExprNode --- *\n");
        ps.println("type: " + node.type);
        if (node.arrayExprNode != null) node.arrayExprNode.accept(this);
        if (node.indexExprNode != null) node.indexExprNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(MemberExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- MemberExprNode --- *\n");
        ps.println("type: " + node.type);
        if (node.supExprNode != null) node.supExprNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(NewExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- NewExprNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("NewType: " + node.type);
        // new exp type is determined in ASTBuilder
        nowIndentNum--;
    }

    @Override
    public void visit(SuffixExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PostfixExprNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("op: " + node.op);
        if (node.exprNode!= null) node.exprNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(PrefixExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- PrefixExprNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("op: " + node.op);
        if (node.exprNode != null) node.exprNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(UnaryExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- UnaryExprNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("op: " + node.op);
        if (node.selfExprNode != null) node.selfExprNode.accept(this);
        nowIndentNum--;
    }

    @Override
    public void visit(LambdaExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- LambdaExprNode --- *\n");
        ps.println(node.funcRegistry);
        node.packNode.accept(this);
        ps.println("type: " + node.type);
        node.callArgExprNodes.forEach(sonnode -> sonnode.accept(this));
        nowIndentNum--;
    }

    @Override
    public void visit(AtomExprNode node) {
        nowIndentNum++;
        ps.println("\n" + INDENT.repeat(nowIndentNum) +  "* --- AtomExprNode --- *\n");
        ps.println("type: " + node.type);
        ps.println("text: " + node.ctx.getText());
        nowIndentNum--;
    }
}