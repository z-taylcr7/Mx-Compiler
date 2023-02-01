; Module = 'test.mx'
;src_file_name = "test.mx"
declare i8* @_bot_malloc(i32)
declare i8* @_bot_str_cat(i8*, i8*)
declare i1 @_bot_str_eq(i8*, i8*)
declare i1 @_bot_str_ne(i8*, i8*)
declare i1 @_bot_str_slt(i8*, i8*)
declare i1 @_bot_str_sle(i8*, i8*)
declare i1 @_bot_str_sgt(i8*, i8*)
declare i1 @_bot_str_sge(i8*, i8*)
declare void @print(i8*)
declare void @println(i8*)
declare void @printInt(i32)
declare void @printlnInt(i32)
declare i8* @getString()
declare i32 @getInt()
declare i8* @toString(i32)
declare i32 @_str_length(i8*)
declare i8* @_str_substring(i8*, i32, i32)
declare i32 @_str_parseInt(i8*)
declare i32 @_str_ord(i8*, i32)

define void @_glb_init()
{

entry.11:                       ;prevs = 
 br label %exit.11

exit.11:                       ;prevs = 
 ret void

}

define i32 @loop()
{

entry.12:                       ;prevs = 
 %sum.addr = alloca  i32, align 4
 %l.addr = alloca  i32, align 4
 %k.addr = alloca  i32, align 4
 %j.addr = alloca  i32, align 4
 %i.addr = alloca  i32, align 4
 %a.addr = alloca  i32*, align 8
 %internal.ret.addr = alloca  i32, align 4
 %mul = mul i32 10000 , 4
 %add = add i32 %mul , 4
 %_bot_malloc.call = call noalias i8* @_bot_malloc(i32 %add)
 %bitcast = bitcast i8* %_bot_malloc.call to i32*
 store i32 10000,i32* %bitcast, align 4
 %getelementptr = getelementptr inbounds i32, i32* %bitcast, i32 1
 %bitcast.1 = bitcast i32* %getelementptr to i32*
 store i32* %bitcast.1,i32** %a.addr, align 8
 %i.load = load i32, i32* %i.addr, align 4
 store i32 0,i32* %i.addr, align 4
 br label %for.cond

exit.12:                       ;prevs = 
 %internal.ret.load = load i32, i32* %internal.ret.addr, align 4
 ret i32 %internal.ret.load

for.cond:                       ;prevs = 
 %i.load.1 = load i32, i32* %i.addr, align 4
 %slt = icmp slt i32 %i.load.1 , 10
 br i1 %slt , label %for.body , label %for.exit

for.incr:                       ;prevs = 
 %i.load.2 = load i32, i32* %i.addr, align 4
 %add.1 = add i32 %i.load.2 , 1
 store i32 %add.1,i32* %i.addr, align 4
 br label %for.cond

for.body:                       ;prevs = 
 %j.load = load i32, i32* %j.addr, align 4
 store i32 0,i32* %j.addr, align 4
 br label %for.cond.1

for.exit:                       ;prevs = 
 store i32 0,i32* %sum.addr, align 4
 %i.load.7 = load i32, i32* %i.addr, align 4
 store i32 0,i32* %i.addr, align 4
 br label %for.cond.4

for.cond.1:                       ;prevs = 
 %j.load.1 = load i32, i32* %j.addr, align 4
 %slt.1 = icmp slt i32 %j.load.1 , 10
 br i1 %slt.1 , label %for.body.1 , label %for.exit.1

for.incr.1:                       ;prevs = 
 %j.load.2 = load i32, i32* %j.addr, align 4
 %add.2 = add i32 %j.load.2 , 1
 store i32 %add.2,i32* %j.addr, align 4
 br label %for.cond.1

for.body.1:                       ;prevs = 
 %k.load = load i32, i32* %k.addr, align 4
 store i32 0,i32* %k.addr, align 4
 br label %for.cond.2

for.exit.1:                       ;prevs = 
 br label %for.incr

for.cond.2:                       ;prevs = 
 %k.load.1 = load i32, i32* %k.addr, align 4
 %slt.2 = icmp slt i32 %k.load.1 , 10
 br i1 %slt.2 , label %for.body.2 , label %for.exit.2

for.incr.2:                       ;prevs = 
 %k.load.2 = load i32, i32* %k.addr, align 4
 %add.3 = add i32 %k.load.2 , 1
 store i32 %add.3,i32* %k.addr, align 4
 br label %for.cond.2

for.body.2:                       ;prevs = 
 %l.load = load i32, i32* %l.addr, align 4
 store i32 0,i32* %l.addr, align 4
 br label %for.cond.3

for.exit.2:                       ;prevs = 
 br label %for.incr.1

for.cond.3:                       ;prevs = 
 %l.load.1 = load i32, i32* %l.addr, align 4
 %slt.3 = icmp slt i32 %l.load.1 , 10
 br i1 %slt.3 , label %for.body.3 , label %for.exit.3

for.incr.3:                       ;prevs = 
 %l.load.2 = load i32, i32* %l.addr, align 4
 %add.4 = add i32 %l.load.2 , 1
 store i32 %add.4,i32* %l.addr, align 4
 br label %for.cond.3

for.body.3:                       ;prevs = 
 %i.load.3 = load i32, i32* %i.addr, align 4
 %mul.1 = mul i32 %i.load.3 , 1000
 %j.load.3 = load i32, i32* %j.addr, align 4
 %mul.2 = mul i32 %j.load.3 , 100
 %add.5 = add i32 %mul.1 , %mul.2
 %k.load.3 = load i32, i32* %k.addr, align 4
 %mul.3 = mul i32 %k.load.3 , 10
 %add.6 = add i32 %add.5 , %mul.3
 %l.load.3 = load i32, i32* %l.addr, align 4
 %add.7 = add i32 %add.6 , %l.load.3
 %a.load = load i32*, i32** %a.addr, align 8
 %a.load.elem.addr = getelementptr inbounds i32, i32* %a.load, i32 %add.7
 %a.load.elem.load = load i32, i32* %a.load.elem.addr, align 4
 %i.load.4 = load i32, i32* %i.addr, align 4
 %l.load.4 = load i32, i32* %l.addr, align 4
 %add.8 = add i32 %i.load.4 , %l.load.4
 store i32 %add.8,i32* %a.load.elem.addr, align 4
 %i.load.5 = load i32, i32* %i.addr, align 4
 %mul.4 = mul i32 %i.load.5 , 10
 %j.load.4 = load i32, i32* %j.addr, align 4
 %mul.5 = mul i32 %j.load.4 , 5
 %add.9 = add i32 %mul.4 , %mul.5
 %a.load.1 = load i32*, i32** %a.addr, align 8
 %a.load.1.elem.addr = getelementptr inbounds i32, i32* %a.load.1, i32 %add.9
 %a.load.1.elem.load = load i32, i32* %a.load.1.elem.addr, align 4
 %i.load.6 = load i32, i32* %i.addr, align 4
 %mul.6 = mul i32 %i.load.6 , 10
 %j.load.5 = load i32, i32* %j.addr, align 4
 %mul.7 = mul i32 %j.load.5 , 5
 %add.10 = add i32 %mul.6 , %mul.7
 %a.load.2 = load i32*, i32** %a.addr, align 8
 %a.load.2.elem.addr = getelementptr inbounds i32, i32* %a.load.2, i32 %add.10
 %a.load.2.elem.load = load i32, i32* %a.load.2.elem.addr, align 4
 store i32 %a.load.2.elem.load,i32* %a.load.1.elem.addr, align 4
 br label %for.incr.3

for.exit.3:                       ;prevs = 
 br label %for.incr.2

for.cond.4:                       ;prevs = 
 %i.load.8 = load i32, i32* %i.addr, align 4
 %slt.4 = icmp slt i32 %i.load.8 , 10
 br i1 %slt.4 , label %for.body.4 , label %for.exit.4

for.incr.4:                       ;prevs = 
 %i.load.9 = load i32, i32* %i.addr, align 4
 %add.11 = add i32 %i.load.9 , 1
 store i32 %add.11,i32* %i.addr, align 4
 br label %for.cond.4

for.body.4:                       ;prevs = 
 %j.load.6 = load i32, i32* %j.addr, align 4
 store i32 0,i32* %j.addr, align 4
 br label %for.cond.5

for.exit.4:                       ;prevs = 
 %sum.load.4 = load i32, i32* %sum.addr, align 4
 store i32 %sum.load.4,i32* %internal.ret.addr, align 4
 br label %exit.12

for.cond.5:                       ;prevs = 
 %j.load.7 = load i32, i32* %j.addr, align 4
 %slt.5 = icmp slt i32 %j.load.7 , 10
 br i1 %slt.5 , label %for.body.5 , label %for.exit.5

for.incr.5:                       ;prevs = 
 %j.load.8 = load i32, i32* %j.addr, align 4
 %add.12 = add i32 %j.load.8 , 1
 store i32 %add.12,i32* %j.addr, align 4
 br label %for.cond.5

for.body.5:                       ;prevs = 
 %k.load.4 = load i32, i32* %k.addr, align 4
 store i32 0,i32* %k.addr, align 4
 br label %for.cond.6

for.exit.5:                       ;prevs = 
 br label %for.incr.4

for.cond.6:                       ;prevs = 
 %k.load.5 = load i32, i32* %k.addr, align 4
 %slt.6 = icmp slt i32 %k.load.5 , 10
 br i1 %slt.6 , label %for.body.6 , label %for.exit.6

for.incr.6:                       ;prevs = 
 %k.load.6 = load i32, i32* %k.addr, align 4
 %add.13 = add i32 %k.load.6 , 1
 store i32 %add.13,i32* %k.addr, align 4
 br label %for.cond.6

for.body.6:                       ;prevs = 
 %l.load.5 = load i32, i32* %l.addr, align 4
 store i32 0,i32* %l.addr, align 4
 br label %for.cond.7

for.exit.6:                       ;prevs = 
 br label %for.incr.5

for.cond.7:                       ;prevs = 
 %l.load.6 = load i32, i32* %l.addr, align 4
 %slt.7 = icmp slt i32 %l.load.6 , 10
 br i1 %slt.7 , label %for.body.7 , label %for.exit.7

for.incr.7:                       ;prevs = 
 %l.load.7 = load i32, i32* %l.addr, align 4
 %add.14 = add i32 %l.load.7 , 1
 store i32 %add.14,i32* %l.addr, align 4
 br label %for.cond.7

for.body.7:                       ;prevs = 
 %l.load.8 = load i32, i32* %l.addr, align 4
 %and = and i32 %l.load.8 , 1
 %eq = icmp eq i32 %and , 1
 br i1 %eq , label %if.true , label %if.false

for.exit.7:                       ;prevs = 
 br label %for.incr.6

if.true:                       ;prevs = 
 %sum.load.2 = load i32, i32* %sum.addr, align 4
 %sum.load.3 = load i32, i32* %sum.addr, align 4
 %i.load.11 = load i32, i32* %i.addr, align 4
 %mul.11 = mul i32 %i.load.11 , 1000
 %j.load.10 = load i32, i32* %j.addr, align 4
 %mul.12 = mul i32 %j.load.10 , 100
 %add.18 = add i32 %mul.11 , %mul.12
 %k.load.8 = load i32, i32* %k.addr, align 4
 %mul.13 = mul i32 %k.load.8 , 10
 %add.19 = add i32 %add.18 , %mul.13
 %l.load.10 = load i32, i32* %l.addr, align 4
 %add.20 = add i32 %add.19 , %l.load.10
 %a.load.4 = load i32*, i32** %a.addr, align 8
 %a.load.4.elem.addr = getelementptr inbounds i32, i32* %a.load.4, i32 %add.20
 %a.load.4.elem.load = load i32, i32* %a.load.4.elem.addr, align 4
 %add.21 = add i32 %sum.load.3 , %a.load.4.elem.load
 store i32 %add.21,i32* %sum.addr, align 4
 br label %if.exit

if.false:                       ;prevs = 
 %sum.load = load i32, i32* %sum.addr, align 4
 %sum.load.1 = load i32, i32* %sum.addr, align 4
 %i.load.10 = load i32, i32* %i.addr, align 4
 %mul.8 = mul i32 %i.load.10 , 1000
 %j.load.9 = load i32, i32* %j.addr, align 4
 %mul.9 = mul i32 %j.load.9 , 100
 %add.15 = add i32 %mul.8 , %mul.9
 %k.load.7 = load i32, i32* %k.addr, align 4
 %mul.10 = mul i32 %k.load.7 , 10
 %add.16 = add i32 %add.15 , %mul.10
 %l.load.9 = load i32, i32* %l.addr, align 4
 %add.17 = add i32 %add.16 , %l.load.9
 %a.load.3 = load i32*, i32** %a.addr, align 8
 %a.load.3.elem.addr = getelementptr inbounds i32, i32* %a.load.3, i32 %add.17
 %a.load.3.elem.load = load i32, i32* %a.load.3.elem.addr, align 4
 %sub = sub i32 %sum.load.1 , %a.load.3.elem.load
 store i32 %sub,i32* %sum.addr, align 4
 br label %if.exit

if.exit:                       ;prevs = 
 br label %for.incr.7

}

define i32 @compute(i32 %num)
{

entry.13:                       ;prevs = 
 %a.addr.1 = alloca  i32, align 4
 %sum.addr.1 = alloca  i32, align 4
 %index.addr = alloca  i32, align 4
 %num.addr = alloca  i32, align 4
 %internal.ret.addr.1 = alloca  i32, align 4
 store i32 %num,i32* %num.addr, align 4
 store i32 0,i32* %index.addr, align 4
 store i32 0,i32* %sum.addr.1, align 4
 br label %wh.cond

exit.13:                       ;prevs = 
 %internal.ret.load.1 = load i32, i32* %internal.ret.addr.1, align 4
 ret i32 %internal.ret.load.1

wh.cond:                       ;prevs = 
 %index.load = load i32, i32* %index.addr, align 4
 %num.load = load i32, i32* %num.addr, align 4
 %sle = icmp sle i32 %index.load , %num.load
 br i1 %sle , label %wh.body , label %wh.exit

wh.body:                       ;prevs = 
 %loop.call = call i32 @loop()
 store i32 %loop.call,i32* %a.addr.1, align 4
 %a.load.5 = load i32, i32* %a.addr.1, align 4
 %sgt = icmp sgt i32 %a.load.5 , 5000
 br i1 %sgt , label %if.true.1 , label %if.false.1

wh.exit:                       ;prevs = 
 %sum.load.10 = load i32, i32* %sum.addr.1, align 4
 store i32 %sum.load.10,i32* %internal.ret.addr.1, align 4
 br label %exit.13

if.true.1:                       ;prevs = 
 %a.load.6 = load i32, i32* %a.addr.1, align 4
 %a.load.7 = load i32, i32* %a.addr.1, align 4
 %sub.1 = sub i32 %a.load.7 , 5000
 store i32 %sub.1,i32* %a.addr.1, align 4
 br label %if.exit.1

if.false.1:                       ;prevs = 
 br label %if.exit.1

if.exit.1:                       ;prevs = 
 %sum.load.5 = load i32, i32* %sum.addr.1, align 4
 %sum.load.6 = load i32, i32* %sum.addr.1, align 4
 %a.load.8 = load i32, i32* %a.addr.1, align 4
 %add.22 = add i32 %sum.load.6 , %a.load.8
 store i32 %add.22,i32* %sum.addr.1, align 4
 %sum.load.7 = load i32, i32* %sum.addr.1, align 4
 %sgt.1 = icmp sgt i32 %sum.load.7 , 5000
 br i1 %sgt.1 , label %if.true.2 , label %if.false.2

if.true.2:                       ;prevs = 
 %sum.load.8 = load i32, i32* %sum.addr.1, align 4
 %sum.load.9 = load i32, i32* %sum.addr.1, align 4
 %sub.2 = sub i32 %sum.load.9 , 5000
 store i32 %sub.2,i32* %sum.addr.1, align 4
 br label %if.exit.2

if.false.2:                       ;prevs = 
 br label %if.exit.2

if.exit.2:                       ;prevs = 
 %index.load.1 = load i32, i32* %index.addr, align 4
 %index.load.2 = load i32, i32* %index.addr, align 4
 %add.23 = add i32 %index.load.2 , 1
 store i32 %add.23,i32* %index.addr, align 4
 br label %wh.cond

}

define i32 @main()
{

entry.14:                       ;prevs = 
 %internal.ret.addr.2 = alloca  i32, align 4
 call void @_glb_init()
 store i32 0,i32* %internal.ret.addr.2, align 4
 %compute.call = call i32 @compute(i32 20)
 call void @printInt(i32 %compute.call)
 br label %exit.14

exit.14:                       ;prevs = 
 %internal.ret.load.2 = load i32, i32* %internal.ret.addr.2, align 4
 ret i32 %internal.ret.load.2

}

