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
	add	t5, a0, t0
	mv	t0, zero
	mv	t2, zero
	mv	t3, zero
	li	t4, 0
	j	for.cond
for.cond:
	li	t1, 10
	blt	t4,t1,for.body
	j	for.exit
for.body:
	li	t3, 0
	j	for.cond.1
for.exit:
	li	a0, 0
	li	t4, 0
	j	for.cond.4
for.cond.1:
	li	t1, 10
	blt	t3,t1,for.body.1
	j	for.exit.1
for.body.1:
	li	t2, 0
	j	for.cond.2
for.exit.1:
	addi	t4, t4, 1
	j	for.cond
for.cond.2:
	li	t1, 10
	blt	t2,t1,for.body.2
	j	for.exit.2
for.body.2:
	li	t0, 0
	j	for.cond.3
for.exit.2:
	addi	t3, t3, 1
	j	for.cond.1
for.cond.3:
	li	t1, 10
	blt	t0,t1,for.body.3
	j	for.exit.3
for.body.3:
	li	t1, 1000
	mul	t6, t4, t1
	li	t1, 100
	mul	t1, t3, t1
	add	t6, t6, t1
	li	t1, 10
	mul	t1, t2, t1
	add	t1, t6, t1
	add	t6, t1, t0
	li	t1, 4
	mul	t1, t6, t1
	add	t1, t5, t1
	add	t6, t4, t0
	sw	t6, 0(t1)
	addi	t0, t0, 1
	j	for.cond.3
for.exit.3:
	addi	t2, t2, 1
	j	for.cond.2
for.cond.4:
	li	t1, 10
	blt	t4,t1,for.body.4
	j	for.exit.4
for.body.4:
	li	t3, 0
	j	for.cond.5
for.exit.4:
	lw	s0, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 16
	ret
for.cond.5:
	li	t1, 10
	blt	t3,t1,for.body.5
	j	for.exit.5
for.body.5:
	li	t2, 0
	j	for.cond.6
for.exit.5:
	addi	t4, t4, 1
	j	for.cond.4
for.cond.6:
	li	t1, 10
	blt	t2,t1,for.body.6
	j	for.exit.6
for.body.6:
	li	t0, 0
	j	for.cond.7
for.exit.6:
	addi	t3, t3, 1
	j	for.cond.5
for.cond.7:
	li	t1, 10
	blt	t0,t1,for.body.7
	j	for.exit.7
for.body.7:
	andi	t6, t0, 1
	li	t1, 1
	beq	t6,t1,if.true
	j	if.false
for.exit.7:
	addi	t2, t2, 1
	j	for.cond.6
if.true:
	li	t1, 1000
	mul	t6, t4, t1
	li	t1, 100
	mul	t1, t3, t1
	add	t6, t6, t1
	li	t1, 10
	mul	t1, t2, t1
	add	t1, t6, t1
	add	t6, t1, t0
	li	t1, 4
	mul	t1, t6, t1
	add	t1, t5, t1
	lw	t1, 0(t1)
	add	a0, a0, t1
	j	if.exit
if.false:
	li	t1, 1000
	mul	t6, t4, t1
	li	t1, 100
	mul	t1, t3, t1
	add	t6, t6, t1
	li	t1, 10
	mul	t1, t2, t1
	add	t1, t6, t1
	add	t6, t1, t0
	li	t1, 4
	mul	t1, t6, t1
	add	t1, t5, t1
	lw	t1, 0(t1)
	sub	a0, a0, t1
	j	if.exit
if.exit:
	addi	t0, t0, 1
	j	for.cond.7
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
wh.cond:
	bge	s0,s2,wh.body
	j	wh.exit
wh.body:
	call	loop
	li	t0, 5000
	blt	t0,a0,if.true.1
	j	if.exit.1
wh.exit:
	mv	a0, s1
	lw	s0, 8(sp)
	lw	s1, 4(sp)
	lw	s2, 0(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
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
	li	a0, 20
	call	compute
	call	printInt
	li	a0, 0
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
	.size	main, .-main
                            #function ends.
