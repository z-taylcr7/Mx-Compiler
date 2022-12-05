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

@n.1 = global i32 zeroinitializer, align 4
@p.1 = global i32 zeroinitializer, align 4
@k.1 = global i32 zeroinitializer, align 4
@i.1 = global i32 zeroinitializer, align 4

%anon.strconst = private unnamed_addr constant  [ i8 x 4 ]  c"<< \00", align 1
%anon.strconst.1 = private unnamed_addr constant  [ i8 x 2 ]  c" \00", align 1
%anon.strconst.2 = private unnamed_addr constant  [ i8 x 2 ]  c"(\00", align 1
%anon.strconst.3 = private unnamed_addr constant  [ i8 x 3 ]  c") \00", align 1
%anon.strconst.4 = private unnamed_addr constant  [ i8 x 4 ]  c">> \00", align 1

define void @_glb_init()
{

entry.11:                       prevs = 
 br Label %exit.11

exit.11:                       prevs = 
 return void

}

define i32 @main()
{

entry.12:                       prevs = 
 %internal.ret.1 = alloca  i32, align 4
 call void @_glb_init(void @_glb_init  )
 store i32 0 i32* %internal.ret.1, align 4
 %n.2 = load i32, i32* @n, align 4
 %getInt.call = call i32 @getInt(i32 @getInt  )
 store i32 %getInt.call i32* @n, align 4
 %p.2 = load i32, i32* @p, align 4
 %getInt.call.1 = call i32 @getInt(i32 @getInt  )
 store i32 %getInt.call.1 i32* @p, align 4
 %k.2 = load i32, i32* @k, align 4
 %getInt.call.2 = call i32 @getInt(i32 @getInt  )
 store i32 %getInt.call.2 i32* @k, align 4
 %p.3 = load i32, i32* @p, align 4
 %k.3 = load i32, i32* @k, align 4
 %sub = sub %p.3 , %k.3
 %sgt = icmp sgt i32 %sub , 1
 %sgt.1 = sgt %sub , 1
 br i32 %sgt.1 , Label %if.true , Label %if.false

exit.12:                       prevs = 
 %internal.ret.1 = load i32, i32* %internal.ret.1, align 4
 return i32 %internal.ret.1

if.true:                       prevs = 
 %getelementptr = getelementptr inbounds  [ i8 x 4 ] ,  [ i8 x 4 ] * %anon.strconst, i32 0, i32 0
 call void @print(void @print , i8* %getelementptr  )
 br Label %if.exit

if.false:                       prevs = 
 br Label %if.exit

if.exit:                       prevs = 
 %i.2 = load i32, i32* @i, align 4
 %p.4 = load i32, i32* @p, align 4
 %k.4 = load i32, i32* @k, align 4
 %sub.1 = sub %p.4 , %k.4
 store i32 %sub.1 i32* @i, align 4
 br Label %for.cond

for.incr:                       prevs = 
 %i.4 = load i32, i32* @i, align 4
 %add.1 = add %i.4 , 1
 store i32 %add.1 i32* @i, align 4
 br Label %for.cond

for.cond:                       prevs = 
 br Label %for.body

for.body:                       prevs = 
 %i.5 = load i32, i32* @i, align 4
 %sle.2 = icmp sle i32 1 , %i.5
 %sle.3 = sle 1 , %i.5
 %i.6 = load i32, i32* @i, align 4
 %n.3 = load i32, i32* @n, align 4
 %sle.4 = icmp sle i32 %i.6 , %n.3
 %sle.5 = sle %i.6 , %n.3
 %not a symbol = not a symbol %sle.3 , %sle.5
 br i32 %not a symbol , Label %if.true.1 , Label %if.false.1

for.exit:                       prevs = 
 %p.7 = load i32, i32* @p, align 4
 %k.6 = load i32, i32* @k, align 4
 %add.2 = add %p.7 , %k.6
 %n.4 = load i32, i32* @n, align 4
 %slt = icmp slt i32 %add.2 , %n.4
 %slt.1 = slt %add.2 , %n.4
 br i32 %slt.1 , Label %if.true.3 , Label %if.false.3

if.true.1:                       prevs = 
 %i.7 = load i32, i32* @i, align 4
 %p.6 = load i32, i32* @p, align 4
 %eq = icmp eq i32 %i.7 , %p.6
 %eq.1 = eq %i.7 , %p.6
 br i32 %eq.1 , Label %if.true.2 , Label %if.false.2

if.false.1:                       prevs = 
 br Label %if.exit.1

if.exit.1:                       prevs = 
 br Label %for.incr

if.true.2:                       prevs = 
 %getelementptr.2 = getelementptr inbounds  [ i8 x 2 ] ,  [ i8 x 2 ] * %anon.strconst.2, i32 0, i32 0
 call void @print(void @print , i8* %getelementptr.2  )
 %i.9 = load i32, i32* @i, align 4
 %toString.call = call i8* @toString(i8* @toString , i32 %i.9  )
 call void @print(void @print , i8* %toString.call  )
 %getelementptr.3 = getelementptr inbounds  [ i8 x 3 ] ,  [ i8 x 3 ] * %anon.strconst.3, i32 0, i32 0
 call void @print(void @print , i8* %getelementptr.3  )
 br Label %if.exit.2

if.false.2:                       prevs = 
 %i.8 = load i32, i32* @i, align 4
 call void @printInt(void @printInt , i32 %i.8  )
 %getelementptr.1 = getelementptr inbounds  [ i8 x 2 ] ,  [ i8 x 2 ] * %anon.strconst.1, i32 0, i32 0
 call void @print(void @print , i8* %getelementptr.1  )
 br Label %if.exit.2

if.exit.2:                       prevs = 
 br Label %exit.12

if.true.3:                       prevs = 
 %getelementptr.4 = getelementptr inbounds  [ i8 x 4 ] ,  [ i8 x 4 ] * %anon.strconst.4, i32 0, i32 0
 call void @print(void @print , i8* %getelementptr.4  )
 br Label %if.exit.3

if.false.3:                       prevs = 
 br Label %if.exit.3

if.exit.3:                       prevs = 
 store i32 0 i32* %internal.ret.1, align 4
 br Label %exit.12

}

