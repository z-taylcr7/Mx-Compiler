package undecimber.compiler.backend.regalloc;


import undecimber.compiler.backend.asm.*;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.*;
import undecimber.compiler.backend.asm.operands.*;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;
import utility.pass.AsmPass;

import java.util.*;
import java.util.LinkedHashSet;

public class RegAlloc implements AsmPass {

    private static final int K = PhysicalReg.assignable.size();

    // info
    private AsmFunction curFunc;
    private int curStackBase = 0;

    /*
     * reg container
     * Registers can only present in one of these
     * Registers in coalescedNodes and selectStack are "deleted"
     */
    private final Set<Register>
    precolored = new LinkedHashSet<>(PhysicalReg.phyRegs.values()),
    initial = new LinkedHashSet<>(),
    simplifyWorklist = new LinkedHashSet<>(),
    freezeWorklist = new LinkedHashSet<>(),
    spillWorklist = new LinkedHashSet<>(),
    spilledNodes = new LinkedHashSet<>(),
    coalescedNodes = new LinkedHashSet<>(),
    coloredNodes = new LinkedHashSet<>();
    private final Stack<Register> selectStack = new Stack<>();

    /* moves
     * coalescedMoves: have been coalesced.
     * constrainedMoves: rd and rs have an edge
     * frozenMoves: have been frozen, no need to consider it.
     * worklistMoves and activeMoves are moves "exists"
     */
    private final Set<AsmMvInst>
    coalescedMoves = new LinkedHashSet<>(),
    constrainedMoves = new LinkedHashSet<>(),
    frozenMoves = new LinkedHashSet<>(),
    worklistMoves = new LinkedHashSet<>(),
    activeMoves = new LinkedHashSet<>();

    /* graph */
    private final InterferenceGraph G = new InterferenceGraph();

    /* utils */
    private final Set<Register> introducedTemp = new HashSet<>();

    /**
     * @param block
     */
    @Override
    public void runBlock(AsmBlock block) {

    }

    @Override
    public void runModule(AsmModule module) {
        for (AsmFunction func : module.functions) {
            curStackBase = 0;
            runFunction(func);
            curFunc.callStackUse += curStackBase;
        }
    }

    @Override
    public void runFunction(AsmFunction function) {
        curFunc = function;
        while (true) {
            init();
            Set<Register> backupInitial = new HashSet<>(initial);

            LiveAnalyzer analyzer = new LiveAnalyzer();
            analyzer.runFunction(function);
            build(analyzer);
            makeWorklist();
            do {
                if (!simplifyWorklist.isEmpty()) simplify();
                else if (!worklistMoves.isEmpty()) coalesce();
                else if (!freezeWorklist.isEmpty()) freeze();
                else if (!spillWorklist.isEmpty()) selectSpill();
            } while (!simplifyWorklist.isEmpty() || !worklistMoves.isEmpty() || !freezeWorklist.isEmpty() || !spillWorklist.isEmpty());

            assignColors();
            if (!spilledNodes.isEmpty()) rewriteProgram();
            else {
                backupInitial.forEach(reg -> System.out.println(reg + " " + reg.color));
                break;
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

        // all physical registers are precolored
        precolored.forEach(reg -> {
            reg.color = (PhysicalReg) reg;
            reg.node.init(true);
        });

        curFunc.blocks.forEach(block -> block.instructions.forEach(inst -> {
            initial.addAll(inst.uses());
            initial.addAll(inst.defs());
        }));
        initial.removeAll(precolored);
        initial.forEach(reg -> {
            reg.color = null;
            reg.node.init(false);
        });

        // this priority calculation is quite simple
        // every reg's priority = sigma (use+def)*10^(the level of the block)
        for (AsmBlock block : curFunc.blocks) {
            double weight = Math.pow(10, Double.min(block.prevs.size(), block.nexts.size()));
            block.instructions.forEach(inst -> {
                inst.defs().forEach(def -> def.node.priority += weight);
                inst.uses().forEach(use -> use.node.priority += weight);
            });
        }
    }

    private void build(LiveAnalyzer analyzer) {
        /*
         * build the InterferenceGraph
         * for inst from tail to head because we start with "liveOut"
         * for each inst, defs and lives interference.
         * Then before move to pre inst, we do update: all defs are dead while all uses are live.
         * Notice that for Move we have to remove their uses
         */
        for (AsmBlock block : curFunc.blocks) {
            HashSet<Register> lives = new HashSet<>(block.aliveOut);
            for (int i = block.instructions.size()-1; i >= 0; i--) {
                AsmBaseInst inst = block.instructions.get(i);
                if (inst instanceof AsmMvInst) {
                    lives.removeAll(inst.uses());
                    inst.defs().forEach(reg -> reg.node.moveList.add((AsmMvInst) inst));
                    inst.uses().forEach(reg -> reg.node.moveList.add((AsmMvInst) inst));
                    worklistMoves.add((AsmMvInst) inst);
                }
                lives.addAll(inst.defs());
                for (Register def : inst.defs())
                    for (Register live : lives)
                        G.addEdge(new InterferenceGraph.Edge(def, live));
                lives.removeAll(inst.defs());
                lives.addAll(inst.uses());
            }
        }
    }

    private void makeWorklist() {
        /*
         * dispatch the node in initial to three worklists.
         */
        var it = initial.iterator();
        while (it.hasNext()) {
            Register reg = it.next();
            it.remove();
            if (reg.node.deg >= K) spillWorklist.add(reg);
            else if (moveRelated(reg)) freezeWorklist.add(reg);
            else simplifyWorklist.add(reg);
        }
    }

    private void enableMoves(Set<Register> regs) {
        /*
         * enable a move: from activeMoves to worklist
         */
        for (Register reg : regs)
            for (AsmMvInst move : nodeMoves(reg))
                if (activeMoves.contains(move)) {
                    activeMoves.remove(move);
                    worklistMoves.add(move);
                }
    }

    private void decrementDegree(Register reg) {
        /*
         * decrease the degree of reg
         * if the degree from K to K-1, then the moves of the adjacent nodes is possible to be enabled.
         */
        reg.node.deg--;
        if (reg.node.deg < K) {
            HashSet<Register> enableMovesWorklist = new HashSet<>(adjacent(reg));
            enableMovesWorklist.add(reg);
            enableMoves(enableMovesWorklist);
            spillWorklist.remove(reg);
            if (moveRelated(reg)) freezeWorklist.add(reg);
            else simplifyWorklist.add(reg);
        }
    }

    private void simplify() {
        /*
         * delete a node in simplifyWorklist, and decrement degree of its adjacent.
         */
        var it = simplifyWorklist.iterator();
        Register reg = it.next();
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
        v.node.alias = u;
        u.node.moveList.addAll(v.node.moveList);
        enableMoves(Collections.singleton(v));
        for (Register t : adjacent(v)) {
            G.addEdge(new InterferenceGraph.Edge(t, u));
            decrementDegree(t);
        }
        if (u.node.deg>= K && freezeWorklist.contains(u)) {
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }

    private void coalesce() {
        /*
         * a union-set coalesce algorithm
         */
        var it = worklistMoves.iterator();
        AsmMvInst move = it.next();
        Register rdAlias = getAlias(move.rd), rs1Alias = getAlias(move.rs1);
        InterferenceGraph.Edge edge;
        if (rs1Alias.node.preColored) edge =new   InterferenceGraph.Edge(rs1Alias, rdAlias);
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
        else if ((edge.u.node.preColored && georgeStrategy(edge.u, edge.v))
                 || (!edge.u.node.preColored && conservative(adjacent(edge.u, edge.v)))) { // briggs strategy
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
            if (getAlias(u) == getAlias(move.rs1)) v = getAlias(move.rd);
            else v = getAlias(move.rs1);
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
        Register u = it.next();
        it.remove();
        simplifyWorklist.add(u);
        freezeMoves(u);
    }

    private void selectSpill() {
        Register minReg = null;
        double minCost = Double.POSITIVE_INFINITY;
        for (Register reg : spillWorklist) {
            if (introducedTemp.contains(reg)) continue;
            double regCost = reg.node.priority / reg.node.deg;
            if (regCost < minCost) {
                minReg = reg;
                minCost = reg.node.priority;
            }
        }
        spillWorklist.remove(minReg);
        simplifyWorklist.add(minReg);
        freezeMoves(minReg);
//        var it=spillWorklist.iterator();
//        var chosen=it.next();
//        it.remove();
//        simplifyWorklist.add(chosen);
//        freezeMoves(chosen);
    }

    private void assignColors() {
        while (!selectStack.empty()) {
            Register n = selectStack.pop();
            HashSet<PhysicalReg> okColors = new HashSet<>(PhysicalReg.assignable);
            HashSet<Register> coloredSet = new HashSet<>(precolored);
            coloredSet.addAll(coloredNodes);
            for (Register w : n.node.adjList) {
                if (coloredSet.contains(getAlias(w)))
                    okColors.remove(getAlias(w).color);
            }
            if (okColors.isEmpty()) spillWorklist.add(n);
            else {
                coloredNodes.add(n);
                n.color = okColors.iterator().next();
            }
        }

        for (Register n : coalescedNodes) n.color = getAlias(n).color;
    }

    private void rewriteProgram() {
        // really a big job...
        // allocate stack space for these nodes
        for (Register reg : spilledNodes) {
            curStackBase += 4;
            if (curStackBase > RV32I.MaxStackSize) throw new StackOverflowError();
            reg.stackOffset = new StackOffset(curStackBase, 1, curFunc);
        }

        Set<Register> newTemps = new HashSet<>();

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
                            AsmBaseInst loadInst = new AsmLoadInst(((VirtualReg) inst.rd).size, inst.rd, PhysicalReg.reg("sp"), use.stackOffset, null);
                            it.set(loadInst);
                        }
                        else {
                            VirtualReg temp = new VirtualReg(((VirtualReg) use).size);
                            AsmBaseInst loadInst = new AsmLoadInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                            inst.replaceUse(use, temp); // will it miss?
                            it.previous();
                            it.add(loadInst);
                            it.next();
                            newTemps.add(temp);
                        }
                    }
                    else {
                        // if it is also in defs
                        VirtualReg temp = new VirtualReg(((VirtualReg) use).size);
                        AsmBaseInst loadInst = new AsmLoadInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                        AsmBaseInst storeInst = new AsmStoreInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                        inst.replaceUse(use, temp);
                        inst.replaceDef(use, temp);
                        it.previous();
                        it.add(loadInst);
                        it.next();
                        it.add(storeInst);
                        newTemps.add(temp);
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
                        newTemps.add(temp);
                    }
                }
            }
            introducedTemp.addAll(newTemps);
        }
    }

    /* tool functions */
    private HashSet<Register> adjacent(Register reg) {
        /*
         * return a set of adjacent nodes
         * notice that here we should move nodes in selectStack and coalescedNodes (which is considered to be deleted)
         */
        HashSet<Register> ret = new HashSet<>(reg.node.adjList);
        selectStack.forEach(ret::remove);
        ret.removeAll(coalescedNodes);
        return ret;
    }

    private HashSet<Register> adjacent(Register reg1, Register reg2) {
        /*
         * return a set of adjacent nodes
         * notice that here we should move nodes in selectStack and coalescedNodes (which is considered to be deleted)
         */
        HashSet<Register> ret = new HashSet<>(adjacent(reg1));
        ret.addAll(adjacent(reg2));
        return ret;
    }

    private HashSet<AsmMvInst> nodeMoves(Register reg) {
        /*
         * return a set of this nodes move insts
         * only those in workList or active are valid.
         */
        HashSet<AsmMvInst> ret = new HashSet<>(activeMoves);
        ret.addAll(worklistMoves);
        ret.retainAll(reg.node.moveList);
        return ret;
    }

    private boolean moveRelated(Register reg) {
        return !nodeMoves(reg).isEmpty();
    }

    private boolean ok(Register t, Register r) {
        return t.node.deg < K || t.node.preColored || G.edgeList.contains(new InterferenceGraph.Edge(t, r));
    }

    private boolean georgeStrategy(Register u, Register v) {
        for (Register t : adjacent(v)) if (!ok(t, u)) return false;
        return true;
    }

    private boolean conservative(HashSet<Register> regs) {
        // a conservative strategy
        int k = 0;
        for (Register reg : regs)
            if (reg.node.deg >= K) k++;
        return k < K;
    }

    private Register getAlias(Register reg) {
        /*
         * like a union-set
         */
        if (coalescedNodes.contains(reg)) {
            var ret = getAlias(reg.node.alias);
            ret.node.alias = ret;
            return ret;
        }
        return reg;
    }
}
