package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRVoidType;
import utility.LLVM;

public class RetNode extends IRBaseNode{
    //return void
    public RetNode(IRBlock parentBlock) {
        super(LLVM.RetInst, new IRVoidType(), parentBlock);
    }
    //return non-void
    public RetNode(Value retValue, IRBlock parentBlock) {
        super(LLVM.RetInst, retValue.type, parentBlock);
        this.addOperand(retValue);
    }
    public Value retValue(){
        return this.getOperand(0);
    }
    public boolean isVoid(){
        return this.getOperandSize()==0;
    }

    @Override
    public boolean isValueSelf() {
        return false;
    }

    @Override
    public boolean isTerminator() {
        return true;
    }

    @Override
    public String format() {
        //ret <type> <value>       ; Return a value from a non-void function
        //ret void                 ; Return from void function
        if(isVoid())
            return "return void" ;
else         return "return " +type+" "+retValue().identifier()  ;
    }

    @Override
    public IRBaseNode copy() {
        if (isVoid()) return new RetNode(null);
        return new RetNode(retValue(), null);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public boolean mayHaveSideEffects() {
        return true;
    }
}
