package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import utility.LLVM;

public class MoveNode extends IRBaseNode{
    public MoveNode(Value to, Value from, IRBlock parentBlock) {
        super(LLVM.MoveInst, from.type, parentBlock);
        this.addOperand(to);
        this.addOperand(from);
    }

    @Override
    public String format() {
        return LLVM.MoveInst + " " + this.getTo().identifier() + " from " + this.getFrom().identifier();
    }

    private Value getTo() {
        return this.getOperand(0);
    }
    private Value getFrom() {
        return this.getOperand(1);
    }

    @Override
    public IRBaseNode copy() {
        return null;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
