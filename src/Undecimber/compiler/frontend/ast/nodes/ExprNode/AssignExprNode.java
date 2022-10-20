package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;

public class AssignExprNode extends ExprNode{
    public ExprNode lhs, rhs;

    public AssignExprNode(Position pos, ExprNode lhs, ExprNode rhs ) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public boolean isLeftValue() {
        return true;
    }
}
