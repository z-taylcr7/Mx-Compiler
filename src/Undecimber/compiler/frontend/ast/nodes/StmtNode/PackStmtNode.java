package undecimber.compiler.frontend.ast.nodes.stmtNode;

import utility.Position;
import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.*;

import java.util.ArrayList;

public class PackStmtNode extends BaseStmtNode {
    public PackNode packNode;

    public PackStmtNode(Position pos,PackNode packNode) {
        super(pos);this.packNode=packNode;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
