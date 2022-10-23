package undecimber.compiler.frontend.ast;

import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.nodes.exprNode.*;
import undecimber.compiler.frontend.ast.nodes.stmtNode.*;
import undecimber.compiler.frontend.registry.*;
import utility.Mx;
import utility.types.MxBaseType;
import utility.types.VarType;
import undecimber.compiler.frontend.parser.MxBaseVisitor;
import undecimber.compiler.frontend.parser.MxParser;
import utility.Position;
import utility.errors.syntax.*;


import java.util.List;
import java.util.Objects;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {

    @Override public ASTNode visitMxCode(MxParser.MxCodeContext ctx) {
        System.out.println("visit mx code.");

        RootNode ret = new RootNode(new Position(ctx));

        ret.scope.register(
                new FuncRegistry("print", MxBaseType.BasicType.VOID, new VarRegistry("str", MxBaseType.BasicType.STRING))
        );

        ret.scope.register(
                new FuncRegistry("println", MxBaseType.BasicType.VOID,
                        new VarRegistry("str", MxBaseType.BasicType.STRING))
        );

        ret.scope.register(
                new FuncRegistry("printInt", MxBaseType.BasicType.VOID,
                        new VarRegistry("n", MxBaseType.BasicType.INT))
        );

        ret.scope.register(
                new FuncRegistry("printlnInt", MxBaseType.BasicType.VOID,
                        new VarRegistry("n", MxBaseType.BasicType.INT))
        );

        ret.scope.register(
                new FuncRegistry("getString", MxBaseType.BasicType.STRING)
        );

        ret.scope.register(
                new FuncRegistry("getInt", MxBaseType.BasicType.INT)
        );

        ret.scope.register(
                new FuncRegistry("toString", MxBaseType.BasicType.STRING,
                        new VarRegistry("i", MxBaseType.BasicType.INT))
        );
        boolean hasMainFunc = false;

        for (int i = 0; i < ctx.children.size(); i++) {
            if (ctx.children.get(i) instanceof MxParser.ClassDefContext) {
                ClassDefNode classDefNode = (ClassDefNode) visit(ctx.children.get(i));
                ret.sonNodes.add(classDefNode);
                ret.scope.register(classDefNode.classRegistry); // register class first
            }
            else if (ctx.children.get(i) instanceof MxParser.FuncDefContext) {
                FuncDefNode funcDefNode = (FuncDefNode) visit(ctx.children.get(i));
                ret.sonNodes.add(funcDefNode);
                ret.scope.register(funcDefNode.funcRegistry); // register global-func first
                if (funcDefNode.isValidMainFunc()) hasMainFunc = true;
            }
            else if (ctx.children.get(i) instanceof  MxParser.VarDefStmtContext) {
                VarDefStmtNode varDefStmtNode = (VarDefStmtNode) visit(ctx.children.get(i));
                ret.sonNodes.add(varDefStmtNode);
            }
        }

        if (!hasMainFunc) {
            throw new MainFunctionError(
                    new Position(ctx.getStop()), // report the end of code is reasonable.
                    MainFunctionError.cantFindMain
            );
        }

        return ret;
    }

    @Override public ASTNode visitClassDef(MxParser.ClassDefContext ctx) {


        ClassDefNode ret = new ClassDefNode(new Position(ctx));

        ret.classRegistry = new ClassRegistry(ctx);

        ctx.classConstructorDef().forEach(sonctx -> {
            FuncDefNode constructorDefNode = (FuncDefNode) visit(sonctx);

            if (!Objects.equals(ret.classRegistry.name, constructorDefNode.funcRegistry.name)) {
                //class already exist
                throw new ClassDeclarationError(new Position(ctx), ClassDeclarationError.constructorNameWrong);
            }

            ret.classRegistry.memberFuncs.add(constructorDefNode.funcRegistry);
            ret.classRegistry.scope.register(constructorDefNode.funcRegistry);
            ret.constructorDefNode = constructorDefNode;
        });

        if (ctx.classConstructorDef().size() == 0) {
            FuncRegistry defaultConstructor = new FuncRegistry(ctx.ID().getText());
            PackNode packNode = new PackNode(new Position(ctx));
            ReturnStmtNode retNode = new ReturnStmtNode(new Position(ctx));
            packNode.stmtNodes.add(retNode);
            ret.classRegistry.memberFuncs.add(defaultConstructor);
            ret.classRegistry.scope.register(defaultConstructor);
            ret.constructorDefNode = new FuncDefNode(new Position(ctx), defaultConstructor, packNode);
        }

        ctx.varDefStmt().forEach(sonctx -> {
            VarDefStmtNode varDefStmtNode = (VarDefStmtNode) visit(sonctx);
            varDefStmtNode.varDefSingleNodes.forEach(sonnode -> {
                ret.classRegistry.memberVars.add(sonnode.varRegistry);
                ret.classRegistry.scope.register(sonnode.varRegistry);
            });
            ret.varDefs.add(varDefStmtNode);
        });

        ctx.funcDef().forEach(sonctx -> {
            FuncDefNode funcDefNode = (FuncDefNode) visit(sonctx);

            ret.classRegistry.memberFuncs.add(funcDefNode.funcRegistry);
            ret.classRegistry.scope.register(funcDefNode.funcRegistry);
            ret.funcDefs.add(funcDefNode);
        });

        return ret;
    }

    @Override public ASTNode visitClassConstructorDef(MxParser.ClassConstructorDefContext ctx) {
        return new FuncDefNode(new Position(ctx), new FuncRegistry(ctx), (PackNode) visit(ctx.pack()));
    }

    @Override public ASTNode visitFuncDef(MxParser.FuncDefContext ctx) {
        return new FuncDefNode(new Position(ctx), new FuncRegistry(ctx), (PackNode) visit(ctx.pack()));
    }

    @Override public ASTNode visitVarDefStmt(MxParser.VarDefStmtContext ctx) {
        VarDefStmtNode ret = new VarDefStmtNode(new Position(ctx));

        for (int i = 0; i < ctx.varDefObj().varDefSingle().size(); i++) {
            VarDefSingleNode varDefSingleNode = (VarDefSingleNode) visit(ctx.varDefObj().varDefSingle(i));
            varDefSingleNode.varRegistry.type = new VarType(ctx.varDefObj().varDefType());
            ret.varDefSingleNodes.add(varDefSingleNode);
        }

        return ret;
    }

    @Override public ASTNode visitVarDefSingle(MxParser.VarDefSingleContext ctx) {
        VarDefSingleNode ret = new VarDefSingleNode(new Position(ctx));

        ret.varRegistry = new VarRegistry(ctx.ID().toString(), ctx);

        if (ctx.Assign() != null) ret.initExpNode = (ExprNode) visit(ctx.expression());

        return ret;
    }

    @Override public ASTNode visitPack(MxParser.PackContext ctx) {
        PackNode ret = new PackNode(new Position(ctx));
        ctx.statement().forEach(sonctx -> ret.stmtNodes.add((BaseStmtNode) visit(sonctx)));
        return ret;
    }





    @Override public ASTNode visitForStmt(MxParser.ForStmtContext ctx) {
        ForStmtNode ret = new ForStmtNode(new Position(ctx));

        if (ctx.forInit() != null) {
            if (ctx.forInit().varDefObj() != null) {
                for (int i = 0; i < ctx.forInit().varDefObj().varDefSingle().size(); i++) {
                    VarDefSingleNode varDefSingleNode = (VarDefSingleNode)
                            visit(ctx.forInit().varDefObj().varDefSingle(i));
                    varDefSingleNode.varRegistry.type = new VarType(ctx.forInit().varDefObj().varDefType());
                    ret.initVarDefSingleNodes.add(varDefSingleNode);
                }
            } else if (ctx.forInit().expression() != null) {
                if (ctx.forInit().expression() != null)
                    ret.initExprNode = (ExprNode) visit(ctx.forInit().expression());
            }
        }
        if (ctx.forCond != null) {
            ret.conditionExprNode = (ExprNode) visit(ctx.forCond);
        }
        if (ctx.forIncr != null) {
            ret.incrExprNode = (ExprNode) visit(ctx.forIncr);
        }

        ret.bodyStmtNode = (BaseStmtNode) visit(ctx.statement());

        return ret;
    }

    @Override public ASTNode visitWhileStmt(MxParser.WhileStmtContext ctx) {
        WhileStmtNode x=new WhileStmtNode(new Position(ctx),
                (ExprNode) visit(ctx.expression()),
                (BaseStmtNode) visit(ctx.statement()));
        return x;

    }

    @Override public ASTNode visitIfStmt(MxParser.IfStmtContext ctx) {

        IfStmtNode ret = new IfStmtNode(new Position(ctx),
                (ExprNode) visit(ctx.expression()),
                (BaseStmtNode) visit(ctx.statement(0)));
        if (ctx.statement().size() == 2) {
            ret.elseStmt = (BaseStmtNode) visit(ctx.statement(1));
        }
        return ret;
    }

    @Override public ASTNode visitPackStmt(MxParser.PackStmtContext ctx) {
        return new PackStmtNode(new Position(ctx), (PackNode) visitPack(ctx.pack()));
    }

    @Override public ASTNode visitControlStmt(MxParser.ControlStmtContext ctx) {
        String controlWord = ctx.getText();
        controlWord = controlWord.substring(0, controlWord.length()-1); // get rid of ';'
        return new ControlStmtNode(new Position(ctx), controlWord);
    }

    @Override public ASTNode visitReturnStmt(MxParser.ReturnStmtContext ctx) {
        ReturnStmtNode ret = new ReturnStmtNode(new Position(ctx));
        if (ctx.expression() != null) ret.value = (ExprNode) visit(ctx.expression());
        return ret;
    }

    @Override public ASTNode visitPureStmt(MxParser.PureStmtContext ctx) {
        PureStmtNode ret = new PureStmtNode(new Position(ctx));
        if (ctx.expression() != null) ret.pure = (ExprNode) visit(ctx.expression());
        return ret;
    }

    @Override public ASTNode visitBinaryExp(MxParser.BinaryExpContext ctx) {
        BinaryExprNode ret = new BinaryExprNode(new Position(ctx),
                (ExprNode) visit(ctx.expression().get(0)), (ExprNode) visit(ctx.expression().get(1))
        );
        if (ctx.LogicOr() != null) {
            ret.op = Mx.LogicOrOp;
            ret.opType = Mx.logicOpType;
        } else if (ctx.LogicAnd() != null) {
            ret.op = Mx.LogicAndOp;
            ret.opType = Mx.logicOpType;
        } else if (ctx.Xor() != null) {
            ret.op = Mx.BitXorOp;
            ret.opType = Mx.arithOpType;
        } else if (ctx.Or() != null) {
            ret.op = Mx.BitOrOp;
            ret.opType = Mx.arithOpType;
        }else if (ctx.And()!= null) {
            ret.op = Mx.BitAndOp;
            ret.opType = Mx.arithOpType;
        } else if (ctx.equalOps() != null) {
            ret.op = ctx.equalOps().getText();
            ret.opType = Mx.equalOpType;
        } else if (ctx.compareOps() != null) {
        ret.op = ctx.compareOps().getText();
        ret.opType = Mx.compareOpType;
        } else if (ctx.infOps() != null) {
            ret.op = ctx.infOps().getText();
            ret.opType = Mx.arithOpType;
        } else if (ctx.supOps() != null) {
            ret.op = ctx.supOps().getText();
            ret.opType = Mx.arithOpType;
        } else if (ctx.shiftOps() != null) {
            ret.op = ctx.shiftOps().getText();
            ret.opType = Mx.arithOpType;
        }

        return ret;
    }

    @Override public ASTNode visitAssignExp(MxParser.AssignExpContext ctx) {
        return new AssignExprNode(new Position(ctx),
                (ExprNode) visit(ctx.expression(0)), (ExprNode) visit(ctx.expression(1)));
    }

    @Override public ASTNode visitFunctionCallExp(MxParser.FunctionCallExpContext ctx) {
        FuncCallExprNode ret = new FuncCallExprNode(new Position(ctx), (ExprNode) visit(ctx.expression()));
        if (ctx.funcCallArgs().expression() != null) {;
            ctx.funcCallArgs().expression().forEach(sonctx -> {
                ret.callArgExpNodes.add((ExprNode) visit(sonctx));
            });
        }
        return ret;
    }

    @Override public ASTNode visitIndexExp(MxParser.IndexExpContext ctx) {
        return new IndexExprNode(new Position(ctx),
                (ExprNode) visit(ctx.expression(0)),
                (ExprNode) visit(ctx.expression(1))
        );
    }

    @Override public ASTNode visitLambdaExp(MxParser.LambdaExpContext ctx) {
        LambdaExprNode ret = new LambdaExprNode(new Position(ctx), (PackNode) visit(ctx.pack()));

        ret.funcRegistry = new FuncRegistry(ctx);

        if (ctx.funcCallArgs().expression() != null) {
            ctx.funcCallArgs().expression().forEach(sonctx -> {
                ret.callArgExprNodes.add((ExprNode) visit(sonctx));
            });
        }
        return ret;
    }

    @Override public ASTNode visitMemberExp(MxParser.MemberExpContext ctx) {
        return new MemberExprNode(new Position(ctx), (ExprNode) visit(ctx.expression()), ctx.ID().getText());
    }

    @Override public ASTNode visitSuffixExp(MxParser.SuffixExpContext ctx) {
        return new SuffixExprNode(new Position(ctx), ctx.suffixOps().getText(), (ExprNode) visit(ctx.expression()));
    }

    @Override public ASTNode visitUnaryExp(MxParser.UnaryExpContext ctx) {
        return new UnaryExprNode(new Position(ctx), ctx.unaryOps().getText(), (ExprNode) visit(ctx.expression()));
    }

    @Override public ASTNode visitPrefixExp(MxParser.PrefixExpContext ctx) {
        return new PrefixExprNode(new Position(ctx), ctx.prefixOps().getText(), (ExprNode) visit(ctx.expression()));
    }

    @Override public ASTNode visitNewExp(MxParser.NewExpContext ctx) {
        NewExprNode ret =  new NewExprNode(new Position(ctx), new VarType(ctx));
        ctx.newExpSizeDeclaration().forEach(sonctx->{
            if (sonctx.expression() != null) {
                ret.DimLengthExprNodes.add((ExprNode) visit(sonctx.expression()));
            }
        });
        return ret;
    }

    @Override public ASTNode visitParenExp(MxParser.ParenExpContext ctx) {
        return visit(ctx.expression());
    }

    @Override public ASTNode visitBasicExp(MxParser.BasicExpContext ctx) {
        return new AtomExprNode(new Position(ctx), ctx);
    }
}