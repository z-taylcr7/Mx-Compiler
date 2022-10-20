package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;

public class PrefixExprNode extends ExprNode{
    public String op;
    public ExprNode exprNode;

    public PrefixExprNode(Position pos,String op, ExprNode exprNode){
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