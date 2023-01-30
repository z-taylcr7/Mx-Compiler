package undecimber.compiler.backend.optim;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.insts.AsmBrInst;
import undecimber.compiler.backend.asm.insts.AsmCallInst;
import undecimber.compiler.backend.asm.insts.AsmMvInst;
import undecimber.compiler.backend.asm.operands.PhysicalReg;
import utility.pass.AsmPass;

import java.util.HashMap;
import java.util.HashSet;

public class RemoveRedundantInst implements AsmPass {

    private void unusedDef(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            HashMap<PhysicalReg, AsmBaseInst> defButNotUsed = new HashMap<>();
            HashSet<AsmBaseInst> toRemoveSet = new HashSet<>();

            for (AsmBaseInst inst : block.instructions) {
                if (inst.rs1 != null && inst.rs1.color != null)
                    defButNotUsed.remove(inst.rs1.color);
                if (inst.rs2 != null && inst.rs2.color != null)
                    defButNotUsed.remove(inst.rs2.color);

                if (inst.rd != null && inst.rd.color != null) {
                    if (defButNotUsed.containsKey(inst.rd.color))
                        toRemoveSet.add(defButNotUsed.get(inst.rd.color));

                    defButNotUsed.put(inst.rd.color, inst);
                }

                if (inst instanceof AsmCallInst || inst instanceof AsmBrInst)
                    defButNotUsed.clear();
            }

            block.instructions.removeAll(toRemoveSet);
        }
    }
    private void foldMoves(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            HashSet<AsmBaseInst> toRemoveSet = new HashSet<>();

            for (int i = 0; i < block.instructions.size()-1; i++)
                // move twice
                if (block.instructions.get(i) instanceof AsmMvInst && block.instructions.get(i+1) instanceof AsmMvInst &&
                        block.instructions.get(i).rd.color == block.instructions.get(i+1).rd.color) {
                    toRemoveSet.add(block.instructions.get(i));
                }

            block.instructions.removeAll(toRemoveSet);
        }
    }
    @Override
    public void runBlock(AsmBlock block) {
        //nothing
    }

    @Override
    public void runModule(AsmModule module) {
        for (AsmFunction function : module.functions) {
            runFunction(function);
        }
    }

    @Override
    public void runFunction(AsmFunction function) {
        foldMoves(function);
        unusedDef(function);

    }
}
