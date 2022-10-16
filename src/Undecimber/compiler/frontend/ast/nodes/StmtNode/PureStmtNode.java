package undecimber.compiler.frontend.ast.nodes.StmtNode;
import utility.Position;

public class PureStmtNode extends StmtNode{
    public PureNode pure;

    public PureStmtNode(PureNode Pure, position pos) {
        super(pos);
        this.pure = pure;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
