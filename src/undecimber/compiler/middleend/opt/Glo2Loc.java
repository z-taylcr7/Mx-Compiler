package undecimber.compiler.middleend.opt;


import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.User;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irconst.GlobalVariable;
import undecimber.compiler.middleend.llvmir.irnode.AllocaNode;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import undecimber.compiler.middleend.llvmir.irnode.LoadNode;
import undecimber.compiler.middleend.llvmir.irnode.StoreNode;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;
import utility.LLVM;
import utility.pass.FunctionPass;

import java.util.*;

public class Glo2Loc implements FunctionPass {

    // if a global variable isn't used many times, not localize it because not worthy
    public static final int UsageThreshold = 1;

    private Map<GlobalVariable, Integer> refTimes = new HashMap<>();
    private Set<GlobalVariable> ableSet = new HashSet<>(), constAbleSet = new HashSet<>();

    private boolean constantDetect(GlobalVariable global) {
        if (global.val == null) return false;
        for (User use : global.users) {
            if (use instanceof StoreNode &&
                !Objects.equals(((StoreNode) use).parentBlock.parentFunction.name, LLVM.InitFuncName)) {
                return false;
            }
        }
        return true;
    }

    private void collectAbleSet(IRFunction function) {

        for (IRBlock block : function.blockList)
            for (IRBaseNode inst : block.instructions) {

                Value global;

                if (inst instanceof LoadNode) {
                    global = ((LoadNode) inst).getLoadAddr();
                } else if (inst instanceof StoreNode) {
                    global = ((StoreNode) inst).getStorePtr();
                } else {
                    continue;
                }

                if (global instanceof GlobalVariable) {
                    refTimes.putIfAbsent((GlobalVariable) global, 1);
                    refTimes.put((GlobalVariable) global, refTimes.get(global) + 1);
                }
            }

        //  If a global variable is used in the callee function, it is likely it will be modified,
        //  and that causes side effects.

        for (var global : refTimes.keySet()) {
            // Log.info("ref times", global.identifier(), refTimes.get(global));

            if (constantDetect(global)) constAbleSet.add(global);
            else if (refTimes.get(global) >= UsageThreshold) {
                boolean check = true;
                for (IRFunction callee : function.node.callee) {
                    if (callee.node.glbUses.contains(global)) {
                        check = false;
                        break;
                    }
                }
                if (check) ableSet.add(global);
            }
        }
    }

    @Override
    public void runFunction(IRFunction function) {
        if (function.node.cyclic) return;
        if (function.name.equals(LLVM.InitFuncName)) return;

        collectAbleSet(function);


        for (GlobalVariable global : ableSet) {
            IRBaseNode initLoad = new LoadNode(global, null),
                       initAlloc = new AllocaNode(LLVM.LocalPrefix + global.name, ((IRPointerType) global.type).pointedType, null),
                       initStore = new StoreNode(initAlloc, initLoad, null);

            // 1. alloc space for local
            // 2. load value from global
            // 3. store value to local

            function.entryBlock.addFirst(initStore);
            function.entryBlock.addFirst(initLoad);
            function.entryBlock.addFirst(initAlloc);

            IRBaseNode writeBackLoad = null, writeBackStore = null;
            // if the function doesn't modify it, there is no need to store back
            if (function.node.glbDefs.contains(global)) {
                 writeBackLoad = new LoadNode(initAlloc, null);
                 writeBackStore = new StoreNode(global, writeBackLoad, null);
                function.exitBlock.addFirst(writeBackStore);
                function.exitBlock.addFirst(writeBackLoad);
            }

            for (IRBlock block : function.blockList)
                for (IRBaseNode inst : block.instructions) {
                    if (inst instanceof LoadNode && global == ((LoadNode) inst).getLoadAddr() &&
                            inst != initLoad && inst != writeBackLoad) {
                        ((LoadNode) inst).replacePtr(initAlloc);
                    }
                    else if (inst instanceof StoreNode && global == ((StoreNode) inst).getStorePtr() &&
                            inst != initStore && inst != writeBackStore) {
                        ((StoreNode) inst).replacePtr(initAlloc);
                    }
                }
        }

        for (GlobalVariable global : constAbleSet) {
            // replace all load with initValue, remove all loads
            // remove the only store

            for (User use : global.users) {
                assert use instanceof IRBaseNode;
                if (use instanceof LoadNode) use.replaceAllUsesWith(global.val);
                ((IRBaseNode) use).parentBlock.instructions.remove(use);
            }
        }
    }
}
