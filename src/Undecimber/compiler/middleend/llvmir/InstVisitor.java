package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.frontend.ast.Pass;
import undecimber.compiler.middleend.llvmir.inst.*t;

public interface InstVisitor extends Pass {
    void visit(AllocaInst inst);
    void visit(BinaryInst inst);
    void visit(BitCastInst inst);
    void visit(BrInst inst);
    void visit(CallInst inst);
    void visit(GetElementPtrInst inst);
    void visit(ICmpInst inst);
    void visit(LoadInst inst);
    void visit(PhiInst inst);
    void visit(RetInst inst);
    void visit(StoreInst inst);
    void visit(TruncInst inst);
    void visit(ZextInst inst);
    void visit(MoveInst inst);
}
