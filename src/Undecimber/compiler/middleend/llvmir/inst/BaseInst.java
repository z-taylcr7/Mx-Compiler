package undecimber.compiler.middleend.llvmir.inst;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.InstVisitor;
import undecimber.compiler.middleend.llvmir.User;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;

import java.util.ArrayList;

public class BaseInst extends User{
    String instName;
    public IRBlock parentBlock;
    public BaseInst(String instName, IRBaseType type, IRBlock parentBlock){
        super(instName,type);
        this.parentBlock=parentBlock;
    }

    public BaseInst(String name, IRBaseType type, IRBlock parentBlock, boolean frontInsert) {
        super(name, type);
        this.instName = name; // instName is the same with value name before rename
        setParentBlockAtHead(parentBlock);
    }

    public void setParentBlock(IRBlock parentBlock) {
        this.parentBlock = parentBlock;
        if (parentBlock != null) parentBlock.addInst(this);
    }

    public void setParentBlockAtHead(IRBlock parentBlock) {
        this.parentBlock = parentBlock;
        if (parentBlock != null) parentBlock.instructions.addFirst(this);
    }

    // before an instruction removed/replaced, call it
    public void removedFromAllUsers() {
        for (Value value : operands) {
            if (value != null)
                value.users.remove(this);
        }
    }

    public boolean mayHaveSideEffects() {return false;}

    public abstract String format();

    public boolean isTerminator() {return false;}

    public boolean isValueSelf() {return true;}

    // copy method will create a copy of the original instruction
    // the parentBlock will be set "null"
    public abstract BaseInst copy();

    public abstract void accept(InstVisitor visitor);

}
