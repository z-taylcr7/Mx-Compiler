package undecimber.compiler.frontend.ast.nodes;

import undecimber.compiler.frontend.ast.ASTVisitor;
import utility.Position;
import undecimber.compiler.frontend.scope.GlobalScope;
import java.util.ArrayList;

public class RootNode extends ASTNode {
    public GlobalScope scope;
    public ArrayList<ASTNode> sonNodes = new ArrayList<>();
    //todo:
    public RootNode(Position pos) {
        super(pos);
        this.scope=new GlobalScope();
        this.sonNodes=new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
