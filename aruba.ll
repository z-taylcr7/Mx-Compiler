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

@t = global i32 zeroinitializer, align 4
@l = global i32 zeroinitializer, align 4
@i = global i32 zeroinitializer, align 4
@s = global i8* zeroinitializer, align 8

define void @_glb_init()
{

entry.11:                       ;prevs = 
 br label %exit.11

exit.11:                       ;prevs = 
 ret void

}

define i32 @main()
{

entry.12:                       ;prevs = 
 %internal.ret.addr = alloca  i32, align 4
 call void @_glb_init()
 store i32 0,i32* %internal.ret.addr, align 4
 %t.load = load i32, i32* @t, align 4
 %getInt.call = call i32 @getInt()
 store i32 %getInt.call,i32* @t, align 4
 %i.load = load i32, i32* @i, align 4
 store i32 0,i32* @i, align 4
 br label %for.cond

exit.12:                       ;prevs = 
 %internal.ret.load = load i32, i32* %internal.ret.addr, align 4
 ret i32 %internal.ret.load

for.cond:                       ;prevs = 
 %i.load.1 = load i32, i32* @i, align 4
 %t.load.1 = load i32, i32* @t, align 4
 %slt = icmp slt i32 %i.load.1 , %t.load.1
 br i1 %slt , label %for.body , label %for.exit

for.incr:                       ;prevs = 
 %i.load.2 = load i32, i32* @i, align 4
 %add = add i32 %i.load.2 , 1
 store i32 %add,i32* @i, align 4
 br label %for.cond

for.body:                       ;prevs = 
 %s.load = load i8*, i8** @s, align 8
 %getString.call = call i8* @getString()
 store i8* %getString.call,i8** @s, align 8
 %l.load = load i32, i32* @l, align 4
 %s.load.1 = load i8*, i8** @s, align 8
 %_str_length.call = call i32 @_str_length(i8* %s.load.1)
 store i32 %_str_length.call,i32* @l, align 4
 %l.load.1 = load i32, i32* @l, align 4
 %sgt = icmp sgt i32 %l.load.1 , 10
 br i1 %sgt , label %if.true , label %if.false

for.exit:                       ;prevs = 
 br label %exit.12

if.true:                       ;prevs = 
 %s.load.3 = load i8*, i8** @s, align 8
 %_str_substring.call = call i8* @_str_substring(i8* %s.load.3, i32 0, i32 1)
 %l.load.2 = load i32, i32* @l, align 4
 %sub = sub i32 %l.load.2 , 2
 %toString.call = call i8* @toString(i32 %sub)
 %_bot_str_cat.call = call i8* @_bot_str_cat(i8* %_str_substring.call, i8* %toString.call)
 %s.load.4 = load i8*, i8** @s, align 8
 %l.load.3 = load i32, i32* @l, align 4
 %sub.1 = sub i32 %l.load.3 , 1
 %l.load.4 = load i32, i32* @l, align 4
 %_str_substring.call.1 = call i8* @_str_substring(i8* %s.load.4, i32 %sub.1, i32 %l.load.4)
 %_bot_str_cat.call.1 = call i8* @_bot_str_cat(i8* %_bot_str_cat.call, i8* %_str_substring.call.1)
 call void @println(i8* %_bot_str_cat.call.1)
 br label %if.exit

if.false:                       ;prevs = 
 %s.load.2 = load i8*, i8** @s, align 8
 call void @println(i8* %s.load.2)
 br label %if.exit

if.exit:                       ;prevs = 
 br label %for.incr

}

