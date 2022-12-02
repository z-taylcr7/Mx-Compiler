package undecimber.compiler.middleend.llvmir;


import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import undecimber.compiler.middleend.llvmir.irnode.PhiNode;
import undecimber.compiler.middleend.llvmir.irtype.IRLabelType;
import utility.errors.internalError;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class IRBlock extends Value {


    public LinkedList<IRBaseNode> instructions;
    public ArrayList<PhiNode> PhiInstructions;

    public boolean isTerminatedNode;
    public IRFunction parentFunction;
    //control flow graph
    public ArrayList<IRBlock>prevs=new ArrayList<>(),nexts=new ArrayList<>();


    public IRBlock(String label, IRFunction parentFunction) {
        super(label, new IRLabelType());
        this.parentFunction = parentFunction;
        if (parentFunction != null) parentFunction.blockList.add(this);
    }

    public void addInst(IRBaseNode irBaseNode) {
        if (isTerminatedNode) return;
        if (irBaseNode.isTerminator()) isTerminatedNode = true;
        instructions.addLast(irBaseNode);
    }
    public void addPhiInst(PhiNode phiNode){
        phiNode.parentBlock=this;
        PhiInstructions.add(phiNode);
    }
    public IRBaseNode terminator() {
        if (instructions.isEmpty()) throw new RuntimeException("empty IRBLock! no terminator! " + this.name);
        return instructions.getLast();
    }

}
