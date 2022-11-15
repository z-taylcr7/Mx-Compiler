package undecimber.compiler.middleend.llvmir.irtype;

public class IRStringType extends IRBaseType {
    public IRBaseType elementType;
    public int length;

    public IRStringType(IRBaseType elementType, int length) {
        this.elementType = elementType;
        this.length = length;
    }

    @Override
    public boolean match(IRBaseType other) {
        return other instanceof IRStringType;
    }

    @Override
    public int size() {
        return elementType.size();
    }

    @Override
    public String toString() {
        return "IRStringType{" +
                "elementType=" + elementType +
                ", length=" + length +
                '}';
    }
}
