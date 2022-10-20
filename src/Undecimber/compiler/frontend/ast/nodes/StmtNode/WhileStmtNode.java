package undecimber.compiler.frontend.ast.nodes.stmtNode;

import undecimber.compiler.frontend.ast.nodes.BaseStmtNode;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.BaseStmtNode;

import undecimber.compiler.frontend.ast.nodes.ExprNode;
import undecimber.compiler.frontend.scope.LoopScope;
import utility.Position;
public class WhileStmtNode extends BaseStmtNode {

    public LoopScope scope;

    public ExprNode conditionExprNode;
    public BaseStmtNode bodyStmtNode;

    public WhileStmtNode(Position pos, ExprNode conditionExprNode, BaseStmtNode bodyStmtNode) {
        super(pos);
        this.scope = new LoopScope();
        this.conditionExprNode = conditionExprNode;
        this.bodyStmtNode = bodyStmtNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
