package undecimber.compiler.frontend.ast.nodes.ExprNode;

import undecimber.compiler.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;

public class UnaryExprNode extends ExprNode {
    public ExprNode selfExprNode;
    public String op;

    public UnaryExpNode(Position pos, ExprNode selfExprNode) {
        super(pos);
        this.selfExprNode = selfExprNode;
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