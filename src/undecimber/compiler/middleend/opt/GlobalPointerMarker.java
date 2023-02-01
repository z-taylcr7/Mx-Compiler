package undecimber.compiler.middleend.opt;


import undecimber.compiler.middleend.analytics.loop.LoopAnalyzer;
import undecimber.compiler.middleend.llvmir.IRModule;
import undecimber.compiler.middleend.llvmir.User;
import undecimber.compiler.middleend.llvmir.irconst.GlobalValue;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import utility.pass.ModulePass;

import java.util.HashMap;

/**
 * this pass intends to find the most frequently used global pointer and mark it
 * in Asm Stage, it will use "gp" to store it
 */

public class GlobalPointerMarker implements ModulePass {
    private HashMap<GlobalValue, Integer> useCount = new HashMap<>();

    @Override
    public void runModule(IRModule module) {
        module.functions.forEach(func -> new LoopAnalyzer().runFunction(func));

        for (GlobalValue glo : module.globalVarArray) {
            for (User user : glo.users) {

                useCount.put(glo, (int) Math.pow(10, ((IRBaseNode) user).parentBlock.loopDepth));
            }
        }

        // string constant not marked

        GlobalValue marked = null;

        for (var entry : useCount.entrySet()) {
            if (marked == null) marked = entry.getKey();
            else {
                if (entry.getValue() > useCount.get(marked)) marked = entry.getKey();
            }
        }

        if (marked != null) {

            marked.isGlbPointer = true;
        }
    }
}
