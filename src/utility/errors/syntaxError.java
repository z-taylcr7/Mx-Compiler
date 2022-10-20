package utility.errors;
import utility.Position;

public class syntaxError extends error {

    public syntaxError(Position pos, String msg,String name) {
        super("SyntaxError: <"+name+">" + msg, pos);
    }

}
