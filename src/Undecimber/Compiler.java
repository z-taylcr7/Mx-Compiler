package undecimber;
import undecimber.compiler.frontend.semantic.SemanticChecker;
import utility.errors.MxErrorListener;
import utility.errors.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.PrintStream;

import undecimber.compiler.frontend.Frontend;
import undecimber.compiler.frontend.parser.MxParser;
import undecimber.compiler.frontend.parser.MxLexer;
import undecimber.compiler.frontend.ast.ASTBuilder;
import undecimber.compiler.frontend.ast.nodes.RootNode;
public class Compiler {
    public static void main(String[] args) throws Exception {


            Frontend frontend = new Frontend();


    }
    private static void errorHandle(Exception e) {
        if (e instanceof error) {
            ((error) e).tell();
            throw new RuntimeException();
        } else {
            e.printStackTrace();
        }
    }
}
