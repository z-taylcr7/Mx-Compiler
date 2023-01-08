package undecimber.compiler.backend.asm.insts;


import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.operands.PhysicalReg;
import undecimber.compiler.backend.asm.operands.Register;
import utility.RV32I;

import java.util.HashSet;

public class AsmCallInst extends AsmBaseInst {
    public final AsmFunction callFunc;

    public boolean isTailCall;
    public AsmCallInst(AsmFunction callFunc, AsmBlock parentBlock) {
        super(null, null, null, null, parentBlock);
        this.callFunc = callFunc;
        this.isTailCall = false;
    }
    public AsmCallInst(AsmFunction callFunc, AsmBlock parentBlock, boolean isTailCall) {
        super(null, null, null, null, parentBlock);
        this.callFunc = callFunc;
        this.isTailCall = isTailCall;
    }

    @Override
    public HashSet<Register> uses() {
        HashSet<Register> ret = new HashSet<>();
        for (int i = 0; i < Integer.min(RV32I.MaxArgRegNum, callFunc.arguments.size()); i++)
            ret.add(PhysicalReg.a(i));
        return ret;
    }

    @Override
    public HashSet<Register> defs() {
        return new HashSet<>(PhysicalReg.callerSaved);
    }

    @Override
    public String format() {
        // call symbol
        return String.format("%s\t%s", RV32I.CallInst, callFunc.id);
    }
}
