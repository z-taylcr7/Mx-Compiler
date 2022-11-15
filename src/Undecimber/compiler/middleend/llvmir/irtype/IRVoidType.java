package undecimber.compiler.middleend.llvmir.irtype;

public class IRVoidType extends IRBaseType{

    @Override
    public boolean match(IRBaseType other) {
        return other instanceof IRVoidType;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "void";
    }
}
