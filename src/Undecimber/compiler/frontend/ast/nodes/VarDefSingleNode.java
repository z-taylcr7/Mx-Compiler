package undecimber.compiler.frontend.ast.nodes;

import utility.Position;
import undecimber.compiler.frontend.registry.VarRegistry;
import undecimber.compiler.frontend.ast.ASTVisitor;

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