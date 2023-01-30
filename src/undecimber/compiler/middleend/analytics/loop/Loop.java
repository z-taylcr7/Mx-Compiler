package undecimber.compiler.middleend.analytics.loop;


import undecimber.compiler.middleend.analytics.AliasAnalyzer;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irconst.IRConst;
import undecimber.compiler.middleend.llvmir.irnode.*;

import java.util.HashSet;

public class Loop {
    public IRBlock preHeader;
    public IRBlock header;
    public HashSet<IRBlock> tailers = new HashSet<>();
    public HashSet<IRBlock> blocks = new HashSet<>();

    public Loop fatherLoop;
    public HashSet<Loop> nestedLoops = new HashSet<>();

    public Loop(IRBlock header) {
        this.header = header;
    }

    public void addBlock(IRBlock block) {
        block.belongLoop = this;
        this.blocks.add(block);
    }

    public void addNestedLoop(Loop subLoop) {
        this.nestedLoops.add(subLoop);
        subLoop.fatherLoop = this;
    }

    public boolean isInvariant(Value value) {
        // const: true
        if (value instanceof IRConst) return true;

        // inst: no def in loop
        if (value instanceof IRBaseNode) {
            return !blocks.contains(((IRBaseNode) value).parentBlock);
        }

        // warning: no move
        for (MoveNode move : value.moveDefs) {
            if (blocks.contains(move.parentBlock)) return false;
        }

        return true;
    }

    public boolean notModified(LoadNode inst, AliasAnalyzer analyzer) {
        for (IRBlock block : this.blocks)
            for (IRBaseNode inst1 : block.instructions) {
                if (inst1 instanceof StoreNode &&
                        analyzer.mayAlias(inst.getLoadAddr(), ((StoreNode) inst1).getStorePtr())) {
                    return false;
                }

                if (inst1 instanceof CallNode) return false;
            }
        return true;
    }

    public boolean isInstInvariant(IRBaseNode inst, AliasAnalyzer analyzer) {
        if ((inst.mayHaveSideEffects() && !(inst instanceof LoadNode)) || !inst.isValueSelf()) return false;

        for (Value operand : inst.operands) {
            if (!this.isInvariant(operand)) {
                // Log.mark("not invariant");
                // Log.info(inst.format());
                // Log.info(operand.identifier());
                return false;
            }
        }

        if (inst instanceof LoadNode) {
            return notModified((LoadNode) inst, analyzer);
        }

        return true;
    }
}
