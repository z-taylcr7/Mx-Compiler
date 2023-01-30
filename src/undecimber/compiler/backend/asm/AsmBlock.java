package undecimber.compiler.backend.asm;

import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.operands.BasicOperand;
import undecimber.compiler.backend.asm.operands.Register;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;

public class AsmBlock extends BasicOperand {
    public LinkedList<AsmBaseInst> instructions = new LinkedList<>();

    // control flow graph
    public ArrayList<AsmBlock> prevs = new ArrayList<>(), nexts = new ArrayList<>();

    // Reg's lifetime analysis
    public HashSet<Register> aliveIn = new HashSet<>(), aliveOut = new HashSet<>();


    public int loopDepth = 0;
    public AsmBlock(String id){
        super(id);
    }

    public void addInst(AsmBaseInst inst) {
        instructions.add(inst);
    }

    public AsmBaseInst terminator() {
        if (instructions.isEmpty()) throw new InternalError("empty AsmBLock no terminator " + this.id);
        return instructions.getLast();
    }
}
