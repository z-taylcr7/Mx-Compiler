package undecimber.compiler.frontend.semantic;

import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.nodes.exprNode.*;
import undecimber.compiler.frontend.ast.nodes.stmtNode.*;
import utility.errors.semantic.TypeError;
import utility.types.MxBaseType;
import utility.types.VarType;
import utility.Mx;

import java.util.Objects;

//check type errors.
public class TypeMatcher {

    // unary:
    // LogicNot (!) -> bool
    // others (+ - ~) -> int
    public static void match(UnaryExprNode node) {
        if (Objects.equals(node.op, Mx.LogicNotOp)) {
            if (!node.selfExprNode.type.match(MxBaseType.BasicType.BOOL)) {
                throw new TypeError(node.pos, MxBaseType.BasicType.BOOL, node.selfExprNode.type);
            }
        } else {
            if (!node.selfExprNode.type.match(MxBaseType.BasicType.INT)) {
                throw new TypeError(node.pos, MxBaseType.BasicType.INT, node.selfExprNode.type);
            }
        }
    }

    // prefix: --a, ++a -> int, leftValue
    public static void match(PrefixExprNode node) {
        if (!node.exprNode.isLeftValue()) {
            throw new TypeError(node.pos, TypeError.prefixAndSuffix);
        }
        if (!node.exprNode.type.match(MxBaseType.BasicType.INT)) {
            throw new TypeError(node.pos, MxBaseType.BasicType.INT, node.exprNode.type);
        }
    }

    // Suffix: a++, a-- -> int, leftValue
    public static void match(SuffixExprNode node) {
        if (!node.exprNode.isLeftValue()) {
            throw new TypeError(node.pos, TypeError.prefixAndSuffix);
        }
        if (!node.exprNode.type.match(MxBaseType.BasicType.INT)) {
            throw new TypeError(node.pos, MxBaseType.BasicType.INT, node.exprNode.type);
        }
    }

    // member: a.b, a -> class (str and array is checked in semantic checker)
    public static void match(MemberExprNode node) {
        if (!node.supExprNode.type.match(MxBaseType.BasicType.CLASS)) {
            throw new TypeError(node.pos, TypeError.typeNotCallable, node.supExprNode.type);
        }
    }

    //index: a[b], a -> subscribable, b -> int
    public static void match(IndexExprNode node) {
        if (!(node.arrayExprNode.type instanceof VarType)) {
            throw new TypeError(node.pos, TypeError.typeNotSubscribable, node.arrayExprNode.type);
        }
        if (((VarType) node.arrayExprNode.type).dimension == 0) {
            throw new TypeError(node.pos, TypeError.typeNotSubscribable, node.arrayExprNode.type);
        }
        assert node.indexExprNode != null;
        if (!node.indexExprNode.type.match(MxBaseType.BasicType.INT)) {
            throw new TypeError(node.pos, MxBaseType.BasicType.INT, node.indexExprNode.type);
        }
    }

    // binary: a op b
    // ----------------------
    // str & str: == != >= <= > < +
    // logicOps: bool && bool
    // arithOps: int + int
    // compare: int < >int
    // == !=: all

    public static void match(BinaryExprNode node) {
        //System.err.println(node.op);
        //System.err.println(node.lhsExprNode.toString());
        //System.err.println(node.rhsExprNode.toString());
        if (!node.lhsExprNode.type.match(node.rhsExprNode.type)) {

            throw new TypeError(node.pos, node.lhsExprNode.type, node.rhsExprNode.type);
        }

        if (node.lhsExprNode.type.match(MxBaseType.BasicType.STRING)) {
            if (!Objects.equals(node.op, Mx.AddOp) &&
                !Objects.equals(node.opType, Mx.compareOpType) &&
                !Objects.equals(node.opType, Mx.equalOpType)
            ) {
                throw new TypeError(node.pos, TypeError.invalidOpForType, node.lhsExprNode.type);
            }
            return;
        }

        if (Objects.equals(node.opType, Mx.logicOpType)) {
            if (!node.lhsExprNode.type.match(MxBaseType.BasicType.BOOL))
                throw new TypeError(node.pos, TypeError.invalidOpForType, node.lhsExprNode.type);
        }

        else if (Objects.equals(node.opType, Mx.arithOpType)) {
            if (!node.lhsExprNode.type.match(MxBaseType.BasicType.INT))
                throw new TypeError(node.pos, TypeError.invalidOpForType, node.lhsExprNode.type);
        }

        else if (Objects.equals(node.opType, Mx.compareOpType)) {
            if (!node.lhsExprNode.type.match(MxBaseType.BasicType.INT))
                throw new TypeError(node.pos, TypeError.invalidOpForType, node.lhsExprNode.type);
        }
    }

    //assignment: a = b -> a.type == b.type, a is left-value
    public static void match(AssignExprNode node) {
        if (!node.lhs.isLeftValue()) {
            throw new TypeError(node.pos, TypeError.assignment);
        }
        if (!node.lhs.type.match(node.rhs.type)) {
            throw new TypeError(node.pos, node.lhs.type, node.rhs.type);
        }
    }

    //var declaration: be like: int a = 1, b = 2;
    public static void match(VarDefSingleNode node) {
        if (!node.varRegistry.type.match(node.initExpNode.type)) {
            throw new TypeError(
                    node.pos, node.varRegistry.type, node.initExpNode.type
            );
        }
    }

    // forstmt: cond is bool
    public static void match(ForStmtNode node) {
        if (!node.conditionExprNode.type.match(MxBaseType.BasicType.BOOL)) {
            throw new TypeError(
                    node.pos, MxBaseType.BasicType.BOOL, node.conditionExprNode.type
            );
        }
    }

    // while stmt: cond is bool
    public static void match(WhileStmtNode node) {
        if (!node.conditionExprNode.type.match(MxBaseType.BasicType.BOOL)) {
            throw new TypeError(
                    node.pos, MxBaseType.BasicType.BOOL, node.conditionExprNode.type
            );
        }
    }

    // if stmt: cond is bool
    public static void match(IfStmtNode node) {
        if (!node.condition.type.match(MxBaseType.BasicType.BOOL)) {
            throw new TypeError(
                    node.pos, MxBaseType.BasicType.BOOL, node.condition.type
            );
        }
    }

    // new: int[][] a = new int[][];
    // dim sizes -> int
    public static void match(NewExprNode node) {
        for (ExprNode dimLengthExprNodes : node.DimLengthExprNodes) {
            if (!dimLengthExprNodes.type.match(MxBaseType.BasicType.INT)) {
                throw new TypeError(node.pos, MxBaseType.BasicType.INT, dimLengthExprNodes.type);
            }
        }
    }
}
