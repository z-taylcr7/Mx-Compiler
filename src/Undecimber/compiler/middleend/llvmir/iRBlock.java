package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;

public class IRBlock extends Value {


    public LinkedList<IRBaseNode> instructions;

    public boolean isTerminatedNode;
    public IRFunction parentFunction;
    //control flow graph
    public ArrayList<IRBlock>prevs=new ArrayList<>(),nexts=new ArrayList<>();



    public IRBlock() {
        isTerminatedNode=false;
    }

    public void addInst(IRBaseNode irBaseNode) {
        instructions.add(irBaseNode);

    }
}
