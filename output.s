	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -32
	sw	s0, 20(sp)
	sw	ra, 24(sp)
	lui	t0, %hi(l)
	lw	t0, %lo(l)(t0)
	sw	t0, 0(sp)
	lui	t0, %hi(s)
	lw	t0, %lo(s)(t0)
	sw	t0, 4(sp)
	lui	t0, %hi(t)
	lw	t0, %lo(t)(t0)
	sw	t0, 8(sp)
	lui	t0, %hi(i)
	lw	t0, %lo(i)(t0)
	sw	t0, 12(sp)
	j	split
exit.12:
	lw	t1, 0(sp)
	lui	t0, %hi(l)
	sw	t1, %lo(l)(t0)
	lw	t1, 4(sp)
	lui	t0, %hi(s)
	sw	t1, %lo(s)(t0)
	lw	t1, 8(sp)
	lui	t0, %hi(t)
	sw	t1, %lo(t)(t0)
	lw	t1, 12(sp)
	lui	t0, %hi(i)
	sw	t1, %lo(i)(t0)
	lw	a0, 16(sp)
	lw	s0, 20(sp)
	lw	ra, 24(sp)
	addi	sp, sp, 32
	ret
for.cond:
	lw	t1, 12(sp)
	lw	t0, 8(sp)
	blt	t1,t0,for.body
	j	exit.12
for.incr:
	lw	t0, 12(sp)
	addi	t0, t0, 1
	sw	t0, 12(sp)
	j	for.cond
for.body:
	lw	t0, 4(sp)
	call	getString
	sw	a0, 4(sp)
	lw	t0, 0(sp)
	lw	a0, 4(sp)
	call	_str_length
	sw	a0, 0(sp)
	lw	t1, 0(sp)
	li	t0, 10
	blt	t0,t1,if.true
	j	if.false
if.true:
	lw	a0, 4(sp)
	li	a1, 0
	li	a2, 1
	call	_str_substring
	mv	s0, a0
	lw	t1, 0(sp)
	li	t0, 2
	sub	a0, t1, t0
	call	toString
	mv	a1, a0
	mv	a0, s0
	call	_bot_str_cat
	mv	s0, a0
	lw	a0, 4(sp)
	lw	t1, 0(sp)
	li	t0, 1
	sub	a1, t1, t0
	lw	a2, 0(sp)
	call	_str_substring
	mv	a1, a0
	mv	a0, s0
	call	_bot_str_cat
	call	println
	j	for.incr
if.false:
	lw	a0, 4(sp)
	call	println
	j	for.incr
split:
	sw	zero, 16(sp)
	lw	t0, 8(sp)
	call	getInt
	sw	a0, 8(sp)
	lw	t0, 12(sp)
	sw	zero, 12(sp)
	j	for.cond
	.size	main, .-main
                            #function ends.
	.type	t,@object
	.section	.bss
	.globl	t
t:
	.word	0
	.size	t, 4
	.type	l,@object
	.section	.bss
	.globl	l
l:
	.word	0
	.size	l, 4
	.type	i,@object
	.section	.bss
	.globl	i
i:
	.word	0
	.size	i, 4
	.type	s,@object
	.section	.bss
	.globl	s
s:
	.word	0
	.size	s, 4
