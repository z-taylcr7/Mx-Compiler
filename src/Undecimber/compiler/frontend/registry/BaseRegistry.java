package undecimber.compiler.frontend.registry;

import utility.position;
import undedcimber.compiler.middleend.mir.value;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class BaseRegistry {
    public final String name;
    public final position pos;
    public Value value;

    BaseRegistry(String name) {
        this.name = name;
        this.codePos = null;
    }

    BaseRegistry(String name, ParserRuleContext ctx) {
        this.name = name;
        this.codePos = new CodePos(ctx);
    }
}
