package undecimber.compiler.middleend.opt.ssa;


import undecimber.compiler.middleend.analytics.CFGBuilder;
import undecimber.compiler.middleend.analytics.DomTreeBuilder;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.*;
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
 * eliminate AllocaNode, and remove some load/store
 *
 * @requirement: CFGBuilder, DomTreeBuilder
 *
 * @reference:
 *      DomTree algorithm is based on the book "Engineering a Compiler"
 *      variable renaming part is based on SSA Book
 */

public class Mem2Reg implements FunctionPass {

    private final ArrayList<IRBaseNode> allocated = new ArrayList<>();

    private final Map<String, Stack<Value>> nameStack = new HashMap<>();

    private final Map<PhiNode, String> phiAllocatedName = new HashMap<>();

    private void collectAllocated(IRFunction function) {
        for (IRBaseNode inst : function.entryBlock.instructions)
            if (inst instanceof AllocaNode) allocated.add(inst);
    }

    private ArrayList<IRBaseNode> collectAllocaDefs(IRBaseNode allocaNode) {
        ArrayList<IRBaseNode> ret = new ArrayList<>();
        // alloca itself is a def
        ret.add(allocaNode);
        for (User user : allocaNode.users) {
            if (user instanceof StoreNode && ((StoreNode) user).getStorePtr() == allocaNode) {
                // store to %allocaPtr
                ret.add((IRBaseNode) user);
            }
        }
        return ret;
    }

    @Override
    public void runFunction(IRFunction function) {
        new CFGBuilder().runFunction(function);
        new DomTreeBuilder(false).runFunction(function);
        phiInsertion(function);
        variableRenaming(function.entryBlock);
    }

    private void phiInsertion(IRFunction function) {
        /*
         * b1: %i.addr = alloca i32, align 4
         * b2: %store val, %i.addr
         * -> b2: phi [b1, val]
         */

        collectAllocated(function);

        for (IRBaseNode allocaVar : allocated) {
            Queue<IRBlock> workQueue = new LinkedList<>();

            var defs = collectAllocaDefs(allocaVar);
            var visited = new HashSet<IRBlock>();

            for (IRBaseNode def : defs) {
                workQueue.offer(def.parentBlock);
            }


            while (!workQueue.isEmpty()) {
                var runner = workQueue.poll();
                for (var frontier : runner.dtNode.domFrontier) {
                    if (visited.contains(frontier)) continue;
                    var phi = new PhiNode(((IRPointerType) allocaVar.type).pointedType, null);
                    visited.add(frontier);
                    workQueue.offer(frontier);
                    frontier.addPhiInst(phi);
                    phiAllocatedName.put(phi, allocaVar.name);
                }
            }
        }
    }

    private void updateReplace(String name, Value replace) {
        if (!nameStack.containsKey(name)) nameStack.put(name, new Stack<>());
        nameStack.get(name).push(replace);
    }

    private Value getReplace(String name) {
        if (!nameStack.containsKey(name) || nameStack.get(name).empty()) {
            return new NullConst();
        }else return nameStack.get(name).lastElement();
    }

    private void variableRenaming(IRBlock block) {
        ArrayList<String> rollbackRecord = new ArrayList<>();

        for (var phi : block.PhiInstructions) {
            if (phiAllocatedName.containsKey(phi)) {
                updateReplace(phiAllocatedName.get(phi), phi);
                rollbackRecord.add(phiAllocatedName.get(phi));
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
//                            new UninitiatedWarning(Value.getRawName(name)).tell();
                            it.remove();
                            inst.replaceAllUsesWith(replace);
                        }
                    } else {
                        // Log.report("load r", ((IRLoadNode) inst).loadPtr().identifier(), name, replace.identifier());
                        it.remove(); // remove load
                        inst.replaceAllUsesWith(replace);
                    }
                }
            }
            else if (inst instanceof StoreNode) {
                if (allocated.contains(((StoreNode) inst).getStorePtr())) {
                    String name = ((StoreNode) inst).getStorePtr().name;
                    // Log.report("store r", ((IRStoreNode) inst).storeValue().identifier(), name);
                    updateReplace(name, ((StoreNode) inst).getStoreData());
                    rollbackRecord.add(name);
                    it.remove(); // remove store
                }
            }
        }

        for (IRBlock suc : block.nexts) {
            for (var sucPhi : suc.PhiInstructions) {
                if (phiAllocatedName.containsKey(sucPhi)) {
                    sucPhi.addBranch(getReplace(phiAllocatedName.get(sucPhi)), block);
                }
            }
        }

        block.dtNode.sons.forEach(son -> variableRenaming(son.fromBlock));

        rollbackRecord.forEach(name -> nameStack.get(name).pop());
    }
}
