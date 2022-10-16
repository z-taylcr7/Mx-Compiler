package undecimber.compiler.frontend.ast.nodes.StmtNode;
import utility.position;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.StmtNode;
import undecimber.compiler.frontend.ast.ExprNode;
import undecimber.compiler.frontend.scope.LoopScope;

public class ForStmtNode extends StmtNode{
    public LoopScope scope;
    public ExprNode  conditionExprNode;
    public ArrayList<VarDefSingleNode> initVarDefSingleNodes;
    public StmtNode bodyStmtNode;
    public ForStmtNode(position pos){
        super(pos);
        this.scope=new LoopScope;
        initVarDefSingleNodes= new ArrayList<VarDefSingleNode>();
        this.conditionExprNode=null;
        this.bodyStmtNode=null;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}