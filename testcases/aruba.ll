; Module = 'testcases/aruba.mx'
;src_file_name = "testcases/aruba.mx"
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
@x = global i32 zeroinitializer, align 4
@y = global i32 zeroinitializer, align 4
@z = global i32 zeroinitializer, align 4
@c = global i32 zeroinitializer, align 4
@k = global i32 zeroinitializer, align 4

define void @_glb_init()
{

entry.11:                       ;prevs = 
 store i32 0,i32* @c, align 4
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
 %n.load = load i32, i32* @n, align 4
 %getInt.call = call i32 @getInt()
 store i32 %getInt.call,i32* @n, align 4
 %k.load = load i32, i32* @k, align 4
 store i32 0,i32* @k, align 4
 br label %for.cond

exit.12:                       ;prevs = 
 %internal.ret.load = load i32, i32* %internal.ret.addr, align 4
 ret i32 %internal.ret.load

for.incr:                       ;prevs = 
 %k.load.2 = load i32, i32* @k, align 4
 %add = add i32 %k.load.2 , 1
 store i32 %add,i32* @k, align 4
 br label %for.cond

for.cond:                       ;prevs = 
 br label %for.body

for.body:                       ;prevs = 
 %x.load = load i32, i32* @x, align 4
 %getInt.call.1 = call i32 @getInt()
 store i32 %getInt.call.1,i32* @x, align 4
 %y.load = load i32, i32* @y, align 4
 %getInt.call.2 = call i32 @getInt()
 store i32 %getInt.call.2,i32* @y, align 4
 %z.load = load i32, i32* @z, align 4
 %getInt.call.3 = call i32 @getInt()
 store i32 %getInt.call.3,i32* @z, align 4
 %x.load.1 = load i32, i32* @x, align 4
 %y.load.1 = load i32, i32* @y, align 4
 %add.1 = add i32 %x.load.1 , %y.load.1
 %z.load.1 = load i32, i32* @z, align 4
 %add.2 = add i32 %add.1 , %z.load.1
 %sgt = icmp sgt i32 %add.2 , 1
 br i1 %sgt , label %if.true , label %if.false

for.exit:                       ;prevs = 
 %c.load.1 = load i32, i32* @c, align 4
 call void @printlnInt(i32 %c.load.1)
 br label %exit.12

if.true:                       ;prevs = 
 %c.load = load i32, i32* @c, align 4
 %add.3 = add i32 %c.load , 1
 store i32 %add.3,i32* @c, align 4
 br label %if.exit

if.false:                       ;prevs = 
 br label %if.exit

if.exit:                       ;prevs = 
 br label %for.incr

}

