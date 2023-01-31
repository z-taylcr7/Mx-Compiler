package undecimber.compiler.frontend.ast.nodes.stmtNode;


import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.BaseStmtNode;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import undecimber.compiler.frontend.scope.*;
import utility.Position;

public class IfStmtNode extends BaseStmtNode {
    public ExprNode condition;
    public BaseStmtNode thenStmt, elseStmt;
    public IfScope thenScope, elseScope;
    public IfStmtNode( Position pos,ExprNode condition, BaseStmtNode thenStmt) {
        super(pos);
        this.thenScope=new IfScope();
        this.elseScope=new IfScope();
        this.condition = condition;
        this.thenStmt = thenStmt;
        this.elseStmt = null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
