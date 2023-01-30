package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;
import utility.LLVM;

public class AllocaNode extends IRBaseNode {
    IRBaseType allocaType;
    public String allocaName;


    public AllocaNode(String NodeName, IRBaseType type, IRBlock parentBlock) {
        super(renameAddress(NodeName), new IRPointerType(type), parentBlock,true);
        allocaName=NodeName;
        allocaType=type;
    }


    @Override
    public String format(){
        return this.identifier()+" = " + LLVM.AllocaInst+"  "+ this.allocaType+", align "+this.allocaType.size();
        //name = alloca <type>
    }

    @Override
    public IRBaseNode copy() {
        return new AllocaNode(allocaName,allocaType,parentBlock);
    }

    @Override
    public boolean mayHaveSideEffects() {return true;}
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
