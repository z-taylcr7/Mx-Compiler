package undecimber.compiler.middleend.llvmir;


import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import undecimber.compiler.middleend.llvmir.irnode.PhiNode;
import undecimber.compiler.middleend.llvmir.irtype.IRLabelType;
import utility.errors.internalError;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class IRBlock extends Value {


    public LinkedList<IRBaseNode> instructions=new LinkedList<>();
    public ArrayList<PhiNode> PhiInstructions=new ArrayList<>();

    public boolean isTerminatedNode=false;
    public IRFunction parentFunction;
    //control flow graph
    public ArrayList<IRBlock>prevs=new ArrayList<>(),nexts=new ArrayList<>();

    // info in Loop
    public int loopDepth = 0;
    //public Loop belongLoop = null;
    public IRBlock(String label, IRFunction parentFunction) {
        super(label, new IRLabelType());
        this.parentFunction = parentFunction;
        if (parentFunction != null) parentFunction.blockList.add(this);
    }
    public void setComment() {
        StringBuilder ret = new StringBuilder(";prevs = ");
        if (!prevs.isEmpty()) {
            prevs.forEach(prev -> ret.append(prev==null?"NULL":prev.identifier()).append(", "));
        }
        if (!nexts.isEmpty()) {
            ret.append(" | nexts = ");
            nexts.forEach(next -> ret.append(next==null?"NULL":next.identifier()).append(", "));
        }
        comment = ret.toString();
    }
    public void addInst(IRBaseNode irBaseNode) {
        if (isTerminatedNode) return;
        if(irBaseNode instanceof PhiNode)PhiInstructions.add((PhiNode) irBaseNode);
        else instructions.addLast(irBaseNode);
        if (irBaseNode.isTerminator()) isTerminatedNode = true;
    }
    public void addPhiInst(PhiNode phiNode){
        phiNode.parentBlock=this;
        PhiInstructions.add(phiNode);
    }


}
