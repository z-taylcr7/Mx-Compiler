package utility.pass;

import undecimber.compiler.middleend.llvmir.IRModule;

public interface ModulePass extends Pass{
    public abstract void runModule(IRModule module);
}
