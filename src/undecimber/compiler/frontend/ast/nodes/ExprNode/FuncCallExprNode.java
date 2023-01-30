package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;

import java.util.ArrayList;

public class FuncCallExprNode extends ExprNode {
    public ArrayList<ExprNode> callArgExpNodes;
    public ExprNode callExprNode;

    public FuncCallExprNode(Position pos, ExprNode callExprNode) {
        super(pos);
        this.callExprNode = callExprNode;
        this.callArgExpNodes = new ArrayList<>();
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