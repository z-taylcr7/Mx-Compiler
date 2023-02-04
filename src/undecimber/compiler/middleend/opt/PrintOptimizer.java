package undecimber.compiler.middleend.opt;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.IRModule;
import undecimber.compiler.middleend.llvmir.irnode.CallNode;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import utility.pass.FunctionPass;

import java.util.HashSet;

public class PrintOptimizer implements FunctionPass {
    private IRModule module;



    public void runBlock(IRBlock block) {
        var it = block.instructions.listIterator();

        HashSet<IRBaseNode> toRemove = new HashSet<>();

        while (it.hasNext()) {
            var node = it.next();


            if (node instanceof CallNode && ((CallNode) node).callFunc() == module.getBuiltInFunction("toString")) {
                if (node.users.size() == 1 && node.users.get(0) instanceof CallNode) {
                    if (((CallNode) node.users.get(0)).callFunc() == module.getBuiltInFunction("print")) {
                        node.removedFromAllUsers();
                        block.setByIterator(new CallNode(module.getBuiltInFunction("printInt"), null, ((CallNode) node).getArg(0)),
                                it);
                        toRemove.add((IRBaseNode) node.users.get(0));
                    }
                    if (((CallNode) node.users.get(0)).callFunc() == module.getBuiltInFunction("println")) {
                        node.removedFromAllUsers();
                        block.setByIterator(new CallNode(module.getBuiltInFunction("printlnInt"), null, ((CallNode) node).getArg(0)),
                                it);
                        toRemove.add((IRBaseNode) node.users.get(0));
                    }
                }
            }
        }

        toRemove.forEach(node -> {
            node.removedFromAllUsers();
            block.instructions.remove(node);
        });
    }

    @Override
    public void runFunction(IRFunction func) {


        module = func.parentModule;
        for (IRBlock block : func.blockList) {
            runBlock(block);
        }
    }
}
