package undecimber.compiler.middleend.llvmir.irconst;

import undecimber.compiler.middleend.llvmir.User;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;

public class IRConst extends User {
    public IRConst(String name, IRBaseType type) {
        super(name, type);
    }
}
