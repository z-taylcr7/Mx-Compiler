package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import utility.LLVM;

public class PhiNode extends IRBaseNode{
    public PhiNode(IRBaseType type,IRBlock parentBlock, Value... args) {
        super(LLVM.PhiInst, type, parentBlock);
        for (Value op:args)this.addOperand(op);
        assert this.getOperandSize()%2==0;
    }
    public void addBranch(Value branchData, IRBlock prevBlock) {
        this.addOperand(branchData);
        this.addOperand(prevBlock);
    }
    @Override
    public String format() {
        StringBuilder ret = new StringBuilder(this.identifier() + " = " + LLVM.PhiInst + " " + this.type + " ");
        for (int i = 0; i < this.getOperandSize(); i += 2) {
            ret.append("[").append(this.getOperand(i).identifier()).append(", ").append(this.getOperand(i + 1).identifier()).append("]");
            if (i < this.getOperandSize() - 2) ret.append(", ");
        }
        return ret.toString();
    }

    @Override
    public IRBaseNode copy() {
        PhiNode ret = new PhiNode(type, null);
        for (int i = 0; i < this.getOperandSize(); i += 2)
            ret.addBranch(this.getOperand(i), (IRBlock) this.getOperand(i+1));
        return ret;
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this
        );
    }
}
