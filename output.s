	.globl	_global_init
	.p2align	1
	.type	_global_init,@function
_global_init:
%entry.11:
	addi	sp, sp, -16
	mv	t1, ra
	sw	t1, 0(sp)
	mv	t1, s0
	sw	t1, 4(sp)
	addi	s0, sp, 16
	j	%exit.11
%exit.11:
	lw	t2, 0(sp)
	mv	ra, t2
	lw	t2, 4(sp)
	mv	s0, t2
	addi	sp, sp, 16
	ret
                            #function ends.
	.globl	abs
	.p2align	1
	.type	abs,@function
abs:
%entry.12:
	addi	sp, sp, -48
	mv	t1, ra
	sw	t1, 12(sp)
	mv	t1, s0
	sw	t1, 16(sp)
	addi	s0, sp, 48
	mv	t1, a0
	sw	t1, 0(sp)
	lw	t3, 0(sp)
	sw	t3, 4(sp)
	lw	t1, 4(sp)
	sw	t1, 20(sp)
	lw	t3, 20(sp)
	blt	zero,t3,%if.true
	j	%if.false
%exit.12:
	lw	t1, 8(sp)
	sw	t1, 24(sp)
	lw	t2, 24(sp)
	mv	a0, t2
	lw	t2, 12(sp)
	mv	ra, t2
	lw	t2, 16(sp)
	mv	s0, t2
	addi	sp, sp, 48
	ret
%if.true:
	lw	t1, 4(sp)
	sw	t1, 28(sp)
	lw	t3, 28(sp)
	sw	t3, 8(sp)
	j	%exit.12
%if.false:
	j	%if.exit
%if.exit:
	lw	t1, 4(sp)
	sw	t1, 32(sp)
	lw	t3, 32(sp)
	sub	t1, zero, t3
	sw	t1, 36(sp)
	lw	t3, 36(sp)
	sw	t3, 8(sp)
	j	%exit.12
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
%entry.13:
	addi	sp, sp, -224
	mv	t1, ra
	sw	t1, 8(sp)
	mv	t1, s0
	sw	t1, 12(sp)
	addi	s0, sp, 224
	call	_global_init
	sw	zero, 4(sp)
	lui	t1, %hi(i)
	sw	t1, 20(sp)
	lw	t2, 20(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 16(sp)
	lui	t1, %hi(i)
	sw	t1, 24(sp)
	lw	t2, 24(sp)
	sw	zero, %lo(i)(t2)
	j	%for.cond
%exit.13:
	lw	t1, 4(sp)
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	mv	a0, t2
	lw	t2, 8(sp)
	mv	ra, t2
	lw	t2, 12(sp)
	mv	s0, t2
	addi	sp, sp, 224
	ret
%for.cond:
	lui	t1, %hi(i)
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 32(sp)
	li	t1, 5
	sw	t1, 40(sp)
	lw	t2, 32(sp)
	lw	t3, 40(sp)
	blt	t2,t3,%for.body
	j	%for.exit
%for.incr:
	lui	t1, %hi(i)
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 44(sp)
	li	t1, 1
	sw	t1, 56(sp)
	lw	t2, 44(sp)
	lw	t3, 56(sp)
	add	t1, t2, t3
	sw	t1, 52(sp)
	lui	t1, %hi(i)
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	lw	t3, 52(sp)
	sw	t3, %lo(i)(t2)
	j	%for.cond
%for.body:
	lui	t1, %hi(j)
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	lw	t1, %lo(j)(t2)
	sw	t1, 64(sp)
	lui	t1, %hi(j)
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	sw	zero, %lo(j)(t2)
	j	%for.cond.1
%for.exit:
	lui	t1, %hi(r)
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	lw	t1, %lo(r)(t2)
	sw	t1, 76(sp)
	li	t1, 2
	sw	t1, 88(sp)
	lw	t2, 88(sp)
	lw	t3, 76(sp)
	sub	t1, t2, t3
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	mv	a0, t2
	call	abs
	mv	t1, a0
	sw	t1, 92(sp)
	lui	t1, %hi(c)
	sw	t1, 100(sp)
	lw	t2, 100(sp)
	lw	t1, %lo(c)(t2)
	sw	t1, 96(sp)
	li	t1, 2
	sw	t1, 108(sp)
	lw	t2, 108(sp)
	lw	t3, 96(sp)
	sub	t1, t2, t3
	sw	t1, 104(sp)
	lw	t2, 104(sp)
	mv	a0, t2
	call	abs
	mv	t1, a0
	sw	t1, 112(sp)
	lw	t2, 92(sp)
	lw	t3, 112(sp)
	add	t1, t2, t3
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	mv	a0, t2
	call	printInt
	sw	zero, 4(sp)
	j	%exit.13
%for.cond.1:
	lui	t1, %hi(j)
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	lw	t1, %lo(j)(t2)
	sw	t1, 120(sp)
	li	t1, 5
	sw	t1, 128(sp)
	lw	t2, 120(sp)
	lw	t3, 128(sp)
	blt	t2,t3,%for.body.1
	j	%for.exit.1
%for.incr.1:
	lui	t1, %hi(j)
	sw	t1, 136(sp)
	lw	t2, 136(sp)
	lw	t1, %lo(j)(t2)
	sw	t1, 132(sp)
	li	t1, 1
	sw	t1, 144(sp)
	lw	t2, 132(sp)
	lw	t3, 144(sp)
	add	t1, t2, t3
	sw	t1, 140(sp)
	lui	t1, %hi(j)
	sw	t1, 148(sp)
	lw	t2, 148(sp)
	lw	t3, 140(sp)
	sw	t3, %lo(j)(t2)
	j	%for.cond.1
%for.body.1:
	lui	t1, %hi(n)
	sw	t1, 156(sp)
	lw	t2, 156(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 152(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 160(sp)
	lui	t1, %hi(n)
	sw	t1, 164(sp)
	lw	t2, 164(sp)
	lw	t3, 160(sp)
	sw	t3, %lo(n)(t2)
	lui	t1, %hi(n)
	sw	t1, 172(sp)
	lw	t2, 172(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 168(sp)
	li	t1, 1
	sw	t1, 176(sp)
	lw	t2, 168(sp)
	lw	t3, 176(sp)
	beq	t2,t3,%if.true.1
	j	%if.false.1
%for.exit.1:
	j	%for.incr
%if.true.1:
	lui	t1, %hi(r)
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	lw	t1, %lo(r)(t2)
	sw	t1, 180(sp)
	lui	t1, %hi(i)
	sw	t1, 192(sp)
	lw	t2, 192(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 188(sp)
	lui	t1, %hi(r)
	sw	t1, 196(sp)
	lw	t2, 196(sp)
	lw	t3, 188(sp)
	sw	t3, %lo(r)(t2)
	lui	t1, %hi(c)
	sw	t1, 204(sp)
	lw	t2, 204(sp)
	lw	t1, %lo(c)(t2)
	sw	t1, 200(sp)
	lui	t1, %hi(j)
	sw	t1, 212(sp)
	lw	t2, 212(sp)
	lw	t1, %lo(j)(t2)
	sw	t1, 208(sp)
	lui	t1, %hi(c)
	sw	t1, 216(sp)
	lw	t2, 216(sp)
	lw	t3, 208(sp)
	sw	t3, %lo(c)(t2)
	j	%if.exit.1
%if.false.1:
	j	%if.exit.1
%if.exit.1:
	j	%for.incr.1
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
