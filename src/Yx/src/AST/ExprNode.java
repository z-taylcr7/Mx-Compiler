package AST;

import MIR.entity;
import utility.Type;
import utility.position;

public abstract class ExprNode extends ASTNode {
    public Type type;
    public entity val;

    public ExprNode(position pos) {
        super(pos);
    }

    public boolean isAssignable() {
        return True;
    }
}
