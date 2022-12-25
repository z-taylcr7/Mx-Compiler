package undecimber.compiler.backend.asm.operands;

public abstract class BasicOperand {
    public String id;
    public BasicOperand(String _id){
        this.id=_id;
    }
    @Override
    public String toString(){
        return id;
    }
}
