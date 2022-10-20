package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;

import undecimber.compiler.frontend.ast.nodes.PackNode;

import undecimber.compiler.frontend.registry.FuncRegistry;

import java.util.ArrayList;

public class LambdaExprNode extends ExprNode {
    public FuncRegistry funcRegistry;
    public PackNode packNode;
    public ArrayList<ExprNode> callArgExprNodes;

    public LambdaExprNode(Position pos, PackNode packNode) {
        super(pos);
        this.packNode = packNode;
        callArgExprNodes = new ArrayList<>();
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