package undecimber.compiler.backend.asm.insts;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.operands.Immediate;
import undecimber.compiler.backend.asm.operands.PhysicalReg;
import undecimber.compiler.backend.asm.operands.Register;

import java.util.HashSet;

public abstract class AsmBaseInst {
    public Immediate imm;
    public Register rs1,rs2,rd;
    public AsmBaseInst(Register rd, Register rs1, Register rs2, Immediate imm, AsmBlock blk){
        this.imm=imm;
        this.rs1=rs1;
        this.rs2=rs2;
        this.rd=rd;
        if(blk!=null)blk.addInst(this);
    }
    public HashSet<Register> uses() {
        HashSet<Register>ret=new HashSet<>();
        if(rs1!=null)ret.add(rs1);
        if(rs2!=null)ret.add(rs2);
        return ret;
    }


    public HashSet<Register> defs(){
        HashSet<Register>ret=new HashSet<>();
        if(rd!=null)ret.add(rd);
        return ret;
    };

    public void replaceUse(Register oldUse, Register newUse) {
        if (rs1 == oldUse) rs1 = newUse;
        if (rs2 == oldUse) rs2 = newUse;
    }

    public void replaceDef(Register oldDef, Register newDef) {
        if (rd == oldDef) {
            rd = newDef;
        }
    }
    public String format(){
        return "undefined";
    }
}
