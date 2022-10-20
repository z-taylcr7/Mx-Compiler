package undecimber.compiler.frontend.registry;

import utility.Position;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class BaseRegistry {
    public final String name;
    public final Position pos;

    BaseRegistry(String name) {
        this.name = name;
        this.pos = null;
    }

    BaseRegistry(String name, ParserRuleContext ctx) {
        this.name = name;
        this.pos= new Position(ctx);
    }
}
