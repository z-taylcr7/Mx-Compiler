package undecimber.compiler.backend.asm.operands;

import utility.RV32I;

public class VirtualReg extends Register {

    public static int virtualRegNum = 0;
    public static void setVirtualRegNumZero() {
        virtualRegNum = 0;
    }

    public final int num, size;

    public VirtualReg() {
        super(RV32I.VirtualRegPrefix + virtualRegNum);
        this.num = virtualRegNum;
        this.size = 4;
        virtualRegNum++;
    }

    public VirtualReg(int size) {
        super(RV32I.VirtualRegPrefix + virtualRegNum);
        this.num = virtualRegNum;
        this.size = size;
        virtualRegNum++;
    }
}
