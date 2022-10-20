package utility.errors.syntax;

import utility.Position;
import utility.errors.syntaxError;

public class ClassDeclarationError extends syntaxError {

    public static final String constructorNameWrong = "the name of constructor should be consistent with class";
    public ClassDeclarationError(Position pos, String msg) {
        super(pos, msg, "ClassDeclarationError");
    }
}
