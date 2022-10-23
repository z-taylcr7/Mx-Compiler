package undecimber.compiler.frontend;
//import undecimber.compiler.frontend.ast.ASTPrinter;
import undecimber.compiler.frontend.ast.ASTPrinter;
import undecimber.compiler.frontend.scope.GlobalScope;
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

import undecimber.compiler.frontend.parser.MxParser;
import undecimber.compiler.frontend.parser.MxLexer;
import undecimber.compiler.frontend.ast.ASTBuilder;
import undecimber.compiler.frontend.ast.nodes.RootNode;


public class Frontend {
    public final RootNode ASTRoot;
    public Frontend() throws Exception
    {
        String name = "testcases/codegen/test.mx";
        String name_= "test.out";
        // InputStream input = new FileInputStream(name);
        //PrintStream output =new PrintStream(name_);
        InputStream input = System.in;
        CharStream charstream = CharStreams.fromStream(input);

        MxLexer lexer = new MxLexer(charstream);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new MxErrorListener());

        MxParser parser = new MxParser(new CommonTokenStream(lexer));
        parser.removeErrorListeners();
        parser.addErrorListener(new MxErrorListener());

        ParseTree parseTreeRoot = parser.mxCode();

        this.ASTRoot = (RootNode) new ASTBuilder().visit(parseTreeRoot);

        new SemanticChecker().visit(this.ASTRoot);
        //new ASTPrinter().visit(this.ASTRoot);

        }
    }
