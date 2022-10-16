package undecimber.compiler.frontend.ast.nodes;


import utility.position;
import ast.ASTVisitor;

import java.util.ArrayList;

public class PackStmtNode extends StmtNode {
    public ArrayList<StmtNode> stmtNodes;
    //todo:
    public PackStmtNode(position pos) {
        super(pos);
        this.stmtNodes = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
