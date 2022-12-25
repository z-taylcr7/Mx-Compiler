package undecimber.compiler.backend.asm.operands;

public class GlobalReg extends Register {
    public String stringConst;

    public GlobalReg(String identifier) {
        super(identifier);
    }

    public GlobalReg(String identifier, String stringConst) {
        super(identifier);
        this.stringConst = stringConst;
    }

    public String stringDataFormat() {
        return stringConst.replace("\"", "\\\"")
                .replace("\\", "\\\\")
                .replace("\n", "\\n")
                .replace("\0", "")
                .replace("\t", "\\t");
    }
}
