package undecimber.compiler.frontend.ast.nodes;

import undecimber.compiler.frontend.ast.ASTVisitor;
import utility.Position;

public abstract  class ASTNode {
    public Position pos;

    public ASTNode(Position pos) {
        this.pos = pos;
    }

    public abstract void accept(ASTVisitor visitor);
}
