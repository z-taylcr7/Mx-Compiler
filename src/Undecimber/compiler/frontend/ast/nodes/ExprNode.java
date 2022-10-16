package undecimber.compiler.frontend.ast.nodes;

import undecimber.compiler.middleend.mir.value;
import utility.Type;
import utility.Position;

public abstract class ExprNode extends ASTNode {
    public Type type;
    public Value val;

    public ExprNode(position pos) {
        super(pos);
    }

    public boolean isAssignable() {
        return true;
    }
}
