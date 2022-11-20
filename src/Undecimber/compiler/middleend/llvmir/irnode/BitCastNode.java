package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import utility.LLVM;

public class BitCastNode extends IRBaseNode{
    public BitCastNode(Value x, IRBaseType type, IRBlock parentBlock) {
        super(LLVM.BitCastInst, type, parentBlock);
        this.addOperand(x);

    }
    public Value getValue(){
        return this.getOperand(0);
    }

    @Override
    public String format() {
        // %bitcast = bitcast type1 <id> to <type2>;
        return this.identifier() + " = " + LLVM.BitCastInst + " " + this.getValue().typeIdentifier()
                + " to " + this.type;
    }

    @Override
    public IRBaseNode copy() {
        return new BitCastNode(this.getValue(),type,null);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

}
