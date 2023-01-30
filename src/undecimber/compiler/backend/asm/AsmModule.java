package undecimber.compiler.backend.asm;

import undecimber.compiler.backend.asm.operands.GlobalReg;

import java.util.ArrayList;

public class AsmModule {

    public ArrayList<AsmFunction> functions = new ArrayList<>();
    public ArrayList<GlobalReg> globalVars = new ArrayList<>();
    public ArrayList<GlobalReg> stringConsts = new ArrayList<>();
}
