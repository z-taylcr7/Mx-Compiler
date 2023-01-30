package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.middleend.llvmir.irconst.GlobalVariable;
import undecimber.compiler.middleend.llvmir.irconst.StringConst;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import undecimber.compiler.middleend.llvmir.irnode.PhiNode;
import undecimber.compiler.middleend.llvmir.irtype.IRFuncType;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;
import utility.LLVM;
import utility.pass.BlockPass;
import utility.pass.FunctionPass;
import utility.pass.ModulePass;

import java.io.PrintStream;

public class IRPrinter implements ModulePass, BlockPass, FunctionPass {
    public PrintStream out;
    public String TAB=" ";
    public String mx_file_name;

    public IRPrinter(PrintStream _ps,String mx_file_name_){
        this.out=_ps;
        this.mx_file_name=mx_file_name_;
    }
    /**
     * @param block
     */
    @Override
    public void runBlock(IRBlock block) {
        block.setComment();
        out.println(block.name+":"+ "                       "+block.comment);
        for (PhiNode phiNode : block.PhiInstructions) {
            out.println(TAB+phiNode.format());
        }
        for (IRBaseNode instruction : block.instructions) {
            out.println(TAB+instruction.format());
        }
    }

    /**
     * @param func
     */
    @Override
    public void runFunction(IRFunction func) {

        out.println(funcDefFormat(func));out.println('{');
        out.print('\n');

        for (int i = 0; i < func.blockList.size(); i++) {
            runBlock(func.blockList.get(i));
            out.print("\n");
        }
        out.println("}\n");

    }

    /**
     * @param module
     */
    @Override
    public void runModule(IRModule module) {
        out.printf("; Module = '%s'%n", mx_file_name);
        out.printf(";src_file_name = \"%s\"%n", mx_file_name);
        for (IRFunction func : module.builtinFunctions) out.println(funcDeclFormat(func));
        out.print('\n');
        for (GlobalVariable globalVar : module.globalVarArray) out.println(globalVarInitFormat(globalVar));
        if (module.globalVarArray.size() > 0) out.print('\n');
        for (StringConst stringConst : module.stringConstArray) out.println(stringConstInitFormat(stringConst));
        if (module.stringConstArray.size() > 0) out.print('\n');
        for (StructProto structProto : module.classArray) out.println(classInitFormat(structProto));
        if (module.classArray.size() > 0) out.print('\n');
        for (IRFunction func : module.functions) runFunction(func);
    }

    public static String stringConstInitFormat(StringConst stringConst) {
        return stringConst.identifier() + " = private unnamed_addr constant " + ((IRPointerType) stringConst.type).pointedType + " "
                + stringConst.constFormat() + ", align " + ((IRPointerType) stringConst.type).pointedType.size();
    }

    public static String globalVarInitFormat(GlobalVariable globalVar) {
        return globalVar.identifier() + " = global " + globalVar.PointedType() + " zeroinitializer, align " + globalVar.PointedType().size();
    }

    public static String classInitFormat(StructProto structProto) {
        StringBuilder ret = new StringBuilder(structProto.identifier() + " = type {");
        for (int i = 0; i < structProto.construct().memberVarTypes.size(); i++) {
            ret.append(structProto.construct().memberVarTypes.get(i));
            if (i != structProto.construct().memberVarTypes.size() - 1) ret.append(", ");
        }
        ret.append("}");
        return ret.toString();
    }

    public static String funcDeclFormat(IRFunction function) {
        // declare void @print(i8*)
        StringBuilder ret = new StringBuilder("declare " + function.typeIdentifier() + "(");
        for (int i = 0; i < ((IRFuncType) function.type).argTypes.size(); i++) {
            ret.append(function.getArgType(i));
            if (i != ((IRFuncType) function.type).argTypes.size() - 1) ret.append(", ");
        }
        ret.append(")");
        return ret.toString();
    }

    public static String funcDefFormat(IRFunction function) {
        // define i32 @foo(i32 %a, i64 %b)
        StringBuilder ret = new StringBuilder("define " + function.typeIdentifier() + "(");
        for (int i = 0; i < function.getOperandSize(); i++) {
            ret.append(function.getArg(i).typeIdentifier());
            if (i != function.getOperandSize() - 1) ret.append(", ");
        }
        ret.append(")");
        return ret.toString();
    }
}
