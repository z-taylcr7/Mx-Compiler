	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry.11:
	j	exit.11
exit.11:
	ret
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -16
	sw	s0, 4(sp)
	sw	ra, 0(sp)
	call	_glb_init
	li	t0, 1
	mv	s0, zero
	li	t1, 0
	j	for.cond
exit.12:
	mv	a0, s0
	lw	s0, 4(sp)
	lw	ra, 0(sp)
	addi	sp, sp, 16
	ret
for.cond:
	li	t2, 10
	blt	t0,t2,for.body
	j	for.exit
for.incr:
	li	t2, 1
	add	t0, t0, t2
	mv	s0, t1
	j	for.cond
for.body:
	add	t1, t1, t1
	j	for.incr
for.exit:
	mv	a0, s0
	call	printInt
	j	exit.12
                            #function ends.
