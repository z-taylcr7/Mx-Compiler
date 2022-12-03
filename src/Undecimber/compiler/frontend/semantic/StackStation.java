package undecimber.compiler.frontend.semantic;

import org.antlr.v4.runtime.misc.Pair;
import  undecimber.compiler.frontend.scope.*;
import  undecimber.compiler.frontend.registry.*;
import utility.types.VarType;


import java.util.Stack;

public class StackStation {
    public Stack<BaseScope> scopeStack;
    public ClassRegistry curClass = null;

    public StackStation(){
        this.scopeStack=new Stack<>();
    }
    public VarRegistry getVarInStack(String name) {
        VarRegistry ret = null;

        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            ret = scopeStack.get(i).getVar(name);
            if (ret != null) {
                break;
            }
        }
        return ret;
    }
    public Pair<VarRegistry, Boolean> getVarInStack_IR(String name) {
        VarRegistry ret = null;
        boolean isMember = false;
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            ret = scopeStack.get(i).getVar(name);
            if (ret != null && ret.value != null) {
                if (scopeStack.get(i) instanceof ClassScope) isMember = true;
                break;
            }
        }
        return new Pair<>(ret, isMember);
    }

    public ClassRegistry getClass(String name) {
        return scopeStack.get(0).getClass(name);
    }

    public FuncRegistry getFuncInStack(String name) {
        FuncRegistry ret = null;
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            ret = scopeStack.get(i).getFunc(name);
            if (ret != null) break;
        }
        return ret;
    }

    public void push(BaseScope scope) {
        assert scope != null;
        this.scopeStack.push(scope);
    }
    public void push(ClassRegistry registry) {
        assert registry.scope != null;
        this.scopeStack.push(registry.scope);
        this.curClass = registry;
    }

    public void pop() {
        if (this.scopeStack.peek() instanceof ClassScope)
            this.curClass = null;
        this.scopeStack.pop();
    }

    public void register(BaseRegistry registry) {
        if (scopeStack.peek() instanceof ClassScope) return;
        scopeStack.peek().register(registry);
    }

    public void stackReturn(VarType returnType) {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof FuncScope) {
                ((FuncScope) scopeStack.get(i)).catchedRetTypeList.add(returnType);
                return;
            }
        }
    }

    public boolean isInLoop() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof LoopScope) {
                return true;
            }
        }
        return false;
    }

    public boolean isInFunc() {
        for (int i = scopeStack.size() - 1; i >= 0; i--) {
            if (scopeStack.get(i) instanceof FuncScope) {
                return true;
            }
        }
        return false;
    }

    public ClassRegistry getCurClass() {
        return curClass;
    }
}