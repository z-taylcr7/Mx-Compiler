package undecimber.compiler.frontend.scope;

import undecimber.compiler.frontend.registry.*;

import java.util.HashMap;

public abstract class BaseScope {

    public HashMap<String, VarRegistry> varTable = new HashMap<>();

    public abstract ClassRegistry getClass(String name);

    public abstract FuncRegistry getFunc(String name);

    public abstract VarRegistry getVar(String name);

    public abstract void register(BaseRegistry registry);
}
