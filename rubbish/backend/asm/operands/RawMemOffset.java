package undecimber.compiler.backend.asm.operands;

public class RawMemOffset extends Immediate {
    public Register pointer;

    public RawMemOffset(Register pointer, int offset) {
        super(offset);
        this.pointer = pointer;
    }
}
