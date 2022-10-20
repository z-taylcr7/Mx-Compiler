package undecimber.compiler.frontend.ast.nodes.stmtNode;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.BaseStmtNode;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;

public class ReturnStmtNode extends BaseStmtNode {
    public ExprNode value;

    public ReturnStmtNode(Position pos) {
        super(pos);
        value=null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
