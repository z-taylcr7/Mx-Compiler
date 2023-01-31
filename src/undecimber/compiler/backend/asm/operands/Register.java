package undecimber.compiler.backend.asm.operands;


import undecimber.compiler.backend.regalloc.RIG;

public abstract class Register extends BasicOperand {

    public PhysicalReg color;

    public RawStackOffset stackOffset;
     public RIG.Node node = new RIG.Node();

    public Register(String identifier) { super(identifier);}

    @Override
    public String toString() {
        if (color == null) {
            return id;
        }
        return color.id;
    }
}
