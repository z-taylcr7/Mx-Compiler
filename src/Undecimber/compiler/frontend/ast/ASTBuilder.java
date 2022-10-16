package undecimber.compiler.frontend.ast;

import undecimber.compiler.frontend.ast.nodes.*;
import undecimber.compiler.frontend.ast.nodes.ExprNode.*;
import undecimber.compiler.frontend.ast.node.StmtNode.*;
import undecimber.compiler.frontend.registry.*;
import undecimber.compiler.frontend.scope.*;
import utility.errors.*;
import utility.types.MxBaseType;
import utility.types.VarType;
import undecimber.compiler.frontend.parser.MxBaseVisitor;
import undecimber.compiler.frontend.parser.MxParser;


import java.util.Objects;

public class ASTBuilder extends MxBaseVisitor<ASTNode> {

    @Override public ASTNode visitMxCode(MxParser.MxCodeContext ctx) {

        RootNode ret = new RootNode(new position(ctx));

        ret.scope.register(
                new FuncRegistry("print", MxBaseType.BasicType.VOID,
                        new VarRegistry("str", MxBaseType.BasicType.STRING))
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
            throw new MainFuncError(
                    new position(ctx.getStop()), // report the end of code is reasonable.
                    MainFuncError.missingMain
            );
        }

        return ret;
    }

    @Override public ASTNode visitClassDef(MxParser.ClassDefContext ctx) {


        ClassDefNode ret = new ClassDefNode(new position(ctx));

        ret.classRegistry = new ClassRegistry(ctx);

        ctx.classConstructorDef().forEach(sonctx -> {
            FuncDefNode constructorDefNode = (FuncDefNode) visit(sonctx);

            if (!Objects.equals(ret.classRegistry.name, constructorDefNode.funcRegistry.name)) {
                //class already exist
                throw new ClassDeclarationError(new position(ctx), ClassDeclarationError.constructorWrongName);
            }

            ret.classRegistry.memberFuncs.add(constructorDefNode.funcRegistry);
            ret.classRegistry.scope.register(constructorDefNode.funcRegistry);
            ret.constructorDefNode = constructorDefNode;
        });

        if (ctx.classConstructorDef().size() == 0) {
            FuncRegistry defaultConstructor = new FuncRegistry(ctx.Identifier().getText());
            PackNode packNode = new PackNode(new position(ctx));
            ReturnStmtNode retNode = new ReturnStmtNode(new position(ctx));
            packNode.stmtNodes.add(retNode);
            ret.classRegistry.memberFuncs.add(defaultConstructor);
            ret.classRegistry.scope.register(defaultConstructor);
            ret.constructorDefNode = new FuncDefNode(new position(ctx), defaultConstructor, packNode);
        }

        ctx.varDefStmt().forEach(sonctx -> {
            VarDefStmtNode varDefStmtNode = (VarDefStmtNode) visit(sonctx);
            varDefStmtNode.varDefSingleNodes.forEach(sonnode -> {
                ret.classRegistry.memberVars.add(sonnode.varRegistry);
                ret.classRegistry.scope.register(sonnode.varRegistry);
            });
            ret.varDefStmtNodes.add(varDefStmtNode);
        });

        ctx.funcDef().forEach(sonctx -> {
            FuncDefNode funcDefNode = (FuncDefNode) visit(sonctx);

            ret.classRegistry.memberFuncs.add(funcDefNode.funcRegistry);
            ret.classRegistry.scope.register(funcDefNode.funcRegistry);
            ret.funcDefNodes.add(funcDefNode);
        });

        return ret;
    }

    @Override public ASTNode visitClassConstructorDef(MxParser.ClassConstructorDefContext ctx) {
        return new FuncDefNode(new position(ctx), new FuncRegistry(ctx), (packNode) visit(ctx.pack()));
    }

    @Override public ASTNode visitFuncDef(MxParser.FuncDefContext ctx) {
        return new FuncDefNode(new position(ctx), new FuncRegistry(ctx), (packNode) visit(ctx.pack()));
    }

    @Override public ASTNode visitVarDefStmt(MxParser.VarDefStmtContext ctx) {
        VarDefStmtNode ret = new VarDefStmtNode(new position(ctx));

        for (int i = 0; i < ctx.varDefObj().varDefSingle().size(); i++) {
            VarDefSingleNode varDefSingleNode = (VarDefSingleNode) visit(ctx.varDefObj().varDefSingle(i));
            varDefSingleNode.varRegistry.type = new VarType(ctx.varDefObj().varDefType());
            ret.varDefSingleNodes.add(varDefSingleNode);
        }

        return ret;
    }

    @Override public ASTNode visitVarDefSingle(MxParser.VarDefSingleContext ctx) {
        VarDefSingleNode ret = new VarDefSingleNode(new position(ctx));

        ret.varRegistry = new VarRegistry(ctx.Identifier().toString(), ctx);

        if (ctx.AssignOp() != null) ret.initExpNode = (ExpASTNode) visit(ctx.expression());

        return ret;
    }

    @Override public ASTNode visitPack(MxParser.PackContext ctx) {
        packNode ret = new packNode(new position(ctx));
        ctx.statement().forEach(sonctx -> ret.stmtNodes.add((StmtASTNode) visit(sonctx)));
        return ret;
    }





    @Override public ASTNode visitForStmt(MxParser.ForStmtContext ctx) {
        ForStmtNode ret = new ForStmtNode(new position(ctx));

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
                    ret.initExpNode = (ExpASTNode) visit(ctx.forInit().expression());
            }
        }
        if (ctx.forCondition != null) {
            ret.conditionExpNode = (ExpASTNode) visit(ctx.forCondition);
        }
        if (ctx.forIncr != null) {
            ret.incrExpNode = (ExpASTNode) visit(ctx.forIncr);
        }

        ret.bodyStmtNode = (StmtASTNode) visit(ctx.statement());

        return ret;
    }

    @Override public ASTNode visitWhileStmt(MxParser.WhileStmtContext ctx) {
        return new WhileStmtNode(new position(ctx),
                (ExpASTNode) visit(ctx.expression()),
                (StmtASTNode) visit(ctx.statement()));
    }

    @Override public ASTNode visitIfStmt(MxParser.IfStmtContext ctx) {
        IfStmtNode ret = new IfStmtNode(new position(ctx),
                (ExprNode) visit(ctx.expression()),
                (StmtNode) visit(ctx.statement(0)));
        if (ctx.statement().size() == 2) {
            ret.elseStmtNode = (StmtNode) visit(ctx.statement(1));
        }
        return ret;
    }

    @Override public ASTNode visitPackStmt(MxParser.PackStmtContext ctx) {
        return new PackStmtNode(new position(ctx), (packNode) visitPack(ctx.pack()));
    }

    @Override public ASTNode visitControlStmt(MxParser.ControlStmtContext ctx) {
        String controlWord = ctx.getText();
        controlWord = controlWord.substring(0, controlWord.length()-1); // get rid of ';'
        return new ControlStmtNode(new position(ctx), controlWord);
    }

    @Override public ASTNode visitReturnStmt(MxParser.ReturnStmtContext ctx) {
        ReturnStmtNode ret = new ReturnStmtNode(new position(ctx));
        if (ctx.expression() != null) ret.retExpNode = (ExpASTNode) visit(ctx.expression());
        return ret;
    }

    @Override public ASTNode visitPureStmt(MxParser.PureStmtContext ctx) {
        PureStmtNode ret = new PureStmtNode(new position(ctx));
        if (ctx.expression() != null) ret.pure = (ExprNode) visit(ctx.expression());
        return ret;
    }

    @Override public ASTNode visitBinaryExp(MxParser.BinaryExpContext ctx) {
        BinaryExprNode ret = new BinaryExprNode(new position(ctx),
                (ExprNode) visit(ctx.expression().get(0)), (ExprNode) visit(ctx.expression().get(1))
        );

        if (ctx.LogicOrOp() != null) {
            ret.op = Mx.LogicOrOp;
            ret.opType = Mx.logicOpType;
        }
        else if (ctx.LogicAndOp() != null) {
            ret.op = Mx.LogicAndOp;
            ret.opType = Mx.logicOpType;
        }
        else if (ctx.BitXorOp() != null) {
            ret.op = Mx.BitXorOp;
            ret.opType = Mx.arithOpType;
        }
        else if (ctx.BitOrOp() != null) {
            ret.op = Mx.BitOrOp;
            ret.opType = Mx.arithOpType;
        }
        else if (ctx.BitAndOp() != null) {
            ret.op = Mx.BitAndOp;
            ret.opType = Mx.arithOpType;
        }
        else if (ctx.equalOps() != null) {
            ret.op = ctx.equalOps().getText();
            ret.opType = Mx.equalOpType;
        }
        else if (ctx.compareOps() != null) {
            ret.op = ctx.compareOps().getText();
            ret.opType = Mx.compareOpType;
        }
        else if (ctx.addLevelOps() != null) {
            ret.op = ctx.addLevelOps().getText();
            ret.opType = Mx.arithOpType;
        }
        else if (ctx.mulLevelOps() != null) {
            ret.op = ctx.mulLevelOps().getText();
            ret.opType = Mx.arithOpType;
        }
        else if (ctx.shiftOps() != null) {
            ret.op = ctx.shiftOps().getText();
            ret.opType = Mx.arithOpType;
        }

        return ret;
    }

    @Override public ASTNode visitAssignExp(MxParser.AssignExpContext ctx) {
        return new AssignExprNode(new position(ctx),
                (ExpASTNode) visit(ctx.expression(0)), (ExpASTNode) visit(ctx.expression(1)));
    }

    @Override public ASTNode visitFuncCallExp(MxParser.FuncCallExpContext ctx) {
        FuncCallExprNode ret = new FuncCallExprNode(new position(ctx), (ExpASTNode) visit(ctx.expression()));
        if (ctx.funcCallArgs().expression() != null) {
            ctx.funcCallArgs().expression().forEach(sonctx -> {
                ret.callArgExprNodes.add((ExpASTNode) visit(sonctx));
            });
        }
        return ret;
    }

    @Override public ASTNode visitIndexExp(MxParser.IndexExpContext ctx) {
        return new IndexExpNode(new position(ctx),
                (ExpASTNode) visit(ctx.expression(0)),
                (ExpASTNode) visit(ctx.expression(1))
        );
    }

    @Override public ASTNode visitLambdaExp(MxParser.LambdaExpContext ctx) {
        LambdaExpNode ret = new LambdaExpNode(new position(ctx), (packNode) visit(ctx.pack()));

        ret.funcRegistry = new FuncRegistry(ctx);

        if (ctx.funcCallArgs().expression() != null) {
            ctx.funcCallArgs().expression().forEach(sonctx -> {
                ret.callArgExpNodes.add((ExpASTNode) visit(sonctx));
            });
        }
        return ret;
    }

    @Override public ASTNode visitMemberExp(MxParser.MemberExpContext ctx) {
        return new MemberExpNode(new position(ctx), (ExpASTNode) visit(ctx.expression()), ctx.Identifier().getText());
    }

    @Override public ASTNode visitPostfixExp(MxParser.PostfixExpContext ctx) {
        return new PostfixExpNode(new position(ctx), ctx.postfixOps().getText(), (ExpASTNode) visit(ctx.expression()));
    }

    @Override public ASTNode visitUnaryExp(MxParser.UnaryExpContext ctx) {
        return new UnaryExpNode(new position(ctx), ctx.unaryOps().getText(), (ExpASTNode) visit(ctx.expression()));
    }

    @Override public ASTNode visitPrefixExp(MxParser.PrefixExpContext ctx) {
        return new PrefixExpNode(new position(ctx), ctx.prefixOps().getText(), (ExpASTNode) visit(ctx.expression()));
    }

    @Override public ASTNode visitNewExp(MxParser.NewExpContext ctx) {
        NewExpNode ret =  new NewExpNode(new position(ctx), new VarType(ctx));
        ctx.newExpSizeDeclaration().forEach(sonctx->{
            if (sonctx.expression() != null) {
                ret.eachDimLengthExpNodes.add((ExpASTNode) visit(sonctx.expression()));
            }
        });
        return ret;
    }

    @Override public ASTNode visitParenExp(MxParser.ParenExpContext ctx) {
        return visit(ctx.expression());
    }

    @Override public ASTNode visitAtomExp(MxParser.AtomExpContext ctx) {
        return new AtomExpNode(new position(ctx), ctx.atom());
    }
}