package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;

public class UnaryExprNode extends ExprNode {
    public ExprNode selfExprNode;
    public String op;

    public UnaryExprNode(Position pos, String Op,ExprNode selfExprNode) {
        super(pos);
        this.op=Op;
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