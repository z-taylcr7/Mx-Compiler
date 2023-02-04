	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.13:
	addi	sp, sp, -16
	sw	ra, 0(sp)
	li	t2, 0
	li	t3, 0
	li	t5, 0
	li	t4, 0
	li	a2, 0
	li	a0, 678
	li	t1, 567
	li	t0, 456
	li	t6, 345
	li	a3, 234
	j	for.cond.i
for.cond.i:
	li	a1, 100
	blt	a2,a1,for.body.i
	j	for.exit.i
for.body.i:
	li	t4, 123
	add	t4, t4, t6
	sub	a1, t4, t1
	li	t4, 789
	sub	a1, a1, t4
	li	t4, 0
	j	for.cond.1.i
for.exit.i:
	mv	a1, t3
	mv	t3, t5
	mv	a2, t4
	li	t5, 0
	mv	t4, a0
	j	for.cond.5.i
for.cond.1.i:
	li	a3, 100
	blt	t4,a3,for.body.1.i
	j	for.exit.1.i
for.body.1.i:
	add	t5, a1, t0
	sub	t6, t5, a0
	li	t5, 123
	sub	t6, t6, t5
	li	t5, 0
	j	for.cond.2.i
for.exit.1.i:
	addi	a2, a2, 1
	mv	a3, a1
	j	for.cond.i
for.cond.2.i:
	li	a3, 100
	blt	t5,a3,for.body.2.i
	j	for.exit.2.i
for.body.2.i:
	add	t3, t6, t1
	li	t0, 789
	sub	t0, t3, t0
	sub	t0, t0, a1
	li	t3, 0
	j	for.cond.3.i
for.exit.2.i:
	addi	t4, t4, 1
	j	for.cond.1.i
for.cond.3.i:
	li	a3, 10
	blt	t3,a3,for.body.3.i
	j	for.exit.3.i
for.body.3.i:
	add	t2, t0, a0
	li	t1, 123
	sub	t1, t2, t1
	sub	t1, t1, t6
	li	t2, 0
	j	for.cond.4.i
for.exit.3.i:
	addi	t5, t5, 1
	j	for.cond.2.i
for.cond.4.i:
	li	a3, 10
	blt	t2,a3,for.body.4.i
	j	for.exit.4.i
for.body.4.i:
	addi	a0, t1, 789
	sub	a0, a0, a1
	sub	a0, a0, t0
	addi	t2, t2, 1
	j	for.cond.4.i
for.exit.4.i:
	addi	t3, t3, 1
	j	for.cond.3.i
for.cond.5.i:
	li	a0, 10
	blt	t5,a0,for.body.5.i
	j	for.exit.5.i
for.body.5.i:
	li	a0, 0
	j	for.cond.6.i
for.exit.5.i:
	mv	a0, t4
	call	printInt
	li	a0, 0
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
for.cond.6.i:
	li	a2, 10
	blt	a0,a2,for.body.6.i
	j	for.exit.6.i
for.body.6.i:
	li	t3, 0
	j	for.cond.7.i
for.exit.6.i:
	addi	t5, t5, 1
	mv	a2, a0
	j	for.cond.5.i
for.cond.7.i:
	li	a2, 10
	blt	t3,a2,for.body.7.i
	j	for.exit.7.i
for.body.7.i:
	add	t0, t6, t1
	addi	t0, t0, 789
	add	t0, t0, a3
	li	a1, 0
	j	for.cond.8.i
for.exit.7.i:
	addi	a0, a0, 1
	j	for.cond.6.i
for.cond.8.i:
	li	t2, 10
	blt	a1,t2,for.body.8.i
	j	for.exit.8.i
for.body.8.i:
	add	t1, t0, t4
	addi	t1, t1, 123
	add	t1, t1, t6
	addi	a1, a1, 1
	j	for.cond.8.i
for.exit.8.i:
	li	t2, 0
	j	for.cond.9.i
for.cond.9.i:
	li	a2, 10
	blt	t2,a2,for.body.9.i
	j	for.exit.9.i
for.body.9.i:
	addi	t4, t1, 789
	add	t4, t4, a3
	add	t4, t4, t0
	addi	t2, t2, 1
	j	for.cond.9.i
for.exit.9.i:
	addi	t3, t3, 1
	j	for.cond.7.i
	.size	main, .-main
                            #function ends.
