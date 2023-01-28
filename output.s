# fileName: test	 compiled by @Masterball.
	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.13:
	addi	sp, sp, -64
	sw	s0, 48(sp)
	sw	s1, 44(sp)
	sw	s2, 40(sp)
	sw	s3, 36(sp)
	sw	s4, 32(sp)
	sw	s5, 28(sp)
	sw	s6, 24(sp)
	sw	s7, 20(sp)
	sw	s8, 16(sp)
	sw	s9, 12(sp)
	sw	s10, 8(sp)
	sw	s11, 4(sp)
	sw	ra, 52(sp)
	li	s2, 0
	li	t0, 0
	sw	t0, 0(sp)
	li	t0, 500000
	blt	s2, t0, for.body.1
	lw	a0, 0(sp)
	call	printInt
	li	a0, 0
	lw	s0, 48(sp)
	lw	s1, 44(sp)
	lw	s2, 40(sp)
	lw	s3, 36(sp)
	lw	s4, 32(sp)
	lw	s5, 28(sp)
	lw	s6, 24(sp)
	lw	s7, 20(sp)
	lw	s8, 16(sp)
	lw	s9, 12(sp)
	lw	s10, 8(sp)
	lw	s11, 4(sp)
	lw	ra, 52(sp)
	addi	sp, sp, 64
	ret
for.body.1:
	addi	s3, s2, 1
	addi	s11, s2, 2
	addi	s10, s2, 3
	addi	t3, s2, 4
	addi	s8, s2, 5
	addi	t4, s2, 6
	addi	a2, s2, 7
	addi	t2, s2, 8
	addi	a6, s2, 9
	addi	a7, s2, 10
	addi	t1, s2, 11
	addi	s6, s2, 12
	addi	a4, s2, 13
	addi	t0, s2, 14
	addi	a1, s2, 15
	addi	s1, s2, 16
	addi	a0, s2, 17
	addi	t6, s2, 18
	addi	s0, s2, 19
	addi	a3, s2, 20
	addi	a5, s2, 21
	addi	s4, s2, 22
	addi	t5, s2, 23
	addi	s7, s2, 24
	li	ra, 0
	li	s9, 0
	li	s5, 50
	blt	ra, s5, for.body.i
	lw	t0, 0(sp)
	add	t0, t0, s9
	mv	s2, s3
	sw	t0, 0(sp)
	li	t0, 500000
	blt	s2, t0, for.body.1
	lw	a0, 0(sp)
	call	printInt
	li	a0, 0
	lw	s0, 48(sp)
	lw	s1, 44(sp)
	lw	s2, 40(sp)
	lw	s3, 36(sp)
	lw	s4, 32(sp)
	lw	s5, 28(sp)
	lw	s6, 24(sp)
	lw	s7, 20(sp)
	lw	s8, 16(sp)
	lw	s9, 12(sp)
	lw	s10, 8(sp)
	lw	s11, 4(sp)
	lw	ra, 52(sp)
	addi	sp, sp, 64
	ret
for.body.i:
	add	s5, s9, s2
	add	s5, s5, s3
	add	s5, s5, s11
	add	s5, s5, s10
	add	s5, s5, t3
	add	s5, s5, s8
	add	s5, s5, t4
	add	s5, s5, a2
	add	s5, s5, t2
	add	s5, s5, a6
	add	s5, s5, a7
	add	s5, s5, t1
	add	s5, s5, s6
	add	s5, s5, a4
	add	s5, s5, t0
	add	s5, s5, a1
	add	s5, s5, s1
	add	s5, s5, a0
	add	s5, s5, t6
	add	s5, s5, s0
	add	s5, s5, a3
	add	s5, s5, a5
	add	s5, s5, s4
	add	s5, s5, t5
	add	s5, s5, s7
	add	s5, s5, ra
	li	s9, 1000000
	bge	s5, s9, if.true.i
	addi	ra, ra, 1
	mv	s9, s5
	li	s5, 50
	blt	ra, s5, for.body.i
	lw	t0, 0(sp)
	add	t0, t0, s9
	mv	s2, s3
	sw	t0, 0(sp)
	li	t0, 500000
	blt	s2, t0, for.body.1
	lw	a0, 0(sp)
	call	printInt
	li	a0, 0
	lw	s0, 48(sp)
	lw	s1, 44(sp)
	lw	s2, 40(sp)
	lw	s3, 36(sp)
	lw	s4, 32(sp)
	lw	s5, 28(sp)
	lw	s6, 24(sp)
	lw	s7, 20(sp)
	lw	s8, 16(sp)
	lw	s9, 12(sp)
	lw	s10, 8(sp)
	lw	s11, 4(sp)
	lw	ra, 52(sp)
	addi	sp, sp, 64
	ret
if.true.i:
	li	s9, 1000000
	sub	s5, s5, s9
	addi	ra, ra, 1
	mv	s9, s5
	li	s5, 50
	blt	ra, s5, for.body.i
	lw	t0, 0(sp)
	add	t0, t0, s9
	mv	s2, s3
	sw	t0, 0(sp)
	li	t0, 500000
	blt	s2, t0, for.body.1
	lw	a0, 0(sp)
	call	printInt
	li	a0, 0
	lw	s0, 48(sp)
	lw	s1, 44(sp)
	lw	s2, 40(sp)
	lw	s3, 36(sp)
	lw	s4, 32(sp)
	lw	s5, 28(sp)
	lw	s6, 24(sp)
	lw	s7, 20(sp)
	lw	s8, 16(sp)
	lw	s9, 12(sp)
	lw	s10, 8(sp)
	lw	s11, 4(sp)
	lw	ra, 52(sp)
	addi	sp, sp, 64
	ret
	.size	main, .-main
                                        # -- End function
	.type	NUM_ITERATIONS,@object
	.section	.bss
	.globl	NUM_ITERATIONS
NUM_ITERATIONS:
	.word	0
	.size	NUM_ITERATIONS, 4