package undecimber.compiler.frontend.scope;

import undecimber.compiler.frontend.registry.ClassRegistry;
import undecimber.compiler.frontend.registry.FuncRegistry;
import undecimber.compiler.frontend.registry.BaseRegistry;
import undecimber.compiler.frontend.registry.VarRegistry;
import utility.errors.semantic.NameError;

import java.util.ArrayList;
import java.util.HashMap;

public class GlobalScope extends BaseScope {

    public HashMap<String, ClassRegistry> classTable;
    public HashMap<String, FuncRegistry> funcTable;
    public ArrayList<FuncRegistry> builtinFuncList;

    public GlobalScope() {
        this.classTable = new HashMap<>();
        this.funcTable = new HashMap<>();
        this.varTable = new HashMap<>();
        this.builtinFuncList = new ArrayList<>();
    }

    @Override
    public ClassRegistry getClass(String name) {
        return classTable.get(name);
    }

    @Override
    public FuncRegistry getFunc(String name) {
        return funcTable.get(name);
    }

    @Override
    public VarRegistry getVar(String name) {
        return varTable.get(name);
    }

    @Override
    public void register(BaseRegistry registry) {
        String name = registry.name;
        if (classTable.containsKey(name))
            //cc

            throw new NameError(registry.pos, NameError.redefine,name);
        if (registry instanceof ClassRegistry) {
            //cf cv
            if (funcTable.containsKey(name) || varTable.containsKey(name))
                throw new NameError(registry.pos, NameError.redefine,name);
            classTable.put(name, (ClassRegistry) registry);
        } else if (registry instanceof FuncRegistry) {
            //ff
            if (funcTable.containsKey(name))
                throw new NameError(registry.pos, NameError.redefine,name);
            funcTable.put(name, (FuncRegistry) registry);
            if (((FuncRegistry) registry).isBasic) {
                builtinFuncList.add((FuncRegistry) registry);
            }
        } else if (registry instanceof VarRegistry) {
            //vv
            if (varTable.containsKey(name))
                throw new NameError(registry.pos, NameError.redefine,name);
            varTable.put(name, (VarRegistry) registry);
        }
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[GlobalScope]\n");
        ret.append("VarTable: ").append(varTable.toString()).append("\n");
        ret.append("FuncTable: ").append(funcTable.toString()).append("\n");
        ret.append("ClassTable: ").append(classTable.toString());
        return ret.toString();
    }
}
