package undecimber.compiler.frontend.ast.nodes.exprNode;


import undecimber.compiler.frontend.ast.nodes.PackNode;
import utility.Position;

public class LocalLambdaExprNode extends LambdaExprNode{
    public  LocalLambdaExprNode(Position pos, PackNode packNode){
        super(pos,packNode);

    }
}
