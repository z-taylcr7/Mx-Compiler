package undecimber.compiler.frontend.ast.nodes;

import utility.types.*;
import utility.Position;

public abstract class ExprNode extends ASTNode {
    public MxBaseType type;

    public ExprNode(Position pos) {
        super(pos);
    }

    public boolean isLeftValue() {
        return true;
    }
}
