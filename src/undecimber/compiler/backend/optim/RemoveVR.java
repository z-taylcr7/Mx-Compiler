package undecimber.compiler.backend.optim;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.insts.AsmMvInst;
import undecimber.compiler.backend.asm.operands.VirtualReg;
import utility.pass.AsmPass;

import java.util.HashSet;
import java.util.Set;

public class RemoveVR implements AsmPass {
    Set<AsmBaseInst> removeList=new HashSet<>();
    /**
     * @param block
     */
    @Override
    public void runBlock(AsmBlock block) {

        for (AsmBaseInst inst : block.instructions) {
            if(inst instanceof AsmMvInst){
                if((inst.rd instanceof VirtualReg&&inst.rd.color==null) || (inst.rs1 instanceof VirtualReg&&inst.rs1.color==null)){
                    removeList.add(inst);
                }
            }
        }
        block.instructions.removeAll(removeList);
        removeList.clear();
    }

    /**
     * @param module
     */
    @Override
    public void runModule(AsmModule module) {
        for (AsmFunction function : module.functions) {
            runFunction(function);
        }
    }

    /**
     * @param function
     */
    @Override
    public void runFunction(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            runBlock(block);
        }

    }
}
