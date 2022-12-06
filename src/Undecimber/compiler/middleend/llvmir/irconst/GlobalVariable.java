package undecimber.compiler.middleend.llvmir.irconst;

import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;

public class GlobalVariable extends GlobalValue{
    public Value val;
    public GlobalVariable(String name, IRBaseType type) {
        super(name,new IRPointerType(type));
    }
    public IRBaseType PointedType(){
        return ((IRPointerType)this.type).pointedType;
    }
}
