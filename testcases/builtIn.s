	.text
	.file	"builtIn.c"
	.globl	print                   # -- Begin function print
	.p2align	4, 0x90
	.type	print,@function
print:                                  # @print
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rsi
	movabsq	$.L.str, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end0:
	.size	print, .Lfunc_end0-print
	.cfi_endproc
                                        # -- End function
	.globl	println                 # -- Begin function println
	.p2align	4, 0x90
	.type	println,@function
println:                                # @println
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rsi
	movabsq	$.L.str.1, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end1:
	.size	println, .Lfunc_end1-println
	.cfi_endproc
                                        # -- End function
	.globl	printInt                # -- Begin function printInt
	.p2align	4, 0x90
	.type	printInt,@function
printInt:                               # @printInt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movl	-4(%rbp), %esi
	movabsq	$.L.str.2, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end2:
	.size	printInt, .Lfunc_end2-printInt
	.cfi_endproc
                                        # -- End function
	.globl	printlnInt              # -- Begin function printlnInt
	.p2align	4, 0x90
	.type	printlnInt,@function
printlnInt:                             # @printlnInt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movl	-4(%rbp), %esi
	movabsq	$.L.str.3, %rdi
	movb	$0, %al
	callq	printf
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end3:
	.size	printlnInt, .Lfunc_end3-printlnInt
	.cfi_endproc
                                        # -- End function
	.globl	getString               # -- Begin function getString
	.p2align	4, 0x90
	.type	getString,@function
getString:                              # @getString
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	$257, %edi              # imm = 0x101
	callq	malloc
	movq	%rax, -8(%rbp)
	movq	-8(%rbp), %rsi
	movabsq	$.L.str, %rdi
	movb	$0, %al
	callq	__isoc99_scanf
	movq	-8(%rbp), %rcx
	movl	%eax, -12(%rbp)         # 4-byte Spill
	movq	%rcx, %rax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end4:
	.size	getString, .Lfunc_end4-getString
	.cfi_endproc
                                        # -- End function
	.globl	getInt                  # -- Begin function getInt
	.p2align	4, 0x90
	.type	getInt,@function
getInt:                                 # @getInt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movabsq	$.L.str.2, %rdi
	leaq	-4(%rbp), %rsi
	movb	$0, %al
	callq	__isoc99_scanf
	movl	-4(%rbp), %ecx
	movl	%eax, -8(%rbp)          # 4-byte Spill
	movl	%ecx, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end5:
	.size	getInt, .Lfunc_end5-getInt
	.cfi_endproc
                                        # -- End function
	.globl	toString                # -- Begin function toString
	.p2align	4, 0x90
	.type	toString,@function
toString:                               # @toString
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$64, %rsp
	movl	%edi, -12(%rbp)
	cmpl	$0, -12(%rbp)
	jne	.LBB6_2
# %bb.1:
	movl	$2, %edi
	callq	malloc
	movq	%rax, -24(%rbp)
	movq	-24(%rbp), %rax
	movb	$48, (%rax)
	movq	-24(%rbp), %rax
	movb	$0, 1(%rax)
	movq	-24(%rbp), %rax
	movq	%rax, -8(%rbp)
	jmp	.LBB6_14
.LBB6_2:
	movb	$0, -36(%rbp)
	cmpl	$0, -12(%rbp)
	jle	.LBB6_4
# %bb.3:
	movb	$0, -35(%rbp)
	jmp	.LBB6_5
.LBB6_4:
	xorl	%eax, %eax
	movb	$1, -35(%rbp)
	subl	-12(%rbp), %eax
	movl	%eax, -12(%rbp)
.LBB6_5:
	jmp	.LBB6_6
.LBB6_6:                                # =>This Inner Loop Header: Depth=1
	cmpl	$0, -12(%rbp)
	jle	.LBB6_8
# %bb.7:                                #   in Loop: Header=BB6_6 Depth=1
	movl	-12(%rbp), %eax
	cltd
	movl	$10, %ecx
	idivl	%ecx
                                        # kill: def $dl killed $dl killed $edx
	movb	-36(%rbp), %sil
	movb	%sil, %dil
	addb	$1, %dil
	movb	%dil, -36(%rbp)
	movsbq	%sil, %r8
	movb	%dl, -34(%rbp,%r8)
	movl	-12(%rbp), %r9d
	movl	%r9d, %eax
	cltd
	idivl	%ecx
	movl	%eax, -12(%rbp)
	jmp	.LBB6_6
.LBB6_8:
	movsbl	-35(%rbp), %eax
	movsbl	-36(%rbp), %ecx
	addl	%ecx, %eax
	addl	$1, %eax
	movslq	%eax, %rdx
	shlq	$0, %rdx
	movq	%rdx, %rdi
	callq	malloc
	movq	%rax, -48(%rbp)
	movsbl	-35(%rbp), %ecx
	cmpl	$0, %ecx
	jle	.LBB6_10
# %bb.9:
	movq	-48(%rbp), %rax
	movb	$45, (%rax)
.LBB6_10:
	movb	$0, -49(%rbp)
.LBB6_11:                               # =>This Inner Loop Header: Depth=1
	movsbl	-49(%rbp), %eax
	movsbl	-36(%rbp), %ecx
	cmpl	%ecx, %eax
	jge	.LBB6_13
# %bb.12:                               #   in Loop: Header=BB6_11 Depth=1
	movsbl	-36(%rbp), %eax
	movsbl	-49(%rbp), %ecx
	subl	%ecx, %eax
	subl	$1, %eax
	movslq	%eax, %rdx
	movsbl	-34(%rbp,%rdx), %eax
	addl	$48, %eax
                                        # kill: def $al killed $al killed $eax
	movq	-48(%rbp), %rdx
	movsbl	-49(%rbp), %ecx
	movsbl	-35(%rbp), %esi
	addl	%esi, %ecx
	movslq	%ecx, %rdi
	movb	%al, (%rdx,%rdi)
	movb	-49(%rbp), %al
	addb	$1, %al
	movb	%al, -49(%rbp)
	jmp	.LBB6_11
.LBB6_13:
	movq	-48(%rbp), %rax
	movsbl	-36(%rbp), %ecx
	movsbl	-35(%rbp), %edx
	addl	%edx, %ecx
	movslq	%ecx, %rsi
	movb	$0, (%rax,%rsi)
	movq	-48(%rbp), %rax
	movq	%rax, -8(%rbp)
.LBB6_14:
	movq	-8(%rbp), %rax
	addq	$64, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end6:
	.size	toString, .Lfunc_end6-toString
	.cfi_endproc
                                        # -- End function
	.globl	_bot_malloc             # -- Begin function _bot_malloc
	.p2align	4, 0x90
	.type	_bot_malloc,@function
_bot_malloc:                            # @_bot_malloc
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movl	%edi, -4(%rbp)
	movslq	-4(%rbp), %rdi
	callq	malloc
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end7:
	.size	_bot_malloc, .Lfunc_end7-_bot_malloc
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_cat            # -- Begin function _bot_str_cat
	.p2align	4, 0x90
	.type	_bot_str_cat,@function
_bot_str_cat:                           # @_bot_str_cat
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$48, %rsp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	-8(%rbp), %rdi
	callq	strlen
                                        # kill: def $eax killed $eax killed $rax
	movl	%eax, -20(%rbp)
	movq	-16(%rbp), %rdi
	callq	strlen
                                        # kill: def $eax killed $eax killed $rax
	movl	%eax, -24(%rbp)
	movl	-20(%rbp), %eax
	addl	-24(%rbp), %eax
	addl	$1, %eax
	movslq	%eax, %rcx
	shlq	$0, %rcx
	movq	%rcx, %rdi
	callq	malloc
	movq	%rax, -32(%rbp)
	movq	-32(%rbp), %rdi
	movq	-8(%rbp), %rsi
	callq	strcat
	movq	-32(%rbp), %rdi
	movq	-16(%rbp), %rsi
	movq	%rax, -40(%rbp)         # 8-byte Spill
	callq	strcat
	movq	-32(%rbp), %rcx
	movq	%rax, -48(%rbp)         # 8-byte Spill
	movq	%rcx, %rax
	addq	$48, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end8:
	.size	_bot_str_cat, .Lfunc_end8-_bot_str_cat
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_eq             # -- Begin function _bot_str_eq
	.p2align	4, 0x90
	.type	_bot_str_eq,@function
_bot_str_eq:                            # @_bot_str_eq
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	sete	%cl
	andb	$1, %cl
	movzbl	%cl, %eax
                                        # kill: def $al killed $al killed $eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end9:
	.size	_bot_str_eq, .Lfunc_end9-_bot_str_eq
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_neq            # -- Begin function _bot_str_neq
	.p2align	4, 0x90
	.type	_bot_str_neq,@function
_bot_str_neq:                           # @_bot_str_neq
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setne	%cl
	andb	$1, %cl
	movzbl	%cl, %eax
                                        # kill: def $al killed $al killed $eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end10:
	.size	_bot_str_neq, .Lfunc_end10-_bot_str_neq
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_slt            # -- Begin function _bot_str_slt
	.p2align	4, 0x90
	.type	_bot_str_slt,@function
_bot_str_slt:                           # @_bot_str_slt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setl	%cl
	andb	$1, %cl
	movzbl	%cl, %eax
                                        # kill: def $al killed $al killed $eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end11:
	.size	_bot_str_slt, .Lfunc_end11-_bot_str_slt
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sgt            # -- Begin function _bot_str_sgt
	.p2align	4, 0x90
	.type	_bot_str_sgt,@function
_bot_str_sgt:                           # @_bot_str_sgt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setg	%cl
	andb	$1, %cl
	movzbl	%cl, %eax
                                        # kill: def $al killed $al killed $eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end12:
	.size	_bot_str_sgt, .Lfunc_end12-_bot_str_sgt
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sle            # -- Begin function _bot_str_sle
	.p2align	4, 0x90
	.type	_bot_str_sle,@function
_bot_str_sle:                           # @_bot_str_sle
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setle	%cl
	andb	$1, %cl
	movzbl	%cl, %eax
                                        # kill: def $al killed $al killed $eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end13:
	.size	_bot_str_sle, .Lfunc_end13-_bot_str_sle
	.cfi_endproc
                                        # -- End function
	.globl	_bot_str_sge            # -- Begin function _bot_str_sge
	.p2align	4, 0x90
	.type	_bot_str_sge,@function
_bot_str_sge:                           # @_bot_str_sge
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	%rsi, -16(%rbp)
	movq	-8(%rbp), %rdi
	movq	-16(%rbp), %rsi
	callq	strcmp
	cmpl	$0, %eax
	setge	%cl
	andb	$1, %cl
	movzbl	%cl, %eax
                                        # kill: def $al killed $al killed $eax
	movsbl	%al, %eax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end14:
	.size	_bot_str_sge, .Lfunc_end14-_bot_str_sge
	.cfi_endproc
                                        # -- End function
	.globl	_str_length             # -- Begin function _str_length
	.p2align	4, 0x90
	.type	_str_length,@function
_str_length:                            # @_str_length
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$16, %rsp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rdi
	callq	strlen
                                        # kill: def $eax killed $eax killed $rax
	addq	$16, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end15:
	.size	_str_length, .Lfunc_end15-_str_length
	.cfi_endproc
                                        # -- End function
	.globl	__str_substring         # -- Begin function __str_substring
	.p2align	4, 0x90
	.type	__str_substring,@function
__str_substring:                        # @__str_substring
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	subq	$48, %rsp
	movq	%rdi, -8(%rbp)
	movl	%esi, -12(%rbp)
	movl	%edx, -16(%rbp)
	movl	-16(%rbp), %eax
	subl	-12(%rbp), %eax
	movl	%eax, -20(%rbp)
	movl	-20(%rbp), %eax
	addl	$1, %eax
	movslq	%eax, %rcx
	shlq	$0, %rcx
	movq	%rcx, %rdi
	callq	malloc
	movq	%rax, -32(%rbp)
	movl	$0, -36(%rbp)
.LBB16_1:                               # =>This Inner Loop Header: Depth=1
	movl	-36(%rbp), %eax
	cmpl	-20(%rbp), %eax
	jge	.LBB16_3
# %bb.2:                                #   in Loop: Header=BB16_1 Depth=1
	movq	-8(%rbp), %rax
	movl	-12(%rbp), %ecx
	addl	-36(%rbp), %ecx
	movslq	%ecx, %rdx
	movb	(%rax,%rdx), %sil
	movq	-32(%rbp), %rax
	movslq	-36(%rbp), %rdx
	movb	%sil, (%rax,%rdx)
	movl	-36(%rbp), %ecx
	addl	$1, %ecx
	movl	%ecx, -36(%rbp)
	jmp	.LBB16_1
.LBB16_3:
	movq	-32(%rbp), %rax
	movslq	-20(%rbp), %rcx
	movb	$0, (%rax,%rcx)
	movq	-32(%rbp), %rax
	addq	$48, %rsp
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end16:
	.size	__str_substring, .Lfunc_end16-__str_substring
	.cfi_endproc
                                        # -- End function
	.globl	_str_parseInt           # -- Begin function _str_parseInt
	.p2align	4, 0x90
	.type	_str_parseInt,@function
_str_parseInt:                          # @_str_parseInt
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movl	$0, -12(%rbp)
	movl	$0, -16(%rbp)
.LBB17_1:                               # =>This Inner Loop Header: Depth=1
	xorl	%eax, %eax
                                        # kill: def $al killed $al killed $eax
	movq	-8(%rbp), %rcx
	movslq	-16(%rbp), %rdx
	movsbl	(%rcx,%rdx), %esi
	cmpl	$0, %esi
	movb	%al, -17(%rbp)          # 1-byte Spill
	je	.LBB17_4
# %bb.2:                                #   in Loop: Header=BB17_1 Depth=1
	xorl	%eax, %eax
                                        # kill: def $al killed $al killed $eax
	movq	-8(%rbp), %rcx
	movslq	-16(%rbp), %rdx
	movsbl	(%rcx,%rdx), %esi
	cmpl	$48, %esi
	movb	%al, -17(%rbp)          # 1-byte Spill
	jl	.LBB17_4
# %bb.3:                                #   in Loop: Header=BB17_1 Depth=1
	movq	-8(%rbp), %rax
	movslq	-16(%rbp), %rcx
	movsbl	(%rax,%rcx), %edx
	cmpl	$57, %edx
	setle	%sil
	movb	%sil, -17(%rbp)         # 1-byte Spill
.LBB17_4:                               #   in Loop: Header=BB17_1 Depth=1
	movb	-17(%rbp), %al          # 1-byte Reload
	testb	$1, %al
	jne	.LBB17_5
	jmp	.LBB17_6
.LBB17_5:                               #   in Loop: Header=BB17_1 Depth=1
	imull	$10, -12(%rbp), %eax
	movq	-8(%rbp), %rcx
	movl	-16(%rbp), %edx
	movl	%edx, %esi
	addl	$1, %esi
	movl	%esi, -16(%rbp)
	movslq	%edx, %rdi
	movsbl	(%rcx,%rdi), %edx
	addl	%edx, %eax
	subl	$48, %eax
	movl	%eax, -12(%rbp)
	jmp	.LBB17_1
.LBB17_6:
	movl	-12(%rbp), %eax
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end17:
	.size	_str_parseInt, .Lfunc_end17-_str_parseInt
	.cfi_endproc
                                        # -- End function
	.globl	__str_ord               # -- Begin function __str_ord
	.p2align	4, 0x90
	.type	__str_ord,@function
__str_ord:                              # @__str_ord
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movl	%esi, -12(%rbp)
	movq	-8(%rbp), %rax
	movslq	-12(%rbp), %rcx
	movsbl	(%rax,%rcx), %eax
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end18:
	.size	__str_ord, .Lfunc_end18-__str_ord
	.cfi_endproc
                                        # -- End function
	.globl	_array_size             # -- Begin function _array_size
	.p2align	4, 0x90
	.type	_array_size,@function
_array_size:                            # @_array_size
	.cfi_startproc
# %bb.0:
	pushq	%rbp
	.cfi_def_cfa_offset 16
	.cfi_offset %rbp, -16
	movq	%rsp, %rbp
	.cfi_def_cfa_register %rbp
	movq	%rdi, -8(%rbp)
	movq	-8(%rbp), %rax
	movl	-4(%rax), %eax
	popq	%rbp
	.cfi_def_cfa %rsp, 8
	retq
.Lfunc_end19:
	.size	_array_size, .Lfunc_end19-_array_size
	.cfi_endproc
                                        # -- End function
	.type	.L.str,@object          # @.str
	.section	.rodata.str1.1,"aMS",@progbits,1
.L.str:
	.asciz	"%s"
	.size	.L.str, 3

	.type	.L.str.1,@object        # @.str.1
.L.str.1:
	.asciz	"%s\n"
	.size	.L.str.1, 4

	.type	.L.str.2,@object        # @.str.2
.L.str.2:
	.asciz	"%d"
	.size	.L.str.2, 3

	.type	.L.str.3,@object        # @.str.3
.L.str.3:
	.asciz	"%d\n"
	.size	.L.str.3, 4

	.ident	"clang version 10.0.0-4ubuntu1 "
	.section	".note.GNU-stack","",@progbits
	.addrsig
	.addrsig_sym printf
	.addrsig_sym malloc
	.addrsig_sym __isoc99_scanf
	.addrsig_sym strlen
	.addrsig_sym strcat
	.addrsig_sym strcmp
