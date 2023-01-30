package undecimber.compiler.middleend.analytics;


import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.IRModule;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irconst.GlobalVariable;
import undecimber.compiler.middleend.llvmir.irnode.CallNode;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import undecimber.compiler.middleend.llvmir.irnode.StoreNode;
import utility.pass.ModulePass;

import java.util.HashSet;
import java.util.Stack;

public class CallGraphAnalyzer implements ModulePass {

    public static class Node {
        public IRFunction fromFunc;
        public HashSet<Value> glbUses = new HashSet<>(), glbDefs = new HashSet<>();

        public HashSet<CallNode> call = new HashSet<>();
        public HashSet<IRFunction> caller = new HashSet<>(), callee = new HashSet<>();

        // A call A, or A call B, B call A ...
        public boolean cyclic = false;

        public Node(IRFunction fromFunc) {
            this.fromFunc = fromFunc;
        }

        public void init() {
            glbUses = new HashSet<>();
            glbDefs = new HashSet<>();
            call = new HashSet<>();
            caller = new HashSet<>();
            callee = new HashSet<>();
            cyclic = false;
        }
    }

    private HashSet<IRFunction> visited = new HashSet<>();
    private Stack<IRFunction> callStack = new Stack<>();

    private void init(IRModule module) {
        module.functions.forEach(function -> function.node.init());
    }

    private void callGraphBuild(IRModule module) {
        for (IRFunction function : module.functions)
            for (IRBlock block : function.blockList)
                for (IRBaseNode inst : block.instructions) {
                    if (inst instanceof CallNode) {
                        function.node.call.add((CallNode) inst);

                        IRFunction callee = ((CallNode) inst).callFunc();
                        callee.node.caller.add(function);
                        function.node.callee.add(callee);
                    }
                    // glb use: load or store
                    inst.operands.forEach(operand -> {
                        if (operand instanceof GlobalVariable) function.node.glbUses.add(operand);
                    });
                    // glb def: store
                    if (inst instanceof StoreNode && ((StoreNode) inst).getStorePtr() instanceof GlobalVariable)
                        function.node.glbDefs.add(((StoreNode) inst).getStorePtr());
                }

        // my callee's use is my use
        boolean changed = true;
        while (changed) {
            changed = false;
            for (IRFunction function : module.functions)
                for (IRFunction callee : function.node.callee)
                    for (Value use : callee.node.glbUses)
                        if (!function.node.glbUses.contains(use)) {
                            function.node.glbUses.add(use);
                            changed = true;
                        }
        }

        // def is not necessary to propagation because it will be considered in callee
    }

    private void callGraphAnalysis(IRFunction function) {
        if (visited.contains(function)) return;
        visited.add(function);
        callStack.push(function);

        for (IRFunction caller : callStack)
            if (function.node.callee.contains(caller)) {
                function.node.cyclic = true; // caller -> ... -> function -> caller
                break;
            }

        function.node.callee.forEach(this::callGraphAnalysis);
        callStack.pop();
    }

    @Override
    public void runModule(IRModule module) {
        init(module);
        callGraphBuild(module);
        for (IRFunction function : module.functions)
            if (!visited.contains(function)) callGraphAnalysis(function);
    }
}
