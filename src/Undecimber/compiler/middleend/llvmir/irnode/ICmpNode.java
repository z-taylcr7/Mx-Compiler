package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRTranslator;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRBoolType;

public class ICmpNode extends IRBaseNode {
    public String cmp;

    public ICmpNode(String cmp,  Value lhs,Value rhs, IRBlock parentBlock) {
        super(cmp, IRTranslator.boolType, parentBlock);
        this.addOperand(lhs);
        this.addOperand(rhs);
    }
    public Value lhs(){
        return this.getOperand(0);
    }
    public Value rhs(){
        return this.getOperand(1);
    }
    public boolean onlyBR(){
        return this.users.size()==1&&this.users.get(0) instanceof BrNode;
    }


    /**
     * @return
     */
    @Override
    public String format() {
        return this.identifier()+" = icmp "+this.cmp+" "+lhs().typeIdentifier()+" , "+rhs().identifier();
    }

    /**
     * @return
     */
    @Override
    public IRBaseNode copy() {
        return null;
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
