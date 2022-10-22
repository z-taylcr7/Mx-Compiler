package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;
import utility.types.VarType;
import java.util.ArrayList;

public class NewExprNode extends ExprNode{
    public ArrayList<ExprNode> DimLengthExprNodes;
    public VarType type;
    public NewExprNode(Position pos, VarType type){
        super(pos);
        this.type=type;
        this.DimLengthExprNodes=new ArrayList<>();
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