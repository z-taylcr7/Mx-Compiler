package undecimber.compiler.frontend.ast.nodes;


import Util.position;

public abstract class StmtNode extends ASTNode {
    public StmtNode(position pos) {
        super(pos);
    }
}
