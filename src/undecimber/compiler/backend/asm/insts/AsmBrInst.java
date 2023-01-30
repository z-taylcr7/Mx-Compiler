package undecimber.compiler.backend.asm.insts;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

public class AsmBrInst extends AsmBaseInst{
    public String op;
    public AsmBlock dest;
    public AsmBrInst(String op, Register rs1,Register rs2,AsmBlock dest_blk,AsmBlock blk){
        super(null,rs1,rs2,null,blk);
        this.op=op;
        this.dest=dest_blk;

    }
    @Override
    public String format(){
        return String.format("%s\t%s,%s,%s", RV32I.BrInstPrefix+op,rs1,rs2,dest);
    }
}
