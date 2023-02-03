	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.13:
	addi	sp, sp, -16
	sw	ra, 0(sp)
	j	entry.12.i
exit.13:
	li	a0, 0
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
entry.12.i:
	li	t4, 0
	li	t6, 0
	li	t0, 0
	li	a1, 0
	li	a2, 0
	li	a0, 678
	li	t3, 567
	li	t1, 456
	li	t5, 345
	li	t2, 234
	j	for.cond.i
for.cond.i:
	li	a3, 100
	blt	a2,a3,for.body.i
	j	for.exit.i
for.incr.i:
	addi	a2, a2, 1
	j	for.cond.i
for.body.i:
	li	t2, 123
	add	t2, t2, t5
	sub	a1, t2, t3
	li	t2, 789
	sub	t2, a1, t2
	li	a1, 0
	j	for.cond.1.i
for.exit.i:
	mv	a2, a1
	li	a1, 0
	j	for.cond.5.i
for.cond.1.i:
	li	a3, 100
	blt	a1,a3,for.body.1.i
	j	for.incr.i
for.incr.1.i:
	addi	a0, a1, 1
	mv	t6, t0
	mv	t0, a4
	mv	a1, a0
	mv	a0, t5
	mv	t5, a3
	j	for.cond.1.i
for.body.1.i:
	add	t0, t2, t1
	sub	t5, t0, a0
	li	t0, 123
	sub	a3, t5, t0
	mv	t0, t6
	li	a4, 0
	mv	t5, a0
	j	for.cond.2.i
for.cond.2.i:
	li	t6, 100
	blt	a4,t6,for.body.2.i
	j	for.incr.1.i
for.incr.2.i:
	addi	t3, a4, 1
	mv	a4, t3
	mv	t3, t1
	mv	t1, t6
	j	for.cond.2.i
for.body.2.i:
	add	t1, a3, t3
	li	t0, 789
	sub	t0, t1, t0
	sub	t6, t0, t2
	li	t0, 0
	mv	t1, t3
	j	for.cond.3.i
for.cond.3.i:
	li	t3, 10
	blt	t0,t3,for.body.3.i
	j	for.incr.2.i
for.incr.3.i:
	addi	t0, t0, 1
	j	for.cond.3.i
for.body.3.i:
	add	t3, t6, t5
	li	t1, 123
	sub	t1, t3, t1
	sub	t1, t1, a3
	li	t4, 0
	j	for.cond.4.i
for.cond.4.i:
	li	t3, 10
	blt	t4,t3,for.body.4.i
	j	for.incr.3.i
for.incr.4.i:
	addi	t4, t4, 1
	j	for.cond.4.i
for.body.4.i:
	addi	t3, t1, 789
	sub	t3, t3, t2
	sub	t5, t3, t6
	j	for.incr.4.i
for.cond.5.i:
	li	a2, 10
	blt	a1,a2,for.body.5.i
	j	split.1
for.incr.5.i:
	addi	a1, a1, 1
	j	for.cond.5.i
for.body.5.i:
	li	a2, 0
	j	for.cond.6.i
for.cond.6.i:
	li	a3, 10
	blt	a2,a3,for.body.6.i
	j	for.incr.5.i
for.incr.6.i:
	addi	a2, a2, 1
	j	for.cond.6.i
for.body.6.i:
	li	t0, 0
	j	for.cond.7.i
for.cond.7.i:
	li	a3, 10
	blt	t0,a3,for.body.7.i
	j	for.incr.6.i
for.incr.7.i:
	addi	t0, t0, 1
	j	for.cond.7.i
for.body.7.i:
	add	t1, t5, t3
	addi	t1, t1, 789
	add	t1, t1, t2
	li	t6, 0
	j	for.cond.8.i
for.cond.8.i:
	li	t4, 10
	blt	t6,t4,for.body.8.i
	j	for.exit.8.i
for.incr.8.i:
	addi	t6, t6, 1
	j	for.cond.8.i
for.body.8.i:
	add	t3, t1, a0
	addi	t3, t3, 123
	add	t3, t3, t5
	j	for.incr.8.i
for.exit.8.i:
	li	t4, 0
	j	for.cond.9.i
for.cond.9.i:
	li	a3, 10
	blt	t4,a3,for.body.9.i
	j	for.incr.7.i
for.incr.9.i:
	addi	t4, t4, 1
	j	for.cond.9.i
for.body.9.i:
	addi	a0, t3, 789
	add	a0, a0, t2
	add	a0, a0, t1
	j	for.incr.9.i
split.1:
	call	printInt
	j	exit.13
	.size	main, .-main
                            #function ends.
