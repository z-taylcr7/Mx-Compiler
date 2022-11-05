package undecimber.compiler.frontend.ast;

import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.nodes.exprNode.*;
import undecimber.compiler.frontend.ast.nodes.stmtNode.*;
public interface ASTVisitor {
    void  visit(RootNode node);
    void visit(ClassDefNode node);

    void visit(VarDefStmtNode node);
    void visit(ReturnStmtNode node);
    void visit(PackStmtNode node);
    void visit(PureStmtNode node);
    void visit(IfStmtNode node);

    void visit(AssignExprNode node);
    void visit(BinaryExprNode node);
    void visit(AtomExprNode node);

    void visit(VarDefSingleNode node);

    void visit(FuncDefNode node);

    void visit(PackNode node);

    void visit(ControlStmtNode node);

    void visit(ForStmtNode node);

    void visit(FuncCallExprNode node);

    void visit(IndexExprNode node);

    void visit(LambdaExprNode node);
    void visit(LocalLambdaExprNode node);

    void visit(MemberExprNode node);

    void visit(NewExprNode node);

    void visit(SuffixExprNode node);

    void visit(PrefixExprNode node);

    void visit(UnaryExprNode node);

    void visit(WhileStmtNode node);
}
