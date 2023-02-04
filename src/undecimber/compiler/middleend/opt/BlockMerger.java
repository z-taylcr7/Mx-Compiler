package undecimber.compiler.middleend.opt;


import undecimber.compiler.middleend.analytics.CFGBuilder;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.irnode.BrNode;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import utility.pass.FunctionPass;

import java.util.HashSet;

/**
 *  This pass simplifies CFG (control flow graph) by:
 *
 *  1. remove unreachable block
 *  2. merge blockList
 *
 * @requirement: CFGBuilder
 */

public class BlockMerger implements FunctionPass {
    private boolean removeUnreachableBlock(IRFunction function) {
        HashSet<IRBlock> toRemoveSet = new HashSet<>();

        boolean removed = true;
        while (removed) {
            removed = false;
            for (IRBlock block : function.blockList) {
                if (block == function.entryBlock) continue;

                if (toRemoveSet.contains(block)) continue;

                if (block.prevs.isEmpty()) {
                    toRemoveSet.add(block);
                    for (IRBlock suc : block.nexts) {
                        suc.prevs.remove(block);
                    }
                    removed = true;
                }
            }
        }

        for (IRBlock toRemove : toRemoveSet) {
            assert toRemove != function.exitBlock;

            // Log.info("removeUnreachable", toRemove.identifier());

            function.blockList.remove(toRemove);

            for (IRBlock suc : toRemove.nexts) {
                suc.prevs.remove(toRemove);
                suc.removePhiBranch(toRemove);
            }

            toRemove.prevs.clear();
            toRemove.nexts.clear();
        }

        return toRemoveSet.size() > 1;
    }

    //eliminate --block--
    private boolean mergeBlocks(IRFunction function) {
        HashSet<IRBlock> toMergeSet = new HashSet<>(); // merge with pre

        function.blockList.forEach(block -> {
            if (block.prevs.size() == 1 && block.prevs.get(0).nexts.size() == 1) {
                assert block.prevs.get(0).nexts.get(0) == block;
                toMergeSet.add(block);
            }
        });

        boolean changed = false;

        while (!toMergeSet.isEmpty()) {
            var it = toMergeSet.iterator();
            while (it.hasNext()) {
                var beMerged = it.next();
                IRBlock preBlock = beMerged.prevs.get(0);
                if (toMergeSet.contains(preBlock)) continue;

                // Log.info("merged", preBlock.identifier(), beMerged.identifier());
                // beMerged.nexts.forEach(suc -> Log.info(suc.identifier()));

                var preTerminator = preBlock.terminator();

                // 1 nexts, must be Jmp
                assert preTerminator instanceof BrNode && ((BrNode) preTerminator).IsJump();

                preBlock.nexts.remove(beMerged);
                preBlock.instructions.remove(preTerminator);
                preBlock.isTerminatedNode = false;

                preBlock.nexts.addAll(beMerged.nexts);
                for (IRBlock suc : beMerged.nexts) {
                    suc.redirectPreBlock(beMerged, preBlock);
                }

                // will it have phi?
                for (IRBaseNode phi : beMerged.PhiInstructions) phi.setParentBlock(preBlock);

                // terminate it also
                for (IRBaseNode inst : beMerged.instructions) inst.setParentBlock(preBlock);

                if (function.exitBlock == beMerged) function.exitBlock = preBlock;

                function.blockList.remove(beMerged);
                it.remove();

                changed = true;
            }
        }

        return changed;
    }

    @Override
    public void runFunction(IRFunction function) {
        boolean changed = true;

        while (changed) {
            new CFGBuilder().runFunction(function);
            changed = mergeBlocks(function);
            changed |= removeUnreachableBlock(function);
        }
    }
}
