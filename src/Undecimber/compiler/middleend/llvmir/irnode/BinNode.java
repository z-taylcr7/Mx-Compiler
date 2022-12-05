package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRTranslator;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;

public class BinNode extends IRBaseNode{
    public String op;
    public BinNode(String op, IRBaseType type,Value lhs,Value rhs, IRBlock parentBlock) {
        super(IRTranslator.translateOp(op), type, parentBlock);
        this.op= IRTranslator.translateOp(op);
        this.addOperand(lhs);
        this.addOperand(rhs);
    }
    public Value lhs(){
        return this.getOperand(0);
    }
    public Value rhs(){
        return this.getOperand(1);
    }

    @Override
    public String format() {
        return this.identifier()+" = "+this.op+" "+lhs().identifier()+" , "+rhs().identifier();
        //<result> = add i32 4, %var          ; yields i32:result = 4 + %var
    }


    @Override
    public IRBaseNode copy() {
        return  new BinNode(op, type, lhs(), rhs(), null);
    }

    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);

    }
}
