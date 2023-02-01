package undecimber.compiler.middleend.analytics;


import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.*;
import undecimber.compiler.middleend.llvmir.irnode.*;
import utility.pass.FunctionPass;

public class CFG_Builder implements FunctionPass {

    private void init(IRFunction function) {
        for (IRBlock block : function.blockList) {
            block.prevs.clear();
            block.nexts.clear();
        };
    }

    @Override
    public void runFunction(IRFunction function) {
        init(function);

        for (IRBlock block : function.blockList) {
            var terminator = block.terminator();
            if (terminator instanceof BrNode) {
                if (((BrNode) terminator).IsJump()) {
                    block.linkBlock(((BrNode) terminator).Dest());
                } else {
                    block.linkBlock(((BrNode) terminator).Then());
                    block.linkBlock(((BrNode) terminator).Else());
                }
            }
        }
    }
}
