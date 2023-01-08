package undecimber.compiler.backend.asm;

import com.sun.jdi.InternalException;
import undecimber.compiler.backend.asm.insts.AsmLiInst;
import undecimber.compiler.backend.asm.operands.*;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irconst.BoolConst;
import undecimber.compiler.middleend.llvmir.irconst.IntConst;
import undecimber.compiler.middleend.llvmir.irconst.NullConst;
import utility.RV32I;

import java.util.HashMap;

public class CurrentInfo {
    public AsmBlock block;
    public AsmFunction function;
    HashMap<Integer,Register>LiMap=new HashMap<>(

    );
    //allocate Reg
    public Register toReg(Value value) {
        if (value.asmOperand != null) {
            return (Register) value.asmOperand;
        }
        Integer intValue = null;
        if (value instanceof IntConst) intValue = ((IntConst) value).data;
        else if (value instanceof BoolConst) intValue = ((BoolConst) value).flag ? 1 : 0;
        else if (value instanceof NullConst) intValue = 0;

        if (intValue != null && intValue == 0) {
            value.asmOperand = PhysicalReg.reg("zero");
            return PhysicalReg.reg("zero");
        }

        Register ret;

        if (LiMap.containsKey(intValue)) {
            ret = LiMap.get(intValue);
        }
        else {
            ret = new VirtualReg(value.type.size());
            if (intValue != null) {
                new AsmLiInst(ret, new Immediate(intValue), this.block);
                LiMap.put(intValue, ret);
            }
        }

        if (!(value instanceof IntConst || value instanceof BoolConst)) value.asmOperand = ret;
        return ret;
    }
    //allocate imm
    public Immediate toImm(int value) {
        if (value < -1 * RV32I.ImmBound || value > RV32I.ImmBound) throw new InternalError("invalid immediate detected");
        return new Immediate(value);
    }

    public Immediate toImm(Value value) {
        if (value.asmOperand instanceof RawStackOffset) return (Immediate) value.asmOperand;
        if (value instanceof IntConst) return new Immediate(((IntConst) value).data);
        if (value instanceof BoolConst) return new Immediate (((BoolConst) value).flag ? 1 : 0);
        throw new InternalException();
    }
}
