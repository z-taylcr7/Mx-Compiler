package undecimber.compiler.backend.asm.operands;

// RawStackOffset will be turned to Immediate with correct position

public class RawStackOffset extends Immediate {

    public enum RawType {callerArg, calleeArg, alloca, spill, lowerSp, raiseSp};
    public RawType level;

    public RawStackOffset(int offset, RawType level) {
        super(offset);
        this.level = level;
    }
}
