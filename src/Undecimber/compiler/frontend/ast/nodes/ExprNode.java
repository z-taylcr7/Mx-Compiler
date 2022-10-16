package undecimber.compiler.frontend.ast.nodes;

import Undecimber.Compiler.mir.Value;
import Util.Type;
import Util.position;

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
