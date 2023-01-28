	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry.11:
	addi	sp, sp, 0
	j	exit.11
exit.11:
	addi	sp, sp, 0
	ret
                            #function ends.
	.globl	loop
	.p2align	1
	.type	loop,@function
loop:
entry.12:
	addi	sp, sp, -16
	sw	s0, 4(sp)
	sw	ra, 0(sp)
	li	s0, 10000
	li	t0, 4
	mul	t1, s0, t0
	li	t0, 4
	add	t0, t1, t0
	mv	a0, t0
	call	_bot_malloc
	mv	t0, a0
	sw	s0, 0(t0)
	li	t1, 4
	add	t0, t0, t1
	mv	t2, t0
	mv	t5, zero
	mv	t6, zero
	mv	t4, zero
	li	t0, 0
	j	for.cond
exit.12:
	mv	a0, t3
	lw	s0, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
for.cond:
	li	t1, 10
	blt	t0,t1,for.body
	j	for.exit
for.incr:
	li	t1, 1
	add	t0, t0, t1
	j	for.cond
for.body:
	li	t4, 0
	j	for.cond.1
for.exit:
	li	t3, 0
	li	t1, 0
	j	for.cond.4
for.cond.1:
	li	t1, 10
	blt	t4,t1,for.body.1
	j	for.exit.1
for.incr.1:
	li	t1, 1
	add	t4, t4, t1
	j	for.cond.1
for.body.1:
	li	t6, 0
	j	for.cond.2
for.exit.1:
	j	for.incr
for.cond.2:
	li	t1, 10
	blt	t6,t1,for.body.2
	j	for.exit.2
for.incr.2:
	li	t1, 1
	add	t6, t6, t1
	j	for.cond.2
for.body.2:
	li	t5, 0
	j	for.cond.3
for.exit.2:
	j	for.incr.1
for.cond.3:
	li	t1, 10
	blt	t5,t1,for.body.3
	j	for.exit.3
for.incr.3:
	li	t1, 1
	add	t5, t5, t1
	j	for.cond.3
for.body.3:
	li	t1, 1000
	mul	t3, t0, t1
	li	t1, 100
	mul	t1, t4, t1
	add	t3, t3, t1
	li	t1, 10
	mul	t1, t6, t1
	add	t1, t3, t1
	add	t3, t1, t5
	li	t1, 4
	mul	t1, t3, t1
	add	t1, t2, t1
	lw	t3, 0(t1)
	add	t3, t0, t5
	sw	t3, 0(t1)
	li	t1, 10
	mul	t3, t0, t1
	li	t1, 5
	mul	t1, t4, t1
	add	t3, t3, t1
	li	t1, 4
	mul	t1, t3, t1
	add	t1, t2, t1
	lw	t3, 0(t1)
	li	t3, 10
	mul	a1, t0, t3
	li	t3, 5
	mul	t3, t4, t3
	add	a1, a1, t3
	li	t3, 4
	mul	t3, a1, t3
	add	t3, t2, t3
	lw	t3, 0(t3)
	sw	t3, 0(t1)
	j	for.incr.3
for.exit.3:
	j	for.incr.2
for.cond.4:
	li	t0, 10
	blt	t1,t0,for.body.4
	j	for.exit.4
for.incr.4:
	li	t4, 1
	add	t1, t1, t4
	mv	t4, t0
	j	for.cond.4
for.body.4:
	li	t0, 0
	j	for.cond.5
for.exit.4:
	j	exit.12
for.cond.5:
	li	t4, 10
	blt	t0,t4,for.body.5
	j	for.exit.5
for.incr.5:
	li	t3, 1
	add	t0, t0, t3
	mv	t3, t4
	j	for.cond.5
for.body.5:
	mv	t4, t3
	li	t6, 0
	j	for.cond.6
for.exit.5:
	j	for.incr.4
for.cond.6:
	li	t3, 10
	blt	t6,t3,for.body.6
	j	for.exit.6
for.incr.6:
	li	t3, 1
	add	t6, t6, t3
	j	for.cond.6
for.body.6:
	li	t5, 0
	j	for.cond.7
for.exit.6:
	j	for.incr.5
for.cond.7:
	li	t3, 10
	blt	t5,t3,for.body.7
	j	for.exit.7
for.incr.7:
	li	t3, 1
	add	t5, t5, t3
	j	for.cond.7
for.body.7:
	li	t3, 1
	and	a1, t5, t3
	li	t3, 1
	beq	a1,t3,if.true
	j	if.false
for.exit.7:
	j	for.incr.6
if.true:
	li	t3, 1000
	mul	a1, t1, t3
	li	t3, 100
	mul	t3, t0, t3
	add	a1, a1, t3
	li	t3, 10
	mul	t3, t6, t3
	add	t3, a1, t3
	add	a1, t3, t5
	li	t3, 4
	mul	t3, a1, t3
	add	t3, t2, t3
	lw	t3, 0(t3)
	add	t4, t4, t3
	j	if.exit
if.false:
	li	t3, 1000
	mul	a1, t1, t3
	li	t3, 100
	mul	t3, t0, t3
	add	a1, a1, t3
	li	t3, 10
	mul	t3, t6, t3
	add	t3, a1, t3
	add	a1, t3, t5
	li	t3, 4
	mul	t3, a1, t3
	add	t3, t2, t3
	lw	t3, 0(t3)
	sub	t4, t4, t3
	j	if.exit
if.exit:
	j	for.incr.7
                            #function ends.
	.globl	compute
	.p2align	1
	.type	compute,@function
compute:
entry.13:
	addi	sp, sp, -16
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	sw	ra, 0(sp)
	mv	t1, zero
	li	s0, 0
	li	s1, 0
	j	wh.cond
exit.13:
	mv	a0, s0
	lw	s0, 8(sp)
	lw	s1, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
wh.cond:
	lw	t0, 12(sp)
	bge	t0,s1,wh.body
	j	wh.exit
wh.body:
	call	loop
	mv	t1, a0
	li	t0, 5000
	blt	t0,t1,if.true.1
	j	if.false.1
wh.exit:
	j	exit.13
if.true.1:
	li	t0, 5000
	sub	t1, t1, t0
	j	if.exit.1
if.false.1:
	j	if.exit.1
if.exit.1:
	add	t0, s0, t1
	li	t2, 5000
	blt	t2,t0,if.true.2
	j	if.false.2
if.true.2:
	li	t2, 5000
	sub	t0, t0, t2
	j	if.exit.2
if.false.2:
	j	if.exit.2
if.exit.2:
	li	t2, 1
	add	t2, s1, t2
	mv	s0, t0
	mv	s1, t2
	j	wh.cond
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.14:
	addi	sp, sp, -16
	sw	ra, 0(sp)
	call	_glb_init
	li	t0, 20
	mv	a0, t0
	call	compute
	mv	t0, a0
	mv	a0, t0
	call	printInt
	j	exit.14
exit.14:
	li	a0, 0
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
                            #function ends.
