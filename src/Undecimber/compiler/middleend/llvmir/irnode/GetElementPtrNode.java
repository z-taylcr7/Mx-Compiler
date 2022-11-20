package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;

public class GetElementPtrNode extends IRBaseNode{
    public GetElementPtrNode(String NodeName, IRBaseType type, IRBlock parentBlock) {
        super(NodeName, type, parentBlock);
    }

    @Override
    public String format() {
        return null;
    }

    @Override
    public IRBaseNode copy() {
        return null;
    }

    @Override
    public void accept(IRVisitor visitor) {

    }
}
