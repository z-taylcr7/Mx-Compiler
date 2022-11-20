package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import utility.LLVM;

public class ZextNode extends IRBaseNode {
    public ZextNode(Value x, IRBaseType type, IRBlock parentBlock) {
        super(LLVM.ZextInst, type, parentBlock);
        this.addOperand(x);
    }
    public Value getValue(){
        return this.getOperand(0);
    }


    @Override
    public String format() {
        //<result> = zext <ty> <value> to <ty2>
        return this.identifier() + " = " + LLVM.ZextInst + " " + this.getValue().typeIdentifier() + " to " + this.type;
    }

    @Override
    public IRBaseNode copy() {
        return new ZextNode(getValue(),type,null);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
