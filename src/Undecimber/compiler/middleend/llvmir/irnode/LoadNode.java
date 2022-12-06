package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;

public class LoadNode extends IRBaseNode{


    public LoadNode(Value loadAddr, IRBlock parentBlock) {
        super(resolveRename(loadAddr.name), ((IRPointerType)loadAddr.type).pointedType, parentBlock);
        this.addOperand(loadAddr);
    }
    public Value getLoadAddr(){
        return this.getOperand(0);
    }


    /**
     * @return
     */
    @Override
    public String format() {
        //<result> = load [volatile] <ty>, ptr <pointer>[, align <alignment>]
        return  this.identifier()+" = load "+ this.type + ", " +
                this.getLoadAddr().typeIdentifier() + ", align " + this.type.size();
    }

    /**
     * @return
     */
    @Override
    public IRBaseNode copy() {
        return new LoadNode(this.getLoadAddr(),parentBlock);
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
