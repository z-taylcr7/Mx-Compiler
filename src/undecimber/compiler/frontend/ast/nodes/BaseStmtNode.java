package undecimber.compiler.frontend.ast.nodes;

import utility.Position;

public abstract class BaseStmtNode extends ASTNode {
    public BaseStmtNode(Position pos) {
        super(pos);
    }
}
