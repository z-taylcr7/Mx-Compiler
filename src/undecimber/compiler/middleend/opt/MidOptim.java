package undecimber.compiler.middleend.opt;

import undecimber.compiler.middleend.analytics.CallGraphAnalyzer;
import undecimber.compiler.middleend.analytics.loop.LoopAnalyzer;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.IRModule;
import undecimber.compiler.middleend.opt.ssa.Mem2Reg;
import undecimber.compiler.middleend.opt.ssa.SSADestructor;
import utility.pass.ModulePass;

public class MidOptim implements ModulePass {

    /**
     * @param module
     */
    @Override
    public void runModule(IRModule module) {

        new CallGraphAnalyzer().runModule(module);


        for (IRFunction function : module.functions) {
//            new Glo2Loc().runFunction(function);
            new Mem2Reg().runFunction(function);
        }

        new Inline().runModule(module);

        // re-analyze info for asm
        for (IRFunction function : module.functions) {
            new SSADestructor().runFunction(function);
            new LoopAnalyzer().runFunction(function);
        }

        new Inline().runModule(module);

    }
}
