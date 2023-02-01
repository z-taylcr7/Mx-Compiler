	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -16
	sw	s0, 0(sp)
	sw	ra, 4(sp)
	lui	t0, %hi(t)
	lui	t0, %hi(i)
	lw	t0, %lo(i)(t0)
	j	split
exit.12:
	lui	t0, %hi(t)
	sw	s0, %lo(t)(t0)
	lui	t0, %hi(i)
	sw	zero, %lo(i)(t0)
	li	a0, 0
	lw	s0, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 16
	ret
for.cond:
	blt	zero,s0,for.body
	j	exit.12
for.incr:
	addi	t0, zero, 1
	j	for.cond
for.body:
	la	a0, anon.strconst
	call	println
	j	for.incr
split:
	call	getInt
	mv	s0, a0
	j	for.cond
	.size	main, .-main
                            #function ends.
	.type	i,@object
	.section	.bss
	.globl	i
i:
	.word	0
	.size	i, 4
	.type	t,@object
	.section	.bss
	.globl	t
t:
	.word	0
	.size	t, 4
	.type	anon.strconst,@object
	.section	.rodata
anon.strconst:
	.asciz	"into cycle."
	.size	anon.strconst, 11
