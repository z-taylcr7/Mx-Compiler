package undecimber.compiler.frontend.ast.nodes.ExprNode;

import undecimber.compiler.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;

public class BinaryExprNode extends ExprNode {
    public ExprNode lhsExprNode, rhsExprNode;
    public String op;
    public String opType;

    public BinaryExpNode(Position pos, ExprNode lhsExprNode, ExprNode rhsExprNode) {
        super(pos);
        this.lhsExprNode = lhsExprNode;
        this.rhsExprNode = rhsExprNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return false;
    }
}