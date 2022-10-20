package undecimber.compiler.frontend.ast.nodes.stmtNode;
import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.BaseStmtNode;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import undecimber.compiler.frontend.ast.nodes.VarDefSingleNode;
import utility.Position;

import java.util.ArrayList;

public class VarDefStmtNode extends BaseStmtNode {
    public ArrayList<VarDefSingleNode> varDefSingleNodes;
    public VarDefStmtNode(Position pos) {
        super(pos);
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
