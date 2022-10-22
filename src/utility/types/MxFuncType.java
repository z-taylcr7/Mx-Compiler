package utility.types;
import undecimber.compiler.frontend.ast.nodes.ExprNode;

import java.util.ArrayList;

import static utility.types.MxBaseType.BasicType.FUNC;

public class MxFuncType extends MxBaseType {
    public VarType retType;
    public ArrayList<VarType> funcArgsType;

    public MxFuncType() {
        super(BasicType.FUNC);
        retType = null;
        funcArgsType = new ArrayList<>();
    }

    @Override
    public boolean match(MxBaseType other) {
        return false;
    }

    @Override
    public boolean match(BasicType other) {
        return other == FUNC;
    }

    public int funcCallMatch(ArrayList<ExprNode> args) {
        if (funcArgsType.size() != args.size()) {
            System.out.println(funcArgsType.size());
            System.out.println(args.size());
            return -1;
        }
        for (int i = 0; i < funcArgsType.size(); i++) {
            if (!funcArgsType.get(i).match(args.get(i).type)) {
                return -2;
            }
        }
        return 0;
    }

    @Override
    public MxBaseType copy() {
        MxFuncType ret = new MxFuncType();
        ret.retType = (VarType) retType.copy();
        for (int i = 0; i < funcArgsType.size(); i++) {
            ret.funcArgsType.add((VarType) funcArgsType.get(i).copy());
        }
        return ret;
    }

    @Override
    public boolean isArray() {
        return false;
    }

    public String toString() {
        StringBuilder ret = new StringBuilder();
        ret.append("func; return Type is:").append(retType).append(" args:");
        for (int i = 0; i < funcArgsType.size(); ++i) {
            ret.append(funcArgsType.get(i).toString() + " ");
        }
        return ret.toString();
    }
}