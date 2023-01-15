package undecimber.compiler.middleend.opt;

import undecimber.compiler.middleend.analytics.CallGraphAnalyzer;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.IRModule;
import utility.pass.ModulePass;

public class MidOptim implements ModulePass {

    /**
     * @param module
     */
    @Override
    public void runModule(IRModule module) {

        new CallGraphAnalyzer().runModule(module);

        for (IRFunction function : module.functions) {
            new Glo2Loc().runFunction(function);
//            new Mem2Reg().runOnFunc(function);
        }
    }
}
