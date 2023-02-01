package undecimber.compiler.backend;

import undecimber.compiler.backend.asm.AsmBuilder;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.AsmPrinter;
import undecimber.compiler.backend.optim.BackEndOptim;
//import undecimber.compiler.backend.regalloc.StackAllocator;
import undecimber.compiler.backend.regalloc.RegAllocator;
import undecimber.compiler.backend.regalloc.StackAllocator;
import undecimber.compiler.middleend.MiddleEnd;
import utility.BuiltInPrinter;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;

public class BackEnd {

    public final AsmModule module;

    public final ArrayList<AsmFunction> functions = new ArrayList<>();

    public BackEnd(MiddleEnd middleEnd) throws FileNotFoundException {
        // Assembly Builder
        AsmBuilder builder = new AsmBuilder();
        builder.runModule(middleEnd.module);
        this.module = builder.module;

        // Graph Coloring
        new RegAllocator().runModule(this.module);

        // Stack Allocate. Eliminate RawStackOffset
        new StackAllocator().runModule(this.module);

         new BackEndOptim().runModule(this.module);
//        PrintStream ps=System.out;

        PrintStream ps= new PrintStream("output.s");

        new AsmPrinter(ps,"output.s"  ).runModule(this.module);
        BuiltInPrinter biu=new BuiltInPrinter();
        biu.print();
    }
}