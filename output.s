	.text
	.globl	loop
	.p2align	1
	.type	loop,@function
loop:
entry.12:
	addi	sp, sp, -16
	sw	s0, 0(sp)
	sw	ra, 4(sp)
	li	s0, 10000
	slli	t0, s0, 2
	addi	a0, t0, 4
	call	_bot_malloc
	sw	s0, 0(a0)
	li	t0, 4
	add	t4, a0, t0
	mv	t1, zero
	mv	t2, zero
	mv	t3, zero
	li	t5, 0
	j	for.cond
exit.12:
	lw	s0, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 16
	ret
for.cond:
	li	t0, 10
	blt	t5,t0,for.body
	j	for.exit
for.incr:
	addi	t5, t5, 1
	j	for.cond
for.body:
	li	t3, 0
	j	for.cond.1
for.exit:
	li	a0, 0
	li	t5, 0
	j	for.cond.4
for.cond.1:
	li	t0, 10
	blt	t3,t0,for.body.1
	j	for.incr
for.incr.1:
	addi	t3, t3, 1
	j	for.cond.1
for.body.1:
	li	t2, 0
	j	for.cond.2
for.cond.2:
	li	t0, 10
	blt	t2,t0,for.body.2
	j	for.incr.1
for.incr.2:
	addi	t2, t2, 1
	j	for.cond.2
for.body.2:
	li	t1, 0
	j	for.cond.3
for.cond.3:
	li	t0, 10
	blt	t1,t0,for.body.3
	j	for.incr.2
for.incr.3:
	addi	t1, t1, 1
	j	for.cond.3
for.body.3:
	li	t0, 1000
	mul	t6, t5, t0
	li	t0, 100
	mul	t0, t3, t0
	add	t6, t6, t0
	li	t0, 10
	mul	t0, t2, t0
	add	t0, t6, t0
	add	t6, t0, t1
	li	t0, 4
	mul	t0, t6, t0
	add	t0, t4, t0
	add	t6, t5, t1
	sw	t6, 0(t0)
	j	for.incr.3
for.cond.4:
	li	t0, 10
	blt	t5,t0,for.body.4
	j	exit.12
for.incr.4:
	addi	t5, t5, 1
	j	for.cond.4
for.body.4:
	li	t3, 0
	j	for.cond.5
for.cond.5:
	li	t0, 10
	blt	t3,t0,for.body.5
	j	for.incr.4
for.incr.5:
	addi	t3, t3, 1
	j	for.cond.5
for.body.5:
	li	t2, 0
	j	for.cond.6
for.cond.6:
	li	t0, 10
	blt	t2,t0,for.body.6
	j	for.incr.5
for.incr.6:
	addi	t2, t2, 1
	j	for.cond.6
for.body.6:
	li	t1, 0
	j	for.cond.7
for.cond.7:
	li	t0, 10
	blt	t1,t0,for.body.7
	j	for.incr.6
for.incr.7:
	addi	t1, t1, 1
	j	for.cond.7
for.body.7:
	andi	t6, t1, 1
	li	t0, 1
	beq	t6,t0,if.true
	j	if.false
if.true:
	li	t0, 1000
	mul	t6, t5, t0
	li	t0, 100
	mul	t0, t3, t0
	add	t6, t6, t0
	li	t0, 10
	mul	t0, t2, t0
	add	t0, t6, t0
	add	t6, t0, t1
	li	t0, 4
	mul	t0, t6, t0
	add	t0, t4, t0
	lw	t0, 0(t0)
	add	a0, a0, t0
	j	for.incr.7
if.false:
	li	t0, 1000
	mul	t6, t5, t0
	li	t0, 100
	mul	t0, t3, t0
	add	t6, t6, t0
	li	t0, 10
	mul	t0, t2, t0
	add	t0, t6, t0
	add	t6, t0, t1
	li	t0, 4
	mul	t0, t6, t0
	add	t0, t4, t0
	lw	t0, 0(t0)
	sub	a0, a0, t0
	j	for.incr.7
	.size	loop, .-loop
                            #function ends.
	.globl	compute
	.p2align	1
	.type	compute,@function
compute:
entry.13:
	addi	sp, sp, -16
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	sw	s2, 0(sp)
	sw	ra, 12(sp)
	mv	s0, a0
	mv	a0, zero
	li	s1, 0
	li	s2, 0
	j	wh.cond
exit.13:
	mv	a0, s1
	lw	s0, 8(sp)
	lw	s1, 4(sp)
	lw	s2, 0(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
wh.cond:
	bge	s0,s2,wh.body
	j	exit.13
wh.body:
	call	loop
	li	t0, 5000
	blt	t0,a0,if.true.1
	j	if.exit.1
if.true.1:
	li	t0, 5000
	sub	a0, a0, t0
	j	if.exit.1
if.exit.1:
	add	t1, s1, a0
	li	t0, 5000
	blt	t0,t1,if.true.2
	j	if.exit.2
if.true.2:
	li	t0, 5000
	sub	t1, t1, t0
	j	if.exit.2
if.exit.2:
	addi	t0, s2, 1
	mv	s1, t1
	mv	s2, t0
	j	wh.cond
	.size	compute, .-compute
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.14:
	addi	sp, sp, -16
	sw	ra, 0(sp)
	j	split
exit.14:
	li	a0, 0
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
split:
	li	a0, 20
	call	compute
	call	printInt
	j	exit.14
	.size	main, .-main
                            #function ends.
