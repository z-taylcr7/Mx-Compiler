package utility.types;


import utility.Position;
import undecimber.compiler.frontend.parser.MxParser;
import utility.errors.semantic.TypeError;
import utility.errors.syntax.ArrayDeclarationError;

import java.util.Objects;

public class VarType extends MxBaseType {
    public static final String nonClass = "not a class";
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

        if (ctx.basicType() != null) {
            if (ctx.basicType().IntType() != null) basicType = BasicType.INT;
            else if (ctx.basicType().BoolType() != null)basicType = BasicType.BOOL;
            else if (ctx.basicType().StringType() != null) basicType = BasicType.STRING;
            else if (ctx.basicType().VoidType() != null) basicType = BasicType.VOID;
        } else if (ctx.ID() != null) {
            basicType = BasicType.CLASS;
            className = ctx.ID().toString();
        }
    }

    public VarType(MxParser.VarDefTypeContext ctx) {
        super(BasicType.NULL);
        dimension = ctx.LBracket().size();
        className = nonClass;

        if (ctx.basicType() != null) {
            if (ctx.basicType().IntType() != null) basicType = BasicType.INT;
            else if (ctx.basicType().BoolType() != null) basicType = BasicType.BOOL;
            else if (ctx.basicType().StringType() != null) basicType = BasicType.STRING;
            else if (ctx.basicType().VoidType() != null) {
                throw new TypeError(new Position(ctx), TypeError.canNotBeVoid);
            }
        } else if (ctx.ID() != null) {
            basicType = BasicType.CLASS;
            className = ctx.ID().toString();
        }
    }

    public VarType(MxParser.NewExpContext ctx) {
        super(BasicType.NULL);
        dimension = ctx.newExpSizeDeclaration().size();
        className = nonClass;

        boolean isNull = (dimension > 0);

        for (int i = 0; i < dimension; i++)
            if (ctx.newExpSizeDeclaration(i).expression() != null)
                isNull = false;

        if (isNull) throw new ArrayDeclarationError(new Position(ctx), ArrayDeclarationError.undefinedSize);

        for (int i = 0; i < dimension-1; i++) {
            if (ctx.newExpSizeDeclaration(i).expression() == null &&
                    ctx.newExpSizeDeclaration(i+1).expression() != null) {
                throw new ArrayDeclarationError(
                        new Position(ctx.newExpSizeDeclaration(i)),
                        ArrayDeclarationError.outOfSize
                );
            }
        }

        if (ctx.basicType() != null) {
            if (ctx.basicType().IntType() != null) basicType = BasicType.INT;
            else if (ctx.basicType().BoolType() != null) basicType = BasicType.BOOL;
            else if (ctx.basicType().StringType() != null) basicType = BasicType.STRING;
            else if (ctx.basicType().VoidType() != null)  {
                throw new TypeError(new Position(ctx), TypeError.canNotBeVoid);
            }
        } else if (ctx.ID() != null) {
            basicType = BasicType.CLASS;
            className = ctx.ID().toString();
        }
    }

    //operator=
    public MxBaseType copy() {
        VarType ret = new VarType(basicType);
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
            if ((dimension > 0 || basicType == BasicType.CLASS) && other.basicType == BasicType.NULL) {
                return true;
            }
            return basicType == other.basicType &&
                    Objects.equals(className, ((VarType) other).className)
                    && dimension == ((VarType) other).dimension;
        }
        return false;
    }

    @Override
    public boolean match(BasicType other) {
        if ((dimension > 0 || basicType == BasicType.CLASS) && other == BasicType.NULL) {
            return true;
        }
        return basicType == other && dimension == 0;
    }

    public String toString() {
        StringBuilder ret = null;

        if (basicType == BasicType.CLASS) ret = new StringBuilder(className);
        else ret = new StringBuilder(basicType.toString());

        for (int i = 0; i < dimension; ++i) ret.append("[]");
        return ret.toString();
    }
}