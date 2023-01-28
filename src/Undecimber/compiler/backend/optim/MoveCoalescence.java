package undecimber.compiler.backend.optim;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.AsmMvInst;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import utility.pass.AsmPass;
import utility.pass.FunctionPass;

public class MoveCoalescence implements AsmPass {

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

    }

    /**
     * @param function
     */
    @Override
    public void runFunction(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
           block.instructions.removeIf(mv->mv instanceof AsmMvInst && mv.rd.color==mv.rs1.color);
        }

    }
}
