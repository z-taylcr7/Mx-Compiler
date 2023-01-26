package undecimber.compiler.backend.asm.insts;


import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

public class AsmMvInst extends AsmBaseInst {
    public AsmMvInst(Register rd, Register rs1, AsmBlock parentBlock) {
        super(rd, rs1, null, null, parentBlock);
    }

    @Override
    public String format() {
        // mv rd, rs1
        return String.format("%s\t%s, %s", RV32I.MvInst, rd, rs1);
    }
}
