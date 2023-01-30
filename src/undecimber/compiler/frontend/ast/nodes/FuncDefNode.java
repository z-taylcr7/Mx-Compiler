package undecimber.compiler.frontend.ast.nodes;

import undecimber.compiler.frontend.ast.ASTVisitor;
import undecimber.compiler.frontend.ast.nodes.*;
import utility.types.MxBaseType;
import undecimber.compiler.frontend.registry.FuncRegistry;
import utility.Position;
import java.util.Objects;

public class FuncDefNode extends ASTNode {


    public PackNode packNode;
    public FuncRegistry funcRegistry;

    public FuncDefNode(Position pos,FuncRegistry funcRegistry,  PackNode packNode) {
        super(pos);
        this.funcRegistry=funcRegistry;
        this.packNode = packNode;
    }



    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }

    public boolean isValidMainFunc() {
        return Objects.equals(funcRegistry.name, "main")
                && funcRegistry.type.retType.match(MxBaseType.BasicType.INT)
                && funcRegistry.funcArgs.size() == 0;
    }
}