package utility.errors;
import utility.Position;

public class internalError extends error {

    public internalError(Position pos, String msg,String name ) {
        super("Internal Error:<"+name+">" + msg, pos);
    }

}
