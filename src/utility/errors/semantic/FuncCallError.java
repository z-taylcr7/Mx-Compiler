package utility.errors.semantic;

import utility.Position;
import utility.errors.semanticError;

public class FuncCallError extends semanticError {
    public static final String argsNotMatch = "wrong number of arguments for the function call";
    public static final String argTypeNotMatch = "wrong type of argument for the function call";
    public static final String expNotAFunc = "the expression is not a function";
    public FuncCallError(Position pos,String msg ){
        super(pos,msg,"FuncCallError");
    }

}
