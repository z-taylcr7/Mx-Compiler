package utility.types;

import java.util.HashMap;

public abstract class MxBaseType {
    public enum BuiltinType {NULL, INT, BOOL, VOID, FUNC, STRING, CLASS  }

    public BuiltinType builtinType;

    public abstract boolean match(MxBaseType other);

    public abstract boolean match(BuiltinType other);

    public abstract MxBaseType copy();

    public abstract boolean isArray();

    public MxBaseType(BuiltinType builtinType) {
        this.builtinType = builtinType;
    }
}