package utility.errors.semantic;

import utility.position;
import utility.errors.semanticError;
import utility.types.MxBaseType;

public class TypeError extends SemanticError {

    public static final String typeNotMatch = "Type mismatched between: ";
    public static final String typeNotSubscribable = "Type not subscribable: ";
    public static final String typeNotCallable = "type not callable: ";
    public static final String canNotBeVoid = "\"void\" type can only use in function return type";

    public static final String invalidOpForType = "invalid operation for type: ";

    public static final String assignment = "the expression on the left side of the assign-op should be a left-value";
    public static final String prefixAndPostfix = "expecting a left-value in prefix/postfix expression";

    public TypeError(position pos, MxBaseType lhs, MxBaseType rhs) {
        super(pos, typeNotMatch + "\"" +  lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(position pos, MxBaseType.BuiltinType lhs, MxBaseType rhs) {
        super(pos, typeNotMatch + "\"" + lhs + "\" and \"" + rhs + "\"", "TypeError");
    }

    public TypeError(position pos, String message, MxBaseType type) {
        super(pos, message + type, "TypeError");
    }

    public TypeError(position pos, String message) {
        super(pos, message, "TypeError");
    }
}