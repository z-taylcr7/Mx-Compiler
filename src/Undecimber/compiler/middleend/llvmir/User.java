package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;

import java.util.ArrayList;

public class User extends Value{
    public static final ArrayList<Value> operands=new ArrayList<Value>();

    public User(IRBaseType type) {
        super(type);
    }

    public User(String name, IRBaseType type) {
        super(name, type);
    }
    Value getOperand(int index){
        return operands.get(index);
    }
    void setOperand(int index, Value value){
        operands.get(index).users.remove(this);
        operands.set(index, value);
        value.addUser(this);
    }
    int getOperandSize(){
        return operands.size();

    }
    public void addOperand(Value value) {
        if (value != null) value.addUser(this);
        operands.add(value);
    }
}
