	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.13:
	addi	sp, sp, -16
	sw	ra, 0(sp)
	li	t3, 0
	li	t5, 0
	li	t1, 0
	li	a1, 0
	li	a2, 0
	li	a0, 678
	li	t2, 567
	li	t0, 456
	li	t6, 345
	li	t4, 234
	j	for.cond.i
for.cond.i:
	li	a3, 100
	blt	a2,a3,for.body.i
	j	for.exit.i
for.body.i:
	li	t4, 123
	add	t4, t4, t6
	sub	a1, t4, t2
	li	t4, 789
	sub	t4, a1, t4
	li	a1, 0
	j	for.cond.1.i
for.exit.i:
	mv	a2, a1
	li	a1, 0
	j	for.cond.5.i
for.cond.1.i:
	li	a3, 100
	blt	a1,a3,for.body.1.i
	j	for.exit.1.i
for.body.1.i:
	add	t1, t4, t0
	sub	t6, t1, a0
	li	t1, 123
	sub	a3, t6, t1
	mv	t1, t5
	li	a4, 0
	mv	t6, a0
	j	for.cond.2.i
for.exit.1.i:
	addi	a2, a2, 1
	j	for.cond.i
for.cond.2.i:
	li	t5, 100
	blt	a4,t5,for.body.2.i
	j	for.exit.2.i
for.body.2.i:
	add	t1, a3, t2
	li	t0, 789
	sub	t0, t1, t0
	sub	t0, t0, t4
	li	t1, 0
	mv	t5, t6
	j	for.cond.3.i
for.exit.2.i:
	addi	a0, a1, 1
	mv	t5, t1
	mv	t1, a4
	mv	a1, a0
	mv	a0, t6
	mv	t6, a3
	j	for.cond.1.i
for.cond.3.i:
	li	t6, 10
	blt	t1,t6,for.body.3.i
	j	for.exit.3.i
for.body.3.i:
	add	t3, t0, t5
	li	t2, 123
	sub	t2, t3, t2
	sub	t2, t2, a3
	addi	t3, t2, 789
	sub	t3, t3, t4
	sub	t6, t3, t0
	li	t3, 0
	j	for.cond.4.i
for.exit.3.i:
	addi	t6, a4, 1
	mv	a4, t6
	mv	t6, t5
	j	for.cond.2.i
for.cond.4.i:
	li	a0, 10
	blt	t3,a0,for.body.4.i
	j	for.exit.4.i
for.body.4.i:
	addi	t3, t3, 1
	mv	t5, t6
	j	for.cond.4.i
for.exit.4.i:
	addi	t1, t1, 1
	j	for.cond.3.i
for.cond.5.i:
	li	a2, 10
	blt	a1,a2,for.body.5.i
	j	for.exit.5.i
for.body.5.i:
	li	a2, 0
	j	for.cond.6.i
for.exit.5.i:
	call	printInt
	li	a0, 0
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
for.cond.6.i:
	li	a3, 10
	blt	a2,a3,for.body.6.i
	j	for.exit.6.i
for.body.6.i:
	mv	t1, t5
	li	a3, 0
	j	for.cond.7.i
for.exit.6.i:
	addi	a1, a1, 1
	j	for.cond.5.i
for.cond.7.i:
	li	t5, 10
	blt	a3,t5,for.body.7.i
	j	for.exit.7.i
for.body.7.i:
	add	t0, t6, t2
	addi	t0, t0, 789
	add	t0, t0, t4
	add	t1, t0, a0
	addi	t1, t1, 123
	add	t3, t1, t6
	li	t1, 0
	j	for.cond.8.i
for.exit.7.i:
	addi	a2, a2, 1
	mv	t5, t1
	mv	t1, a3
	j	for.cond.6.i
for.cond.8.i:
	li	t5, 10
	blt	t1,t5,for.body.8.i
	j	for.exit.8.i
for.body.8.i:
	addi	t1, t1, 1
	mv	t2, t3
	j	for.cond.8.i
for.exit.8.i:
	addi	t3, t2, 789
	add	t3, t3, t4
	add	a4, t3, t0
	li	t3, 0
	mv	t5, a0
	j	for.cond.9.i
for.cond.9.i:
	li	a0, 10
	blt	t3,a0,for.body.9.i
	j	for.exit.9.i
for.body.9.i:
	addi	t3, t3, 1
	mv	t5, a4
	j	for.cond.9.i
for.exit.9.i:
	addi	a0, a3, 1
	mv	a3, a0
	mv	a0, t5
	j	for.cond.7.i
	.size	main, .-main
                            #function ends.
