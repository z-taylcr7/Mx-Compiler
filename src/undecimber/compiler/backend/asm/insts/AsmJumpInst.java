package undecimber.compiler.backend.asm.insts;


import undecimber.compiler.backend.asm.AsmBlock;
import utility.RV32I;

public class AsmJumpInst extends AsmBaseInst {
    public AsmBlock dest;

    public AsmJumpInst(AsmBlock dest, AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        this.dest = dest;
    }

    @Override
    public String format() {
        // j offset
        return String.format("%s\t%s", RV32I.JmpInstPrefix, dest);
    }
}
