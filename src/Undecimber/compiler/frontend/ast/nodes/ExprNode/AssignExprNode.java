package undecimber.compiler.frontend.ast.nodes.ExprNode;

import undecimber.compiler.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;

public class assignExprNode extends ExprNode{
    public ExprNode lhs, rhs;

    public assignExprNode(Position pos,ExprNode lhs, ExprNode rhs ) {
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
