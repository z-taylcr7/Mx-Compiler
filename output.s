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
	mv	t0, a0
                            #function ends.
	.globl	test_foo
	.p2align	1
	.type	test_foo,@function
test_foo:
entry.12:
	addi	sp, sp, -96
	sw	t0, 76(sp)
	sw	zero, 72(sp)
	sw	zero, 68(sp)
	sw	zero, 64(sp)
	sw	zero, 60(sp)
	sw	zero, 56(sp)
	sw	zero, 52(sp)
	sw	zero, 48(sp)
	sw	zero, 44(sp)
	sw	zero, 40(sp)
	sw	zero, 36(sp)
	sw	zero, 32(sp)
	sw	zero, 28(sp)
	sw	zero, 24(sp)
	sw	zero, 20(sp)
	sw	zero, 16(sp)
	sw	zero, 12(sp)
	sw	zero, 8(sp)
	sw	zero, 4(sp)
	sw	zero, 0(sp)
	lw	t0, 8(sp)
	sw	zero, 8(sp)
	j	for.cond
exit.12:
	lw	a0, 80(sp)
	addi	sp, sp, 96
	ret
for.cond:
	lw	t1, 8(sp)
	lw	t0, 76(sp)
	blt	t1,t0,for.body
	j	for.exit
for.incr:
	lw	t1, 8(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 8(sp)
	j	for.cond
for.body:
	lw	t0, 4(sp)
	sw	zero, 4(sp)
	j	for.cond.1
for.exit:
	lw	t0, 72(sp)
	sw	t0, 80(sp)
	j	exit.12
for.cond.1:
	lw	t1, 4(sp)
	lw	t0, 76(sp)
	blt	t1,t0,for.body.1
	j	for.exit.1
for.incr.1:
	lw	t1, 4(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 4(sp)
	j	for.cond.1
for.body.1:
	lw	t0, 0(sp)
	sw	zero, 0(sp)
	j	for.cond.2
for.exit.1:
	j	for.incr
for.cond.2:
	lw	t1, 0(sp)
	lw	t0, 76(sp)
	blt	t1,t0,for.body.2
	j	for.exit.2
for.incr.2:
	lw	t1, 0(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 0(sp)
	j	for.cond.2
for.body.2:
	lw	t0, 20(sp)
	sw	zero, 20(sp)
	j	for.cond.3
for.exit.2:
	j	for.incr.1
for.cond.3:
	lw	t1, 20(sp)
	lw	t0, 76(sp)
	blt	t1,t0,for.body.3
	j	for.exit.3
for.incr.3:
	lw	t1, 20(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 20(sp)
	j	for.cond.3
for.body.3:
	lw	t0, 72(sp)
	lw	t1, 72(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 72(sp)
	lw	t1, 72(sp)
	li	t0, 1000000
	blt	t0,t1,if.true
	j	if.false
for.exit.3:
	j	for.incr.2
if.true:
	lw	t0, 72(sp)
	lw	t1, 72(sp)
	li	t0, 1000000
	sub	t0, t1, t0
	sw	t0, 72(sp)
	j	if.exit
if.false:
	j	if.exit
if.exit:
	lw	t1, 48(sp)
	li	t0, 1000000
	blt	t0,t1,if.true.1
	j	if.false.1
if.true.1:
	lw	t0, 48(sp)
	lw	t1, 48(sp)
	li	t0, 1000000
	sub	t0, t1, t0
	sw	t0, 48(sp)
	j	if.exit.1
if.false.1:
	j	if.exit.1
if.exit.1:
	lw	t1, 68(sp)
	li	t0, 1000000
	blt	t0,t1,if.true.2
	j	if.false.2
if.true.2:
	lw	t0, 68(sp)
	lw	t1, 68(sp)
	li	t0, 1000000
	sub	t0, t1, t0
	sw	t0, 68(sp)
	j	if.exit.2
if.false.2:
	j	if.exit.2
if.exit.2:
	lw	t1, 64(sp)
	li	t0, 1000000
	blt	t0,t1,if.true.3
	j	if.false.3
if.true.3:
	lw	t0, 64(sp)
	lw	t1, 64(sp)
	li	t0, 1000000
	sub	t0, t1, t0
	sw	t0, 64(sp)
	j	if.exit.3
if.false.3:
	j	if.exit.3
if.exit.3:
	lw	t1, 52(sp)
	li	t0, 1000000
	blt	t0,t1,if.true.4
	j	if.false.4
if.true.4:
	lw	t0, 52(sp)
	lw	t1, 52(sp)
	li	t0, 1000000
	sub	t0, t1, t0
	sw	t0, 52(sp)
	j	if.exit.4
if.false.4:
	j	if.exit.4
if.exit.4:
	lw	t0, 68(sp)
	lw	t1, 68(sp)
	li	t0, 2
	add	t0, t1, t0
	sw	t0, 68(sp)
	lw	t1, 72(sp)
	li	t0, 3
	blt	t0,t1,if.true.5
	j	if.false.5
if.true.5:
	lw	t0, 64(sp)
	lw	t1, 64(sp)
	lw	t0, 72(sp)
	add	t1, t1, t0
	li	t0, 10
	sub	t0, t1, t0
	sw	t0, 64(sp)
	j	if.exit.5
if.false.5:
	j	if.exit.5
if.exit.5:
	lw	t0, 64(sp)
	lw	t1, 64(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 64(sp)
	lw	t0, 52(sp)
	lw	t1, 64(sp)
	lw	t0, 72(sp)
	add	t0, t1, t0
	sw	t0, 52(sp)
	lw	t0, 60(sp)
	lw	t1, 52(sp)
	lw	t0, 60(sp)
	add	t0, t1, t0
	sw	t0, 60(sp)
	lw	t0, 48(sp)
	lw	t1, 72(sp)
	lw	t0, 68(sp)
	add	t1, t1, t0
	lw	t0, 64(sp)
	add	t1, t1, t0
	lw	t0, 60(sp)
	add	t1, t1, t0
	lw	t0, 56(sp)
	add	t1, t1, t0
	lw	t0, 52(sp)
	add	t0, t1, t0
	sw	t0, 48(sp)
	lw	t1, 48(sp)
	li	t0, 10
	blt	t0,t1,if.true.6
	j	if.false.6
if.true.6:
	lw	t0, 44(sp)
	lw	t1, 44(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 44(sp)
	lw	t0, 28(sp)
	lw	t1, 28(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 28(sp)
	lw	t0, 16(sp)
	lw	t1, 16(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 16(sp)
	j	if.exit.6
if.false.6:
	lw	t0, 72(sp)
	lw	t1, 72(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 72(sp)
	lw	t0, 28(sp)
	lw	t1, 28(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 28(sp)
	lw	t0, 32(sp)
	lw	t1, 32(sp)
	li	t0, 1
	add	t0, t1, t0
	sw	t0, 32(sp)
	j	if.exit.6
if.exit.6:
	j	for.incr.3
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.13:
	addi	sp, sp, -16
	call	_glb_init
	sw	zero, 0(sp)
	li	a0, 60
	call	test_foo
	call	printInt
	j	exit.13
exit.13:
	lw	a0, 0(sp)
	addi	sp, sp, 16
	ret
                            #function ends.
