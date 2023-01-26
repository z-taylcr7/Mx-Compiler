package undecimber.compiler.backend.asm.insts;


import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmTranslator;
import undecimber.compiler.backend.asm.operands.Immediate;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

public class AsmStoreInst extends AsmBaseInst {
    private final int byteWidth;

    public AsmStoreInst(int byteWidth, Register rs1, Register rs2, Immediate imm, AsmBlock parentBlock) {
        super(null, rs1, rs2, imm, parentBlock);
        this.byteWidth = byteWidth;
    }

    @Override
    public String format() {
        // sw rs2, offset(rs1)
        return String.format("%s\t%s, %s(%s)",
                RV32I.StoreInstPrefix + AsmTranslator.translateByteWidth(byteWidth), rs2, imm, rs1);
    }
}
