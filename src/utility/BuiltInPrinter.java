package utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class BuiltInPrinter {
    public BuiltInPrinter(){

    }
    public static String bi="\t.text\n" +
            "\t.file\t\"builtin.c\"\n" +
            "\t.globl\t_bot_malloc             # -- Begin function _bot_malloc\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_bot_malloc,@function\n" +
            "_bot_malloc:                            # @_bot_malloc\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\tsrai\ta1, a0, 31\n" +
            "\ttail\tmalloc\n" +
            ".Lfunc_end0:\n" +
            "\t.size\t_bot_malloc, .Lfunc_end0-_bot_malloc\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_bot_str_cat            # -- Begin function _bot_str_cat\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_bot_str_cat,@function\n" +
            "_bot_str_cat:                           # @_bot_str_cat\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -32\n" +
            "\t.cfi_def_cfa_offset 32\n" +
            "\tsw\tra, 28(sp)\n" +
            "\tsw\ts0, 24(sp)\n" +
            "\tsw\ts1, 20(sp)\n" +
            "\tsw\ts2, 16(sp)\n" +
            "\tsw\ts3, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\t.cfi_offset s0, -8\n" +
            "\t.cfi_offset s1, -12\n" +
            "\t.cfi_offset s2, -16\n" +
            "\t.cfi_offset s3, -20\n" +
            "\tmv\ts2, a1\n" +
            "\tmv\ts3, a0\n" +
            "\tcall\tstrlen\n" +
            "\tmv\ts0, a0\n" +
            "\tmv\ts1, a1\n" +
            "\tmv\ta0, s2\n" +
            "\tcall\tstrlen\n" +
            "\tadd\ta1, s1, a1\n" +
            "\tadd\ta2, s0, a0\n" +
            "\tsltu\ta0, a2, s0\n" +
            "\tadd\ta1, a1, a0\n" +
            "\taddi\ta0, a2, 1\n" +
            "\tsltu\ta2, a0, a2\n" +
            "\tadd\ta1, a1, a2\n" +
            "\tcall\tmalloc\n" +
            "\tmv\ts0, a0\n" +
            "\tmv\ta1, s3\n" +
            "\tcall\tstrcpy\n" +
            "\tmv\ta0, s0\n" +
            "\tmv\ta1, s2\n" +
            "\tlw\ts3, 12(sp)\n" +
            "\tlw\ts2, 16(sp)\n" +
            "\tlw\ts1, 20(sp)\n" +
            "\tlw\ts0, 24(sp)\n" +
            "\tlw\tra, 28(sp)\n" +
            "\taddi\tsp, sp, 32\n" +
            "\ttail\tstrcat\n" +
            ".Lfunc_end1:\n" +
            "\t.size\t_bot_str_cat, .Lfunc_end1-_bot_str_cat\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_bot_str_eq             # -- Begin function _bot_str_eq\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_bot_str_eq,@function\n" +
            "_bot_str_eq:                            # @_bot_str_eq\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tcall\tstrcmp\n" +
            "\tseqz\ta0, a0\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end2:\n" +
            "\t.size\t_bot_str_eq, .Lfunc_end2-_bot_str_eq\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_bot_str_neq            # -- Begin function _bot_str_neq\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_bot_str_neq,@function\n" +
            "_bot_str_neq:                           # @_bot_str_neq\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tcall\tstrcmp\n" +
            "\tsnez\ta0, a0\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end3:\n" +
            "\t.size\t_bot_str_neq, .Lfunc_end3-_bot_str_neq\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_bot_str_slt            # -- Begin function _bot_str_slt\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_bot_str_slt,@function\n" +
            "_bot_str_slt:                           # @_bot_str_slt\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tcall\tstrcmp\n" +
            "\tsrli\ta0, a0, 31\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end4:\n" +
            "\t.size\t_bot_str_slt, .Lfunc_end4-_bot_str_slt\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_bot_str_sle            # -- Begin function _bot_str_sle\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_bot_str_sle,@function\n" +
            "_bot_str_sle:                           # @_bot_str_sle\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tcall\tstrcmp\n" +
            "\tslti\ta0, a0, 1\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end5:\n" +
            "\t.size\t_bot_str_sle, .Lfunc_end5-_bot_str_sle\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_bot_str_sgt            # -- Begin function _bot_str_sgt\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_bot_str_sgt,@function\n" +
            "_bot_str_sgt:                           # @_bot_str_sgt\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tcall\tstrcmp\n" +
            "\tsgtz\ta0, a0\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end6:\n" +
            "\t.size\t_bot_str_sgt, .Lfunc_end6-_bot_str_sgt\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_bot_str_sge            # -- Begin function _bot_str_sge\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_bot_str_sge,@function\n" +
            "_bot_str_sge:                           # @_bot_str_sge\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tcall\tstrcmp\n" +
            "\tnot\ta0, a0\n" +
            "\tsrli\ta0, a0, 31\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end7:\n" +
            "\t.size\t_bot_str_sge, .Lfunc_end7-_bot_str_sge\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\tprint                   # -- Begin function print\n" +
            "\t.p2align\t2\n" +
            "\t.type\tprint,@function\n" +
            "print:                                  # @print\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\tlui\ta1, %hi(.L.str)\n" +
            "\taddi\ta1, a1, %lo(.L.str)\n" +
            "\tmv\ta2, a0\n" +
            "\tmv\ta0, a1\n" +
            "\tmv\ta1, a2\n" +
            "\ttail\tprintf\n" +
            ".Lfunc_end8:\n" +
            "\t.size\tprint, .Lfunc_end8-print\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\tprintln                 # -- Begin function println\n" +
            "\t.p2align\t2\n" +
            "\t.type\tprintln,@function\n" +
            "println:                                # @println\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\ttail\tputs\n" +
            ".Lfunc_end9:\n" +
            "\t.size\tprintln, .Lfunc_end9-println\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\tprintInt                # -- Begin function printInt\n" +
            "\t.p2align\t2\n" +
            "\t.type\tprintInt,@function\n" +
            "printInt:                               # @printInt\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\tlui\ta1, %hi(.L.str.2)\n" +
            "\taddi\ta1, a1, %lo(.L.str.2)\n" +
            "\tmv\ta2, a0\n" +
            "\tmv\ta0, a1\n" +
            "\tmv\ta1, a2\n" +
            "\ttail\tprintf\n" +
            ".Lfunc_end10:\n" +
            "\t.size\tprintInt, .Lfunc_end10-printInt\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\tprintlnInt              # -- Begin function printlnInt\n" +
            "\t.p2align\t2\n" +
            "\t.type\tprintlnInt,@function\n" +
            "printlnInt:                             # @printlnInt\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\tlui\ta1, %hi(.L.str.3)\n" +
            "\taddi\ta1, a1, %lo(.L.str.3)\n" +
            "\tmv\ta2, a0\n" +
            "\tmv\ta0, a1\n" +
            "\tmv\ta1, a2\n" +
            "\ttail\tprintf\n" +
            ".Lfunc_end11:\n" +
            "\t.size\tprintlnInt, .Lfunc_end11-printlnInt\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\tgetString               # -- Begin function getString\n" +
            "\t.p2align\t2\n" +
            "\t.type\tgetString,@function\n" +
            "getString:                              # @getString\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\t.cfi_offset s0, -8\n" +
            "\taddi\ta0, zero, 256\n" +
            "\tmv\ta1, zero\n" +
            "\tcall\tmalloc\n" +
            "\tmv\ts0, a0\n" +
            "\tlui\ta0, %hi(.L.str)\n" +
            "\taddi\ta0, a0, %lo(.L.str)\n" +
            "\tmv\ta1, s0\n" +
            "\tcall\t__isoc99_scanf\n" +
            "\tmv\ta0, s0\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end12:\n" +
            "\t.size\tgetString, .Lfunc_end12-getString\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\tgetInt                  # -- Begin function getInt\n" +
            "\t.p2align\t2\n" +
            "\t.type\tgetInt,@function\n" +
            "getInt:                                 # @getInt\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tlui\ta0, %hi(.L.str.2)\n" +
            "\taddi\ta0, a0, %lo(.L.str.2)\n" +
            "\taddi\ta1, sp, 8\n" +
            "\tcall\t__isoc99_scanf\n" +
            "\tlw\ta0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end13:\n" +
            "\t.size\tgetInt, .Lfunc_end13-getInt\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\ttoString                # -- Begin function toString\n" +
            "\t.p2align\t2\n" +
            "\t.type\ttoString,@function\n" +
            "toString:                               # @toString\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\tsw\ts0, 8(sp)\n" +
            "\tsw\ts1, 4(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\t.cfi_offset s0, -8\n" +
            "\t.cfi_offset s1, -12\n" +
            "\tmv\ts0, a0\n" +
            "\taddi\ta0, zero, 20\n" +
            "\tmv\ta1, zero\n" +
            "\tcall\tmalloc\n" +
            "\tmv\ts1, a0\n" +
            "\tlui\ta0, %hi(.L.str.2)\n" +
            "\taddi\ta1, a0, %lo(.L.str.2)\n" +
            "\tmv\ta0, s1\n" +
            "\tmv\ta2, s0\n" +
            "\tcall\tsprintf\n" +
            "\tmv\ta0, s1\n" +
            "\tlw\ts1, 4(sp)\n" +
            "\tlw\ts0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end14:\n" +
            "\t.size\ttoString, .Lfunc_end14-toString\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_str_length             # -- Begin function _str_length\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_str_length,@function\n" +
            "_str_length:                            # @_str_length\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tcall\tstrlen\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end15:\n" +
            "\t.size\t_str_length, .Lfunc_end15-_str_length\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_str_substring          # -- Begin function _str_substring\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_str_substring,@function\n" +
            "_str_substring:                         # @_str_substring\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -32\n" +
            "\t.cfi_def_cfa_offset 32\n" +
            "\tsw\tra, 28(sp)\n" +
            "\tsw\ts0, 24(sp)\n" +
            "\tsw\ts1, 20(sp)\n" +
            "\tsw\ts2, 16(sp)\n" +
            "\tsw\ts3, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\t.cfi_offset s0, -8\n" +
            "\t.cfi_offset s1, -12\n" +
            "\t.cfi_offset s2, -16\n" +
            "\t.cfi_offset s3, -20\n" +
            "\tmv\ts3, a1\n" +
            "\tmv\ts2, a0\n" +
            "\tsub\ts1, a2, a1\n" +
            "\taddi\ta0, s1, 1\n" +
            "\tsrai\ta1, a0, 31\n" +
            "\tcall\tmalloc\n" +
            "\tmv\ts0, a0\n" +
            "\tadd\ta1, s2, s3\n" +
            "\tmv\ta2, s1\n" +
            "\tcall\tmemcpy\n" +
            "\tadd\ta0, s0, s1\n" +
            "\tsb\tzero, 0(a0)\n" +
            "\tmv\ta0, s0\n" +
            "\tlw\ts3, 12(sp)\n" +
            "\tlw\ts2, 16(sp)\n" +
            "\tlw\ts1, 20(sp)\n" +
            "\tlw\ts0, 24(sp)\n" +
            "\tlw\tra, 28(sp)\n" +
            "\taddi\tsp, sp, 32\n" +
            "\tret\n" +
            ".Lfunc_end16:\n" +
            "\t.size\t_str_substring, .Lfunc_end16-_str_substring\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_str_parseInt           # -- Begin function _str_parseInt\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_str_parseInt,@function\n" +
            "_str_parseInt:                          # @_str_parseInt\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\taddi\tsp, sp, -16\n" +
            "\t.cfi_def_cfa_offset 16\n" +
            "\tsw\tra, 12(sp)\n" +
            "\t.cfi_offset ra, -4\n" +
            "\tlui\ta1, %hi(.L.str.2)\n" +
            "\taddi\ta1, a1, %lo(.L.str.2)\n" +
            "\taddi\ta2, sp, 8\n" +
            "\tcall\t__isoc99_sscanf\n" +
            "\tlw\ta0, 8(sp)\n" +
            "\tlw\tra, 12(sp)\n" +
            "\taddi\tsp, sp, 16\n" +
            "\tret\n" +
            ".Lfunc_end17:\n" +
            "\t.size\t_str_parseInt, .Lfunc_end17-_str_parseInt\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.globl\t_str_ord                # -- Begin function _str_ord\n" +
            "\t.p2align\t2\n" +
            "\t.type\t_str_ord,@function\n" +
            "_str_ord:                               # @_str_ord\n" +
            "\t.cfi_startproc\n" +
            "# %bb.0:\n" +
            "\tadd\ta0, a0, a1\n" +
            "\tlb\ta0, 0(a0)\n" +
            "\tret\n" +
            ".Lfunc_end18:\n" +
            "\t.size\t_str_ord, .Lfunc_end18-_str_ord\n" +
            "\t.cfi_endproc\n" +
            "                                        # -- End function\n" +
            "\t.type\tIO_BUFFER_SIZE,@object  # @IO_BUFFER_SIZE\n" +
            "\t.section\t.rodata,\"a\",@progbits\n" +
            "\t.globl\tIO_BUFFER_SIZE\n" +
            "\t.p2align\t2\n" +
            "IO_BUFFER_SIZE:\n" +
            "\t.word\t256                     # 0x100\n" +
            "\t.size\tIO_BUFFER_SIZE, 4\n" +
            "\n" +
            "\t.type\tNUM_BUFFER_SIZE,@object # @NUM_BUFFER_SIZE\n" +
            "\t.globl\tNUM_BUFFER_SIZE\n" +
            "\t.p2align\t2\n" +
            "NUM_BUFFER_SIZE:\n" +
            "\t.word\t20                      # 0x14\n" +
            "\t.size\tNUM_BUFFER_SIZE, 4\n" +
            "\n" +
            "\t.type\t.L.str,@object          # @.str\n" +
            "\t.section\t.rodata.str1.1,\"aMS\",@progbits,1\n" +
            ".L.str:\n" +
            "\t.asciz\t\"%s\"\n" +
            "\t.size\t.L.str, 3\n" +
            "\n" +
            "\t.type\t.L.str.2,@object        # @.str.2\n" +
            ".L.str.2:\n" +
            "\t.asciz\t\"%d\"\n" +
            "\t.size\t.L.str.2, 3\n" +
            "\n" +
            "\t.type\t.L.str.3,@object        # @.str.3\n" +
            ".L.str.3:\n" +
            "\t.asciz\t\"%d\\n\"\n" +
            "\t.size\t.L.str.3, 4\n" +
            "\n" +
            "\t.ident\t\"clang version 10.0.0-4ubuntu1 \"\n" +
            "\t.section\t\".note.GNU-stack\",\"\",@progbits\n";
    public void print()throws FileNotFoundException {
        File builtIn=new File("builtin.s");
        PrintStream ps=new PrintStream(builtIn);
        ps.print(bi);
        ps.close();
    }
}
