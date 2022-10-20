package undecimber.compiler.frontend.registry;

import undecimber.compiler.frontend.parser.MxParser;
import undecimber.compiler.frontend.scope.ClassScope;

import java.util.ArrayList;

public class ClassRegistry extends BaseRegistry {

    public ClassScope scope;
    public ArrayList<VarRegistry> memberVars;
    public ArrayList<FuncRegistry> memberFuncs;

    public String toString() {
        StringBuilder ret = new StringBuilder("[ClassRegistry] ");
        ret.append("\nname:" + name + " ");
        ret.append("\nscope:" + scope + " ");
        return ret.toString();
    }
    public ClassRegistry(MxParser.ClassDefContext ctx) {
        super(ctx.ID().toString(), ctx);
        this.scope = new ClassScope();
        memberVars = new ArrayList<>();
        memberFuncs = new ArrayList<>();
    }

    // IR GetElementPtr
    public int getMemberVarIndex(String memberVarName) {
        for (int i = 0; i < memberVars.size(); i++)
            if (memberVars.get(i).name.equals(memberVarName)) return i;
        return -1;
    }

}
