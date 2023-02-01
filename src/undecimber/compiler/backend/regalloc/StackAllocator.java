package undecimber.compiler.backend.regalloc;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.operands.Immediate;
import undecimber.compiler.backend.asm.operands.RawStackOffset;
import utility.RV32I;

public class StackAllocator {
    public void runModule(AsmModule module){
        for (AsmFunction function : module.functions) {
            runFunction(function);
        }
    }
    public void runFunction(AsmFunction function){
        int mod;
        //here to calculate the stack offset in total
        function.totalStackUse+=function.callerArgStackUse+function.allocaStackUse+ function.spillStackUse;

        // | caller | alloca | spill | callee

        //stack alignment
        if( (mod=function.totalStackUse% RV32I.SpLowUnit)>0)function.totalStackUse=(function.totalStackUse / RV32I.SpLowUnit + 1) * RV32I.SpLowUnit;
        for (AsmBlock block : function.blocks) {
            for (AsmBaseInst instruction : block.instructions) {
                if(!(instruction.imm instanceof RawStackOffset))continue;
                Immediate immediate=instruction.imm;
                switch (((RawStackOffset) instruction.imm).level){
                    case spill -> instruction.imm=new Immediate(immediate.imm+ function.allocaStackUse+ function.callerArgStackUse);
                    case alloca -> instruction.imm=new Immediate(immediate.imm+ function.callerArgStackUse);
                    case callerArg -> instruction.imm=new Immediate(immediate.imm);
                    case calleeArg -> instruction.imm=new Immediate(function.totalStackUse+ immediate.imm);
                    case raiseSp -> instruction.imm=new Immediate(function.totalStackUse);
                    case lowerSp -> instruction.imm=new Immediate(-function.totalStackUse);
                    default -> throw new InternalError();

                }
            }
        }
    }
}
