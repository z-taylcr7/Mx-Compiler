package undecimber.compiler.frontend.scope;

import undecimber.compiler.frontend.registry.*;

public class NormalScope extends BaseScope {

    @Override
    public ClassRegistry getClass(String name) {
        return null;
    }

    @Override
    public FuncRegistry getFunc(String name) {
        return null;
    }

    @Override
    public VarRegistry getVar(String name) {
        return varTable.get(name);
    }

    @Override
    public void register(BaseRegistry registry) {
        String name = registry.name;
        if (varTable.containsKey(name))
            //throw new NameError(registry.pos,  name);
        varTable.put(name, (VarRegistry) registry);
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[NormalScope]\n");
        ret.append("VarTable: ").append(varTable.toString());
        return ret.toString();
    }
}
