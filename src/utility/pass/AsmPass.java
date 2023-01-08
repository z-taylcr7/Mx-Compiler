package utility.pass;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.middleend.llvmir.IRBlock;

public interface AsmPass extends Pass{

    public abstract void runBlock(AsmBlock block);
    public abstract  void runModule(AsmModule module);
    public abstract void runFunction(AsmFunction function);

}
