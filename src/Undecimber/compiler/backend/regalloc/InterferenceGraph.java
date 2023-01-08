package undecimber.compiler.backend.regalloc;

import undecimber.compiler.backend.asm.insts.AsmMvInst;
import undecimber.compiler.backend.asm.operands.Register;

import java.util.*;

public class InterferenceGraph {
    public static class Edge{
       public  Register u,v;
       public Edge(Register _u,Register _v){
           this.u=_u;

           this.v=_v;

       }
       public boolean isLoop(){
           return this.u==this.v;

       }
       public boolean equals(Object o){
           return (o instanceof Edge)&&(this.u==((Edge)o).u)&&(this.v==((Edge)o).v);
        }
       public Edge convert(){
            return new Edge(v,u);
       }
       public int hashcode(){
           return u.hashCode()^v.hashCode();
       }
    }
    public static int inf=19891213;
    public static class node{
        public HashSet<Register> adjList = new LinkedHashSet<>();
        public HashSet<AsmMvInst> moveList = new LinkedHashSet<>();
        public boolean preColored;
        public int deg;
        public double priority;
        public void init(boolean isPreColored) {
            this.adjList.clear();
            this.moveList.clear();
            this.priority = 0;
            if (isPreColored) this.deg = inf;
            else this.deg = 0;
            this.preColored = isPreColored;
        }

    }
    HashSet<Edge>edgeList=new LinkedHashSet<>();
    public void addEdge(Edge edge){
        if(edge.isLoop()||edgeList.contains(edge))return;
        edgeList.add(edge);
        edgeList.add(edge.convert());
        if (!edge.u.node.preColored) {
            edge.u.node.adjList.add(edge.v);
            edge.u.node.deg++;
        }
        if(!edge.v.node.preColored){
            edge.v.node.deg++;
            edge.v.node.adjList.add(edge.u);
        }

    }

    public void reset() {
        edgeList.clear();
    }

}
