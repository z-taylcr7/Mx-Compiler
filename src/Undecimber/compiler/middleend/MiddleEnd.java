package undecimber.compiler.middleend;

import undecimber.compiler.frontend.Frontend;
import undecimber.compiler.middleend.llvmir.IRBuilder;
import undecimber.compiler.middleend.llvmir.IRModule;
import undecimber.compiler.middleend.llvmir.IRPrinter;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.opt.MidOptim;

import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

public class MiddleEnd {
    public final IRModule module;
    public MiddleEnd (Frontend frontend) throws Exception {
//        PrintStream ps= new PrintStream("testcases/aruba.ll");
        PrintStream ps= System.out;
        Value.rename=true;
        this.module=new IRBuilder(frontend.ASTRoot).module;
        new MidOptim().runModule(this.module);
        //new IRPrinter(ps,"test.mx").runModule(this.module);
    }

}
