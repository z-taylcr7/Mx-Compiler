package undecimber.compiler.frontend.ast.nodes.stmtNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.BaseStmtNode;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import undecimber.compiler.frontend.scope.LoopScope;
import undecimber.compiler.frontend.ast.nodes.VarDefSingleNode;
import utility.Position;

import java.util.ArrayList;

public class ForStmtNode extends BaseStmtNode {
    public LoopScope scope;
    public ExprNode initExprNode, conditionExprNode, incrExprNode;
    public ArrayList<VarDefSingleNode> initVarDefSingleNodes;
    public BaseStmtNode bodyStmtNode;
    public ForStmtNode(Position pos){
        super(pos);
        this.scope=new LoopScope();
        initVarDefSingleNodes= new ArrayList<>();
        this.initExprNode=this.conditionExprNode=this.incrExprNode=null;
        this.bodyStmtNode=null;
    }
    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}