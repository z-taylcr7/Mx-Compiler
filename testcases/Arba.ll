eclare i8* @_bot_malloc(i32)
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

@asciiTable = global i8* zeroinitializer, align 4
@MAXCHUNK = global i32 zeroinitializer, align 4
@MAXLENGTH = global i32 zeroinitializer, align 4
@chunks = global i32** zeroinitializer, align 4
@inputBuffer = global i32* zeroinitializer, align 4
@outputBuffer = global i32* zeroinitializer, align 4

@anon.strconst = private unnamed_addr constant [96 x i8] c" !\22#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\5C]^_`abcdefghijklmnopqrstuvwxyz{|}~\00", align 1
@anon.strconst.1 = private unnamed_addr constant [1 x i8] c"\00", align 1
@anon.strconst.2 = private unnamed_addr constant [19 x i8] c"nChunk > MAXCHUNK!\00", align 1
@anon.strconst.3 = private unnamed_addr constant [14 x i8] c"Invalid input\00", align 1
@anon.strconst.4 = private unnamed_addr constant [11 x i8] c"Not Found!\00", align 1

define void @_glb_init() {

entry.11:                                                ; preds =
  %getelementptr = getelementptr inbounds [96 x i8], [96 x i8]* @anon.strconst, i32 0, i32 0
  store i8* %getelementptr, i8** @asciiTable, align 4
  store i32 100, i32* @MAXCHUNK, align 4
  %MAXCHUNK.load = load i32, i32* @MAXCHUNK, align 4
  %sub = sub i32 %MAXCHUNK.load, 1
  %mul = mul i32 %sub, 64
  %sub.1 = sub i32 %mul, 16
  store i32 %sub.1, i32* @MAXLENGTH, align 4
  %MAXCHUNK.load.1 = load i32, i32* @MAXCHUNK, align 4
  %mul.1 = mul i32 %MAXCHUNK.load.1, 4
  %add.1 = add i32 %mul.1, 4
  %_bot_malloc.call = call noalias i8* @_bot_malloc(i32 %add.1)
  %bitcast = bitcast i8* %_bot_malloc.call to i32*
  store i32 %MAXCHUNK.load.1, i32* %bitcast, align 4
  %getelementptr.1 = getelementptr inbounds i32, i32* %bitcast, i32 1
  %bitcast.1 = bitcast i32* %getelementptr.1 to i32**
  %getelementptr.2 = getelementptr inbounds i32*, i32** %bitcast.1, i32 %MAXCHUNK.load.1
  br label %wh.cond

exit.11:                                                ; preds =
  ret void

wh.cond:                                                ; preds =
  %phi = phi i32** [%bitcast.1, %entry.11], [%getelementptr.3, %wh.body]
  %icmp = icmp ne i32** %phi, %getelementptr.2
  br i1 %icmp, label %wh.body, label %wh.exit

wh.body:                                                ; preds =
  %mul.2 = mul i32 80, 4
  %add.2 = add i32 %mul.2, 4
  %_bot_malloc.call.1 = call noalias i8* @_bot_malloc(i32 %add.2)
  %bitcast.2 = bitcast i8* %_bot_malloc.call.1 to i32*
  store i32 80, i32* %bitcast.2, align 4
  %getelementptr.4 = getelementptr inbounds i32, i32* %bitcast.2, i32 1
  %bitcast.3 = bitcast i32* %getelementptr.4 to i32*
  store i32* %bitcast.3, i32** %phi, align 4
  %getelementptr.3 = getelementptr inbounds i32*, i32** %phi, i32 1
  br label %wh.cond

wh.exit:                                                ; preds =
  store i32** %bitcast.1, i32*** @chunks, align 4
  %MAXLENGTH.load = load i32, i32* @MAXLENGTH, align 4
  %mul.3 = mul i32 %MAXLENGTH.load, 4
  %add.3 = add i32 %mul.3, 4
  %_bot_malloc.call.2 = call noalias i8* @_bot_malloc(i32 %add.3)
  %bitcast.4 = bitcast i8* %_bot_malloc.call.2 to i32*
  store i32 %MAXLENGTH.load, i32* %bitcast.4, align 4
  %getelementptr.5 = getelementptr inbounds i32, i32* %bitcast.4, i32 1
  %bitcast.5 = bitcast i32* %getelementptr.5 to i32*
  store i32* %bitcast.5, i32** @inputBuffer, align 4
  %mul.4 = mul i32 5, 4
  %add.4 = add i32 %mul.4, 4
  %_bot_malloc.call.3 = call noalias i8* @_bot_malloc(i32 %add.4)
  %bitcast.6 = bitcast i8* %_bot_malloc.call.3 to i32*
  store i32 5, i32* %bitcast.6, align 4
  %getelementptr.6 = getelementptr inbounds i32, i32* %bitcast.6, i32 1
  %bitcast.7 = bitcast i32* %getelementptr.6 to i32*
  store i32* %bitcast.7, i32** @outputBuffer, align 4
  br label %exit.11

}

define i32 @hex2int(i8* %x) {

entry.12:                                                ; preds =
  %digit.addr = alloca i32, align 4
  %result.addr = alloca i32, align 4
  %i.addr = alloca i32, align 4
  %x.addr = alloca i8*, align 4
  %internal.ret.addr = alloca i32, align 4
  store i8* %x, i8** %x.addr, align 4
  store i32 0, i32* %result.addr, align 4
  %i.load = load i32, i32* %i.addr, align 4
  store i32 0, i32* %i.addr, align 4
  br label %for.cond

exit.12:                                                ; preds =
  %internal.ret.load = load i32, i32* %internal.ret.addr, align 4
  ret i32 %internal.ret.load

for.cond:                                                ; preds =
  %i.load.1 = load i32, i32* %i.addr, align 4
  %x.load = load i8*, i8** %x.addr, align 4
  %_str_length.call = call i32 @_str_length(i8* %x.load)
  %icmp.1 = icmp slt i32 %i.load.1, %_str_length.call
  br i1 %icmp.1, label %for.body, label %for.exit

for.incr:                                                ; preds =
  %i.load.2 = load i32, i32* %i.addr, align 4
  %add.5 = add i32 %i.load.2, 1
  store i32 %add.5, i32* %i.addr, align 4
  br label %for.cond

for.body:                                                ; preds =
  %x.load.1 = load i8*, i8** %x.addr, align 4
  %i.load.3 = load i32, i32* %i.addr, align 4
  %_str_ord.call = call i32 @_str_ord(i8* %x.load.1, i32 %i.load.3)
  store i32 %_str_ord.call, i32* %digit.addr, align 4
  %digit.load = load i32, i32* %digit.addr, align 4
  %icmp.2 = icmp sge i32 %digit.load, 48
  %digit.load.1 = load i32, i32* %digit.addr, align 4
  %icmp.3 = icmp sle i32 %digit.load.1, 57
  %and = and i1 %icmp.2, %icmp.3
  br i1 %and, label %if.true, label %if.false

for.exit:                                                ; preds =
  %result.load.6 = load i32, i32* %result.addr, align 4
  store i32 %result.load.6, i32* %internal.ret.addr, align 4
  br label %exit.12

if.true:                                                ; preds =
  %result.load.4 = load i32, i32* %result.addr, align 4
  %result.load.5 = load i32, i32* %result.addr, align 4
  %mul.7 = mul i32 %result.load.5, 16
  %digit.load.8 = load i32, i32* %digit.addr, align 4
  %add.10 = add i32 %mul.7, %digit.load.8
  %sub.4 = sub i32 %add.10, 48
  store i32 %sub.4, i32* %result.addr, align 4
  br label %if.exit

if.false:                                                ; preds =
  %digit.load.2 = load i32, i32* %digit.addr, align 4
  %icmp.4 = icmp sge i32 %digit.load.2, 65
  %digit.load.3 = load i32, i32* %digit.addr, align 4
  %icmp.5 = icmp sle i32 %digit.load.3, 70
  %and.1 = and i1 %icmp.4, %icmp.5
  br i1 %and.1, label %if.true.1, label %if.false.1

if.exit:                                                ; preds =
  br label %for.incr

if.true.1:                                                ; preds =
  %result.load.2 = load i32, i32* %result.addr, align 4
  %result.load.3 = load i32, i32* %result.addr, align 4
  %mul.6 = mul i32 %result.load.3, 16
  %digit.load.7 = load i32, i32* %digit.addr, align 4
  %add.8 = add i32 %mul.6, %digit.load.7
  %sub.3 = sub i32 %add.8, 65
  %add.9 = add i32 %sub.3, 10
  store i32 %add.9, i32* %result.addr, align 4
  br label %if.exit.1

if.false.1:                                                ; preds =
  %digit.load.4 = load i32, i32* %digit.addr, align 4
  %icmp.6 = icmp sge i32 %digit.load.4, 97
  %digit.load.5 = load i32, i32* %digit.addr, align 4
  %icmp.7 = icmp sle i32 %digit.load.5, 102
  %and.2 = and i1 %icmp.6, %icmp.7
  br i1 %and.2, label %if.true.2, label %if.false.2

if.exit.1:                                                ; preds =
  br label %if.exit

if.true.2:                                                ; preds =
  %result.load = load i32, i32* %result.addr, align 4
  %result.load.1 = load i32, i32* %result.addr, align 4
  %mul.5 = mul i32 %result.load.1, 16
  %digit.load.6 = load i32, i32* %digit.addr, align 4
  %add.6 = add i32 %mul.5, %digit.load.6
  %sub.2 = sub i32 %add.6, 97
  %add.7 = add i32 %sub.2, 10
  store i32 %add.7, i32* %result.addr, align 4
  br label %if.exit.2

if.false.2:                                                ; preds =
  store i32 0, i32* %internal.ret.addr, align 4
  br label %exit.12

if.exit.2:                                                ; preds =
  br label %if.exit.1

}

define i8* @int2chr(i32 %x.1) {

entry.13:                                                ; preds =
  %x.addr.1 = alloca i32, align 4
  %internal.ret.addr.1 = alloca i8*, align 4
  store i32 %x.1, i32* %x.addr.1, align 4
  %x.load.2 = load i32, i32* %x.addr.1, align 4
  %icmp.8 = icmp sge i32 %x.load.2, 32
  %x.load.3 = load i32, i32* %x.addr.1, align 4
  %icmp.9 = icmp sle i32 %x.load.3, 126
  %and.3 = and i1 %icmp.8, %icmp.9
  br i1 %and.3, label %if.true.3, label %if.false.3

exit.13:                                                ; preds =
  %internal.ret.load.1 = load i8*, i8** %internal.ret.addr.1, align 4
  ret i8* %internal.ret.load.1

if.true.3:                                                ; preds =
  %asciiTable.load = load i8*, i8** @asciiTable, align 4
  %x.load.4 = load i32, i32* %x.addr.1, align 4
  %sub.5 = sub i32 %x.load.4, 32
  %x.load.5 = load i32, i32* %x.addr.1, align 4
  %sub.6 = sub i32 %x.load.5, 31
  %_str_substring.call = call i8* @_str_substring(i8* %asciiTable.load, i32 %sub.5, i32 %sub.6)
  store i8* %_str_substring.call, i8** %internal.ret.addr.1, align 4
  br label %exit.13

if.false.3:                                                ; preds =
  br label %if.exit.3

if.exit.3:                                                ; preds =
  %getelementptr.7 = getelementptr inbounds [1 x i8], [1 x i8]* @anon.strconst.1, i32 0, i32 0
  store i8* %getelementptr.7, i8** %internal.ret.addr.1, align 4
  br label %exit.13

}

define i8* @toStringHex(i32 %x.2) {

entry.14:                                                ; preds =
  %digit.addr.1 = alloca i32, align 4
  %i.addr.1 = alloca i32, align 4
  %ret.addr = alloca i8*, align 4
  %x.addr.2 = alloca i32, align 4
  %internal.ret.addr.2 = alloca i8*, align 4
  store i32 %x.2, i32* %x.addr.2, align 4
  %getelementptr.8 = getelementptr inbounds [1 x i8], [1 x i8]* @anon.strconst.1, i32 0, i32 0
  store i8* %getelementptr.8, i8** %ret.addr, align 4
  %i.load.4 = load i32, i32* %i.addr.1, align 4
  store i32 28, i32* %i.addr.1, align 4
  br label %for.cond.1

exit.14:                                                ; preds =
  %internal.ret.load.2 = load i8*, i8** %internal.ret.addr.2, align 4
  ret i8* %internal.ret.load.2

for.cond.1:                                                ; preds =
  %i.load.5 = load i32, i32* %i.addr.1, align 4
  %icmp.10 = icmp sge i32 %i.load.5, 0
  br i1 %icmp.10, label %for.body.1, label %for.exit.1

for.incr.1:                                                ; preds =
  %i.load.6 = load i32, i32* %i.addr.1, align 4
  %i.load.7 = load i32, i32* %i.addr.1, align 4
  %sub.7 = sub i32 %i.load.7, 4
  store i32 %sub.7, i32* %i.addr.1, align 4
  br label %for.cond.1

for.body.1:                                                ; preds =
  %x.load.6 = load i32, i32* %x.addr.2, align 4
  %i.load.8 = load i32, i32* %i.addr.1, align 4
  %ashr = ashr i32 %x.load.6, %i.load.8
  %and.4 = and i32 %ashr, 15
  store i32 %and.4, i32* %digit.addr.1, align 4
  %digit.load.9 = load i32, i32* %digit.addr.1, align 4
  %icmp.11 = icmp slt i32 %digit.load.9, 10
  br i1 %icmp.11, label %if.true.4, label %if.false.4

for.exit.1:                                                ; preds =
  %ret.load.4 = load i8*, i8** %ret.addr, align 4
  store i8* %ret.load.4, i8** %internal.ret.addr.2, align 4
  br label %exit.14

if.true.4:                                                ; preds =
  %ret.load.2 = load i8*, i8** %ret.addr, align 4
  %ret.load.3 = load i8*, i8** %ret.addr, align 4
  %digit.load.11 = load i32, i32* %digit.addr.1, align 4
  %add.12 = add i32 48, %digit.load.11
  %int2chr.call.1 = call i8* @int2chr(i32 %add.12)
  %_bot_str_cat.call.1 = call i8* @_bot_str_cat(i8* %ret.load.3, i8* %int2chr.call.1)
  store i8* %_bot_str_cat.call.1, i8** %ret.addr, align 4
  br label %if.exit.4

if.false.4:                                                ; preds =
  %ret.load = load i8*, i8** %ret.addr, align 4
  %ret.load.1 = load i8*, i8** %ret.addr, align 4
  %digit.load.10 = load i32, i32* %digit.addr.1, align 4
  %add.11 = add i32 65, %digit.load.10
  %sub.8 = sub i32 %add.11, 10
  %int2chr.call = call i8* @int2chr(i32 %sub.8)
  %_bot_str_cat.call = call i8* @_bot_str_cat(i8* %ret.load.1, i8* %int2chr.call)
  store i8* %_bot_str_cat.call, i8** %ret.addr, align 4
  br label %if.exit.4

if.exit.4:                                                ; preds =
  br label %for.incr.1

}

define i32 @rotate_left(i32 %x.3, i32 %shift) {

entry.15:                                                ; preds =
  %shift.addr = alloca i32, align 4
  %x.addr.3 = alloca i32, align 4
  %internal.ret.addr.3 = alloca i32, align 4
  store i32 %x.3, i32* %x.addr.3, align 4
  store i32 %shift, i32* %shift.addr, align 4
  %shift.load = load i32, i32* %shift.addr, align 4
  %icmp.12 = icmp eq i32 %shift.load, 1
  br i1 %icmp.12, label %if.true.5, label %if.false.5

exit.15:                                                ; preds =
  %internal.ret.load.3 = load i32, i32* %internal.ret.addr.3, align 4
  ret i32 %internal.ret.load.3

if.true.5:                                                ; preds =
  %x.load.7 = load i32, i32* %x.addr.3, align 4
  %and.5 = and i32 %x.load.7, 2147483647
  %shl = shl i32 %and.5, 1
  %x.load.8 = load i32, i32* %x.addr.3, align 4
  %ashr.1 = ashr i32 %x.load.8, 31
  %and.6 = and i32 %ashr.1, 1
  %or = or i32 %shl, %and.6
  store i32 %or, i32* %internal.ret.addr.3, align 4
  br label %exit.15

if.false.5:                                                ; preds =
  br label %if.exit.5

if.exit.5:                                                ; preds =
  %shift.load.1 = load i32, i32* %shift.addr, align 4
  %icmp.13 = icmp eq i32 %shift.load.1, 31
  br i1 %icmp.13, label %if.true.6, label %if.false.6

if.true.6:                                                ; preds =
  %x.load.9 = load i32, i32* %x.addr.3, align 4
  %and.7 = and i32 %x.load.9, 1
  %shl.1 = shl i32 %and.7, 31
  %x.load.10 = load i32, i32* %x.addr.3, align 4
  %ashr.2 = ashr i32 %x.load.10, 1
  %and.8 = and i32 %ashr.2, 2147483647
  %or.1 = or i32 %shl.1, %and.8
  store i32 %or.1, i32* %internal.ret.addr.3, align 4
  br label %exit.15

if.false.6:                                                ; preds =
  br label %if.exit.6

if.exit.6:                                                ; preds =
  %x.load.11 = load i32, i32* %x.addr.3, align 4
  %shift.load.2 = load i32, i32* %shift.addr, align 4
  %sub.9 = sub i32 32, %shift.load.2
  %shl.2 = shl i32 1, %sub.9
  %sub.10 = sub i32 %shl.2, 1
  %and.9 = and i32 %x.load.11, %sub.10
  %shift.load.3 = load i32, i32* %shift.addr, align 4
  %shl.3 = shl i32 %and.9, %shift.load.3
  %x.load.12 = load i32, i32* %x.addr.3, align 4
  %shift.load.4 = load i32, i32* %shift.addr, align 4
  %sub.11 = sub i32 32, %shift.load.4
  %ashr.3 = ashr i32 %x.load.12, %sub.11
  %shift.load.5 = load i32, i32* %shift.addr, align 4
  %shl.4 = shl i32 1, %shift.load.5
  %sub.12 = sub i32 %shl.4, 1
  %and.10 = and i32 %ashr.3, %sub.12
  %or.2 = or i32 %shl.3, %and.10
  store i32 %or.2, i32* %internal.ret.addr.3, align 4
  br label %exit.15

}

define i32 @add(i32 %x.4, i32 %y) {

entry.16:                                                ; preds =
  %high.addr = alloca i32, align 4
  %low.addr = alloca i32, align 4
  %y.addr = alloca i32, align 4
  %x.addr.4 = alloca i32, align 4
  %internal.ret.addr.4 = alloca i32, align 4
  store i32 %x.4, i32* %x.addr.4, align 4
  store i32 %y, i32* %y.addr, align 4
  %x.load.13 = load i32, i32* %x.addr.4, align 4
  %and.11 = and i32 %x.load.13, 65535
  %y.load = load i32, i32* %y.addr, align 4
  %and.12 = and i32 %y.load, 65535
  %add.13 = add i32 %and.11, %and.12
  store i32 %add.13, i32* %low.addr, align 4
  %x.load.14 = load i32, i32* %x.addr.4, align 4
  %ashr.4 = ashr i32 %x.load.14, 16
  %and.13 = and i32 %ashr.4, 65535
  %y.load.1 = load i32, i32* %y.addr, align 4
  %ashr.5 = ashr i32 %y.load.1, 16
  %and.14 = and i32 %ashr.5, 65535
  %add.14 = add i32 %and.13, %and.14
  %low.load = load i32, i32* %low.addr, align 4
  %ashr.6 = ashr i32 %low.load, 16
  %add.15 = add i32 %add.14, %ashr.6
  %and.15 = and i32 %add.15, 65535
  store i32 %and.15, i32* %high.addr, align 4
  %high.load = load i32, i32* %high.addr, align 4
  %shl.5 = shl i32 %high.load, 16
  %low.load.1 = load i32, i32* %low.addr, align 4
  %and.16 = and i32 %low.load.1, 65535
  %or.3 = or i32 %shl.5, %and.16
  store i32 %or.3, i32* %internal.ret.addr.4, align 4
  br label %exit.16

exit.16:                                                ; preds =
  %internal.ret.load.4 = load i32, i32* %internal.ret.addr.4, align 4
  ret i32 %internal.ret.load.4

}

define i32 @lohi(i32 %lo, i32 %hi) {

entry.17:                                                ; preds =
  %hi.addr = alloca i32, align 4
  %lo.addr = alloca i32, align 4
  %internal.ret.addr.5 = alloca i32, align 4
  store i32 %lo, i32* %lo.addr, align 4
  store i32 %hi, i32* %hi.addr, align 4
  %lo.load = load i32, i32* %lo.addr, align 4
  %hi.load = load i32, i32* %hi.addr, align 4
  %shl.6 = shl i32 %hi.load, 16
  %or.4 = or i32 %lo.load, %shl.6
  store i32 %or.4, i32* %internal.ret.addr.5, align 4
  br label %exit.17

exit.17:                                                ; preds =
  %internal.ret.load.5 = load i32, i32* %internal.ret.addr.5, align 4
  ret i32 %internal.ret.load.5

}

define i32* @sha1(i32* %input, i32 %length) {

entry.18:                                                ; preds =
  %temp.addr = alloca i32, align 4
  %k.addr = alloca i32, align 4
  %f.addr = alloca i32, align 4
  %e.addr = alloca i32, align 4
  %d.addr = alloca i32, align 4
  %c.addr = alloca i32, align 4
  %b.addr = alloca i32, align 4
  %a.addr = alloca i32, align 4
  %h4.addr = alloca i32, align 4
  %h3.addr = alloca i32, align 4
  %h2.addr = alloca i32, align 4
  %h1.addr = alloca i32, align 4
  %h0.addr = alloca i32, align 4
  %j.addr = alloca i32, align 4
  %i.addr.2 = alloca i32, align 4
  %nChunk.addr = alloca i32, align 4
  %length.addr = alloca i32, align 4
  %input.addr = alloca i32*, align 4
  %internal.ret.addr.6 = alloca i32*, align 4
  store i32* %input, i32** %input.addr, align 4
  store i32 %length, i32* %length.addr, align 4
  %length.load = load i32, i32* %length.addr, align 4
  %add.16 = add i32 %length.load, 64
  %sub.13 = sub i32 %add.16, 56
  %sdiv = sdiv i32 %sub.13, 64
  %add.17 = add i32 %sdiv, 1
  store i32 %add.17, i32* %nChunk.addr, align 4
  %nChunk.load = load i32, i32* %nChunk.addr, align 4
  %MAXCHUNK.load.2 = load i32, i32* @MAXCHUNK, align 4
  %icmp.14 = icmp sgt i32 %nChunk.load, %MAXCHUNK.load.2
  br i1 %icmp.14, label %if.true.7, label %if.false.7

exit.18:                                                ; preds =
  %internal.ret.load.6 = load i32*, i32** %internal.ret.addr.6, align 4
  ret i32* %internal.ret.load.6

if.true.7:                                                ; preds =
  %getelementptr.9 = getelementptr inbounds [19 x i8], [19 x i8]* @anon.strconst.2, i32 0, i32 0
  call void @println(i8* %getelementptr.9)
  store i32* null, i32** %internal.ret.addr.6, align 4
  br label %exit.18

if.false.7:                                                ; preds =
  br label %if.exit.7

if.exit.7:                                                ; preds =
  %i.load.9 = load i32, i32* %i.addr.2, align 4
  store i32 0, i32* %i.addr.2, align 4
  br label %for.cond.2

for.cond.2:                                                ; preds =
  %i.load.10 = load i32, i32* %i.addr.2, align 4
  %nChunk.load.1 = load i32, i32* %nChunk.addr, align 4
  %icmp.15 = icmp slt i32 %i.load.10, %nChunk.load.1
  br i1 %icmp.15, label %for.body.2, label %for.exit.2

for.incr.2:                                                ; preds =
  %i.load.11 = load i32, i32* %i.addr.2, align 4
  %add.18 = add i32 %i.load.11, 1
  store i32 %add.18, i32* %i.addr.2, align 4
  br label %for.cond.2

for.body.2:                                                ; preds =
  %j.load = load i32, i32* %j.addr, align 4
  store i32 0, i32* %j.addr, align 4
  br label %for.cond.3

for.exit.2:                                                ; preds =
  %i.load.13 = load i32, i32* %i.addr.2, align 4
  store i32 0, i32* %i.addr.2, align 4
  br label %for.cond.4

for.cond.3:                                                ; preds =
  %j.load.1 = load i32, i32* %j.addr, align 4
  %icmp.16 = icmp slt i32 %j.load.1, 80
  br i1 %icmp.16, label %for.body.3, label %for.exit.3

for.incr.3:                                                ; preds =
  %j.load.2 = load i32, i32* %j.addr, align 4
  %add.19 = add i32 %j.load.2, 1
  store i32 %add.19, i32* %j.addr, align 4
  br label %for.cond.3

for.body.3:                                                ; preds =
  %chunks.load = load i32**, i32*** @chunks, align 4
  %i.load.12 = load i32, i32* %i.addr.2, align 4
  %chunks.load.elem.addr = getelementptr inbounds i32*, i32** %chunks.load, i32 %i.load.12
  %chunks.load.elem.load = load i32*, i32** %chunks.load.elem.addr, align 4
  %j.load.3 = load i32, i32* %j.addr, align 4
  %chunks.load.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.elem.load, i32 %j.load.3
  %chunks.load.elem.load.elem.load = load i32, i32* %chunks.load.elem.load.elem.addr, align 4
  store i32 0, i32* %chunks.load.elem.load.elem.addr, align 4
  br label %for.incr.3

for.exit.3:                                                ; preds =
  br label %for.incr.2

for.cond.4:                                                ; preds =
  %i.load.14 = load i32, i32* %i.addr.2, align 4
  %length.load.1 = load i32, i32* %length.addr, align 4
  %icmp.17 = icmp slt i32 %i.load.14, %length.load.1
  br i1 %icmp.17, label %for.body.4, label %for.exit.4

for.incr.4:                                                ; preds =
  %i.load.15 = load i32, i32* %i.addr.2, align 4
  %add.20 = add i32 %i.load.15, 1
  store i32 %add.20, i32* %i.addr.2, align 4
  br label %for.cond.4

for.body.4:                                                ; preds =
  %chunks.load.1 = load i32**, i32*** @chunks, align 4
  %i.load.16 = load i32, i32* %i.addr.2, align 4
  %sdiv.1 = sdiv i32 %i.load.16, 64
  %chunks.load.1.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.1, i32 %sdiv.1
  %chunks.load.1.elem.load = load i32*, i32** %chunks.load.1.elem.addr, align 4
  %i.load.17 = load i32, i32* %i.addr.2, align 4
  %srem = srem i32 %i.load.17, 64
  %sdiv.2 = sdiv i32 %srem, 4
  %chunks.load.1.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.1.elem.load, i32 %sdiv.2
  %chunks.load.1.elem.load.elem.load = load i32, i32* %chunks.load.1.elem.load.elem.addr, align 4
  %chunks.load.2 = load i32**, i32*** @chunks, align 4
  %i.load.18 = load i32, i32* %i.addr.2, align 4
  %sdiv.3 = sdiv i32 %i.load.18, 64
  %chunks.load.2.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.2, i32 %sdiv.3
  %chunks.load.2.elem.load = load i32*, i32** %chunks.load.2.elem.addr, align 4
  %i.load.19 = load i32, i32* %i.addr.2, align 4
  %srem.1 = srem i32 %i.load.19, 64
  %sdiv.4 = sdiv i32 %srem.1, 4
  %chunks.load.2.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.2.elem.load, i32 %sdiv.4
  %chunks.load.2.elem.load.elem.load = load i32, i32* %chunks.load.2.elem.load.elem.addr, align 4
  %input.load = load i32*, i32** %input.addr, align 4
  %i.load.20 = load i32, i32* %i.addr.2, align 4
  %input.load.elem.addr = getelementptr inbounds i32, i32* %input.load, i32 %i.load.20
  %input.load.elem.load = load i32, i32* %input.load.elem.addr, align 4
  %i.load.21 = load i32, i32* %i.addr.2, align 4
  %srem.2 = srem i32 %i.load.21, 4
  %sub.14 = sub i32 3, %srem.2
  %mul.8 = mul i32 %sub.14, 8
  %shl.7 = shl i32 %input.load.elem.load, %mul.8
  %or.5 = or i32 %chunks.load.2.elem.load.elem.load, %shl.7
  store i32 %or.5, i32* %chunks.load.1.elem.load.elem.addr, align 4
  br label %for.incr.4

for.exit.4:                                                ; preds =
  %chunks.load.3 = load i32**, i32*** @chunks, align 4
  %i.load.22 = load i32, i32* %i.addr.2, align 4
  %sdiv.5 = sdiv i32 %i.load.22, 64
  %chunks.load.3.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.3, i32 %sdiv.5
  %chunks.load.3.elem.load = load i32*, i32** %chunks.load.3.elem.addr, align 4
  %i.load.23 = load i32, i32* %i.addr.2, align 4
  %srem.3 = srem i32 %i.load.23, 64
  %sdiv.6 = sdiv i32 %srem.3, 4
  %chunks.load.3.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.3.elem.load, i32 %sdiv.6
  %chunks.load.3.elem.load.elem.load = load i32, i32* %chunks.load.3.elem.load.elem.addr, align 4
  %chunks.load.4 = load i32**, i32*** @chunks, align 4
  %i.load.24 = load i32, i32* %i.addr.2, align 4
  %sdiv.7 = sdiv i32 %i.load.24, 64
  %chunks.load.4.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.4, i32 %sdiv.7
  %chunks.load.4.elem.load = load i32*, i32** %chunks.load.4.elem.addr, align 4
  %i.load.25 = load i32, i32* %i.addr.2, align 4
  %srem.4 = srem i32 %i.load.25, 64
  %sdiv.8 = sdiv i32 %srem.4, 4
  %chunks.load.4.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.4.elem.load, i32 %sdiv.8
  %chunks.load.4.elem.load.elem.load = load i32, i32* %chunks.load.4.elem.load.elem.addr, align 4
  %i.load.26 = load i32, i32* %i.addr.2, align 4
  %srem.5 = srem i32 %i.load.26, 4
  %sub.15 = sub i32 3, %srem.5
  %mul.9 = mul i32 %sub.15, 8
  %shl.8 = shl i32 128, %mul.9
  %or.6 = or i32 %chunks.load.4.elem.load.elem.load, %shl.8
  store i32 %or.6, i32* %chunks.load.3.elem.load.elem.addr, align 4
  %chunks.load.5 = load i32**, i32*** @chunks, align 4
  %nChunk.load.2 = load i32, i32* %nChunk.addr, align 4
  %sub.16 = sub i32 %nChunk.load.2, 1
  %chunks.load.5.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.5, i32 %sub.16
  %chunks.load.5.elem.load = load i32*, i32** %chunks.load.5.elem.addr, align 4
  %chunks.load.5.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.5.elem.load, i32 15
  %chunks.load.5.elem.load.elem.load = load i32, i32* %chunks.load.5.elem.load.elem.addr, align 4
  %length.load.2 = load i32, i32* %length.addr, align 4
  %shl.9 = shl i32 %length.load.2, 3
  store i32 %shl.9, i32* %chunks.load.5.elem.load.elem.addr, align 4
  %chunks.load.6 = load i32**, i32*** @chunks, align 4
  %nChunk.load.3 = load i32, i32* %nChunk.addr, align 4
  %sub.17 = sub i32 %nChunk.load.3, 1
  %chunks.load.6.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.6, i32 %sub.17
  %chunks.load.6.elem.load = load i32*, i32** %chunks.load.6.elem.addr, align 4
  %chunks.load.6.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.6.elem.load, i32 14
  %chunks.load.6.elem.load.elem.load = load i32, i32* %chunks.load.6.elem.load.elem.addr, align 4
  %length.load.3 = load i32, i32* %length.addr, align 4
  %ashr.7 = ashr i32 %length.load.3, 29
  %and.17 = and i32 %ashr.7, 7
  store i32 %and.17, i32* %chunks.load.6.elem.load.elem.addr, align 4
  store i32 1732584193, i32* %h0.addr, align 4
  %lohi.call = call i32 @lohi(i32 43913, i32 61389)
  store i32 %lohi.call, i32* %h1.addr, align 4
  %lohi.call.1 = call i32 @lohi(i32 56574, i32 39098)
  store i32 %lohi.call.1, i32* %h2.addr, align 4
  store i32 271733878, i32* %h3.addr, align 4
  %lohi.call.2 = call i32 @lohi(i32 57840, i32 50130)
  store i32 %lohi.call.2, i32* %h4.addr, align 4
  %i.load.27 = load i32, i32* %i.addr.2, align 4
  store i32 0, i32* %i.addr.2, align 4
  br label %for.cond.5

for.cond.5:                                                ; preds =
  %i.load.28 = load i32, i32* %i.addr.2, align 4
  %nChunk.load.4 = load i32, i32* %nChunk.addr, align 4
  %icmp.18 = icmp slt i32 %i.load.28, %nChunk.load.4
  br i1 %icmp.18, label %for.body.5, label %for.exit.5

for.incr.5:                                                ; preds =
  %i.load.29 = load i32, i32* %i.addr.2, align 4
  %add.21 = add i32 %i.load.29, 1
  store i32 %add.21, i32* %i.addr.2, align 4
  br label %for.cond.5

for.body.5:                                                ; preds =
  %j.load.4 = load i32, i32* %j.addr, align 4
  store i32 16, i32* %j.addr, align 4
  br label %for.cond.6

for.exit.5:                                                ; preds =
  %outputBuffer.load = load i32*, i32** @outputBuffer, align 4
  %outputBuffer.load.elem.addr = getelementptr inbounds i32, i32* %outputBuffer.load, i32 0
  %outputBuffer.load.elem.load = load i32, i32* %outputBuffer.load.elem.addr, align 4
  %h0.load.3 = load i32, i32* %h0.addr, align 4
  store i32 %h0.load.3, i32* %outputBuffer.load.elem.addr, align 4
  %outputBuffer.load.1 = load i32*, i32** @outputBuffer, align 4
  %outputBuffer.load.1.elem.addr = getelementptr inbounds i32, i32* %outputBuffer.load.1, i32 1
  %outputBuffer.load.1.elem.load = load i32, i32* %outputBuffer.load.1.elem.addr, align 4
  %h1.load.3 = load i32, i32* %h1.addr, align 4
  store i32 %h1.load.3, i32* %outputBuffer.load.1.elem.addr, align 4
  %outputBuffer.load.2 = load i32*, i32** @outputBuffer, align 4
  %outputBuffer.load.2.elem.addr = getelementptr inbounds i32, i32* %outputBuffer.load.2, i32 2
  %outputBuffer.load.2.elem.load = load i32, i32* %outputBuffer.load.2.elem.addr, align 4
  %h2.load.3 = load i32, i32* %h2.addr, align 4
  store i32 %h2.load.3, i32* %outputBuffer.load.2.elem.addr, align 4
  %outputBuffer.load.3 = load i32*, i32** @outputBuffer, align 4
  %outputBuffer.load.3.elem.addr = getelementptr inbounds i32, i32* %outputBuffer.load.3, i32 3
  %outputBuffer.load.3.elem.load = load i32, i32* %outputBuffer.load.3.elem.addr, align 4
  %h3.load.3 = load i32, i32* %h3.addr, align 4
  store i32 %h3.load.3, i32* %outputBuffer.load.3.elem.addr, align 4
  %outputBuffer.load.4 = load i32*, i32** @outputBuffer, align 4
  %outputBuffer.load.4.elem.addr = getelementptr inbounds i32, i32* %outputBuffer.load.4, i32 4
  %outputBuffer.load.4.elem.load = load i32, i32* %outputBuffer.load.4.elem.addr, align 4
  %h4.load.3 = load i32, i32* %h4.addr, align 4
  store i32 %h4.load.3, i32* %outputBuffer.load.4.elem.addr, align 4
  %outputBuffer.load.5 = load i32*, i32** @outputBuffer, align 4
  store i32* %outputBuffer.load.5, i32** %internal.ret.addr.6, align 4
  br label %exit.18

for.cond.6:                                                ; preds =
  %j.load.5 = load i32, i32* %j.addr, align 4
  %icmp.19 = icmp slt i32 %j.load.5, 80
  br i1 %icmp.19, label %for.body.6, label %for.exit.6

for.incr.6:                                                ; preds =
  %j.load.6 = load i32, i32* %j.addr, align 4
  %add.22 = add i32 %j.load.6, 1
  store i32 %add.22, i32* %j.addr, align 4
  br label %for.cond.6

for.body.6:                                                ; preds =
  %chunks.load.7 = load i32**, i32*** @chunks, align 4
  %i.load.30 = load i32, i32* %i.addr.2, align 4
  %chunks.load.7.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.7, i32 %i.load.30
  %chunks.load.7.elem.load = load i32*, i32** %chunks.load.7.elem.addr, align 4
  %j.load.7 = load i32, i32* %j.addr, align 4
  %chunks.load.7.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.7.elem.load, i32 %j.load.7
  %chunks.load.7.elem.load.elem.load = load i32, i32* %chunks.load.7.elem.load.elem.addr, align 4
  %chunks.load.8 = load i32**, i32*** @chunks, align 4
  %i.load.31 = load i32, i32* %i.addr.2, align 4
  %chunks.load.8.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.8, i32 %i.load.31
  %chunks.load.8.elem.load = load i32*, i32** %chunks.load.8.elem.addr, align 4
  %j.load.8 = load i32, i32* %j.addr, align 4
  %sub.18 = sub i32 %j.load.8, 3
  %chunks.load.8.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.8.elem.load, i32 %sub.18
  %chunks.load.8.elem.load.elem.load = load i32, i32* %chunks.load.8.elem.load.elem.addr, align 4
  %chunks.load.9 = load i32**, i32*** @chunks, align 4
  %i.load.32 = load i32, i32* %i.addr.2, align 4
  %chunks.load.9.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.9, i32 %i.load.32
  %chunks.load.9.elem.load = load i32*, i32** %chunks.load.9.elem.addr, align 4
  %j.load.9 = load i32, i32* %j.addr, align 4
  %sub.19 = sub i32 %j.load.9, 8
  %chunks.load.9.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.9.elem.load, i32 %sub.19
  %chunks.load.9.elem.load.elem.load = load i32, i32* %chunks.load.9.elem.load.elem.addr, align 4
  %xor = xor i32 %chunks.load.8.elem.load.elem.load, %chunks.load.9.elem.load.elem.load
  %chunks.load.10 = load i32**, i32*** @chunks, align 4
  %i.load.33 = load i32, i32* %i.addr.2, align 4
  %chunks.load.10.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.10, i32 %i.load.33
  %chunks.load.10.elem.load = load i32*, i32** %chunks.load.10.elem.addr, align 4
  %j.load.10 = load i32, i32* %j.addr, align 4
  %sub.20 = sub i32 %j.load.10, 14
  %chunks.load.10.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.10.elem.load, i32 %sub.20
  %chunks.load.10.elem.load.elem.load = load i32, i32* %chunks.load.10.elem.load.elem.addr, align 4
  %xor.1 = xor i32 %xor, %chunks.load.10.elem.load.elem.load
  %chunks.load.11 = load i32**, i32*** @chunks, align 4
  %i.load.34 = load i32, i32* %i.addr.2, align 4
  %chunks.load.11.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.11, i32 %i.load.34
  %chunks.load.11.elem.load = load i32*, i32** %chunks.load.11.elem.addr, align 4
  %j.load.11 = load i32, i32* %j.addr, align 4
  %sub.21 = sub i32 %j.load.11, 16
  %chunks.load.11.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.11.elem.load, i32 %sub.21
  %chunks.load.11.elem.load.elem.load = load i32, i32* %chunks.load.11.elem.load.elem.addr, align 4
  %xor.2 = xor i32 %xor.1, %chunks.load.11.elem.load.elem.load
  %rotate_left.call = call i32 @rotate_left(i32 %xor.2, i32 1)
  store i32 %rotate_left.call, i32* %chunks.load.7.elem.load.elem.addr, align 4
  br label %for.incr.6

for.exit.6:                                                ; preds =
  %h0.load = load i32, i32* %h0.addr, align 4
  store i32 %h0.load, i32* %a.addr, align 4
  %h1.load = load i32, i32* %h1.addr, align 4
  store i32 %h1.load, i32* %b.addr, align 4
  %h2.load = load i32, i32* %h2.addr, align 4
  store i32 %h2.load, i32* %c.addr, align 4
  %h3.load = load i32, i32* %h3.addr, align 4
  store i32 %h3.load, i32* %d.addr, align 4
  %h4.load = load i32, i32* %h4.addr, align 4
  store i32 %h4.load, i32* %e.addr, align 4
  %j.load.12 = load i32, i32* %j.addr, align 4
  store i32 0, i32* %j.addr, align 4
  br label %for.cond.7

for.cond.7:                                                ; preds =
  %j.load.13 = load i32, i32* %j.addr, align 4
  %icmp.20 = icmp slt i32 %j.load.13, 80
  br i1 %icmp.20, label %for.body.7, label %for.exit.7

for.incr.7:                                                ; preds =
  %j.load.14 = load i32, i32* %j.addr, align 4
  %add.23 = add i32 %j.load.14, 1
  store i32 %add.23, i32* %j.addr, align 4
  br label %for.cond.7

for.body.7:                                                ; preds =
  %j.load.15 = load i32, i32* %j.addr, align 4
  %icmp.21 = icmp slt i32 %j.load.15, 20
  br i1 %icmp.21, label %if.true.8, label %if.false.8

for.exit.7:                                                ; preds =
  %h0.load.1 = load i32, i32* %h0.addr, align 4
  %h0.load.2 = load i32, i32* %h0.addr, align 4
  %a.load.3 = load i32, i32* %a.addr, align 4
  %add.call.4 = call i32 @add(i32 %h0.load.2, i32 %a.load.3)
  store i32 %add.call.4, i32* %h0.addr, align 4
  %h1.load.1 = load i32, i32* %h1.addr, align 4
  %h1.load.2 = load i32, i32* %h1.addr, align 4
  %b.load.8 = load i32, i32* %b.addr, align 4
  %add.call.5 = call i32 @add(i32 %h1.load.2, i32 %b.load.8)
  store i32 %add.call.5, i32* %h1.addr, align 4
  %h2.load.1 = load i32, i32* %h2.addr, align 4
  %h2.load.2 = load i32, i32* %h2.addr, align 4
  %c.load.7 = load i32, i32* %c.addr, align 4
  %add.call.6 = call i32 @add(i32 %h2.load.2, i32 %c.load.7)
  store i32 %add.call.6, i32* %h2.addr, align 4
  %h3.load.1 = load i32, i32* %h3.addr, align 4
  %h3.load.2 = load i32, i32* %h3.addr, align 4
  %d.load.7 = load i32, i32* %d.addr, align 4
  %add.call.7 = call i32 @add(i32 %h3.load.2, i32 %d.load.7)
  store i32 %add.call.7, i32* %h3.addr, align 4
  %h4.load.1 = load i32, i32* %h4.addr, align 4
  %h4.load.2 = load i32, i32* %h4.addr, align 4
  %e.load.2 = load i32, i32* %e.addr, align 4
  %add.call.8 = call i32 @add(i32 %h4.load.2, i32 %e.load.2)
  store i32 %add.call.8, i32* %h4.addr, align 4
  br label %for.incr.5

if.true.8:                                                ; preds =
  %f.load.3 = load i32, i32* %f.addr, align 4
  %b.load.4 = load i32, i32* %b.addr, align 4
  %c.load.4 = load i32, i32* %c.addr, align 4
  %and.21 = and i32 %b.load.4, %c.load.4
  %b.load.5 = load i32, i32* %b.addr, align 4
  %xor.7 = xor i32 %b.load.5, -1
  %d.load.4 = load i32, i32* %d.addr, align 4
  %and.22 = and i32 %xor.7, %d.load.4
  %or.9 = or i32 %and.21, %and.22
  store i32 %or.9, i32* %f.addr, align 4
  %k.load.3 = load i32, i32* %k.addr, align 4
  store i32 1518500249, i32* %k.addr, align 4
  br label %if.exit.8

if.false.8:                                                ; preds =
  %j.load.16 = load i32, i32* %j.addr, align 4
  %icmp.22 = icmp slt i32 %j.load.16, 40
  br i1 %icmp.22, label %if.true.9, label %if.false.9

if.exit.8:                                                ; preds =
  %a.load = load i32, i32* %a.addr, align 4
  %rotate_left.call.1 = call i32 @rotate_left(i32 %a.load, i32 5)
  %e.load = load i32, i32* %e.addr, align 4
  %add.call = call i32 @add(i32 %rotate_left.call.1, i32 %e.load)
  %f.load.4 = load i32, i32* %f.addr, align 4
  %k.load.4 = load i32, i32* %k.addr, align 4
  %add.call.1 = call i32 @add(i32 %f.load.4, i32 %k.load.4)
  %add.call.2 = call i32 @add(i32 %add.call, i32 %add.call.1)
  %chunks.load.12 = load i32**, i32*** @chunks, align 4
  %i.load.35 = load i32, i32* %i.addr.2, align 4
  %chunks.load.12.elem.addr = getelementptr inbounds i32*, i32** %chunks.load.12, i32 %i.load.35
  %chunks.load.12.elem.load = load i32*, i32** %chunks.load.12.elem.addr, align 4
  %j.load.18 = load i32, i32* %j.addr, align 4
  %chunks.load.12.elem.load.elem.addr = getelementptr inbounds i32, i32* %chunks.load.12.elem.load, i32 %j.load.18
  %chunks.load.12.elem.load.elem.load = load i32, i32* %chunks.load.12.elem.load.elem.addr, align 4
  %add.call.3 = call i32 @add(i32 %add.call.2, i32 %chunks.load.12.elem.load.elem.load)
  store i32 %add.call.3, i32* %temp.addr, align 4
  %e.load.1 = load i32, i32* %e.addr, align 4
  %d.load.5 = load i32, i32* %d.addr, align 4
  store i32 %d.load.5, i32* %e.addr, align 4
  %d.load.6 = load i32, i32* %d.addr, align 4
  %c.load.5 = load i32, i32* %c.addr, align 4
  store i32 %c.load.5, i32* %d.addr, align 4
  %c.load.6 = load i32, i32* %c.addr, align 4
  %b.load.6 = load i32, i32* %b.addr, align 4
  %rotate_left.call.2 = call i32 @rotate_left(i32 %b.load.6, i32 30)
  store i32 %rotate_left.call.2, i32* %c.addr, align 4
  %b.load.7 = load i32, i32* %b.addr, align 4
  %a.load.1 = load i32, i32* %a.addr, align 4
  store i32 %a.load.1, i32* %b.addr, align 4
  %a.load.2 = load i32, i32* %a.addr, align 4
  %temp.load = load i32, i32* %temp.addr, align 4
  store i32 %temp.load, i32* %a.addr, align 4
  br label %for.incr.7

if.true.9:                                                ; preds =
  %f.load.2 = load i32, i32* %f.addr, align 4
  %b.load.3 = load i32, i32* %b.addr, align 4
  %c.load.3 = load i32, i32* %c.addr, align 4
  %xor.5 = xor i32 %b.load.3, %c.load.3
  %d.load.3 = load i32, i32* %d.addr, align 4
  %xor.6 = xor i32 %xor.5, %d.load.3
  store i32 %xor.6, i32* %f.addr, align 4
  %k.load.2 = load i32, i32* %k.addr, align 4
  store i32 1859775393, i32* %k.addr, align 4
  br label %if.exit.9

if.false.9:                                                ; preds =
  %j.load.17 = load i32, i32* %j.addr, align 4
  %icmp.23 = icmp slt i32 %j.load.17, 60
  br i1 %icmp.23, label %if.true.10, label %if.false.10

if.exit.9:                                                ; preds =
  br label %if.exit.8

if.true.10:                                                ; preds =
  %f.load.1 = load i32, i32* %f.addr, align 4
  %b.load.1 = load i32, i32* %b.addr, align 4
  %c.load.1 = load i32, i32* %c.addr, align 4
  %and.18 = and i32 %b.load.1, %c.load.1
  %b.load.2 = load i32, i32* %b.addr, align 4
  %d.load.1 = load i32, i32* %d.addr, align 4
  %and.19 = and i32 %b.load.2, %d.load.1
  %or.7 = or i32 %and.18, %and.19
  %c.load.2 = load i32, i32* %c.addr, align 4
  %d.load.2 = load i32, i32* %d.addr, align 4
  %and.20 = and i32 %c.load.2, %d.load.2
  %or.8 = or i32 %or.7, %and.20
  store i32 %or.8, i32* %f.addr, align 4
  %k.load.1 = load i32, i32* %k.addr, align 4
  %lohi.call.4 = call i32 @lohi(i32 48348, i32 36635)
  store i32 %lohi.call.4, i32* %k.addr, align 4
  br label %if.exit.10

if.false.10:                                                ; preds =
  %f.load = load i32, i32* %f.addr, align 4
  %b.load = load i32, i32* %b.addr, align 4
  %c.load = load i32, i32* %c.addr, align 4
  %xor.3 = xor i32 %b.load, %c.load
  %d.load = load i32, i32* %d.addr, align 4
  %xor.4 = xor i32 %xor.3, %d.load
  store i32 %xor.4, i32* %f.addr, align 4
  %k.load = load i32, i32* %k.addr, align 4
  %lohi.call.3 = call i32 @lohi(i32 49622, i32 51810)
  store i32 %lohi.call.3, i32* %k.addr, align 4
  br label %if.exit.10

if.exit.10:                                                ; preds =
  br label %if.exit.9

}

define void @computeSHA1(i8* %input.1) {

entry.19:                                                ; preds =
  %result.addr.1 = alloca i32*, align 4
  %i.addr.3 = alloca i32, align 4
  %input.addr.1 = alloca i8*, align 4
  store i8* %input.1, i8** %input.addr.1, align 4
  %i.load.36 = load i32, i32* %i.addr.3, align 4
  store i32 0, i32* %i.addr.3, align 4
  br label %for.cond.8

exit.19:                                                ; preds =
  ret void

for.cond.8:                                                ; preds =
  %i.load.37 = load i32, i32* %i.addr.3, align 4
  %input.load.1 = load i8*, i8** %input.addr.1, align 4
  %_str_length.call.1 = call i32 @_str_length(i8* %input.load.1)
  %icmp.24 = icmp slt i32 %i.load.37, %_str_length.call.1
  br i1 %icmp.24, label %for.body.8, label %for.exit.8

for.incr.8:                                                ; preds =
  %i.load.38 = load i32, i32* %i.addr.3, align 4
  %add.24 = add i32 %i.load.38, 1
  store i32 %add.24, i32* %i.addr.3, align 4
  br label %for.cond.8

for.body.8:                                                ; preds =
  %inputBuffer.load = load i32*, i32** @inputBuffer, align 4
  %i.load.39 = load i32, i32* %i.addr.3, align 4
  %inputBuffer.load.elem.addr = getelementptr inbounds i32, i32* %inputBuffer.load, i32 %i.load.39
  %inputBuffer.load.elem.load = load i32, i32* %inputBuffer.load.elem.addr, align 4
  %input.load.2 = load i8*, i8** %input.addr.1, align 4
  %i.load.40 = load i32, i32* %i.addr.3, align 4
  %_str_ord.call.1 = call i32 @_str_ord(i8* %input.load.2, i32 %i.load.40)
  store i32 %_str_ord.call.1, i32* %inputBuffer.load.elem.addr, align 4
  br label %for.incr.8

for.exit.8:                                                ; preds =
  %inputBuffer.load.1 = load i32*, i32** @inputBuffer, align 4
  %input.load.3 = load i8*, i8** %input.addr.1, align 4
  %_str_length.call.2 = call i32 @_str_length(i8* %input.load.3)
  %sha1.call = call i32* @sha1(i32* %inputBuffer.load.1, i32 %_str_length.call.2)
  store i32* %sha1.call, i32** %result.addr.1, align 4
  %i.load.41 = load i32, i32* %i.addr.3, align 4
  store i32 0, i32* %i.addr.3, align 4
  br label %for.cond.9

for.cond.9:                                                ; preds =
  %i.load.42 = load i32, i32* %i.addr.3, align 4
  %result.load.7 = load i32*, i32** %result.addr.1, align 4
  %bitcast.8 = bitcast i32* %result.load.7 to i32*
  %getelementptr.10 = getelementptr inbounds i32, i32* %bitcast.8, i32 -1
  %getelementptr.10.load = load i32, i32* %getelementptr.10, align 4
  %icmp.25 = icmp slt i32 %i.load.42, %getelementptr.10.load
  br i1 %icmp.25, label %for.body.9, label %for.exit.9

for.incr.9:                                                ; preds =
  %i.load.43 = load i32, i32* %i.addr.3, align 4
  %add.25 = add i32 %i.load.43, 1
  store i32 %add.25, i32* %i.addr.3, align 4
  br label %for.cond.9

for.body.9:                                                ; preds =
  %result.load.8 = load i32*, i32** %result.addr.1, align 4
  %i.load.44 = load i32, i32* %i.addr.3, align 4
  %result.load.8.elem.addr = getelementptr inbounds i32, i32* %result.load.8, i32 %i.load.44
  %result.load.8.elem.load = load i32, i32* %result.load.8.elem.addr, align 4
  %toStringHex.call = call i8* @toStringHex(i32 %result.load.8.elem.load)
  call void @print(i8* %toStringHex.call)
  br label %for.incr.9

for.exit.9:                                                ; preds =
  %getelementptr.11 = getelementptr inbounds [1 x i8], [1 x i8]* @anon.strconst.1, i32 0, i32 0
  call void @println(i8* %getelementptr.11)
  br label %exit.19

}

define i32 @nextLetter(i32 %now) {

entry.20:                                                ; preds =
  %now.addr = alloca i32, align 4
  %internal.ret.addr.7 = alloca i32, align 4
  store i32 %now, i32* %now.addr, align 4
  %now.load = load i32, i32* %now.addr, align 4
  %icmp.26 = icmp eq i32 %now.load, 122
  br i1 %icmp.26, label %if.true.11, label %if.false.11

exit.20:                                                ; preds =
  %internal.ret.load.7 = load i32, i32* %internal.ret.addr.7, align 4
  ret i32 %internal.ret.load.7

if.true.11:                                                ; preds =
  %sub.22 = sub i32 0, 1
  store i32 %sub.22, i32* %internal.ret.addr.7, align 4
  br label %exit.20

if.false.11:                                                ; preds =
  br label %if.exit.11

if.exit.11:                                                ; preds =
  %now.load.1 = load i32, i32* %now.addr, align 4
  %icmp.27 = icmp eq i32 %now.load.1, 90
  br i1 %icmp.27, label %if.true.12, label %if.false.12

if.true.12:                                                ; preds =
  store i32 97, i32* %internal.ret.addr.7, align 4
  br label %exit.20

if.false.12:                                                ; preds =
  br label %if.exit.12

if.exit.12:                                                ; preds =
  %now.load.2 = load i32, i32* %now.addr, align 4
  %icmp.28 = icmp eq i32 %now.load.2, 57
  br i1 %icmp.28, label %if.true.13, label %if.false.13

if.true.13:                                                ; preds =
  store i32 65, i32* %internal.ret.addr.7, align 4
  br label %exit.20

if.false.13:                                                ; preds =
  br label %if.exit.13

if.exit.13:                                                ; preds =
  %now.load.3 = load i32, i32* %now.addr, align 4
  %add.26 = add i32 %now.load.3, 1
  store i32 %add.26, i32* %internal.ret.addr.7, align 4
  br label %exit.20

}

define i1 @nextText(i32* %now.1, i32 %length.1) {

entry.21:                                                ; preds =
  %i.addr.4 = alloca i32, align 4
  %length.addr.1 = alloca i32, align 4
  %now.addr.1 = alloca i32*, align 4
  %internal.ret.addr.8 = alloca i8, align 1
  store i32* %now.1, i32** %now.addr.1, align 4
  store i32 %length.1, i32* %length.addr.1, align 4
  %i.load.45 = load i32, i32* %i.addr.4, align 4
  %length.load.4 = load i32, i32* %length.addr.1, align 4
  %sub.23 = sub i32 %length.load.4, 1
  store i32 %sub.23, i32* %i.addr.4, align 4
  br label %for.cond.10

exit.21:                                                ; preds =
  %internal.ret.load.8 = load i8, i8* %internal.ret.addr.8, align 1
  %trunc = trunc i8 %internal.ret.load.8 to i1
  ret i1 %trunc

for.cond.10:                                                ; preds =
  %i.load.46 = load i32, i32* %i.addr.4, align 4
  %icmp.29 = icmp sge i32 %i.load.46, 0
  br i1 %icmp.29, label %for.body.10, label %for.exit.10

for.incr.10:                                                ; preds =
  %i.load.47 = load i32, i32* %i.addr.4, align 4
  %sub.24 = sub i32 %i.load.47, 1
  store i32 %sub.24, i32* %i.addr.4, align 4
  br label %for.cond.10

for.body.10:                                                ; preds =
  %now.load.4 = load i32*, i32** %now.addr.1, align 4
  %i.load.48 = load i32, i32* %i.addr.4, align 4
  %now.load.4.elem.addr = getelementptr inbounds i32, i32* %now.load.4, i32 %i.load.48
  %now.load.4.elem.load = load i32, i32* %now.load.4.elem.addr, align 4
  %now.load.5 = load i32*, i32** %now.addr.1, align 4
  %i.load.49 = load i32, i32* %i.addr.4, align 4
  %now.load.5.elem.addr = getelementptr inbounds i32, i32* %now.load.5, i32 %i.load.49
  %now.load.5.elem.load = load i32, i32* %now.load.5.elem.addr, align 4
  %nextLetter.call = call i32 @nextLetter(i32 %now.load.5.elem.load)
  store i32 %nextLetter.call, i32* %now.load.4.elem.addr, align 4
  %now.load.6 = load i32*, i32** %now.addr.1, align 4
  %i.load.50 = load i32, i32* %i.addr.4, align 4
  %now.load.6.elem.addr = getelementptr inbounds i32, i32* %now.load.6, i32 %i.load.50
  %now.load.6.elem.load = load i32, i32* %now.load.6.elem.addr, align 4
  %sub.25 = sub i32 0, 1
  %icmp.30 = icmp eq i32 %now.load.6.elem.load, %sub.25
  br i1 %icmp.30, label %if.true.14, label %if.false.14

for.exit.10:                                                ; preds =
  %zext.1 = zext i1 false to i8
  store i8 %zext.1, i8* %internal.ret.addr.8, align 1
  br label %exit.21

if.true.14:                                                ; preds =
  %now.load.7 = load i32*, i32** %now.addr.1, align 4
  %i.load.51 = load i32, i32* %i.addr.4, align 4
  %now.load.7.elem.addr = getelementptr inbounds i32, i32* %now.load.7, i32 %i.load.51
  %now.load.7.elem.load = load i32, i32* %now.load.7.elem.addr, align 4
  store i32 48, i32* %now.load.7.elem.addr, align 4
  br label %if.exit.14

if.false.14:                                                ; preds =
  %zext = zext i1 true to i8
  store i8 %zext, i8* %internal.ret.addr.8, align 1
  br label %exit.21

if.exit.14:                                                ; preds =
  br label %for.incr.10

}

define i1 @array_equal(i32* %a, i32* %b) {

entry.22:                                                ; preds =
  %i.addr.5 = alloca i32, align 4
  %b.addr.1 = alloca i32*, align 4
  %a.addr.1 = alloca i32*, align 4
  %internal.ret.addr.9 = alloca i8, align 1
  store i32* %a, i32** %a.addr.1, align 4
  store i32* %b, i32** %b.addr.1, align 4
  %a.load.4 = load i32*, i32** %a.addr.1, align 4
  %bitcast.9 = bitcast i32* %a.load.4 to i32*
  %getelementptr.12 = getelementptr inbounds i32, i32* %bitcast.9, i32 -1
  %getelementptr.12.load = load i32, i32* %getelementptr.12, align 4
  %b.load.9 = load i32*, i32** %b.addr.1, align 4
  %bitcast.10 = bitcast i32* %b.load.9 to i32*
  %getelementptr.13 = getelementptr inbounds i32, i32* %bitcast.10, i32 -1
  %getelementptr.13.load = load i32, i32* %getelementptr.13, align 4
  %icmp.31 = icmp ne i32 %getelementptr.12.load, %getelementptr.13.load
  br i1 %icmp.31, label %if.true.15, label %if.false.15

exit.22:                                                ; preds =
  %internal.ret.load.9 = load i8, i8* %internal.ret.addr.9, align 1
  %trunc.1 = trunc i8 %internal.ret.load.9 to i1
  ret i1 %trunc.1

if.true.15:                                                ; preds =
  %zext.2 = zext i1 false to i8
  store i8 %zext.2, i8* %internal.ret.addr.9, align 1
  br label %exit.22

if.false.15:                                                ; preds =
  br label %if.exit.15

if.exit.15:                                                ; preds =
  %i.load.52 = load i32, i32* %i.addr.5, align 4
  store i32 0, i32* %i.addr.5, align 4
  br label %for.cond.11

for.cond.11:                                                ; preds =
  %i.load.53 = load i32, i32* %i.addr.5, align 4
  %a.load.5 = load i32*, i32** %a.addr.1, align 4
  %bitcast.11 = bitcast i32* %a.load.5 to i32*
  %getelementptr.14 = getelementptr inbounds i32, i32* %bitcast.11, i32 -1
  %getelementptr.14.load = load i32, i32* %getelementptr.14, align 4
  %icmp.32 = icmp slt i32 %i.load.53, %getelementptr.14.load
  br i1 %icmp.32, label %for.body.11, label %for.exit.11

for.incr.11:                                                ; preds =
  %i.load.54 = load i32, i32* %i.addr.5, align 4
  %add.27 = add i32 %i.load.54, 1
  store i32 %add.27, i32* %i.addr.5, align 4
  br label %for.cond.11

for.body.11:                                                ; preds =
  %a.load.6 = load i32*, i32** %a.addr.1, align 4
  %i.load.55 = load i32, i32* %i.addr.5, align 4
  %a.load.6.elem.addr = getelementptr inbounds i32, i32* %a.load.6, i32 %i.load.55
  %a.load.6.elem.load = load i32, i32* %a.load.6.elem.addr, align 4
  %b.load.10 = load i32*, i32** %b.addr.1, align 4
  %i.load.56 = load i32, i32* %i.addr.5, align 4
  %b.load.10.elem.addr = getelementptr inbounds i32, i32* %b.load.10, i32 %i.load.56
  %b.load.10.elem.load = load i32, i32* %b.load.10.elem.addr, align 4
  %icmp.33 = icmp ne i32 %a.load.6.elem.load, %b.load.10.elem.load
  br i1 %icmp.33, label %if.true.16, label %if.false.16

for.exit.11:                                                ; preds =
  %zext.4 = zext i1 true to i8
  store i8 %zext.4, i8* %internal.ret.addr.9, align 1
  br label %exit.22

if.true.16:                                                ; preds =
  %zext.3 = zext i1 false to i8
  store i8 %zext.3, i8* %internal.ret.addr.9, align 1
  br label %exit.22

if.false.16:                                                ; preds =
  br label %if.exit.16

if.exit.16:                                                ; preds =
  br label %for.incr.11

}

define void @crackSHA1(i8* %input.2) {

entry.23:                                                ; preds =
  %out.addr = alloca i32*, align 4
  %digit.addr.2 = alloca i32, align 4
  %MAXDIGIT.addr = alloca i32, align 4
  %i.addr.6 = alloca i32, align 4
  %target.addr = alloca i32*, align 4
  %input.addr.2 = alloca i8*, align 4
  store i8* %input.2, i8** %input.addr.2, align 4
  %mul.10 = mul i32 5, 4
  %add.28 = add i32 %mul.10, 4
  %_bot_malloc.call.4 = call noalias i8* @_bot_malloc(i32 %add.28)
  %bitcast.12 = bitcast i8* %_bot_malloc.call.4 to i32*
  store i32 5, i32* %bitcast.12, align 4
  %getelementptr.15 = getelementptr inbounds i32, i32* %bitcast.12, i32 1
  %bitcast.13 = bitcast i32* %getelementptr.15 to i32*
  store i32* %bitcast.13, i32** %target.addr, align 4
  %input.load.4 = load i8*, i8** %input.addr.2, align 4
  %_str_length.call.3 = call i32 @_str_length(i8* %input.load.4)
  %icmp.34 = icmp ne i32 %_str_length.call.3, 40
  br i1 %icmp.34, label %if.true.17, label %if.false.17

exit.23:                                                ; preds =
  ret void

if.true.17:                                                ; preds =
  %getelementptr.16 = getelementptr inbounds [14 x i8], [14 x i8]* @anon.strconst.3, i32 0, i32 0
  call void @println(i8* %getelementptr.16)
  br label %exit.23

if.false.17:                                                ; preds =
  br label %if.exit.17

if.exit.17:                                                ; preds =
  %i.load.57 = load i32, i32* %i.addr.6, align 4
  store i32 0, i32* %i.addr.6, align 4
  br label %for.cond.12

for.cond.12:                                                ; preds =
  %i.load.58 = load i32, i32* %i.addr.6, align 4
  %icmp.35 = icmp slt i32 %i.load.58, 5
  br i1 %icmp.35, label %for.body.12, label %for.exit.12

for.incr.12:                                                ; preds =
  %i.load.59 = load i32, i32* %i.addr.6, align 4
  %add.29 = add i32 %i.load.59, 1
  store i32 %add.29, i32* %i.addr.6, align 4
  br label %for.cond.12

for.body.12:                                                ; preds =
  %target.load = load i32*, i32** %target.addr, align 4
  %i.load.60 = load i32, i32* %i.addr.6, align 4
  %target.load.elem.addr = getelementptr inbounds i32, i32* %target.load, i32 %i.load.60
  %target.load.elem.load = load i32, i32* %target.load.elem.addr, align 4
  store i32 0, i32* %target.load.elem.addr, align 4
  br label %for.incr.12

for.exit.12:                                                ; preds =
  %i.load.61 = load i32, i32* %i.addr.6, align 4
  store i32 0, i32* %i.addr.6, align 4
  br label %for.cond.13

for.cond.13:                                                ; preds =
  %i.load.62 = load i32, i32* %i.addr.6, align 4
  %icmp.36 = icmp slt i32 %i.load.62, 40
  br i1 %icmp.36, label %for.body.13, label %for.exit.13

for.incr.13:                                                ; preds =
  %i.load.63 = load i32, i32* %i.addr.6, align 4
  %i.load.64 = load i32, i32* %i.addr.6, align 4
  %add.30 = add i32 %i.load.64, 4
  store i32 %add.30, i32* %i.addr.6, align 4
  br label %for.cond.13

for.body.13:                                                ; preds =
  %target.load.1 = load i32*, i32** %target.addr, align 4
  %i.load.65 = load i32, i32* %i.addr.6, align 4
  %sdiv.9 = sdiv i32 %i.load.65, 8
  %target.load.1.elem.addr = getelementptr inbounds i32, i32* %target.load.1, i32 %sdiv.9
  %target.load.1.elem.load = load i32, i32* %target.load.1.elem.addr, align 4
  %target.load.2 = load i32*, i32** %target.addr, align 4
  %i.load.66 = load i32, i32* %i.addr.6, align 4
  %sdiv.10 = sdiv i32 %i.load.66, 8
  %target.load.2.elem.addr = getelementptr inbounds i32, i32* %target.load.2, i32 %sdiv.10
  %target.load.2.elem.load = load i32, i32* %target.load.2.elem.addr, align 4
  %input.load.5 = load i8*, i8** %input.addr.2, align 4
  %i.load.67 = load i32, i32* %i.addr.6, align 4
  %i.load.68 = load i32, i32* %i.addr.6, align 4
  %add.31 = add i32 %i.load.68, 4
  %_str_substring.call.1 = call i8* @_str_substring(i8* %input.load.5, i32 %i.load.67, i32 %add.31)
  %hex2int.call = call i32 @hex2int(i8* %_str_substring.call.1)
  %i.load.69 = load i32, i32* %i.addr.6, align 4
  %sdiv.11 = sdiv i32 %i.load.69, 4
  %srem.6 = srem i32 %sdiv.11, 2
  %sub.26 = sub i32 1, %srem.6
  %mul.11 = mul i32 %sub.26, 16
  %shl.10 = shl i32 %hex2int.call, %mul.11
  %or.10 = or i32 %target.load.2.elem.load, %shl.10
  store i32 %or.10, i32* %target.load.1.elem.addr, align 4
  br label %for.incr.13

for.exit.13:                                                ; preds =
  store i32 4, i32* %MAXDIGIT.addr, align 4
  %digit.load.12 = load i32, i32* %digit.addr.2, align 4
  store i32 1, i32* %digit.addr.2, align 4
  br label %for.cond.14

for.cond.14:                                                ; preds =
  %digit.load.13 = load i32, i32* %digit.addr.2, align 4
  %MAXDIGIT.load = load i32, i32* %MAXDIGIT.addr, align 4
  %icmp.37 = icmp sle i32 %digit.load.13, %MAXDIGIT.load
  br i1 %icmp.37, label %for.body.14, label %for.exit.14

for.incr.14:                                                ; preds =
  %digit.load.14 = load i32, i32* %digit.addr.2, align 4
  %add.32 = add i32 %digit.load.14, 1
  store i32 %add.32, i32* %digit.addr.2, align 4
  br label %for.cond.14

for.body.14:                                                ; preds =
  %i.load.70 = load i32, i32* %i.addr.6, align 4
  store i32 0, i32* %i.addr.6, align 4
  br label %for.cond.15

for.exit.14:                                                ; preds =
  %getelementptr.18 = getelementptr inbounds [11 x i8], [11 x i8]* @anon.strconst.4, i32 0, i32 0
  call void @println(i8* %getelementptr.18)
  br label %exit.23

for.cond.15:                                                ; preds =
  %i.load.71 = load i32, i32* %i.addr.6, align 4
  %digit.load.15 = load i32, i32* %digit.addr.2, align 4
  %icmp.38 = icmp slt i32 %i.load.71, %digit.load.15
  br i1 %icmp.38, label %for.body.15, label %for.exit.15

for.incr.15:                                                ; preds =
  %i.load.72 = load i32, i32* %i.addr.6, align 4
  %add.33 = add i32 %i.load.72, 1
  store i32 %add.33, i32* %i.addr.6, align 4
  br label %for.cond.15

for.body.15:                                                ; preds =
  %inputBuffer.load.2 = load i32*, i32** @inputBuffer, align 4
  %i.load.73 = load i32, i32* %i.addr.6, align 4
  %inputBuffer.load.2.elem.addr = getelementptr inbounds i32, i32* %inputBuffer.load.2, i32 %i.load.73
  %inputBuffer.load.2.elem.load = load i32, i32* %inputBuffer.load.2.elem.addr, align 4
  store i32 48, i32* %inputBuffer.load.2.elem.addr, align 4
  br label %for.incr.15

for.exit.15:                                                ; preds =
  br label %wh.cond.1

wh.cond.1:                                                ; preds =
  br i1 true, label %wh.body.1, label %wh.exit.1

wh.body.1:                                                ; preds =
  %inputBuffer.load.3 = load i32*, i32** @inputBuffer, align 4
  %digit.load.16 = load i32, i32* %digit.addr.2, align 4
  %sha1.call.1 = call i32* @sha1(i32* %inputBuffer.load.3, i32 %digit.load.16)
  store i32* %sha1.call.1, i32** %out.addr, align 4
  %out.load = load i32*, i32** %out.addr, align 4
  %target.load.3 = load i32*, i32** %target.addr, align 4
  %array_equal.call = call i1 @array_equal(i32* %out.load, i32* %target.load.3)
  br i1 %array_equal.call, label %if.true.18, label %if.false.18

wh.exit.1:                                                ; preds =
  br label %for.incr.14

if.true.18:                                                ; preds =
  %i.load.74 = load i32, i32* %i.addr.6, align 4
  store i32 0, i32* %i.addr.6, align 4
  br label %for.cond.16

if.false.18:                                                ; preds =
  br label %if.exit.18

if.exit.18:                                                ; preds =
  %inputBuffer.load.5 = load i32*, i32** @inputBuffer, align 4
  %digit.load.18 = load i32, i32* %digit.addr.2, align 4
  %nextText.call = call i1 @nextText(i32* %inputBuffer.load.5, i32 %digit.load.18)
  %xor.8 = xor i1 %nextText.call, true
  br i1 %xor.8, label %if.true.19, label %if.false.19

for.cond.16:                                                ; preds =
  %i.load.75 = load i32, i32* %i.addr.6, align 4
  %digit.load.17 = load i32, i32* %digit.addr.2, align 4
  %icmp.39 = icmp slt i32 %i.load.75, %digit.load.17
  br i1 %icmp.39, label %for.body.16, label %for.exit.16

for.incr.16:                                                ; preds =
  %i.load.76 = load i32, i32* %i.addr.6, align 4
  %add.34 = add i32 %i.load.76, 1
  store i32 %add.34, i32* %i.addr.6, align 4
  br label %for.cond.16

for.body.16:                                                ; preds =
  %inputBuffer.load.4 = load i32*, i32** @inputBuffer, align 4
  %i.load.77 = load i32, i32* %i.addr.6, align 4
  %inputBuffer.load.4.elem.addr = getelementptr inbounds i32, i32* %inputBuffer.load.4, i32 %i.load.77
  %inputBuffer.load.4.elem.load = load i32, i32* %inputBuffer.load.4.elem.addr, align 4
  %int2chr.call.2 = call i8* @int2chr(i32 %inputBuffer.load.4.elem.load)
  call void @print(i8* %int2chr.call.2)
  br label %for.incr.16

for.exit.16:                                                ; preds =
  %getelementptr.17 = getelementptr inbounds [1 x i8], [1 x i8]* @anon.strconst.1, i32 0, i32 0
  call void @println(i8* %getelementptr.17)
  br label %exit.23

if.true.19:                                                ; preds =
  br label %wh.exit.1

if.false.19:                                                ; preds =
  br label %if.exit.19

if.exit.19:                                                ; preds =
  br label %wh.cond.1

}

define i32 @main() {

entry.24:                                                ; preds =
  %input.addr.3 = alloca i8*, align 4
  %op.addr = alloca i32, align 4
  %internal.ret.addr.10 = alloca i32, align 4
  call void @_glb_init()
  store i32 0, i32* %internal.ret.addr.10, align 4
  br label %wh.cond.2

exit.24:                                                ; preds =
  %internal.ret.load.10 = load i32, i32* %internal.ret.addr.10, align 4
  ret i32 %internal.ret.load.10

wh.cond.2:                                                ; preds =
  br i1 true, label %wh.body.2, label %wh.exit.2

wh.body.2:                                                ; preds =
  %op.load = load i32, i32* %op.addr, align 4
  %getInt.call = call i32 @getInt()
  store i32 %getInt.call, i32* %op.addr, align 4
  %op.load.1 = load i32, i32* %op.addr, align 4
  %icmp.40 = icmp eq i32 %op.load.1, 0
  br i1 %icmp.40, label %if.true.20, label %if.false.20

wh.exit.2:                                                ; preds =
  store i32 0, i32* %internal.ret.addr.10, align 4
  br label %exit.24

if.true.20:                                                ; preds =
  br label %wh.exit.2

if.false.20:                                                ; preds =
  br label %if.exit.20

if.exit.20:                                                ; preds =
  %op.load.2 = load i32, i32* %op.addr, align 4
  %icmp.41 = icmp eq i32 %op.load.2, 1
  br i1 %icmp.41, label %if.true.21, label %if.false.21

if.true.21:                                                ; preds =
  %input.load.8 = load i8*, i8** %input.addr.3, align 4
  %getString.call.1 = call i8* @getString()
  store i8* %getString.call.1, i8** %input.addr.3, align 4
  %input.load.9 = load i8*, i8** %input.addr.3, align 4
  call void @computeSHA1(i8* %input.load.9)
  br label %if.exit.21

if.false.21:                                                ; preds =
  %op.load.3 = load i32, i32* %op.addr, align 4
  %icmp.42 = icmp eq i32 %op.load.3, 2
  br i1 %icmp.42, label %if.true.22, label %if.false.22

if.exit.21:                                                ; preds =
  br label %wh.cond.2

if.true.22:                                                ; preds =
  %input.load.6 = load i8*, i8** %input.addr.3, align 4
  %getString.call = call i8* @getString()
  store i8* %getString.call, i8** %input.addr.3, align 4
  %input.load.7 = load i8*, i8** %input.addr.3, align 4
  call void @crackSHA1(i8* %input.load.7)
  br label %if.exit.22

if.false.22:                                                ; preds =
  br label %if.exit.22

if.exit.22:                                                ; preds =
  br label %if.exit.21

}