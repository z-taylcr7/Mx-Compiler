package undecimber.compiler.backend.regalloc;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.insts.AsmLoadInst;
import undecimber.compiler.backend.asm.insts.AsmMvInst;
import undecimber.compiler.backend.asm.insts.AsmStoreInst;
import undecimber.compiler.backend.asm.operands.*;
import utility.UnionSet;
import utility.pass.AsmPass;

import java.util.*;

import static undecimber.compiler.backend.asm.operands.PhysicalReg.phyRegs;
import static undecimber.compiler.backend.asm.operands.PhysicalReg.reg;

public class RegAllocator implements AsmPass {
    private static final int K = PhysicalReg.assignable.size();

    private AsmFunction curFunc;

    private final UnionSet<Register> unionSet = new UnionSet<Register>();
    private final Set<Register> introducedTemp = new HashSet<>();
    /**
     * reg container
     * Registers can only present in one of these
     * Registers in coalescedNodes and selectStack are "deleted"
     */
    private final HashSet<Register>
            precolored = new LinkedHashSet<>(phyRegs.values()),
            initial = new LinkedHashSet<>(),
            coalescedNodes = new LinkedHashSet<>(),
            coloredNodes = new LinkedHashSet<>(),
            simplifyWorklist = new LinkedHashSet<>(),
            freezeWorklist = new LinkedHashSet<>(),
            spillWorklist = new LinkedHashSet<>(),
            spilledNodes = new LinkedHashSet<>();
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



    /**
     * @param block
     */
    @Override
    public void runBlock(AsmBlock block) {
        //nothing
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
            curFunc=function;
    while(true){
        init();
        new LiveAnalyzer().runFunction(curFunc);
        buildInterferenceGraph();
        makeWorklist();

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
        reGenerate();
    }else return;
}

    }

    private void assignColors() {
        while (!selectStack.empty()) {
            Register reg = selectStack.pop();
            ArrayList<PhysicalReg> Colors = new ArrayList<>(PhysicalReg.assignable);

            for (Register neighbor : reg.node.adjList) {
                var neiborAlias = unionSet.getAlias(neighbor);
                if (neiborAlias.node.preColored || coloredNodes.contains(neiborAlias))
                    Colors.remove(neiborAlias.color);
            }

            if (Colors.isEmpty()) spilledNodes.add(reg);
            else {
                coloredNodes.add(reg);
                reg.color = Colors.iterator().next();
            }
        }

        for (Register reg : coalescedNodes) {
            reg.color = unionSet.getAlias(reg).color;
        }
    }

    private void selectSpill() {

        Register minReg = null;
        double minCost = Double.POSITIVE_INFINITY;
        for (Register register : spillWorklist) {

            if(introducedTemp.contains(register))continue;
            if(minCost>register.node.priority/register.node.deg){
                minReg=register;
                minCost=register.node.priority/register.node.deg;
            };
        }
        if(minReg==null) for (Register register : spillWorklist) {
            if(minCost>register.node.priority/register.node.deg){
                minReg=register;
                minCost=register.node.priority/register.node.deg;
            };
        }
        simplifyWorklist.add(minReg);
        spillWorklist.remove(minReg);
        freezeMoves(minReg);
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

    private void coalesce() {
        var it = worklistMoves.iterator();
        AsmMvInst move = it.next();
        Register alias_dst=unionSet.getAlias(move.rd),alias_src=unionSet.getAlias(move.rs1);
        InterferenceGraph.Edge edge;
        if(alias_src.node.preColored)edge= new InterferenceGraph.Edge(alias_src,alias_dst);
            else edge=new InterferenceGraph.Edge(alias_dst,alias_src);
        it.remove();
        if(edge.isLoop()){
            coalescedMoves.remove(move);
            addWorklist(edge.u);
        } else if (edge.v.node.preColored||G.edgeList.contains(edge)) {
            constrainedMoves.add(move);
            addWorklist(edge.u);addWorklist(edge.v);
        }
        else if ((edge.u.node.preColored && George(edge.u, edge.v)) || (!edge.u.node.preColored && Briggs(edge.u, edge.v))) {
            coalescedMoves.add(move);
            combine(edge.u, edge.v);
            addWorklist(edge.u);
        }else {
            activeMoves.add(move);

        }


    }

    private boolean Briggs(Register a, Register b) {
        Set<Register>totAdj=new HashSet<>(adjacent(a));
        totAdj.addAll(adjacent(b));
        int cnt=0;
        for (Register register : totAdj) {
            if(register.node.deg>=K)cnt++;
            if(cnt>=K)return false;
        }
        return true;
    }

    private boolean George(Register a, Register b) {
        for (Register register : adjacent(a)) {
            if(register.node.deg<K||adjacent(b).contains(register))continue;
            return false;
        }
        return true;
    }

    private void simplify() {
        var it = simplifyWorklist.iterator();
        Register reg = it.next();
        // Log.track("simplify", reg);
        it.remove();
        selectStack.push(reg);
        adjacent(reg).forEach(this::removeAdjacent);
    }

    private void removeAdjacent(Register reg) {
            reg.node.deg--;
            if (reg.node.deg == K - 1) {
                //from unenable to enable
                HashSet<Register> enableMovesWorklist = new HashSet<>(adjacent(reg));
                enableMovesWorklist.add(reg);
                enableMoves(enableMovesWorklist);
                spillWorklist.remove(reg);
                if (!nodeMoves(reg).isEmpty()) freezeWorklist.add(reg);
                else simplifyWorklist.add(reg);
            }

    }

    private void enableMoves(Set<Register> enableMovesWorklist) {
            for (Register reg : enableMovesWorklist)
                for (AsmMvInst move : nodeMoves(reg))
                    if (activeMoves.contains(move)) {
                        activeMoves.remove(move);
                        worklistMoves.add(move);
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
    private void buildInterferenceGraph() {
        for (AsmBlock block : curFunc.blocks) {
            HashSet<Register>alive=new HashSet<>(block.aliveOut);

            for (int i =block.instructions.size()-1 ; i >= 0; i--) {
                AsmBaseInst inst=block.instructions.get(i);
                if(inst instanceof AsmMvInst){
                    alive.removeAll(inst.uses());
                    HashSet<Register> move=new HashSet<>();
                    move.addAll(inst.defs());
                    move.addAll(inst.uses());
                    for (Register register : move) {
                        register.node.moveList.add((AsmMvInst) inst);
                    }
                    worklistMoves.add((AsmMvInst) inst);

                }

                alive.addAll(inst.defs());
                alive.add(PhysicalReg.reg("zero"));
                for (Register def : inst.defs()) {
                    for (Register register : alive) {
                        G.addEdge(new InterferenceGraph.Edge(def,register));
                    }
                }
                alive.removeAll(inst.defs());
                alive.addAll(inst.uses());
            }

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
            removeAdjacent(t);
        }

        if (u.node.deg >= K && freezeWorklist.contains(u)) {
            freezeWorklist.remove(u);
            spillWorklist.add(u);
        }
    }
    private void addWorklist(Register reg) {
        if (!reg.node.preColored && nodeMoves(reg).isEmpty() && reg.node.deg < K) {
            freezeWorklist.remove(reg);
            simplifyWorklist.add(reg);
        }
    }
    private void reGenerate(){
        for (Register spilledNode : spilledNodes) {
            spilledNode.stackOffset=new RawStackOffset(curFunc.spillStackUse, RawStackOffset.RawType.spill);
            curFunc.spillStackUse+=4;
        }

            for (AsmBlock asmBlock : curFunc.blocks) {
                ListIterator<AsmBaseInst>iter=asmBlock.instructions.listIterator();
                while(iter.hasNext()){
                    AsmBaseInst next= iter.next();
                    for (Register use : next.uses()) {
                        if (use.stackOffset == null) continue;

                        if (!next.defs().contains(use)) {
                            if (next instanceof AsmMvInst && next.rd.stackOffset == null) {
                                // move rd reg -> load rd stackPos(sp)
                                assert use.equals(next.rs1);
                                AsmBaseInst rep = new AsmLoadInst(((VirtualReg) use).size, next.rd, PhysicalReg.reg("sp"), use.stackOffset, null);
                                iter.set(rep);
                            }
                            else {
                                VirtualReg temp = new VirtualReg(((VirtualReg) use).size);
                                AsmBaseInst rep = new AsmLoadInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                                next.replaceUse(use, temp);
                                iter.previous();
                                iter.add(rep);
                                iter.next();
                                introducedTemp.add(temp);
                            }
                        }
                        else {
                            // if it is also in defs()
                            VirtualReg temp = new VirtualReg(((VirtualReg) use).size);
                            AsmBaseInst loadInst = new AsmLoadInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                            AsmBaseInst storeInst = new AsmStoreInst(temp.size, temp, PhysicalReg.reg("sp"), use.stackOffset, null);
                            next.replaceUse(use, temp);
                            next.replaceDef(use, temp);
                            iter.previous();
                            iter.add(loadInst);
                            iter.next();
                            iter.add(storeInst);
                            introducedTemp.add(temp);
                        }
                    }

                    for (Register def : next.defs()) {
                        if (def.stackOffset == null) continue;

                        if (next.uses().contains(def)) continue;
                        else {
                            if (next instanceof AsmMvInst && next.rs1.stackOffset == null) {
                                AsmBaseInst storeInst = new AsmStoreInst(((VirtualReg) def).size, PhysicalReg.reg("sp"), next.rs1, def.stackOffset, null);
                                iter.set(storeInst);
                            } else {
                                VirtualReg temp = new VirtualReg(((VirtualReg) def).size);
                                next.replaceDef(def, temp);
                                AsmBaseInst storeInst = new AsmStoreInst(((VirtualReg) def).size, PhysicalReg.reg("sp"), temp, def.stackOffset, null);
                                iter.add(storeInst);
                                introducedTemp.add(temp);
                            }
                        }

                    }
                }

            }



    }

    private void makeWorklist() {
        var it = initial.iterator();
        while (it.hasNext()) {
            Register reg = it.next();
            it.remove();
            if (reg.node.deg >= K) spillWorklist.add(reg);
            else if (!nodeMoves(reg).isEmpty()) freezeWorklist.add(reg);
            else simplifyWorklist.add(reg);
        }
    }
    private HashSet<AsmMvInst> nodeMoves(Register reg) {
        HashSet<AsmMvInst> ret = new HashSet<>();
        reg.node.moveList.forEach(move -> {
            if (activeMoves.contains(move) || worklistMoves.contains(move))
                ret.add(move);
        });
        return ret;
    }
    private LinkedHashSet<Register> adjacent(Register reg) {
        LinkedHashSet<Register> ret = new LinkedHashSet<>(reg.node.adjList);
        selectStack.forEach(ret::remove);
        ret.removeAll(coloredNodes);
        return ret;
    }


}
