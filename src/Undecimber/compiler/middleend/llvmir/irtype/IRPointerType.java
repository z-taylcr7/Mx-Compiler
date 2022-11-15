package undecimber.compiler.middleend.llvmir.irtype;

import utility.LLVM;

public class IRPointerType extends IRBaseType{
    public IRBaseType pointedType;
    public int dimension;

    public IRPointerType(IRBaseType pointedType) {
        if (pointedType instanceof IRPointerType)this.dimension+=1;
        else this.dimension=1;
        this.pointedType = pointedType;

    }

    @Override
    public boolean match(IRBaseType other) {
        if(other instanceof IRPointerType){
//            if(other.equals(nullType))return true;
            return (pointedType.match(((IRPointerType) other).pointedType)&&this.dimension==((IRPointerType) other).dimension);
        } else if (other instanceof IRStringType) {
            return true;
            //todo: stringtype unconfirmed
        }
        return false;
    }

    @Override
    public int size() {
        return LLVM.PointerSize;
    }

    @Override
    public String toString() {
        return (pointedType.toString()+'*');
    }
}
