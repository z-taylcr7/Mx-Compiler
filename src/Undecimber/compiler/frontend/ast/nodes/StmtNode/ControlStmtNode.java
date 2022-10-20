package undecimber.compiler.frontend.ast.nodes.stmtNode;

import utility.Position;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.BaseStmtNode;

public class ControlStmtNode extends BaseStmtNode {
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