package utility.errors;
import utility.Position;

public class semanticError extends error {

    public semanticError( Position pos ,String msg, String name) {
        super("Semantic Error: <"+name+"> "+ msg, pos);
    }

}
