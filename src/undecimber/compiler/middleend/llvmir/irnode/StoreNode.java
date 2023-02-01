package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irconst.NullConst;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;
import utility.LLVM;

public class StoreNode extends IRBaseNode{
    public StoreNode(Value StorePtr, Value StoreData, IRBlock parentBlock) {
        super(LLVM.StoreInst, StoreData.type, parentBlock);
        this.addOperand(StorePtr);
        this.addOperand(StoreData);
    }
    public void replacePtr(Value value) {this.setOperand(0,value);}

    /**
     * @return
     */
    @Override
    public String format() {
        //store [volatile] <ty> <value>, ptr <pointer>[, align <alignment>]
        if (this.getStoreData() instanceof NullConst)
            return LLVM.StoreInst + " " + ((IRPointerType) this.getStorePtr().type).pointedType + " " +
                    this.getStoreData().identifier() + ", " + this.getStorePtr().typeIdentifier() + ", align " + this.type.size();

        return name = "store " + this.getStoreData().typeIdentifier() + "," +
                this.getStorePtr().typeIdentifier() + ", align " + this.type.size();
    }

    @Override
    public boolean mayHaveSideEffects() {return true;}
    public Value getStorePtr() {
        return this.getOperand(0);
    }
    public Value getStoreData(){
        return this.getOperand(1);
    }


    /**
     * @return
     */
    @Override
    public IRBaseNode copy() {
        return new StoreNode(getStorePtr(),this.getStoreData(),parentBlock);
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
