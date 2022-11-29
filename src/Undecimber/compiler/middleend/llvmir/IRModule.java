package undecimber.compiler.middleend.llvmir;

import com.sun.jdi.InternalException;
import undecimber.compiler.middleend.llvmir.irconst.GlobalVariable;
import undecimber.compiler.middleend.llvmir.irconst.StringConst;
import utility.LLVM;

import java.util.ArrayList;
import java.util.Objects;

public class IRModule {
    public ArrayList<StructProto> classArray = new ArrayList<>();
    public ArrayList<GlobalVariable> globalVarArray = new ArrayList<>();
    public ArrayList<StringConst> stringConstArray = new ArrayList<>();
    public ArrayList<IRFunction> functions = new ArrayList<>();
    public ArrayList<IRFunction> builtinFunctions = new ArrayList<>();


    public IRFunction getFunction(String x){
        for (IRFunction function : functions) {
            if(Objects.equals(function.name,x)||Objects.equals(function.name,LLVM.BottomStrFuncPrefix+x))return function;
        }
        throw new InternalError(x);
    }
    public IRFunction getBuiltInFunction(String x){
        for (IRFunction function : builtinFunctions) {
            if(Objects.equals(function.name,x)||Objects.equals(function.name,LLVM.BottomStrFuncPrefix+x))return function;
        }
        throw new InternalException(x);
    }
    public StringConst getStringConst(String x){
        for (StringConst stringConst : stringConstArray) {
            if(stringConst.name.equals(x))return stringConst;
        }
        StringConst xstr=new StringConst(x);
        stringConstArray.add(xstr);
        return xstr;
    }

    public void setBottomFunctions() {
        builtinFunctions.add(new IRFunction(LLVM.BottomPrefix + "malloc",
                IRTranslator.heapPointerType, IRTranslator.i32Type));

        builtinFunctions.add(new IRFunction(LLVM.BottomStrFuncPrefix + LLVM.StrCatArg,
                IRTranslator.stringType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new IRFunction(LLVM.BottomStrFuncPrefix + LLVM.EqualArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new IRFunction(LLVM.BottomStrFuncPrefix + LLVM.NotEqualArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new IRFunction(LLVM.BottomStrFuncPrefix + LLVM.LessArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new IRFunction(LLVM.BottomStrFuncPrefix + LLVM.LessEqualArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new IRFunction(LLVM.BottomStrFuncPrefix + LLVM.GreaterArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));

        builtinFunctions.add(new IRFunction(LLVM.BottomStrFuncPrefix + LLVM.GreaterEqualArg,
                IRTranslator.boolType, IRTranslator.stringType, IRTranslator.stringType));
    }
    public IRFunction getMalloc() {
        return builtinFunctions.get(0);
    }

}
