package utility.errors;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import utility.Position;
import utility.errors.*;
import utility.errors.syntax.ParseFailedError;

public class MxErrorListener extends BaseErrorListener
{
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e)
    {
        throw new ParseFailedError(new Position(line, charPositionInLine), msg);
    }
}
