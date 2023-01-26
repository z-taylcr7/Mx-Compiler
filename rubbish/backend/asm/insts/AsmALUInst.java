package undecimber.compiler.backend.asm.insts;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.operands.Immediate;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

public class AsmALUInst extends AsmBaseInst{
    public final String op;

    public AsmALUInst(String op, Register rd, Register rs1, Register rs2, AsmBlock parentBlock) {
        super(rd, rs1, rs2, null, parentBlock);
        this.op = op;
    }

    public AsmALUInst(String op, Register rd, Register rs1, Immediate imm, AsmBlock parentBlock) {
        super(rd, rs1, null, imm, parentBlock);
        this.op = op;
    }

    public AsmALUInst(String op, Register rd, Register rs1, AsmBlock parentBlock) {
        super(rd, rs1, null, null, parentBlock);
        this.op = op;
    }



    @Override
    public String format() {
        // add rd, rs1, rs2
        // addi rd, rs1, imm
        if (this.imm != null) // I-Type
            return String.format("%s\t%s, %s, %s", op + RV32I.ITypeSuffix, rd, rs1, imm);
        else if (this.rs2 != null) // R-Type
            return String.format("%s\t%s, %s, %s", op, rd, rs1, rs2);
        else
            return String.format("%s\t%s, %s", op, rd, rs1);
    }
}
