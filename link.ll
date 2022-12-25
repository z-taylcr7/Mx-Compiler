; ModuleID = 'link.bc'
source_filename = "llvm-link"
target datalayout = "e-m:e-p270:32:32-p271:32:32-p272:64:64-i64:64-f80:128-n8:16:32:64-S128"
target triple = "x86_64-pc-linux-gnu"

%class.Edge = type { i32, i32, i32 }

@n = global i32 0, align 4
@m = global i32 0, align 4
@ans = global i32 0, align 4
@fa = global i32* null, align 8
@rk = global i32* null, align 8
@e = global %class.Edge** null, align 8
@.str = private unnamed_addr constant [3 x i8] c"%s\00", align 1
@.str.1 = private unnamed_addr constant [4 x i8] c"%s\0A\00", align 1
@.str.2 = private unnamed_addr constant [3 x i8] c"%d\00", align 1
@.str.3 = private unnamed_addr constant [4 x i8] c"%d\0A\00", align 1

define void @_global_init() {
entry.11:
  store i32 0, i32* @ans, align 4
  store i32* null, i32** @fa, align 8
  store i32* null, i32** @rk, align 8
  store %class.Edge** null, %class.Edge*** @e, align 8
  br label %exit.11

exit.11:                                          ; preds = %entry.11
  ret void
}

define void @Edge.Edge(%class.Edge* %internal.this) {
entry.12:
  br label %exit.12

exit.12:                                          ; preds = %entry.12
  ret void
}

define void @qsort(%class.Edge** %e.1, i32 %l, i32 %r) {
entry.13:
  %x.addr = alloca %class.Edge*, align 8
  %j.addr = alloca i32, align 4
  %i.addr = alloca i32, align 4
  %r.addr = alloca i32, align 4
  %l.addr = alloca i32, align 4
  %e.addr = alloca %class.Edge**, align 8
  store %class.Edge** %e.1, %class.Edge*** %e.addr, align 8
  store i32 %l, i32* %l.addr, align 4
  store i32 %r, i32* %r.addr, align 4
  %l.load = load i32, i32* %l.addr, align 4
  %r.load = load i32, i32* %r.addr, align 4
  %slt = icmp slt i32 %l.load, %r.load
  br i1 %slt, label %if.true, label %if.false

exit.13:                                          ; preds = %if.exit
  ret void

if.true:                                          ; preds = %entry.13
  %l.load.1 = load i32, i32* %l.addr, align 4
  store i32 %l.load.1, i32* %i.addr, align 4
  %r.load.1 = load i32, i32* %r.addr, align 4
  store i32 %r.load.1, i32* %j.addr, align 4
  %l.load.2 = load i32, i32* %l.addr, align 4
  %e.load = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %e.load.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load, i32 %l.load.2
  %e.load.elem.load = load %class.Edge*, %class.Edge** %e.load.elem.addr, align 8
  store %class.Edge* %e.load.elem.load, %class.Edge** %x.addr, align 8
  br label %wh.cond

if.false:                                         ; preds = %entry.13
  br label %if.exit

if.exit:                                          ; preds = %wh.exit, %if.false
  br label %exit.13

wh.cond:                                          ; preds = %if.exit.2, %if.true
  %i.load = load i32, i32* %i.addr, align 4
  %j.load = load i32, i32* %j.addr, align 4
  %slt.1 = icmp slt i32 %i.load, %j.load
  br i1 %slt.1, label %wh.body, label %wh.exit

wh.body:                                          ; preds = %wh.cond
  br label %wh.cond.1

wh.exit:                                          ; preds = %wh.cond
  %i.load.10 = load i32, i32* %i.addr, align 4
  %e.load.7 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %e.load.7.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.7, i32 %i.load.10
  %e.load.7.elem.load = load %class.Edge*, %class.Edge** %e.load.7.elem.addr, align 8
  %x.load.2 = load %class.Edge*, %class.Edge** %x.addr, align 8
  store %class.Edge* %x.load.2, %class.Edge** %e.load.7.elem.addr, align 8
  %e.load.8 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %l.load.3 = load i32, i32* %l.addr, align 4
  %i.load.11 = load i32, i32* %i.addr, align 4
  %sub = sub i32 %i.load.11, 1
  call void @qsort(%class.Edge** %e.load.8, i32 %l.load.3, i32 %sub)
  %e.load.9 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %i.load.12 = load i32, i32* %i.addr, align 4
  %add.4 = add i32 %i.load.12, 1
  %r.load.2 = load i32, i32* %r.addr, align 4
  call void @qsort(%class.Edge** %e.load.9, i32 %add.4, i32 %r.load.2)
  br label %if.exit

wh.cond.1:                                        ; preds = %wh.body.1, %wh.body
  %i.load.1 = load i32, i32* %i.addr, align 4
  %j.load.1 = load i32, i32* %j.addr, align 4
  %slt.2 = icmp slt i32 %i.load.1, %j.load.1
  br i1 %slt.2, label %logic.uncut, label %logic.exit

wh.body.1:                                        ; preds = %logic.exit
  %j.load.3 = load i32, i32* %j.addr, align 4
  %add = add i32 %j.load.3, -1
  store i32 %add, i32* %j.addr, align 4
  br label %wh.cond.1

wh.exit.1:                                        ; preds = %logic.exit
  %i.load.2 = load i32, i32* %i.addr, align 4
  %j.load.4 = load i32, i32* %j.addr, align 4
  %slt.3 = icmp slt i32 %i.load.2, %j.load.4
  br i1 %slt.3, label %if.true.1, label %if.false.1

logic.uncut:                                      ; preds = %wh.cond.1
  %j.load.2 = load i32, i32* %j.addr, align 4
  %e.load.1 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %e.load.1.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.1, i32 %j.load.2
  %e.load.1.elem.load = load %class.Edge*, %class.Edge** %e.load.1.elem.addr, align 8
  %w.addr = getelementptr inbounds %class.Edge, %class.Edge* %e.load.1.elem.load, i32 0, i32 2
  %w.load = load i32, i32* %w.addr, align 4
  %x.load = load %class.Edge*, %class.Edge** %x.addr, align 8
  %w.addr.1 = getelementptr inbounds %class.Edge, %class.Edge* %x.load, i32 0, i32 2
  %w.load.1 = load i32, i32* %w.addr.1, align 4
  %sge = icmp sge i32 %w.load, %w.load.1
  br label %logic.exit

logic.exit:                                       ; preds = %logic.uncut, %wh.cond.1
  %phi = phi i1 [ %slt.2, %wh.cond.1 ], [ %sge, %logic.uncut ]
  br i1 %phi, label %wh.body.1, label %wh.exit.1

if.true.1:                                        ; preds = %wh.exit.1
  %i.load.3 = load i32, i32* %i.addr, align 4
  %e.load.2 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %e.load.2.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.2, i32 %i.load.3
  %e.load.2.elem.load = load %class.Edge*, %class.Edge** %e.load.2.elem.addr, align 8
  %j.load.5 = load i32, i32* %j.addr, align 4
  %e.load.3 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %e.load.3.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.3, i32 %j.load.5
  %e.load.3.elem.load = load %class.Edge*, %class.Edge** %e.load.3.elem.addr, align 8
  store %class.Edge* %e.load.3.elem.load, %class.Edge** %e.load.2.elem.addr, align 8
  %i.load.4 = load i32, i32* %i.addr, align 4
  %add.1 = add i32 %i.load.4, 1
  store i32 %add.1, i32* %i.addr, align 4
  br label %if.exit.1

if.false.1:                                       ; preds = %wh.exit.1
  br label %if.exit.1

if.exit.1:                                        ; preds = %if.false.1, %if.true.1
  br label %wh.cond.2

wh.cond.2:                                        ; preds = %wh.body.2, %if.exit.1
  %i.load.5 = load i32, i32* %i.addr, align 4
  %j.load.6 = load i32, i32* %j.addr, align 4
  %slt.4 = icmp slt i32 %i.load.5, %j.load.6
  br i1 %slt.4, label %logic.uncut.1, label %logic.exit.1

wh.body.2:                                        ; preds = %logic.exit.1
  %i.load.7 = load i32, i32* %i.addr, align 4
  %add.2 = add i32 %i.load.7, 1
  store i32 %add.2, i32* %i.addr, align 4
  br label %wh.cond.2

wh.exit.2:                                        ; preds = %logic.exit.1
  %i.load.8 = load i32, i32* %i.addr, align 4
  %j.load.7 = load i32, i32* %j.addr, align 4
  %slt.6 = icmp slt i32 %i.load.8, %j.load.7
  br i1 %slt.6, label %if.true.2, label %if.false.2

logic.uncut.1:                                    ; preds = %wh.cond.2
  %i.load.6 = load i32, i32* %i.addr, align 4
  %e.load.4 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %e.load.4.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.4, i32 %i.load.6
  %e.load.4.elem.load = load %class.Edge*, %class.Edge** %e.load.4.elem.addr, align 8
  %w.addr.2 = getelementptr inbounds %class.Edge, %class.Edge* %e.load.4.elem.load, i32 0, i32 2
  %w.load.2 = load i32, i32* %w.addr.2, align 4
  %x.load.1 = load %class.Edge*, %class.Edge** %x.addr, align 8
  %w.addr.3 = getelementptr inbounds %class.Edge, %class.Edge* %x.load.1, i32 0, i32 2
  %w.load.3 = load i32, i32* %w.addr.3, align 4
  %slt.5 = icmp slt i32 %w.load.2, %w.load.3
  br label %logic.exit.1

logic.exit.1:                                     ; preds = %logic.uncut.1, %wh.cond.2
  %phi.1 = phi i1 [ %slt.4, %wh.cond.2 ], [ %slt.5, %logic.uncut.1 ]
  br i1 %phi.1, label %wh.body.2, label %wh.exit.2

if.true.2:                                        ; preds = %wh.exit.2
  %j.load.8 = load i32, i32* %j.addr, align 4
  %e.load.5 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %e.load.5.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.5, i32 %j.load.8
  %e.load.5.elem.load = load %class.Edge*, %class.Edge** %e.load.5.elem.addr, align 8
  %i.load.9 = load i32, i32* %i.addr, align 4
  %e.load.6 = load %class.Edge**, %class.Edge*** %e.addr, align 8
  %e.load.6.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.6, i32 %i.load.9
  %e.load.6.elem.load = load %class.Edge*, %class.Edge** %e.load.6.elem.addr, align 8
  store %class.Edge* %e.load.6.elem.load, %class.Edge** %e.load.5.elem.addr, align 8
  %j.load.9 = load i32, i32* %j.addr, align 4
  %add.3 = add i32 %j.load.9, -1
  store i32 %add.3, i32* %j.addr, align 4
  br label %if.exit.2

if.false.2:                                       ; preds = %wh.exit.2
  br label %if.exit.2

if.exit.2:                                        ; preds = %if.false.2, %if.true.2
  br label %wh.cond
}

define void @init() {
entry.14:
  %i.addr.1 = alloca i32, align 4
  %fa.load = load i32*, i32** @fa, align 8
  %n.load = load i32, i32* @n, align 4
  %add.5 = add i32 %n.load, 1
  %mul = mul i32 %add.5, 4
  %add.6 = add i32 %mul, 4
  %_bot_malloc.call = call noalias i8* @_bot_malloc(i32 %add.6)
  %bitcast = bitcast i8* %_bot_malloc.call to i32*
  store i32 %add.5, i32* %bitcast, align 4
  %getelementptr = getelementptr inbounds i32, i32* %bitcast, i32 1
  %bitcast.1 = bitcast i32* %getelementptr to i32*
  store i32* %bitcast.1, i32** @fa, align 8
  %rk.load = load i32*, i32** @rk, align 8
  %n.load.1 = load i32, i32* @n, align 4
  %add.7 = add i32 %n.load.1, 1
  %mul.1 = mul i32 %add.7, 4
  %add.8 = add i32 %mul.1, 4
  %_bot_malloc.call.1 = call noalias i8* @_bot_malloc(i32 %add.8)
  %bitcast.2 = bitcast i8* %_bot_malloc.call.1 to i32*
  store i32 %add.7, i32* %bitcast.2, align 4
  %getelementptr.1 = getelementptr inbounds i32, i32* %bitcast.2, i32 1
  %bitcast.3 = bitcast i32* %getelementptr.1 to i32*
  store i32* %bitcast.3, i32** @rk, align 8
  %i.load.13 = load i32, i32* %i.addr.1, align 4
  store i32 1, i32* %i.addr.1, align 4
  br label %for.cond

exit.14:                                          ; preds = %for.exit
  ret void

for.cond:                                         ; preds = %for.incr, %entry.14
  %i.load.14 = load i32, i32* %i.addr.1, align 4
  %n.load.2 = load i32, i32* @n, align 4
  %sle = icmp sle i32 %i.load.14, %n.load.2
  br i1 %sle, label %for.body, label %for.exit

for.incr:                                         ; preds = %for.body
  %i.load.15 = load i32, i32* %i.addr.1, align 4
  %add.9 = add i32 %i.load.15, 1
  store i32 %add.9, i32* %i.addr.1, align 4
  br label %for.cond

for.body:                                         ; preds = %for.cond
  %i.load.16 = load i32, i32* %i.addr.1, align 4
  %fa.load.1 = load i32*, i32** @fa, align 8
  %fa.load.1.elem.addr = getelementptr inbounds i32, i32* %fa.load.1, i32 %i.load.16
  %fa.load.1.elem.load = load i32, i32* %fa.load.1.elem.addr, align 4
  %i.load.17 = load i32, i32* %i.addr.1, align 4
  store i32 %i.load.17, i32* %fa.load.1.elem.addr, align 4
  %i.load.18 = load i32, i32* %i.addr.1, align 4
  %rk.load.1 = load i32*, i32** @rk, align 8
  %rk.load.1.elem.addr = getelementptr inbounds i32, i32* %rk.load.1, i32 %i.load.18
  %rk.load.1.elem.load = load i32, i32* %rk.load.1.elem.addr, align 4
  store i32 1, i32* %rk.load.1.elem.addr, align 4
  br label %for.incr

for.exit:                                         ; preds = %for.cond
  br label %exit.14
}

define i32 @find(i32 %x) {
entry.15:
  %x.addr.1 = alloca i32, align 4
  %internal.ret.addr = alloca i32, align 4
  store i32 %x, i32* %x.addr.1, align 4
  %x.load.3 = load i32, i32* %x.addr.1, align 4
  %x.load.4 = load i32, i32* %x.addr.1, align 4
  %fa.load.2 = load i32*, i32** @fa, align 8
  %fa.load.2.elem.addr = getelementptr inbounds i32, i32* %fa.load.2, i32 %x.load.4
  %fa.load.2.elem.load = load i32, i32* %fa.load.2.elem.addr, align 4
  %eq = icmp eq i32 %x.load.3, %fa.load.2.elem.load
  br i1 %eq, label %if.true.3, label %if.false.3

exit.15:                                          ; preds = %if.exit.3, %if.true.3
  %internal.ret.load = load i32, i32* %internal.ret.addr, align 4
  ret i32 %internal.ret.load

if.true.3:                                        ; preds = %entry.15
  %x.load.5 = load i32, i32* %x.addr.1, align 4
  store i32 %x.load.5, i32* %internal.ret.addr, align 4
  br label %exit.15

if.false.3:                                       ; preds = %entry.15
  br label %if.exit.3

if.exit.3:                                        ; preds = %if.false.3
  %x.load.6 = load i32, i32* %x.addr.1, align 4
  %x.load.7 = load i32, i32* %x.addr.1, align 4
  %fa.load.3 = load i32*, i32** @fa, align 8
  %fa.load.3.elem.addr = getelementptr inbounds i32, i32* %fa.load.3, i32 %x.load.7
  %fa.load.3.elem.load = load i32, i32* %fa.load.3.elem.addr, align 4
  %find.call = call i32 @find(i32 %fa.load.3.elem.load)
  store i32 %find.call, i32* %x.addr.1, align 4
  %x.load.8 = load i32, i32* %x.addr.1, align 4
  %fa.load.4 = load i32*, i32** @fa, align 8
  %fa.load.4.elem.addr = getelementptr inbounds i32, i32* %fa.load.4, i32 %x.load.8
  %fa.load.4.elem.load = load i32, i32* %fa.load.4.elem.addr, align 4
  store i32 %fa.load.4.elem.load, i32* %internal.ret.addr, align 4
  br label %exit.15
}

define i1 @union(i32 %x.1, i32 %y) {
entry.16:
  %y.addr = alloca i32, align 4
  %x.addr.2 = alloca i32, align 4
  %internal.ret.addr.1 = alloca i8, align 1
  store i32 %x.1, i32* %x.addr.2, align 4
  store i32 %y, i32* %y.addr, align 4
  %x.load.9 = load i32, i32* %x.addr.2, align 4
  %x.load.10 = load i32, i32* %x.addr.2, align 4
  %find.call.1 = call i32 @find(i32 %x.load.10)
  store i32 %find.call.1, i32* %x.addr.2, align 4
  %y.load = load i32, i32* %y.addr, align 4
  %y.load.1 = load i32, i32* %y.addr, align 4
  %find.call.2 = call i32 @find(i32 %y.load.1)
  store i32 %find.call.2, i32* %y.addr, align 4
  %x.load.11 = load i32, i32* %x.addr.2, align 4
  %y.load.2 = load i32, i32* %y.addr, align 4
  %eq.1 = icmp eq i32 %x.load.11, %y.load.2
  br i1 %eq.1, label %if.true.4, label %if.false.4

exit.16:                                          ; preds = %if.exit.5, %if.true.4
  %internal.ret.load.1 = load i8, i8* %internal.ret.addr.1, align 1
  %trunc = trunc i8 %internal.ret.load.1 to i1
  ret i1 %trunc

if.true.4:                                        ; preds = %entry.16
  %zext = zext i1 false to i8
  store i8 %zext, i8* %internal.ret.addr.1, align 1
  br label %exit.16

if.false.4:                                       ; preds = %entry.16
  br label %if.exit.4

if.exit.4:                                        ; preds = %if.false.4
  %x.load.12 = load i32, i32* %x.addr.2, align 4
  %rk.load.2 = load i32*, i32** @rk, align 8
  %rk.load.2.elem.addr = getelementptr inbounds i32, i32* %rk.load.2, i32 %x.load.12
  %rk.load.2.elem.load = load i32, i32* %rk.load.2.elem.addr, align 4
  %y.load.3 = load i32, i32* %y.addr, align 4
  %rk.load.3 = load i32*, i32** @rk, align 8
  %rk.load.3.elem.addr = getelementptr inbounds i32, i32* %rk.load.3, i32 %y.load.3
  %rk.load.3.elem.load = load i32, i32* %rk.load.3.elem.addr, align 4
  %sgt = icmp sgt i32 %rk.load.2.elem.load, %rk.load.3.elem.load
  br i1 %sgt, label %if.true.5, label %if.false.5

if.true.5:                                        ; preds = %if.exit.4
  %y.load.7 = load i32, i32* %y.addr, align 4
  %fa.load.6 = load i32*, i32** @fa, align 8
  %fa.load.6.elem.addr = getelementptr inbounds i32, i32* %fa.load.6, i32 %y.load.7
  %fa.load.6.elem.load = load i32, i32* %fa.load.6.elem.addr, align 4
  %x.load.15 = load i32, i32* %x.addr.2, align 4
  store i32 %x.load.15, i32* %fa.load.6.elem.addr, align 4
  %x.load.16 = load i32, i32* %x.addr.2, align 4
  %rk.load.7 = load i32*, i32** @rk, align 8
  %rk.load.7.elem.addr = getelementptr inbounds i32, i32* %rk.load.7, i32 %x.load.16
  %rk.load.7.elem.load = load i32, i32* %rk.load.7.elem.addr, align 4
  %x.load.17 = load i32, i32* %x.addr.2, align 4
  %rk.load.8 = load i32*, i32** @rk, align 8
  %rk.load.8.elem.addr = getelementptr inbounds i32, i32* %rk.load.8, i32 %x.load.17
  %rk.load.8.elem.load = load i32, i32* %rk.load.8.elem.addr, align 4
  %y.load.8 = load i32, i32* %y.addr, align 4
  %rk.load.9 = load i32*, i32** @rk, align 8
  %rk.load.9.elem.addr = getelementptr inbounds i32, i32* %rk.load.9, i32 %y.load.8
  %rk.load.9.elem.load = load i32, i32* %rk.load.9.elem.addr, align 4
  %add.11 = add i32 %rk.load.8.elem.load, %rk.load.9.elem.load
  store i32 %add.11, i32* %rk.load.7.elem.addr, align 4
  br label %if.exit.5

if.false.5:                                       ; preds = %if.exit.4
  %x.load.13 = load i32, i32* %x.addr.2, align 4
  %fa.load.5 = load i32*, i32** @fa, align 8
  %fa.load.5.elem.addr = getelementptr inbounds i32, i32* %fa.load.5, i32 %x.load.13
  %fa.load.5.elem.load = load i32, i32* %fa.load.5.elem.addr, align 4
  %y.load.4 = load i32, i32* %y.addr, align 4
  store i32 %y.load.4, i32* %fa.load.5.elem.addr, align 4
  %y.load.5 = load i32, i32* %y.addr, align 4
  %rk.load.4 = load i32*, i32** @rk, align 8
  %rk.load.4.elem.addr = getelementptr inbounds i32, i32* %rk.load.4, i32 %y.load.5
  %rk.load.4.elem.load = load i32, i32* %rk.load.4.elem.addr, align 4
  %y.load.6 = load i32, i32* %y.addr, align 4
  %rk.load.5 = load i32*, i32** @rk, align 8
  %rk.load.5.elem.addr = getelementptr inbounds i32, i32* %rk.load.5, i32 %y.load.6
  %rk.load.5.elem.load = load i32, i32* %rk.load.5.elem.addr, align 4
  %x.load.14 = load i32, i32* %x.addr.2, align 4
  %rk.load.6 = load i32*, i32** @rk, align 8
  %rk.load.6.elem.addr = getelementptr inbounds i32, i32* %rk.load.6, i32 %x.load.14
  %rk.load.6.elem.load = load i32, i32* %rk.load.6.elem.addr, align 4
  %add.10 = add i32 %rk.load.5.elem.load, %rk.load.6.elem.load
  store i32 %add.10, i32* %rk.load.4.elem.addr, align 4
  br label %if.exit.5

if.exit.5:                                        ; preds = %if.false.5, %if.true.5
  %zext.1 = zext i1 true to i8
  store i8 %zext.1, i8* %internal.ret.addr.1, align 1
  br label %exit.16
}

define i32 @main() {
entry.17:
  %ed.addr.1 = alloca %class.Edge*, align 8
  %j.addr.1 = alloca i32, align 4
  %ed.addr = alloca %class.Edge*, align 8
  %i.addr.2 = alloca i32, align 4
  %internal.ret.addr.2 = alloca i32, align 4
  call void @_global_init()
  store i32 0, i32* %internal.ret.addr.2, align 4
  %n.load.3 = load i32, i32* @n, align 4
  %getInt.call = call i32 @getInt()
  store i32 %getInt.call, i32* @n, align 4
  %m.load = load i32, i32* @m, align 4
  %getInt.call.1 = call i32 @getInt()
  store i32 %getInt.call.1, i32* @m, align 4
  %e.load.10 = load %class.Edge**, %class.Edge*** @e, align 8
  %m.load.1 = load i32, i32* @m, align 4
  %mul.2 = mul i32 %m.load.1, 8
  %add.12 = add i32 %mul.2, 4
  %_bot_malloc.call.2 = call noalias i8* @_bot_malloc(i32 %add.12)
  %bitcast.4 = bitcast i8* %_bot_malloc.call.2 to i32*
  store i32 %m.load.1, i32* %bitcast.4, align 4
  %getelementptr.2 = getelementptr inbounds i32, i32* %bitcast.4, i32 1
  %bitcast.5 = bitcast i32* %getelementptr.2 to %class.Edge**
  store %class.Edge** %bitcast.5, %class.Edge*** @e, align 8
  %i.load.19 = load i32, i32* %i.addr.2, align 4
  store i32 0, i32* %i.addr.2, align 4
  br label %for.cond.1

exit.17:                                          ; preds = %if.exit.8, %if.true.6
  %internal.ret.load.2 = load i32, i32* %internal.ret.addr.2, align 4
  ret i32 %internal.ret.load.2

for.cond.1:                                       ; preds = %for.incr.1, %entry.17
  %i.load.20 = load i32, i32* %i.addr.2, align 4
  %m.load.2 = load i32, i32* @m, align 4
  %slt.7 = icmp slt i32 %i.load.20, %m.load.2
  br i1 %slt.7, label %for.body.1, label %for.exit.1

for.incr.1:                                       ; preds = %for.body.1
  %i.load.21 = load i32, i32* %i.addr.2, align 4
  %add.13 = add i32 %i.load.21, 1
  store i32 %add.13, i32* %i.addr.2, align 4
  br label %for.cond.1

for.body.1:                                       ; preds = %for.cond.1
  %_bot_malloc.call.3 = call noalias i8* @_bot_malloc(i32 12)
  %bitcast.6 = bitcast i8* %_bot_malloc.call.3 to %class.Edge*
  call void @Edge.Edge(%class.Edge* %bitcast.6)
  store %class.Edge* %bitcast.6, %class.Edge** %ed.addr, align 8
  %ed.load = load %class.Edge*, %class.Edge** %ed.addr, align 8
  %x.addr.3 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load, i32 0, i32 0
  %x.load.18 = load i32, i32* %x.addr.3, align 4
  %getInt.call.2 = call i32 @getInt()
  store i32 %getInt.call.2, i32* %x.addr.3, align 4
  %ed.load.1 = load %class.Edge*, %class.Edge** %ed.addr, align 8
  %y.addr.1 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load.1, i32 0, i32 1
  %y.load.9 = load i32, i32* %y.addr.1, align 4
  %getInt.call.3 = call i32 @getInt()
  store i32 %getInt.call.3, i32* %y.addr.1, align 4
  %ed.load.2 = load %class.Edge*, %class.Edge** %ed.addr, align 8
  %w.addr.4 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load.2, i32 0, i32 2
  %w.load.4 = load i32, i32* %w.addr.4, align 4
  %getInt.call.4 = call i32 @getInt()
  store i32 %getInt.call.4, i32* %w.addr.4, align 4
  %i.load.22 = load i32, i32* %i.addr.2, align 4
  %e.load.11 = load %class.Edge**, %class.Edge*** @e, align 8
  %e.load.11.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.11, i32 %i.load.22
  %e.load.11.elem.load = load %class.Edge*, %class.Edge** %e.load.11.elem.addr, align 8
  %ed.load.3 = load %class.Edge*, %class.Edge** %ed.addr, align 8
  store %class.Edge* %ed.load.3, %class.Edge** %e.load.11.elem.addr, align 8
  br label %for.incr.1

for.exit.1:                                       ; preds = %for.cond.1
  %e.load.12 = load %class.Edge**, %class.Edge*** @e, align 8
  %m.load.3 = load i32, i32* @m, align 4
  %sub.1 = sub i32 %m.load.3, 1
  call void @qsort(%class.Edge** %e.load.12, i32 0, i32 %sub.1)
  call void @init()
  %i.load.23 = load i32, i32* %i.addr.2, align 4
  store i32 0, i32* %i.addr.2, align 4
  store i32 0, i32* %j.addr.1, align 4
  br label %wh.cond.3

wh.cond.3:                                        ; preds = %if.exit.7, %for.exit.1
  %i.load.24 = load i32, i32* %i.addr.2, align 4
  %n.load.4 = load i32, i32* @n, align 4
  %sub.2 = sub i32 %n.load.4, 1
  %slt.8 = icmp slt i32 %i.load.24, %sub.2
  br i1 %slt.8, label %wh.body.3, label %wh.exit.3

wh.body.3:                                        ; preds = %wh.cond.3
  %j.load.10 = load i32, i32* %j.addr.1, align 4
  %m.load.4 = load i32, i32* @m, align 4
  %sge.1 = icmp sge i32 %j.load.10, %m.load.4
  br i1 %sge.1, label %if.true.6, label %if.false.6

wh.exit.3:                                        ; preds = %wh.cond.3
  %find.call.3 = call i32 @find(i32 1)
  %rk.load.10 = load i32*, i32** @rk, align 8
  %rk.load.10.elem.addr = getelementptr inbounds i32, i32* %rk.load.10, i32 %find.call.3
  %rk.load.10.elem.load = load i32, i32* %rk.load.10.elem.addr, align 4
  %n.load.5 = load i32, i32* @n, align 4
  %eq.2 = icmp eq i32 %rk.load.10.elem.load, %n.load.5
  br i1 %eq.2, label %if.true.8, label %if.false.8

if.true.6:                                        ; preds = %wh.body.3
  %sub.3 = sub i32 0, 1
  call void @printInt(i32 %sub.3)
  store i32 0, i32* %internal.ret.addr.2, align 4
  br label %exit.17

if.false.6:                                       ; preds = %wh.body.3
  br label %if.exit.6

if.exit.6:                                        ; preds = %if.false.6
  %j.load.11 = load i32, i32* %j.addr.1, align 4
  %e.load.13 = load %class.Edge**, %class.Edge*** @e, align 8
  %e.load.13.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %e.load.13, i32 %j.load.11
  %e.load.13.elem.load = load %class.Edge*, %class.Edge** %e.load.13.elem.addr, align 8
  store %class.Edge* %e.load.13.elem.load, %class.Edge** %ed.addr.1, align 8
  %j.load.12 = load i32, i32* %j.addr.1, align 4
  %add.14 = add i32 %j.load.12, 1
  store i32 %add.14, i32* %j.addr.1, align 4
  %ed.load.4 = load %class.Edge*, %class.Edge** %ed.addr.1, align 8
  %x.addr.4 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load.4, i32 0, i32 0
  %x.load.19 = load i32, i32* %x.addr.4, align 4
  %ed.load.5 = load %class.Edge*, %class.Edge** %ed.addr.1, align 8
  %y.addr.2 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load.5, i32 0, i32 1
  %y.load.10 = load i32, i32* %y.addr.2, align 4
  %union.call = call i1 @union(i32 %x.load.19, i32 %y.load.10)
  br i1 %union.call, label %if.true.7, label %if.false.7

if.true.7:                                        ; preds = %if.exit.6
  %i.load.25 = load i32, i32* %i.addr.2, align 4
  %add.15 = add i32 %i.load.25, 1
  store i32 %add.15, i32* %i.addr.2, align 4
  %ans.load = load i32, i32* @ans, align 4
  %ans.load.1 = load i32, i32* @ans, align 4
  %ed.load.6 = load %class.Edge*, %class.Edge** %ed.addr.1, align 8
  %w.addr.5 = getelementptr inbounds %class.Edge, %class.Edge* %ed.load.6, i32 0, i32 2
  %w.load.5 = load i32, i32* %w.addr.5, align 4
  %add.16 = add i32 %ans.load.1, %w.load.5
  store i32 %add.16, i32* @ans, align 4
  br label %if.exit.7

if.false.7:                                       ; preds = %if.exit.6
  br label %if.exit.7

if.exit.7:                                        ; preds = %if.false.7, %if.true.7
  br label %wh.cond.3

if.true.8:                                        ; preds = %wh.exit.3
  %ans.load.2 = load i32, i32* @ans, align 4
  call void @printInt(i32 %ans.load.2)
  br label %if.exit.8

if.false.8:                                       ; preds = %wh.exit.3
  %sub.4 = sub i32 0, 1
  call void @printInt(i32 %sub.4)
  br label %if.exit.8

if.exit.8:                                        ; preds = %if.false.8, %if.true.8
  store i32 0, i32* %internal.ret.addr.2, align 4
  br label %exit.17
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @print(i8* %0) #0 {
  %2 = alloca i8*, align 8
  store i8* %0, i8** %2, align 8
  %3 = load i8*, i8** %2, align 8
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i8* %3)
  ret void
}

declare dso_local i32 @printf(i8*, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @println(i8* %0) #0 {
  %2 = alloca i8*, align 8
  store i8* %0, i8** %2, align 8
  %3 = load i8*, i8** %2, align 8
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.1, i64 0, i64 0), i8* %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @printInt(i32 %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, i32* %2, align 4
  %3 = load i32, i32* %2, align 4
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32 %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local void @printlnInt(i32 %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, i32* %2, align 4
  %3 = load i32, i32* %2, align 4
  %4 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str.3, i64 0, i64 0), i32 %3)
  ret void
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @getString() #0 {
  %1 = alloca i8*, align 8
  %2 = call noalias i8* @malloc(i64 256) #4
  store i8* %2, i8** %1, align 8
  %3 = load i8*, i8** %1, align 8
  %4 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str, i64 0, i64 0), i8* %3)
  %5 = load i8*, i8** %1, align 8
  ret i8* %5
}

; Function Attrs: nounwind
declare dso_local noalias i8* @malloc(i64) #2

declare dso_local i32 @__isoc99_scanf(i8*, ...) #1

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @getInt() #0 {
  %1 = alloca i32, align 4
  %2 = call i32 (i8*, ...) @__isoc99_scanf(i8* getelementptr inbounds ([3 x i8], [3 x i8]* @.str.2, i64 0, i64 0), i32* %1)
  %3 = load i32, i32* %1, align 4
  ret i32 %3
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @toString(i32 %0) #0 {
  %2 = alloca i8*, align 8
  %3 = alloca i32, align 4
  %4 = alloca i8*, align 8
  %5 = alloca [10 x i8], align 1
  %6 = alloca i8, align 1
  %7 = alloca i8, align 1
  %8 = alloca i8*, align 8
  %9 = alloca i8, align 1
  store i32 %0, i32* %3, align 4
  %10 = load i32, i32* %3, align 4
  %11 = icmp eq i32 %10, 0
  br i1 %11, label %12, label %19

12:                                               ; preds = %1
  %13 = call noalias i8* @malloc(i64 2) #4
  store i8* %13, i8** %4, align 8
  %14 = load i8*, i8** %4, align 8
  %15 = getelementptr inbounds i8, i8* %14, i64 0
  store i8 48, i8* %15, align 1
  %16 = load i8*, i8** %4, align 8
  %17 = getelementptr inbounds i8, i8* %16, i64 1
  store i8 0, i8* %17, align 1
  %18 = load i8*, i8** %4, align 8
  store i8* %18, i8** %2, align 8
  br label %96

19:                                               ; preds = %1
  store i8 0, i8* %7, align 1
  %20 = load i32, i32* %3, align 4
  %21 = icmp sgt i32 %20, 0
  br i1 %21, label %22, label %23

22:                                               ; preds = %19
  store i8 0, i8* %6, align 1
  br label %26

23:                                               ; preds = %19
  store i8 1, i8* %6, align 1
  %24 = load i32, i32* %3, align 4
  %25 = sub nsw i32 0, %24
  store i32 %25, i32* %3, align 4
  br label %26

26:                                               ; preds = %23, %22
  br label %27

27:                                               ; preds = %30, %26
  %28 = load i32, i32* %3, align 4
  %29 = icmp sgt i32 %28, 0
  br i1 %29, label %30, label %40

30:                                               ; preds = %27
  %31 = load i32, i32* %3, align 4
  %32 = srem i32 %31, 10
  %33 = trunc i32 %32 to i8
  %34 = load i8, i8* %7, align 1
  %35 = add i8 %34, 1
  store i8 %35, i8* %7, align 1
  %36 = sext i8 %34 to i64
  %37 = getelementptr inbounds [10 x i8], [10 x i8]* %5, i64 0, i64 %36
  store i8 %33, i8* %37, align 1
  %38 = load i32, i32* %3, align 4
  %39 = sdiv i32 %38, 10
  store i32 %39, i32* %3, align 4
  br label %27

40:                                               ; preds = %27
  %41 = load i8, i8* %6, align 1
  %42 = sext i8 %41 to i32
  %43 = load i8, i8* %7, align 1
  %44 = sext i8 %43 to i32
  %45 = add nsw i32 %42, %44
  %46 = add nsw i32 %45, 1
  %47 = sext i32 %46 to i64
  %48 = mul i64 1, %47
  %49 = call noalias i8* @malloc(i64 %48) #4
  store i8* %49, i8** %8, align 8
  %50 = load i8, i8* %6, align 1
  %51 = sext i8 %50 to i32
  %52 = icmp sgt i32 %51, 0
  br i1 %52, label %53, label %56

53:                                               ; preds = %40
  %54 = load i8*, i8** %8, align 8
  %55 = getelementptr inbounds i8, i8* %54, i64 0
  store i8 45, i8* %55, align 1
  br label %56

56:                                               ; preds = %53, %40
  store i8 0, i8* %9, align 1
  br label %57

57:                                               ; preds = %63, %56
  %58 = load i8, i8* %9, align 1
  %59 = sext i8 %58 to i32
  %60 = load i8, i8* %7, align 1
  %61 = sext i8 %60 to i32
  %62 = icmp slt i32 %59, %61
  br i1 %62, label %63, label %86

63:                                               ; preds = %57
  %64 = load i8, i8* %7, align 1
  %65 = sext i8 %64 to i32
  %66 = load i8, i8* %9, align 1
  %67 = sext i8 %66 to i32
  %68 = sub nsw i32 %65, %67
  %69 = sub nsw i32 %68, 1
  %70 = sext i32 %69 to i64
  %71 = getelementptr inbounds [10 x i8], [10 x i8]* %5, i64 0, i64 %70
  %72 = load i8, i8* %71, align 1
  %73 = sext i8 %72 to i32
  %74 = add nsw i32 %73, 48
  %75 = trunc i32 %74 to i8
  %76 = load i8*, i8** %8, align 8
  %77 = load i8, i8* %9, align 1
  %78 = sext i8 %77 to i32
  %79 = load i8, i8* %6, align 1
  %80 = sext i8 %79 to i32
  %81 = add nsw i32 %78, %80
  %82 = sext i32 %81 to i64
  %83 = getelementptr inbounds i8, i8* %76, i64 %82
  store i8 %75, i8* %83, align 1
  %84 = load i8, i8* %9, align 1
  %85 = add i8 %84, 1
  store i8 %85, i8* %9, align 1
  br label %57

86:                                               ; preds = %57
  %87 = load i8*, i8** %8, align 8
  %88 = load i8, i8* %7, align 1
  %89 = sext i8 %88 to i32
  %90 = load i8, i8* %6, align 1
  %91 = sext i8 %90 to i32
  %92 = add nsw i32 %89, %91
  %93 = sext i32 %92 to i64
  %94 = getelementptr inbounds i8, i8* %87, i64 %93
  store i8 0, i8* %94, align 1
  %95 = load i8*, i8** %8, align 8
  store i8* %95, i8** %2, align 8
  br label %96

96:                                               ; preds = %86, %12
  %97 = load i8*, i8** %2, align 8
  ret i8* %97
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_bot_malloc(i32 %0) #0 {
  %2 = alloca i32, align 4
  store i32 %0, i32* %2, align 4
  %3 = load i32, i32* %2, align 4
  %4 = sext i32 %3 to i64
  %5 = call noalias i8* @malloc(i64 %4) #4
  ret i8* %5
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_bot_str_cat(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  %5 = alloca i32, align 4
  %6 = alloca i32, align 4
  %7 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %8 = load i8*, i8** %3, align 8
  %9 = call i64 @strlen(i8* %8) #5
  %10 = trunc i64 %9 to i32
  store i32 %10, i32* %5, align 4
  %11 = load i8*, i8** %4, align 8
  %12 = call i64 @strlen(i8* %11) #5
  %13 = trunc i64 %12 to i32
  store i32 %13, i32* %6, align 4
  %14 = load i32, i32* %5, align 4
  %15 = load i32, i32* %6, align 4
  %16 = add nsw i32 %14, %15
  %17 = add nsw i32 %16, 1
  %18 = sext i32 %17 to i64
  %19 = mul i64 1, %18
  %20 = call noalias i8* @malloc(i64 %19) #4
  store i8* %20, i8** %7, align 8
  %21 = load i8*, i8** %7, align 8
  %22 = load i8*, i8** %3, align 8
  %23 = call i8* @strcat(i8* %21, i8* %22) #4
  %24 = load i8*, i8** %7, align 8
  %25 = load i8*, i8** %4, align 8
  %26 = call i8* @strcat(i8* %24, i8* %25) #4
  %27 = load i8*, i8** %7, align 8
  ret i8* %27
}

; Function Attrs: nounwind readonly
declare dso_local i64 @strlen(i8*) #3

; Function Attrs: nounwind
declare dso_local i8* @strcat(i8*, i8*) #2

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_bot_str_eq(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #5
  %8 = icmp eq i32 %7, 0
  %9 = zext i1 %8 to i32
  %10 = trunc i32 %9 to i8
  ret i8 %10
}

; Function Attrs: nounwind readonly
declare dso_local i32 @strcmp(i8*, i8*) #3

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_bot_str_neq(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #5
  %8 = icmp ne i32 %7, 0
  %9 = zext i1 %8 to i32
  %10 = trunc i32 %9 to i8
  ret i8 %10
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_bot_str_slt(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #5
  %8 = icmp slt i32 %7, 0
  %9 = zext i1 %8 to i32
  %10 = trunc i32 %9 to i8
  ret i8 %10
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_bot_str_sgt(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #5
  %8 = icmp sgt i32 %7, 0
  %9 = zext i1 %8 to i32
  %10 = trunc i32 %9 to i8
  ret i8 %10
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_bot_str_sle(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #5
  %8 = icmp sle i32 %7, 0
  %9 = zext i1 %8 to i32
  %10 = trunc i32 %9 to i8
  ret i8 %10
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local signext i8 @_bot_str_sge(i8* %0, i8* %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i8*, align 8
  store i8* %0, i8** %3, align 8
  store i8* %1, i8** %4, align 8
  %5 = load i8*, i8** %3, align 8
  %6 = load i8*, i8** %4, align 8
  %7 = call i32 @strcmp(i8* %5, i8* %6) #5
  %8 = icmp sge i32 %7, 0
  %9 = zext i1 %8 to i32
  %10 = trunc i32 %9 to i8
  ret i8 %10
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_str_length(i8* %0) #0 {
  %2 = alloca i8*, align 8
  store i8* %0, i8** %2, align 8
  %3 = load i8*, i8** %2, align 8
  %4 = call i64 @strlen(i8* %3) #5
  %5 = trunc i64 %4 to i32
  ret i32 %5
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i8* @_str_substring(i8* %0, i32 %1, i32 %2) #0 {
  %4 = alloca i8*, align 8
  %5 = alloca i32, align 4
  %6 = alloca i32, align 4
  %7 = alloca i32, align 4
  %8 = alloca i8*, align 8
  %9 = alloca i32, align 4
  store i8* %0, i8** %4, align 8
  store i32 %1, i32* %5, align 4
  store i32 %2, i32* %6, align 4
  %10 = load i32, i32* %6, align 4
  %11 = load i32, i32* %5, align 4
  %12 = sub nsw i32 %10, %11
  store i32 %12, i32* %7, align 4
  %13 = load i32, i32* %7, align 4
  %14 = add nsw i32 %13, 1
  %15 = sext i32 %14 to i64
  %16 = mul i64 1, %15
  %17 = call noalias i8* @malloc(i64 %16) #4
  store i8* %17, i8** %8, align 8
  store i32 0, i32* %9, align 4
  br label %18

18:                                               ; preds = %22, %3
  %19 = load i32, i32* %9, align 4
  %20 = load i32, i32* %7, align 4
  %21 = icmp slt i32 %19, %20
  br i1 %21, label %22, label %36

22:                                               ; preds = %18
  %23 = load i8*, i8** %4, align 8
  %24 = load i32, i32* %5, align 4
  %25 = load i32, i32* %9, align 4
  %26 = add nsw i32 %24, %25
  %27 = sext i32 %26 to i64
  %28 = getelementptr inbounds i8, i8* %23, i64 %27
  %29 = load i8, i8* %28, align 1
  %30 = load i8*, i8** %8, align 8
  %31 = load i32, i32* %9, align 4
  %32 = sext i32 %31 to i64
  %33 = getelementptr inbounds i8, i8* %30, i64 %32
  store i8 %29, i8* %33, align 1
  %34 = load i32, i32* %9, align 4
  %35 = add nsw i32 %34, 1
  store i32 %35, i32* %9, align 4
  br label %18

36:                                               ; preds = %18
  %37 = load i8*, i8** %8, align 8
  %38 = load i32, i32* %7, align 4
  %39 = sext i32 %38 to i64
  %40 = getelementptr inbounds i8, i8* %37, i64 %39
  store i8 0, i8* %40, align 1
  %41 = load i8*, i8** %8, align 8
  ret i8* %41
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_str_parseInt(i8* %0) #0 {
  %2 = alloca i8*, align 8
  %3 = alloca i32, align 4
  %4 = alloca i32, align 4
  store i8* %0, i8** %2, align 8
  store i32 0, i32* %3, align 4
  store i32 0, i32* %4, align 4
  br label %5

5:                                                ; preds = %31, %1
  %6 = load i8*, i8** %2, align 8
  %7 = load i32, i32* %4, align 4
  %8 = sext i32 %7 to i64
  %9 = getelementptr inbounds i8, i8* %6, i64 %8
  %10 = load i8, i8* %9, align 1
  %11 = sext i8 %10 to i32
  %12 = icmp ne i32 %11, 0
  br i1 %12, label %13, label %29

13:                                               ; preds = %5
  %14 = load i8*, i8** %2, align 8
  %15 = load i32, i32* %4, align 4
  %16 = sext i32 %15 to i64
  %17 = getelementptr inbounds i8, i8* %14, i64 %16
  %18 = load i8, i8* %17, align 1
  %19 = sext i8 %18 to i32
  %20 = icmp sge i32 %19, 48
  br i1 %20, label %21, label %29

21:                                               ; preds = %13
  %22 = load i8*, i8** %2, align 8
  %23 = load i32, i32* %4, align 4
  %24 = sext i32 %23 to i64
  %25 = getelementptr inbounds i8, i8* %22, i64 %24
  %26 = load i8, i8* %25, align 1
  %27 = sext i8 %26 to i32
  %28 = icmp sle i32 %27, 57
  br label %29

29:                                               ; preds = %21, %13, %5
  %30 = phi i1 [ false, %13 ], [ false, %5 ], [ %28, %21 ]
  br i1 %30, label %31, label %43

31:                                               ; preds = %29
  %32 = load i32, i32* %3, align 4
  %33 = mul nsw i32 %32, 10
  %34 = load i8*, i8** %2, align 8
  %35 = load i32, i32* %4, align 4
  %36 = add nsw i32 %35, 1
  store i32 %36, i32* %4, align 4
  %37 = sext i32 %35 to i64
  %38 = getelementptr inbounds i8, i8* %34, i64 %37
  %39 = load i8, i8* %38, align 1
  %40 = sext i8 %39 to i32
  %41 = add nsw i32 %33, %40
  %42 = sub nsw i32 %41, 48
  store i32 %42, i32* %3, align 4
  br label %5

43:                                               ; preds = %29
  %44 = load i32, i32* %3, align 4
  ret i32 %44
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_str_ord(i8* %0, i32 %1) #0 {
  %3 = alloca i8*, align 8
  %4 = alloca i32, align 4
  store i8* %0, i8** %3, align 8
  store i32 %1, i32* %4, align 4
  %5 = load i8*, i8** %3, align 8
  %6 = load i32, i32* %4, align 4
  %7 = sext i32 %6 to i64
  %8 = getelementptr inbounds i8, i8* %5, i64 %7
  %9 = load i8, i8* %8, align 1
  %10 = sext i8 %9 to i32
  ret i32 %10
}

; Function Attrs: noinline nounwind optnone uwtable
define dso_local i32 @_array_size(i8* %0) #0 {
  %2 = alloca i8*, align 8
  store i8* %0, i8** %2, align 8
  %3 = load i8*, i8** %2, align 8
  %4 = bitcast i8* %3 to i32*
  %5 = getelementptr inbounds i32, i32* %4, i64 -1
  %6 = load i32, i32* %5, align 4
  ret i32 %6
}

attributes #0 = { noinline nounwind optnone uwtable "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "min-legal-vector-width"="0" "no-infs-fp-math"="false" "no-jump-tables"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #1 = { "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #2 = { nounwind "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #3 = { nounwind readonly "correctly-rounded-divide-sqrt-fp-math"="false" "disable-tail-calls"="false" "frame-pointer"="all" "less-precise-fpmad"="false" "no-infs-fp-math"="false" "no-nans-fp-math"="false" "no-signed-zeros-fp-math"="false" "no-trapping-math"="false" "stack-protector-buffer-size"="8" "target-cpu"="x86-64" "target-features"="+cx8,+fxsr,+mmx,+sse,+sse2,+x87" "unsafe-fp-math"="false" "use-soft-float"="false" }
attributes #4 = { nounwind }
attributes #5 = { nounwind readonly }

!llvm.ident = !{!0}
!llvm.module.flags = !{!1}

!0 = !{!"clang version 10.0.0-4ubuntu1 "}
!1 = !{i32 1, !"wchar_size", i32 4}
