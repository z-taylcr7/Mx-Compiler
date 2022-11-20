package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRFunction;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRFuncType;
import undecimber.compiler.middleend.llvmir.irtype.IRVoidType;
import utility.LLVM;

import java.util.ArrayList;

public class CallNode extends IRBaseNode{

    public CallNode(IRFunction func, IRBlock parentBlock, ArrayList<Value>args) {
        super(func.name + LLVM.CallSuffix, ((IRFuncType) func.type).retType, parentBlock);
        this.addOperand(func);
        for (int i = 0; i <args.size() ; i++) {
            this.addOperand(args.get(i));
        }
    }
    public CallNode(IRFunction func, IRBlock parentBlock, Value... args) {
        super(func.name + LLVM.CallSuffix, ((IRFuncType) func.type).retType, parentBlock);
        this.addOperand(func);
        for (Value arg:args) {
            this.addOperand(arg);
        }
    }
    IRFunction callFunc(){
        return (IRFunction) this.getOperand(0);
    }

    /**
     * @return
     */
    @Override
    public String format() {
        //%retval = call i32 @test(i32 %argc)
        //call i32 (ptr, ...) @printf(ptr %msg, i32 12, i8 42)        ; yields i32
        //%X = tail call i32 @foo()                                    ; yields i32
        //%Y = tail call fastcc i32 @foo()  ; yields i32
        //call void %foo(i8 signext 97)
        //
        //%struct.A = type { i32, i8 }
        //%r = call %struct.A @foo()                        ; yields { i32, i8 }
        //%gr = extractvalue %struct.A %r, 0                ; yields i32
        //%gr1 = extractvalue %struct.A %r, 1               ; yields i8
        //%Z = call void @foo() noreturn                    ; indicates that %foo never returns normally
        //%ZZ = call zeroext i32 @bar()                     ; Return value is %zero extended
        StringBuilder ret = new StringBuilder((this.type.match(new IRVoidType())) ? "" : this.identifier() + " = ");
        ret.append(LLVM.CallInst + " (");
        for (int i = 1; i < this.getOperandSize()+1; i++) {
            ret.append(this.getOperand(i).typeIdentifier()+" , ");
        }
        ret.append(")");
        return ret.toString();
    }

    /**
     * @return
     */
    @Override
    public IRBaseNode copy() {
        ArrayList<Value> args = new ArrayList<Value>();
        for (int i = 1; i < this.callFunc().getArgNum(); i++)
            args.add(this.callFunc().getArg(i));
        return new CallNode(callFunc(), null, args);
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);
    }
}
