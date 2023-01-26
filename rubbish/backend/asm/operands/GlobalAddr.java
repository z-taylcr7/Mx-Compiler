package undecimber.compiler.backend.asm.operands;

// to deal with global variable
// lui  %hi(glb)
// lw	a0, %lo(glb)(a0)

public class GlobalAddr extends Immediate {
    public enum status {hi, lo};

    public GlobalReg reg;

    public GlobalAddr(GlobalReg reg, status s) {
        super("%"+String.format("%s(%s)", s, reg));
        this.reg = reg;
    }
}
