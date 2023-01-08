package undecimber.compiler.backend;

import undecimber.compiler.backend.asm.AsmBuilder;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.AsmPrinter;
import undecimber.compiler.backend.regalloc.RegAllocator;
import undecimber.compiler.backend.regalloc.StackAllocator;
import undecimber.compiler.middleend.MiddleEnd;

import java.io.PrintStream;
import java.util.ArrayList;

public class BackEnd {

    public final AsmModule module;

    public final ArrayList<AsmFunction> functions = new ArrayList<>();

    public BackEnd(MiddleEnd middleEnd) {
        // Assembly Builder
        AsmBuilder builder = new AsmBuilder();
        builder.runModule(middleEnd.module);
        this.module = builder.module;

        // Graph Coloring
        //new RegAllocator().runModule(this.module);

        // Stack Allocate. Eliminate RawStackOffset
        //new StackAllocator().runModule(this.module);

        // Optimize Assembly. Don't comment it directly because there are some necessary passes.
        //new BackEndOptimizer().runOnModule(this.module);
        PrintStream ps=System.out;

        new AsmPrinter(ps,
                "test.in"
        ).runModule(this.module);
    }
}