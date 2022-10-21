package undecimber.compiler.frontend.semantic;

import undecimber.compiler.frontend.registry.FuncRegistry;
import undecimber.compiler.frontend.registry.VarRegistry;
import undecimber.compiler.frontend.scope.ClassScope;
import utility.types.MxBaseType;

public class StringBuiltInMethods {
    public static ClassScope scope = new ClassScope();

    static {
        scope.register(
                new FuncRegistry("length", MxBaseType.BasicType.INT)
        );

        scope.register(
                new FuncRegistry("substring", MxBaseType.BasicType.STRING,
                        new VarRegistry("left", MxBaseType.BasicType.INT),
                        new VarRegistry("right", MxBaseType.BasicType.INT)
                )
        );

        scope.register(
                new FuncRegistry("parseInt", MxBaseType.BasicType.INT)
        );

        scope.register(
                new FuncRegistry("ord", MxBaseType.BasicType.INT,
                        new VarRegistry("pos", MxBaseType.BasicType.INT))
        );
    }
}
