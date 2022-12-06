	.text
	.file	"aruba.ll"
	.globl	_glb_init               # -- Begin function _glb_init
	.p2align	4, 0x90
	.type	_glb_init,@function
_glb_init:                              # @_glb_init
	.cfi_startproc
# %bb.0:                                # %entry.11
	movl	$0, c
# %bb.1:                                # %exit.11
	retq
.Lfunc_end0:
	.size	_glb_init, .Lfunc_end0-_glb_init
	.cfi_endproc
                                        # -- End function
	.globl	main                    # -- Begin function main
	.p2align	4, 0x90
	.type	main,@function
main:                                   # @main
	.cfi_startproc
# %bb.0:                                # %entry.12
	pushq	%rax
	.cfi_def_cfa_offset 16
	callq	_glb_init
	movl	$0, 4(%rsp)
	callq	getInt
	movl	%eax, n
	movl	$0, k
	jmp	.LBB1_2
.LBB1_1:                                # %for.incr
                                        #   in Loop: Header=BB1_2 Depth=1
	movl	k, %eax
	addl	$1, %eax
	movl	%eax, k
.LBB1_2:                                # %for.cond
                                        # =>This Inner Loop Header: Depth=1
	jmp	.LBB1_3
.LBB1_3:                                # %for.body
                                        #   in Loop: Header=BB1_2 Depth=1
	callq	getInt
	movl	%eax, x
	callq	getInt
	movl	%eax, y
	callq	getInt
	movl	%eax, z
	movl	x, %eax
	addl	y, %eax
	addl	z, %eax
	cmpl	$1, %eax
	jle	.LBB1_5
# %bb.4:                                # %if.true
                                        #   in Loop: Header=BB1_2 Depth=1
	movl	c, %eax
	addl	$1, %eax
	movl	%eax, c
	jmp	.LBB1_6
.LBB1_5:                                # %if.false
                                        #   in Loop: Header=BB1_2 Depth=1
	jmp	.LBB1_6
.LBB1_6:                                # %if.exit
                                        #   in Loop: Header=BB1_2 Depth=1
	jmp	.LBB1_1
.Lfunc_end1:
	.size	main, .Lfunc_end1-main
	.cfi_endproc
                                        # -- End function
	.type	n,@object               # @n
	.bss
	.globl	n
	.p2align	2
n:
	.long	0                       # 0x0
	.size	n, 4

	.type	x,@object               # @x
	.globl	x
	.p2align	2
x:
	.long	0                       # 0x0
	.size	x, 4

	.type	y,@object               # @y
	.globl	y
	.p2align	2
y:
	.long	0                       # 0x0
	.size	y, 4

	.type	z,@object               # @z
	.globl	z
	.p2align	2
z:
	.long	0                       # 0x0
	.size	z, 4

	.type	c,@object               # @c
	.globl	c
	.p2align	2
c:
	.long	0                       # 0x0
	.size	c, 4

	.type	k,@object               # @k
	.globl	k
	.p2align	2
k:
	.long	0                       # 0x0
	.size	k, 4

	.section	".note.GNU-stack","",@progbits
	.addrsig
	.addrsig_sym getInt
	.addrsig_sym _glb_init
	.addrsig_sym n
	.addrsig_sym x
	.addrsig_sym y
	.addrsig_sym z
	.addrsig_sym c
	.addrsig_sym k
