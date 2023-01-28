package undecimber.compiler.backend.asm.operands;


import undecimber.compiler.backend.regalloc.InterferenceGraph;

public abstract class Register extends BasicOperand {

    public PhysicalReg color;

    public RawStackOffset stackOffset;
     public InterferenceGraph.node node = new InterferenceGraph.node();

    public Register(String identifier) { super(identifier);}

    @Override
    public String toString() {
        if (color == null) {
            return id;
        }
        return color.id;
    }
}
