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

define i32 @qpow(i32 %a, i32 %p, i32 %mod)
{

entry.12:                       ;prevs = 
 %y.addr = alloca  i32, align 4
 %t.addr = alloca  i32, align 4
 %mod.addr = alloca  i32, align 4
 %p.addr = alloca  i32, align 4
 %a.addr = alloca  i32, align 4
 %internal.ret.addr = alloca  i32, align 4
 store i32 %a,i32* %a.addr, align 4
 store i32 %p,i32* %p.addr, align 4
 store i32 %mod,i32* %mod.addr, align 4
 store i32 1,i32* %t.addr, align 4
 %a.load = load i32, i32* %a.addr, align 4
 store i32 %a.load,i32* %y.addr, align 4
 br label %wh.cond

exit.12:                       ;prevs = 
 %internal.ret.load = load i32, i32* %internal.ret.addr, align 4
 ret i32 %internal.ret.load

wh.cond:                       ;prevs = 
 %p.load = load i32, i32* %p.addr, align 4
 %sgt = icmp sgt i32 %p.load , 0
 br i1 %sgt , label %wh.body , label %wh.exit

wh.body:                       ;prevs = 
 %p.load.1 = load i32, i32* %p.addr, align 4
 %and = and i32 %p.load.1 , 1
 %eq = icmp eq i32 %and , 1
 br i1 %eq , label %if.true , label %if.false

wh.exit:                       ;prevs = 
 %t.load.2 = load i32, i32* %t.addr, align 4
 store i32 %t.load.2,i32* %internal.ret.addr, align 4
 br label %exit.12

if.true:                       ;prevs = 
 %t.load = load i32, i32* %t.addr, align 4
 %t.load.1 = load i32, i32* %t.addr, align 4
 %y.load = load i32, i32* %y.addr, align 4
 %mul = mul i32 %t.load.1 , %y.load
 %mod.load = load i32, i32* %mod.addr, align 4
 %srem = srem i32 %mul , %mod.load
 store i32 %srem,i32* %t.addr, align 4
 br label %if.exit

if.false:                       ;prevs = 
 br label %if.exit

if.exit:                       ;prevs = 
 %y.load.1 = load i32, i32* %y.addr, align 4
 %y.load.2 = load i32, i32* %y.addr, align 4
 %y.load.3 = load i32, i32* %y.addr, align 4
 %mul.1 = mul i32 %y.load.2 , %y.load.3
 %mod.load.1 = load i32, i32* %mod.addr, align 4
 %srem.1 = srem i32 %mul.1 , %mod.load.1
 store i32 %srem.1,i32* %y.addr, align 4
 %p.load.2 = load i32, i32* %p.addr, align 4
 %p.load.3 = load i32, i32* %p.addr, align 4
 %sdiv = sdiv i32 %p.load.3 , 2
 store i32 %sdiv,i32* %p.addr, align 4
 br label %wh.cond

}

define i32 @main()
{

entry.13:                       ;prevs = 
 %internal.ret.addr.1 = alloca  i32, align 4
 call void @_glb_init()
 store i32 0,i32* %internal.ret.addr.1, align 4
 %qpow.call = call i32 @qpow(i32 2, i32 10, i32 10000)
 %toString.call = call i8* @toString(i32 %qpow.call)
 call void @println(i8* %toString.call)
 store i32 0,i32* %internal.ret.addr.1, align 4
 br label %exit.13

exit.13:                       ;prevs = 
 %internal.ret.load.1 = load i32, i32* %internal.ret.addr.1, align 4
 ret i32 %internal.ret.load.1

}

