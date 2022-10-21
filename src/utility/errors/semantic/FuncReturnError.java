package utility.errors.semantic;

import utility.Position;
import utility.errors.semanticError;

public class FuncReturnError extends semanticError {
    public static final String retTypeNotMatch = "wrong type of argument for the function call";
    public static final String noReturn = "the expression is not a function";
    public FuncReturnError(Position pos ,String msg){
        super(pos,msg,"FuncReturnError");
    }

}

