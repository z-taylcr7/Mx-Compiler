package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;


public class IndexExprNode extends ExprNode {
    public ExprNode arrayExprNode;
    public ExprNode indexExprNode;

    public IndexExprNode(Position pos, ExprNode arrayExpNode, ExprNode indexExpNode) {
        super(pos);
        this.arrayExprNode = arrayExpNode;
        this.indexExprNode = indexExpNode;
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