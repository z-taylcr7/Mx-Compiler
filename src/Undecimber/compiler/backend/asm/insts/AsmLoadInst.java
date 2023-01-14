package undecimber.compiler.backend.asm.insts;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmTranslator;
import undecimber.compiler.backend.asm.operands.Immediate;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

public class AsmLoadInst extends AsmBaseInst{
    public int width;//lbu lb lw lh lhu


    public AsmLoadInst(int width,Register rd, Register rs1, Immediate imm, AsmBlock blk) {
        super(rd, rs1, null, imm, blk);
        this.width=width;
    }
    @Override
    public String format() {
        // lw rd, offset(rs1)
        return String.format("%s\t%s, %s(%s)",
                RV32I.LoadInstPrefix + AsmTranslator.translateByteWidth(width), rd, imm, rs1);
    }
}
