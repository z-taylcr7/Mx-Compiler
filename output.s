	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -16
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	sw	ra, 0(sp)
	j	entry.11.i
exit.12:
	mv	a0, s1
	lw	s0, 8(sp)
	lw	s1, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
for.cond:
	li	t1, 10
	blt	s0,t1,for.body
	j	for.exit
for.incr:
	li	t0, 1
	add	t0, s0, t0
	mv	s0, t0
	mv	t0, s1
	j	for.cond
for.body:
	add	s1, t0, s1
	mv	a0, s1
	call	printInt
	j	for.incr
for.exit:
	j	exit.12
entry.11.i:
	j	exit.11.i
exit.11.i:
	j	split
split:
	li	s0, 1
	mv	s1, zero
	li	s1, 1
	li	t0, 0
	j	for.cond
                            #function ends.
