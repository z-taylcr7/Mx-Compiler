package undecimber.compiler.middleend.opt;

import undecimber.compiler.middleend.analytics.AliasAnalyzer;
import undecimber.compiler.middleend.analytics.CFGBuilder;
import undecimber.compiler.middleend.analytics.loop.Loop;
import undecimber.compiler.middleend.analytics.loop.LoopAnalyzer;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.irnode.BrNode;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import utility.LLVM;
import utility.pass.FunctionPass;
import utility.pass.LoopPass;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class LoopInvariant implements FunctionPass, LoopPass {
    AliasAnalyzer aliasAnalyzer=new AliasAnalyzer();

    private final HashSet<IRBaseNode> motionAble = new LinkedHashSet<>();
    @Override
    public void runFunction(IRFunction func) {
        new CFGBuilder().runFunction(func);
        new LoopAnalyzer().runFunction(func);
        for (Loop loop : func.topLevelLoops) {
            runLoop(loop);
        }
    }
    private void collectMotionAble(Loop loop) {
        for (IRBlock block : loop.blocks)
            for (IRBaseNode inst : block.instructions)
                if (loop.isInstInvariant(inst, aliasAnalyzer)) motionAble.add(inst);
    }

    private void motionInst(Loop loop) {
        for (IRBaseNode inst : motionAble) {

            inst.parentBlock.instructions.remove(inst);
            loop.preHeader.addBeforeTerminator(inst);
        }

        motionAble.clear();
    }

    public void createPreHeader(Loop loop) {
        IRBlock preHeader=new IRBlock(LLVM.PreHeaderBlockLabel,loop.header.parentFunction);
        loop.preHeader = preHeader;
        ArrayList<IRBlock> headerPrevs = new ArrayList<>(loop.header.prevs);

        for (var pre : headerPrevs) {
            if (loop.tailers.contains(pre)) continue;

            preHeader.prevs.add(pre);
            loop.header.prevs.remove(pre);

            pre.redirectSucBlock(loop.header, preHeader);
            loop.header.redirectPreBlock(pre, preHeader);
        }

        new BrNode(loop.header, preHeader);
        preHeader.nexts.add(loop.header);

        Loop fa = loop.fatherLoop;
        while (fa != null) {
            fa.blocks.add(loop.preHeader);
            fa = fa.fatherLoop;
        }

        if (loop.header.parentFunction.entryBlock == loop.header)
            loop.header.parentFunction.entryBlock = preHeader;
    }
    @Override
    public void runLoop(Loop loop) {
        // motion children first
        for (Loop nestedLoop : loop.nestedLoops) {
            runLoop(nestedLoop);
        }


        createPreHeader(loop);
        while (true) {
            aliasAnalyzer.runFunction(loop.header.parentFunction);
            collectMotionAble(loop);

            if (motionAble.isEmpty()) break;
            motionInst(loop);
        }
    }
}
