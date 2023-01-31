package undecimber.compiler.backend.regalloc;


// Register Interference Graph

import undecimber.compiler.backend.asm.insts.AsmMvInst;
import undecimber.compiler.backend.asm.operands.Register;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RIG {

    public static int INF = 1145141919;

    public static class Edge {
        public Register u, v;
        public Edge(Register u, Register v) {
            this.u = u;
            this.v = v;
        }

        public boolean isLoop() {
            return this.u == this.v;
        }

        public Edge convert() {
            return new Edge(v, u);
        }

        @Override
        public int hashCode() {
            return u.hashCode() ^ v.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            return o instanceof Edge && (((Edge) o).u == u && ((Edge) o).v == v);
        }
    }
    public static class Node {
        public HashSet<Register> adjList = new LinkedHashSet<>();
        public boolean preColored;
        public int deg;
        public double priority;
        public Set<AsmMvInst> moveList = new LinkedHashSet<>();

        public void init(boolean isPrecolored) {
            this.adjList.clear();
            this.moveList.clear();
            this.priority = 0;
            if (isPrecolored) this.deg = INF;
            else this.deg = 0;
            this.preColored = isPrecolored;
        }
    }

    public Set<Edge> edgeList = new LinkedHashSet<>();

    public void addEdge(RIG.Edge edge) {
        if (!edgeList.contains(edge) && !edge.isLoop()) {
            edgeList.add(edge);
            edgeList.add(edge.convert());
            if (!edge.u.node.preColored) {
                edge.u.node.adjList.add(edge.v);
                edge.u.node.deg++;
            }
            if (!edge.v.node.preColored) {
                edge.v.node.adjList.add(edge.u);
                edge.v.node.deg++;
            }
        }
    }

    public void reset() {
        edgeList.clear();
    }
}
