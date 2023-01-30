	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.13:
	addi	sp, sp, -16
	sw	ra, 0(sp)
	j	entry.11.i
exit.13:
	li	a0, 0
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
entry.12.i:
	li	t1, 2
	li	t2, 1
	li	t0, 10
	j	wh.cond.i
exit.12.i:
	j	split
wh.cond.i:
	blt	zero,t0,wh.body.i
	j	wh.exit.i
wh.body.i:
	li	t4, 1
	and	t3, t0, t4
	beq	t3,t4,if.true.i
	j	if.false.i
wh.exit.i:
	j	exit.12.i
if.true.i:
	mul	t3, t2, t1
	li	t2, 10000
	rem	t2, t3, t2
	j	if.exit.i
if.false.i:
	j	if.exit.i
if.exit.i:
	mul	t3, t1, t1
	li	t1, 10000
	rem	t1, t3, t1
	li	t3, 2
	div	t0, t0, t3
	j	wh.cond.i
split:
	mv	a0, t2
	call	toString
	mv	t0, a0
	mv	a0, t0
	call	println
	j	exit.13
entry.11.i:
	j	exit.11.i
exit.11.i:
	j	split.1
split.1:
	j	entry.12.i
                            #function ends.
