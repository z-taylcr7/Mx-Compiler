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

@anon.strconst = private unnamed_addr constant [ 5 x i8 ] c"done\00", align 1

define i32 @main()
{

entry.12:                       ;prevs =  | nexts = %entry.11.i, 
 br label %entry.11.i

exit.12:                       ;prevs = %for.exit, 
 ret i32 0

for.cond:                       ;prevs = %for.incr, %split,  | nexts = %for.body, %for.exit, 
 %phi = phi i32 [null, %split], [%phi.1, %for.incr]
 %phi.2 = phi i32 [0, %split], [%add, %for.incr]
 %phi.5 = phi i32 [null, %split], [%phi.4, %for.incr]
 %phi.8 = phi i32 [null, %split], [%phi.7, %for.incr]
 %phi.10 = phi i32 [null, %split], [%phi.9, %for.incr]
 %slt = icmp slt i32 %phi.2 , 5
 br i1 %slt , label %for.body , label %for.exit

for.incr:                       ;prevs = %for.exit.1,  | nexts = %for.cond, 
 %add = add i32 %phi.2 , 1
 move %phi from %phi.1
 move %phi.2 from %add
 move %phi.5 from %phi.4
 move %phi.8 from %phi.7
 move %phi.10 from %phi.9
 br label %for.cond

for.body:                       ;prevs = %for.cond,  | nexts = %for.cond.1, 
 move %phi.1 from 0
 move %phi.4 from %phi.5
 move %phi.7 from %phi.8
 move %phi.9 from %phi.10
 br label %for.cond.1

for.exit:                       ;prevs = %for.cond,  | nexts = %exit.12, 
 %getelementptr = getelementptr inbounds [ 5 x i8 ], [ 5 x i8 ]* @anon.strconst, i32 0, i32 0
 call void @println(i8* %getelementptr)
 br label %exit.12

for.cond.1:                       ;prevs = %for.body, %for.incr.1,  | nexts = %for.body.1, %for.exit.1, 
 %phi.1 = phi i32 [0, %for.body], [%add.1, %for.incr.1]
 %phi.4 = phi i32 [%phi.5, %for.body], [%phi.3, %for.incr.1]
 %phi.7 = phi i32 [%phi.8, %for.body], [%phi.6, %for.incr.1]
 %phi.9 = phi i32 [%phi.10, %for.body], [%getInt.call, %for.incr.1]
 %slt.1 = icmp slt i32 %phi.1 , 5
 br i1 %slt.1 , label %for.body.1 , label %for.exit.1

for.incr.1:                       ;prevs = %if.exit,  | nexts = %for.cond.1, 
 %add.1 = add i32 %phi.1 , 1
 move %phi.1 from %add.1
 move %phi.4 from %phi.3
 move %phi.7 from %phi.6
 move %phi.9 from %getInt.call
 br label %for.cond.1

for.body.1:                       ;prevs = %for.cond.1,  | nexts = %if.true, %if.false, 
 %getInt.call = call i32 @getInt()
 %eq = icmp eq i32 %getInt.call , 1
 br i1 %eq , label %if.true , label %if.false

for.exit.1:                       ;prevs = %for.cond.1,  | nexts = %for.incr, 
 br label %for.incr

if.true:                       ;prevs = %for.body.1,  | nexts = %if.exit, 
 move %phi.3 from %phi.1
 move %phi.6 from %phi.2
 br label %if.exit

if.false:                       ;prevs = %for.body.1,  | nexts = %if.exit, 
 move %phi.3 from %phi.4
 move %phi.6 from %phi.7
 br label %if.exit

if.exit:                       ;prevs = %if.true, %if.false,  | nexts = %for.incr.1, 
 %phi.3 = phi i32 [%phi.1, %if.true], [%phi.4, %if.false]
 %phi.6 = phi i32 [%phi.2, %if.true], [%phi.7, %if.false]
 br label %for.incr.1

entry.11.i:                       ;prevs = %entry.12,  | nexts = %exit.11.i, 
 br label %exit.11.i

exit.11.i:                       ;prevs = %entry.11.i,  | nexts = %split, 
 br label %split

split:                       ;prevs = %exit.11.i,  | nexts = %for.cond, 
 move %phi from null
 move %phi.2 from 0
 move %phi.5 from null
 move %phi.8 from null
 move %phi.10 from null
 br label %for.cond

}

