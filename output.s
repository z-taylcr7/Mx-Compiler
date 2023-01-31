	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -16
	sw	s0, 0(sp)
	sw	ra, 4(sp)
	j	entry.11.i
exit.12:
	mv	a0, s0
	lw	s0, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 16
	ret
for.cond:
	li	t0, 10
	blt	t1,t0,for.body
	j	for.exit
for.incr:
	addi	t1, t1, 1
	mv	s0, t0
	mv	t3, t2
	mv	t2, t0
	j	for.cond
for.body:
	add	t0, t3, t2
	j	for.incr
for.exit:
	mv	a0, s0
	call	printInt
	j	exit.12
entry.11.i:
	j	exit.11.i
exit.11.i:
	j	split
split:
	li	t1, 1
	mv	s0, zero
	li	t2, 1
	li	t3, 0
	j	for.cond
                            #function ends.
