package utility.pass;

import undecimber.compiler.middleend.llvmir.IRFunction;

public interface FunctionPass extends Pass{
    public abstract void runFunction(IRFunction func);
}
