package undecimber.compiler.frontend.ast.nodes;

import undecimber.compiler.middleend.llvmir.Value;
import utility.types.*;
import utility.Position;

public abstract class ExprNode extends ASTNode {
    public MxBaseType type;

    public ExprNode(Position pos) {
        super(pos);
        this.type=null;
    }

    public boolean isLeftValue() {
        return true;
    }
}
