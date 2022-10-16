package undecimber.compiler.frontend.registry;

import utility.types.MxBaseType;
import utility.types.MxFuncType;
import utility.types.VarType;
import undecimber.compiler.frontend.parser.MxParser;
import undecimber.compiler.frontend.scope.FuncScope;

import java.util.ArrayList;

public class FuncRegistry extends BaseRegistry {

    public MxFuncType type;
    public FuncScope scope;
    public ArrayList<VarRegistry> funcArgs;
    //bulitin
    public boolean isBuiltin;

    // default func
    public FuncRegistry(String name) {
        super(name);

        this.scope = new FuncScope();
        this.type = new MxFuncType();
        this.isBuiltin = false;

        type.retType = new VarType(MxBaseType.BuiltinType.VOID);
        type.funcArgsType = new ArrayList<>();

        funcArgs = new ArrayList<>();
    }

    // builtin function
    public FuncRegistry(String name, MxBaseType.BuiltinType retType, VarRegistry... args) {
        super(name);

        this.scope = new FuncScope();
        this.type = new MxFuncType();
        this.isBuiltin = true;

        type.retType = new VarType(retType);

        type.funcArgsType = new ArrayList<>();
        funcArgs = new ArrayList<>();

        for (int i = 0; i < args.length; i++) {
            funcArgs.add(args[i]);
            type.funcArgsType.add(args[i].type);
        }
    }

    // lambda
    public FuncRegistry(MxStarParser.LambdaExpContext ctx) {
        super("", ctx);

        this.scope = new FuncScope();
        this.type = new MxFuncType();
        this.isBuiltin = false;

        type.funcArgsType = new ArrayList<>();
        funcArgs = new ArrayList<>();

        MxStarParser.FuncDefArgsContext funcDefArgsContext = ctx.funcDefArgs();

        if (funcDefArgsContext != null) {
            for (int i = 0; i < funcDefArgsContext.varDefType().size(); ++i) {
                VarRegistry varRegistry = new VarRegistry(funcDefArgsContext.Identifier(i).toString(), funcDefArgsContext.varDefType(i));
                funcArgs.add(varRegistry);
                type.funcArgsType.add(varRegistry.type);
            }
        }
    }

    // normal
    public FuncRegistry(MxStarParser.FuncDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);

        this.scope = new FuncScope();
        this.type = new MxFuncType();
        this.isBuiltin = false;

        type.retType = new VarType(ctx.varDefType(), true);
        type.funcArgsType = new ArrayList<>();
        funcArgs = new ArrayList<>();

        MxStarParser.FuncDefArgsContext funcDefArgsContext = ctx.funcDefArgs();

        if (funcDefArgsContext != null) {
            for (int i = 0; i < funcDefArgsContext.varDefType().size(); ++i) {
                VarRegistry varRegistry = new VarRegistry(funcDefArgsContext.Identifier(i).toString(), funcDefArgsContext.varDefType(i));
                funcArgs.add(varRegistry);
                type.funcArgsType.add(varRegistry.type);
            }
        }
    }

    // constructor
    public FuncRegistry(MxStarParser.ClassConstructorDefContext ctx) {
        super(ctx.Identifier().toString(), ctx);

        this.scope = new FuncScope();
        this.type = new MxFuncType();
        this.isBuiltin = false;

        type.retType = new VarType(MxBaseType.BuiltinType.VOID);

        funcArgs = new ArrayList<>();
    }

    public String toString() {
        StringBuilder ret = new StringBuilder("[FuncRegistry] ");
        ret.append("name: " + name + " ");
        ret.append("type: " + type);
        return ret.toString();
    }
}
