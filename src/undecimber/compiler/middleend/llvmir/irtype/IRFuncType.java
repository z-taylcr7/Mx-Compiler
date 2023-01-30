package undecimber.compiler.middleend.llvmir.irtype;

import java.util.ArrayList;
public class IRFuncType extends IRBaseType{
    public ArrayList<IRBaseType> argTypes;
    public IRBaseType retType;
    public IRBaseType memberOf;

    public IRFuncType(IRBaseType retType, IRBaseType memberOf) {
        this.retType = retType;
        this.memberOf = memberOf;
        this.argTypes = new ArrayList<IRBaseType>();
    }

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
        return retType.toString() ;
    }
}
