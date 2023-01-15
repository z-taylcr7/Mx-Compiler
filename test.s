	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry.11:
	addi	sp, sp, -32
	mv	t1, ra
	sw	t1, 0(sp)
	mv	t1, s0
	sw	t1, 4(sp)
	addi	s0, sp, 32
	lui	t1, %hi(ans)
	sw	t1, 8(sp)
	lw	t2, 8(sp)
	sw	zero, %lo(ans)(t2)
	lui	t1, %hi(fa)
	sw	t1, 12(sp)
	lw	t2, 12(sp)
	sw	zero, %lo(fa)(t2)
	lui	t1, %hi(rk)
	sw	t1, 16(sp)
	lw	t2, 16(sp)
	sw	zero, %lo(rk)(t2)
	lui	t1, %hi(e)
	sw	t1, 20(sp)
	lw	t2, 20(sp)
	sw	zero, %lo(e)(t2)
	j	exit.11
exit.11:
	lw	t2, 0(sp)
	mv	ra, t2
	lw	t2, 4(sp)
	mv	s0, t2
	addi	sp, sp, 32
	ret
                            #function ends.
	.globl	Edge.Edge
	.p2align	1
	.type	Edge.Edge,@function
Edge.Edge:
entry.12:
	addi	sp, sp, -16
	mv	t1, ra
	sw	t1, 4(sp)
	mv	t1, s0
	sw	t1, 8(sp)
	addi	s0, sp, 16
	mv	t1, a0
	sw	t1, 0(sp)
	j	exit.12
exit.12:
	lw	t2, 4(sp)
	mv	ra, t2
	lw	t2, 8(sp)
	mv	s0, t2
	addi	sp, sp, 16
	ret
                            #function ends.
	.globl	qsort
	.p2align	1
	.type	qsort,@function
qsort:
entry.13:
	addi	sp, sp, -512
	mv	t1, ra
	sw	t1, 36(sp)
	mv	t1, s0
	sw	t1, 40(sp)
	addi	s0, sp, 512
	mv	t1, a0
	sw	t1, 0(sp)
	mv	t1, a1
	sw	t1, 4(sp)
	mv	t1, a2
	sw	t1, 8(sp)
	lw	t3, 0(sp)
	sw	t3, 32(sp)
	lw	t3, 4(sp)
	sw	t3, 28(sp)
	lw	t3, 8(sp)
	sw	t3, 24(sp)
	lw	t1, 28(sp)
	sw	t1, 44(sp)
	lw	t1, 24(sp)
	sw	t1, 48(sp)
	lw	t2, 44(sp)
	lw	t3, 48(sp)
	blt	t2,t3,if.true
	j	if.false
exit.13:
	lw	t2, 36(sp)
	mv	ra, t2
	lw	t2, 40(sp)
	mv	s0, t2
	addi	sp, sp, 512
	ret
if.true:
	lw	t1, 28(sp)
	sw	t1, 52(sp)
	lw	t3, 52(sp)
	sw	t3, 20(sp)
	lw	t1, 24(sp)
	sw	t1, 56(sp)
	lw	t3, 56(sp)
	sw	t3, 16(sp)
	lw	t1, 28(sp)
	sw	t1, 60(sp)
	lw	t1, 32(sp)
	sw	t1, 64(sp)
	li	t1, 8
	sw	t1, 80(sp)
	lw	t2, 60(sp)
	lw	t3, 80(sp)
	mul	t1, t2, t3
	sw	t1, 76(sp)
	lw	t2, 64(sp)
	lw	t3, 76(sp)
	add	t1, t2, t3
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	mv	t1, t2
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	lw	t1, 0(t2)
	sw	t1, 84(sp)
	lw	t3, 84(sp)
	sw	t3, 12(sp)
	j	wh.cond
if.false:
	j	if.exit
if.exit:
	j	exit.13
wh.cond:
	lw	t1, 20(sp)
	sw	t1, 88(sp)
	lw	t1, 16(sp)
	sw	t1, 92(sp)
	lw	t2, 88(sp)
	lw	t3, 92(sp)
	blt	t2,t3,wh.body
	j	wh.exit
wh.body:
	j	wh.cond.1
wh.exit:
	lw	t1, 20(sp)
	sw	t1, 96(sp)
	lw	t1, 32(sp)
	sw	t1, 100(sp)
	li	t1, 8
	sw	t1, 116(sp)
	lw	t2, 96(sp)
	lw	t3, 116(sp)
	mul	t1, t2, t3
	sw	t1, 112(sp)
	lw	t2, 100(sp)
	lw	t3, 112(sp)
	add	t1, t2, t3
	sw	t1, 108(sp)
	lw	t2, 108(sp)
	mv	t1, t2
	sw	t1, 104(sp)
	lw	t2, 104(sp)
	lw	t1, 0(t2)
	sw	t1, 120(sp)
	lw	t1, 12(sp)
	sw	t1, 124(sp)
	lw	t2, 104(sp)
	lw	t3, 124(sp)
	sw	t3, 0(t2)
	lw	t1, 32(sp)
	sw	t1, 128(sp)
	lw	t1, 28(sp)
	sw	t1, 132(sp)
	lw	t1, 20(sp)
	sw	t1, 136(sp)
	li	t1, 1
	sw	t1, 144(sp)
	lw	t2, 136(sp)
	lw	t3, 144(sp)
	sub	t1, t2, t3
	sw	t1, 140(sp)
	lw	t2, 128(sp)
	mv	a0, t2
	lw	t2, 132(sp)
	mv	a1, t2
	lw	t2, 140(sp)
	mv	a2, t2
	call	qsort
	lw	t1, 32(sp)
	sw	t1, 148(sp)
	lw	t1, 20(sp)
	sw	t1, 152(sp)
	li	t1, 1
	sw	t1, 160(sp)
	lw	t2, 152(sp)
	lw	t3, 160(sp)
	add	t1, t2, t3
	sw	t1, 156(sp)
	lw	t1, 24(sp)
	sw	t1, 164(sp)
	lw	t2, 148(sp)
	mv	a0, t2
	lw	t2, 156(sp)
	mv	a1, t2
	lw	t2, 164(sp)
	mv	a2, t2
	call	qsort
	j	if.exit
wh.cond.1:
	lw	t1, 20(sp)
	sw	t1, 168(sp)
	lw	t1, 16(sp)
	sw	t1, 172(sp)
	lw	t2, 168(sp)
	lw	t3, 172(sp)
	slt	t1, t2, t3
	sb	t1, 176(sp)
	lb	t2, 176(sp)
	bne	t2,zero,logic.uncut
	j	logic.exit
wh.body.1:
	lw	t1, 16(sp)
	sw	t1, 180(sp)
	li	t1, -1
	sw	t1, 188(sp)
	lw	t2, 180(sp)
	lw	t3, 188(sp)
	add	t1, t2, t3
	sw	t1, 184(sp)
	lw	t3, 184(sp)
	sw	t3, 16(sp)
	j	wh.cond.1
wh.exit.1:
	lw	t1, 20(sp)
	sw	t1, 192(sp)
	lw	t1, 16(sp)
	sw	t1, 196(sp)
	lw	t2, 192(sp)
	lw	t3, 196(sp)
	blt	t2,t3,if.true.1
	j	if.false.1
logic.uncut:
	lw	t1, 16(sp)
	sw	t1, 200(sp)
	lw	t1, 32(sp)
	sw	t1, 204(sp)
	li	t1, 8
	sw	t1, 220(sp)
	lw	t2, 200(sp)
	lw	t3, 220(sp)
	mul	t1, t2, t3
	sw	t1, 216(sp)
	lw	t2, 204(sp)
	lw	t3, 216(sp)
	add	t1, t2, t3
	sw	t1, 212(sp)
	lw	t2, 212(sp)
	mv	t1, t2
	sw	t1, 208(sp)
	lw	t2, 208(sp)
	lw	t1, 0(t2)
	sw	t1, 224(sp)
	li	t1, 8
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
	lw	t1, 12(sp)
	sw	t1, 244(sp)
	li	t1, 8
	sw	t1, 256(sp)
	lw	t2, 244(sp)
	lw	t3, 256(sp)
	add	t1, t2, t3
	sw	t1, 252(sp)
	lw	t2, 252(sp)
	mv	t1, t2
	sw	t1, 248(sp)
	lw	t2, 248(sp)
	lw	t1, 0(t2)
	sw	t1, 260(sp)
	lw	t2, 240(sp)
	lw	t3, 260(sp)
	slt	t1, t2, t3
	sb	t1, 264(sp)
	lb	t2, 264(sp)
	xori	t1, t2, 1
	sb	t1, 264(sp)
	j	logic.exit
logic.exit:
	lb	t2, 268(sp)
	bne	t2,zero,wh.body.1
	j	wh.exit.1
if.true.1:
	lw	t1, 20(sp)
	sw	t1, 272(sp)
	lw	t1, 32(sp)
	sw	t1, 276(sp)
	li	t1, 8
	sw	t1, 292(sp)
	lw	t2, 272(sp)
	lw	t3, 292(sp)
	mul	t1, t2, t3
	sw	t1, 288(sp)
	lw	t2, 276(sp)
	lw	t3, 288(sp)
	add	t1, t2, t3
	sw	t1, 284(sp)
	lw	t2, 284(sp)
	mv	t1, t2
	sw	t1, 280(sp)
	lw	t2, 280(sp)
	lw	t1, 0(t2)
	sw	t1, 296(sp)
	lw	t1, 16(sp)
	sw	t1, 300(sp)
	lw	t1, 32(sp)
	sw	t1, 304(sp)
	li	t1, 8
	sw	t1, 320(sp)
	lw	t2, 300(sp)
	lw	t3, 320(sp)
	mul	t1, t2, t3
	sw	t1, 316(sp)
	lw	t2, 304(sp)
	lw	t3, 316(sp)
	add	t1, t2, t3
	sw	t1, 312(sp)
	lw	t2, 312(sp)
	mv	t1, t2
	sw	t1, 308(sp)
	lw	t2, 308(sp)
	lw	t1, 0(t2)
	sw	t1, 324(sp)
	lw	t2, 280(sp)
	lw	t3, 324(sp)
	sw	t3, 0(t2)
	lw	t1, 20(sp)
	sw	t1, 328(sp)
	li	t1, 1
	sw	t1, 336(sp)
	lw	t2, 328(sp)
	lw	t3, 336(sp)
	add	t1, t2, t3
	sw	t1, 332(sp)
	lw	t3, 332(sp)
	sw	t3, 20(sp)
	j	if.exit.1
if.false.1:
	j	if.exit.1
if.exit.1:
	j	wh.cond.2
wh.cond.2:
	lw	t1, 20(sp)
	sw	t1, 340(sp)
	lw	t1, 16(sp)
	sw	t1, 344(sp)
	lw	t2, 340(sp)
	lw	t3, 344(sp)
	slt	t1, t2, t3
	sb	t1, 348(sp)
	lb	t2, 348(sp)
	bne	t2,zero,logic.uncut.1
	j	logic.exit.1
wh.body.2:
	lw	t1, 20(sp)
	sw	t1, 352(sp)
	li	t1, 1
	sw	t1, 360(sp)
	lw	t2, 352(sp)
	lw	t3, 360(sp)
	add	t1, t2, t3
	sw	t1, 356(sp)
	lw	t3, 356(sp)
	sw	t3, 20(sp)
	j	wh.cond.2
wh.exit.2:
	lw	t1, 20(sp)
	sw	t1, 364(sp)
	lw	t1, 16(sp)
	sw	t1, 368(sp)
	lw	t2, 364(sp)
	lw	t3, 368(sp)
	blt	t2,t3,if.true.2
	j	if.false.2
logic.uncut.1:
	lw	t1, 20(sp)
	sw	t1, 372(sp)
	lw	t1, 32(sp)
	sw	t1, 376(sp)
	li	t1, 8
	sw	t1, 392(sp)
	lw	t2, 372(sp)
	lw	t3, 392(sp)
	mul	t1, t2, t3
	sw	t1, 388(sp)
	lw	t2, 376(sp)
	lw	t3, 388(sp)
	add	t1, t2, t3
	sw	t1, 384(sp)
	lw	t2, 384(sp)
	mv	t1, t2
	sw	t1, 380(sp)
	lw	t2, 380(sp)
	lw	t1, 0(t2)
	sw	t1, 396(sp)
	li	t1, 8
	sw	t1, 408(sp)
	lw	t2, 396(sp)
	lw	t3, 408(sp)
	add	t1, t2, t3
	sw	t1, 404(sp)
	lw	t2, 404(sp)
	mv	t1, t2
	sw	t1, 400(sp)
	lw	t2, 400(sp)
	lw	t1, 0(t2)
	sw	t1, 412(sp)
	lw	t1, 12(sp)
	sw	t1, 416(sp)
	li	t1, 8
	sw	t1, 428(sp)
	lw	t2, 416(sp)
	lw	t3, 428(sp)
	add	t1, t2, t3
	sw	t1, 424(sp)
	lw	t2, 424(sp)
	mv	t1, t2
	sw	t1, 420(sp)
	lw	t2, 420(sp)
	lw	t1, 0(t2)
	sw	t1, 432(sp)
	lw	t2, 412(sp)
	lw	t3, 432(sp)
	slt	t1, t2, t3
	sb	t1, 436(sp)
	j	logic.exit.1
logic.exit.1:
	lb	t2, 440(sp)
	bne	t2,zero,wh.body.2
	j	wh.exit.2
if.true.2:
	lw	t1, 16(sp)
	sw	t1, 444(sp)
	lw	t1, 32(sp)
	sw	t1, 448(sp)
	li	t1, 8
	sw	t1, 464(sp)
	lw	t2, 444(sp)
	lw	t3, 464(sp)
	mul	t1, t2, t3
	sw	t1, 460(sp)
	lw	t2, 448(sp)
	lw	t3, 460(sp)
	add	t1, t2, t3
	sw	t1, 456(sp)
	lw	t2, 456(sp)
	mv	t1, t2
	sw	t1, 452(sp)
	lw	t2, 452(sp)
	lw	t1, 0(t2)
	sw	t1, 468(sp)
	lw	t1, 20(sp)
	sw	t1, 472(sp)
	lw	t1, 32(sp)
	sw	t1, 476(sp)
	li	t1, 8
	sw	t1, 492(sp)
	lw	t2, 472(sp)
	lw	t3, 492(sp)
	mul	t1, t2, t3
	sw	t1, 488(sp)
	lw	t2, 476(sp)
	lw	t3, 488(sp)
	add	t1, t2, t3
	sw	t1, 484(sp)
	lw	t2, 484(sp)
	mv	t1, t2
	sw	t1, 480(sp)
	lw	t2, 480(sp)
	lw	t1, 0(t2)
	sw	t1, 496(sp)
	lw	t2, 452(sp)
	lw	t3, 496(sp)
	sw	t3, 0(t2)
	lw	t1, 16(sp)
	sw	t1, 500(sp)
	li	t1, -1
	sw	t1, 508(sp)
	lw	t2, 500(sp)
	lw	t3, 508(sp)
	add	t1, t2, t3
	sw	t1, 504(sp)
	lw	t3, 504(sp)
	sw	t3, 16(sp)
	j	if.exit.2
if.false.2:
	j	if.exit.2
if.exit.2:
	j	wh.cond
                            #function ends.
	.globl	init
	.p2align	1
	.type	init,@function
init:
entry.14:
	addi	sp, sp, -272
	mv	t1, ra
	sw	t1, 20(sp)
	mv	t1, s0
	sw	t1, 24(sp)
	addi	s0, sp, 272
	lui	t1, %hi(fa)
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	lw	t1, %lo(fa)(t2)
	sw	t1, 28(sp)
	lw	t3, 28(sp)
	sw	t3, 4(sp)
	lui	t1, %hi(rk)
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	lw	t1, %lo(rk)(t2)
	sw	t1, 36(sp)
	lw	t3, 36(sp)
	sw	t3, 8(sp)
	lui	t1, %hi(n)
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 44(sp)
	lw	t3, 44(sp)
	sw	t3, 12(sp)
	lw	t1, 4(sp)
	sw	t1, 52(sp)
	lw	t1, 12(sp)
	sw	t1, 56(sp)
	li	t1, 1
	sw	t1, 64(sp)
	lw	t2, 56(sp)
	lw	t3, 64(sp)
	add	t1, t2, t3
	sw	t1, 60(sp)
	li	t1, 4
	sw	t1, 72(sp)
	lw	t2, 60(sp)
	lw	t3, 72(sp)
	mul	t1, t2, t3
	sw	t1, 68(sp)
	li	t1, 4
	sw	t1, 80(sp)
	lw	t2, 68(sp)
	lw	t3, 80(sp)
	add	t1, t2, t3
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	mv	t1, t2
	sw	t1, 88(sp)
	lw	t2, 88(sp)
	lw	t3, 60(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 100(sp)
	lw	t2, 88(sp)
	lw	t3, 100(sp)
	add	t1, t2, t3
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	mv	t1, t2
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	mv	t1, t2
	sw	t1, 104(sp)
	lw	t3, 104(sp)
	sw	t3, 4(sp)
	lw	t1, 8(sp)
	sw	t1, 108(sp)
	lw	t1, 12(sp)
	sw	t1, 112(sp)
	li	t1, 1
	sw	t1, 120(sp)
	lw	t2, 112(sp)
	lw	t3, 120(sp)
	add	t1, t2, t3
	sw	t1, 116(sp)
	li	t1, 4
	sw	t1, 128(sp)
	lw	t2, 116(sp)
	lw	t3, 128(sp)
	mul	t1, t2, t3
	sw	t1, 124(sp)
	li	t1, 4
	sw	t1, 136(sp)
	lw	t2, 124(sp)
	lw	t3, 136(sp)
	add	t1, t2, t3
	sw	t1, 132(sp)
	lw	t2, 132(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 140(sp)
	lw	t2, 140(sp)
	mv	t1, t2
	sw	t1, 144(sp)
	lw	t2, 144(sp)
	lw	t3, 116(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 156(sp)
	lw	t2, 144(sp)
	lw	t3, 156(sp)
	add	t1, t2, t3
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	mv	t1, t2
	sw	t1, 148(sp)
	lw	t2, 148(sp)
	mv	t1, t2
	sw	t1, 160(sp)
	lw	t3, 160(sp)
	sw	t3, 8(sp)
	lw	t1, 16(sp)
	sw	t1, 164(sp)
	li	t1, 1
	sw	t1, 168(sp)
	lw	t3, 168(sp)
	sw	t3, 16(sp)
	j	for.cond
exit.14:
	lw	t1, 4(sp)
	sw	t1, 172(sp)
	lui	t1, %hi(fa)
	sw	t1, 176(sp)
	lw	t2, 176(sp)
	lw	t3, 172(sp)
	sw	t3, %lo(fa)(t2)
	lw	t1, 8(sp)
	sw	t1, 180(sp)
	lui	t1, %hi(rk)
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	lw	t3, 180(sp)
	sw	t3, %lo(rk)(t2)
	lw	t2, 20(sp)
	mv	ra, t2
	lw	t2, 24(sp)
	mv	s0, t2
	addi	sp, sp, 272
	ret
for.cond:
	lw	t1, 16(sp)
	sw	t1, 188(sp)
	lw	t1, 12(sp)
	sw	t1, 192(sp)
	lw	t2, 192(sp)
	lw	t3, 188(sp)
	bge	t2,t3,for.body
	j	for.exit
for.incr:
	lw	t1, 16(sp)
	sw	t1, 196(sp)
	li	t1, 1
	sw	t1, 204(sp)
	lw	t2, 196(sp)
	lw	t3, 204(sp)
	add	t1, t2, t3
	sw	t1, 200(sp)
	lw	t3, 200(sp)
	sw	t3, 16(sp)
	j	for.cond
for.body:
	lw	t1, 16(sp)
	sw	t1, 208(sp)
	lw	t1, 4(sp)
	sw	t1, 212(sp)
	li	t1, 4
	sw	t1, 228(sp)
	lw	t2, 208(sp)
	lw	t3, 228(sp)
	mul	t1, t2, t3
	sw	t1, 224(sp)
	lw	t2, 212(sp)
	lw	t3, 224(sp)
	add	t1, t2, t3
	sw	t1, 220(sp)
	lw	t2, 220(sp)
	mv	t1, t2
	sw	t1, 216(sp)
	lw	t2, 216(sp)
	lw	t1, 0(t2)
	sw	t1, 232(sp)
	lw	t1, 16(sp)
	sw	t1, 236(sp)
	lw	t2, 216(sp)
	lw	t3, 236(sp)
	sw	t3, 0(t2)
	lw	t1, 16(sp)
	sw	t1, 240(sp)
	lw	t1, 8(sp)
	sw	t1, 244(sp)
	li	t1, 4
	sw	t1, 260(sp)
	lw	t2, 240(sp)
	lw	t3, 260(sp)
	mul	t1, t2, t3
	sw	t1, 256(sp)
	lw	t2, 244(sp)
	lw	t3, 256(sp)
	add	t1, t2, t3
	sw	t1, 252(sp)
	lw	t2, 252(sp)
	mv	t1, t2
	sw	t1, 248(sp)
	lw	t2, 248(sp)
	lw	t1, 0(t2)
	sw	t1, 264(sp)
	li	t1, 1
	sw	t1, 268(sp)
	lw	t2, 248(sp)
	lw	t3, 268(sp)
	sw	t3, 0(t2)
	j	for.incr
for.exit:
	j	exit.14
                            #function ends.
	.globl	find
	.p2align	1
	.type	find,@function
find:
entry.15:
	addi	sp, sp, -144
	mv	t1, ra
	sw	t1, 12(sp)
	mv	t1, s0
	sw	t1, 16(sp)
	addi	s0, sp, 144
	mv	t1, a0
	sw	t1, 0(sp)
	lw	t3, 0(sp)
	sw	t3, 4(sp)
	lw	t1, 4(sp)
	sw	t1, 20(sp)
	lw	t1, 4(sp)
	sw	t1, 24(sp)
	lui	t1, %hi(fa)
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	lw	t1, %lo(fa)(t2)
	sw	t1, 28(sp)
	li	t1, 4
	sw	t1, 48(sp)
	lw	t2, 24(sp)
	lw	t3, 48(sp)
	mul	t1, t2, t3
	sw	t1, 44(sp)
	lw	t2, 28(sp)
	lw	t3, 44(sp)
	add	t1, t2, t3
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	mv	t1, t2
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	lw	t1, 0(t2)
	sw	t1, 52(sp)
	lw	t2, 20(sp)
	lw	t3, 52(sp)
	beq	t2,t3,if.true.3
	j	if.false.3
exit.15:
	lw	t1, 8(sp)
	sw	t1, 56(sp)
	lw	t2, 56(sp)
	mv	a0, t2
	lw	t2, 12(sp)
	mv	ra, t2
	lw	t2, 16(sp)
	mv	s0, t2
	addi	sp, sp, 144
	ret
if.true.3:
	lw	t1, 4(sp)
	sw	t1, 60(sp)
	lw	t3, 60(sp)
	sw	t3, 8(sp)
	j	exit.15
if.false.3:
	j	if.exit.3
if.exit.3:
	lw	t1, 4(sp)
	sw	t1, 64(sp)
	lw	t1, 4(sp)
	sw	t1, 68(sp)
	lui	t1, %hi(fa)
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	lw	t1, %lo(fa)(t2)
	sw	t1, 72(sp)
	li	t1, 4
	sw	t1, 92(sp)
	lw	t2, 68(sp)
	lw	t3, 92(sp)
	mul	t1, t2, t3
	sw	t1, 88(sp)
	lw	t2, 72(sp)
	lw	t3, 88(sp)
	add	t1, t2, t3
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	mv	t1, t2
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	lw	t1, 0(t2)
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	mv	a0, t2
	call	find
	mv	t1, a0
	sw	t1, 100(sp)
	lw	t3, 100(sp)
	sw	t3, 4(sp)
	lw	t1, 4(sp)
	sw	t1, 104(sp)
	lui	t1, %hi(fa)
	sw	t1, 112(sp)
	lw	t2, 112(sp)
	lw	t1, %lo(fa)(t2)
	sw	t1, 108(sp)
	li	t1, 4
	sw	t1, 128(sp)
	lw	t2, 104(sp)
	lw	t3, 128(sp)
	mul	t1, t2, t3
	sw	t1, 124(sp)
	lw	t2, 108(sp)
	lw	t3, 124(sp)
	add	t1, t2, t3
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	mv	t1, t2
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	lw	t1, 0(t2)
	sw	t1, 132(sp)
	lw	t3, 132(sp)
	sw	t3, 8(sp)
	j	exit.15
                            #function ends.
	.globl	union
	.p2align	1
	.type	union,@function
union:
entry.16:
	addi	sp, sp, -400
	mv	t1, ra
	sw	t1, 24(sp)
	mv	t1, s0
	sw	t1, 28(sp)
	addi	s0, sp, 400
	mv	t1, a0
	sw	t1, 0(sp)
	mv	t1, a1
	sw	t1, 4(sp)
	lui	t1, %hi(rk)
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	lw	t1, %lo(rk)(t2)
	sw	t1, 32(sp)
	lw	t3, 32(sp)
	sw	t3, 8(sp)
	lw	t3, 0(sp)
	sw	t3, 16(sp)
	lw	t3, 4(sp)
	sw	t3, 12(sp)
	lw	t1, 16(sp)
	sw	t1, 40(sp)
	lw	t1, 16(sp)
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	mv	a0, t2
	call	find
	mv	t1, a0
	sw	t1, 48(sp)
	lw	t3, 48(sp)
	sw	t3, 16(sp)
	lw	t1, 12(sp)
	sw	t1, 52(sp)
	lw	t1, 12(sp)
	sw	t1, 56(sp)
	lw	t2, 56(sp)
	mv	a0, t2
	call	find
	mv	t1, a0
	sw	t1, 60(sp)
	lw	t3, 60(sp)
	sw	t3, 12(sp)
	lw	t1, 16(sp)
	sw	t1, 64(sp)
	lw	t1, 12(sp)
	sw	t1, 68(sp)
	lw	t2, 64(sp)
	lw	t3, 68(sp)
	beq	t2,t3,if.true.4
	j	if.false.4
exit.16:
	lb	t1, 20(sp)
	sb	t1, 72(sp)
	lb	t2, 72(sp)
	mv	t1, t2
	sb	t1, 76(sp)
	lb	t2, 76(sp)
	mv	a0, t2
	lw	t2, 24(sp)
	mv	ra, t2
	lw	t2, 28(sp)
	mv	s0, t2
	addi	sp, sp, 400
	ret
if.true.4:
	li	t1, 0
	sb	t1, 80(sp)
	lb	t3, 80(sp)
	sb	t3, 20(sp)
	j	exit.16
if.false.4:
	j	if.exit.4
if.exit.4:
	lw	t1, 16(sp)
	sw	t1, 84(sp)
	lw	t1, 8(sp)
	sw	t1, 88(sp)
	li	t1, 4
	sw	t1, 104(sp)
	lw	t2, 84(sp)
	lw	t3, 104(sp)
	mul	t1, t2, t3
	sw	t1, 100(sp)
	lw	t2, 88(sp)
	lw	t3, 100(sp)
	add	t1, t2, t3
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	mv	t1, t2
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	lw	t1, 0(t2)
	sw	t1, 108(sp)
	lw	t1, 12(sp)
	sw	t1, 112(sp)
	lw	t1, 8(sp)
	sw	t1, 116(sp)
	li	t1, 4
	sw	t1, 132(sp)
	lw	t2, 112(sp)
	lw	t3, 132(sp)
	mul	t1, t2, t3
	sw	t1, 128(sp)
	lw	t2, 116(sp)
	lw	t3, 128(sp)
	add	t1, t2, t3
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	mv	t1, t2
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	lw	t1, 0(t2)
	sw	t1, 136(sp)
	lw	t2, 136(sp)
	lw	t3, 108(sp)
	blt	t2,t3,if.true.5
	j	if.false.5
if.true.5:
	lw	t1, 12(sp)
	sw	t1, 140(sp)
	lui	t1, %hi(fa)
	sw	t1, 148(sp)
	lw	t2, 148(sp)
	lw	t1, %lo(fa)(t2)
	sw	t1, 144(sp)
	li	t1, 4
	sw	t1, 164(sp)
	lw	t2, 140(sp)
	lw	t3, 164(sp)
	mul	t1, t2, t3
	sw	t1, 160(sp)
	lw	t2, 144(sp)
	lw	t3, 160(sp)
	add	t1, t2, t3
	sw	t1, 156(sp)
	lw	t2, 156(sp)
	mv	t1, t2
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	lw	t1, 0(t2)
	sw	t1, 168(sp)
	lw	t1, 16(sp)
	sw	t1, 172(sp)
	lw	t2, 152(sp)
	lw	t3, 172(sp)
	sw	t3, 0(t2)
	lw	t1, 16(sp)
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
	lw	t1, 16(sp)
	sw	t1, 204(sp)
	lw	t1, 8(sp)
	sw	t1, 208(sp)
	li	t1, 4
	sw	t1, 224(sp)
	lw	t2, 204(sp)
	lw	t3, 224(sp)
	mul	t1, t2, t3
	sw	t1, 220(sp)
	lw	t2, 208(sp)
	lw	t3, 220(sp)
	add	t1, t2, t3
	sw	t1, 216(sp)
	lw	t2, 216(sp)
	mv	t1, t2
	sw	t1, 212(sp)
	lw	t2, 212(sp)
	lw	t1, 0(t2)
	sw	t1, 228(sp)
	lw	t1, 12(sp)
	sw	t1, 232(sp)
	lw	t1, 8(sp)
	sw	t1, 236(sp)
	li	t1, 4
	sw	t1, 252(sp)
	lw	t2, 232(sp)
	lw	t3, 252(sp)
	mul	t1, t2, t3
	sw	t1, 248(sp)
	lw	t2, 236(sp)
	lw	t3, 248(sp)
	add	t1, t2, t3
	sw	t1, 244(sp)
	lw	t2, 244(sp)
	mv	t1, t2
	sw	t1, 240(sp)
	lw	t2, 240(sp)
	lw	t1, 0(t2)
	sw	t1, 256(sp)
	lw	t2, 228(sp)
	lw	t3, 256(sp)
	add	t1, t2, t3
	sw	t1, 260(sp)
	lw	t2, 184(sp)
	lw	t3, 260(sp)
	sw	t3, 0(t2)
	j	if.exit.5
if.false.5:
	lw	t1, 16(sp)
	sw	t1, 264(sp)
	lui	t1, %hi(fa)
	sw	t1, 272(sp)
	lw	t2, 272(sp)
	lw	t1, %lo(fa)(t2)
	sw	t1, 268(sp)
	li	t1, 4
	sw	t1, 288(sp)
	lw	t2, 264(sp)
	lw	t3, 288(sp)
	mul	t1, t2, t3
	sw	t1, 284(sp)
	lw	t2, 268(sp)
	lw	t3, 284(sp)
	add	t1, t2, t3
	sw	t1, 280(sp)
	lw	t2, 280(sp)
	mv	t1, t2
	sw	t1, 276(sp)
	lw	t2, 276(sp)
	lw	t1, 0(t2)
	sw	t1, 292(sp)
	lw	t1, 12(sp)
	sw	t1, 296(sp)
	lw	t2, 276(sp)
	lw	t3, 296(sp)
	sw	t3, 0(t2)
	lw	t1, 12(sp)
	sw	t1, 300(sp)
	lw	t1, 8(sp)
	sw	t1, 304(sp)
	li	t1, 4
	sw	t1, 320(sp)
	lw	t2, 300(sp)
	lw	t3, 320(sp)
	mul	t1, t2, t3
	sw	t1, 316(sp)
	lw	t2, 304(sp)
	lw	t3, 316(sp)
	add	t1, t2, t3
	sw	t1, 312(sp)
	lw	t2, 312(sp)
	mv	t1, t2
	sw	t1, 308(sp)
	lw	t2, 308(sp)
	lw	t1, 0(t2)
	sw	t1, 324(sp)
	lw	t1, 12(sp)
	sw	t1, 328(sp)
	lw	t1, 8(sp)
	sw	t1, 332(sp)
	li	t1, 4
	sw	t1, 348(sp)
	lw	t2, 328(sp)
	lw	t3, 348(sp)
	mul	t1, t2, t3
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
	sw	t1, 352(sp)
	lw	t1, 16(sp)
	sw	t1, 356(sp)
	lw	t1, 8(sp)
	sw	t1, 360(sp)
	li	t1, 4
	sw	t1, 376(sp)
	lw	t2, 356(sp)
	lw	t3, 376(sp)
	mul	t1, t2, t3
	sw	t1, 372(sp)
	lw	t2, 360(sp)
	lw	t3, 372(sp)
	add	t1, t2, t3
	sw	t1, 368(sp)
	lw	t2, 368(sp)
	mv	t1, t2
	sw	t1, 364(sp)
	lw	t2, 364(sp)
	lw	t1, 0(t2)
	sw	t1, 380(sp)
	lw	t2, 352(sp)
	lw	t3, 380(sp)
	add	t1, t2, t3
	sw	t1, 384(sp)
	lw	t2, 308(sp)
	lw	t3, 384(sp)
	sw	t3, 0(t2)
	j	if.exit.5
if.exit.5:
	li	t1, 1
	sb	t1, 388(sp)
	lb	t3, 388(sp)
	sb	t3, 20(sp)
	j	exit.16
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.17:
	addi	sp, sp, -544
	mv	t1, ra
	sw	t1, 36(sp)
	mv	t1, s0
	sw	t1, 40(sp)
	addi	s0, sp, 544
	lui	t1, %hi(m)
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	lw	t1, %lo(m)(t2)
	sw	t1, 44(sp)
	lw	t3, 44(sp)
	sw	t3, 12(sp)
	call	_glb_init
	sw	zero, 32(sp)
	lui	t1, %hi(n)
	sw	t1, 56(sp)
	lw	t2, 56(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 52(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 60(sp)
	lui	t1, %hi(n)
	sw	t1, 64(sp)
	lw	t2, 64(sp)
	lw	t3, 60(sp)
	sw	t3, %lo(n)(t2)
	lw	t1, 12(sp)
	sw	t1, 68(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 72(sp)
	lw	t3, 72(sp)
	sw	t3, 12(sp)
	lui	t1, %hi(e)
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	lw	t1, %lo(e)(t2)
	sw	t1, 76(sp)
	lw	t1, 12(sp)
	sw	t1, 84(sp)
	li	t1, 8
	sw	t1, 92(sp)
	lw	t2, 84(sp)
	lw	t3, 92(sp)
	mul	t1, t2, t3
	sw	t1, 88(sp)
	li	t1, 4
	sw	t1, 100(sp)
	lw	t2, 88(sp)
	lw	t3, 100(sp)
	add	t1, t2, t3
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 104(sp)
	lw	t2, 104(sp)
	mv	t1, t2
	sw	t1, 108(sp)
	lw	t2, 108(sp)
	lw	t3, 84(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 120(sp)
	lw	t2, 108(sp)
	lw	t3, 120(sp)
	add	t1, t2, t3
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	mv	t1, t2
	sw	t1, 112(sp)
	lw	t2, 112(sp)
	mv	t1, t2
	sw	t1, 124(sp)
	lui	t1, %hi(e)
	sw	t1, 128(sp)
	lw	t2, 128(sp)
	lw	t3, 124(sp)
	sw	t3, %lo(e)(t2)
	lw	t1, 28(sp)
	sw	t1, 132(sp)
	sw	zero, 28(sp)
	j	for.cond.1
exit.17:
	lw	t1, 12(sp)
	sw	t1, 136(sp)
	lui	t1, %hi(m)
	sw	t1, 140(sp)
	lw	t2, 140(sp)
	lw	t3, 136(sp)
	sw	t3, %lo(m)(t2)
	lw	t1, 32(sp)
	sw	t1, 144(sp)
	lw	t2, 144(sp)
	mv	a0, t2
	lw	t2, 36(sp)
	mv	ra, t2
	lw	t2, 40(sp)
	mv	s0, t2
	addi	sp, sp, 544
	ret
for.cond.1:
	lw	t1, 28(sp)
	sw	t1, 148(sp)
	lw	t1, 12(sp)
	sw	t1, 152(sp)
	lw	t2, 148(sp)
	lw	t3, 152(sp)
	blt	t2,t3,for.body.1
	j	for.exit.1
for.incr.1:
	lw	t1, 28(sp)
	sw	t1, 156(sp)
	li	t1, 1
	sw	t1, 164(sp)
	lw	t2, 156(sp)
	lw	t3, 164(sp)
	add	t1, t2, t3
	sw	t1, 160(sp)
	lw	t3, 160(sp)
	sw	t3, 28(sp)
	j	for.cond.1
for.body.1:
	li	t1, 12
	sw	t1, 168(sp)
	lw	t2, 168(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 172(sp)
	lw	t2, 172(sp)
	mv	t1, t2
	sw	t1, 176(sp)
	lw	t2, 176(sp)
	mv	a0, t2
	call	Edge.Edge
	lw	t3, 176(sp)
	sw	t3, 24(sp)
	lw	t1, 24(sp)
	sw	t1, 180(sp)
	lw	t2, 180(sp)
	mv	t1, t2
	sw	t1, 188(sp)
	lw	t2, 188(sp)
	mv	t1, t2
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	lw	t1, 0(t2)
	sw	t1, 192(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 196(sp)
	lw	t2, 184(sp)
	lw	t3, 196(sp)
	sw	t3, 0(t2)
	lw	t1, 24(sp)
	sw	t1, 200(sp)
	li	t1, 4
	sw	t1, 212(sp)
	lw	t2, 200(sp)
	lw	t3, 212(sp)
	add	t1, t2, t3
	sw	t1, 208(sp)
	lw	t2, 208(sp)
	mv	t1, t2
	sw	t1, 204(sp)
	lw	t2, 204(sp)
	lw	t1, 0(t2)
	sw	t1, 216(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 220(sp)
	lw	t2, 204(sp)
	lw	t3, 220(sp)
	sw	t3, 0(t2)
	lw	t1, 24(sp)
	sw	t1, 224(sp)
	li	t1, 8
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
	call	getInt
	mv	t1, a0
	sw	t1, 244(sp)
	lw	t2, 228(sp)
	lw	t3, 244(sp)
	sw	t3, 0(t2)
	lw	t1, 28(sp)
	sw	t1, 248(sp)
	lui	t1, %hi(e)
	sw	t1, 256(sp)
	lw	t2, 256(sp)
	lw	t1, %lo(e)(t2)
	sw	t1, 252(sp)
	li	t1, 8
	sw	t1, 272(sp)
	lw	t2, 248(sp)
	lw	t3, 272(sp)
	mul	t1, t2, t3
	sw	t1, 268(sp)
	lw	t2, 252(sp)
	lw	t3, 268(sp)
	add	t1, t2, t3
	sw	t1, 264(sp)
	lw	t2, 264(sp)
	mv	t1, t2
	sw	t1, 260(sp)
	lw	t2, 260(sp)
	lw	t1, 0(t2)
	sw	t1, 276(sp)
	lw	t1, 24(sp)
	sw	t1, 280(sp)
	lw	t2, 260(sp)
	lw	t3, 280(sp)
	sw	t3, 0(t2)
	j	for.incr.1
for.exit.1:
	lui	t1, %hi(e)
	sw	t1, 288(sp)
	lw	t2, 288(sp)
	lw	t1, %lo(e)(t2)
	sw	t1, 284(sp)
	lw	t1, 12(sp)
	sw	t1, 292(sp)
	li	t1, 1
	sw	t1, 300(sp)
	lw	t2, 292(sp)
	lw	t3, 300(sp)
	sub	t1, t2, t3
	sw	t1, 296(sp)
	lw	t2, 284(sp)
	mv	a0, t2
	mv	a1, zero
	lw	t2, 296(sp)
	mv	a2, t2
	call	qsort
	call	init
	lw	t1, 28(sp)
	sw	t1, 304(sp)
	sw	zero, 28(sp)
	sw	zero, 20(sp)
	j	wh.cond.3
wh.cond.3:
	lw	t1, 28(sp)
	sw	t1, 308(sp)
	lui	t1, %hi(n)
	sw	t1, 316(sp)
	lw	t2, 316(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 312(sp)
	li	t1, 1
	sw	t1, 324(sp)
	lw	t2, 312(sp)
	lw	t3, 324(sp)
	sub	t1, t2, t3
	sw	t1, 320(sp)
	lw	t2, 308(sp)
	lw	t3, 320(sp)
	blt	t2,t3,wh.body.3
	j	wh.exit.3
wh.body.3:
	lw	t1, 20(sp)
	sw	t1, 328(sp)
	lw	t1, 12(sp)
	sw	t1, 332(sp)
	lw	t2, 328(sp)
	lw	t3, 332(sp)
	bge	t2,t3,if.true.6
	j	if.false.6
wh.exit.3:
	li	t1, 1
	sw	t1, 336(sp)
	lw	t2, 336(sp)
	mv	a0, t2
	call	find
	mv	t1, a0
	sw	t1, 340(sp)
	lui	t1, %hi(rk)
	sw	t1, 348(sp)
	lw	t2, 348(sp)
	lw	t1, %lo(rk)(t2)
	sw	t1, 344(sp)
	li	t1, 4
	sw	t1, 364(sp)
	lw	t2, 340(sp)
	lw	t3, 364(sp)
	mul	t1, t2, t3
	sw	t1, 360(sp)
	lw	t2, 344(sp)
	lw	t3, 360(sp)
	add	t1, t2, t3
	sw	t1, 356(sp)
	lw	t2, 356(sp)
	mv	t1, t2
	sw	t1, 352(sp)
	lw	t2, 352(sp)
	lw	t1, 0(t2)
	sw	t1, 368(sp)
	lui	t1, %hi(n)
	sw	t1, 376(sp)
	lw	t2, 376(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 372(sp)
	lw	t2, 368(sp)
	lw	t3, 372(sp)
	beq	t2,t3,if.true.8
	j	if.false.8
if.true.6:
	li	t1, 1
	sw	t1, 384(sp)
	lw	t3, 384(sp)
	sub	t1, zero, t3
	sw	t1, 380(sp)
	lw	t2, 380(sp)
	mv	a0, t2
	call	printInt
	sw	zero, 32(sp)
	j	exit.17
if.false.6:
	j	if.exit.6
if.exit.6:
	lw	t1, 20(sp)
	sw	t1, 388(sp)
	lui	t1, %hi(e)
	sw	t1, 396(sp)
	lw	t2, 396(sp)
	lw	t1, %lo(e)(t2)
	sw	t1, 392(sp)
	li	t1, 8
	sw	t1, 412(sp)
	lw	t2, 388(sp)
	lw	t3, 412(sp)
	mul	t1, t2, t3
	sw	t1, 408(sp)
	lw	t2, 392(sp)
	lw	t3, 408(sp)
	add	t1, t2, t3
	sw	t1, 404(sp)
	lw	t2, 404(sp)
	mv	t1, t2
	sw	t1, 400(sp)
	lw	t2, 400(sp)
	lw	t1, 0(t2)
	sw	t1, 416(sp)
	lw	t3, 416(sp)
	sw	t3, 16(sp)
	lw	t1, 20(sp)
	sw	t1, 420(sp)
	li	t1, 1
	sw	t1, 428(sp)
	lw	t2, 420(sp)
	lw	t3, 428(sp)
	add	t1, t2, t3
	sw	t1, 424(sp)
	lw	t3, 424(sp)
	sw	t3, 20(sp)
	lw	t1, 16(sp)
	sw	t1, 432(sp)
	lw	t2, 432(sp)
	mv	t1, t2
	sw	t1, 440(sp)
	lw	t2, 440(sp)
	mv	t1, t2
	sw	t1, 436(sp)
	lw	t2, 436(sp)
	lw	t1, 0(t2)
	sw	t1, 444(sp)
	lw	t1, 16(sp)
	sw	t1, 448(sp)
	li	t1, 4
	sw	t1, 460(sp)
	lw	t2, 448(sp)
	lw	t3, 460(sp)
	add	t1, t2, t3
	sw	t1, 456(sp)
	lw	t2, 456(sp)
	mv	t1, t2
	sw	t1, 452(sp)
	lw	t2, 452(sp)
	lw	t1, 0(t2)
	sw	t1, 464(sp)
	lw	t2, 444(sp)
	mv	a0, t2
	lw	t2, 464(sp)
	mv	a1, t2
	call	union
	mv	t1, a0
	sb	t1, 468(sp)
	lb	t2, 468(sp)
	bne	t2,zero,if.true.7
	j	if.false.7
if.true.7:
	lw	t1, 28(sp)
	sw	t1, 472(sp)
	li	t1, 1
	sw	t1, 480(sp)
	lw	t2, 472(sp)
	lw	t3, 480(sp)
	add	t1, t2, t3
	sw	t1, 476(sp)
	lw	t3, 476(sp)
	sw	t3, 28(sp)
	lui	t1, %hi(ans)
	sw	t1, 488(sp)
	lw	t2, 488(sp)
	lw	t1, %lo(ans)(t2)
	sw	t1, 484(sp)
	lui	t1, %hi(ans)
	sw	t1, 496(sp)
	lw	t2, 496(sp)
	lw	t1, %lo(ans)(t2)
	sw	t1, 492(sp)
	lw	t1, 16(sp)
	sw	t1, 500(sp)
	li	t1, 8
	sw	t1, 512(sp)
	lw	t2, 500(sp)
	lw	t3, 512(sp)
	add	t1, t2, t3
	sw	t1, 508(sp)
	lw	t2, 508(sp)
	mv	t1, t2
	sw	t1, 504(sp)
	lw	t2, 504(sp)
	lw	t1, 0(t2)
	sw	t1, 516(sp)
	lw	t2, 492(sp)
	lw	t3, 516(sp)
	add	t1, t2, t3
	sw	t1, 520(sp)
	lui	t1, %hi(ans)
	sw	t1, 524(sp)
	lw	t2, 524(sp)
	lw	t3, 520(sp)
	sw	t3, %lo(ans)(t2)
	j	if.exit.7
if.false.7:
	j	if.exit.7
if.exit.7:
	j	wh.cond.3
if.true.8:
	lui	t1, %hi(ans)
	sw	t1, 532(sp)
	lw	t2, 532(sp)
	lw	t1, %lo(ans)(t2)
	sw	t1, 528(sp)
	lw	t2, 528(sp)
	mv	a0, t2
	call	printInt
	j	if.exit.8
if.false.8:
	li	t1, 1
	sw	t1, 540(sp)
	lw	t3, 540(sp)
	sub	t1, zero, t3
	sw	t1, 536(sp)
	lw	t2, 536(sp)
	mv	a0, t2
	call	printInt
	j	if.exit.8
if.exit.8:
	sw	zero, 32(sp)
	j	exit.17
                            #function ends.
	.type	n,@object
	.section	.bss
	.globl	n
n:
	.word	0
	.size	n, 4
	.type	m,@object
	.section	.bss
	.globl	m
m:
	.word	0
	.size	m, 4
	.type	ans,@object
	.section	.bss
	.globl	ans
ans:
	.word	0
	.size	ans, 4
	.type	fa,@object
	.section	.bss
	.globl	fa
fa:
	.word	0
	.size	fa, 4
	.type	rk,@object
	.section	.bss
	.globl	rk
rk:
	.word	0
	.size	rk, 4
	.type	e,@object
	.section	.bss
	.globl	e
e:
	.word	0
	.size	e, 4
