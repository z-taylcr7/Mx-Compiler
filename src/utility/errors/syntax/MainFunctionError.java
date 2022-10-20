package utility.errors.syntax;

import utility.Position;
import utility.errors.syntaxError;

public class MainFunctionError extends syntaxError {
    public static String cantFindMain="can't find valid main function";
    public MainFunctionError(Position pos,String msg){
        super(pos,msg,"MainFunctionError");
    }
}
