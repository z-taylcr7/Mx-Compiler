package undecimber.compiler.frontend.ast.nodes;

import Util.position;
import undecimber.compiler.frontend.scope.GlobalScope;
import java.util.ArrayList;

public class RootNode extends ASTNode {
    public GlobalScope scope;
    public ArrayList<structDefNode> sonNodes = new ArrayList<>();
    //todo:
    public RootNode(position pos) {
        super(pos);
        this.scope=new GlobalScope();
        this.sonNodes=new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
