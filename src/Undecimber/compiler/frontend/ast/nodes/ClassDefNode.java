package undecimber.compiler.frontend.ast.nodes;

import utility.Position;
import undecimber.compiler.frontend.ast.nodes.Stmtnode.VarDefStmtNode;
import java.util.ArrayList;
import undecimber.compiler.frontend.registry.ClassRegistry;
public class ClassDefNode extends ASTNode {
    public ArrayList<VarDefStmtNode> varDefs = new ArrayList<>();
    public ArrayList<FuncDefNode> funcDefs = new ArrayList<>();
    public ClassRegistry classRegistry;

    public FuncDefNode constructorDefNode;

    public ClassDefNode(position pos,// String name
        ) {
        super(pos);this.constructorDefNode=null;
        this.varDefs = new ArrayList<>();
        this.funcDefs = new ArrayList<>();
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}
