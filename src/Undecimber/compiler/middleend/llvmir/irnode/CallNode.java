package undecimber.compiler.middleend.llvmir.irnode;

import undecimber.compiler.middleend.llvmir.IRBlock;
import undecimber.compiler.middleend.llvmir.IRVisitor;
import undecimber.compiler.middleend.llvmir.Value;
import undecimber.compiler.middleend.llvmir.irtype.IRBaseType;
import undecimber.compiler.middleend.llvmir.irtype.IRFuncType;
import utility.LLVM;

public class CallNode extends IRBaseNode{

    public CallNode(String NodeName, IRFuncType func, IRBlock parentBlock) {
        super(LLVM.CallInst, func, parentBlock);
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

        return null;
    }

    /**
     * @return
     */
    @Override
    public IRBaseNode copy() {
        return null;
    }

    /**
     * @param visitor
     */
    @Override
    public void accept(IRVisitor visitor) {
        visitor.visit(this);

    }
}
