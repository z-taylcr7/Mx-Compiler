package undecimber.compiler.middleend.analytics.loop;



import org.antlr.v4.runtime.misc.Pair;
import undecimber.compiler.middleend.analytics.CFGBuilder;
import undecimber.compiler.middleend.analytics.DomTreeBuilder;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import utility.pass.FunctionPass;

import java.util.*;

public class LoopAnalyzer implements FunctionPass {

    // <head, tail>
    private Map<IRBlock, Loop> headToLoopMap = new HashMap<>();
    private ArrayList<Pair<IRBlock, IRBlock>> backEdge = new ArrayList<>();

    private void init(IRFunction function) {
        new CFGBuilder().runFunction(function);
        new DomTreeBuilder(false).runFunction(function);
        function.topLevelLoops.clear();
        function.blockList.forEach(block -> {
            block.loopDepth = 0;
            block.belongLoop = null;
        });
    }

    private void collectBackEdge(IRFunction function) {
        for (IRBlock block : function.blockList) {
            for (IRBlock suc : block.nexts) {
                if (block.dtNode.doms.contains(suc.dtNode)) {
                    backEdge.add(new Pair<>(suc, block));
                    break;
                }
            }
        }
    }

    private void buildNaturalLoop(IRBlock edgeHead, IRBlock edgeTail) {
        headToLoopMap.putIfAbsent(edgeHead, new Loop(edgeHead));
        headToLoopMap.get(edgeHead).tailers.add(edgeTail);
        headToLoopMap.get(edgeHead).addBlock(edgeHead);
        headToLoopMap.get(edgeHead).addBlock(edgeTail);

        Queue<IRBlock> workQueue = new LinkedList<>();
        workQueue.offer(edgeTail);

        while (!workQueue.isEmpty()) {
            IRBlock nowBlock = workQueue.poll();
            for (IRBlock pre : nowBlock.prevs)
                if (!headToLoopMap.get(edgeHead).blocks.contains(pre)) {
                    headToLoopMap.get(edgeHead).addBlock(pre);
                    workQueue.offer(pre);
                }
        }
    }

    private Stack<Loop> loopStack = new Stack<>();
    private HashSet<IRBlock> visited = new HashSet<>();

    private void buildLoopNestTree(IRFunction function, IRBlock block) {
        if (visited.contains(block)) return;
        visited.add(block);

        // Log.info("build", block.identifier());

        // filter the inner loop
        Loop outerLoop = null;
        if (!loopStack.empty()) {
            outerLoop = loopStack.peek();
            while (!outerLoop.blocks.contains(block)) {
                loopStack.pop();
                if (loopStack.empty()) {
                    outerLoop = null;
                    break;
                }
                outerLoop = loopStack.peek();
            }
        }

        if (headToLoopMap.containsKey(block)) {
            var nowLoop = headToLoopMap.get(block);
            if (outerLoop != null) {
                outerLoop.addNestedLoop(nowLoop);
            }
            else {
                function.topLevelLoops.add(nowLoop);
            }
            loopStack.push(nowLoop);
        }

        block.loopDepth = loopStack.size();

        for (IRBlock suc : block.nexts) buildLoopNestTree(function, suc);
    }

    @Override
    public void runFunction(IRFunction function) {

        init(function);

        collectBackEdge(function);

        backEdge.forEach(edge -> buildNaturalLoop(edge.a, edge.b));
        buildLoopNestTree(function, function.entryBlock);

    }
}