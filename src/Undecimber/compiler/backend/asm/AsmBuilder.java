package undecimber.compiler.backend.asm;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.IRModule;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.irnode.*;
import utility.pass.BlockPass;
import utility.pass.FunctionPass;
import utility.pass.ModulePass;

public class AsmBuilder implements ModulePass, FunctionPass, BlockPass, IRVisitor {

    /**
     * @param Node
     */
    @Override
    public void visit(AllocaNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(BinNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(BitCastNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(BrNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(CallNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(ICmpNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(LoadNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(ZextNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(RetNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(TruncNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(StoreNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(PhiNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(MoveNode Node) {

    }

    /**
     * @param Node
     */
    @Override
    public void visit(GetElementPtrNode Node) {

    }

    /**
     * @param block
     */
    @Override
    public void runBlock(IRBlock block) {

    }

    /**
     * @param func
     */
    @Override
    public void runFunction(IRFunction func) {

    }

    /**
     * @param module
     */
    @Override
    public void runModule(IRModule module) {

    }
}

