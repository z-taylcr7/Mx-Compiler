package utility.errors.semantic;

import utility.Position;
import utility.errors.semanticError;

public class FuncReturnError extends semanticError {
    public static final String retTypeNotMatch = "wrong type of argument for the function call";
    public static final String noReturn = "the expression is not a function";
    public FuncReturnError(String msg, Position pos){
        super(pos,msg,"FuncReturnError");
    }

}

