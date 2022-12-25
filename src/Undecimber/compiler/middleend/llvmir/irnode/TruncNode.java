package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import utility.LLVM;

public class TruncNode extends IRBaseNode {
    public TruncNode(Value val, IRBaseType type, IRBlock parentBlock) {
        super(LLVM.TruncInst  , type, parentBlock);
        this.addOperand(val);
    }

    @Override
    public String format() {
        return this.identifier() + " = " + LLVM.TruncInst + " " + this.fromValue().typeIdentifier() + " to " + this.type;
    }

    private Value fromValue() {
        return this.getOperand(0);
    }

    @Override
    public IRBaseNode copy() {
        return new TruncNode(fromValue(), type, null);
    }

    @Override
    public void accept(IRVisitor visitor) {
            visitor.visit(this);
    }
}
