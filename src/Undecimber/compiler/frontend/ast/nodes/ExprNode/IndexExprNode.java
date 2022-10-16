package undecimber.compiler.frontend.ast.nodes.ExprNode;

import undecimber.compiler.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;


public class IndexExprNode extends ExprNode {
    public ExprNode arrayExpNode;
    public ExprNode indexExpNode;

    public IndexExprNode(Positiion pos, ExpBaseNode arrayExpNode, ExpBaseNode indexExpNode) {
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