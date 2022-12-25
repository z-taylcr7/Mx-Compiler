	.text
	.file	"aruba.ll"
	.globl	_global_init            # -- Begin function _global_init
	.p2align	4, 0x90
	.type	_global_init,@function
_global_init:                           # @_global_init
	.cfi_startproc
# %bb.0:                                # %entry.11
	movq	$0, g
	movl	$10000000, INF          # imm = 0x989680
# %bb.1:                                # %exit.11
	retq
.Lfunc_end0:
	.size	_global_init, .Lfunc_end0-_global_init
	.cfi_endproc
                                        # -- End function
	.globl	Edge.Edge               # -- Begin function Edge.Edge
	.p2align	4, 0x90
	.type	Edge.Edge,@function
Edge.Edge:                              # @Edge.Edge
	.cfi_startproc
# %bb.0:                                # %entry.12
# %bb.1:                                # %exit.12
	retq
.Lfunc_end1:
	.size	Edge.Edge, .Lfunc_end1-Edge.Edge
	.cfi_endproc
                                        # -- End function
	.globl	EdgeList.EdgeList       # -- Begin function EdgeList.EdgeList
	.p2align	4, 0x90
	.type	EdgeList.EdgeList,@function
EdgeList.EdgeList:                      # @EdgeList.EdgeList
	.cfi_startproc
# %bb.0:                                # %entry.13
	jmp	.LBB2_1
.LBB2_1:                                # %exit.13
	retq
.Lfunc_end2:
	.size	EdgeList.EdgeList, .Lfunc_end2-EdgeList.EdgeList
	.cfi_endproc
                                        # -- End function
	.globl	init.init               # -- Begin function init.init
	.p2align	4, 0x90
	.type	init.init,@function
init.init:                              # @init.init
	.cfi_startproc
# %bb.0:                                # %entry.14
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	movl	%esi, 28(%rsp)
	movl	%edx, 32(%rsp)
	movl	32(%rsp), %eax
	movl	%eax, %ecx
	shll	$3, %ecx
	addl	$4, %ecx
	movq	%rdi, 16(%rsp)          # 8-byte Spill
	movl	%ecx, %edi
	movl	%eax, 12(%rsp)          # 4-byte Spill
	callq	_bot_malloc
	movq	%rax, %r8
	movl	12(%rsp), %ecx          # 4-byte Reload
	movl	%ecx, (%rax)
	addq	$4, %r8
	movq	16(%rsp), %rax          # 8-byte Reload
	movq	%r8, (%rax)
	movl	32(%rsp), %edx
	movl	%edx, %esi
	shll	$2, %esi
	addl	$4, %esi
	movl	%esi, %edi
	movl	%edx, 8(%rsp)           # 4-byte Spill
	callq	_bot_malloc
	movq	%rax, %r8
	movl	8(%rsp), %ecx           # 4-byte Reload
	movl	%ecx, (%rax)
	addq	$4, %r8
	movq	16(%rsp), %rax          # 8-byte Reload
	movq	%r8, 8(%rax)
	movl	28(%rsp), %edx
	movl	%edx, %esi
	shll	$2, %esi
	addl	$4, %esi
	movl	%esi, %edi
	movl	%edx, 4(%rsp)           # 4-byte Spill
	callq	_bot_malloc
	movq	%rax, %r8
	movl	4(%rsp), %ecx           # 4-byte Reload
	movl	%ecx, (%rax)
	addq	$4, %r8
	movq	16(%rsp), %rax          # 8-byte Reload
	movq	%r8, 16(%rax)
	movl	$0, 36(%rsp)
	jmp	.LBB3_2
.LBB3_1:                                # %exit.14
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB3_2:                                # %for.cond
                                        # =>This Inner Loop Header: Depth=1
	.cfi_def_cfa_offset 48
	movl	36(%rsp), %eax
	cmpl	32(%rsp), %eax
	jl	.LBB3_4
	jmp	.LBB3_5
.LBB3_3:                                # %for.incr
                                        #   in Loop: Header=BB3_2 Depth=1
	movl	36(%rsp), %eax
	addl	$1, %eax
	movl	%eax, 36(%rsp)
	jmp	.LBB3_2
.LBB3_4:                                # %for.body
                                        #   in Loop: Header=BB3_2 Depth=1
	xorl	%eax, %eax
	movl	36(%rsp), %ecx
	movq	16(%rsp), %rdx          # 8-byte Reload
	movq	8(%rdx), %rsi
	subl	$1, %eax
	movslq	%ecx, %rdi
	movl	%eax, (%rsi,%rdi,4)
	jmp	.LBB3_3
.LBB3_5:                                # %for.exit
	movl	$0, 36(%rsp)
.LBB3_6:                                # %for.cond.1
                                        # =>This Inner Loop Header: Depth=1
	movl	36(%rsp), %eax
	cmpl	28(%rsp), %eax
	jl	.LBB3_8
	jmp	.LBB3_9
.LBB3_7:                                # %for.incr.1
                                        #   in Loop: Header=BB3_6 Depth=1
	movl	36(%rsp), %eax
	addl	$1, %eax
	movl	%eax, 36(%rsp)
	jmp	.LBB3_6
.LBB3_8:                                # %for.body.1
                                        #   in Loop: Header=BB3_6 Depth=1
	xorl	%eax, %eax
	movl	36(%rsp), %ecx
	movq	16(%rsp), %rdx          # 8-byte Reload
	movq	16(%rdx), %rsi
	subl	$1, %eax
	movslq	%ecx, %rdi
	movl	%eax, (%rsi,%rdi,4)
	jmp	.LBB3_7
.LBB3_9:                                # %for.exit.1
	movq	16(%rsp), %rax          # 8-byte Reload
	movl	$0, 24(%rax)
	jmp	.LBB3_1
.Lfunc_end3:
	.size	init.init, .Lfunc_end3-init.init
	.cfi_endproc
                                        # -- End function
	.globl	addEdge.addEdge         # -- Begin function addEdge.addEdge
	.p2align	4, 0x90
	.type	addEdge.addEdge,@function
addEdge.addEdge:                        # @addEdge.addEdge
	.cfi_startproc
# %bb.0:                                # %entry.15
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	movl	%esi, 20(%rsp)
	movl	%edx, 24(%rsp)
	movl	%ecx, 28(%rsp)
	movl	$12, %eax
	movq	%rdi, 8(%rsp)           # 8-byte Spill
	movl	%eax, %edi
	callq	_bot_malloc
	movq	%rax, %rdi
	movq	%rax, (%rsp)            # 8-byte Spill
	callq	Edge.Edge
	movq	(%rsp), %rax            # 8-byte Reload
	movq	%rax, 32(%rsp)
	movq	32(%rsp), %rdi
	movl	20(%rsp), %ecx
	movl	%ecx, (%rdi)
	movq	32(%rsp), %rdi
	movl	24(%rsp), %ecx
	movl	%ecx, 4(%rdi)
	movq	32(%rsp), %rdi
	movl	28(%rsp), %ecx
	movl	%ecx, 8(%rdi)
	movq	8(%rsp), %rdi           # 8-byte Reload
	movl	24(%rdi), %ecx
	movq	(%rdi), %r8
	movq	32(%rsp), %r9
	movslq	%ecx, %r10
	movq	%r9, (%r8,%r10,8)
	movl	24(%rdi), %ecx
	movq	8(%rdi), %r8
	movl	20(%rsp), %edx
	movq	16(%rdi), %r9
	movslq	%edx, %r10
	movl	(%r9,%r10,4), %esi
	movslq	%ecx, %r9
	movslq	%edx, %r10
	movl	%esi, (%r8,%r9,4)
	movl	20(%rsp), %ecx
	movq	16(%rdi), %r8
	movl	24(%rdi), %edx
	movslq	%ecx, %r9
	movl	%edx, (%r8,%r9,4)
	movl	24(%rdi), %ecx
	addl	$1, %ecx
	movl	%ecx, 24(%rdi)
# %bb.1:                                # %exit.15
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end4:
	.size	addEdge.addEdge, .Lfunc_end4-addEdge.addEdge
	.cfi_endproc
                                        # -- End function
	.globl	nVertices.nVertices     # -- Begin function nVertices.nVertices
	.p2align	4, 0x90
	.type	nVertices.nVertices,@function
nVertices.nVertices:                    # @nVertices.nVertices
	.cfi_startproc
# %bb.0:                                # %entry.16
	movq	16(%rdi), %rax
	movl	-4(%rax), %ecx
	movl	%ecx, -4(%rsp)
# %bb.1:                                # %exit.16
	movl	-4(%rsp), %eax
	retq
.Lfunc_end5:
	.size	nVertices.nVertices, .Lfunc_end5-nVertices.nVertices
	.cfi_endproc
                                        # -- End function
	.globl	nEdges.nEdges           # -- Begin function nEdges.nEdges
	.p2align	4, 0x90
	.type	nEdges.nEdges,@function
nEdges.nEdges:                          # @nEdges.nEdges
	.cfi_startproc
# %bb.0:                                # %entry.17
	movq	(%rdi), %rax
	movl	-4(%rax), %ecx
	movl	%ecx, -20(%rsp)
# %bb.1:                                # %exit.17
	movl	-20(%rsp), %eax
	retq
.Lfunc_end6:
	.size	nEdges.nEdges, .Lfunc_end6-nEdges.nEdges
	.cfi_endproc
                                        # -- End function
	.globl	Array_Node.Array_Node   # -- Begin function Array_Node.Array_Node
	.p2align	4, 0x90
	.type	Array_Node.Array_Node,@function
Array_Node.Array_Node:                  # @Array_Node.Array_Node
	.cfi_startproc
# %bb.0:                                # %entry.18
	pushq	%rax
	.cfi_def_cfa_offset 16
	movl	$0, 8(%rdi)
	movl	$8, %eax
	shll	$4, %eax
	addl	$4, %eax
	movq	%rdi, (%rsp)            # 8-byte Spill
	movl	%eax, %edi
	callq	_bot_malloc
	movq	%rax, %rcx
	movl	$16, (%rax)
	addq	$4, %rcx
	movq	(%rsp), %rax            # 8-byte Reload
	movq	%rcx, (%rax)
# %bb.1:                                # %exit.18
	popq	%rax
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end7:
	.size	Array_Node.Array_Node, .Lfunc_end7-Array_Node.Array_Node
	.cfi_endproc
                                        # -- End function
	.globl	push_back.push_back     # -- Begin function push_back.push_back
	.p2align	4, 0x90
	.type	push_back.push_back,@function
push_back.push_back:                    # @push_back.push_back
	.cfi_startproc
# %bb.0:                                # %entry.19
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movq	%rsi, 16(%rsp)
	movq	%rdi, 8(%rsp)           # 8-byte Spill
	callq	size.size
	movq	8(%rsp), %rcx           # 8-byte Reload
	movq	(%rcx), %rdx
	cmpl	-4(%rdx), %eax
	je	.LBB8_2
	jmp	.LBB8_3
.LBB8_1:                                # %exit.19
	addq	$24, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB8_2:                                # %if.true
	.cfi_def_cfa_offset 32
	movq	8(%rsp), %rdi           # 8-byte Reload
	callq	doubleStorage.doubleStorage
	jmp	.LBB8_4
.LBB8_3:                                # %if.false
	jmp	.LBB8_4
.LBB8_4:                                # %if.exit
	movq	8(%rsp), %rax           # 8-byte Reload
	movl	8(%rax), %ecx
	movq	(%rax), %rdx
	movq	16(%rsp), %rsi
	movslq	%ecx, %rdi
	movq	%rsi, (%rdx,%rdi,8)
	movl	8(%rax), %ecx
	addl	$1, %ecx
	movl	%ecx, 8(%rax)
	jmp	.LBB8_1
.Lfunc_end8:
	.size	push_back.push_back, .Lfunc_end8-push_back.push_back
	.cfi_endproc
                                        # -- End function
	.globl	pop_back.pop_back       # -- Begin function pop_back.pop_back
	.p2align	4, 0x90
	.type	pop_back.pop_back,@function
pop_back.pop_back:                      # @pop_back.pop_back
	.cfi_startproc
# %bb.0:                                # %entry.20
	movl	8(%rdi), %eax
	addl	$-1, %eax
	movl	%eax, 8(%rdi)
	movl	8(%rdi), %eax
	movq	(%rdi), %rcx
	movslq	%eax, %rdx
	movq	(%rcx,%rdx,8), %rcx
	movslq	%eax, %rdx
	movq	%rcx, -8(%rsp)
# %bb.1:                                # %exit.20
	movq	-8(%rsp), %rax
	retq
.Lfunc_end9:
	.size	pop_back.pop_back, .Lfunc_end9-pop_back.pop_back
	.cfi_endproc
                                        # -- End function
	.globl	back.back               # -- Begin function back.back
	.p2align	4, 0x90
	.type	back.back,@function
back.back:                              # @back.back
	.cfi_startproc
# %bb.0:                                # %entry.21
	movl	8(%rdi), %eax
	subl	$1, %eax
	movq	(%rdi), %rcx
	movslq	%eax, %rdx
	movq	(%rcx,%rdx,8), %rcx
	movslq	%eax, %rdx
	movq	%rcx, -8(%rsp)
# %bb.1:                                # %exit.21
	movq	-8(%rsp), %rax
	retq
.Lfunc_end10:
	.size	back.back, .Lfunc_end10-back.back
	.cfi_endproc
                                        # -- End function
	.globl	front.front             # -- Begin function front.front
	.p2align	4, 0x90
	.type	front.front,@function
front.front:                            # @front.front
	.cfi_startproc
# %bb.0:                                # %entry.22
	movq	(%rdi), %rax
	movq	(%rax), %rax
	movq	%rax, -8(%rsp)
# %bb.1:                                # %exit.22
	movq	-8(%rsp), %rax
	retq
.Lfunc_end11:
	.size	front.front, .Lfunc_end11-front.front
	.cfi_endproc
                                        # -- End function
	.globl	size.size               # -- Begin function size.size
	.p2align	4, 0x90
	.type	size.size,@function
size.size:                              # @size.size
	.cfi_startproc
# %bb.0:                                # %entry.23
	movl	8(%rdi), %eax
	movl	%eax, -4(%rsp)
# %bb.1:                                # %exit.23
	movl	-4(%rsp), %eax
	retq
.Lfunc_end12:
	.size	size.size, .Lfunc_end12-size.size
	.cfi_endproc
                                        # -- End function
	.globl	resize.resize           # -- Begin function resize.resize
	.p2align	4, 0x90
	.type	resize.resize,@function
resize.resize:                          # @resize.resize
	.cfi_startproc
# %bb.0:                                # %entry.24
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movl	%esi, 20(%rsp)
	movq	%rdi, 8(%rsp)           # 8-byte Spill
	jmp	.LBB13_2
.LBB13_1:                               # %exit.24
	addq	$24, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB13_2:                               # %wh.cond
                                        # =>This Inner Loop Header: Depth=1
	.cfi_def_cfa_offset 32
	movq	8(%rsp), %rax           # 8-byte Reload
	movq	(%rax), %rcx
	movl	-4(%rcx), %edx
	cmpl	20(%rsp), %edx
	jge	.LBB13_4
# %bb.3:                                # %wh.body
                                        #   in Loop: Header=BB13_2 Depth=1
	movq	8(%rsp), %rdi           # 8-byte Reload
	callq	doubleStorage.doubleStorage
	jmp	.LBB13_2
.LBB13_4:                               # %wh.exit
	movl	20(%rsp), %eax
	movq	8(%rsp), %rcx           # 8-byte Reload
	movl	%eax, 8(%rcx)
	jmp	.LBB13_1
.Lfunc_end13:
	.size	resize.resize, .Lfunc_end13-resize.resize
	.cfi_endproc
                                        # -- End function
	.globl	get.get                 # -- Begin function get.get
	.p2align	4, 0x90
	.type	get.get,@function
get.get:                                # @get.get
	.cfi_startproc
# %bb.0:                                # %entry.25
	movl	%esi, -4(%rsp)
	movl	-4(%rsp), %eax
	movq	(%rdi), %rcx
	movslq	%eax, %rdx
	movq	(%rcx,%rdx,8), %rcx
	movslq	%eax, %rdx
	movq	%rcx, -16(%rsp)
# %bb.1:                                # %exit.25
	movq	-16(%rsp), %rax
	retq
.Lfunc_end14:
	.size	get.get, .Lfunc_end14-get.get
	.cfi_endproc
                                        # -- End function
	.globl	set.set                 # -- Begin function set.set
	.p2align	4, 0x90
	.type	set.set,@function
set.set:                                # @set.set
	.cfi_startproc
# %bb.0:                                # %entry.26
	movl	%esi, -12(%rsp)
	movq	%rdx, -8(%rsp)
	movl	-12(%rsp), %eax
	movq	(%rdi), %rcx
	movq	-8(%rsp), %rdx
	movslq	%eax, %rdi
	movq	%rdx, (%rcx,%rdi,8)
# %bb.1:                                # %exit.26
	retq
.Lfunc_end15:
	.size	set.set, .Lfunc_end15-set.set
	.cfi_endproc
                                        # -- End function
	.globl	swap.swap               # -- Begin function swap.swap
	.p2align	4, 0x90
	.type	swap.swap,@function
swap.swap:                              # @swap.swap
	.cfi_startproc
# %bb.0:                                # %entry.27
	movl	%esi, -16(%rsp)
	movl	%edx, -12(%rsp)
	movl	-16(%rsp), %eax
	movq	(%rdi), %rcx
	movslq	%eax, %r8
	movq	(%rcx,%r8,8), %rcx
	movslq	%eax, %r8
	movq	%rcx, -8(%rsp)
	movl	-16(%rsp), %eax
	movq	(%rdi), %rcx
	movl	-12(%rsp), %edx
	movq	(%rdi), %r9
	movslq	%edx, %r10
	movq	(%r9,%r10,8), %r9
	movslq	%eax, %r10
	movslq	%edx, %r11
	movq	%r9, (%rcx,%r10,8)
	movl	-12(%rsp), %eax
	movq	(%rdi), %rcx
	movq	-8(%rsp), %rdi
	movslq	%eax, %r9
	movq	%rdi, (%rcx,%r9,8)
# %bb.1:                                # %exit.27
	retq
.Lfunc_end16:
	.size	swap.swap, .Lfunc_end16-swap.swap
	.cfi_endproc
                                        # -- End function
	.globl	doubleStorage.doubleStorage # -- Begin function doubleStorage.doubleStorage
	.p2align	4, 0x90
	.type	doubleStorage.doubleStorage,@function
doubleStorage.doubleStorage:            # @doubleStorage.doubleStorage
	.cfi_startproc
# %bb.0:                                # %entry.28
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	movq	(%rdi), %rax
	movq	%rax, 16(%rsp)
	movl	8(%rdi), %ecx
	movl	%ecx, 28(%rsp)
	movq	16(%rsp), %rax
	movl	-4(%rax), %ecx
	shll	$1, %ecx
	movl	%ecx, %edx
	shll	$3, %edx
	addl	$4, %edx
	movq	%rdi, 8(%rsp)           # 8-byte Spill
	movl	%edx, %edi
	movl	%ecx, 4(%rsp)           # 4-byte Spill
	callq	_bot_malloc
	movq	%rax, %rsi
	movl	4(%rsp), %ecx           # 4-byte Reload
	movl	%ecx, (%rax)
	addq	$4, %rsi
	movq	8(%rsp), %rax           # 8-byte Reload
	movq	%rsi, (%rax)
	movl	$0, 8(%rax)
	jmp	.LBB17_2
.LBB17_1:                               # %exit.28
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB17_2:                               # %for.cond.2
                                        # =>This Inner Loop Header: Depth=1
	.cfi_def_cfa_offset 48
	movq	8(%rsp), %rax           # 8-byte Reload
	movl	8(%rax), %ecx
	cmpl	28(%rsp), %ecx
	jne	.LBB17_4
	jmp	.LBB17_5
.LBB17_3:                               # %for.incr.2
                                        #   in Loop: Header=BB17_2 Depth=1
	movq	8(%rsp), %rax           # 8-byte Reload
	movl	8(%rax), %ecx
	addl	$1, %ecx
	movl	%ecx, 8(%rax)
	jmp	.LBB17_2
.LBB17_4:                               # %for.body.2
                                        #   in Loop: Header=BB17_2 Depth=1
	movq	8(%rsp), %rax           # 8-byte Reload
	movl	8(%rax), %ecx
	movq	(%rax), %rdx
	movl	8(%rax), %esi
	movq	16(%rsp), %rdi
	movslq	%esi, %r8
	movq	(%rdi,%r8,8), %rdi
	movslq	%ecx, %r8
	movslq	%esi, %r9
	movq	%rdi, (%rdx,%r8,8)
	jmp	.LBB17_3
.LBB17_5:                               # %for.exit.2
	jmp	.LBB17_1
.Lfunc_end17:
	.size	doubleStorage.doubleStorage, .Lfunc_end17-doubleStorage.doubleStorage
	.cfi_endproc
                                        # -- End function
	.globl	Heap_Node.Heap_Node     # -- Begin function Heap_Node.Heap_Node
	.p2align	4, 0x90
	.type	Heap_Node.Heap_Node,@function
Heap_Node.Heap_Node:                    # @Heap_Node.Heap_Node
	.cfi_startproc
# %bb.0:                                # %entry.29
	subq	$24, %rsp
	.cfi_def_cfa_offset 32
	movl	$12, %eax
	movq	%rdi, 16(%rsp)          # 8-byte Spill
	movl	%eax, %edi
	callq	_bot_malloc
	movq	%rax, %rdi
	movq	%rax, 8(%rsp)           # 8-byte Spill
	callq	Array_Node.Array_Node
	movq	16(%rsp), %rax          # 8-byte Reload
	movq	8(%rsp), %rcx           # 8-byte Reload
	movq	%rcx, (%rax)
# %bb.1:                                # %exit.29
	addq	$24, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end18:
	.size	Heap_Node.Heap_Node, .Lfunc_end18-Heap_Node.Heap_Node
	.cfi_endproc
                                        # -- End function
	.globl	push.push               # -- Begin function push.push
	.p2align	4, 0x90
	.type	push.push,@function
push.push:                              # @push.push
	.cfi_startproc
# %bb.0:                                # %entry.30
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	movq	%rsi, 24(%rsp)
	movq	(%rdi), %rax
	movq	24(%rsp), %rsi
	movq	%rdi, 16(%rsp)          # 8-byte Spill
	movq	%rax, %rdi
	callq	push_back.push_back
	movq	16(%rsp), %rdi          # 8-byte Reload
	callq	size.size.1
	subl	$1, %eax
	movl	%eax, 32(%rsp)
	jmp	.LBB19_2
.LBB19_1:                               # %exit.30
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB19_2:                               # %wh.cond.1
                                        # =>This Inner Loop Header: Depth=1
	.cfi_def_cfa_offset 48
	cmpl	$0, 32(%rsp)
	jle	.LBB19_4
# %bb.3:                                # %wh.body.1
                                        #   in Loop: Header=BB19_2 Depth=1
	movl	32(%rsp), %esi
	movq	16(%rsp), %rdi          # 8-byte Reload
	callq	pnt.pnt
	movl	%eax, 36(%rsp)
	movq	16(%rsp), %rcx          # 8-byte Reload
	movq	(%rcx), %rdi
	movl	36(%rsp), %esi
	callq	get.get
	movq	%rax, %rdi
	callq	key_.key_
	movq	16(%rsp), %rcx          # 8-byte Reload
	movq	(%rcx), %rdi
	movl	32(%rsp), %esi
	movl	%eax, 12(%rsp)          # 4-byte Spill
	callq	get.get
	movq	%rax, %rdi
	callq	key_.key_
	movl	12(%rsp), %edx          # 4-byte Reload
	cmpl	%eax, %edx
	jge	.LBB19_5
	jmp	.LBB19_6
.LBB19_4:                               # %wh.exit.1
	jmp	.LBB19_1
.LBB19_5:                               # %if.true.1
	jmp	.LBB19_4
.LBB19_6:                               # %if.false.1
                                        #   in Loop: Header=BB19_2 Depth=1
	jmp	.LBB19_7
.LBB19_7:                               # %if.exit.1
                                        #   in Loop: Header=BB19_2 Depth=1
	movq	16(%rsp), %rax          # 8-byte Reload
	movq	(%rax), %rdi
	movl	36(%rsp), %esi
	movl	32(%rsp), %edx
	callq	swap.swap
	movl	36(%rsp), %ecx
	movl	%ecx, 32(%rsp)
	jmp	.LBB19_2
.Lfunc_end19:
	.size	push.push, .Lfunc_end19-push.push
	.cfi_endproc
                                        # -- End function
	.globl	pop.pop                 # -- Begin function pop.pop
	.p2align	4, 0x90
	.type	pop.pop,@function
pop.pop:                                # @pop.pop
	.cfi_startproc
# %bb.0:                                # %entry.31
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	movq	(%rdi), %rax
	movq	%rdi, 16(%rsp)          # 8-byte Spill
	movq	%rax, %rdi
	callq	front.front
	movq	%rax, 32(%rsp)
	movq	16(%rsp), %rax          # 8-byte Reload
	movq	(%rax), %rdi
	movq	%rdi, 8(%rsp)           # 8-byte Spill
	movq	%rax, %rdi
	callq	size.size.1
	xorl	%esi, %esi
	subl	$1, %eax
	movq	8(%rsp), %rdi           # 8-byte Reload
	movl	%eax, %edx
	callq	swap.swap
	movq	16(%rsp), %rcx          # 8-byte Reload
	movq	(%rcx), %rdi
	callq	pop_back.pop_back
	xorl	%esi, %esi
	movq	16(%rsp), %rdi          # 8-byte Reload
	movq	%rax, (%rsp)            # 8-byte Spill
	callq	maxHeapify.maxHeapify
	movq	32(%rsp), %rax
	movq	%rax, 24(%rsp)
# %bb.1:                                # %exit.31
	movq	24(%rsp), %rax
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end20:
	.size	pop.pop, .Lfunc_end20-pop.pop
	.cfi_endproc
                                        # -- End function
	.globl	top.top                 # -- Begin function top.top
	.p2align	4, 0x90
	.type	top.top,@function
top.top:                                # @top.top
	.cfi_startproc
# %bb.0:                                # %entry.32
	pushq	%rax
	.cfi_def_cfa_offset 16
	movq	(%rdi), %rdi
	callq	front.front
	movq	%rax, (%rsp)
# %bb.1:                                # %exit.32
	movq	(%rsp), %rax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end21:
	.size	top.top, .Lfunc_end21-top.top
	.cfi_endproc
                                        # -- End function
	.globl	size.size.1             # -- Begin function size.size.1
	.p2align	4, 0x90
	.type	size.size.1,@function
size.size.1:                            # @size.size.1
	.cfi_startproc
# %bb.0:                                # %entry.33
	pushq	%rax
	.cfi_def_cfa_offset 16
	movq	(%rdi), %rdi
	callq	size.size
	movl	%eax, 4(%rsp)
# %bb.1:                                # %exit.33
	movl	4(%rsp), %eax
	popq	%rcx
	.cfi_def_cfa_offset 8
	retq
.Lfunc_end22:
	.size	size.size.1, .Lfunc_end22-size.size.1
	.cfi_endproc
                                        # -- End function
	.globl	lchild.lchild           # -- Begin function lchild.lchild
	.p2align	4, 0x90
	.type	lchild.lchild,@function
lchild.lchild:                          # @lchild.lchild
	.cfi_startproc
# %bb.0:                                # %entry.34
	movl	%esi, -4(%rsp)
	movl	-4(%rsp), %eax
	shll	$1, %eax
	addl	$1, %eax
	movl	%eax, -8(%rsp)
# %bb.1:                                # %exit.34
	movl	-8(%rsp), %eax
	retq
.Lfunc_end23:
	.size	lchild.lchild, .Lfunc_end23-lchild.lchild
	.cfi_endproc
                                        # -- End function
	.globl	rchild.rchild           # -- Begin function rchild.rchild
	.p2align	4, 0x90
	.type	rchild.rchild,@function
rchild.rchild:                          # @rchild.rchild
	.cfi_startproc
# %bb.0:                                # %entry.35
	movl	%esi, -4(%rsp)
	movl	-4(%rsp), %eax
	shll	$1, %eax
	addl	$2, %eax
	movl	%eax, -8(%rsp)
# %bb.1:                                # %exit.35
	movl	-8(%rsp), %eax
	retq
.Lfunc_end24:
	.size	rchild.rchild, .Lfunc_end24-rchild.rchild
	.cfi_endproc
                                        # -- End function
	.globl	pnt.pnt                 # -- Begin function pnt.pnt
	.p2align	4, 0x90
	.type	pnt.pnt,@function
pnt.pnt:                                # @pnt.pnt
	.cfi_startproc
# %bb.0:                                # %entry.36
	movl	%esi, -4(%rsp)
	movl	-4(%rsp), %eax
	subl	$1, %eax
	cltd
	movl	$2, %ecx
	idivl	%ecx
	movl	%eax, -8(%rsp)
# %bb.1:                                # %exit.36
	movl	-8(%rsp), %eax
	retq
.Lfunc_end25:
	.size	pnt.pnt, .Lfunc_end25-pnt.pnt
	.cfi_endproc
                                        # -- End function
	.globl	maxHeapify.maxHeapify   # -- Begin function maxHeapify.maxHeapify
	.p2align	4, 0x90
	.type	maxHeapify.maxHeapify,@function
maxHeapify.maxHeapify:                  # @maxHeapify.maxHeapify
	.cfi_startproc
# %bb.0:                                # %entry.37
	subq	$56, %rsp
	.cfi_def_cfa_offset 64
	movl	%esi, 40(%rsp)
	movl	40(%rsp), %esi
	movq	%rdi, 32(%rsp)          # 8-byte Spill
	callq	lchild.lchild
	movl	%eax, 44(%rsp)
	movl	40(%rsp), %esi
	movq	32(%rsp), %rdi          # 8-byte Reload
	callq	rchild.rchild
	movl	%eax, 48(%rsp)
	movl	40(%rsp), %eax
	movl	%eax, 52(%rsp)
	movl	44(%rsp), %eax
	movq	32(%rsp), %rdi          # 8-byte Reload
	movl	%eax, 28(%rsp)          # 4-byte Spill
	callq	size.size.1
	movl	28(%rsp), %ecx          # 4-byte Reload
	cmpl	%eax, %ecx
	setl	%dl
	testb	$1, %dl
	movb	%dl, 27(%rsp)           # 1-byte Spill
	jne	.LBB26_5
	jmp	.LBB26_6
.LBB26_1:                               # %exit.37
	addq	$56, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB26_2:                               # %if.true.2
	.cfi_def_cfa_offset 64
	movl	44(%rsp), %eax
	movl	%eax, 52(%rsp)
	jmp	.LBB26_4
.LBB26_3:                               # %if.false.2
	jmp	.LBB26_4
.LBB26_4:                               # %if.exit.2
	movl	48(%rsp), %eax
	movq	32(%rsp), %rdi          # 8-byte Reload
	movl	%eax, 20(%rsp)          # 4-byte Spill
	callq	size.size.1
	movl	20(%rsp), %ecx          # 4-byte Reload
	cmpl	%eax, %ecx
	setl	%dl
	testb	$1, %dl
	movb	%dl, 19(%rsp)           # 1-byte Spill
	jne	.LBB26_10
	jmp	.LBB26_11
.LBB26_5:                               # %logic.uncut
	movq	32(%rsp), %rax          # 8-byte Reload
	movq	(%rax), %rdi
	movl	44(%rsp), %esi
	callq	get.get
	movq	%rax, %rdi
	callq	key_.key_
	movq	32(%rsp), %rcx          # 8-byte Reload
	movq	(%rcx), %rdi
	movl	52(%rsp), %esi
	movl	%eax, 12(%rsp)          # 4-byte Spill
	callq	get.get
	movq	%rax, %rdi
	callq	key_.key_
	movl	12(%rsp), %edx          # 4-byte Reload
	cmpl	%eax, %edx
	setg	%r8b
	movb	%r8b, 27(%rsp)          # 1-byte Spill
.LBB26_6:                               # %logic.exit
	movb	27(%rsp), %al           # 1-byte Reload
	testb	$1, %al
	jne	.LBB26_2
	jmp	.LBB26_3
.LBB26_7:                               # %if.true.3
	movl	48(%rsp), %eax
	movl	%eax, 52(%rsp)
	jmp	.LBB26_9
.LBB26_8:                               # %if.false.3
	jmp	.LBB26_9
.LBB26_9:                               # %if.exit.3
	movl	52(%rsp), %eax
	cmpl	40(%rsp), %eax
	je	.LBB26_12
	jmp	.LBB26_13
.LBB26_10:                              # %logic.uncut.1
	movq	32(%rsp), %rax          # 8-byte Reload
	movq	(%rax), %rdi
	movl	48(%rsp), %esi
	callq	get.get
	movq	%rax, %rdi
	callq	key_.key_
	movq	32(%rsp), %rcx          # 8-byte Reload
	movq	(%rcx), %rdi
	movl	52(%rsp), %esi
	movl	%eax, 8(%rsp)           # 4-byte Spill
	callq	get.get
	movq	%rax, %rdi
	callq	key_.key_
	movl	8(%rsp), %edx           # 4-byte Reload
	cmpl	%eax, %edx
	setg	%r8b
	movb	%r8b, 19(%rsp)          # 1-byte Spill
.LBB26_11:                              # %logic.exit.1
	movb	19(%rsp), %al           # 1-byte Reload
	testb	$1, %al
	jne	.LBB26_7
	jmp	.LBB26_8
.LBB26_12:                              # %if.true.4
	jmp	.LBB26_1
.LBB26_13:                              # %if.false.4
	jmp	.LBB26_14
.LBB26_14:                              # %if.exit.4
	movq	32(%rsp), %rax          # 8-byte Reload
	movq	(%rax), %rdi
	movl	40(%rsp), %esi
	movl	52(%rsp), %edx
	callq	swap.swap
	movl	52(%rsp), %esi
	movq	32(%rsp), %rdi          # 8-byte Reload
	callq	maxHeapify.maxHeapify
	jmp	.LBB26_1
.Lfunc_end26:
	.size	maxHeapify.maxHeapify, .Lfunc_end26-maxHeapify.maxHeapify
	.cfi_endproc
                                        # -- End function
	.globl	Node.Node               # -- Begin function Node.Node
	.p2align	4, 0x90
	.type	Node.Node,@function
Node.Node:                              # @Node.Node
	.cfi_startproc
# %bb.0:                                # %entry.38
	jmp	.LBB27_1
.LBB27_1:                               # %exit.38
	retq
.Lfunc_end27:
	.size	Node.Node, .Lfunc_end27-Node.Node
	.cfi_endproc
                                        # -- End function
	.globl	key_.key_               # -- Begin function key_.key_
	.p2align	4, 0x90
	.type	key_.key_,@function
key_.key_:                              # @key_.key_
	.cfi_startproc
# %bb.0:                                # %entry.39
	xorl	%eax, %eax
	subl	4(%rdi), %eax
	movl	%eax, -4(%rsp)
# %bb.1:                                # %exit.39
	movl	-4(%rsp), %eax
	retq
.Lfunc_end28:
	.size	key_.key_, .Lfunc_end28-key_.key_
	.cfi_endproc
                                        # -- End function
	.globl	init                    # -- Begin function init
	.p2align	4, 0x90
	.type	init,@function
init:                                   # @init
	.cfi_startproc
# %bb.0:                                # %entry.40
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	callq	getInt
	movl	%eax, n
	callq	getInt
	movl	%eax, m
	movl	$28, %edi
	callq	_bot_malloc
	movq	%rax, %rdi
	movq	%rax, 8(%rsp)           # 8-byte Spill
	callq	EdgeList.EdgeList
	movq	8(%rsp), %rax           # 8-byte Reload
	movq	%rax, g
	movq	g, %rdi
	movl	n, %esi
	movl	m, %edx
	callq	init.init
	movl	$0, 16(%rsp)
	jmp	.LBB29_2
.LBB29_1:                               # %exit.40
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB29_2:                               # %for.cond.3
                                        # =>This Inner Loop Header: Depth=1
	.cfi_def_cfa_offset 48
	movl	16(%rsp), %eax
	cmpl	m, %eax
	jl	.LBB29_4
	jmp	.LBB29_5
.LBB29_3:                               # %for.incr.3
                                        #   in Loop: Header=BB29_2 Depth=1
	movl	16(%rsp), %eax
	addl	$1, %eax
	movl	%eax, 16(%rsp)
	jmp	.LBB29_2
.LBB29_4:                               # %for.body.3
                                        #   in Loop: Header=BB29_2 Depth=1
	callq	getInt
	movl	%eax, 20(%rsp)
	callq	getInt
	movl	%eax, 24(%rsp)
	callq	getInt
	movl	%eax, 28(%rsp)
	movq	g, %rdi
	movl	20(%rsp), %esi
	movl	24(%rsp), %edx
	movl	28(%rsp), %ecx
	callq	addEdge.addEdge
	jmp	.LBB29_3
.LBB29_5:                               # %for.exit.3
	jmp	.LBB29_1
.Lfunc_end29:
	.size	init, .Lfunc_end29-init
	.cfi_endproc
                                        # -- End function
	.globl	dijkstra                # -- Begin function dijkstra
	.p2align	4, 0x90
	.type	dijkstra,@function
dijkstra:                               # @dijkstra
	.cfi_startproc
# %bb.0:                                # %entry.41
	subq	$136, %rsp
	.cfi_def_cfa_offset 144
	movl	%edi, 60(%rsp)
	movl	n, %eax
	movl	%eax, %ecx
	shll	$2, %ecx
	addl	$4, %ecx
	movl	%ecx, %edi
	movl	%eax, 44(%rsp)          # 4-byte Spill
	callq	_bot_malloc
	movabsq	$.Lanonym.strconst, %rdi
	movq	%rax, %rdx
	movl	44(%rsp), %ecx          # 4-byte Reload
	movl	%ecx, (%rax)
	addq	$4, %rdx
	movq	%rdx, 64(%rsp)
	callq	println
	movl	n, %edi
	callq	printlnInt
	movl	n, %ecx
	movl	%ecx, %esi
	shll	$2, %esi
	addl	$4, %esi
	movl	%esi, %edi
	movl	%ecx, 40(%rsp)          # 4-byte Spill
	callq	_bot_malloc
	movq	%rax, %rdx
	movl	40(%rsp), %ecx          # 4-byte Reload
	movl	%ecx, (%rax)
	addq	$4, %rdx
	movq	%rdx, 72(%rsp)
	movl	$0, 84(%rsp)
	jmp	.LBB30_2
.LBB30_1:                               # %exit.41
	movq	48(%rsp), %rax
	addq	$136, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB30_2:                               # %for.cond.4
                                        # =>This Inner Loop Header: Depth=1
	.cfi_def_cfa_offset 144
	movl	84(%rsp), %eax
	cmpl	n, %eax
	jl	.LBB30_4
	jmp	.LBB30_5
.LBB30_3:                               # %for.incr.4
                                        #   in Loop: Header=BB30_2 Depth=1
	movl	84(%rsp), %eax
	addl	$1, %eax
	movl	%eax, 84(%rsp)
	jmp	.LBB30_2
.LBB30_4:                               # %for.body.4
                                        #   in Loop: Header=BB30_2 Depth=1
	movl	84(%rsp), %eax
	movq	72(%rsp), %rcx
	movl	INF, %edx
	movslq	%eax, %rsi
	movl	%edx, (%rcx,%rsi,4)
	movl	84(%rsp), %eax
	movq	64(%rsp), %rcx
	movslq	%eax, %rsi
	movl	$0, (%rcx,%rsi,4)
	jmp	.LBB30_3
.LBB30_5:                               # %for.exit.4
	movl	60(%rsp), %eax
	movq	72(%rsp), %rcx
	movslq	%eax, %rdx
	movl	$0, (%rcx,%rdx,4)
	movl	$8, %edi
	callq	_bot_malloc
	movq	%rax, %rdi
	movq	%rax, 32(%rsp)          # 8-byte Spill
	callq	Heap_Node.Heap_Node
	movq	32(%rsp), %rax          # 8-byte Reload
	movq	%rax, 88(%rsp)
	movl	$8, %edi
	callq	_bot_malloc
	movq	%rax, %rdi
	movq	%rax, 24(%rsp)          # 8-byte Spill
	callq	Node.Node
	movq	24(%rsp), %rax          # 8-byte Reload
	movq	%rax, 96(%rsp)
	movq	96(%rsp), %rcx
	movl	$0, 4(%rcx)
	movq	96(%rsp), %rcx
	movl	60(%rsp), %esi
	movl	%esi, (%rcx)
	movq	88(%rsp), %rdi
	movq	96(%rsp), %rsi
	callq	push.push
.LBB30_6:                               # %wh.cond.2
                                        # =>This Loop Header: Depth=1
                                        #     Child Loop BB30_12 Depth 2
	movq	88(%rsp), %rdi
	callq	size.size.1
	cmpl	$0, %eax
	je	.LBB30_8
# %bb.7:                                # %wh.body.2
                                        #   in Loop: Header=BB30_6 Depth=1
	movq	88(%rsp), %rdi
	callq	pop.pop
	movq	%rax, 104(%rsp)
	movq	104(%rsp), %rax
	movl	(%rax), %ecx
	movl	%ecx, 116(%rsp)
	movl	116(%rsp), %edi
	callq	printlnInt
	movl	116(%rsp), %ecx
	movq	64(%rsp), %rax
	movslq	%ecx, %rdx
	cmpl	$1, (%rax,%rdx,4)
	je	.LBB30_9
	jmp	.LBB30_10
.LBB30_8:                               # %wh.exit.2
	movq	72(%rsp), %rax
	movq	%rax, 48(%rsp)
	jmp	.LBB30_1
.LBB30_9:                               # %if.true.5
                                        #   in Loop: Header=BB30_6 Depth=1
	movabsq	$.Lanonym.strconst.1, %rdi
	callq	println
	movq	88(%rsp), %rdi
	callq	size.size.1
	movl	%eax, %edi
	callq	printlnInt
	jmp	.LBB30_6
.LBB30_10:                              # %if.false.5
                                        #   in Loop: Header=BB30_6 Depth=1
	jmp	.LBB30_11
.LBB30_11:                              # %if.exit.5
                                        #   in Loop: Header=BB30_6 Depth=1
	movl	116(%rsp), %eax
	movq	64(%rsp), %rcx
	movslq	%eax, %rdx
	movl	$1, (%rcx,%rdx,4)
	movl	116(%rsp), %eax
	movq	g, %rcx
	movq	16(%rcx), %rcx
	movslq	%eax, %rdx
	movl	(%rcx,%rdx,4), %esi
	movslq	%eax, %rcx
	movl	%esi, 120(%rsp)
.LBB30_12:                              # %for.cond.5
                                        #   Parent Loop BB30_6 Depth=1
                                        # =>  This Inner Loop Header: Depth=2
	xorl	%eax, %eax
	movl	120(%rsp), %ecx
	subl	$1, %eax
	cmpl	%eax, %ecx
	jne	.LBB30_14
	jmp	.LBB30_15
.LBB30_13:                              # %for.incr.5
                                        #   in Loop: Header=BB30_12 Depth=2
	movl	120(%rsp), %eax
	movq	g, %rcx
	movq	8(%rcx), %rcx
	movslq	%eax, %rdx
	movl	(%rcx,%rdx,4), %esi
	movslq	%eax, %rcx
	movl	%esi, 120(%rsp)
	jmp	.LBB30_12
.LBB30_14:                              # %for.body.5
                                        #   in Loop: Header=BB30_12 Depth=2
	movl	120(%rsp), %eax
	movq	g, %rcx
	movq	(%rcx), %rcx
	movslq	%eax, %rdx
	movq	(%rcx,%rdx,8), %rcx
	movslq	%eax, %rdx
	movl	4(%rcx), %eax
	movl	%eax, 124(%rsp)
	movl	120(%rsp), %eax
	movq	g, %rcx
	movq	(%rcx), %rcx
	movslq	%eax, %rsi
	movq	(%rcx,%rsi,8), %rcx
	movslq	%eax, %rsi
	movl	8(%rcx), %eax
	movl	%eax, 128(%rsp)
	movl	116(%rsp), %eax
	movq	72(%rsp), %rcx
	movslq	%eax, %rdi
	movl	(%rcx,%rdi,4), %eax
	addl	128(%rsp), %eax
	movl	%eax, 132(%rsp)
	movl	132(%rsp), %eax
	movl	124(%rsp), %r8d
	movq	72(%rsp), %rcx
	movslq	%r8d, %rdi
	cmpl	(%rcx,%rdi,4), %eax
	jge	.LBB30_16
	jmp	.LBB30_17
.LBB30_15:                              # %for.exit.5
                                        #   in Loop: Header=BB30_6 Depth=1
	jmp	.LBB30_6
.LBB30_16:                              # %if.true.6
                                        #   in Loop: Header=BB30_12 Depth=2
	jmp	.LBB30_13
.LBB30_17:                              # %if.false.6
                                        #   in Loop: Header=BB30_12 Depth=2
	jmp	.LBB30_18
.LBB30_18:                              # %if.exit.6
                                        #   in Loop: Header=BB30_12 Depth=2
	movabsq	$.Lanonym.strconst.2, %rdi
	movl	124(%rsp), %eax
	movq	72(%rsp), %rcx
	movl	132(%rsp), %edx
	movslq	%eax, %rsi
	movl	%edx, (%rcx,%rsi,4)
	callq	println
	movl	$8, %edi
	callq	_bot_malloc
	movq	%rax, %rdi
	movq	%rax, 16(%rsp)          # 8-byte Spill
	callq	Node.Node
	movq	16(%rsp), %rax          # 8-byte Reload
	movq	%rax, 104(%rsp)
	movq	104(%rsp), %rcx
	movl	124(%rsp), %edx
	movl	%edx, (%rcx)
	movq	104(%rsp), %rcx
	movl	124(%rsp), %edx
	movq	72(%rsp), %rsi
	movslq	%edx, %rdi
	movl	(%rsi,%rdi,4), %r8d
	movslq	%edx, %rsi
	movl	%r8d, 4(%rcx)
	movq	88(%rsp), %rdi
	movq	104(%rsp), %rcx
	movq	%rsi, 8(%rsp)           # 8-byte Spill
	movq	%rcx, %rsi
	callq	push.push
	movabsq	$.Lanonym.strconst.3, %rdi
	callq	println
	jmp	.LBB30_13
.Lfunc_end30:
	.size	dijkstra, .Lfunc_end30-dijkstra
	.cfi_endproc
                                        # -- End function
	.globl	main                    # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:                                # %entry.42
	subq	$40, %rsp
	.cfi_def_cfa_offset 48
	callq	_global_init
	movl	$0, 20(%rsp)
	callq	init
	movl	$0, 24(%rsp)
	jmp	.LBB31_2
.LBB31_1:                               # %exit.42
	movl	20(%rsp), %eax
	addq	$40, %rsp
	.cfi_def_cfa_offset 8
	retq
.LBB31_2:                               # %for.cond.6
                                        # =>This Loop Header: Depth=1
                                        #     Child Loop BB31_6 Depth 2
	.cfi_def_cfa_offset 48
	movl	24(%rsp), %eax
	cmpl	n, %eax
	jl	.LBB31_4
	jmp	.LBB31_5
.LBB31_3:                               # %for.incr.6
                                        #   in Loop: Header=BB31_2 Depth=1
	movl	24(%rsp), %eax
	addl	$1, %eax
	movl	%eax, 24(%rsp)
	jmp	.LBB31_2
.LBB31_4:                               # %for.body.6
                                        #   in Loop: Header=BB31_2 Depth=1
	movl	24(%rsp), %edi
	callq	dijkstra
	movq	%rax, 32(%rsp)
	movl	$0, 28(%rsp)
	jmp	.LBB31_6
.LBB31_5:                               # %for.exit.6
	movl	$0, 20(%rsp)
	jmp	.LBB31_1
.LBB31_6:                               # %for.cond.7
                                        #   Parent Loop BB31_2 Depth=1
                                        # =>  This Inner Loop Header: Depth=2
	movl	28(%rsp), %eax
	cmpl	n, %eax
	jl	.LBB31_8
	jmp	.LBB31_9
.LBB31_7:                               # %for.incr.7
                                        #   in Loop: Header=BB31_6 Depth=2
	movl	28(%rsp), %eax
	addl	$1, %eax
	movl	%eax, 28(%rsp)
	jmp	.LBB31_6
.LBB31_8:                               # %for.body.7
                                        #   in Loop: Header=BB31_6 Depth=2
	movl	28(%rsp), %eax
	movq	32(%rsp), %rcx
	movslq	%eax, %rdx
	movl	(%rcx,%rdx,4), %eax
	cmpl	INF, %eax
	je	.LBB31_10
	jmp	.LBB31_11
.LBB31_9:                               # %for.exit.7
                                        #   in Loop: Header=BB31_2 Depth=1
	movabsq	$.Lanonym.strconst.6, %rdi
	callq	println
	jmp	.LBB31_3
.LBB31_10:                              # %if.true.7
                                        #   in Loop: Header=BB31_6 Depth=2
	movabsq	$.Lanonym.strconst.4, %rdi
	callq	print
	jmp	.LBB31_12
.LBB31_11:                              # %if.false.7
                                        #   in Loop: Header=BB31_6 Depth=2
	movl	28(%rsp), %eax
	movq	32(%rsp), %rcx
	movslq	%eax, %rdx
	movl	(%rcx,%rdx,4), %edi
	movslq	%eax, %rcx
	movq	%rcx, 8(%rsp)           # 8-byte Spill
	callq	toString
	movq	%rax, %rdi
	callq	print
.LBB31_12:                              # %if.exit.7
                                        #   in Loop: Header=BB31_6 Depth=2
	movabsq	$.Lanonym.strconst.5, %rdi
	callq	print
	jmp	.LBB31_7
.Lfunc_end31:
	.size	main, .Lfunc_end31-main
	.cfi_endproc
                                        # -- End function
	.type	n,@object               # @n
	.bss
	.globl	n
	.p2align	2
n:
	.long	0                       # 0x0
	.size	n, 4

	.type	m,@object               # @m
	.globl	m
	.p2align	2
m:
	.long	0                       # 0x0
	.size	m, 4

	.type	g,@object               # @g
	.globl	g
	.p2align	3
g:
	.quad	0
	.size	g, 8

	.type	INF,@object             # @INF
	.globl	INF
	.p2align	2
INF:
	.long	0                       # 0x0
	.size	INF, 4

	.type	.Lanonym.strconst,@object # @anonym.strconst
	.section	.rodata.str1.1,"aMS",@progbits,1
.Lanonym.strconst:
	.asciz	"dij start"
	.size	.Lanonym.strconst, 10

	.type	.Lanonym.strconst.1,@object # @anonym.strconst.1
.Lanonym.strconst.1:
	.asciz	"visit continue"
	.size	.Lanonym.strconst.1, 15

	.type	.Lanonym.strconst.2,@object # @anonym.strconst.2
.Lanonym.strconst.2:
	.asciz	"newing start"
	.size	.Lanonym.strconst.2, 13

	.type	.Lanonym.strconst.3,@object # @anonym.strconst.3
.Lanonym.strconst.3:
	.asciz	"newing over"
	.size	.Lanonym.strconst.3, 12

	.type	.Lanonym.strconst.4,@object # @anonym.strconst.4
.Lanonym.strconst.4:
	.asciz	"-1"
	.size	.Lanonym.strconst.4, 3

	.type	.Lanonym.strconst.5,@object # @anonym.strconst.5
.Lanonym.strconst.5:
	.asciz	" "
	.size	.Lanonym.strconst.5, 2

	.type	.Lanonym.strconst.6,@object # @anonym.strconst.6
.Lanonym.strconst.6:
	.zero	1
	.size	.Lanonym.strconst.6, 1

	.section	".note.GNU-stack","",@progbits
	.addrsig
	.addrsig_sym _bot_malloc
	.addrsig_sym print
	.addrsig_sym println
	.addrsig_sym printlnInt
	.addrsig_sym getInt
	.addrsig_sym toString
	.addrsig_sym _global_init
	.addrsig_sym Edge.Edge
	.addrsig_sym EdgeList.EdgeList
	.addrsig_sym init.init
	.addrsig_sym addEdge.addEdge
	.addrsig_sym Array_Node.Array_Node
	.addrsig_sym push_back.push_back
	.addrsig_sym pop_back.pop_back
	.addrsig_sym front.front
	.addrsig_sym size.size
	.addrsig_sym get.get
	.addrsig_sym swap.swap
	.addrsig_sym doubleStorage.doubleStorage
	.addrsig_sym Heap_Node.Heap_Node
	.addrsig_sym push.push
	.addrsig_sym pop.pop
	.addrsig_sym size.size.1
	.addrsig_sym lchild.lchild
	.addrsig_sym rchild.rchild
	.addrsig_sym pnt.pnt
	.addrsig_sym maxHeapify.maxHeapify
	.addrsig_sym Node.Node
	.addrsig_sym key_.key_
	.addrsig_sym init
	.addrsig_sym dijkstra
	.addrsig_sym n
	.addrsig_sym m
	.addrsig_sym g
	.addrsig_sym INF
