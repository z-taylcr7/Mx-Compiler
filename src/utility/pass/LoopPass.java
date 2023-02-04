package utility.pass;


import undecimber.compiler.middleend.analytics.loop.Loop;

public interface LoopPass extends Pass {
    void runLoop(Loop loop);
}
