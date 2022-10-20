package utility.errors.syntax;

import utility.Position;
import utility.errors.syntaxError;

public class ArrayDeclarationError extends syntaxError {
    public static final String outOfSize="first declare the outer dimension!";
    public static final String undefinedSize="size undefined";
    public ArrayDeclarationError(Position pos,String msg){
        super(pos,msg,"ArrayDeclarationError");
    }

}
