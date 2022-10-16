package undecimber.compiler.frontend.ast.nodes;

import Utility.position;
import Undecimber.compiler.frontend.info.registry.VarRegistry;
import Undecimber.compiler.frontend.ast.ASTVisitor;

public class VarDefSingleNode extends BaseNode {
    public VarRegistry varRegistry;
    public ExprNode initExpNode;

    public VarDefSingleNode(position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}