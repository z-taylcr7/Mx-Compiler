	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry.11:
	addi	sp, sp, -16
	mv	t1, ra
	sw	t1, 0(sp)
	mv	t1, s0
	sw	t1, 4(sp)
	addi	s0, sp, 16
	j	exit.11
exit.11:
	lw	t2, 0(sp)
	mv	ra, t2
	lw	t2, 4(sp)
	mv	s0, t2
	addi	sp, sp, 16
	ret
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -208
	mv	t1, ra
	sw	t1, 24(sp)
	mv	t1, s0
	sw	t1, 28(sp)
	addi	s0, sp, 208
	call	_glb_init
	sw	zero, 20(sp)
	li	t1, 5
	sw	t1, 32(sp)
	lw	t3, 32(sp)
	sw	t3, 16(sp)
	sw	zero, 12(sp)
	lw	t1, 12(sp)
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	xor	t1, t2, zero
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	snez	t1, t2
	sb	t1, 40(sp)
	lb	t2, 40(sp)
	mv	t1, t2
	sb	t1, 48(sp)
	lb	t2, 40(sp)
	bne	t2,zero,logic.uncut
	j	logic.exit
exit.12:
	lw	t1, 20(sp)
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	mv	a0, t2
	lw	t2, 24(sp)
	mv	ra, t2
	lw	t2, 28(sp)
	mv	s0, t2
	addi	sp, sp, 208
	ret
logic.uncut:
	lw	t1, 16(sp)
	sw	t1, 56(sp)
	lw	t1, 12(sp)
	sw	t1, 60(sp)
	lw	t2, 56(sp)
	lw	t3, 60(sp)
	div	t1, t2, t3
	sw	t1, 64(sp)
	li	t1, 1
	sw	t1, 76(sp)
	lw	t2, 64(sp)
	lw	t3, 76(sp)
	xor	t1, t2, t3
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	snez	t1, t2
	sb	t1, 68(sp)
	lb	t2, 68(sp)
	mv	t1, t2
	sb	t1, 48(sp)
	j	logic.exit
logic.exit:
	lb	t2, 48(sp)
	mv	t1, t2
	sb	t1, 80(sp)
	lb	t3, 80(sp)
	sb	t3, 4(sp)
	lb	t1, 4(sp)
	sb	t1, 84(sp)
	lb	t2, 84(sp)
	mv	t1, t2
	sb	t1, 88(sp)
	lb	t2, 88(sp)
	bne	t2,zero,if.true
	j	if.false
if.true:
	lw	t1, 8(sp)
	sw	t1, 92(sp)
	li	t1, 10
	sw	t1, 96(sp)
	lw	t3, 96(sp)
	sw	t3, 8(sp)
	j	if.exit
if.false:
	lw	t1, 8(sp)
	sw	t1, 100(sp)
	li	t1, 20
	sw	t1, 104(sp)
	lw	t3, 104(sp)
	sw	t3, 8(sp)
	j	if.exit
if.exit:
	lb	t1, 0(sp)
	sb	t1, 108(sp)
	lb	t2, 108(sp)
	mv	t1, t2
	sb	t1, 112(sp)
	lw	t1, 8(sp)
	sw	t1, 116(sp)
	li	t1, 10
	sw	t1, 128(sp)
	lw	t2, 116(sp)
	lw	t3, 128(sp)
	xor	t1, t2, t3
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	seqz	t1, t2
	sb	t1, 120(sp)
	lb	t2, 120(sp)
	mv	t1, t2
	sb	t1, 132(sp)
	lb	t2, 120(sp)
	bne	t2,zero,logic.uncut.1
	j	logic.exit.1
logic.uncut.1:
	lw	t1, 16(sp)
	sw	t1, 136(sp)
	lw	t1, 12(sp)
	sw	t1, 140(sp)
	lw	t2, 136(sp)
	lw	t3, 140(sp)
	div	t1, t2, t3
	sw	t1, 144(sp)
	lw	t2, 144(sp)
	xor	t1, t2, zero
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	seqz	t1, t2
	sb	t1, 148(sp)
	lb	t2, 148(sp)
	mv	t1, t2
	sb	t1, 132(sp)
	j	logic.exit.1
logic.exit.1:
	lb	t2, 132(sp)
	mv	t1, t2
	sb	t1, 156(sp)
	lb	t2, 132(sp)
	bne	t2,zero,logic.uncut.2
	j	logic.exit.2
logic.uncut.2:
	lw	t1, 16(sp)
	sw	t1, 160(sp)
	li	t1, 5
	sw	t1, 172(sp)
	lw	t2, 160(sp)
	lw	t3, 172(sp)
	xor	t1, t2, t3
	sw	t1, 168(sp)
	lw	t2, 168(sp)
	seqz	t1, t2
	sb	t1, 164(sp)
	lb	t2, 164(sp)
	mv	t1, t2
	sb	t1, 156(sp)
	j	logic.exit.2
logic.exit.2:
	li	t1, 1
	sb	t1, 180(sp)
	lb	t2, 156(sp)
	lb	t3, 180(sp)
	xor	t1, t2, t3
	sb	t1, 176(sp)
	lb	t2, 176(sp)
	mv	t1, t2
	sb	t1, 184(sp)
	lb	t3, 184(sp)
	sb	t3, 0(sp)
	lb	t1, 0(sp)
	sb	t1, 188(sp)
	lb	t2, 188(sp)
	mv	t1, t2
	sb	t1, 192(sp)
	lb	t2, 192(sp)
	bne	t2,zero,if.true.1
	j	if.false.1
if.true.1:
	lw	t1, 8(sp)
	sw	t1, 196(sp)
	li	t1, 30
	sw	t1, 200(sp)
	lw	t3, 200(sp)
	sw	t3, 8(sp)
	j	if.exit.1
if.false.1:
	j	if.exit.1
if.exit.1:
	lw	t1, 8(sp)
	sw	t1, 204(sp)
	lw	t3, 204(sp)
	sw	t3, 20(sp)
	j	exit.12
                            #function ends.
