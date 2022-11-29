package undecimber.compiler.middleend.llvmir.irtype;
import undecimber.compiler.middleend.llvmir.StructProto;
import utility.LLVM;
import java.util.ArrayList;
import java.util.Objects;
public class IRStructType extends IRBaseType{
    public final String structName;
    public final StructProto structProto;
    public ArrayList<IRBaseType> memberVarTypes = new ArrayList<>();

    public IRStructType(String structName) {
        this.structName = structName;
       this.structProto = new StructProto(LLVM.StructPrefix + structName, this);

    }

    @Override
    public boolean match(IRBaseType other) {
        return other instanceof IRStructType && Objects.equals(structName, ((IRStructType) other).structName);
    }

    @Override
    public int size() {
        int ret = 0;
        for (IRBaseType memberVarType : memberVarTypes) ret += memberVarType.size();
        return ret;
    }

    public int memberOffset(int index) {
        int ret = 0;
        for (int i = 0; i < index; ++i) ret += memberVarTypes.get(i).size();
        return ret;
    }
    @Override
    public String toString() {
        return "IRStructType{" +
                "structName='" + structName + '\'' +
                ", memberVarTypes=" + memberVarTypes +
                '}';
    }
}
