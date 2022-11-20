package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.frontend.ast.Pass;
import undecimber.compiler.middleend.llvmir.irnode.*;
public interface IRVisitor extends Pass {
    void visit(AllocaNode Node);//ok
    void visit(BinNode Node);//ok
    void visit(BitCastNode Node);//ok
    void visit(BrNode Node);//ok
    void visit(CallNode Node);
    void visit(GetElementPtrNode Node);
    void visit(ICmpNode Node);//ok
    void visit(LoadNode Node);//ok
    void visit(PhiNode Node);
    void visit(RetNode Node);//ok
    void visit(StoreNode Node);
    void visit(TruncNode Node);
    void visit(ZextNode Node);//ok
    void visit(MoveNode Node);
}
