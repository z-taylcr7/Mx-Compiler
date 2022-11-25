package undecimber.compiler.middleend.llvmir.irconst;

import undecimber.compiler.middleend.llvmir.irtype.IRIntType;
import undecimber.compiler.middleend.llvmir.irtype.IRStringType;
import utility.LLVM;

import java.util.Objects;

public class StringConst extends IRConst{
    String str;
    public StringConst(String _str){
        super(LLVM.StrConstAnon,new IRStringType(new IRIntType(8), _str.length()+1));
        str=_str;
    }
    public boolean equals(Object o) {return o instanceof StringConst && Objects.equals(str, ((StringConst) o).str);}
    public String constFormat() {
        return "c\"" +
                str.replace("\\", "\\5C")
                .replace("\n", "\\0A")
                .replace("\0", "\\00")
                .replace("\t", "\\09")
                .replace("\"", "\\22")
                + "\\00\"";
    }
}
