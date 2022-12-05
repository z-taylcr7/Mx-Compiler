package undecimber.compiler.frontend.ast.nodes;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import utility.Position;

public abstract  class ASTNode {
    public Position pos;
    public Value value=null;
    public ASTNode(Position pos) {
        this.pos = pos;
    }

    public abstract void accept(ASTVisitor visitor);
}
