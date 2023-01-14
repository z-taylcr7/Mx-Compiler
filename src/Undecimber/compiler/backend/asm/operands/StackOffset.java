package undecimber.compiler.backend.asm.operands;


import undecimber.compiler.backend.asm.AsmFunction;

import java.util.HashSet;
import java.util.Set;

public class StackOffset extends Immediate {

    public static Set<StackOffset> collection = new HashSet<>();

    public final int level;
    public final AsmFunction parentFunction;

    public StackOffset(int offset, int level, AsmFunction parentFunction) {
        super(offset);
        this.level = level;
        collection.add(this);
        this.parentFunction = parentFunction;
    }

    public void setStackBase(int basePos) {
        this.imm += basePos;
        this.id = String.valueOf(this.imm);
    }
}
