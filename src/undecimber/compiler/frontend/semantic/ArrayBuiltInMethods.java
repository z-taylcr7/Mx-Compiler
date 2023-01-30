package undecimber.compiler.frontend.semantic;

import undecimber.compiler.frontend.registry.FuncRegistry;
import undecimber.compiler.frontend.scope.ClassScope;
import utility.types.MxBaseType;

public class ArrayBuiltInMethods {
    public static ClassScope scope = new ClassScope();

    static {
        scope.register(
                new FuncRegistry("size", MxBaseType.BasicType.INT)
        );
    }
}
