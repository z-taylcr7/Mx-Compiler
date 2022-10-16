package undecimber.compiler.frontend.scope;

import undecimber.compiler.frontend.registry.VarRegistry;

import utility.types.VarType;

import java.util.ArrayList;

public class FuncScope extends NormalScope {

    public ArrayList<VarType> catchedRetTypeList = new ArrayList<>();
}
