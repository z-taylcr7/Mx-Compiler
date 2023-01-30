package undecimber.compiler.backend.asm.insts;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.operands.Immediate;
import undecimber.compiler.backend.asm.operands.PhysicalReg;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

import java.util.HashSet;

public class AsmTailInst extends AsmBaseInst{
    AsmFunction callFunc;
    public AsmTailInst(AsmFunction callFunc, AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        this.callFunc = callFunc;
    }

    @Override
    public HashSet<Register> defs() {
        return new HashSet<>(PhysicalReg.callerSaved);
    }
    @Override
    public HashSet<Register> uses() {
        HashSet<Register> ret = new HashSet<>();
        for (int i = 0; i < Integer.min(RV32I.MaxArgRegNum, callFunc.arguments.size()); i++)
            ret.add(PhysicalReg.a(i));
        return ret;
    }
    @Override
    public String format() {
        // tail symbol
        return String.format("%s\t%s", RV32I.TailInst, callFunc.id);
    }
}
