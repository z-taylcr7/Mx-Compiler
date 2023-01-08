package undecimber.compiler.backend.regalloc;

/**

 *      liveIn[n] = use[n] \cup (out[n] - def[n])
 *      liveOut[n] = \cap_{s \in suc[n]} in[s]
 *      不动点法进行迭代
 */
public class LiveAnalyzer {

}
