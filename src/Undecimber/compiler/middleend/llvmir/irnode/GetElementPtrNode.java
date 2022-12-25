package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;
import utility.LLVM;

import java.util.ArrayList;

public class GetElementPtrNode extends IRBaseNode {
    private String elementName = null;

    public GetElementPtrNode(String elementName, Value headPointer, IRBaseType yieldType, IRBlock parentBlock, Value... indices) {
        super(elementName + LLVM.AddrSuffix, yieldType, parentBlock);
        assert headPointer.type instanceof IRPointerType;
        this.addOperand(headPointer);
        for (Value index : indices) this.addOperand(index);

        this.elementName = elementName;
    }



    public GetElementPtrNode(Value headPointer, IRBaseType yieldType, IRBlock parentBlock, Value... indices) {
        super(LLVM.GetElementPtrInst, yieldType, parentBlock);
        assert headPointer.type instanceof IRPointerType;
        this.addOperand(headPointer);
        for (Value index : indices) this.addOperand(index);
    }


    public int indicesNum() {
        return this.getOperandSize() - 1;
    }

    public Value getIndex(int pos) {
        return this.getOperand(pos + 1);
    }

    public Value headPointer() {
        return this.getOperand(0);
    }

    @Override
    public String format() {
        // %t4 = getelementptr [10 x [20 x i32]], [10 x [20 x i32]]* %t3, i32 0, i32 5
        StringBuilder ret = new StringBuilder(this.identifier() + " = " + LLVM.GetElementPtrInst
                + " inbounds " + ((IRPointerType) this.headPointer().type).pointedType
                + ", " + this.headPointer().typeIdentifier());
        for (int i = 0; i < this.indicesNum(); ++i)
            ret.append(", ").append(this.getIndex(i).typeIdentifier());
        return ret.toString();
    }

    @Override
    public IRBaseNode copy() {
        if (elementName == null) {
            if (indicesNum() == 1) return new GetElementPtrNode(headPointer(), type, null, getIndex(0));
            else return new GetElementPtrNode(headPointer(), type, null, getIndex(0), getIndex(1));
        } else {
            if (indicesNum() == 1) return new GetElementPtrNode(elementName, headPointer(), type, null, getIndex(0));
            else return new GetElementPtrNode(elementName, headPointer(), type, null, getIndex(0), getIndex(1));
        }
    }


    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
