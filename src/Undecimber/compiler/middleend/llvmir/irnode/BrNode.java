package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRVoidType;
import utility.LLVM;

public class BrNode extends IRBaseNode{
    boolean isJump=false;
    public BrNode(IRBlock block, IRBlock parentBlock) {
        super(LLVM.BrInst,new IRVoidType(), parentBlock);
        this.addOperand(block);
        isJump=true;
    }
    public BrNode(Value cond, IRBlock thenBlock, IRBlock elseBlock,IRBlock parentBlock){
        super(LLVM.BrInst,new IRVoidType(), parentBlock);
        this.addOperand(cond);
        this.addOperand(thenBlock);
        this.addOperand(elseBlock);
    }
    @Override
    public boolean isTerminator() {return true;}

    @Override
    public boolean isValueSelf() {return false;}
    public Value Cond(){assert !isJump;return this.getOperand(0);}
    public IRBlock Then(){return (IRBlock) this.getOperand(isJump?0:1);}
    public IRBlock Else(){assert !isJump;return (IRBlock) this.getOperand(2);}
    public void setCond(Value cond){assert !isJump;this.setOperand(0,cond);}
    public void setThen(IRBlock block){this.setOperand(isJump?0:1,block);}
    public void setElse(IRBlock block){assert !isJump;this.setOperand(2,block);}
    /**
     * @return
     */
    @Override
    public String format() {
        //br i1 <cond>, label <then>, label <else>
        //br label <then>          ; Unconditional branch
        if (isJump)return LLVM.BrInst+" "+this.Then().typeIdentifier();
        return LLVM.BrInst+" "+this.Cond().typeIdentifier()+" , "+this.Then().typeIdentifier()+" , "+this.Else().typeIdentifier();
    }

    /**
     * @return
     */
    @Override
    public IRBaseNode copy() {
        if(isJump)return new BrNode(this.Then(),this.parentBlock);
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
