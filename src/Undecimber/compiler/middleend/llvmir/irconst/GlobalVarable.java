package undecimber.compiler.middleend.llvmir.irconst;

import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;

public class GlobalVarable extends GlobalValue{
    public Value val;
    public int dim=0;
    public GlobalVarable(Value val, IRBaseType type) {
        super(val.identifier(),new IRPointerType(type));
    }
    public IRBaseType PointedType(){
        return ((IRPointerType)this.type).pointedType;
    }
}
