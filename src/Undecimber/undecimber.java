import utility.Error;
import utility.MxErrorListener;
import utility.position;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import java.io.IOException;
import java.io.InputStream;
import undecimber.compiler.frontend.parser.MxParser;
import undecimber.compiler.frontend.parser.MxLexer;



public class Compiler
{
    public static void main(String[] args) throws IOException
    {
        InputStream input_stream = System.in;
        CharStream charstream = CharStreams.fromStream(input_stream);
        // My compiler thought that everything goes so wrong that
        // no code should pass sementic check.
        try {
            MxLexer lexer = new MxLexer(CharStreams.fromStream(input));
            lexer.removeErrorListeners();
            lexer.addErrorListener(new MxErrorListener());
            MxParser parser = new MxParser(new CommonTokenStream(lexer));
            parser.removeErrorListeners();
            parser.addErrorListener(new MxErrorListener());
            ParseTree parseTreeRoot = parser.program();
        } catch (error er) {
            System.err.println(er.toString());
            throw new RuntimeException();
        }
    }
}