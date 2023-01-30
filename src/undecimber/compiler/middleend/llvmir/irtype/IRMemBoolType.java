package undecimber.compiler.middleend.llvmir.irtype;

public class IRMemBoolType extends IRBaseType{
    @Override
    public boolean match(IRBaseType other) {
        return other instanceof IRMemBoolType;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String toString() {
        return "i8";
    }
}
