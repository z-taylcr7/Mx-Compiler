package undecimber.compiler.middleend.analytics;


import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irconst.IntConst;
import undecimber.compiler.middleend.llvmir.irnode.BitCastNode;
import undecimber.compiler.middleend.llvmir.irnode.CallNode;
import undecimber.compiler.middleend.llvmir.irnode.GetElementPtrNode;
import undecimber.compiler.middleend.llvmir.irnode.IRBaseNode;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;
import utility.UnionSet;
import utility.pass.FunctionPass;

import java.util.HashSet;

public class AliasAnalyzer implements FunctionPass {

    private HashSet<Value> certain = new HashSet<>();
    private UnionSet<Value> bitcastUnion = new UnionSet<>();

    @Override
    public void runFunction(IRFunction function) {

        certain.clear();
        bitcastUnion.clear();
        certain.addAll(function.parentModule.globalVarArray);
        certain.addAll(function.parentModule.stringConstArray);

        for (IRBlock block : function.blockList)
            for (IRBaseNode inst : block.instructions) {
                if (inst instanceof CallNode && ((CallNode) inst).callFunc() == function.parentModule.getMalloc())
                    certain.add(inst);
                if (inst instanceof BitCastNode && ((BitCastNode) inst).getValue().type instanceof IRPointerType) {
                    bitcastUnion.setAlias(inst, ((BitCastNode) inst).getValue());
                }
            }
    }

    public boolean mayAlias(Value addr1, Value addr2) {


        addr1 = bitcastUnion.getAlias(addr1);
        addr2 = bitcastUnion.getAlias(addr2);



        if (certain.contains(addr1) || certain.contains(addr2)) {
            return addr1.equals(addr2);
        }

        if (addr1 instanceof GetElementPtrNode) {
            if (addr2 instanceof GetElementPtrNode) {
                boolean ret = mayAlias(((GetElementPtrNode) addr1).headPointer(), ((GetElementPtrNode) addr2).headPointer());
                if (((GetElementPtrNode) addr1).indicesNum() == 1 && ((GetElementPtrNode) addr2).indicesNum() == 1) {
                    Value index1 = ((GetElementPtrNode) addr1).headPointer();
                    Value index2 = ((GetElementPtrNode) addr2).headPointer();

                    if (index1 instanceof IntConst && index2 instanceof IntConst && ((IntConst) index1).data != ((IntConst) index2).data) {
                        return false;
                    }
                }
                return ret;
            }
            else return mayAlias(((GetElementPtrNode) addr1).headPointer(), addr2);
        }

        if (addr2 instanceof GetElementPtrNode)
            return mayAlias(addr2, addr1);

        return addr1.type.match(addr2.type);
    }
}
