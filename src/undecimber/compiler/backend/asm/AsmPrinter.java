package undecimber.compiler.backend.asm;

import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.operands.GlobalReg;
import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.IRModule;
import utility.pass.*;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class AsmPrinter implements AsmPass {
    PrintStream ps;
    String file_name;

    private final static String TAB = "\t";
    public int funcEndCounter = 0;

    public AsmPrinter(PrintStream ps, String file_name) {
        this.ps = ps;
        this.file_name = file_name;
    }

    public void runBlock(AsmBlock block) {
        ps.println(block.id+":");
        for (AsmBaseInst inst : block.instructions) {
            ps.println(TAB+inst.format());
        }
    }


    public void runFunction(AsmFunction function) {
        ps.println(TAB + ".globl" + TAB + function);
        ps.println(TAB + ".p2align" + TAB + "1");
        ps.println(TAB + ".type" + TAB + function + "," + "@function");
        ps.println(function.id + ":");

        for (AsmBlock block : function.blocks) {
            runBlock(block);
        }
        funcEndCounter++;
        ps.println(TAB + ".size" + TAB + function + ", .-" + function);

        ps.println("                            #function ends.");
    }

    public void runModule(AsmModule module) {
        //module
        ps.println(TAB + ".text");

        for (AsmFunction function : module.functions) {
            runFunction(function);
        }
        //glb var
        /*
        	.type	glb,@object             # @glb
            .section	.sbss,"aw",@nobits
            .globl	glb
            .p2align	2
        glb:
            .word	0                       # 0x0
            .size	glb, 4

         */
        for (GlobalReg globalReg : module.globalVars) {
            ps.println(TAB + ".type" + TAB + globalReg + ",@object");
            ps.println(TAB + ".section" + TAB + ".bss");
            ps.println(TAB + ".globl" + TAB + globalReg.id);
            ps.println(globalReg.id + ":");
            ps.println(TAB + ".word" + TAB + 0);
            ps.println(TAB + ".size" + TAB + globalReg.id  + ", 4");
        }

        //str const
        /*
        	.type	.Lanon.strconst,@object # @anon.strconst
            .section	.rodata.str1.1,"aMS",@progbits,1
        .Lanon.strconst:
            .asciz	"aca"
            .size	.Lanon.strconst, 3
         */
        for (GlobalReg globalReg : module.stringConsts) {


            ps.println(TAB + ".type" + TAB + globalReg + ",@object");
            ps.println(TAB + ".section" + TAB + ".rodata");
            ps.println(globalReg.id + ":");
            ps.println(TAB + ".asciz" + TAB + "\"" + globalReg.stringDataFormat() + "\"");
            ps.println(TAB + ".size" + TAB + globalReg.id + ", " + globalReg.stringConst.length());
        }

    }
}
