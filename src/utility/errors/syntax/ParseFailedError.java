package utility.errors.syntax;
import utility.Position;
import utility.errors.syntaxError;
public class ParseFailedError extends syntaxError {

    public ParseFailedError(Position pos, String msg){
        super(pos,msg,"ParseFailedError");
    }
}
