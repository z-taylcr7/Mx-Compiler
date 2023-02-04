package undecimber.compiler.middleend.opt;

import undecimber.compiler.middleend.analytics.CFGBuilder;
import undecimber.compiler.middleend.analytics.CallGraphAnalyzer;
import undecimber.compiler.middleend.llvmir.*;
import undecimber.compiler.middleend.llvmir.irnode.*;
import utility.LLVM;
import utility.pass.ModulePass;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Inline implements ModulePass {
    public IRModule module;
    private static int calleeInstMax=500,callerInstMax=1000,
    blockMax=500;

    private final ArrayList<CallNode> inlineable = new ArrayList<>();
    private final Map<IRFunction, Integer> nodeNum = new HashMap<>();
    /**
     * @param module
     */
    @Override
    public void runModule(IRModule module) {
        this.module = module;


        while (true) {

            new CallGraphAnalyzer().runModule(module);
            collectAbleSet();

            if (inlineable.isEmpty()) break;


            for (CallNode pendingCall : inlineable) {
                // don't accept recursive
                if (pendingCall.callFunc() != pendingCall.parentBlock.parentFunction)
                    inline(pendingCall);
            }

        }

        new CallGraphAnalyzer().runModule(module);

        // remove dead function
        ArrayList<IRFunction> toRemove=new ArrayList();
        for (IRFunction function : module.functions) {
            if(!isUntouchable(function)&&function.node.caller.isEmpty())toRemove.add(function);
        }
        module.functions.removeAll(toRemove);
    }
    private boolean isUntouchable(IRFunction function) {
        return function.name.equals("main") || module.builtinFunctions.contains(function);
    }
    private boolean canInline(IRFunction caller, IRFunction callee) {
        return !isUntouchable(callee) &&
                // this is for correct order of inlining, do not use cyclic
                callee.node.call.isEmpty() &&
                nodeNum.get(caller) <= callerInstMax &&
                nodeNum.get(callee) <= calleeInstMax &&
                caller.blockList.size() <= blockMax &&
                callee.blockList.size() <= blockMax;
    }
    private void collectAbleSet(){
        nodeNum.clear();
        inlineable.clear();
        // Statistics of functions
        for (IRFunction function : module.functions) {

            int sum=0;
            for (IRBlock block : function.blockList) {
                sum+=block.instructions.size();
            }
            nodeNum.put(function,sum);
        }
        //Statistics of calls
        //dead functions will be deprecated
        for (IRFunction function : module.functions) {
            for (CallNode callNode : function.node.call) {
                if(canInline(function,callNode.callFunc()))inlineable.add(callNode);
            }
        }
    }


    private void inline(CallNode call) {
        IRFunction caller = call.parentBlock.parentFunction,
                callee = call.callFunc();

        if (!canInline(caller, callee))
            return;

        Map<Value, Value> replaceValueMap = new HashMap<>();
        Map<IRBlock, IRBlock> replaceBlockMap = new HashMap<>();

        IRBlock inlineEntry = call.parentBlock;

        // self-copy the callee function body
        // avoiding concurrent self recursion.

        ArrayList<IRBlock> calleeBlocks = new ArrayList<>(callee.blockList);
        for (IRBlock block : calleeBlocks) {
            IRBlock inlinedBlock = new IRBlock(block.name + LLVM.InlineSuffix, caller);
            replaceValueMap.put(block, inlinedBlock);
            replaceBlockMap.put(block, inlinedBlock);

            for (PhiNode phi : block.PhiInstructions) {
                PhiNode newPhi = (PhiNode) phi.copy();
                newPhi.setParentBlock(inlinedBlock);
                replaceValueMap.put(phi, newPhi);
            }

            for (IRBaseNode instruction : block.instructions) {
                IRBaseNode tmp=instruction.copy();
                tmp.setParentBlock(inlinedBlock);
                replaceValueMap.put(instruction,tmp);
            }
        }


        //Arguments replacement
        for (int i = 0; i < callee.getArgNum(); i++)
            replaceValueMap.put(callee.getArg(i), call.getArg(i));

        for (IRBlock oldBlock : replaceBlockMap.keySet()) {
            IRBlock newBlock = replaceBlockMap.get(oldBlock);

            for (IRBaseNode node : newBlock.instructions)
                replaceOperand(node, replaceValueMap);

            for (PhiNode phinode : newBlock.PhiInstructions)
                replaceOperand(phinode, replaceValueMap);
        }

        //relink the blocks after the call to the end of inline block

        IRBlock inlineExit = new IRBlock(LLVM.SplitBlockLabel, caller);

        boolean splitStarted = false;
        var it = inlineEntry.instructions.iterator();
        while (it.hasNext()) {
            IRBaseNode node = it.next();
            if (node == call)splitStarted=true;
            if (!splitStarted) continue;
            if (node != call) node.setParentBlock(inlineExit);
            it.remove();
        }

        // call parentBlock to inline.entry
        inlineEntry.addLast(new BrNode(replaceBlockMap.get(callee.entryBlock), null));

        inlineEntry.nexts.forEach(suc -> suc.redirectPreBlock(inlineEntry, inlineExit));
        //replace all the uses of callnode with the ret value
        RetNode ret = (RetNode) replaceBlockMap.get(callee.exitBlock).terminator();
        if (!callee.isVoid()) {
            call.replaceAllUsesWith(ret.retValue());
        }

        //replace of the terminator of the callfunc(it's a return node) with jmp to inline-exit
        replaceBlockMap.get(callee.exitBlock).terminator().removedFromAllUsers();
        replaceBlockMap.get(callee.exitBlock).replaceTerminator(new BrNode(inlineExit, null));
        if (caller.exitBlock == inlineEntry) caller.exitBlock = inlineExit;

        //re-analyse because inline changed controlflow
        new CFGBuilder().runFunction(caller);
    }

    private void replaceOperand(User user, Map<Value, Value> replaceMap) {
        for (int i = 0; i< user.operands.size(); i++) {
            if (replaceMap.containsKey(user.getOperand(i)))
                user.setOperand(i, replaceMap.get(user.getOperand(i)));
        }
    }

}
