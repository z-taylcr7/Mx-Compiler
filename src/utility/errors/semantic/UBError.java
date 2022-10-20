package utility.errors.semantic;
import utility.errors.semanticError;
import utility.Position;

public class UBError extends semanticError {
    public UBError(Position pos, String msg, String name){
        super(pos,msg,name);
    }
}
