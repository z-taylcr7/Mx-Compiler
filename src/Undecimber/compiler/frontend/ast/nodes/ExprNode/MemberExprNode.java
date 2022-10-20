package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;
import utility.types.MxBaseType;

public class MemberExprNode extends ExprNode{
    public ExprNode supExprNode;
    public String name;

    public MemberExprNode(Position pos,ExprNode exp,String name){
        super(pos);
        this.supExprNode=exp;
        this.name=name;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return !this.type.match(MxBaseType.BasicType.FUNC);
    }
}
