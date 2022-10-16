package undecimber.compiler.frontend.ast.nodes.ExprNode;

import undecimber.compiler.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;

import java.util.ArrayList;

public class FuncCallExpNode extends ExprNode
    public ArrayList<ExpBaseNode> callArgExpNodes;

    public FuncCallExpNode(Position pos, ExprNode callExpNode) {
        super(pos);
        this.callExprNode = callExpNode;
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