package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRStructType;



public class StructProto extends Value{
    public StructProto(String name, IRBaseType type) {
        super(name, type);
    }
    public IRStructType construct(){
        return (IRStructType)(this.type);
    }
}
