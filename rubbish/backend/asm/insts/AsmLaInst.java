package undecimber.compiler.backend.asm.insts;


import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

public class AsmLaInst extends AsmBaseInst {
    private final String symbol;

    public AsmLaInst(Register rd, String symbol, AsmBlock parentBlock) {
        super(rd, null, null, null, parentBlock);
        this.symbol = symbol;
    }

    @Override
    public String format() {
        // la rd, symbol
        return String.format("%s\t%s, %s", RV32I.LaInst, rd, symbol);
    }
}
