package undecimber.compiler.backend.optim;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.insts.AsmBrInst;
import undecimber.compiler.backend.asm.insts.AsmJumpInst;
import utility.UnionSet;
import utility.pass.AsmPass;

import java.util.HashSet;

/**
 * this pass intends to remove block:
 * b1:
 *      j  b2
 * directly use b1 to replace b2
 */

public class MergeBlock implements AsmPass {

    private final UnionSet<AsmBlock> unionSet = new UnionSet<>();

    private AsmBlock getOnlyDest(AsmBlock block) {
        HashSet<AsmBlock> dests = new HashSet<>();
        for (AsmBaseInst inst : block.instructions) {
            if (!(inst instanceof AsmBrInst || inst instanceof AsmJumpInst)) return null;
            if (inst instanceof AsmBrInst) dests.add(((AsmBrInst) inst).dest);
            else dests.add(((AsmJumpInst) inst).dest);
        }
        if (dests.size() > 1) return null;
        return dests.iterator().next();
    }

    @Override
    public void runBlock(AsmBlock block) {

    }

    @Override
    public void runModule(AsmModule module) {

    }

    @Override
    public void runFunction(AsmFunction function) {
        boolean changed = true;

        while (changed) {
            changed = false;
            unionSet.clear();

            for (AsmBlock block : function.blocks) {
                var dest = getOnlyDest(block);
                if (dest != null) {
                    var replace = unionSet.getAlias(dest);
                    unionSet.setAlias(block, replace);
                }
            }

            var it = function.blocks.iterator();

            while (it.hasNext()) {
                var block = it.next();
                if (unionSet.contains(block)) {
                    var alias = unionSet.getAlias(block);
                    for (AsmBlock pre : block.prevs) {
                        for (AsmBaseInst inst : pre.instructions) {
                            if (inst instanceof AsmBrInst && ((AsmBrInst) inst).dest == block)
                                ((AsmBrInst) inst).dest = alias;
                            if (inst instanceof AsmJumpInst && ((AsmJumpInst) inst).dest == block)
                                ((AsmJumpInst) inst).dest = alias;
                        }
                    }

                    alias.prevs.addAll(block.prevs);
                    // nexts must be the same

                    it.remove();
                    changed = true;

                    // if entry is eliminated, the alias should swap with the first
                    if (block == function.entryBlock) {
                        function.entryBlock = alias;
                        var index = function.blocks.indexOf(alias);
                        function.blocks.set(index, function.blocks.get(0));
                        function.blocks.set(0, alias);
                    }
                }
            }
        }
    }

}
