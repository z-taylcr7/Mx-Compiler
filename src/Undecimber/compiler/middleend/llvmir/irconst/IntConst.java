package undecimber.compiler.middleend.llvmir.irconst;

import undecimber.compiler.middleend.llvmir.IRTranslator;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRIntType;
import utility.LLVM;

import java.util.Objects;

public class IntConst extends IRConst{
    int data;

    public IntConst(int _data) {
        super(LLVM.ConstAnon, IRTranslator.intType);
        data=_data;

    }
    public IntConst(int _data,int _width) {
        super(LLVM.ConstAnon, new IRIntType(_width));
        data=_data;

    }
    @Override
    public boolean equals(Object o) {return o instanceof IntConst && Objects.equals(data, ((IntConst) o).data);}
    @Override
    public String identifier(){
        return String.valueOf(data);
    }

}
