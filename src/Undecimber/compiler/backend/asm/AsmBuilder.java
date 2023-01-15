package undecimber.compiler.backend.asm;
//rollback to:2023/1/12
import org.antlr.v4.runtime.misc.Pair;
import undecimber.compiler.backend.asm.insts.*;
import undecimber.compiler.backend.asm.operands.*;
import undecimber.compiler.middleend.llvmir.*;
import undecimber.compiler.middleend.llvmir.irconst.*;
import undecimber.compiler.middleend.llvmir.irnode.*;
import undecimber.compiler.middleend.llvmir.irtype.IRFuncType;
import undecimber.compiler.middleend.llvmir.irtype.IRPointerType;
import undecimber.compiler.middleend.llvmir.irtype.IRStructType;
import utility.LLVM;
import utility.RV32I;
import utility.pass.BlockPass;
import utility.pass.FunctionPass;
import utility.pass.ModulePass;

import java.util.ArrayList;

import static java.lang.Integer.max;

public class AsmBuilder implements ModulePass, FunctionPass, BlockPass, IRVisitor {
    public final AsmModule module = new AsmModule();

    private final CurrentInfo cur = new CurrentInfo();

    public AsmBuilder() {}


    /**
     * @param Node
     */
    @Override
    public void visit(AllocaNode Node) {
        Node.asmOperand=new StackOffset(cur.function.allocaStackUse, 1,cur.function);
        cur.function.allocaStackUse+= RV32I.I32Unit;

    }

    /**
     * @param Node
     */
    @Override
    public void visit(BinNode Node) {
        new AsmALUInst(AsmTranslator.translateArithOp(Node.op),cur.toReg(Node),cur.toReg(Node.lhs()),cur.toReg(Node.rhs()),cur.block);
    }

    /**
     * @param Node
     */
    @Override
    public void visit(BitCastNode Node) {
        Value val=Node.getOperand(0);
        if(validImm(val)) new AsmLiInst(cur.toReg(Node),cur.toImm(val),cur.block);
        else new AsmMvInst(cur.toReg(Node),cur.toReg(val),cur.block);
    }

    /**
     * @param Node
     */
    @Override
    public void visit(BrNode Node) {
        Node.asmOperand=null;
        if(Node.IsJump())new AsmJumpInst((AsmBlock)Node.Dest().asmOperand,cur.block);
        else{
            //todo
            if(Node.Cond() instanceof ICmpNode && ((ICmpNode)Node.Cond()).onlyBR()){
                Pair<String ,Boolean>ret=AsmTranslator.translateCmpOp(((ICmpNode)Node.Cond()).cmp);
                if(ret.b){//swap lhs&rhs
                    new AsmBrInst(ret.a, cur.toReg(((ICmpNode) Node.Cond()) .rhs()),cur.toReg(((ICmpNode) Node.Cond()) .lhs()),
                            (AsmBlock) ((Node.Then().asmOperand)),cur.block);
                }else {

                    new AsmBrInst(ret.a, cur.toReg(((ICmpNode) Node.Cond()) .lhs()),cur.toReg(((ICmpNode) Node.Cond()) .rhs()),
                            (AsmBlock) ((Node.Then().asmOperand)),cur.block);
                }
            }else{
                new AsmBrInst(RV32I.NotEqualSuffix,cur.toReg(Node.Cond()),cur.toReg(new IntConst(0)),
                        (AsmBlock) ((Node.Then().asmOperand)),cur.block);
            }
            new AsmJumpInst((AsmBlock) Node.Else().asmOperand,cur.block);
        }

    }

    /**
     * @param Node
     */
    @Override
    public void visit(CallNode Node) {
        AsmFunction asmFunction=(AsmFunction)Node.callFunc().asmOperand;
        int ArgNum=Node.callFunc().getArgNum();
        for (int i = 0; i <ArgNum ; i++) {
            if(i< RV32I.MaxArgRegNum){
                //todo:argnum cflt
                if(Node.getArg(i) instanceof GlobalValue){
//
//                        if (((GlobalValue) Node.getArg(i)).isGlbPointer) {
//                            new AsmMvInst(PhysicalReg.a(i), PhysicalReg.reg("gp"), cur.block);
//                        }
//                        else {
//                            new AsmLaInst(PhysicalReg.a(i), Node.getArg(i).asmOperand.id, cur.block);
//                        }
                    new AsmLaInst(PhysicalReg.a(i), Node.getArg(i).asmOperand.id, cur.block);
                }else new AsmMvInst(PhysicalReg.a(i),cur.toReg(Node.getArg(i)),cur.block);
            }
            else new AsmStoreInst(
                    Node.getArg(i).type.size(),
                    PhysicalReg.reg("sp"),
                        asmFunction.arguments.get(i),
//                    cur.toReg(Node.getArg(i)),
//                   new  RawStackOffset(asmFunction.arguments.get(i).stackOffset.imm, RawStackOffset.RawType.callerArg),
              asmFunction.arguments.get(i).stackOffset,
                    cur.block
            );

        }
//        cur.function.callerArgStackUse = max(cur.function.callerArgStackUse, asmFunction.calleeArgStackUse);
        cur.function.callStackUse = max(cur.function.callStackUse, asmFunction.callStackUse);

        new AsmCallInst(asmFunction, cur.block);
        //return if non-void
        if (!Node.callFunc().isVoid()) {
            new AsmMvInst(cur.toReg(Node), PhysicalReg.reg("a0"), cur.block);
        }

    }

    /**
     * @param Node
     */
    @Override
    public void visit(ICmpNode Node) {
        // only use slt, seqz, snez

        if(Node.onlyBR()){

            return;// will be merged into next br
        }
        Register instReg=cur.toReg(Node);
        switch(Node.cmp){
            case LLVM.EqualArg -> {
                VirtualReg vr=new VirtualReg();
                new AsmALUInst(RV32I.XorInst,vr, cur.toReg(Node.lhs()),cur.toReg(Node.rhs()),cur.block );
                new AsmALUInst(RV32I.SeqzInst,instReg,vr,cur.block);
            }// a == b -> xor = a ^ b; seqz rd, xor
            case LLVM.NotEqualArg -> {
                VirtualReg vr=new VirtualReg();
                new AsmALUInst(RV32I.XorInst,vr, cur.toReg(Node.lhs()),cur.toReg(Node.rhs()),cur.block );
                new AsmALUInst(RV32I.SnezInst,instReg,vr,cur.block);
            }
            case LLVM.LessArg -> new AsmALUInst(RV32I.SltInst,cur.toReg(Node),cur.toReg(Node.lhs()),cur.toReg(Node.rhs()),cur.block);
            case LLVM.GreaterArg -> new AsmALUInst(RV32I.SltInst,cur.toReg(Node),cur.toReg(Node.rhs()),cur.toReg(Node.lhs()),cur.block);
            case LLVM.LessEqualArg -> {
                new AsmALUInst(RV32I.SltInst,instReg,cur.toReg(Node.rhs()),cur.toReg(Node.lhs()),cur.block);
                new AsmALUInst(RV32I.XorInst,instReg,instReg,new Immediate(1), cur.block);
            }//a <= b -> !(a > b)
            case LLVM.GreaterEqualArg -> {

                new AsmALUInst(RV32I.SltInst,instReg,cur.toReg(Node.lhs()),cur.toReg(Node.rhs()),cur.block);
                new AsmALUInst(RV32I.XorInst,instReg,instReg,new Immediate(1), cur.block);
            }
            default -> throw new RuntimeException();
        }

    }

    /**
     * @param Node
     */
    @Override
    public void visit(LoadNode Node) {
        Register reg=cur.toReg(Node);
        if(Node.getLoadAddr() instanceof GlobalValue){
            if(((GlobalValue)Node.getLoadAddr()).isGlbPointer){
                new AsmMvInst(reg, PhysicalReg.reg("gp"), cur.block);
            }else {
                VirtualReg vr=new VirtualReg();

                GlobalReg glb= (GlobalReg) cur.toReg(Node.getLoadAddr());
                new AsmLuiInst(vr,new GlobalAddr(glb, GlobalAddr.status.hi),cur.block);
                new AsmLoadInst(Node.type.size(),reg,vr,new GlobalAddr(glb, GlobalAddr.status.lo),cur.block);
            }
        }else {//at stack
            if (Node.getLoadAddr().asmOperand instanceof StackOffset) {
                new AsmLoadInst(Node.type.size(),reg, PhysicalReg.reg("sp"), cur.toImm(Node.getLoadAddr()), cur.block);
//            }else if (Node.getLoadAddr().asmOperand instanceof RawMemOffset){
//                new AsmLoadInst(Node.type.size(),reg,null,(Immediate)(Node.getLoadAddr().asmOperand),cur.block);
            }else new AsmLoadInst(Node.type.size(),reg,cur.toReg(Node.getLoadAddr()),cur.toImm(0),cur.block);
        }
    }

    /**
     * @param Node
     */
    @Override
    public void visit(ZextNode Node) {
        if (validImm(Node.getOperand(0))) {
            new AsmLiInst(cur.toReg(Node), cur.toImm(Node.getOperand(0)), cur.block);
        }
        else {
            new AsmMvInst(cur.toReg(Node), cur.toReg(Node.getOperand(0)), cur.block);
        }
    }

    /**
     * @param Node
     */
    @Override
    public void visit(RetNode Node) {
        if(Node.isVoid())return;
        else {
            if (validImm(Node.retValue())) {
                new AsmLiInst(PhysicalReg.reg("a0"), cur.toImm(Node.retValue()), cur.block);
            }
            else {
                new AsmMvInst(PhysicalReg.reg("a0"), cur.toReg(Node.retValue()), cur.block);
            }
        }

    }

    /**
     * @param Node
     */
    @Override
    public void visit(TruncNode Node) {
        if (validImm(Node.getOperand(0))) {
            new AsmLiInst(cur.toReg(Node), cur.toImm(Node.getOperand(0)), cur.block);
        }
        else {
            new AsmMvInst(cur.toReg(Node), cur.toReg(Node.getOperand(0)), cur.block);
        }
    }

    /**
     * @param Node
     */
    @Override
    public void visit(StoreNode Node) {
        if(Node.getStorePtr() instanceof GlobalValue){
            if(((GlobalValue)Node.getStorePtr()).isGlbPointer){
                new AsmMvInst( PhysicalReg.reg("gp"),cur.toReg(Node.getStoreData()), cur.block);
            }else {
                VirtualReg vr=new VirtualReg();

                GlobalReg glb= (GlobalReg) cur.toReg(Node.getStorePtr());
                new AsmLuiInst(vr,new GlobalAddr(glb, GlobalAddr.status.hi),cur.block);
                new AsmStoreInst(Node.getStoreData().type.size(),vr,cur.toReg(Node.getStoreData()),new GlobalAddr(glb, GlobalAddr.status.lo),cur.block);
            }
        }else {
            if (Node.getStorePtr().asmOperand instanceof StackOffset) {
                new AsmStoreInst(Node.getStoreData().type.size(),  PhysicalReg.reg("sp"), cur.toReg(Node.getStoreData()),cur.toImm(Node.getStorePtr()), cur.block);
//            }else if (Node.getStorePtr().asmOperand instanceof RawMemOffset){
//                new AsmStoreInst(Node.getStoreData().type.size(),null,cur.toReg(Node.getStoreData()),(Immediate)(Node.getStorePtr().asmOperand),cur.block);
            }else new AsmStoreInst(Node.getStoreData().type.size(),cur.toReg(Node.getStorePtr()),cur.toReg(Node.getStoreData()),cur.toImm(0),cur.block);
        }

    }

    /**
     * @param Node
     */
    @Override
    public void visit(PhiNode Node) {
        throw new RuntimeException("Phi in ASM") ;
    }

    /**
     * @param Node
     */
    @Override
    public void visit(MoveNode Node) {
        if (validImm(Node.getFrom())) {
            new AsmLiInst(cur.toReg(Node.getTo()), cur.toImm(Node.getFrom()), cur.block);
        }
        else {
            new AsmMvInst(cur.toReg(Node.getTo()), cur.toReg(Node.getFrom()), cur.block);
        }
    }

    /**
     * @param Node
     */
    @Override
    public void visit(GetElementPtrNode Node) {
        Value index=Node.isGetMember()? Node.getIndex(1):Node.getIndex(0);
//        IRStructType classType=Node.isGetMember() ? (IRStructType) ((IRPointerType) Node.headPointer().type).pointedType : null;
//        int elemSize=((IRPointerType) Node.headPointer().type).pointedType.size();
//        if (index instanceof IntConst && !(Node.headPointer() instanceof GlobalValue) ) {
//            int offset = 0;
//            if (classType != null) {
//                offset = classType.memberOffset(((IntConst) index).data);
//            }
//            else {
//                offset = ((IntConst) index).data * elemSize;
//            }
//            Node.asmOperand = new RawMemOffset(cur.toReg(Node.headPointer()), offset);
//            return;
//        }
//
//        Register instReg = cur.toReg(Node);

        Register instReg = cur.toReg(Node);
        IRStructType classType = Node.isGetMember() ? (IRStructType) ((IRPointerType) Node.headPointer().type).pointedType : null;
        int elemSize = ((IRPointerType) Node.headPointer().type).pointedType.size(); // well... quite interesting
        Register ptr = cur.toReg(Node.headPointer());
        VirtualReg gep= new VirtualReg();
        if(classType==null){
            if(index instanceof IntConst){
                if(equalZero(index)){
//                    Register ptr = cur.toReg(Node.headPointer());
                    // get headptr
                    if (ptr instanceof GlobalReg) {
                        if (((GlobalValue) Node.headPointer()).isGlbPointer) {
                            new AsmMvInst(gep, PhysicalReg.reg("gp"), cur.block);
                        }
                        else {
                            new AsmLaInst(gep, ptr.id, cur.block);
                        }
                    }
//                    else new AsmMvInst(gep, ptr, cur.block);
                    else new AsmALUInst(RV32I.AddInst, gep, ptr, cur.toImm(((IntConst) index).data * elemSize), cur.block);

                }else{
                    int sumOffset=elemSize*((IntConst) index).data;
                    new AsmALUInst(RV32I.AddInst,gep,cur.toReg(Node.headPointer()),cur.toReg(new IntConst(sumOffset)),cur.block);
                }
            }else{
                VirtualReg mul = new VirtualReg();
                new AsmALUInst(RV32I.MulInst, mul, cur.toReg(index), cur.toReg(new IntConst(elemSize)),cur.block);
                // this not use awesomeALU because it can not be optimized
                new AsmALUInst(RV32I.AddInst, gep, cur.toReg(Node.headPointer()), mul, cur.block);
            }
        }else{
            if(equalZero(index)){
//                Register ptr = cur.toReg(Node.headPointer());
                // get headptr
                if (Node.headPointer() instanceof GlobalValue) {
                    if (((GlobalValue) Node.headPointer()).isGlbPointer) {
                        new AsmMvInst(gep, PhysicalReg.reg("gp"), cur.block);
                    }
                    else {
                        new AsmLaInst(gep, ptr.id, cur.block);
                    }
                }
                else new AsmMvInst(gep, ptr, cur.block);
            }else{
                assert index instanceof IntConst;
                int memberOffset = classType.memberOffset(((IntConst) index).data);
                new AsmALUInst(RV32I.AddInst,gep,cur.toReg(Node.headPointer()),cur.toReg(new IntConst(memberOffset)),cur.block);
            }
        }
        new AsmMvInst(instReg, gep, cur.block);
    }

    public void initModule(IRModule irmodule){
        globalDecl(irmodule);
        for (IRFunction function : irmodule.builtinFunctions) {
            AsmFunction func = new AsmFunction(function.name);
            function.asmOperand = func;
            for (int i = 0; i < ((IRFuncType) function.type).argTypes.size(); i++) {
//                VirtualReg vr=new VirtualReg(function.getArgType(i).size());
//                func.arguments.add(vr);
////                if(i>= RV32I.MaxArgRegNum){
//                    vr.stackOffset=new StackOffset(func.calleeArgStackUse, 0,func);
//                    func.callStackUse+=RV32I.I32Unit;
////                func.calleeArgStackUse+=RV32I.I32Unit;
                ArgumentReg reg = new ArgumentReg(String.valueOf(i), function.getArgType(i).size());
                func.arguments.add(reg);
                reg.stackOffset = new StackOffset(func.callStackUse, 0, func);
                func.callStackUse += 4;
//                }
            }
        }
        for (IRFunction function : irmodule.functions) {
            AsmFunction asm=new AsmFunction(function.name);
            function.asmOperand=asm;
//            for (int i = 0; i < ((IRFuncType) function.type).argTypes.size(); i++) {
//
//                VirtualReg vr=new VirtualReg(function.getArgType(i).size());
//                Value arg=function.operands.get(i);
//                asm.arguments.add(vr);
//                arg.asmOperand=asm;
////                if(i>= RV32I.MaxArgRegNum){
//                vr.stackOffset=new StackOffset(asm.calleeArgStackUse, 0,asm);
//                asm.callStackUse+=RV32I.I32Unit;
////                asm.calleeArgStackUse+=RV32I.I32Unit;
////                }
//            }
            function.operands.forEach(arg -> {
                arg.asmOperand = new ArgumentReg(arg.name, arg.type.size());
                asm.arguments.add((Register) arg.asmOperand);
                ((Register) arg.asmOperand).stackOffset = new StackOffset(asm.callStackUse, 0, asm);
               asm.callStackUse += 4;
            });
            module.functions.add((AsmFunction) function.asmOperand);
            for (IRBlock irBlock : function.blockList) {
                AsmBlock block=new AsmBlock(irBlock.name);

                block.loopDepth= irBlock.loopDepth;
                irBlock.asmOperand=block;
                asm.blocks.add(block);
            }
            asm.entryBlock = (AsmBlock) function.entryBlock.asmOperand;
            asm.exitBlock = (AsmBlock) function.exitBlock.asmOperand;
            for (IRBlock irBlock : function.blockList) {
                for (IRBlock prev : irBlock.prevs) {
                    ((AsmBlock)irBlock.asmOperand).prevs.add((AsmBlock) prev.asmOperand);
                }
                for (IRBlock next : irBlock.nexts) {
                    ((AsmBlock)irBlock.asmOperand).nexts.add((AsmBlock) next.asmOperand);
                }
            }

        }

    }

    /**
     * @param block
     */
    @Override
    public void runBlock(IRBlock block) {
        cur.block=(AsmBlock) block.asmOperand;
//        cur.LiMap.clear();
        for (IRBaseNode instruction : block.instructions) {
            instruction.accept(this);
        }
    }

    @Override
    public void runFunction(IRFunction function) {
//        AsmFunction asmFunction=(AsmFunction) irFunction.asmOperand;
//        cur.function=asmFunction;
////        // sp
////        new AsmALUInst(RV32I.AddInst,PhysicalReg.reg("sp"),PhysicalReg.reg("sp"), new RawStackOffset(0, RawStackOffset.RawType.lowerSp),cur.block);
//
//        // ra
//        VirtualReg ra = new VirtualReg();
//        new AsmMvInst(ra, PhysicalReg.reg("ra"), cur.function.entryBlock);
//        VirtualReg fp=new VirtualReg();
//        new AsmMvInst(fp, PhysicalReg.reg("s0"), cur.function.entryBlock);
//
//        //callee save
//        ArrayList<Register> calleeSaver = new ArrayList<>();
//        for (PhysicalReg phyReg : PhysicalReg.calleeSaved) {
//            VirtualReg vr = new VirtualReg();
//            calleeSaver.add(vr);
//            new AsmMvInst(vr, phyReg, cur.function.entryBlock);
//        }
//        for (int i = 0; i < cur.function.arguments.size(); i++) {
//            if(i==RV32I.MaxArgRegNum)break;
//            new AsmMvInst(cur.function.arguments.get(i),PhysicalReg.a(i),cur.block);
//        }
//
//        // load arguments in mem to reg
//        for (int i = RV32I.MaxArgRegNum; i < cur.function.arguments.size(); i++) {
//            new AsmLoadInst(irFunction.getOperand(i).type.size(), cur.function.arguments.get(i), PhysicalReg.reg("sp"),
//                    cur.function.arguments.get(i).stackOffset, cur.function.entryBlock);
//        }
//
//        for (IRBlock irBlock : irFunction.blockList) {
//            runBlock(irBlock);
//        }
//        // callee-saved load back
//        for (int i = 0; i < PhysicalReg.calleeSaved.size(); i++) {
//            new AsmMvInst(PhysicalReg.calleeSaved.get(i), calleeSaver.get(i),cur.function.exitBlock );
//        }
//
//        //ra load back
//        new AsmMvInst( PhysicalReg.reg("ra"),ra, cur.function.exitBlock);
//        //sp return
//        new AsmALUInst(RV32I.AddInst,PhysicalReg.reg("sp"),PhysicalReg.reg("sp"), new RawStackOffset(0, RawStackOffset.RawType.raiseSp),cur.block);
//        // return
//        new AsmRetInst(cur.function.exitBlock);
//
//        cur.function.blocks.forEach(block -> {
//            for (AsmBaseInst instruction : block.instructions) {
//                allocate(instruction);
//            }
//        });
        cur.function = (AsmFunction) function.asmOperand;

        // lower the stack pointer
        // backup callee
        /*
        ArrayList<Register> calleeSaveTemp = new ArrayList<Register>();
        for (PhysicalReg phyReg : PhysicalReg.calleeSaved) {
            VirtualReg rd = new VirtualReg();
            calleeSaveTemp.add(rd);
            new AsmMvInst(rd, phyReg, cur.func.entryBlock());
        }
        */
        // ra
        VirtualReg raTemp = new VirtualReg();
        new AsmMvInst(raTemp, PhysicalReg.reg("ra"), cur.function.entryBlock);
        // s0
        VirtualReg fpTemp = new VirtualReg();
        new AsmMvInst(fpTemp, PhysicalReg.reg("s0"), cur.function.entryBlock);

        // arguments 0~7

        for (int i = 0; i < Integer.min(cur.function.arguments.size(), RV32I.MaxArgRegNum); i++) {
            new AsmMvInst(cur.function.arguments.get(i), PhysicalReg.a(i), cur.function.entryBlock);
        }

        // spill to mem
        for (int i = RV32I.MaxArgRegNum; i < cur.function.arguments.size(); i++) {
            new AsmLoadInst(function.getOperand(i).type.size(), cur.function.arguments.get(i), PhysicalReg.reg("s0"),
                    cur.function.arguments.get(i).stackOffset, cur.function.entryBlock);
        }

        function.blockList.forEach(this::runBlock);

        // temp back
        /*
        for (int i = 0; i < PhysicalReg.calleeSaved.size(); i++) {
            new AsmMvInst(PhysicalReg.calleeSaved.get(i), calleeSaveTemp.get(i), cur.func.exitBlock());
        }
        */
        new AsmMvInst(PhysicalReg.reg("ra"), raTemp, cur.function.exitBlock);
        new AsmMvInst(PhysicalReg.reg("s0"), fpTemp, cur.function.exitBlock);

        cur.function.virtualStackUse = VirtualReg.virtualRegNum * 4;
        VirtualReg.setVirtualRegNumZero();

    }

    /**
     * @param irmodule
     */
    @Override
    public void runModule(IRModule irmodule) {
        initModule(irmodule);
        for (IRFunction function : irmodule.functions) {
            runFunction(function);
        }
    }
    // private basic methods
    private static boolean validImm(Value value) {
        return (value instanceof IntConst && ((IntConst) value).data >= -1 * RV32I.ImmBound && ((IntConst) value).data < RV32I.ImmBound) || value instanceof BoolConst;
    }

    private static boolean validImm(int value) {
        return value >= -1 * RV32I.ImmBound && value < RV32I.ImmBound;
    }

    private static boolean equalZero(Value value) {
        return value instanceof NullConst || (value instanceof IntConst && ((IntConst) value).data == 0)
                || (value instanceof BoolConst && !((BoolConst) value).flag);
    }
    private void globalDecl(IRModule irModule) {
        for (GlobalVariable globalVar : irModule.globalVarArray) {
            GlobalReg globalReg = new GlobalReg(globalVar.name);
            globalVar.asmOperand = globalReg;
            module.globalVars.add(globalReg);
        }

        for (StringConst strConst : irModule.stringConstArray) {
            GlobalReg strReg = new GlobalReg(strConst.name, strConst.str);
            strConst.asmOperand = strReg;
            module.stringConsts.add(strReg);
        }
    }
    private void allocate(AsmBaseInst inst){
        if(!(inst.imm instanceof RawMemOffset))return;
        inst.rs1=((RawMemOffset) inst.imm).pointer;
        inst.imm=new Immediate(inst.imm.imm);
    }
}

