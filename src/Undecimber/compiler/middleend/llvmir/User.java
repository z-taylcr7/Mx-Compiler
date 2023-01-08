package undecimber.compiler.middleend.llvmir;

import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;

import java.util.ArrayList;

public class User extends Value{
    public ArrayList<Value> operands=new ArrayList<Value>();

    public User(IRBaseType type) {
        super(type);
    }

    public User(String name, IRBaseType type) {
        super(name, type);
    }
    public Value getOperand(int index){
        return operands.get(index);
    }
    public Value getArg(int i){
        return getOperand(i+1);
    }
    public void setOperand(int index, Value value){
        operands.get(index).users.remove(this);
        operands.set(index, value);
        value.addUser(this);
    }
    public int getOperandSize(){
        return operands.size();

    }
    public void addOperand(Value value) {
        if (value != null) value.addUser(this);
        operands.add(value);
    }
}
