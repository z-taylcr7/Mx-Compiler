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
@m = global i32 zeroinitializer, align 4
@g = global %class.EdgeList* zeroinitializer, align 8
@INF = global i32 zeroinitializer, align 4

@anonym.strconst = private unnamed_addr constant [ 10 x i8 ] c"dij start\00", align 1
@anonym.strconst.1 = private unnamed_addr constant [ 15 x i8 ] c"visit continue\00", align 1
@anonym.strconst.2 = private unnamed_addr constant [ 13 x i8 ] c"newing start\00", align 1
@anonym.strconst.3 = private unnamed_addr constant [ 12 x i8 ] c"newing over\00", align 1
@anonym.strconst.4 = private unnamed_addr constant [ 3 x i8 ] c"-1\00", align 1
@anonym.strconst.5 = private unnamed_addr constant [ 2 x i8 ] c" \00", align 1
@anonym.strconst.6 = private unnamed_addr constant [ 1 x i8 ] c"\00", align 1

%class.Edge = type {i32, i32, i32}
%class.EdgeList = type {%class.Edge**, i32*, i32*, i32}
%class.Array_Node = type {%class.Node**, i32}
%class.Heap_Node = type {%class.Array_Node*}
%class.Node = type {i32, i32}

define void @_global_init()
{

entry.11:                       ;prevs = 
 store %class.EdgeList* null, %class.EdgeList** @g, align 8
 store i32 10000000,i32* @INF, align 4
 br label %exit.11

exit.11:                       ;prevs = 
 ret void

}

define void @Edge.Edge(%class.Edge* %internal.this)
{

entry.12:                       ;prevs = 
 %size.addr = alloca  i32, align 4
 %first.addr = alloca  i32*, align 8
 %next.addr = alloca  i32*, align 8
 %edges.addr = alloca  %class.Edge**, align 8
 br label %exit.12

exit.12:                       ;prevs = 
 ret void

}

define void @EdgeList.EdgeList(%class.EdgeList* %internal.this.1)
{

entry.13:                       ;prevs = 
 br label %exit.13

exit.13:                       ;prevs = 
 ret void

}

define void @init.init(%class.EdgeList* %internal.this.2, i32 %n.1, i32 %m.1)
{

entry.14:                       ;prevs = 
 %i.addr = alloca  i32, align 4
 %m.addr = alloca  i32, align 4
 %n.addr = alloca  i32, align 4
 store i32 %n.1,i32* %n.addr, align 4
 store i32 %m.1,i32* %m.addr, align 4
 %edges.addr.1 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.2, i32 0, i32 0
 %edges.load = load %class.Edge**, %class.Edge*** %edges.addr.1, align 8
 %m.load = load i32, i32* %m.addr, align 4
 %mul = mul i32 %m.load , 8
 %add = add i32 %mul , 4
 %_bot_malloc.call = call noalias i8* @_bot_malloc(i32 %add)
 %bitcast = bitcast i8* %_bot_malloc.call to i32*
 store i32 %m.load,i32* %bitcast, align 4
 %getelementptr = getelementptr inbounds i32, i32* %bitcast, i32 1
 %bitcast.1 = bitcast i32* %getelementptr to %class.Edge**
 store %class.Edge** %bitcast.1,%class.Edge*** %edges.addr.1, align 8
 %next.addr.1 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.2, i32 0, i32 1
 %next.load = load i32*, i32** %next.addr.1, align 8
 %m.load.1 = load i32, i32* %m.addr, align 4
 %mul.1 = mul i32 %m.load.1 , 4
 %add.1 = add i32 %mul.1 , 4
 %_bot_malloc.call.1 = call noalias i8* @_bot_malloc(i32 %add.1)
 %bitcast.2 = bitcast i8* %_bot_malloc.call.1 to i32*
 store i32 %m.load.1,i32* %bitcast.2, align 4
 %getelementptr.1 = getelementptr inbounds i32, i32* %bitcast.2, i32 1
 %bitcast.3 = bitcast i32* %getelementptr.1 to i32*
 store i32* %bitcast.3,i32** %next.addr.1, align 8
 %first.addr.1 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.2, i32 0, i32 2
 %first.load = load i32*, i32** %first.addr.1, align 8
 %n.load = load i32, i32* %n.addr, align 4
 %mul.2 = mul i32 %n.load , 4
 %add.2 = add i32 %mul.2 , 4
 %_bot_malloc.call.2 = call noalias i8* @_bot_malloc(i32 %add.2)
 %bitcast.4 = bitcast i8* %_bot_malloc.call.2 to i32*
 store i32 %n.load,i32* %bitcast.4, align 4
 %getelementptr.2 = getelementptr inbounds i32, i32* %bitcast.4, i32 1
 %bitcast.5 = bitcast i32* %getelementptr.2 to i32*
 store i32* %bitcast.5,i32** %first.addr.1, align 8
 %i.load = load i32, i32* %i.addr, align 4
 store i32 0,i32* %i.addr, align 4
 br label %for.cond

exit.14:                       ;prevs = 
 ret void

for.cond:                       ;prevs = 
 %i.load.1 = load i32, i32* %i.addr, align 4
 %m.load.2 = load i32, i32* %m.addr, align 4
 %slt = icmp slt i32 %i.load.1 , %m.load.2
 br i1 %slt , label %for.body , label %for.exit

for.incr:                       ;prevs = 
 %i.load.2 = load i32, i32* %i.addr, align 4
 %add.3 = add i32 %i.load.2 , 1
 store i32 %add.3,i32* %i.addr, align 4
 br label %for.cond

for.body:                       ;prevs = 
 %i.load.3 = load i32, i32* %i.addr, align 4
 %next.addr.2 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.2, i32 0, i32 1
 %next.load.1 = load i32*, i32** %next.addr.2, align 8
 %next.load.1.elem.addr = getelementptr inbounds i32, i32* %next.load.1, i32 %i.load.3
 %next.load.1.elem.load = load i32, i32* %next.load.1.elem.addr, align 4
 %sub = sub i32 0 , 1
 store i32 %sub,i32* %next.load.1.elem.addr, align 4
 br label %for.incr

for.exit:                       ;prevs = 
 %i.load.4 = load i32, i32* %i.addr, align 4
 store i32 0,i32* %i.addr, align 4
 br label %for.cond.1

for.cond.1:                       ;prevs = 
 %i.load.5 = load i32, i32* %i.addr, align 4
 %n.load.1 = load i32, i32* %n.addr, align 4
 %slt.1 = icmp slt i32 %i.load.5 , %n.load.1
 br i1 %slt.1 , label %for.body.1 , label %for.exit.1

for.incr.1:                       ;prevs = 
 %i.load.6 = load i32, i32* %i.addr, align 4
 %add.4 = add i32 %i.load.6 , 1
 store i32 %add.4,i32* %i.addr, align 4
 br label %for.cond.1

for.body.1:                       ;prevs = 
 %i.load.7 = load i32, i32* %i.addr, align 4
 %first.addr.2 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.2, i32 0, i32 2
 %first.load.1 = load i32*, i32** %first.addr.2, align 8
 %first.load.1.elem.addr = getelementptr inbounds i32, i32* %first.load.1, i32 %i.load.7
 %first.load.1.elem.load = load i32, i32* %first.load.1.elem.addr, align 4
 %sub.1 = sub i32 0 , 1
 store i32 %sub.1,i32* %first.load.1.elem.addr, align 4
 br label %for.incr.1

for.exit.1:                       ;prevs = 
 %size.addr.1 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.2, i32 0, i32 3
 %size.load = load i32, i32* %size.addr.1, align 4
 store i32 0,i32* %size.addr.1, align 4
 br label %exit.14

}

define void @addEdge.addEdge(%class.EdgeList* %internal.this.3, i32 %u, i32 %v, i32 %w)
{

entry.15:                       ;prevs = 
 %e.addr = alloca  %class.Edge*, align 8
 %w.addr = alloca  i32, align 4
 %v.addr = alloca  i32, align 4
 %u.addr = alloca  i32, align 4
 store i32 %u,i32* %u.addr, align 4
 store i32 %v,i32* %v.addr, align 4
 store i32 %w,i32* %w.addr, align 4
 %_bot_malloc.call.3 = call noalias i8* @_bot_malloc(i32 12)
 %bitcast.6 = bitcast i8* %_bot_malloc.call.3 to %class.Edge*
 call void @Edge.Edge(%class.Edge* %bitcast.6)
 store %class.Edge* %bitcast.6,%class.Edge** %e.addr, align 8
 %e.load = load %class.Edge*, %class.Edge** %e.addr, align 8
 %from.addr = getelementptr inbounds %class.Edge, %class.Edge* %e.load, i32 0, i32 0
 %from.load = load i32, i32* %from.addr, align 4
 %u.load = load i32, i32* %u.addr, align 4
 store i32 %u.load,i32* %from.addr, align 4
 %e.load.1 = load %class.Edge*, %class.Edge** %e.addr, align 8
 %to.addr = getelementptr inbounds %class.Edge, %class.Edge* %e.load.1, i32 0, i32 1
 %to.load = load i32, i32* %to.addr, align 4
 %v.load = load i32, i32* %v.addr, align 4
 store i32 %v.load,i32* %to.addr, align 4
 %e.load.2 = load %class.Edge*, %class.Edge** %e.addr, align 8
 %weight.addr = getelementptr inbounds %class.Edge, %class.Edge* %e.load.2, i32 0, i32 2
 %weight.load = load i32, i32* %weight.addr, align 4
 %w.load = load i32, i32* %w.addr, align 4
 store i32 %w.load,i32* %weight.addr, align 4
 %size.addr.2 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.3, i32 0, i32 3
 %size.load.1 = load i32, i32* %size.addr.2, align 4
 %edges.addr.2 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.3, i32 0, i32 0
 %edges.load.1 = load %class.Edge**, %class.Edge*** %edges.addr.2, align 8
 %edges.load.1.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %edges.load.1, i32 %size.load.1
 %edges.load.1.elem.load = load %class.Edge*, %class.Edge** %edges.load.1.elem.addr, align 8
 %e.load.3 = load %class.Edge*, %class.Edge** %e.addr, align 8
 store %class.Edge* %e.load.3,%class.Edge** %edges.load.1.elem.addr, align 8
 %size.addr.3 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.3, i32 0, i32 3
 %size.load.2 = load i32, i32* %size.addr.3, align 4
 %next.addr.3 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.3, i32 0, i32 1
 %next.load.2 = load i32*, i32** %next.addr.3, align 8
 %next.load.2.elem.addr = getelementptr inbounds i32, i32* %next.load.2, i32 %size.load.2
 %next.load.2.elem.load = load i32, i32* %next.load.2.elem.addr, align 4
 %u.load.1 = load i32, i32* %u.addr, align 4
 %first.addr.3 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.3, i32 0, i32 2
 %first.load.2 = load i32*, i32** %first.addr.3, align 8
 %first.load.2.elem.addr = getelementptr inbounds i32, i32* %first.load.2, i32 %u.load.1
 %first.load.2.elem.load = load i32, i32* %first.load.2.elem.addr, align 4
 store i32 %first.load.2.elem.load,i32* %next.load.2.elem.addr, align 4
 %u.load.2 = load i32, i32* %u.addr, align 4
 %first.addr.4 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.3, i32 0, i32 2
 %first.load.3 = load i32*, i32** %first.addr.4, align 8
 %first.load.3.elem.addr = getelementptr inbounds i32, i32* %first.load.3, i32 %u.load.2
 %first.load.3.elem.load = load i32, i32* %first.load.3.elem.addr, align 4
 %size.addr.4 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.3, i32 0, i32 3
 %size.load.3 = load i32, i32* %size.addr.4, align 4
 store i32 %size.load.3,i32* %first.load.3.elem.addr, align 4
 %size.addr.5 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.3, i32 0, i32 3
 %size.load.4 = load i32, i32* %size.addr.5, align 4
 %add.5 = add i32 %size.load.4 , 1
 store i32 %add.5,i32* %size.addr.5, align 4
 br label %exit.15

exit.15:                       ;prevs = 
 ret void

}

define i32 @nVertices.nVertices(%class.EdgeList* %internal.this.4)
{

entry.16:                       ;prevs = 
 %internal.ret.addr = alloca  i32, align 4
 %first.addr.5 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.4, i32 0, i32 2
 %first.load.4 = load i32*, i32** %first.addr.5, align 8
 %bitcast.7 = bitcast i32* %first.load.4 to i32*
 %getelementptr.3 = getelementptr inbounds i32, i32* %bitcast.7, i32 -1
 %getelementptr.3.load = load i32, i32* %getelementptr.3, align 4
 store i32 %getelementptr.3.load,i32* %internal.ret.addr, align 4
 br label %exit.16

exit.16:                       ;prevs = 
 %internal.ret.load = load i32, i32* %internal.ret.addr, align 4
 ret i32 %internal.ret.load

}

define i32 @nEdges.nEdges(%class.EdgeList* %internal.this.5)
{

entry.17:                       ;prevs = 
 %sz.addr = alloca  i32, align 4
 %storage.addr = alloca  %class.Node**, align 8
 %internal.ret.addr.1 = alloca  i32, align 4
 %edges.addr.3 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %internal.this.5, i32 0, i32 0
 %edges.load.2 = load %class.Edge**, %class.Edge*** %edges.addr.3, align 8
 %bitcast.8 = bitcast %class.Edge** %edges.load.2 to i32*
 %getelementptr.4 = getelementptr inbounds i32, i32* %bitcast.8, i32 -1
 %getelementptr.4.load = load i32, i32* %getelementptr.4, align 4
 store i32 %getelementptr.4.load,i32* %internal.ret.addr.1, align 4
 br label %exit.17

exit.17:                       ;prevs = 
 %internal.ret.load.1 = load i32, i32* %internal.ret.addr.1, align 4
 ret i32 %internal.ret.load.1

}

define void @Array_Node.Array_Node(%class.Array_Node* %internal.this.6)
{

entry.18:                       ;prevs = 
 %sz.addr.1 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.6, i32 0, i32 1
 %sz.load = load i32, i32* %sz.addr.1, align 4
 store i32 0,i32* %sz.addr.1, align 4
 %storage.addr.1 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.6, i32 0, i32 0
 %storage.load = load %class.Node**, %class.Node*** %storage.addr.1, align 8
 %mul.3 = mul i32 16 , 8
 %add.6 = add i32 %mul.3 , 4
 %_bot_malloc.call.4 = call noalias i8* @_bot_malloc(i32 %add.6)
 %bitcast.9 = bitcast i8* %_bot_malloc.call.4 to i32*
 store i32 16,i32* %bitcast.9, align 4
 %getelementptr.5 = getelementptr inbounds i32, i32* %bitcast.9, i32 1
 %bitcast.10 = bitcast i32* %getelementptr.5 to %class.Node**
 store %class.Node** %bitcast.10,%class.Node*** %storage.addr.1, align 8
 br label %exit.18

exit.18:                       ;prevs = 
 ret void

}

define void @push_back.push_back(%class.Array_Node* %internal.this.7, %class.Node* %v.1)
{

entry.19:                       ;prevs = 
 %v.addr.1 = alloca  %class.Node*, align 8
 store %class.Node* %v.1,%class.Node** %v.addr.1, align 8
 %size.size.call = call i32 @size.size(%class.Array_Node* %internal.this.7)
 %storage.addr.2 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.7, i32 0, i32 0
 %storage.load.1 = load %class.Node**, %class.Node*** %storage.addr.2, align 8
 %bitcast.11 = bitcast %class.Node** %storage.load.1 to i32*
 %getelementptr.6 = getelementptr inbounds i32, i32* %bitcast.11, i32 -1
 %getelementptr.6.load = load i32, i32* %getelementptr.6, align 4
 %eq = icmp eq i32 %size.size.call , %getelementptr.6.load
 br i1 %eq , label %if.true , label %if.false

exit.19:                       ;prevs = 
 ret void

if.true:                       ;prevs = 
 call void @doubleStorage.doubleStorage(%class.Array_Node* %internal.this.7)
 br label %if.exit

if.false:                       ;prevs = 
 br label %if.exit

if.exit:                       ;prevs = 
 %sz.addr.2 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.7, i32 0, i32 1
 %sz.load.1 = load i32, i32* %sz.addr.2, align 4
 %storage.addr.3 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.7, i32 0, i32 0
 %storage.load.2 = load %class.Node**, %class.Node*** %storage.addr.3, align 8
 %storage.load.2.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.2, i32 %sz.load.1
 %storage.load.2.elem.load = load %class.Node*, %class.Node** %storage.load.2.elem.addr, align 8
 %v.load.1 = load %class.Node*, %class.Node** %v.addr.1, align 8
 store %class.Node* %v.load.1,%class.Node** %storage.load.2.elem.addr, align 8
 %sz.addr.3 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.7, i32 0, i32 1
 %sz.load.2 = load i32, i32* %sz.addr.3, align 4
 %add.7 = add i32 %sz.load.2 , 1
 store i32 %add.7,i32* %sz.addr.3, align 4
 br label %exit.19

}

define %class.Node* @pop_back.pop_back(%class.Array_Node* %internal.this.8)
{

entry.20:                       ;prevs = 
 %internal.ret.addr.2 = alloca  %class.Node*, align 8
 %sz.addr.4 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.8, i32 0, i32 1
 %sz.load.3 = load i32, i32* %sz.addr.4, align 4
 %add.8 = add i32 %sz.load.3 , -1
 store i32 %add.8,i32* %sz.addr.4, align 4
 %sz.addr.5 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.8, i32 0, i32 1
 %sz.load.4 = load i32, i32* %sz.addr.5, align 4
 %storage.addr.4 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.8, i32 0, i32 0
 %storage.load.3 = load %class.Node**, %class.Node*** %storage.addr.4, align 8
 %storage.load.3.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.3, i32 %sz.load.4
 %storage.load.3.elem.load = load %class.Node*, %class.Node** %storage.load.3.elem.addr, align 8
 store %class.Node* %storage.load.3.elem.load,%class.Node** %internal.ret.addr.2, align 8
 br label %exit.20

exit.20:                       ;prevs = 
 %internal.ret.load.2 = load %class.Node*, %class.Node** %internal.ret.addr.2, align 8
 ret %class.Node* %internal.ret.load.2

}

define %class.Node* @back.back(%class.Array_Node* %internal.this.9)
{

entry.21:                       ;prevs = 
 %internal.ret.addr.3 = alloca  %class.Node*, align 8
 %sz.addr.6 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.9, i32 0, i32 1
 %sz.load.5 = load i32, i32* %sz.addr.6, align 4
 %sub.2 = sub i32 %sz.load.5 , 1
 %storage.addr.5 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.9, i32 0, i32 0
 %storage.load.4 = load %class.Node**, %class.Node*** %storage.addr.5, align 8
 %storage.load.4.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.4, i32 %sub.2
 %storage.load.4.elem.load = load %class.Node*, %class.Node** %storage.load.4.elem.addr, align 8
 store %class.Node* %storage.load.4.elem.load,%class.Node** %internal.ret.addr.3, align 8
 br label %exit.21

exit.21:                       ;prevs = 
 %internal.ret.load.3 = load %class.Node*, %class.Node** %internal.ret.addr.3, align 8
 ret %class.Node* %internal.ret.load.3

}

define %class.Node* @front.front(%class.Array_Node* %internal.this.10)
{

entry.22:                       ;prevs = 
 %internal.ret.addr.4 = alloca  %class.Node*, align 8
 %storage.addr.6 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.10, i32 0, i32 0
 %storage.load.5 = load %class.Node**, %class.Node*** %storage.addr.6, align 8
 %storage.load.5.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.5, i32 0
 %storage.load.5.elem.load = load %class.Node*, %class.Node** %storage.load.5.elem.addr, align 8
 store %class.Node* %storage.load.5.elem.load,%class.Node** %internal.ret.addr.4, align 8
 br label %exit.22

exit.22:                       ;prevs = 
 %internal.ret.load.4 = load %class.Node*, %class.Node** %internal.ret.addr.4, align 8
 ret %class.Node* %internal.ret.load.4

}

define i32 @size.size(%class.Array_Node* %internal.this.11)
{

entry.23:                       ;prevs = 
 %internal.ret.addr.5 = alloca  i32, align 4
 %sz.addr.7 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.11, i32 0, i32 1
 %sz.load.6 = load i32, i32* %sz.addr.7, align 4
 store i32 %sz.load.6,i32* %internal.ret.addr.5, align 4
 br label %exit.23

exit.23:                       ;prevs = 
 %internal.ret.load.5 = load i32, i32* %internal.ret.addr.5, align 4
 ret i32 %internal.ret.load.5

}

define void @resize.resize(%class.Array_Node* %internal.this.12, i32 %newSize)
{

entry.24:                       ;prevs = 
 %newSize.addr = alloca  i32, align 4
 store i32 %newSize,i32* %newSize.addr, align 4
 br label %wh.cond

exit.24:                       ;prevs = 
 ret void

wh.cond:                       ;prevs = 
 %storage.addr.7 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.12, i32 0, i32 0
 %storage.load.6 = load %class.Node**, %class.Node*** %storage.addr.7, align 8
 %bitcast.12 = bitcast %class.Node** %storage.load.6 to i32*
 %getelementptr.7 = getelementptr inbounds i32, i32* %bitcast.12, i32 -1
 %getelementptr.7.load = load i32, i32* %getelementptr.7, align 4
 %newSize.load = load i32, i32* %newSize.addr, align 4
 %slt.2 = icmp slt i32 %getelementptr.7.load , %newSize.load
 br i1 %slt.2 , label %wh.body , label %wh.exit

wh.body:                       ;prevs = 
 call void @doubleStorage.doubleStorage(%class.Array_Node* %internal.this.12)
 br label %wh.cond

wh.exit:                       ;prevs = 
 %sz.addr.8 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.12, i32 0, i32 1
 %sz.load.7 = load i32, i32* %sz.addr.8, align 4
 %newSize.load.1 = load i32, i32* %newSize.addr, align 4
 store i32 %newSize.load.1,i32* %sz.addr.8, align 4
 br label %exit.24

}

define %class.Node* @get.get(%class.Array_Node* %internal.this.13, i32 %i)
{

entry.25:                       ;prevs = 
 %i.addr.1 = alloca  i32, align 4
 %internal.ret.addr.6 = alloca  %class.Node*, align 8
 store i32 %i,i32* %i.addr.1, align 4
 %i.load.8 = load i32, i32* %i.addr.1, align 4
 %storage.addr.8 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.13, i32 0, i32 0
 %storage.load.7 = load %class.Node**, %class.Node*** %storage.addr.8, align 8
 %storage.load.7.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.7, i32 %i.load.8
 %storage.load.7.elem.load = load %class.Node*, %class.Node** %storage.load.7.elem.addr, align 8
 store %class.Node* %storage.load.7.elem.load,%class.Node** %internal.ret.addr.6, align 8
 br label %exit.25

exit.25:                       ;prevs = 
 %internal.ret.load.6 = load %class.Node*, %class.Node** %internal.ret.addr.6, align 8
 ret %class.Node* %internal.ret.load.6

}

define void @set.set(%class.Array_Node* %internal.this.14, i32 %i.1, %class.Node* %v.2)
{

entry.26:                       ;prevs = 
 %v.addr.2 = alloca  %class.Node*, align 8
 %i.addr.2 = alloca  i32, align 4
 store i32 %i.1,i32* %i.addr.2, align 4
 store %class.Node* %v.2,%class.Node** %v.addr.2, align 8
 %i.load.9 = load i32, i32* %i.addr.2, align 4
 %storage.addr.9 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.14, i32 0, i32 0
 %storage.load.8 = load %class.Node**, %class.Node*** %storage.addr.9, align 8
 %storage.load.8.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.8, i32 %i.load.9
 %storage.load.8.elem.load = load %class.Node*, %class.Node** %storage.load.8.elem.addr, align 8
 %v.load.2 = load %class.Node*, %class.Node** %v.addr.2, align 8
 store %class.Node* %v.load.2,%class.Node** %storage.load.8.elem.addr, align 8
 br label %exit.26

exit.26:                       ;prevs = 
 ret void

}

define void @swap.swap(%class.Array_Node* %internal.this.15, i32 %i.2, i32 %j)
{

entry.27:                       ;prevs = 
 %t.addr = alloca  %class.Node*, align 8
 %j.addr = alloca  i32, align 4
 %i.addr.3 = alloca  i32, align 4
 store i32 %i.2,i32* %i.addr.3, align 4
 store i32 %j,i32* %j.addr, align 4
 %i.load.10 = load i32, i32* %i.addr.3, align 4
 %storage.addr.10 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.15, i32 0, i32 0
 %storage.load.9 = load %class.Node**, %class.Node*** %storage.addr.10, align 8
 %storage.load.9.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.9, i32 %i.load.10
 %storage.load.9.elem.load = load %class.Node*, %class.Node** %storage.load.9.elem.addr, align 8
 store %class.Node* %storage.load.9.elem.load,%class.Node** %t.addr, align 8
 %i.load.11 = load i32, i32* %i.addr.3, align 4
 %storage.addr.11 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.15, i32 0, i32 0
 %storage.load.10 = load %class.Node**, %class.Node*** %storage.addr.11, align 8
 %storage.load.10.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.10, i32 %i.load.11
 %storage.load.10.elem.load = load %class.Node*, %class.Node** %storage.load.10.elem.addr, align 8
 %j.load = load i32, i32* %j.addr, align 4
 %storage.addr.12 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.15, i32 0, i32 0
 %storage.load.11 = load %class.Node**, %class.Node*** %storage.addr.12, align 8
 %storage.load.11.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.11, i32 %j.load
 %storage.load.11.elem.load = load %class.Node*, %class.Node** %storage.load.11.elem.addr, align 8
 store %class.Node* %storage.load.11.elem.load,%class.Node** %storage.load.10.elem.addr, align 8
 %j.load.1 = load i32, i32* %j.addr, align 4
 %storage.addr.13 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.15, i32 0, i32 0
 %storage.load.12 = load %class.Node**, %class.Node*** %storage.addr.13, align 8
 %storage.load.12.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.12, i32 %j.load.1
 %storage.load.12.elem.load = load %class.Node*, %class.Node** %storage.load.12.elem.addr, align 8
 %t.load = load %class.Node*, %class.Node** %t.addr, align 8
 store %class.Node* %t.load,%class.Node** %storage.load.12.elem.addr, align 8
 br label %exit.27

exit.27:                       ;prevs = 
 ret void

}

define void @doubleStorage.doubleStorage(%class.Array_Node* %internal.this.16)
{

entry.28:                       ;prevs = 
 %storage.addr.17 = alloca  %class.Array_Node*, align 8
 %szCopy.addr = alloca  i32, align 4
 %copy.addr = alloca  %class.Node**, align 8
 %storage.addr.14 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 0
 %storage.load.13 = load %class.Node**, %class.Node*** %storage.addr.14, align 8
 store %class.Node** %storage.load.13,%class.Node*** %copy.addr, align 8
 %sz.addr.9 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 1
 %sz.load.8 = load i32, i32* %sz.addr.9, align 4
 store i32 %sz.load.8,i32* %szCopy.addr, align 4
 %storage.addr.15 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 0
 %storage.load.14 = load %class.Node**, %class.Node*** %storage.addr.15, align 8
 %copy.load = load %class.Node**, %class.Node*** %copy.addr, align 8
 %bitcast.13 = bitcast %class.Node** %copy.load to i32*
 %getelementptr.8 = getelementptr inbounds i32, i32* %bitcast.13, i32 -1
 %getelementptr.8.load = load i32, i32* %getelementptr.8, align 4
 %mul.4 = mul i32 %getelementptr.8.load , 2
 %mul.5 = mul i32 %mul.4 , 8
 %add.9 = add i32 %mul.5 , 4
 %_bot_malloc.call.5 = call noalias i8* @_bot_malloc(i32 %add.9)
 %bitcast.14 = bitcast i8* %_bot_malloc.call.5 to i32*
 store i32 %mul.4,i32* %bitcast.14, align 4
 %getelementptr.9 = getelementptr inbounds i32, i32* %bitcast.14, i32 1
 %bitcast.15 = bitcast i32* %getelementptr.9 to %class.Node**
 store %class.Node** %bitcast.15,%class.Node*** %storage.addr.15, align 8
 %sz.addr.10 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 1
 %sz.load.9 = load i32, i32* %sz.addr.10, align 4
 store i32 0,i32* %sz.addr.10, align 4
 br label %for.cond.2

exit.28:                       ;prevs = 
 ret void

for.cond.2:                       ;prevs = 
 %sz.addr.11 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 1
 %sz.load.10 = load i32, i32* %sz.addr.11, align 4
 %szCopy.load = load i32, i32* %szCopy.addr, align 4
 %ne = icmp ne i32 %sz.load.10 , %szCopy.load
 br i1 %ne , label %for.body.2 , label %for.exit.2

for.incr.2:                       ;prevs = 
 %sz.addr.12 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 1
 %sz.load.11 = load i32, i32* %sz.addr.12, align 4
 %add.10 = add i32 %sz.load.11 , 1
 store i32 %add.10,i32* %sz.addr.12, align 4
 br label %for.cond.2

for.body.2:                       ;prevs = 
 %sz.addr.13 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 1
 %sz.load.12 = load i32, i32* %sz.addr.13, align 4
 %storage.addr.16 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 0
 %storage.load.15 = load %class.Node**, %class.Node*** %storage.addr.16, align 8
 %storage.load.15.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %storage.load.15, i32 %sz.load.12
 %storage.load.15.elem.load = load %class.Node*, %class.Node** %storage.load.15.elem.addr, align 8
 %sz.addr.14 = getelementptr inbounds %class.Array_Node, %class.Array_Node* %internal.this.16, i32 0, i32 1
 %sz.load.13 = load i32, i32* %sz.addr.14, align 4
 %copy.load.1 = load %class.Node**, %class.Node*** %copy.addr, align 8
 %copy.load.1.elem.addr = getelementptr inbounds %class.Node*, %class.Node** %copy.load.1, i32 %sz.load.13
 %copy.load.1.elem.load = load %class.Node*, %class.Node** %copy.load.1.elem.addr, align 8
 store %class.Node* %copy.load.1.elem.load,%class.Node** %storage.load.15.elem.addr, align 8
 br label %for.incr.2

for.exit.2:                       ;prevs = 
 br label %exit.28

}

define void @Heap_Node.Heap_Node(%class.Heap_Node* %internal.this.17)
{

entry.29:                       ;prevs = 
 %storage.addr.18 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.17, i32 0, i32 0
 %storage.load.16 = load %class.Array_Node*, %class.Array_Node** %storage.addr.18, align 8
 %_bot_malloc.call.6 = call noalias i8* @_bot_malloc(i32 12)
 %bitcast.16 = bitcast i8* %_bot_malloc.call.6 to %class.Array_Node*
 call void @Array_Node.Array_Node(%class.Array_Node* %bitcast.16)
 store %class.Array_Node* %bitcast.16,%class.Array_Node** %storage.addr.18, align 8
 br label %exit.29

exit.29:                       ;prevs = 
 ret void

}

define void @push.push(%class.Heap_Node* %internal.this.18, %class.Node* %v.3)
{

entry.30:                       ;prevs = 
 %p.addr = alloca  i32, align 4
 %x.addr = alloca  i32, align 4
 %v.addr.3 = alloca  %class.Node*, align 8
 store %class.Node* %v.3,%class.Node** %v.addr.3, align 8
 %storage.addr.19 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.18, i32 0, i32 0
 %storage.load.17 = load %class.Array_Node*, %class.Array_Node** %storage.addr.19, align 8
 %v.load.3 = load %class.Node*, %class.Node** %v.addr.3, align 8
 call void @push_back.push_back(%class.Array_Node* %storage.load.17, %class.Node* %v.load.3)
 %size.size.1.call = call i32 @size.size.1(%class.Heap_Node* %internal.this.18)
 %sub.3 = sub i32 %size.size.1.call , 1
 store i32 %sub.3,i32* %x.addr, align 4
 br label %wh.cond.1

exit.30:                       ;prevs = 
 ret void

wh.cond.1:                       ;prevs = 
 %x.load = load i32, i32* %x.addr, align 4
 %sgt = icmp sgt i32 %x.load , 0
 br i1 %sgt , label %wh.body.1 , label %wh.exit.1

wh.body.1:                       ;prevs = 
 %x.load.1 = load i32, i32* %x.addr, align 4
 %pnt.pnt.call = call i32 @pnt.pnt(%class.Heap_Node* %internal.this.18, i32 %x.load.1)
 store i32 %pnt.pnt.call,i32* %p.addr, align 4
 %storage.addr.20 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.18, i32 0, i32 0
 %storage.load.18 = load %class.Array_Node*, %class.Array_Node** %storage.addr.20, align 8
 %p.load = load i32, i32* %p.addr, align 4
 %get.get.call = call %class.Node* @get.get(%class.Array_Node* %storage.load.18, i32 %p.load)
 %key_.key_.call = call i32 @key_.key_(%class.Node* %get.get.call)
 %storage.addr.21 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.18, i32 0, i32 0
 %storage.load.19 = load %class.Array_Node*, %class.Array_Node** %storage.addr.21, align 8
 %x.load.2 = load i32, i32* %x.addr, align 4
 %get.get.call.1 = call %class.Node* @get.get(%class.Array_Node* %storage.load.19, i32 %x.load.2)
 %key_.key_.call.1 = call i32 @key_.key_(%class.Node* %get.get.call.1)
 %sge = icmp sge i32 %key_.key_.call , %key_.key_.call.1
 br i1 %sge , label %if.true.1 , label %if.false.1

wh.exit.1:                       ;prevs = 
 br label %exit.30

if.true.1:                       ;prevs = 
 br label %wh.exit.1

if.false.1:                       ;prevs = 
 br label %if.exit.1

if.exit.1:                       ;prevs = 
 %storage.addr.22 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.18, i32 0, i32 0
 %storage.load.20 = load %class.Array_Node*, %class.Array_Node** %storage.addr.22, align 8
 %p.load.1 = load i32, i32* %p.addr, align 4
 %x.load.3 = load i32, i32* %x.addr, align 4
 call void @swap.swap(%class.Array_Node* %storage.load.20, i32 %p.load.1, i32 %x.load.3)
 %x.load.4 = load i32, i32* %x.addr, align 4
 %p.load.2 = load i32, i32* %p.addr, align 4
 store i32 %p.load.2,i32* %x.addr, align 4
 br label %wh.cond.1

}

define %class.Node* @pop.pop(%class.Heap_Node* %internal.this.19)
{

entry.31:                       ;prevs = 
 %res.addr = alloca  %class.Node*, align 8
 %internal.ret.addr.7 = alloca  %class.Node*, align 8
 %storage.addr.23 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.19, i32 0, i32 0
 %storage.load.21 = load %class.Array_Node*, %class.Array_Node** %storage.addr.23, align 8
 %front.front.call = call %class.Node* @front.front(%class.Array_Node* %storage.load.21)
 store %class.Node* %front.front.call,%class.Node** %res.addr, align 8
 %storage.addr.24 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.19, i32 0, i32 0
 %storage.load.22 = load %class.Array_Node*, %class.Array_Node** %storage.addr.24, align 8
 %size.size.1.call.1 = call i32 @size.size.1(%class.Heap_Node* %internal.this.19)
 %sub.4 = sub i32 %size.size.1.call.1 , 1
 call void @swap.swap(%class.Array_Node* %storage.load.22, i32 0, i32 %sub.4)
 %storage.addr.25 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.19, i32 0, i32 0
 %storage.load.23 = load %class.Array_Node*, %class.Array_Node** %storage.addr.25, align 8
 %pop_back.pop_back.call = call %class.Node* @pop_back.pop_back(%class.Array_Node* %storage.load.23)
 call void @maxHeapify.maxHeapify(%class.Heap_Node* %internal.this.19, i32 0)
 %res.load = load %class.Node*, %class.Node** %res.addr, align 8
 store %class.Node* %res.load,%class.Node** %internal.ret.addr.7, align 8
 br label %exit.31

exit.31:                       ;prevs = 
 %internal.ret.load.7 = load %class.Node*, %class.Node** %internal.ret.addr.7, align 8
 ret %class.Node* %internal.ret.load.7

}

define %class.Node* @top.top(%class.Heap_Node* %internal.this.20)
{

entry.32:                       ;prevs = 
 %internal.ret.addr.8 = alloca  %class.Node*, align 8
 %storage.addr.26 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.20, i32 0, i32 0
 %storage.load.24 = load %class.Array_Node*, %class.Array_Node** %storage.addr.26, align 8
 %front.front.call.1 = call %class.Node* @front.front(%class.Array_Node* %storage.load.24)
 store %class.Node* %front.front.call.1,%class.Node** %internal.ret.addr.8, align 8
 br label %exit.32

exit.32:                       ;prevs = 
 %internal.ret.load.8 = load %class.Node*, %class.Node** %internal.ret.addr.8, align 8
 ret %class.Node* %internal.ret.load.8

}

define i32 @size.size.1(%class.Heap_Node* %internal.this.21)
{

entry.33:                       ;prevs = 
 %internal.ret.addr.9 = alloca  i32, align 4
 %storage.addr.27 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.21, i32 0, i32 0
 %storage.load.25 = load %class.Array_Node*, %class.Array_Node** %storage.addr.27, align 8
 %size.size.call.1 = call i32 @size.size(%class.Array_Node* %storage.load.25)
 store i32 %size.size.call.1,i32* %internal.ret.addr.9, align 4
 br label %exit.33

exit.33:                       ;prevs = 
 %internal.ret.load.9 = load i32, i32* %internal.ret.addr.9, align 4
 ret i32 %internal.ret.load.9

}

define i32 @lchild.lchild(%class.Heap_Node* %internal.this.22, i32 %x)
{

entry.34:                       ;prevs = 
 %x.addr.1 = alloca  i32, align 4
 %internal.ret.addr.10 = alloca  i32, align 4
 store i32 %x,i32* %x.addr.1, align 4
 %x.load.5 = load i32, i32* %x.addr.1, align 4
 %mul.6 = mul i32 %x.load.5 , 2
 %add.11 = add i32 %mul.6 , 1
 store i32 %add.11,i32* %internal.ret.addr.10, align 4
 br label %exit.34

exit.34:                       ;prevs = 
 %internal.ret.load.10 = load i32, i32* %internal.ret.addr.10, align 4
 ret i32 %internal.ret.load.10

}

define i32 @rchild.rchild(%class.Heap_Node* %internal.this.23, i32 %x.1)
{

entry.35:                       ;prevs = 
 %x.addr.2 = alloca  i32, align 4
 %internal.ret.addr.11 = alloca  i32, align 4
 store i32 %x.1,i32* %x.addr.2, align 4
 %x.load.6 = load i32, i32* %x.addr.2, align 4
 %mul.7 = mul i32 %x.load.6 , 2
 %add.12 = add i32 %mul.7 , 2
 store i32 %add.12,i32* %internal.ret.addr.11, align 4
 br label %exit.35

exit.35:                       ;prevs = 
 %internal.ret.load.11 = load i32, i32* %internal.ret.addr.11, align 4
 ret i32 %internal.ret.load.11

}

define i32 @pnt.pnt(%class.Heap_Node* %internal.this.24, i32 %x.2)
{

entry.36:                       ;prevs = 
 %x.addr.3 = alloca  i32, align 4
 %internal.ret.addr.12 = alloca  i32, align 4
 store i32 %x.2,i32* %x.addr.3, align 4
 %x.load.7 = load i32, i32* %x.addr.3, align 4
 %sub.5 = sub i32 %x.load.7 , 1
 %sdiv = sdiv i32 %sub.5 , 2
 store i32 %sdiv,i32* %internal.ret.addr.12, align 4
 br label %exit.36

exit.36:                       ;prevs = 
 %internal.ret.load.12 = load i32, i32* %internal.ret.addr.12, align 4
 ret i32 %internal.ret.load.12

}

define void @maxHeapify.maxHeapify(%class.Heap_Node* %internal.this.25, i32 %x.3)
{

entry.37:                       ;prevs = 
 %largest.addr = alloca  i32, align 4
 %r.addr = alloca  i32, align 4
 %l.addr = alloca  i32, align 4
 %x.addr.4 = alloca  i32, align 4
 store i32 %x.3,i32* %x.addr.4, align 4
 %x.load.8 = load i32, i32* %x.addr.4, align 4
 %lchild.lchild.call = call i32 @lchild.lchild(%class.Heap_Node* %internal.this.25, i32 %x.load.8)
 store i32 %lchild.lchild.call,i32* %l.addr, align 4
 %x.load.9 = load i32, i32* %x.addr.4, align 4
 %rchild.rchild.call = call i32 @rchild.rchild(%class.Heap_Node* %internal.this.25, i32 %x.load.9)
 store i32 %rchild.rchild.call,i32* %r.addr, align 4
 %x.load.10 = load i32, i32* %x.addr.4, align 4
 store i32 %x.load.10,i32* %largest.addr, align 4
 %l.load = load i32, i32* %l.addr, align 4
 %size.size.1.call.2 = call i32 @size.size.1(%class.Heap_Node* %internal.this.25)
 %slt.3 = icmp slt i32 %l.load , %size.size.1.call.2
 br i1 %slt.3 , label %logic.uncut , label %logic.exit

exit.37:                       ;prevs = 
 ret void

if.true.2:                       ;prevs = 
 %largest.load.1 = load i32, i32* %largest.addr, align 4
 %l.load.2 = load i32, i32* %l.addr, align 4
 store i32 %l.load.2,i32* %largest.addr, align 4
 br label %if.exit.2

if.false.2:                       ;prevs = 
 br label %if.exit.2

if.exit.2:                       ;prevs = 
 %r.load = load i32, i32* %r.addr, align 4
 %size.size.1.call.3 = call i32 @size.size.1(%class.Heap_Node* %internal.this.25)
 %slt.4 = icmp slt i32 %r.load , %size.size.1.call.3
 br i1 %slt.4 , label %logic.uncut.1 , label %logic.exit.1

logic.uncut:                       ;prevs = 
 %storage.addr.28 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.25, i32 0, i32 0
 %storage.load.26 = load %class.Array_Node*, %class.Array_Node** %storage.addr.28, align 8
 %l.load.1 = load i32, i32* %l.addr, align 4
 %get.get.call.2 = call %class.Node* @get.get(%class.Array_Node* %storage.load.26, i32 %l.load.1)
 %key_.key_.call.2 = call i32 @key_.key_(%class.Node* %get.get.call.2)
 %storage.addr.29 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.25, i32 0, i32 0
 %storage.load.27 = load %class.Array_Node*, %class.Array_Node** %storage.addr.29, align 8
 %largest.load = load i32, i32* %largest.addr, align 4
 %get.get.call.3 = call %class.Node* @get.get(%class.Array_Node* %storage.load.27, i32 %largest.load)
 %key_.key_.call.3 = call i32 @key_.key_(%class.Node* %get.get.call.3)
 %sgt.1 = icmp sgt i32 %key_.key_.call.2 , %key_.key_.call.3
 br label %logic.exit

logic.exit:                       ;prevs = 
 %phi = phi i1 [%slt.3, %entry.37], [%sgt.1, %logic.uncut]
 br i1 %phi , label %if.true.2 , label %if.false.2

if.true.3:                       ;prevs = 
 %largest.load.3 = load i32, i32* %largest.addr, align 4
 %r.load.2 = load i32, i32* %r.addr, align 4
 store i32 %r.load.2,i32* %largest.addr, align 4
 br label %if.exit.3

if.false.3:                       ;prevs = 
 br label %if.exit.3

if.exit.3:                       ;prevs = 
 %largest.load.4 = load i32, i32* %largest.addr, align 4
 %x.load.11 = load i32, i32* %x.addr.4, align 4
 %eq.1 = icmp eq i32 %largest.load.4 , %x.load.11
 br i1 %eq.1 , label %if.true.4 , label %if.false.4

logic.uncut.1:                       ;prevs = 
 %storage.addr.30 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.25, i32 0, i32 0
 %storage.load.28 = load %class.Array_Node*, %class.Array_Node** %storage.addr.30, align 8
 %r.load.1 = load i32, i32* %r.addr, align 4
 %get.get.call.4 = call %class.Node* @get.get(%class.Array_Node* %storage.load.28, i32 %r.load.1)
 %key_.key_.call.4 = call i32 @key_.key_(%class.Node* %get.get.call.4)
 %storage.addr.31 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.25, i32 0, i32 0
 %storage.load.29 = load %class.Array_Node*, %class.Array_Node** %storage.addr.31, align 8
 %largest.load.2 = load i32, i32* %largest.addr, align 4
 %get.get.call.5 = call %class.Node* @get.get(%class.Array_Node* %storage.load.29, i32 %largest.load.2)
 %key_.key_.call.5 = call i32 @key_.key_(%class.Node* %get.get.call.5)
 %sgt.2 = icmp sgt i32 %key_.key_.call.4 , %key_.key_.call.5
 br label %logic.exit.1

logic.exit.1:                       ;prevs = 
 %phi.1 = phi i1 [%slt.4, %if.exit.2], [%sgt.2, %logic.uncut.1]
 br i1 %phi.1 , label %if.true.3 , label %if.false.3

if.true.4:                       ;prevs = 
 br label %exit.37

if.false.4:                       ;prevs = 
 br label %if.exit.4

if.exit.4:                       ;prevs = 
 %storage.addr.32 = getelementptr inbounds %class.Heap_Node, %class.Heap_Node* %internal.this.25, i32 0, i32 0
 %storage.load.30 = load %class.Array_Node*, %class.Array_Node** %storage.addr.32, align 8
 %x.load.12 = load i32, i32* %x.addr.4, align 4
 %largest.load.5 = load i32, i32* %largest.addr, align 4
 call void @swap.swap(%class.Array_Node* %storage.load.30, i32 %x.load.12, i32 %largest.load.5)
 %largest.load.6 = load i32, i32* %largest.addr, align 4
 call void @maxHeapify.maxHeapify(%class.Heap_Node* %internal.this.25, i32 %largest.load.6)
 br label %exit.37

}

define void @Node.Node(%class.Node* %internal.this.26)
{

entry.38:                       ;prevs = 
 br label %exit.38

exit.38:                       ;prevs = 
 ret void

}

define i32 @key_.key_(%class.Node* %internal.this.27)
{

entry.39:                       ;prevs = 
 %internal.ret.addr.13 = alloca  i32, align 4
 %dist.addr.1 = getelementptr inbounds %class.Node, %class.Node* %internal.this.27, i32 0, i32 1
 %dist.load = load i32, i32* %dist.addr.1, align 4
 %sub.6 = sub i32 0 , %dist.load
 store i32 %sub.6,i32* %internal.ret.addr.13, align 4
 br label %exit.39

exit.39:                       ;prevs = 
 %internal.ret.load.13 = load i32, i32* %internal.ret.addr.13, align 4
 ret i32 %internal.ret.load.13

}

define void @init()
{

entry.40:                       ;prevs = 
 %dist.addr = alloca  i32, align 4
 %node.addr = alloca  i32, align 4
 %w.addr.1 = alloca  i32, align 4
 %v.addr.4 = alloca  i32, align 4
 %u.addr.1 = alloca  i32, align 4
 %i.addr.4 = alloca  i32, align 4
 %n.load.2 = load i32, i32* @n, align 4
 %getInt.call = call i32 @getInt()
 store i32 %getInt.call,i32* @n, align 4
 %m.load.3 = load i32, i32* @m, align 4
 %getInt.call.1 = call i32 @getInt()
 store i32 %getInt.call.1,i32* @m, align 4
 %g.load = load %class.EdgeList*, %class.EdgeList** @g, align 8
 %_bot_malloc.call.7 = call noalias i8* @_bot_malloc(i32 28)
 %bitcast.17 = bitcast i8* %_bot_malloc.call.7 to %class.EdgeList*
 call void @EdgeList.EdgeList(%class.EdgeList* %bitcast.17)
 store %class.EdgeList* %bitcast.17,%class.EdgeList** @g, align 8
 %g.load.1 = load %class.EdgeList*, %class.EdgeList** @g, align 8
 %n.load.3 = load i32, i32* @n, align 4
 %m.load.4 = load i32, i32* @m, align 4
 call void @init.init(%class.EdgeList* %g.load.1, i32 %n.load.3, i32 %m.load.4)
 %i.load.12 = load i32, i32* %i.addr.4, align 4
 store i32 0,i32* %i.addr.4, align 4
 br label %for.cond.3

exit.40:                       ;prevs = 
 ret void

for.cond.3:                       ;prevs = 
 %i.load.13 = load i32, i32* %i.addr.4, align 4
 %m.load.5 = load i32, i32* @m, align 4
 %slt.5 = icmp slt i32 %i.load.13 , %m.load.5
 br i1 %slt.5 , label %for.body.3 , label %for.exit.3

for.incr.3:                       ;prevs = 
 %i.load.14 = load i32, i32* %i.addr.4, align 4
 %add.13 = add i32 %i.load.14 , 1
 store i32 %add.13,i32* %i.addr.4, align 4
 br label %for.cond.3

for.body.3:                       ;prevs = 
 %getInt.call.2 = call i32 @getInt()
 store i32 %getInt.call.2,i32* %u.addr.1, align 4
 %getInt.call.3 = call i32 @getInt()
 store i32 %getInt.call.3,i32* %v.addr.4, align 4
 %getInt.call.4 = call i32 @getInt()
 store i32 %getInt.call.4,i32* %w.addr.1, align 4
 %g.load.2 = load %class.EdgeList*, %class.EdgeList** @g, align 8
 %u.load.3 = load i32, i32* %u.addr.1, align 4
 %v.load.4 = load i32, i32* %v.addr.4, align 4
 %w.load.1 = load i32, i32* %w.addr.1, align 4
 call void @addEdge.addEdge(%class.EdgeList* %g.load.2, i32 %u.load.3, i32 %v.load.4, i32 %w.load.1)
 br label %for.incr.3

for.exit.3:                       ;prevs = 
 br label %exit.40

}

define i32* @dijkstra(i32 %s)
{

entry.41:                       ;prevs = 
 %alt.addr = alloca  i32, align 4
 %w.addr.2 = alloca  i32, align 4
 %v.addr.5 = alloca  i32, align 4
 %k.addr = alloca  i32, align 4
 %u.addr.2 = alloca  i32, align 4
 %node.addr.2 = alloca  %class.Node*, align 8
 %src.addr = alloca  %class.Node*, align 8
 %q.addr = alloca  %class.Heap_Node*, align 8
 %i.addr.5 = alloca  i32, align 4
 %d.addr = alloca  i32*, align 8
 %visited.addr = alloca  i32*, align 8
 %s.addr = alloca  i32, align 4
 %internal.ret.addr.14 = alloca  i32*, align 8
 store i32 %s,i32* %s.addr, align 4
 %n.load.4 = load i32, i32* @n, align 4
 %mul.8 = mul i32 %n.load.4 , 4
 %add.14 = add i32 %mul.8 , 4
 %_bot_malloc.call.8 = call noalias i8* @_bot_malloc(i32 %add.14)
 %bitcast.18 = bitcast i8* %_bot_malloc.call.8 to i32*
 store i32 %n.load.4,i32* %bitcast.18, align 4
 %getelementptr.10 = getelementptr inbounds i32, i32* %bitcast.18, i32 1
 %bitcast.19 = bitcast i32* %getelementptr.10 to i32*
 store i32* %bitcast.19,i32** %visited.addr, align 8
 %getelementptr.11 = getelementptr inbounds [ 10 x i8 ], [ 10 x i8 ]* @anonym.strconst, i32 0, i32 0
 call void @println(i8* %getelementptr.11)
 %n.load.5 = load i32, i32* @n, align 4
 call void @printlnInt(i32 %n.load.5)
 %n.load.6 = load i32, i32* @n, align 4
 %mul.9 = mul i32 %n.load.6 , 4
 %add.15 = add i32 %mul.9 , 4
 %_bot_malloc.call.9 = call noalias i8* @_bot_malloc(i32 %add.15)
 %bitcast.20 = bitcast i8* %_bot_malloc.call.9 to i32*
 store i32 %n.load.6,i32* %bitcast.20, align 4
 %getelementptr.12 = getelementptr inbounds i32, i32* %bitcast.20, i32 1
 %bitcast.21 = bitcast i32* %getelementptr.12 to i32*
 store i32* %bitcast.21,i32** %d.addr, align 8
 %i.load.15 = load i32, i32* %i.addr.5, align 4
 store i32 0,i32* %i.addr.5, align 4
 br label %for.cond.4

exit.41:                       ;prevs = 
 %internal.ret.load.14 = load i32*, i32** %internal.ret.addr.14, align 8
 ret i32* %internal.ret.load.14

for.cond.4:                       ;prevs = 
 %i.load.16 = load i32, i32* %i.addr.5, align 4
 %n.load.7 = load i32, i32* @n, align 4
 %slt.6 = icmp slt i32 %i.load.16 , %n.load.7
 br i1 %slt.6 , label %for.body.4 , label %for.exit.4

for.incr.4:                       ;prevs = 
 %i.load.17 = load i32, i32* %i.addr.5, align 4
 %add.16 = add i32 %i.load.17 , 1
 store i32 %add.16,i32* %i.addr.5, align 4
 br label %for.cond.4

for.body.4:                       ;prevs = 
 %i.load.18 = load i32, i32* %i.addr.5, align 4
 %d.load = load i32*, i32** %d.addr, align 8
 %d.load.elem.addr = getelementptr inbounds i32, i32* %d.load, i32 %i.load.18
 %d.load.elem.load = load i32, i32* %d.load.elem.addr, align 4
 %INF.load = load i32, i32* @INF, align 4
 store i32 %INF.load,i32* %d.load.elem.addr, align 4
 %i.load.19 = load i32, i32* %i.addr.5, align 4
 %visited.load = load i32*, i32** %visited.addr, align 8
 %visited.load.elem.addr = getelementptr inbounds i32, i32* %visited.load, i32 %i.load.19
 %visited.load.elem.load = load i32, i32* %visited.load.elem.addr, align 4
 store i32 0,i32* %visited.load.elem.addr, align 4
 br label %for.incr.4

for.exit.4:                       ;prevs = 
 %s.load = load i32, i32* %s.addr, align 4
 %d.load.1 = load i32*, i32** %d.addr, align 8
 %d.load.1.elem.addr = getelementptr inbounds i32, i32* %d.load.1, i32 %s.load
 %d.load.1.elem.load = load i32, i32* %d.load.1.elem.addr, align 4
 store i32 0,i32* %d.load.1.elem.addr, align 4
 %_bot_malloc.call.10 = call noalias i8* @_bot_malloc(i32 8)
 %bitcast.22 = bitcast i8* %_bot_malloc.call.10 to %class.Heap_Node*
 call void @Heap_Node.Heap_Node(%class.Heap_Node* %bitcast.22)
 store %class.Heap_Node* %bitcast.22,%class.Heap_Node** %q.addr, align 8
 %_bot_malloc.call.11 = call noalias i8* @_bot_malloc(i32 8)
 %bitcast.23 = bitcast i8* %_bot_malloc.call.11 to %class.Node*
 call void @Node.Node(%class.Node* %bitcast.23)
 store %class.Node* %bitcast.23,%class.Node** %src.addr, align 8
 %src.load = load %class.Node*, %class.Node** %src.addr, align 8
 %dist.addr.2 = getelementptr inbounds %class.Node, %class.Node* %src.load, i32 0, i32 1
 %dist.load.1 = load i32, i32* %dist.addr.2, align 4
 store i32 0,i32* %dist.addr.2, align 4
 %src.load.1 = load %class.Node*, %class.Node** %src.addr, align 8
 %node.addr.1 = getelementptr inbounds %class.Node, %class.Node* %src.load.1, i32 0, i32 0
 %node.load = load i32, i32* %node.addr.1, align 4
 %s.load.1 = load i32, i32* %s.addr, align 4
 store i32 %s.load.1,i32* %node.addr.1, align 4
 %q.load = load %class.Heap_Node*, %class.Heap_Node** %q.addr, align 8
 %src.load.2 = load %class.Node*, %class.Node** %src.addr, align 8
 call void @push.push(%class.Heap_Node* %q.load, %class.Node* %src.load.2)
 br label %wh.cond.2

wh.cond.2:                       ;prevs = 
 %q.load.1 = load %class.Heap_Node*, %class.Heap_Node** %q.addr, align 8
 %size.size.1.call.4 = call i32 @size.size.1(%class.Heap_Node* %q.load.1)
 %ne.1 = icmp ne i32 %size.size.1.call.4 , 0
 br i1 %ne.1 , label %wh.body.2 , label %wh.exit.2

wh.body.2:                       ;prevs = 
 %q.load.2 = load %class.Heap_Node*, %class.Heap_Node** %q.addr, align 8
 %pop.pop.call = call %class.Node* @pop.pop(%class.Heap_Node* %q.load.2)
 store %class.Node* %pop.pop.call,%class.Node** %node.addr.2, align 8
 %node.load.1 = load %class.Node*, %class.Node** %node.addr.2, align 8
 %node.addr.3 = getelementptr inbounds %class.Node, %class.Node* %node.load.1, i32 0, i32 0
 %node.load.2 = load i32, i32* %node.addr.3, align 4
 store i32 %node.load.2,i32* %u.addr.2, align 4
 %u.load.4 = load i32, i32* %u.addr.2, align 4
 call void @printlnInt(i32 %u.load.4)
 %u.load.5 = load i32, i32* %u.addr.2, align 4
 %visited.load.1 = load i32*, i32** %visited.addr, align 8
 %visited.load.1.elem.addr = getelementptr inbounds i32, i32* %visited.load.1, i32 %u.load.5
 %visited.load.1.elem.load = load i32, i32* %visited.load.1.elem.addr, align 4
 %eq.2 = icmp eq i32 %visited.load.1.elem.load , 1
 br i1 %eq.2 , label %if.true.5 , label %if.false.5

wh.exit.2:                       ;prevs = 
 %d.load.6 = load i32*, i32** %d.addr, align 8
 store i32* %d.load.6,i32** %internal.ret.addr.14, align 8
 br label %exit.41

if.true.5:                       ;prevs = 
 %getelementptr.13 = getelementptr inbounds [ 15 x i8 ], [ 15 x i8 ]* @anonym.strconst.1, i32 0, i32 0
 call void @println(i8* %getelementptr.13)
 %q.load.3 = load %class.Heap_Node*, %class.Heap_Node** %q.addr, align 8
 %size.size.1.call.5 = call i32 @size.size.1(%class.Heap_Node* %q.load.3)
 call void @printlnInt(i32 %size.size.1.call.5)
 br label %wh.cond.2

if.false.5:                       ;prevs = 
 br label %if.exit.5

if.exit.5:                       ;prevs = 
 %u.load.6 = load i32, i32* %u.addr.2, align 4
 %visited.load.2 = load i32*, i32** %visited.addr, align 8
 %visited.load.2.elem.addr = getelementptr inbounds i32, i32* %visited.load.2, i32 %u.load.6
 %visited.load.2.elem.load = load i32, i32* %visited.load.2.elem.addr, align 4
 store i32 1,i32* %visited.load.2.elem.addr, align 4
 %k.load = load i32, i32* %k.addr, align 4
 %u.load.7 = load i32, i32* %u.addr.2, align 4
 %g.load.3 = load %class.EdgeList*, %class.EdgeList** @g, align 8
 %first.addr.6 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %g.load.3, i32 0, i32 2
 %first.load.5 = load i32*, i32** %first.addr.6, align 8
 %first.load.5.elem.addr = getelementptr inbounds i32, i32* %first.load.5, i32 %u.load.7
 %first.load.5.elem.load = load i32, i32* %first.load.5.elem.addr, align 4
 store i32 %first.load.5.elem.load,i32* %k.addr, align 4
 br label %for.cond.5

for.cond.5:                       ;prevs = 
 %k.load.1 = load i32, i32* %k.addr, align 4
 %sub.7 = sub i32 0 , 1
 %ne.2 = icmp ne i32 %k.load.1 , %sub.7
 br i1 %ne.2 , label %for.body.5 , label %for.exit.5

for.incr.5:                       ;prevs = 
 %k.load.2 = load i32, i32* %k.addr, align 4
 %k.load.3 = load i32, i32* %k.addr, align 4
 %g.load.4 = load %class.EdgeList*, %class.EdgeList** @g, align 8
 %next.addr.4 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %g.load.4, i32 0, i32 1
 %next.load.3 = load i32*, i32** %next.addr.4, align 8
 %next.load.3.elem.addr = getelementptr inbounds i32, i32* %next.load.3, i32 %k.load.3
 %next.load.3.elem.load = load i32, i32* %next.load.3.elem.addr, align 4
 store i32 %next.load.3.elem.load,i32* %k.addr, align 4
 br label %for.cond.5

for.body.5:                       ;prevs = 
 %k.load.4 = load i32, i32* %k.addr, align 4
 %g.load.5 = load %class.EdgeList*, %class.EdgeList** @g, align 8
 %edges.addr.4 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %g.load.5, i32 0, i32 0
 %edges.load.3 = load %class.Edge**, %class.Edge*** %edges.addr.4, align 8
 %edges.load.3.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %edges.load.3, i32 %k.load.4
 %edges.load.3.elem.load = load %class.Edge*, %class.Edge** %edges.load.3.elem.addr, align 8
 %to.addr.1 = getelementptr inbounds %class.Edge, %class.Edge* %edges.load.3.elem.load, i32 0, i32 1
 %to.load.1 = load i32, i32* %to.addr.1, align 4
 store i32 %to.load.1,i32* %v.addr.5, align 4
 %k.load.5 = load i32, i32* %k.addr, align 4
 %g.load.6 = load %class.EdgeList*, %class.EdgeList** @g, align 8
 %edges.addr.5 = getelementptr inbounds %class.EdgeList, %class.EdgeList* %g.load.6, i32 0, i32 0
 %edges.load.4 = load %class.Edge**, %class.Edge*** %edges.addr.5, align 8
 %edges.load.4.elem.addr = getelementptr inbounds %class.Edge*, %class.Edge** %edges.load.4, i32 %k.load.5
 %edges.load.4.elem.load = load %class.Edge*, %class.Edge** %edges.load.4.elem.addr, align 8
 %weight.addr.1 = getelementptr inbounds %class.Edge, %class.Edge* %edges.load.4.elem.load, i32 0, i32 2
 %weight.load.1 = load i32, i32* %weight.addr.1, align 4
 store i32 %weight.load.1,i32* %w.addr.2, align 4
 %u.load.8 = load i32, i32* %u.addr.2, align 4
 %d.load.2 = load i32*, i32** %d.addr, align 8
 %d.load.2.elem.addr = getelementptr inbounds i32, i32* %d.load.2, i32 %u.load.8
 %d.load.2.elem.load = load i32, i32* %d.load.2.elem.addr, align 4
 %w.load.2 = load i32, i32* %w.addr.2, align 4
 %add.17 = add i32 %d.load.2.elem.load , %w.load.2
 store i32 %add.17,i32* %alt.addr, align 4
 %alt.load = load i32, i32* %alt.addr, align 4
 %v.load.5 = load i32, i32* %v.addr.5, align 4
 %d.load.3 = load i32*, i32** %d.addr, align 8
 %d.load.3.elem.addr = getelementptr inbounds i32, i32* %d.load.3, i32 %v.load.5
 %d.load.3.elem.load = load i32, i32* %d.load.3.elem.addr, align 4
 %sge.1 = icmp sge i32 %alt.load , %d.load.3.elem.load
 br i1 %sge.1 , label %if.true.6 , label %if.false.6

for.exit.5:                       ;prevs = 
 br label %wh.cond.2

if.true.6:                       ;prevs = 
 br label %for.incr.5

if.false.6:                       ;prevs = 
 br label %if.exit.6

if.exit.6:                       ;prevs = 
 %v.load.6 = load i32, i32* %v.addr.5, align 4
 %d.load.4 = load i32*, i32** %d.addr, align 8
 %d.load.4.elem.addr = getelementptr inbounds i32, i32* %d.load.4, i32 %v.load.6
 %d.load.4.elem.load = load i32, i32* %d.load.4.elem.addr, align 4
 %alt.load.1 = load i32, i32* %alt.addr, align 4
 store i32 %alt.load.1,i32* %d.load.4.elem.addr, align 4
 %getelementptr.14 = getelementptr inbounds [ 13 x i8 ], [ 13 x i8 ]* @anonym.strconst.2, i32 0, i32 0
 call void @println(i8* %getelementptr.14)
 %node.load.3 = load %class.Node*, %class.Node** %node.addr.2, align 8
 %_bot_malloc.call.12 = call noalias i8* @_bot_malloc(i32 8)
 %bitcast.24 = bitcast i8* %_bot_malloc.call.12 to %class.Node*
 call void @Node.Node(%class.Node* %bitcast.24)
 store %class.Node* %bitcast.24,%class.Node** %node.addr.2, align 8
 %node.load.4 = load %class.Node*, %class.Node** %node.addr.2, align 8
 %node.addr.4 = getelementptr inbounds %class.Node, %class.Node* %node.load.4, i32 0, i32 0
 %node.load.5 = load i32, i32* %node.addr.4, align 4
 %v.load.7 = load i32, i32* %v.addr.5, align 4
 store i32 %v.load.7,i32* %node.addr.4, align 4
 %node.load.6 = load %class.Node*, %class.Node** %node.addr.2, align 8
 %dist.addr.3 = getelementptr inbounds %class.Node, %class.Node* %node.load.6, i32 0, i32 1
 %dist.load.2 = load i32, i32* %dist.addr.3, align 4
 %v.load.8 = load i32, i32* %v.addr.5, align 4
 %d.load.5 = load i32*, i32** %d.addr, align 8
 %d.load.5.elem.addr = getelementptr inbounds i32, i32* %d.load.5, i32 %v.load.8
 %d.load.5.elem.load = load i32, i32* %d.load.5.elem.addr, align 4
 store i32 %d.load.5.elem.load,i32* %dist.addr.3, align 4
 %q.load.4 = load %class.Heap_Node*, %class.Heap_Node** %q.addr, align 8
 %node.load.7 = load %class.Node*, %class.Node** %node.addr.2, align 8
 call void @push.push(%class.Heap_Node* %q.load.4, %class.Node* %node.load.7)
 %getelementptr.15 = getelementptr inbounds [ 12 x i8 ], [ 12 x i8 ]* @anonym.strconst.3, i32 0, i32 0
 call void @println(i8* %getelementptr.15)
 br label %for.incr.5

}

define i32 @main()
{

entry.42:                       ;prevs = 
 %d.addr.1 = alloca  i32*, align 8
 %j.addr.1 = alloca  i32, align 4
 %i.addr.6 = alloca  i32, align 4
 %internal.ret.addr.15 = alloca  i32, align 4
 call void @_global_init()
 store i32 0,i32* %internal.ret.addr.15, align 4
 call void @init()
 %i.load.20 = load i32, i32* %i.addr.6, align 4
 store i32 0,i32* %i.addr.6, align 4
 br label %for.cond.6

exit.42:                       ;prevs = 
 %internal.ret.load.15 = load i32, i32* %internal.ret.addr.15, align 4
 ret i32 %internal.ret.load.15

for.cond.6:                       ;prevs = 
 %i.load.21 = load i32, i32* %i.addr.6, align 4
 %n.load.8 = load i32, i32* @n, align 4
 %slt.7 = icmp slt i32 %i.load.21 , %n.load.8
 br i1 %slt.7 , label %for.body.6 , label %for.exit.6

for.incr.6:                       ;prevs = 
 %i.load.22 = load i32, i32* %i.addr.6, align 4
 %add.18 = add i32 %i.load.22 , 1
 store i32 %add.18,i32* %i.addr.6, align 4
 br label %for.cond.6

for.body.6:                       ;prevs = 
 %i.load.23 = load i32, i32* %i.addr.6, align 4
 %dijkstra.call = call i32* @dijkstra(i32 %i.load.23)
 store i32* %dijkstra.call,i32** %d.addr.1, align 8
 %j.load.2 = load i32, i32* %j.addr.1, align 4
 store i32 0,i32* %j.addr.1, align 4
 br label %for.cond.7

for.exit.6:                       ;prevs = 
 store i32 0,i32* %internal.ret.addr.15, align 4
 br label %exit.42

for.cond.7:                       ;prevs = 
 %j.load.3 = load i32, i32* %j.addr.1, align 4
 %n.load.9 = load i32, i32* @n, align 4
 %slt.8 = icmp slt i32 %j.load.3 , %n.load.9
 br i1 %slt.8 , label %for.body.7 , label %for.exit.7

for.incr.7:                       ;prevs = 
 %j.load.4 = load i32, i32* %j.addr.1, align 4
 %add.19 = add i32 %j.load.4 , 1
 store i32 %add.19,i32* %j.addr.1, align 4
 br label %for.cond.7

for.body.7:                       ;prevs = 
 %j.load.5 = load i32, i32* %j.addr.1, align 4
 %d.load.7 = load i32*, i32** %d.addr.1, align 8
 %d.load.7.elem.addr = getelementptr inbounds i32, i32* %d.load.7, i32 %j.load.5
 %d.load.7.elem.load = load i32, i32* %d.load.7.elem.addr, align 4
 %INF.load.1 = load i32, i32* @INF, align 4
 %eq.3 = icmp eq i32 %d.load.7.elem.load , %INF.load.1
 br i1 %eq.3 , label %if.true.7 , label %if.false.7

for.exit.7:                       ;prevs = 
 %getelementptr.18 = getelementptr inbounds [ 1 x i8 ], [ 1 x i8 ]* @anonym.strconst.6, i32 0, i32 0
 call void @println(i8* %getelementptr.18)
 br label %for.incr.6

if.true.7:                       ;prevs = 
 %getelementptr.16 = getelementptr inbounds [ 3 x i8 ], [ 3 x i8 ]* @anonym.strconst.4, i32 0, i32 0
 call void @print(i8* %getelementptr.16)
 br label %if.exit.7

if.false.7:                       ;prevs = 
 %j.load.6 = load i32, i32* %j.addr.1, align 4
 %d.load.8 = load i32*, i32** %d.addr.1, align 8
 %d.load.8.elem.addr = getelementptr inbounds i32, i32* %d.load.8, i32 %j.load.6
 %d.load.8.elem.load = load i32, i32* %d.load.8.elem.addr, align 4
 %toString.call = call i8* @toString(i32 %d.load.8.elem.load)
 call void @print(i8* %toString.call)
 br label %if.exit.7

if.exit.7:                       ;prevs = 
 %getelementptr.17 = getelementptr inbounds [ 2 x i8 ], [ 2 x i8 ]* @anonym.strconst.5, i32 0, i32 0
 call void @print(i8* %getelementptr.17)
 br label %for.incr.7

}

