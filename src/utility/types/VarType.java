package utility.types;


import utility.position;
import Undecimber.compiler.frontend.parser.MxParser;
import utility.errors.semantic.typeError;
import java.util.Objects;

public class VarType extends MxBaseType {

    public String className;

    public int dimension;  // for array

    public VarType(BasicType basicType) {
        super(basicType);
        dimension = 0;
        className = nonClass;
    }

    public VarType(String className) {
        super(BasicType.CLASS);
        this.className = className;
        dimension = 0;
    }

    public VarType(MxParser.VarDefTypeContext ctx, boolean isFuncRetType) {
        super(BasicType.NULL);
        dimension = ctx.LBracket().size();
        className = nonClass;

        if (ctx.BasicType() != null) {
            if (ctx.BasicType().IntType() != null) basicType = BasicType.INT;
            else if (ctx.BasicType().BoolType() != null)basicType = BasicType.BOOL;
            else if (ctx.BasicType().StringType() != null) basicType = BasicType.STRING;
            else if (ctx.BasicType().VoidType() != null) basicType = BasicType.VOID;
        } else if (ctx.ID() != null) {
            basicType = BasicType.CLASS;
            className = ctx.ID().toString();
        }
    }

    public VarType(MxStarParser.VarDefTypeContext ctx) {
        super(BasicType.NULL);
        dimension = ctx.LBracket().size();
        className = nonClass;

        if (ctx.BasicType() != null) {
            if (ctx.BasicType().IntType() != null) basicType = BasicType.INT;
            else if (ctx.BasicType().BoolType() != null) basicType = BasicType.BOOL;
            else if (ctx.BasicType().StringType() != null) basicType = BasicType.STRING;
            else if (ctx.BasicType().VoidType() != null) {
                throw new TypeError(new position(ctx), TypeError.canNotBeVoid);
            }
        } else if (ctx.Identifier() != null) {
            basicType = BasicType.CLASS;
            className = ctx.ID().toString();
        }
    }

    public VarType(MxStarParser.NewExpContext ctx) {
        super(BasicType.NULL);
        dimension = ctx.newExpSizeDeclaration().size();
        className = nonClass;

        boolean isAllNull = (dimension > 0);

        for (int i = 0; i < dimension; i++)
            if (ctx.new ExpSizeDeclaration(i).expression() != null)
                isAllNull = false;

        if (isAllNull) throw new ArrayDeclarationError(new CodePos(ctx), ArrayDeclarationError.leastOneSize);

        for (int i = 0; i < dimension-1; i++) {
            if (ctx.newExpSizeDeclaration(i).expression() == null &&
                    ctx.newExpSizeDeclaration(i+1).expression() != null) {
                throw new ArrayDeclarationError(
                        new CodePos(ctx.newExpSizeDeclaration(i)),
                        ArrayDeclarationError.outsizeFirst
                );
            }
        }

        if (ctx.BasicType() != null) {
            if (ctx.BasicType().IntType() != null) BasicType = BasicType.INT;
            else if (ctx.BasicType().BoolType() != null) BasicType = BasicType.BOOL;
            else if (ctx.BasicType().StringType() != null) BasicType = BasicType.STRING;
            else if (ctx.BasicType().VoidType() != null)  {
                throw new TypeError(new position(ctx), TypeError.canNotBeVoid);
            }
        } else if (ctx.Identifier() != null) {
            BasicType = BasicType.CLASS;
            className = ctx.Identifier().toString();
        }
    }

    public MxBaseType copy() {
        VarType ret = new VarType(BasicType);
        ret.dimension = dimension;
        ret.className = className;
        return ret;
    }

    @Override
    public boolean isArray() {
        return this.dimension > 0;
    }

    @Override
    public boolean match(MxBaseType other) {
        if (other instanceof VarType) {
            if ((dimension > 0 || BasicType == BasicType.CLASS) && other.BasicType == BasicType.NULL) {
                return true;
            }
            return BasicType == other.BasicType &&
                    Objects.equals(className, ((VarType) other).className)
                    && dimension == ((VarType) other).dimension;
        }
        return false;
    }

    @Override
    public boolean match(BasicType other) {
        if ((dimension > 0 || BasicType == BasicType.CLASS) && other == BasicType.NULL) {
            return true;
        }
        return BasicType == other && dimension == 0;
    }

    public String toString() {
        StringBuilder ret = null;

        if (BasicType == BasicType.CLASS) ret = new StringBuilder(className);
        else ret = new StringBuilder(BasicType.toString());

        for (int i = 0; i < dimension; ++i) ret.append("[]");
        return ret.toString();
    }
}