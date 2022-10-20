package undecimber.compiler.frontend.ast.nodes;


import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.scope.NormalScope;
import utility.Position;
import java.util.ArrayList;

public class PackNode extends ASTNode {
    public ArrayList<BaseStmtNode> stmtNodes;
    public NormalScope scope;
    //todo:
    public PackNode(Position pos) {
        super(pos);
        this.scope=new NormalScope();
        this.stmtNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
