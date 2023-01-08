package undecimber.compiler.backend.asm.operands;

import utility.RV32I;

public class Immediate extends BasicOperand{
   public int imm;

    public Immediate(int _imm) {
        super(String.valueOf(_imm));
        this.imm=_imm;
    }
    public Immediate(String _id) {
        super(_id);
        this.imm=0;
    }
    public Immediate MakeNegative(){
        return new Immediate (-this.imm);
    }
    public boolean isValidImm(){
        return (imm< RV32I.ImmBound&&imm>(-RV32I.ImmBound));
    }
}
