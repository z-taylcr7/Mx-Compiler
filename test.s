	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry.11:
	addi	sp, sp, -64
	mv	t1, ra
	sw	t1, 4(sp)
	mv	t1, s0
	sw	t1, 8(sp)
	addi	s0, sp, 64
	li	t1, 4
	sw	t1, 16(sp)
	li	t1, 4
	sw	t1, 20(sp)
	lw	t2, 16(sp)
	lw	t3, 20(sp)
	mul	t1, t2, t3
	sw	t1, 12(sp)
	li	t1, 4
	sw	t1, 28(sp)
	lw	t2, 12(sp)
	lw	t3, 28(sp)
	add	t1, t2, t3
	sw	t1, 24(sp)
	lw	t2, 24(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	mv	t1, t2
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	lw	t3, 16(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 48(sp)
	lw	t2, 36(sp)
	lw	t3, 48(sp)
	add	t1, t2, t3
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	mv	t1, t2
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	mv	t1, t2
	sw	t1, 52(sp)
	lui	t1, %hi(a)
	sw	t1, 56(sp)
	lw	t2, 56(sp)
	lw	t3, 52(sp)
	sw	t3, %lo(a)(t2)
	j	exit.11
exit.11:
	lw	t2, 4(sp)
	mv	ra, t2
	lw	t2, 8(sp)
	mv	s0, t2
	addi	sp, sp, 64
	ret
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -400
	mv	t1, ra
	sw	t1, 16(sp)
	mv	t1, s0
	sw	t1, 20(sp)
	addi	s0, sp, 400
	call	_glb_init
	sw	zero, 12(sp)
	lui	t1, %hi(a)
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	lw	t1, %lo(a)(t2)
	sw	t1, 24(sp)
	lw	t2, 24(sp)
	mv	t1, t2
	sw	t1, 32(sp)
	li	t1, -4
	sw	t1, 44(sp)
	lw	t2, 32(sp)
	lw	t3, 44(sp)
	add	t1, t2, t3
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	mv	t1, t2
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	lw	t1, 0(t2)
	sw	t1, 48(sp)
	li	t1, 4
	sw	t1, 56(sp)
	lw	t2, 48(sp)
	lw	t3, 56(sp)
	mul	t1, t2, t3
	sw	t1, 52(sp)
	li	t1, 4
	sw	t1, 64(sp)
	lw	t2, 52(sp)
	lw	t3, 64(sp)
	add	t1, t2, t3
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	mv	t1, t2
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	lw	t3, 48(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 84(sp)
	lw	t2, 72(sp)
	lw	t3, 84(sp)
	add	t1, t2, t3
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	mv	t1, t2
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	mv	t1, t2
	sw	t1, 88(sp)
	lw	t3, 88(sp)
	sw	t3, 8(sp)
	lw	t1, 4(sp)
	sw	t1, 92(sp)
	sw	zero, 4(sp)
	j	for.cond
exit.12:
	lw	t1, 12(sp)
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	mv	a0, t2
	lw	t2, 16(sp)
	mv	ra, t2
	lw	t2, 20(sp)
	mv	s0, t2
	addi	sp, sp, 400
	ret
for.cond:
	lw	t1, 4(sp)
	sw	t1, 100(sp)
	lui	t1, %hi(a)
	sw	t1, 108(sp)
	lw	t2, 108(sp)
	lw	t1, %lo(a)(t2)
	sw	t1, 104(sp)
	lw	t2, 104(sp)
	mv	t1, t2
	sw	t1, 112(sp)
	li	t1, -4
	sw	t1, 124(sp)
	lw	t2, 112(sp)
	lw	t3, 124(sp)
	add	t1, t2, t3
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	mv	t1, t2
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	lw	t1, 0(t2)
	sw	t1, 128(sp)
	lw	t2, 100(sp)
	lw	t3, 128(sp)
	blt	t2,t3,for.body
	j	for.exit
for.incr:
	lw	t1, 4(sp)
	sw	t1, 132(sp)
	li	t1, 1
	sw	t1, 140(sp)
	lw	t2, 132(sp)
	lw	t3, 140(sp)
	add	t1, t2, t3
	sw	t1, 136(sp)
	lw	t3, 136(sp)
	sw	t3, 4(sp)
	j	for.cond
for.body:
	lw	t1, 4(sp)
	sw	t1, 144(sp)
	lui	t1, %hi(a)
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	lw	t1, %lo(a)(t2)
	sw	t1, 148(sp)
	li	t1, 4
	sw	t1, 168(sp)
	lw	t2, 144(sp)
	lw	t3, 168(sp)
	mul	t1, t2, t3
	sw	t1, 164(sp)
	lw	t2, 148(sp)
	lw	t3, 164(sp)
	add	t1, t2, t3
	sw	t1, 160(sp)
	lw	t2, 160(sp)
	mv	t1, t2
	sw	t1, 156(sp)
	lw	t2, 156(sp)
	lw	t1, 0(t2)
	sw	t1, 172(sp)
	lw	t2, 156(sp)
	sw	zero, 0(t2)
	lw	t1, 4(sp)
	sw	t1, 176(sp)
	lw	t1, 8(sp)
	sw	t1, 180(sp)
	li	t1, 4
	sw	t1, 196(sp)
	lw	t2, 176(sp)
	lw	t3, 196(sp)
	mul	t1, t2, t3
	sw	t1, 192(sp)
	lw	t2, 180(sp)
	lw	t3, 192(sp)
	add	t1, t2, t3
	sw	t1, 188(sp)
	lw	t2, 188(sp)
	mv	t1, t2
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	lw	t1, 0(t2)
	sw	t1, 200(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 204(sp)
	lw	t2, 184(sp)
	lw	t3, 204(sp)
	sw	t3, 0(t2)
	j	for.incr
for.exit:
	lw	t1, 4(sp)
	sw	t1, 208(sp)
	sw	zero, 4(sp)
	j	for.cond.1
for.cond.1:
	lw	t1, 4(sp)
	sw	t1, 212(sp)
	lui	t1, %hi(a)
	sw	t1, 220(sp)
	lw	t2, 220(sp)
	lw	t1, %lo(a)(t2)
	sw	t1, 216(sp)
	lw	t2, 216(sp)
	mv	t1, t2
	sw	t1, 224(sp)
	li	t1, -4
	sw	t1, 236(sp)
	lw	t2, 224(sp)
	lw	t3, 236(sp)
	add	t1, t2, t3
	sw	t1, 232(sp)
	lw	t2, 232(sp)
	mv	t1, t2
	sw	t1, 228(sp)
	lw	t2, 228(sp)
	lw	t1, 0(t2)
	sw	t1, 240(sp)
	lw	t2, 212(sp)
	lw	t3, 240(sp)
	blt	t2,t3,for.body.1
	j	for.exit.1
for.incr.1:
	lw	t1, 4(sp)
	sw	t1, 244(sp)
	li	t1, 1
	sw	t1, 252(sp)
	lw	t2, 244(sp)
	lw	t3, 252(sp)
	add	t1, t2, t3
	sw	t1, 248(sp)
	lw	t3, 248(sp)
	sw	t3, 4(sp)
	j	for.cond.1
for.body.1:
	lw	t1, 4(sp)
	sw	t1, 256(sp)
	lui	t1, %hi(a)
	sw	t1, 264(sp)
	lw	t2, 264(sp)
	lw	t1, %lo(a)(t2)
	sw	t1, 260(sp)
	li	t1, 4
	sw	t1, 280(sp)
	lw	t2, 256(sp)
	lw	t3, 280(sp)
	mul	t1, t2, t3
	sw	t1, 276(sp)
	lw	t2, 260(sp)
	lw	t3, 276(sp)
	add	t1, t2, t3
	sw	t1, 272(sp)
	lw	t2, 272(sp)
	mv	t1, t2
	sw	t1, 268(sp)
	lw	t2, 268(sp)
	lw	t1, 0(t2)
	sw	t1, 284(sp)
	lw	t2, 284(sp)
	mv	a0, t2
	call	toString
	mv	t1, a0
	sw	t1, 288(sp)
	lw	t2, 288(sp)
	mv	a0, t2
	call	print
	j	for.incr.1
for.exit.1:
	la	t1, anon.strconst
	sw	t1, 296(sp)
	lw	t2, 296(sp)
	mv	t1, t2
	sw	t1, 292(sp)
	lw	t2, 292(sp)
	mv	a0, t2
	call	println
	lui	t1, %hi(a)
	sw	t1, 304(sp)
	lw	t2, 304(sp)
	lw	t1, %lo(a)(t2)
	sw	t1, 300(sp)
	lw	t1, 8(sp)
	sw	t1, 308(sp)
	lui	t1, %hi(a)
	sw	t1, 312(sp)
	lw	t2, 312(sp)
	lw	t3, 308(sp)
	sw	t3, %lo(a)(t2)
	lw	t1, 4(sp)
	sw	t1, 316(sp)
	sw	zero, 4(sp)
	j	for.cond.2
for.cond.2:
	lw	t1, 4(sp)
	sw	t1, 320(sp)
	lui	t1, %hi(a)
	sw	t1, 328(sp)
	lw	t2, 328(sp)
	lw	t1, %lo(a)(t2)
	sw	t1, 324(sp)
	lw	t2, 324(sp)
	mv	t1, t2
	sw	t1, 332(sp)
	li	t1, -4
	sw	t1, 344(sp)
	lw	t2, 332(sp)
	lw	t3, 344(sp)
	add	t1, t2, t3
	sw	t1, 340(sp)
	lw	t2, 340(sp)
	mv	t1, t2
	sw	t1, 336(sp)
	lw	t2, 336(sp)
	lw	t1, 0(t2)
	sw	t1, 348(sp)
	lw	t2, 320(sp)
	lw	t3, 348(sp)
	blt	t2,t3,for.body.2
	j	for.exit.2
for.incr.2:
	lw	t1, 4(sp)
	sw	t1, 352(sp)
	li	t1, 1
	sw	t1, 360(sp)
	lw	t2, 352(sp)
	lw	t3, 360(sp)
	add	t1, t2, t3
	sw	t1, 356(sp)
	lw	t3, 356(sp)
	sw	t3, 4(sp)
	j	for.cond.2
for.body.2:
	lw	t1, 4(sp)
	sw	t1, 364(sp)
	lui	t1, %hi(a)
	sw	t1, 372(sp)
	lw	t2, 372(sp)
	lw	t1, %lo(a)(t2)
	sw	t1, 368(sp)
	li	t1, 4
	sw	t1, 388(sp)
	lw	t2, 364(sp)
	lw	t3, 388(sp)
	mul	t1, t2, t3
	sw	t1, 384(sp)
	lw	t2, 368(sp)
	lw	t3, 384(sp)
	add	t1, t2, t3
	sw	t1, 380(sp)
	lw	t2, 380(sp)
	mv	t1, t2
	sw	t1, 376(sp)
	lw	t2, 376(sp)
	lw	t1, 0(t2)
	sw	t1, 392(sp)
	lw	t2, 392(sp)
	mv	a0, t2
	call	toString
	mv	t1, a0
	sw	t1, 396(sp)
	lw	t2, 396(sp)
	mv	a0, t2
	call	print
	j	for.incr.2
for.exit.2:
	sw	zero, 12(sp)
	j	exit.12
                            #function ends.
	.type	a,@object
	.section	.bss
	.globl	a
a:
	.word	0
	.size	a, 4
	.type	anon.strconst,@object
	.section	.rodata
anon.strconst:
	.asciz	""
	.size	anon.strconst, 0
