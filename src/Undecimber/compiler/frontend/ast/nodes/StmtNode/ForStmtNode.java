package undecimber.compiler.frontend.ast.nodes.StmtNode;

import utility.Position;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.StmtNode;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import undecimber.compiler.frontend.scope.LoopScope;
import undecimber.compiler.frontend.ast.VarDefSingleNode;

public class ForStmtNode extends StmtNode{
    public LoopScope scope;
    public ExprNode initExprNode, conditionExprNode, incrExprNode;
    public ArrayList<VarDefSingleNode> initVarDefSingleNodes;
    public StmtNode bodyStmtNode;
    public ForStmtNode(position pos){
        super(pos);
        this.scope=new LoopScope;
        initVarDefSingleNodes= new ArrayList<VarDefSingleNode>();
        this.initExprNode=this.conditionExprNode=this.incrExprNode=null;
        this.bodyStmtNode=null;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}