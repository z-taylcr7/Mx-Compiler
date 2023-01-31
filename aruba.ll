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

define i32 @main()
{

entry.12:                       ;prevs =  | nexts = %entry.11.i, 
 br label %entry.11.i

exit.12:                       ;prevs = %for.exit, 
 ret i32 %phi.1

for.cond:                       ;prevs = %for.incr, %split,  | nexts = %for.body, %for.exit, 
 %phi = phi i32 [1, %split], [%add, %for.incr]
 %phi.1 = phi i32 [null, %split], [%add.1, %for.incr]
 %phi.2 = phi i32 [1, %split], [%add.1, %for.incr]
 %phi.3 = phi i32 [0, %split], [%phi.2, %for.incr]
 %slt = icmp slt i32 %phi , 10
 br i1 %slt , label %for.body , label %for.exit

for.incr:                       ;prevs = %for.body,  | nexts = %for.cond, 
 %add = add i32 %phi , 1
 move %phi from %add
 move %phi.1 from %add.1
 move %phi.3 from %phi.2
 move %phi.2 from %add.1
 br label %for.cond

for.body:                       ;prevs = %for.cond,  | nexts = %for.incr, 
 %add.1 = add i32 %phi.3 , %phi.2
 br label %for.incr

for.exit:                       ;prevs = %for.cond,  | nexts = %exit.12, 
 call void @printInt(i32 %phi.1)
 br label %exit.12

entry.11.i:                       ;prevs = %entry.12,  | nexts = %exit.11.i, 
 br label %exit.11.i

exit.11.i:                       ;prevs = %entry.11.i,  | nexts = %split, 
 br label %split

split:                       ;prevs = %exit.11.i,  | nexts = %for.cond, 
 move %phi from 1
 move %phi.1 from null
 move %phi.2 from 1
 move %phi.3 from 0
 br label %for.cond

}

