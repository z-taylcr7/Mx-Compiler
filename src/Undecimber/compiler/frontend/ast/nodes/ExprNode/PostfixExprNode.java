package undecimber.compiler.frontend.ast.nodes.ExprNode;

import undecimber.compiler.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;

public class PostfixExprNode extends ExprNode{
    public String op;
    public ExprNode exprNode;

    public PostfixExprNode(Position pos,String op, ExprNode exprNode){
        super(pos);
        this.exprNode=exprNode;

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