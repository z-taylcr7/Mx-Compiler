package utility.errors.semantic;

import utility.Position;
import utility.errors.semanticError;
import utility.types.MxBaseType;

public class TypeError extends semanticError {

    public static final String typeNotMatch = "Type mismatched between: ";
    public static final String typeNotSubscribable = "Type not subscribable: ";
    public static final String typeNotCallable = "type not callable: ";
    public static final String canNotBeVoid = "\"void\" type can only use in function return type";

    public static final String invalidOpForType = "invalid operation for type: ";

    public static final String assignment = "the expression on the left side of the assign-op should be a left-value";
    public static final String prefixAndSuffix = "expecting a left-value in prefix/suffix expression";

    public TypeError(Position pos, MxBaseType lhs, MxBaseType rhs) {
        super(pos, typeNotMatch + "\"" +  lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(Position pos, MxBaseType.BasicType lhs, MxBaseType rhs) {
        super(pos, typeNotMatch + "\"" + lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(Position pos, String message, MxBaseType type) {
        super(pos, message + type, "TypeError");
    }

    public TypeError(Position pos, String message) {
        super(pos, message, "TypeError");
    }
}