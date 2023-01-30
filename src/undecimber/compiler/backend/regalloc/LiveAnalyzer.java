package undecimber.compiler.backend.regalloc;

import undecimber.compiler.backend.asm.AsmBlock;
import undecimber.compiler.backend.asm.AsmFunction;
import undecimber.compiler.backend.asm.AsmModule;
import undecimber.compiler.backend.asm.insts.AsmBaseInst;
import undecimber.compiler.backend.asm.operands.Register;
import utility.pass.AsmPass;

import java.util.*;

/**

 *      liveIn[n] = use[n] \cup (out[n] - def[n])
 *      liveOut[n] = \cap_{s \in suc[n]} in[s]
 *      不动点法进行迭代
 */
public class LiveAnalyzer implements AsmPass {

    private final Map<AsmBlock, HashSet<Register>> blockUsesMap = new HashMap<>(), blockDefsMap = new HashMap<>();

    private final Queue<AsmBlock> Q = new LinkedList<>();
    private final HashSet<AsmBlock> doneSet = new HashSet<>();
    public void init(AsmFunction function){
        for (AsmBlock block : function.blocks) {
           block.aliveIn.clear();
           block.aliveOut.clear();
        }
    }
    // first collect all uses and defs in a block
    public void collect(AsmBlock block){

        HashSet<Register> blockUses = new HashSet<>(), blockDefs = new HashSet<>();
            for (AsmBaseInst instruction : block.instructions) {
                for (Register use : instruction.uses()) {
                    if(!blockDefs.contains(use)){//self def-use --> def only
                        blockUses.add(use);
                    }
                }
                blockDefs.addAll(instruction.defs());
            }
            blockDefsMap.put(block,blockDefs);
            blockUsesMap.put(block,blockUses);
        }
    @Override
    public void runFunction(AsmFunction function) {
        init(function);
        for (AsmBlock block : function.blocks) {
            collect(block);
        }
        Q.offer(function.exitBlock);
        while (!Q.isEmpty()) livenessAnalyze(Q.poll());
    }
    public void livenessAnalyze(AsmBlock block){
        if(doneSet.contains(block))return;
        doneSet.add(block);


        HashSet<Register> inbar=new HashSet<>(block.aliveIn);
        HashSet<Register> outbar=new HashSet<>(block.aliveOut);

        for (AsmBlock next : block.nexts) {
            block.aliveOut.addAll(next.aliveIn);
        }

        block.aliveIn=new HashSet<>(block.aliveOut);
        block.aliveIn.removeAll(blockDefsMap.get(block));
        block.aliveIn.addAll(blockUsesMap.get(block));

        if(block.aliveIn.equals(inbar)&&block.aliveOut.equals(outbar)){

        }else {
            block.prevs.forEach(doneSet::remove);

        }
        Q.addAll(block.prevs);//bfs ctrl graph
    }
    /**
     * @param block
     */
    @Override
    public void runBlock(AsmBlock block) {
        //nothing
    }

    /**
     * @param module
     */
    @Override
    public void runModule(AsmModule module) {
        //nothing
    }


}
