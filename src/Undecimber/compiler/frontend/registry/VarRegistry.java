package undecimber.compiler.frontend.registry;

import utility.type.MxBaseType;
import utility.type.VarType;
import undecimber.compiler.frontend.parser.MxParser;

import java.util.ArrayList;

public class VarRegistry extends BaseRegistry {
    public VarType type;
    public ArrayList<VarRegistry> eachDimLength;

    public VarRegistry(String name, MxBaseType.BasicType basicType) {
        super(name);
        type = new VarType(basicType);
        eachDimLength = new ArrayList<>();
    }

    public VarRegistry(String name, MxParser.VarDefSingleContext ctx) {
        super(name, ctx);
        eachDimLength = new ArrayList<>();
    }

    public VarRegistry(String name, MxParser.VarDefTypeContext ctx) {
        super(name, ctx);
        this.type = new VarType(ctx);
        eachDimLength = new ArrayList<>();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[VarRegistry] ");
        ret.append(type + "|" + name);
        return ret.toString();
    }
}
