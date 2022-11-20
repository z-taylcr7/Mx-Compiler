package undecimber.compiler.middleend.llvmir.irnode;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.User;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;

public abstract class IRBaseNode extends User{
    String NodeName;
    public IRBlock parentBlock;
    public IRBaseNode(String NodeName, IRBaseType type, IRBlock parentBlock){
        super(NodeName,type);
        this.parentBlock=parentBlock;
    }

    public IRBaseNode(String name, IRBaseType type, IRBlock parentBlock, boolean frontInsert) {
        super(name, type);
        this.NodeName = name; // NodeName is the same with value name before rename
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

    // before an Noderuction removed/replaced, call it
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

    // copy method will create a copy of the original Instruction
    // the parentBlock will be set "null"
    public abstract IRBaseNode copy();

    public abstract void accept(IRVisitor visitor);

}
