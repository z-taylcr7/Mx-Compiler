package Undecimber.compiler.middleend.mir;

import Undecimber.compiler.backend.rvasm.operand.BaseOperand;
import Undecimber.compiler.middleend.llvmir.inst.IRMoveInst;
import Undecimber.compiler.middleend.llvmir.type.IRBaseType;
//import Undecimber.compiler.share.lang.LLVM;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class Value {


    public IRBaseType type;
    public ArrayList<User> users = new ArrayList<User>();
    public Value resolveFrom = null;
    public String name;
    public String comment = null;

    // a move will def a value but due to it is a void inst, use this
    public Set<IRMoveInst> moveDefs = new HashSet<>();

    // interact with BackEnd
    public BaseOperand asmOperand = null;

    public Value(IRBaseType type) {
        this.name = LLVM.TypeAnon;
        this.type = type;
    }

    public Value(String name, IRBaseType type) {
        this.name = rename(name);
        this.type = type;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public String identifier() {
        return "%" + name;
    }

    // RAUW
    public void replaceAllUsesWith(Value replace) {
        if (this == replace) return;

        for (User user : users) {
            var operands = user.operands;
            for (int i = 0; i < operands.size(); i++) {
                if (operands.get(i) == this)
                    operands.set(i, replace);
            }
            replace.users.add(user);
        }
    }

    public String typedIdentifier() {
        return type + " " + identifier();
    }

    public String commentFormat() {
        if (comment == null) return "";
        return LLVM.CommentPrefix + comment;
    }
}