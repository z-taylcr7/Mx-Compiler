package undecimber.compiler.middleend.llvmir.irconst;

import undecimber.compiler.middleend.llvmir.IRTranslator;
import undecimber.compiler.middleend.llvmir.irtype.*;
import utility.LLVM;

public class NullConst extends IRConst{
    public NullConst(){
        super(LLVM.Nullptr, IRTranslator.nullType);
    }
    @Override
    public boolean equals(Object o){
        return o instanceof NullConst;
    }

    @Override
    public String identifier() {return LLVM.Nullptr;}
}
