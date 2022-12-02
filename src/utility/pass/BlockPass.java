package utility.pass;

import undecimber.compiler.middleend.llvmir.IRBlock;

public interface BlockPass extends Pass{
    public abstract void runBlock(IRBlock block);

}
