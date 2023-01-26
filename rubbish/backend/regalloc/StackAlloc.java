package undecimber.compiler.backend.regalloc;



/*
 * after register allocation, refresh the program.
 * move eliminator & stack allocator
 */

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
//import undecimber.compiler.backend.asm.operands.Register;

import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.operands.*;
import undecimber.compiler.backend.asm.insts.*;
import utility.RV32I;
import utility.pass.AsmPass;

public class StackAlloc implements AsmPass {

    public void virtualSet(Register reg, AsmFunction function) {
        if (reg instanceof VirtualReg) {
            if (reg.stackOffset == null)
                reg.stackOffset = new StackOffset(((VirtualReg) reg).num * 4, 2, function);
        }
    }


    public void violentAllocator(AsmFunction function) {
        for (AsmBlock block : function.blocks) {
            var it = block.instructions.listIterator();
            while (it.hasNext()) {
                AsmBaseInst inst = it.next();

                if (inst.rs1 instanceof VirtualReg) {
                    it.previous();
                    if (inst.rs1.stackOffset.imm >= RV32I.ImmBound) {
                        it.add(new AsmLiInst(PhysicalReg.reg("s1"), new Immediate(inst.rs1.stackOffset.imm), null));
                        it.add(new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("s1"), PhysicalReg.reg("s1"), PhysicalReg.reg("sp"), null));
                        it.add(new AsmLoadInst(((VirtualReg) inst.rs1).size, PhysicalReg.t(2), PhysicalReg.reg("s1"), new Immediate(0), null));
                    } else {
                        it.add(new AsmLoadInst(((VirtualReg) inst.rs1).size, PhysicalReg.t(2), PhysicalReg.reg("sp"), inst.rs1.stackOffset, null));
                    }
                    it.next();
                    inst.rs1 = PhysicalReg.t(2);
                }
                else if (inst.rs1 instanceof ArgumentReg) {
                    it.previous();
                    it.add(new AsmLoadInst(((ArgumentReg) inst.rs1).size, PhysicalReg.t(2), PhysicalReg.reg("sp"), inst.rs1.stackOffset, null));
                    it.next();
                    inst.rs1 = PhysicalReg.t(2);
                }

                if (inst.rs2 instanceof VirtualReg) {
                    it.previous();
                    if (inst.rs2.stackOffset.imm >= RV32I.ImmBound) {
                        it.add(new AsmLiInst(PhysicalReg.reg("s1"), new Immediate(inst.rs2.stackOffset.imm), null));
                        it.add(new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("s1"), PhysicalReg.reg("s1"), PhysicalReg.reg("sp"), null));
                        it.add(new AsmLoadInst(((VirtualReg) inst.rs2).size, PhysicalReg.t(3), PhysicalReg.reg("s1"), new Immediate(0), null));
                    } else {
                        it.add(new AsmLoadInst(((VirtualReg) inst.rs2).size, PhysicalReg.t(3), PhysicalReg.reg("sp"), inst.rs2.stackOffset, null));
                    }
                    it.next();
                    inst.rs2 = PhysicalReg.t(3);
                }
                else if (inst.rs2 instanceof ArgumentReg) {
                    it.previous();
                    it.add(new AsmLoadInst(((ArgumentReg) inst.rs2).size, PhysicalReg.t(3), PhysicalReg.reg("sp"), inst.rs2.stackOffset, null));
                    it.next();
                    inst.rs2 = PhysicalReg.t(3);
                }

                if (inst.rd instanceof VirtualReg) {
                    if (inst.rd.stackOffset.imm>= RV32I.ImmBound) {
                        it.add(new AsmLiInst(PhysicalReg.reg("s1"), new Immediate(inst.rd.stackOffset.imm), null));
                        it.add(new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("s1"), PhysicalReg.reg("s1"), PhysicalReg.reg("sp"), null));
                        it.add(new AsmStoreInst(((VirtualReg) inst.rd).size, PhysicalReg.reg("s1"), PhysicalReg.t(1), new Immediate(0), null));
                    } else {
                        it.add(new AsmStoreInst(((VirtualReg) inst.rd).size, PhysicalReg.reg("sp"), PhysicalReg.t(1), inst.rd.stackOffset, null));
                    }
                    inst.rd = PhysicalReg.t(1);
                }
                else if (inst.rd instanceof ArgumentReg) {
                    it.add(new AsmStoreInst(((ArgumentReg) inst.rd).size, PhysicalReg.reg("sp"), PhysicalReg.t(1), inst.rd.stackOffset, null));
                    inst.rd = PhysicalReg.t(1);
                }
            }
        }
    }

    /**
     * @param block
     */
    @Override
    public void runBlock(AsmBlock block) {
        //nothing
    }

    /**
     * @param module
     */
    @Override
    public void runModule(AsmModule module) {
        for (AsmFunction function : module.functions) {
            runFunction(function);
        }
    }

    @Override
    public void runFunction(AsmFunction function) {

        function.totalStackUse += function.callStackUse + function.allocaStackUse + function.virtualStackUse;
        if (function.totalStackUse % 16 != 0)
            function.totalStackUse = (function.totalStackUse / 16 + 1) * 16;

        // todo: overflow
        // if (function.stackBase > RV32I.MaxStackSize) throw new StackOverflowError();

        if (function.totalStackUse >= RV32I.ImmBound) {
            function.entryBlock.instructions.addFirst(
                    new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"), PhysicalReg.reg("s1"), null)
            );
            function.entryBlock.instructions.addFirst(
                    new AsmLiInst(PhysicalReg.reg("s1"), new Immediate(-function.totalStackUse), null)
            );
            new AsmLiInst(PhysicalReg.reg("s1"), new Immediate(function.totalStackUse), function.exitBlock);
            new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"), PhysicalReg.reg("s1"), function.exitBlock);
        }
        else {
            function.entryBlock.instructions.addFirst(
                    new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"),
                            new StackOffset(-function.totalStackUse, 0, function), null)
            );
            new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("sp"), PhysicalReg.reg("sp"),
                    new StackOffset(function.totalStackUse, 0, function), function.exitBlock);
        }

        var fpInstPtr = function.entryBlock.instructions.listIterator();
        fpInstPtr.next(); // ra
        fpInstPtr.next(); // s0
        fpInstPtr.next(); // arrive
        if (function.totalStackUse >= RV32I.ImmBound) {
            fpInstPtr.add(
                    new AsmALUInst(RV32I.SubInst, PhysicalReg.reg("s0"), PhysicalReg.reg("sp"), PhysicalReg.reg("s1"), null)
            );
        } else {
            fpInstPtr.add(
                    new AsmALUInst(RV32I.AddInst, PhysicalReg.reg("s0"), PhysicalReg.reg("sp"),
                            new StackOffset(function.totalStackUse, 0, function), null)
            );
        }

        new AsmRetInst(function.exitBlock);

        function.blocks.forEach(block -> {
            block.instructions.forEach(inst -> {
                virtualSet(inst.rd, function);
                virtualSet(inst.rs1, function);
                virtualSet(inst.rs2, function);
            });
        });

        StackOffset.collection.forEach(offset -> {
            if (offset.parentFunction == function) {
                if (offset.level == 1) offset.setStackBase(function.callStackUse);
                else if (offset.level == 2) offset.setStackBase(function.callStackUse + function.allocaStackUse);
            }
        });

        violentAllocator(function);
    }
}
