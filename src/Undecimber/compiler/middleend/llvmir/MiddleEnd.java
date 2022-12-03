package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.frontend.Frontend;

import java.io.PrintStream;

public class MiddleEnd {
    public final IRModule module;
    public MiddleEnd (Frontend frontend){
        PrintStream ps=System.out;
        Value.rename=false;
        this.module=new IRBuilder(frontend.ASTRoot).module;
        new IRPrinter(ps,"testcases/aruba.mx").runModule(this.module);
    }

}
