package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.frontend.scope.GlobalScope;
import undecimber.compiler.middleend.llvmir.irtype.*;
import utility.LLVM;
import utility.Mx;
import utility.types.MxBaseType;
import utility.types.MxFuncType;
import utility.types.VarType;

import java.util.Objects;

public class IRTranslator {
    //tyypes
    public static final IRBaseType stringType=new IRPointerType(new IRIntType(8)),
                                    boolType=new IRBoolType(),memBoolType=new IRMemBoolType(),
                                    intType=new IRIntType(8),
                                    i32Type = new IRIntType(32),
                                    i32PointerType = new IRPointerType(i32Type),
                                    voidType = new IRVoidType(),
                                    heapPointerType = new IRPointerType(new IRIntType(8)),
                                    nullType = heapPointerType;
    public static String translateOp(String mxOp) {
        return switch (mxOp) {
            case Mx.AddOp -> LLVM.AddInst;
            case Mx.SubOp -> LLVM.SubInst;
            case Mx.MulOp -> LLVM.MulInst;
            case Mx.DivOp -> LLVM.DivInst;
            case Mx.ModOp -> LLVM.ModInst;
            case Mx.ArithShiftLeftOp -> LLVM.ShiftLeftInst;
            case Mx.ArithShiftRightOp -> LLVM.ShiftRightInst;
            case Mx.BitAndOp -> LLVM.AndInst;
            case Mx.BitOrOp -> LLVM.OrInst;
            case Mx.BitXorOp -> LLVM.XorInst;
            case Mx.GreaterOp -> LLVM.GreaterArg;
            case Mx.GreaterEqualOp -> LLVM.GreaterEqualArg;
            case Mx.LessOp -> LLVM.LessArg;
            case Mx.LessEqualOp -> LLVM.LessEqualArg;
            case Mx.EqualOp -> LLVM.EqualArg;
            case Mx.NotEqualOp -> LLVM.NotEqualArg;
            default -> mxOp;
        };

    }
    public static String translateStrOp(String mxOp){
        if(Objects.equals(mxOp,Mx.AddOp))return LLVM.StrCatArg;
        return translateOp(mxOp);
    }
    public static String logic_2Bit(String mxOp) {
        switch (mxOp) {
            case Mx.LogicAndOp: return LLVM.AndInst;
            case Mx.LogicOrOp: return LLVM.OrInst;
        }
        return "";
    }
    private GlobalScope globalScope;

    public void setGlobalScope(GlobalScope globalScope) {this.globalScope = globalScope;}

    public IRBaseType translateBuiltinType(MxBaseType mxType) {
        IRBaseType ret;
        switch (mxType.basicType) {
            case INT: ret = i32Type; break;
            case BOOL: ret = boolType; break;
            case STRING: ret = stringType; break;
            case CLASS: ret = new IRPointerType(globalScope.getClass(((VarType) mxType).className).value.type); break;
            default: ret = voidType;
        }
        return ret;
    }
    public IRBaseType translateVarType(MxBaseType mxType) {
        IRBaseType ret;

        assert mxType instanceof VarType;

        ret = translateBuiltinType(mxType);

        for (int i = 1; i <= ((VarType) mxType).dimension; i++)
            ret = new IRPointerType(ret);

        return ret;
    }
    public IRBaseType translateFuncType(MxFuncType type,IRBaseType origin){
        IRFuncType ret= new IRFuncType(translateVarType(type.retType),origin);
        if(origin!=null)ret.argTypes.add(origin);
        for (VarType varType : type.funcArgsType) {
            ret.argTypes.add(translateVarType(varType));
        }
        return ret;
    }
    public IRBaseType translateAllocaType(MxBaseType mxType){
        IRBaseType ret;
        if(mxType.basicType== MxBaseType.BasicType.BOOL)ret=memBoolType;
        else return translateVarType(mxType);
        for (int i = 0; i < ((VarType) mxType).dimension; i++) {
            ret = new IRPointerType(ret);
        }
        return ret;
    }


}
