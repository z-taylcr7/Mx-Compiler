package undecimber.compiler.middleend.llvmir.irtype;


public class IRIntType extends IRBaseType {
    public final int width;

    public IRIntType(){
        this.width=32;
    }
    public IRIntType(int x){
        this.width=x;
    }
    public int size(){
        return width/8;
    }

    @Override
    public boolean match(IRBaseType other) {
        return ( other instanceof IRIntType
                 && (((IRIntType) other).width==width));
    }

    @Override
    public String toString() {
        return "i" +width;
    }
}