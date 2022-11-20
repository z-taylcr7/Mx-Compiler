package undecimber.compiler.middleend.llvmir.irconst;

import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;

public class GlobalValue extends IRConst{
    Value constVal;
    public GlobalValue(Value val) {
        super(val.name, val.type);
    }

    public GlobalValue(String name, IRBaseType type) {
        super(name,type);
    }

    @Override
    public String identifier() {return "@" + this.name;}
}
