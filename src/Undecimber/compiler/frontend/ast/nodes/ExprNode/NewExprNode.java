package undecimber.compiler.frontend.ast.nodes.ExprNode;

import undecimber.compiler.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.Position;
import utility.types.varType;
import java.util.ArrayList;

public class NewExprNode extends ExprNode{
    ArrayList<ExprNode> DimLengthExprNodes;
    varType type;
    public NewExprNode(Position pos, varType type){
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