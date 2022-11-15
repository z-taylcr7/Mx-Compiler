package undecimber.compiler.middleend.llvmir.irtype;

public class IRLabelType extends IRBaseType{

    @Override
    public boolean match(IRBaseType other) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "Label";
    }
}
