package utility.types;

import java.util.HashMap;

public abstract class MxBaseType {
    public enum BasicType {NULL, INT, BOOL, VOID, FUNC, STRING, CLASS}

    public BasicType basicType;

    public abstract boolean match(MxBaseType other);

    public abstract boolean match(BasicType other);

    public abstract MxBaseType copy();

    public abstract boolean isArray();

    public MxBaseType(BasicType basicType) {
        this.basicType = basicType;
    }
}