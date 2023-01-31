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

@n = global i32 zeroinitializer, align 4
@r = global i32 zeroinitializer, align 4
@c = global i32 zeroinitializer, align 4
@i = global i32 zeroinitializer, align 4
@j = global i32 zeroinitializer, align 4

define i32 @main()
{

entry.13:                       ;prevs =  | nexts = %entry.11.i, 
 %i.load.4 = load i32, i32* @i, align 4
 %r.load.2 = load i32, i32* @r, align 4
 %c.load.5 = load i32, i32* @c, align 4
 %n.load.2 = load i32, i32* @n, align 4
 %j.load.4 = load i32, i32* @j, align 4
 br label %entry.11.i

exit.13:                       ;prevs = %split.2, 
 store i32 0,i32* @i, align 4
 store i32 %r.load.2,i32* @r, align 4
 store i32 %c.load.5,i32* @c, align 4
 store i32 %n.load.2,i32* @n, align 4
 store i32 %j.load.4,i32* @j, align 4
 ret i32 0

for.cond:                       ;prevs = %for.incr, %split,  | nexts = %for.body, %for.exit, 
 %slt = icmp slt i32 0 , 5
 br i1 %slt , label %for.body , label %for.exit

for.incr:                       ;prevs = %for.exit.1,  | nexts = %for.cond, 
 %add = add i32 0 , 1
 br label %for.cond

for.body:                       ;prevs = %for.cond,  | nexts = %for.cond.1, 
 br label %for.cond.1

for.exit:                       ;prevs = %for.cond,  | nexts = %entry.12.i, 
 %sub.1 = sub i32 2 , %r.load.2
 br label %entry.12.i

for.cond.1:                       ;prevs = %for.body, %for.incr.1,  | nexts = %for.body.1, %for.exit.1, 
 %slt.1 = icmp slt i32 0 , 5
 br i1 %slt.1 , label %for.body.1 , label %for.exit.1

for.incr.1:                       ;prevs = %if.exit.1,  | nexts = %for.cond.1, 
 %add.1 = add i32 0 , 1
 br label %for.cond.1

for.body.1:                       ;prevs = %for.cond.1,  | nexts = %if.true.1, %if.false.1, 
 %getInt.call = call i32 @getInt()
 %eq = icmp eq i32 %getInt.call , 1
 br i1 %eq , label %if.true.1 , label %if.false.1

for.exit.1:                       ;prevs = %for.cond.1,  | nexts = %for.incr, 
 br label %for.incr

if.true.1:                       ;prevs = %for.body.1,  | nexts = %if.exit.1, 
 br label %if.exit.1

if.false.1:                       ;prevs = %for.body.1,  | nexts = %if.exit.1, 
 br label %if.exit.1

if.exit.1:                       ;prevs = %if.true.1, %if.false.1,  | nexts = %for.incr.1, 
 br label %for.incr.1

entry.11.i:                       ;prevs = %entry.13,  | nexts = %exit.11.i, 
 br label %exit.11.i

exit.11.i:                       ;prevs = %entry.11.i,  | nexts = %split, 
 br label %split

split:                       ;prevs = %exit.11.i,  | nexts = %for.cond, 
 br label %for.cond

entry.12.i:                       ;prevs = %for.exit,  | nexts = %if.true.i, %if.false.i, 
 %sgt.1 = icmp sgt i32 %sub.1 , 0
 br i1 %sgt.1 , label %if.true.i , label %if.false.i

exit.12.i:                       ;prevs = %if.true.i, %if.exit.i,  | nexts = %split.1, 
 %phi.1 = phi i32 [%sub.1, %if.true.i], [%sub.3, %if.exit.i]
 br label %split.1

if.true.i:                       ;prevs = %entry.12.i,  | nexts = %exit.12.i, 
 move %phi.1 from %sub.1
 br label %exit.12.i

if.false.i:                       ;prevs = %entry.12.i,  | nexts = %if.exit.i, 
 br label %if.exit.i

if.exit.i:                       ;prevs = %if.false.i,  | nexts = %exit.12.i, 
 %sub.3 = sub i32 0 , %sub.1
 move %phi.1 from %sub.3
 br label %exit.12.i

split.1:                       ;prevs = %exit.12.i,  | nexts = %entry.12.i.1, 
 %sub.2 = sub i32 2 , %c.load.5
 br label %entry.12.i.1

entry.12.i.1:                       ;prevs = %split.1,  | nexts = %if.true.i.1, %if.false.i.1, 
 %sgt.2 = icmp sgt i32 %sub.2 , 0
 br i1 %sgt.2 , label %if.true.i.1 , label %if.false.i.1

exit.12.i.1:                       ;prevs = %if.true.i.1, %if.exit.i.1,  | nexts = %split.2, 
 %phi.2 = phi i32 [%sub.2, %if.true.i.1], [%sub.4, %if.exit.i.1]
 br label %split.2

if.true.i.1:                       ;prevs = %entry.12.i.1,  | nexts = %exit.12.i.1, 
 move %phi.2 from %sub.2
 br label %exit.12.i.1

if.false.i.1:                       ;prevs = %entry.12.i.1,  | nexts = %if.exit.i.1, 
 br label %if.exit.i.1

if.exit.i.1:                       ;prevs = %if.false.i.1,  | nexts = %exit.12.i.1, 
 %sub.4 = sub i32 0 , %sub.2
 move %phi.2 from %sub.4
 br label %exit.12.i.1

split.2:                       ;prevs = %exit.12.i.1,  | nexts = %exit.13, 
 %add.2 = add i32 %phi.1 , %phi.2
 call void @printInt(i32 %add.2)
 br label %exit.13

}

