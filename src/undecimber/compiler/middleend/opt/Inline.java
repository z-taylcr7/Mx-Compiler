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
    private static int calleeInstMax=100,callerInstMax=200,
    blockMax=100;

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
                if (pendingCall.callFunc() != pendingCall.parentBlock.parentFunction)
                    inline(pendingCall);
            }

            for (CallNode pendingCall : inlineable) {
                if (pendingCall.callFunc() == pendingCall.parentBlock.parentFunction)
                    inline(pendingCall);
            }
        }

        new CallGraphAnalyzer().runModule(module);

        // remove dead function
        module.functions.removeIf(function -> !isUntouchable(function) && function.node.caller.size() == 0);
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
        for (IRFunction function : module.functions) {
//            nodeNum.putIfAbsent(function, 0);
//            for (IRBlock block : function.blockList) {
//                nodeNum.put(function, nodeNum.get(function) + block.instructions.size());
//            }
            int sum=0;
            for (IRBlock block : function.blockList) {
                sum+=block.instructions.size();
            }
            nodeNum.put(function,sum);
        }
        for (IRFunction function : module.functions) {
            for (CallNode callNode : function.node.call) {
                if(canInline(function,callNode.callFunc()))inlineable.add(callNode);
            }
        }
    }
    // callee's code will be inserted to caller
    private void inline(CallNode call) {
        IRFunction caller = call.parentBlock.parentFunction,
                callee = call.callFunc();

        if (!canInline(caller, callee))
            return;

        Map<Value, Value> replaceValueMap = new HashMap<>();
        Map<IRBlock, IRBlock> replaceBlockMap = new HashMap<>();

        IRBlock inlineEntry = call.parentBlock;

        // self-copy the function body
        // avoiding concurrent self recursion

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

        for (int i = 0; i < callee.getArgNum(); i++)
            replaceValueMap.put(callee.getArg(i), call.getArg(i));

        for (IRBlock oldBlock : replaceBlockMap.keySet()) {
            IRBlock newBlock = replaceBlockMap.get(oldBlock);



            for (IRBaseNode node : newBlock.instructions)
                replaceOperand(node, replaceValueMap);

            for (PhiNode phinode : newBlock.PhiInstructions)
                replaceOperand(phinode, replaceValueMap);
        }

        //relink the block

        IRBlock inlineExit = new IRBlock(LLVM.SplitBlockLabel, caller);

        boolean splitStart = false;
        var it = inlineEntry.instructions.iterator();
        while (it.hasNext()) {
            IRBaseNode node = it.next();
            if (node == call)splitStart=true;
            if (!splitStart) continue;
            if (node != call) node.setParentBlock(inlineExit);
            it.remove();
        }

        // call parentBlock to inline.entry
        inlineEntry.addLast(new BrNode(replaceBlockMap.get(callee.entryBlock), null));

        inlineEntry.nexts.forEach(suc -> suc.redirectPreBlock(inlineEntry, inlineExit));

        RetNode ret = (RetNode) replaceBlockMap.get(callee.exitBlock).terminator();
        if (!callee.isVoid()) {
            call.replaceAllUsesWith(ret.retValue());
        }

        replaceBlockMap.get(callee.exitBlock).terminator().removedFromAllUsers();
        replaceBlockMap.get(callee.exitBlock).replaceTerminator(new BrNode(inlineExit, null));

        if (caller.exitBlock == inlineEntry) caller.exitBlock = inlineExit;

        new CFGBuilder().runFunction(caller);
    }

    private void replaceOperand(User user, Map<Value, Value> replaceMap) {
        for (int i = 0; i< user.operands.size(); i++) {
            if (replaceMap.containsKey(user.getOperand(i)))
                user.setOperand(i, replaceMap.get(user.getOperand(i)));
        }
    }

}
