package undecimber.compiler.frontend.ast.nodes.StmtNode;

import utility.position;

import java.util.ArrayList;

public class PackStmtNode extends StmtNode {
    public ArrayList<StmtNode> stmts;

    public PackStmtNode(position pos) {
        super(pos);
        this.stmts = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
