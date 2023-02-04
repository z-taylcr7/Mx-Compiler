package undecimber.compiler.middleend.llvmir;


import undecimber.compiler.middleend.analytics.DomTreeBuilder;
import undecimber.compiler.middleend.analytics.loop.Loop;
import undecimber.compiler.middleend.llvmir.irnode.BrNode;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import undecimber.compiler.middleend.llvmir.irnode.PhiNode;
import undecimber.compiler.middleend.llvmir.irtype.IRLabelType;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class IRBlock extends Value {
    public LinkedList<IRBaseNode> instructions=new LinkedList<>();
    public ArrayList<PhiNode> PhiInstructions=new ArrayList<>();

    public boolean isTerminatedNode=false;
    public IRFunction parentFunction;
    //control flow graph
    public ArrayList<IRBlock>prevs=new ArrayList<>(),nexts=new ArrayList<>();

    // info in Loop
    public int loopDepth = 0;
//    public DomTreeBuilder.Node dtNode=new DomTreeBuilder.Node(this);
    public DomTreeBuilder.Node dtNode=new DomTreeBuilder.Node(this);
    public Loop belongLoop;

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
    public void addFirst(IRBaseNode inst) {
        inst.parentBlock = this;
        instructions.addFirst(inst);
    }

    public void addLast(IRBaseNode inst) {
        inst.parentBlock = this;
        instructions.addLast(inst);
    }
    public void linkBlock(IRBlock toBlock) {
        this.nexts.add(toBlock);
        toBlock.prevs.add(this);
    }

    public void redirectPreBlock(IRBlock oldPre, IRBlock newPre) {
        this.prevs.remove(oldPre);
        this.prevs.add(newPre);
        for (PhiNode phi : this.PhiInstructions) {
            for (int i = 1; i < phi.getOperandSize(); i += 2) {
                if (phi.getOperand(i) == oldPre)
                    phi.setOperand(i, newPre);
            }
        }
    }

    public void redirectSucBlock(IRBlock oldSuc, IRBlock newSuc) {
        this.nexts.remove(oldSuc);
        this.nexts.add(newSuc);
        for (IRBaseNode inst : this.instructions) {
            if (inst instanceof BrNode) {
                if (((BrNode) inst).IsJump()) {
                    if (((BrNode) inst).Dest() == oldSuc) ((BrNode) inst).setDest(newSuc);
                } else {
                    if (((BrNode) inst).Then() == oldSuc) ((BrNode) inst).setThen(newSuc);
                    if (((BrNode) inst).Else() == oldSuc) ((BrNode) inst).setElse(newSuc);
                }
            }
        }
    }
    public void addBeforeTerminator(IRBaseNode inst) {
        inst.parentBlock = this;
        if (instructions.isEmpty()) return;
        instructions.add(instructions.size() - 1, inst);
    }

    public void addByIterator(IRBaseNode node, ListIterator<IRBaseNode> it) {
        node.parentBlock = this;
        it.add(node);
    }

    public void setByIterator(IRBaseNode node, ListIterator<IRBaseNode> it) {
        node.parentBlock = this;
        it.set(node);
    }

    public void replaceTerminator(IRBaseNode newTerminator) {
        newTerminator.parentBlock = this;
        instructions.removeLast();
        instructions.addLast(newTerminator);
    }

    public void removePhiBranch(IRBlock remove) {
        var it = this.PhiInstructions.iterator();
        while (it.hasNext()) {
            var phi = it.next();
            for (int i = 1; i < phi.getOperandSize(); i += 2) {
                if (phi.getOperand(i) == remove) {
                    // remove the branch
                    phi.operands.remove(i-1);
                    phi.operands.remove(remove);
                }
            }
            if (phi.getOperandSize() == 2) {
                // can not remove from users because its register will be saved
                it.remove();
                // IRMoveInst move = new IRMoveInst(phi, phi.getOperand(0), null); // terminated
                // this.tAddFirst(move);
                // Log.info(phi.format());
                phi.replaceAllUsesWith(phi.getOperand(0));
            }
        }
    }

    public IRBaseNode terminator() {
        if (instructions.isEmpty()) throw new InternalError("empty IRBLock! no terminator! " + this.name);
        return instructions.getLast();
    }

}
