package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRVoidType;
import utility.LLVM;

public class BrNode extends IRBaseNode{
    public final boolean isJump=false;
    public BrNode(IRBlock block, IRBlock parentBlock) {
        super(LLVM.BrInst,new IRVoidType(), parentBlock);
        this.addOperand(block);
    }

    public boolean IsJump() {
        return this.getOperandSize()==1;
    }

    public BrNode(Value cond, IRBlock thenBlock, IRBlock elseBlock, IRBlock parentBlock){
        super(LLVM.BrInst,new IRVoidType(), parentBlock);
        this.addOperand(cond);
        this.addOperand(thenBlock);
        this.addOperand(elseBlock);
    }
    @Override
    public boolean isTerminator() {return true;}

    @Override
    public boolean isValueSelf() {return false;}
    public Value Cond(){assert !IsJump();return this.getOperand(0);}
    public IRBlock Dest(){assert !IsJump();return (IRBlock) this.getOperand(0);}
    public IRBlock Then(){
        Value v=this.getOperand(1);
        return (IRBlock) this.getOperand(1);
    }
    public IRBlock Else(){assert !IsJump();return (IRBlock) this.getOperand(2);}
    public void setDest(Value d){assert !IsJump();this.setOperand(0,d);}
    public void setThen(IRBlock block){this.setOperand(1,block);}
    public void setElse(IRBlock block){assert !IsJump();this.setOperand(2,block);}
    /**
     * @return
     */
    @Override
    public String format() {
        int x=1;
        //br i1 <cond>, label <then>, label <else>
        //br label <then>          ; Unconditional branch
        if (IsJump())return LLVM.BrInst+" "+this.Dest().typeIdentifier();
        else return LLVM.BrInst+" "+this.Cond().type+" , "+this.Then().typeIdentifier()+" , "+this.Else().typeIdentifier();
    }

    /**
     * @return
     */
    @Override
    public IRBaseNode copy() {
        if(isJump)return new BrNode(this.Dest(),this.parentBlock);
        else return new BrNode(this.Cond(),this.Then(),this.Else(),this.parentBlock);
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);

    }
}
