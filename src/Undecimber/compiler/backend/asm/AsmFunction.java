package undecimber.compiler.backend.asm;

import undecimber.compiler.backend.asm.operands.BasicOperand;
import undecimber.compiler.backend.asm.operands.Register;

import java.util.ArrayList;

public class AsmFunction extends BasicOperand {
    public final ArrayList<AsmBlock> blocks = new ArrayList<>();
    public final ArrayList<Register> arguments = new ArrayList<>();

    public AsmBlock entryBlock, exitBlock;

    public int
            callerArgStackUse = 0,
            calleeArgStackUse = 0,
            allocaStackUse = 0,
            spillStackUse = 0,
            totalStackUse = 0;

    public AsmFunction(String identifier) {
        super(identifier);
    }
}
