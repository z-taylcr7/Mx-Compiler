	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.13:
	addi	sp, sp, -32
	sw	s0, 12(sp)
	sw	s1, 8(sp)
	sw	s2, 4(sp)
	sw	s3, 0(sp)
	sw	ra, 16(sp)
	lui	t0, %hi(i)
	lui	t0, %hi(r)
	lw	s0, %lo(r)(t0)
	lui	t0, %hi(c)
	lw	s1, %lo(c)(t0)
	lui	t0, %hi(n)
	lw	s2, %lo(n)(t0)
	lui	t0, %hi(j)
	lw	s3, %lo(j)(t0)
	j	entry.11.i
exit.13:
	lui	t0, %hi(i)
	sw	zero, %lo(i)(t0)
	lui	t0, %hi(r)
	sw	s0, %lo(r)(t0)
	lui	t0, %hi(c)
	sw	s1, %lo(c)(t0)
	lui	t0, %hi(n)
	sw	s2, %lo(n)(t0)
	lui	t0, %hi(j)
	sw	s3, %lo(j)(t0)
	li	a0, 0
	lw	s0, 12(sp)
	lw	s1, 8(sp)
	lw	s2, 4(sp)
	lw	s3, 0(sp)
	lw	ra, 16(sp)
	addi	sp, sp, 32
	ret
for.cond:
	li	t0, 5
	blt	zero,t0,for.body
	j	for.exit
for.incr:
	addi	t0, zero, 1
	j	for.cond
for.body:
	j	for.cond.1
for.exit:
	li	t0, 2
	sub	t1, t0, s0
	j	entry.12.i
for.cond.1:
	li	t0, 5
	blt	zero,t0,for.body.1
	j	for.exit.1
for.incr.1:
	addi	t0, zero, 1
	j	for.cond.1
for.body.1:
	call	getInt
	li	t0, 1
	beq	a0,t0,if.true.1
	j	if.false.1
for.exit.1:
	j	for.incr
if.true.1:
	j	if.exit.1
if.false.1:
	j	if.exit.1
if.exit.1:
	j	for.incr.1
entry.11.i:
	j	exit.11.i
exit.11.i:
	j	split
split:
	j	for.cond
entry.12.i:
	blt	zero,t1,if.true.i
	j	if.false.i
exit.12.i:
	j	split.1
if.true.i:
	j	exit.12.i
if.false.i:
	j	if.exit.i
if.exit.i:
	sub	t1, zero, t1
	j	exit.12.i
split.1:
	li	t0, 2
	sub	t0, t0, s1
	j	entry.12.i.1
entry.12.i.1:
	blt	zero,t0,if.true.i.1
	j	if.false.i.1
exit.12.i.1:
	j	split.2
if.true.i.1:
	j	exit.12.i.1
if.false.i.1:
	j	if.exit.i.1
if.exit.i.1:
	sub	t0, zero, t0
	j	exit.12.i.1
split.2:
	add	a0, t1, t0
	call	printInt
	j	exit.13
                            #function ends.
	.type	n,@object
	.section	.bss
	.globl	n
n:
	.word	0
	.size	n, 4
	.type	r,@object
	.section	.bss
	.globl	r
r:
	.word	0
	.size	r, 4
	.type	c,@object
	.section	.bss
	.globl	c
c:
	.word	0
	.size	c, 4
	.type	i,@object
	.section	.bss
	.globl	i
i:
	.word	0
	.size	i, 4
	.type	j,@object
	.section	.bss
	.globl	j
j:
	.word	0
	.size	j, 4
