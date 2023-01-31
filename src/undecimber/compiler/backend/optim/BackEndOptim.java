package undecimber.compiler.backend.optim;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.middleend.llvmir.IRFunction;
import utility.pass.AsmPass;
import utility.pass.FunctionPass;

public class BackEndOptim implements AsmPass {
    /**
     * @param func
     */
    @Override
    public void runFunction(AsmFunction func) {
        new MoveCoalescence().runFunction(func);
        new MergeBlock().runFunction(func);
        new ZeroElimination().runFunction(func);
        new RemoveRedundantInst().runFunction(func);

    }
    /**
     * @param block
     */
    @Override
    public void runBlock(AsmBlock block) {

    }

    /**
     * @param module
     */
    @Override
    public void runModule(AsmModule module) {
        for (AsmFunction function : module.functions) {
            runFunction(function);
        }
        new RemoveVR().runModule(module);


    }


}
