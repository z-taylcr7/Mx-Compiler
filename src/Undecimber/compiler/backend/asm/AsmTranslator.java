package undecimber.compiler.backend.asm;


import org.antlr.v4.runtime.misc.Pair;
import utility.LLVM;
import utility.RV32I;

public class AsmTranslator {
//translate LLVMIR to ASM
    public static String translateByteWidth(int op) {
        switch (op) {
            case 1: return RV32I.ByteWord;
            case 2: return RV32I.HalfWord;
            case 4: case 8: return RV32I.WordWord; // pointer type 64bit -> 32bit
        }
        return "";
    }

    public static String translateArithOp(String irOp) {
        switch (irOp) {
            case LLVM.DivInst: return RV32I.DivInst;
            case LLVM.ModInst: return RV32I.ModInst;
            case LLVM.ShiftLeftInst: return RV32I.ShiftLeftInst;
            case LLVM.ShiftRightInst: return RV32I.ShiftRightInst;
            // notice: LLVM IR and RV32 Asm have many in common
            default: return irOp;
        }
    }

    // second param: swap flag (e.g. a > b to b < a)
    public static Pair<String, Boolean> translateCmpOp(String irOp) {
        switch (irOp) {
            case LLVM.GreaterArg: return new Pair<>(RV32I.LessSuffix, true);
            case LLVM.GreaterEqualArg: return new Pair<>(RV32I.GreaterEqualSuffix, false);
            case LLVM.LessArg: return new Pair<>(RV32I.LessSuffix, false);
            case LLVM.LessEqualArg: return new Pair<>(RV32I.GreaterEqualSuffix, true);
            default: return new Pair<>(irOp, false);
        }
    }

    public static boolean isCommunicative(String rvOp) {
        switch (rvOp) {
            case RV32I.SubInst:
            case RV32I.DivInst:
            case RV32I.ModInst:
            case RV32I.ShiftLeftInst:
            case RV32I.ShiftRightInst:
            case RV32I.SltInst:
                return false;
            default:
                return true;
        }
    }

    public static boolean has_I_Type(String rvOp) {
        switch (rvOp) {
            case RV32I.SubInst:
            case RV32I.MulInst:
            case RV32I.DivInst:
            case RV32I.ModInst:
                return false;
            default:
                return true;
        }
    }
}
