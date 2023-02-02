package undecimber.compiler.middleend.analytics;


import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import utility.pass.FunctionPass;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class DomTreeBuilder implements FunctionPass {

    private final boolean postDomTree;

    private IRBlock startBlock;

    public DomTreeBuilder(boolean postDomTree) {


        this.postDomTree = postDomTree;
    }

    @Override
    public void runFunction(IRFunction function) {
        init(function);
        startBlock = postDomTree ? function.exitBlock : function.entryBlock;

        sortByRPO(startBlock);
        Collections.reverse(blocksInRPO);
        for (int i = 0; i < blocksInRPO.size(); i++)
            blocksInRPO.get(i).dtNode.order = i;// rpo

        calculateIDom(function);//immediate dom
        calculateDF(function);//Dom Frontier
        calculateDoms(startBlock);
    }

    public static class Node {
        public int order;
        public IRBlock fromBlock;
        public Node idom;
        public List<Node> sons;
        public HashSet<Node> doms;
        public List<IRBlock> domFrontier;

        public Node(IRBlock fromBlock) {
            this.fromBlock = fromBlock;
        }

        public void init() {
            order = 0;
            idom = null;
            sons = new ArrayList<>();
            doms = new HashSet<>();
            domFrontier = new ArrayList<>();
        }
    }

    private final ArrayList<IRBlock> blocksInRPO = new ArrayList<>();

    private final HashSet<IRBlock> visited = new HashSet<>();

    private void init(IRFunction function) {
        function.blockList.forEach(block -> block.dtNode.init());
    }

    private void sortByRPO(IRBlock block) {//reverse post order
        visited.add(block);

        var realNext = postDomTree ? block.prevs : block.nexts;

        for (IRBlock suc : realNext)
            if (!visited.contains(suc)) sortByRPO(suc);
        blocksInRPO.add(block);
    }

    private Node intersect(Node u, Node v) {
        /*
         * LCA in DomTree
         */
        while (u != v) {
            while (u.order > v.order) u = u.idom;
            while (u.order < v.order) v = v.idom;
        }
        return u;
    }

    private void calculateIDom(IRFunction function) {
        DomTreeBuilder.Node startNode = startBlock.dtNode;
        startNode.idom = startNode;
        boolean changed = true;
        while (changed) {
            changed = false;
            for (IRBlock block : blocksInRPO) {
                if (block.dtNode == startNode) continue;
                Node newIdom = null;
                var truePrevs = postDomTree ? block.nexts : block.prevs;
                for (IRBlock pred : truePrevs) {
                    //to calculate the intersect of all the predecessors
                    if (pred.dtNode.idom == null) continue;
                    if (newIdom == null) newIdom = pred.dtNode;
                    else newIdom = intersect(newIdom, pred.dtNode);
                }
                if (block.dtNode.idom != newIdom) {
                    block.dtNode.idom = newIdom;
                    changed = true;
                }
            }
        }

        for (IRBlock block : function.blockList) {
            if (block.dtNode != startNode && block.dtNode.idom != null) {
                block.dtNode.idom.sons.add(block.dtNode);
            }
        }
    }

    private void calculateDF(IRFunction function) {
        for (IRBlock block : function.blockList) {
            var truePrevs = postDomTree ? block.nexts : block.prevs;
            if (truePrevs.size() < 2) continue;
            for (IRBlock pred : truePrevs) {
               Node runner = pred.dtNode;
                while (runner != block.dtNode.idom && runner != null) {
                    runner.domFrontier.add(block);
                    runner = runner.idom;
                }
            }
        }
    }

    private void calculateDoms(IRBlock block) {
        if (block.dtNode.idom != null) {
            block.dtNode.doms.addAll(block.dtNode.idom.doms);
        }
        block.dtNode.doms.add(block.dtNode.idom);
        for (Node son : block.dtNode.sons) {
            calculateDoms(son.fromBlock);
        }
    }
}
