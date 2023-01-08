package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.middleend.llvmir.irconst.GlobalValue;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRFuncType;
import utility.LLVM;

import java.util.ArrayList;
import java.util.LinkedList;

public class IRFunction extends GlobalValue {
    public IRModule parentModule;
    public IRBlock entryBlock, exitBlock;
    public LinkedList<IRBlock> blockList=new LinkedList<>();
    public Value returnAddress; // returnType == void ? null : valid_address;
    public boolean isBuiltin = false;
    public boolean isUsed = false;
    public IRFunction(String name, IRBaseType type) {
        super(name, type);
        this.returnAddress = null;
        entryBlock = new IRBlock(LLVM.EntryBlockLabel, this);
        exitBlock = new IRBlock(LLVM.ExitBlockLabel, this);
        entryBlock.parentFunction = this;

        // remember: here we place exit in second, not the logic order
        exitBlock.parentFunction = this;
    }
    public IRFunction(String name, IRBaseType retType, IRBaseType... argTypes) {
        super(name, new IRFuncType(retType, null));
        for (IRBaseType argType : argTypes) {

            ((IRFuncType) this.type).argTypes.add(argType);
        }
    }

    public IRFunction(String name, IRBaseType translateFuncType, IRModule module) {
        super(name,translateFuncType);
        blockList=new LinkedList<>();
        entryBlock = new IRBlock(LLVM.EntryBlockLabel, this);
        exitBlock = new IRBlock(LLVM.ExitBlockLabel, this);
        entryBlock.parentFunction = this;

        exitBlock.parentFunction = this;

        this.parentModule = module;
    }

    public void addBlock(IRBlock x){
        blockList.add(x);
    }

    public IRBlock entryBlock(){ return this.blockList.get(0); }

    public IRBlock exitBlock(){ return this.blockList.get(1); }

    public void addArg(Value arg){
        this.addOperand(arg);
    }

    public void setBuiltin(){
        this.isBuiltin = true;
    }

    public void setUsed(){
        this.isUsed = true;
    }

    @Override
    public String identifier() {
        return "@" + this.name;
    }


    public int getArgNum() {
        return ((IRFuncType)this.type).argTypes.size();
    }
    public Value getArg(int index) {
        return this.getOperand(index);
    }

    public boolean isVoid() {
        return ((IRFuncType) this.type).retType.match(IRTranslator.voidType);
    }
    public IRBaseType getArgType(int index) {
        return ((IRFuncType) this.type).argTypes.get(index);
    }

}
