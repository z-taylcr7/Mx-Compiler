package utility.errors.semantic;

import utility.Position;
import utility.errors.semanticError;

public class NameError extends semanticError {
    public static final String undefine="undefined";
    public static final String redefine="redefined";
    public NameError(Position pos,String msg,String name){
        super(pos,msg,name);
    }

}
