package AST;

import utility.position;

import java.utility.ArrayList;

public class structDefNode extends ASTNode {
    public ArrayList<varDefStmtNode> varDefs = new ArrayList<>();
    public String name;

    public structDefNode(position pos, String name) {
        super(pos);
        this.name = name;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
