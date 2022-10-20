package utility.errors.semantic;
import utility.Position;
import utility.errors.semanticError;
public class ScopeError extends semanticError {
    public static final String wrongBreak = "\"break\" not in a loop-statement";
    public static final String wrongContinue = "\"continue\" not in a loop-statement";
    public static final String wrongReturn = "\"return\" not in any function body";
    public static final String wrongThis = "\"this\" not in any class body";
    public ScopeError(Position pos,String msg){
        super(pos,msg,"ScopeError");
    }
}
