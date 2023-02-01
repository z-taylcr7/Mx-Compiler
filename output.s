	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry.11:
	j	exit.11
exit.11:
	ret
	.size	_glb_init, .-_glb_init
                            #function ends.
	.globl	qpow
	.p2align	1
	.type	qpow,@function
qpow:
entry.12:
	addi	sp, sp, -32
	sw	a0, 16(sp)
	sw	a1, 12(sp)
	sw	a2, 8(sp)
	li	t0, 1
	sw	t0, 4(sp)
	lw	t0, 16(sp)
	sw	t0, 0(sp)
	j	wh.cond
exit.12:
	lw	a0, 20(sp)
	addi	sp, sp, 32
	ret
wh.cond:
	lw	t0, 12(sp)
	blt	zero,t0,wh.body
	j	wh.exit
wh.body:
	lw	t0, 12(sp)
	andi	t1, t0, 1
	li	t0, 1
	beq	t1,t0,if.true
	j	if.exit
wh.exit:
	lw	t0, 4(sp)
	sw	t0, 20(sp)
	j	exit.12
if.true:
	lw	t1, 4(sp)
	lw	t0, 0(sp)
	mul	t1, t1, t0
	lw	t0, 8(sp)
	rem	t0, t1, t0
	sw	t0, 4(sp)
	j	if.exit
if.exit:
	lw	t1, 0(sp)
	lw	t0, 0(sp)
	mul	t1, t1, t0
	lw	t0, 8(sp)
	rem	t0, t1, t0
	sw	t0, 0(sp)
	lw	t1, 12(sp)
	li	t0, 2
	div	t0, t1, t0
	sw	t0, 12(sp)
	j	wh.cond
	.size	qpow, .-qpow
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.13:
	addi	sp, sp, -16
	sw	ra, 4(sp)
	call	_glb_init
	sw	zero, 0(sp)
	li	a0, 2
	li	a1, 10
	li	a2, 10000
	call	qpow
	call	toString
	call	println
	sw	zero, 0(sp)
	j	exit.13
exit.13:
	lw	a0, 0(sp)
	lw	ra, 4(sp)
	addi	sp, sp, 16
	ret
	.size	main, .-main
                            #function ends.
