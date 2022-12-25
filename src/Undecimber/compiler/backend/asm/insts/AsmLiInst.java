package undecimber.compiler.backend.asm.insts;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.operands.Immediate;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

public class AsmLiInst extends AsmBaseInst{
    public AsmLiInst(Register rd, Immediate imm, AsmBlock parentBlock) {
        super(rd, null, null, imm, parentBlock);
    }


    @Override
    public String format() {
        // lui	a0, %hi(glb)
        return String.format("%s\t%s, %s", RV32I.LiInst, rd, imm);
    }
}
