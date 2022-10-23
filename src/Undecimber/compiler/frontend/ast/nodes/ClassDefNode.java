package undecimber.compiler.frontend.ast.nodes;

import undecimber.compiler.frontend.ast.ASTVisitor;
import utility.Position;
import undecimber.compiler.frontend.ast.nodes.stmtNode.VarDefStmtNode;
import java.util.ArrayList;
import undecimber.compiler.frontend.registry.ClassRegistry;
public class ClassDefNode extends ASTNode {
    public ArrayList<VarDefStmtNode> varDefs ;
    public ArrayList<FuncDefNode> funcDefs;
    public ClassRegistry classRegistry;

    public FuncDefNode constructorDefNode;

    public ClassDefNode(Position pos//, String name
        ) {
        super(pos);
        this.constructorDefNode=null;
        this.varDefs = new ArrayList<>();
        this.funcDefs = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
