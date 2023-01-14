package undecimber.compiler.backend.asm.operands;

public class ArgumentReg extends Register {

    public final int size;

    public ArgumentReg(String identifier, int size) {
        super(identifier);
        this.size = size;
    }
}
