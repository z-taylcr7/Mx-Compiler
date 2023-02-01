package undecimber.compiler.middleend.opt.ssa;


import undecimber.compiler.middleend.analytics.CFGBuilder;
import undecimber.compiler.middleend.analytics.CFG_Builder;
import undecimber.compiler.middleend.analytics.DTBuilder;
import undecimber.compiler.middleend.analytics.DomTreeBuilder;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.User;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irconst.GlobalVariable;
import undecimber.compiler.middleend.llvmir.irconst.NullConst;
import undecimber.compiler.middleend.llvmir.irnode.*;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;
import utility.LLVM;
import utility.pass.FunctionPass;

import java.util.*;

/**
 * implement a simple Mem2Reg Pass
 * eliminate AllocaInst, and remove some load/store
 *
 * @requirement: CFGBuilder, DomTreeBuilder
 *
 * @reference:
 *      DomTree algorithm is based on the book "Engineering a Compiler"
 *      variable renaming part is based on SSA Book
 */

public class MemToReg implements FunctionPass {

    private final ArrayList<IRBaseNode> allocated = new ArrayList<>();

    private final Map<String, Stack<Value>> nameStack = new HashMap<>();

    private final Map<PhiNode, String> phiAllocaName = new HashMap<>();

    private void collectAllocated(IRFunction function) {
        for (IRBaseNode inst : function.entryBlock.instructions)
            if (inst instanceof AllocaNode) allocated.add(inst);
    }

    private ArrayList<IRBaseNode> collectAllocaDefs(IRBaseNode allocaInst) {
        ArrayList<IRBaseNode> ret = new ArrayList<>();
        // alloca itself is a def
        ret.add(allocaInst);
        for (User user : allocaInst.users) {
            if (user instanceof StoreNode && ((StoreNode) user).getStorePtr() == allocaInst) {
                // store to %allocaPtr
                ret.add((IRBaseNode) user);
            }
        }
        return ret;
    }

    @Override
    public void runFunction(IRFunction function) {
        new CFG_Builder().runFunction(function);
        new DTBuilder(false).runFunction(function);
        phiInsertion(function);
        variableRenaming(function.entryBlock);
    }

    private void phiInsertion(IRFunction function) {
        /*
         * b1: %i.addr = alloca i32, align 4
         * b2: %store val, %i.addr
         * -> b2: phi [b1, val]
         */

        // Log.mark("phi insertion: " + function.identifier());
        /*
        function.blocks.forEach(block -> Log.report("idom: ", block.identifier(), block.node.idom.fromBlock.identifier()));
        function.blocks.forEach(block -> block.node.domFrontier.forEach(
                df -> Log.report("df", block.identifier(), df.identifier())
        ));
        */
        collectAllocated(function);

        for (IRBaseNode allocaVar : allocated) {
            Queue<IRBlock> workQueue = new LinkedList<>();

            var defs = collectAllocaDefs(allocaVar);
            var visited = new HashSet<IRBlock>();

            defs.forEach(defInst -> workQueue.offer(defInst.parentBlock));

            while (!workQueue.isEmpty()) {
                var runner = workQueue.poll();
                for (var frontier : runner.dtNode.domFrontier) {
                    if (visited.contains(frontier)) continue;
                    visited.add(frontier);

                    workQueue.offer(frontier);
                    // Log.mark("new phi");
                    var phi = new PhiNode(((IRPointerType) allocaVar.type).pointedType, null);
                    frontier.addPhiInst(phi);
                    phiAllocaName.put(phi, allocaVar.name);
                }
            }
        }
    }

    private Value getReplace(String name) {
        if (!nameStack.containsKey(name) || nameStack.get(name).empty()) {
            return new NullConst();
        }
        return nameStack.get(name).lastElement();
    }

    private void updateReplace(String name, Value replace) {
        if (!nameStack.containsKey(name)) nameStack.put(name, new Stack<>());
        nameStack.get(name).push(replace);
    }

    private void variableRenaming(IRBlock block) {
        ArrayList<String> rollbackRecord = new ArrayList<>();

        for (var phi : block.PhiInstructions) {
            if (phiAllocaName.containsKey(phi)) {
                // Log.report("phi: ", phi.format(), phiAllocaName.get(phi));
                updateReplace(phiAllocaName.get(phi), phi);
                rollbackRecord.add(phiAllocaName.get(phi));
            }
        }

        var it = block.instructions.iterator();

        while (it.hasNext()) {
            var inst = it.next();

            if (inst instanceof AllocaNode) {
                // remove alloca
                it.remove();
            }
            else if (inst instanceof LoadNode) {
                if (allocated.contains(((LoadNode) inst).getLoadAddr())) {
                    String name = ((LoadNode) inst).getLoadAddr().name;
                    Value replace = getReplace(name);
                    if (replace.identifier().equals(LLVM.Nullptr)) {
                        // use before def, there are two conditions:
                        // 1. usage of uninitiated
                        // 2. global localization

                        // ignore Glo2Loc load inst
                        if (!(((LoadNode) inst).getLoadAddr() instanceof GlobalVariable)) {
                            // no global
//                            throw new RuntimeException();
                            it.remove();
                            inst.replaceAllUsesWith(replace);
                        }
                    } else {
                        // Log.report("load r", ((LoadNode) inst).loadPtr().identifier(), name, replace.identifier());
                        it.remove(); // remove load
                        inst.replaceAllUsesWith(replace);
                    }
                }
            }
            else if (inst instanceof StoreNode) {
                if (allocated.contains(((StoreNode) inst).getStorePtr())) {
                    String name = ((StoreNode) inst).getStorePtr().name;
                    // Log.report("store r", ((StoreNode) inst).storeValue().identifier(), name);
                    updateReplace(name, ((StoreNode) inst).getStoreData());
                    rollbackRecord.add(name);
                    it.remove(); // remove store
                }
            }
        }

        for (IRBlock suc : block.nexts) {
            for (var sucPhi : suc.PhiInstructions) {
                if (phiAllocaName.containsKey(sucPhi)) {
                    sucPhi.addBranch(getReplace(phiAllocaName.get(sucPhi)), block);
                }
            }
        }

        block.dtNode.sons.forEach(son -> variableRenaming(son.fromBlock));

        rollbackRecord.forEach(name -> nameStack.get(name).pop());
    }
}
