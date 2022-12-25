package undecimber.compiler.middleend.llvmir.irconst;

import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRBoolType;
import utility.LLVM;

public class BoolConst extends IRConst{
   public boolean flag;

    public BoolConst(boolean _flag) {
        super(LLVM.ConstAnon,new IRBoolType());
        flag=_flag;
    }

    @Override
    public boolean equals(Object o) {return o instanceof BoolConst && flag == ((BoolConst) o).flag;}

    @Override
    public String identifier() {
        return flag ? "true" : "false";
    }
}
