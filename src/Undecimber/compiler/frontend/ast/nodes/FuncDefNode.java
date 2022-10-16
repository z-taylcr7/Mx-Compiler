package undecimber.compiler.frontend.ast.nodes;

import ast.nodes.*;
import Undecimber.frontend.info.types.MxBaseType;

import utility.position;
import java.util.Objects;

public class FuncDefNode extends BaseNode {


    public PackNode packNode;

    public FuncDefNode(position pos,FuncRegistry funcRegistry,  PackNode packNode) {
        super(pos);
        this.packNode = packNode;
    }

    public boolean isMain() {
        return Objects.equals(funcRegistry.name, 'main')
                && funcRegistry.type.retType.match(MxBaseType.BuiltinType.INT)
                && funcRegistry.funcArgs.size() == 0;
    }

    @Override
    public void accept(ASTVisitor visitor) {
        visitor.visit(this);
    }
}