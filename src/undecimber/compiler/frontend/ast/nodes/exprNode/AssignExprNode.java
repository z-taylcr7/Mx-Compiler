package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;

public class AssignExprNode extends ExprNode{
    public ExprNode lhs, rhs;
    public boolean rubbish=false;

    public AssignExprNode(Position pos, ExprNode lhs, ExprNode rhs,boolean isRubbish ) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
        this.rubbish=isRubbish;
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
