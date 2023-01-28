package undecimber.compiler.backend.optim;


import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.AsmALUInst;
import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.operands.PhysicalReg;
import utility.RV32I;
import utility.pass.AsmPass;

public class ZeroElimination implements AsmPass {

    /**
     * @param block
     */
    @Override
    public void runBlock(AsmBlock block) {

    }

    /**
     * @param module
     */
    @Override
    public void runModule(AsmModule module) {

    }


    @Override
    public void runFunction(AsmFunction function) {

        for (AsmBlock block : function.blocks) {
            var it = block.instructions.iterator();

            while (it.hasNext()) {
                AsmBaseInst inst = it.next();

                if (inst instanceof AsmALUInst) {
                    String op = ((AsmALUInst) inst).op;

                    switch (op) {
                        case RV32I.AddInst:
                        case RV32I.SubInst:
                        case RV32I.OrInst:
                        case RV32I.XorInst:
                        case RV32I.ShiftLeftInst:
                        case RV32I.ShiftRightInst: {
                            if (inst.rd.color == inst.rs1.color) {
                                if (inst.imm != null && inst.imm.imm == 0) it.remove();
                                if (inst.rs2 != null && inst.rs2.color == PhysicalReg.reg("zero")) it.remove();
                            }
                        }
                    }
                }
            }
        }

    }
}
