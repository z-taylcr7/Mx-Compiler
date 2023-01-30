package undecimber.compiler.backend.regalloc;


import undecimber.compiler.backend.asm.*;
import undecimber.compiler.backend.asm.insts.*;
import undecimber.compiler.backend.asm.operands.*;
import utility.UnionSet;
import utility.pass.AsmPass;

import java.util.*;

import static undecimber.compiler.backend.asm.operands.PhysicalReg.phyRegs;

public class RegisterAllocator implements AsmPass {

    private static final int K = PhysicalReg.assignable.size();

    private AsmFunction curFunc;

    /**
     * reg container
     * Registers can only present in one of these
     * Registers in coalescedNodes and selectStack are "deleted"
     */
    private final HashSet<Register>
            preColored = new LinkedHashSet<>(phyRegs.values()),
            initial = new LinkedHashSet<>(),
            simplifyWorklist = new LinkedHashSet<>(),
            freezeWorklist = new LinkedHashSet<>(),
            spillWorklist = new LinkedHashSet<>(),
            spilledNodes = new LinkedHashSet<>(),
            coalescedNodes = new LinkedHashSet<>(),
            coloredNodes = new LinkedHashSet<>();
    private final Stack<Register> selectStack = new Stack<>();

    /**
     * moves
     * coalescedMoves: have been coalesced.
     * constrainedMoves: rd and rs have an edge
     * frozenMoves: have been frozen, no need to consider it.
     * worklistMoves and activeMoves are moves "exists"
     */
    private final HashSet<AsmMvInst>
            coalescedMoves = new LinkedHashSet<>(),
            constrainedMoves = new LinkedHashSet<>(),
            frozenMoves = new LinkedHashSet<>(),
            worklistMoves = new LinkedHashSet<>(),
            activeMoves = new LinkedHashSet<>();

    /* graph */
    private final InterferenceGraph G = new InterferenceGraph();

    /* utils */
    private final UnionSet<Register> unionSet = new UnionSet<Register>();
    private final Set<Register> introducedTemp = new HashSet<>();

    @Override
    public void runBlock(AsmBlock block) {
        
    }

    @Override
    public void runModule(AsmModule module) {

        module.functions.forEach(this::runFunction);
    }

    @Override
    public void runFunction(AsmFunction function) {

        curFunc = function;

        while (true) {
            init();


            new LiveAnalyzer().runFunction(function);
            build();

            makeWorklist();
            /*
            Log.report("simplify", simplifyWorklist);
            Log.report("freeze", freezeWorklist);
            Log.report("spill", spillWorklist);
            */

            do {
                if (!simplifyWorklist.isEmpty()) simplify();
                else if (!worklistMoves.isEmpty()) coalesce();
                else if (!freezeWorklist.isEmpty()) freeze();
                else if (!spillWorklist.isEmpty()) selectSpill();
            } while (!simplifyWorklist.isEmpty() ||
                    !worklistMoves.isEmpty() ||
                    !freezeWorklist.isEmpty() ||
                    !spillWorklist.isEmpty());

            assignColors();

            if (!spilledNodes.isEmpty()) {

                rewriteProgram();

               
            }
            else {

                
                return;
            }
        }
    }

    private void init() {
        initial.clear();
        simplifyWorklist.clear();
        freezeWorklist.clear();
        spillWorklist.clear();
        spilledNodes.clear();
        coalescedNodes.clear();
        coloredNodes.clear();
        selectStack.clear();

        coalescedMoves.clear();
        constrainedMoves.clear();
        frozenMoves.clear();
        worklistMoves.clear();
        activeMoves.clear();

        // init the graph
        G.reset();

        // all physical registers are preColored
        preColored.forEach(reg -> {
            reg.color = (PhysicalReg) reg;
            reg.node.init(true);
        });

        curFunc.blocks.forEach(block -> block.instructions.forEach(inst -> {
            initial.addAll(inst.uses());
            initial.addAll(inst.defs());
        }));
        initial.removeAll(preColored);
        initial.forEach(reg -> {
            reg.color = null;
            reg.node.init(false);
            unionSet.remove(reg);
        });

        // this priority calculation is quite simple
        // every reg's priority = sigma (use+def)*10^(the level of the block)

        for (AsmBlock block : curFunc.blocks) {
            double weight = Math.pow(10, block.loopDepth);
            block.instructions.forEach(inst -> {
                inst.defs().forEach(def -> def.node.priority += weight);
                inst.uses().forEach(use -> use.node.priority += weight);
            });
        }
    }

    /**
     * build the InterferenceGraph
     * for inst from tail to head because we start with "liveOut"
     * for each inst, defs() and lives interference.
     * Then before move to pre inst, we do update: all defs() are dead while all uses() are live.
     * Notice that for Move we have to remove their uses()
     */
    private void build() {

        for (AsmBlock block : curFunc.blocks) {
            HashSet<Register> lives = new HashSet<>(block.aliveOut);

            for (int i = block.instructions.size()-1; i >= 0; i--) {
                AsmBaseInst inst = block.instructions.get(i);
                if (inst instanceof AsmMvInst) {
                    lives.removeAll(inst.uses());
                    HashSet<Register> moveRelated = new HashSet<>(inst.defs());
                    moveRelated.addAll(inst.uses());
                    moveRelated.forEach(reg -> reg.node.moveList.add((AsmMvInst) inst));
                    worklistMoves.add((AsmMvInst) inst);
                }

                lives.add(PhysicalReg.reg("zero"));
                lives.addAll(inst.defs());

                for (Register def : inst.defs())
                    for (Register live : lives)
                        G.addEdge(new InterferenceGraph.Edge(def, live));

                lives.removeAll(inst.defs());
                lives.addAll(inst.uses());
            }
        }
    }

    /**
     * dispatch the node in initial to three worklists.
     */
    private void makeWorklist() {
        var it = initial.iterator();
        while (it.hasNext()) {
            Register reg = it.next();
            it.remove();
            if (reg.node.deg >= K) spillWorklist.add(reg);
            else if (moveRelated(reg)) freezeWorklist.add(reg);
            else simplifyWorklist.add(reg);
        }
    }

    /**
     * enable a move: from activeMoves to worklist
     */
    private void enableMoves(Set<Register> regs) {
        for (Register reg : regs)
            for (AsmMvInst move : nodeMoves(reg))
                if (activeMoves.contains(move)) {
                    activeMoves.remove(move);
                    worklistMoves.add(move);
                }
    }

    /**
     * decrease the degree of reg
     * if the degree from K to K-1, then the moves of the adjacent nodes is possible to be enabled.
     */
    private void decrementDegree(Register reg) {
        int d = reg.node.deg;
        reg.node.deg--;
        if (d == K) {
            HashSet<Register> enableMovesWorklist = new HashSet<>(adjacent(reg));
            enableMovesWorklist.add(reg);
            enableMoves(enableMovesWorklist);
            spillWorklist.remove(reg);
            if (moveRelated(reg)) freezeWorklist.add(reg);
            else simplifyWorklist.add(reg);
        }
    }

    /**
     * delete a node in simplifyWorklist, and decrement degree of its adjacent.
     */
    private void simplify() {
        var it = simplifyWorklist.iterator();
        Register reg = it.next();
        // Log.track("simplify", reg);
        it.remove();
        selectStack.push(reg);
        adjacent(reg).forEach(this::decrementDegree);
    }

    private void addWorklist(Register reg) {
        if (!reg.node.preColored && !moveRelated(reg) && reg.node.deg < K) {
            freezeWorklist.remove(reg);
            simplifyWorklist.add(reg);
        }
    }

    private void combine(Register u, Register v) {
        if (freezeWorklist.contains(v)) freezeWorklist.remove(v);
        else spillWorklist.remove(v);
        coalescedNodes.add(v);
        unionSet.setAlias(v, u); // v -> u
        u.node.moveList.addAll(v.node.moveList);
        enableMoves(Collections.singleton(v));

        for (Register t : adjacent(v)) {
            G.addEdge(new InterferenceGraph.Edge(t, u));
            decrementDegree(t);
        }

        if (u.node.deg >= K && freezeWorklist.contains(u)) {
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }

    /**
     * a union-set coalesce algorithm
     */
    private void coalesce() {
        var it = worklistMoves.iterator();
        AsmMvInst move = it.next();

        // Log.track("coalesce", move.rd, move.rs1);

        Register rdAlias = unionSet.getAlias(move.rd), rs1Alias = unionSet.getAlias(move.rs1);
        InterferenceGraph.Edge edge;
        if (rs1Alias.node.preColored) edge = new InterferenceGraph.Edge(rs1Alias, rdAlias);
        else edge = new InterferenceGraph.Edge(rdAlias, rs1Alias);
        it.remove();

        if (edge.isLoop()) {
            coalescedMoves.remove(move);
            addWorklist(edge.u);
        }
        else if (edge.v.node.preColored || G.edgeList.contains(edge)) {
            constrainedMoves.add(move);
            addWorklist(edge.u);
            addWorklist(edge.v);
        }
        else if ((edge.u.node.preColored && georgeCriterion(edge.u, edge.v))
                || (!edge.u.node.preColored && briggsCriterion(edge.u, edge.v))) { // briggs strategy
            coalescedMoves.add(move);

            combine(edge.u, edge.v);
            addWorklist(edge.u);
        }
        else {
            activeMoves.add(move);
        }
    }

    private void freezeMoves(Register u) {
        for (AsmMvInst move : nodeMoves(u)) {
            Register v;
            if (unionSet.getAlias(u) == unionSet.getAlias(move.rs1)) v = unionSet.getAlias(move.rd);
            else v = unionSet.getAlias(move.rs1);
            activeMoves.remove(move);
            frozenMoves.add(move);
            if (nodeMoves(v).isEmpty() && v.node.deg < K) {
                freezeWorklist.remove(v);
                simplifyWorklist.add(v);
            }
        }
    }

    private void freeze() {
        var it = freezeWorklist.iterator();
        Register reg = it.next();
        // Log.track("freeze", reg);
        it.remove();
        simplifyWorklist.add(reg);
        freezeMoves(reg);
    }

    /**
     * selectSpill: using simple heuristic to select
     */
    private void selectSpill() {

        Register minReg = null;
        double minCost = Double.POSITIVE_INFINITY;
        for (Register reg : spillWorklist) {
            if (introducedTemp.contains(reg)) continue;
            double regCost = reg.node.priority / reg.node.deg;
            if (regCost < minCost) {
                minReg = reg;
                minCost = regCost;
            }
        }
        // those introduced by rewrite
        if (minReg == null) {
            for (Register reg : spillWorklist) {
                double regCost = reg.node.priority / reg.node.deg;
                if (regCost < minCost) {
                    minReg = reg;
                    minCost = regCost;
                }
            }
        }

//        Statistics.plus("spill");

        spillWorklist.remove(minReg);
        simplifyWorklist.add(minReg);
        freezeMoves(minReg);
    }

    private void assignColors() {
        while (!selectStack.empty()) {
            Register reg = selectStack.pop();
            ArrayList<PhysicalReg> okColors = new ArrayList<>(PhysicalReg.assignable);

            for (Register neighbor : reg.node.adjList) {
                var neiborAlias = unionSet.getAlias(neighbor);
                if (neiborAlias.node.preColored || coloredNodes.contains(neiborAlias))
                    okColors.remove(neiborAlias.color);
            }

            if (okColors.isEmpty()) spilledNodes.add(reg);
            else {
                coloredNodes.add(reg);
                reg.color = okColors.iterator().next();
            }
        }

        for (Register reg : coalescedNodes) {
            reg.color = unionSet.getAlias(reg).color;
        }
    }

    /**
     * rewrite the program. mainly for:
     * 1. allocate stack space for these nodes
     * 2. insert load/store for nodes (will introduce temps in this step)
     */
    private void rewriteProgram() {
        // Log.track("rewrite");

        for (Register reg : spilledNodes) {
            reg.stackOffset = new RawStackOffset(curFunc.spillStackUse, RawStackOffset.RawType.spill);
            curFunc.spillStackUse += 4;
        }

        for (AsmBlock block : curFunc.blocks) {
            ListIterator<AsmBaseInst> it = block.instructions.listIterator();
            // instruction insert & delete, use iterator

            while (it.hasNext()) {
                AsmBaseInst inst = it.next();

                for (Register use : inst.uses()) {
                    if (use.stackOffset == null) continue;

                    if (!inst.defs().contains(use)) {
                        if (inst instanceof AsmMvInst && inst.rd.stackOffset == null) {
                            // move rd reg -> load rd stackPos(sp)
                            assert use.equals(inst.rs1);
                            AsmBaseInst loadInst = new AsmLoadInst(((VirtualReg) use).size, inst.rd, PhysicalReg.reg("sp"), use.stackOffset, null);
                            it.set(loadInst);
                        }
                        else {
                            VirtualReg temp = new VirtualReg(((VirtualReg) use).size);
                            AsmBaseInst loadInst = new AsmLoadInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                            inst.replaceUse(use, temp); // will it miss?
                            it.previous();
                            it.add(loadInst);
                            it.next();
                            introducedTemp.add(temp);
                        }
                    }
                    else {
                        // if it is also in defs()
                        VirtualReg temp = new VirtualReg(((VirtualReg) use).size);
                        AsmBaseInst loadInst = new AsmLoadInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                        AsmBaseInst storeInst = new AsmStoreInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                        inst.replaceUse(use, temp);
                        inst.replaceDef(use, temp);
                        it.previous();
                        it.add(loadInst);
                        it.next();
                        it.add(storeInst);
                        introducedTemp.add(temp);
                    }
                }

                for (Register def : inst.defs()) {
                    if (def.stackOffset == null) continue;

                    if (inst.uses().contains(def)) continue; // has been considered previously
                    if (inst instanceof AsmMvInst && inst.rs1.stackOffset == null) {
                        AsmBaseInst storeInst = new AsmStoreInst(((VirtualReg) def).size, PhysicalReg.reg("sp"), inst.rs1, def.stackOffset, null);
                        it.set(storeInst);
                    } else {
                        VirtualReg temp = new VirtualReg(((VirtualReg) def).size);
                        inst.replaceDef(def, temp);
                        AsmBaseInst storeInst = new AsmStoreInst(((VirtualReg) def).size, PhysicalReg.reg("sp"), temp, def.stackOffset, null);
                        it.add(storeInst);
                        introducedTemp.add(temp);
                    }
                }
            }
        }
    }

    /* tool functions */

    /**
     * return a set of adjacent nodes
     * notice that here we should move nodes in selectStack and coalescedNodes (which is considered to be deleted)
     */
    private LinkedHashSet<Register> adjacent(Register reg) {
        LinkedHashSet<Register> ret = new LinkedHashSet<>(reg.node.adjList);
        selectStack.forEach(ret::remove);
        ret.removeAll(coloredNodes);
        return ret;
    }

    /**
     * return a set of this nodes move insts
     * only those in workList or active are valid.
     * warning: adjList < worklistMoves, so use this to make program faster
     */
    private HashSet<AsmMvInst> nodeMoves(Register reg) {
        HashSet<AsmMvInst> ret = new HashSet<>();
        reg.node.moveList.forEach(move -> {
            if (activeMoves.contains(move) || worklistMoves.contains(move))
                ret.add(move);
        });
        return ret;
    }

    private boolean moveRelated(Register reg) {
        return !nodeMoves(reg).isEmpty();
    }

    private boolean ok(Register t, Register r) {
        return t.node.deg < K || t.node.preColored || G.edgeList.contains(new InterferenceGraph.Edge(t, r));
    }

    private boolean georgeCriterion(Register u, Register v) {
        for (Register t : adjacent(v)) if (!ok(t, u)) return false;
        return true;
    }

    /**
     * a conservative strategy
     */
    private boolean briggsCriterion(Register u, Register v) {
        int k = 0;

        Set<Register> commonAdj = new HashSet<>(adjacent(u));
        commonAdj.addAll(adjacent(v));

        for (var n : commonAdj)
            if (n.node.deg >= K) k++;

        return k < K;
    }
}