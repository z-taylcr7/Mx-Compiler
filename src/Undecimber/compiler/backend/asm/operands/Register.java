package undecimber.compiler.backend.asm.operands;


import undecimber.compiler.backend.regalloc.InterferenceGraph;

public abstract class Register extends BasicOperand {

    // assigned in RegisterAllocator
    public PhysicalReg color;

    // location in stack, only spill registers have (graphColor spill & function call spill)
    public RawStackOffset stackOffset;

    // info in InterferenceGraph, used in RegAlloc
     public InterferenceGraph.node node = new InterferenceGraph.node();

    public Register(String identifier) { super(identifier);}

    @Override
    public String toString() {
        if (color == null) {
            return id;
            // throw new InternalError(this);
        }
        return color.id;
        // return identifier;
    }
}
