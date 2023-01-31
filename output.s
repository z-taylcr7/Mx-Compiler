	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -32
	sw	s0, 12(sp)
	sw	s1, 8(sp)
	sw	s2, 4(sp)
	sw	s3, 0(sp)
	sw	ra, 16(sp)
	j	split
exit.12:
	li	a0, 0
	lw	s0, 12(sp)
	lw	s1, 8(sp)
	lw	s2, 4(sp)
	lw	s3, 0(sp)
	lw	ra, 16(sp)
	addi	sp, sp, 32
	ret
for.cond:
	li	t2, 5
	blt	s3,t2,for.body
	j	for.exit
for.incr:
	addi	t1, s3, 1
	mv	s3, t1
	mv	t1, s1
	mv	t0, s2
	j	for.cond
for.body:
	li	s0, 0
	mv	s1, t1
	mv	s2, t0
	j	for.cond.1
for.exit:
	la	a0, anon.strconst
	call	println
	j	exit.12
for.cond.1:
	li	t0, 5
	blt	s0,t0,for.body.1
	j	for.incr
for.incr.1:
	addi	t2, s0, 1
	mv	s0, t2
	mv	s1, t1
	mv	s2, t0
	j	for.cond.1
for.body.1:
	call	getInt
	li	t0, 1
	beq	a0,t0,if.true
	j	if.false
if.true:
	mv	t1, s0
	mv	t0, s3
	j	for.incr.1
if.false:
	mv	t1, s1
	mv	t0, s2
	j	for.incr.1
split:
	li	s3, 0
	mv	t1, zero
	mv	t0, zero
	mv	a0, zero
	j	for.cond
	.size	main, .-main
                                        # -- End function
	.type	anon.strconst,@object
	.section	.rodata
anon.strconst:
	.asciz	"done"
	.size	anon.strconst, 4
