package undecimber.compiler.frontend.ast.nodes.exprNode;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;
import undecimber.compiler.frontend.parser.MxParser;

public class AtomExprNode extends ExprNode {
    // literal content
    public MxParser.BasicExpContext ctx;

    public AtomExprNode(Position pos, MxParser.BasicExpContext ctx) {
        super(pos);
        this.ctx = ctx;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return ctx.ID() != null;
    }
}