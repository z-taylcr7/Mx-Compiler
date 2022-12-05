package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.frontend.registry.ClassRegistry;
import undecimber.compiler.middleend.llvmir.irnode.BrNode;
import utility.Mx;

import java.util.Stack;

public class CurrentInfo {
    public ClassRegistry classRegistry;
    public IRBlock block;
    public IRFunction function;
    private final Stack<IRBlock> continueTargets=new Stack<>(),breakTargets=new Stack<>();

    public void addControlTarget(IRBlock _continue,IRBlock _break){
        continueTargets.push(_continue);
        breakTargets.push(_break);
    }
    public void deleteControlTarget(){
        continueTargets.pop();
        breakTargets.pop();
    }
    public void getControlNode(String x){
        if(x.equals( Mx.continueStr)) {
            new BrNode(continueTargets.peek(),block);
        }else if(x == Mx.breakStr){
            new BrNode(breakTargets.peek(),block);
        }else{
            throw new InternalError(x);
        }
    }
    public void TerminateAll(){
        for (IRBlock block : this.function.blockList)
            if (!block.isTerminatedNode)
                new BrNode(this.function.exitBlock, block);
    }
    public Value getThis() {
        if (this.classRegistry == null || this.function == null) throw new InternalError("IR this doesn't appear in a class");
        return this.function.getOperand(0);
    }

}
