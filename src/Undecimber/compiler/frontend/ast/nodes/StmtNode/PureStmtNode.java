package undecimber.compiler.frontend.ast.nodes.stmtNode;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.BaseStmtNode;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;

public class PureStmtNode extends BaseStmtNode {
    public ExprNode pure;

    public PureStmtNode(Position pos) {
        super(pos);this.pure=null;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
