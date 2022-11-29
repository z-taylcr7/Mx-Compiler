package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.frontend.ast.Pass;
import undecimber.compiler.middleend.llvmir.irnode.*;
public interface IRVisitor extends Pass {
    void visit(AllocaNode Node);//ok
    void visit(BinNode Node);//ok
    void visit(BitCastNode Node);//ok
    void visit(BrNode Node);//ok
    void visit(CallNode Node);//ok
    void visit(ICmpNode Node);//ok
    void visit(LoadNode Node);//ok
    void visit(ZextNode Node);//ok
    void visit(RetNode Node);//ok
    void visit(TruncNode Node);//ok
    void visit(StoreNode Node);//ok
    void visit(PhiNode Node);//ok?
    void visit(MoveNode Node);//ok
    void visit(GetElementPtrNode Node);//ok
}
