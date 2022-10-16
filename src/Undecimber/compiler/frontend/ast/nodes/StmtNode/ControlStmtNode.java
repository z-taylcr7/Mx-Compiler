package undecimber.compiler.frontend.ast.nodes.StmtNode;

import utility.Position;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.StmtNode;

public class ControlStmtNode extends StmtBaseNode {
    public String controlKey;

    public ControlStmtNode(Position pos, String controlKey) {
        super(pos);
        this.controlKey = controlKey;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}