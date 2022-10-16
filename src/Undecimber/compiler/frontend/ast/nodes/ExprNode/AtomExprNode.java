package undecimber.compiler.frontend.ast.nodes.ExprNode;

import undecimber.compiler.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.ExprNode;
import utility.Position;
import undecimber.compiler.frontend.parser.MxParser;

public class AtomExprNode extends ExprNode {
    // literal content
    public MxParser.AtomContext ctx;

    public AtomExprNode(Position pos, MxParser.AtomContext ctx) {
        super(pos;
        this.ctx = ctx;
    }

    public String getStringLiteral() {
        String rawString =  this.ctx.StringConstant().toString();
        return rawString.substring(1, rawString.length()-1) // quote filter
                .replace("\\\"","\"")
                .replace("\\n","\n")
                .replace("\\t","\t")
                .replace("\\\\","\\");
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean isLeftValue() {
        return ctx.Identifier() != null;
    }
}