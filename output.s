	.text
	.globl	_glb_init
	.p2align	1
	.type	_glb_init,@function
_glb_init:
entry.11:
	addi	sp, sp, -80
	mv	t1, ra
	sw	t1, 4(sp)
	mv	t1, s0
	sw	t1, 8(sp)
	addi	s0, sp, 80
	lui	t1, %hi(N)
	sw	t1, 12(sp)
	li	t1, 15000
	sw	t1, 16(sp)
	lw	t2, 12(sp)
	lw	t3, 16(sp)
	sw	t3, %lo(N)(t2)
	li	t1, 15001
	sw	t1, 24(sp)
	li	t1, 1
	sw	t1, 28(sp)
	lw	t2, 24(sp)
	lw	t3, 28(sp)
	mul	t1, t2, t3
	sw	t1, 20(sp)
	li	t1, 4
	sw	t1, 36(sp)
	lw	t2, 20(sp)
	lw	t3, 36(sp)
	add	t1, t2, t3
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 40(sp)
	lw	t2, 40(sp)
	mv	t1, t2
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	lw	t3, 24(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 56(sp)
	lw	t2, 44(sp)
	lw	t3, 56(sp)
	add	t1, t2, t3
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	mv	t1, t2
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	mv	t1, t2
	sw	t1, 60(sp)
	lui	t1, %hi(b)
	sw	t1, 64(sp)
	lw	t2, 64(sp)
	lw	t3, 60(sp)
	sw	t3, %lo(b)(t2)
	lui	t1, %hi(resultCount)
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	sw	zero, %lo(resultCount)(t2)
	j	exit.11
exit.11:
	lw	t2, 4(sp)
	mv	ra, t2
	lw	t2, 8(sp)
	mv	s0, t2
	addi	sp, sp, 80
	ret
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -400
	mv	t1, ra
	sw	t1, 20(sp)
	mv	t1, s0
	sw	t1, 24(sp)
	addi	s0, sp, 400
	call	_glb_init
	sw	zero, 16(sp)
	lw	t1, 12(sp)
	sw	t1, 28(sp)
	li	t1, 1
	sw	t1, 32(sp)
	lw	t3, 32(sp)
	sw	t3, 12(sp)
	j	for.cond
exit.12:
	lw	t1, 16(sp)
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	mv	a0, t2
	lw	t2, 20(sp)
	mv	ra, t2
	lw	t2, 24(sp)
	mv	s0, t2
	addi	sp, sp, 400
	ret
for.cond:
	lw	t1, 12(sp)
	sw	t1, 40(sp)
	lui	t1, %hi(N)
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	lw	t3, 40(sp)
	bge	t2,t3,for.body
	j	for.exit
for.incr:
	lw	t1, 12(sp)
	sw	t1, 52(sp)
	li	t1, 1
	sw	t1, 60(sp)
	lw	t2, 52(sp)
	lw	t3, 60(sp)
	add	t1, t2, t3
	sw	t1, 56(sp)
	lw	t3, 56(sp)
	sw	t3, 12(sp)
	j	for.cond
for.body:
	lw	t1, 12(sp)
	sw	t1, 64(sp)
	lui	t1, %hi(b)
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	lw	t1, %lo(b)(t2)
	sw	t1, 68(sp)
	li	t1, 1
	sw	t1, 88(sp)
	lw	t2, 64(sp)
	lw	t3, 88(sp)
	mul	t1, t2, t3
	sw	t1, 84(sp)
	lw	t2, 68(sp)
	lw	t3, 84(sp)
	add	t1, t2, t3
	sw	t1, 80(sp)
	lw	t2, 80(sp)
	mv	t1, t2
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	lb	t1, 0(t2)
	sb	t1, 92(sp)
	lb	t2, 92(sp)
	mv	t1, t2
	sb	t1, 96(sp)
	li	t1, 1
	sb	t1, 100(sp)
	lw	t2, 76(sp)
	lb	t3, 100(sp)
	sb	t3, 0(t2)
	j	for.incr
for.exit:
	lw	t1, 12(sp)
	sw	t1, 104(sp)
	li	t1, 2
	sw	t1, 108(sp)
	lw	t3, 108(sp)
	sw	t3, 12(sp)
	j	for.cond.1
for.cond.1:
	lw	t1, 12(sp)
	sw	t1, 112(sp)
	lui	t1, %hi(N)
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 116(sp)
	lw	t2, 116(sp)
	lw	t3, 112(sp)
	bge	t2,t3,for.body.1
	j	for.exit.1
for.incr.1:
	lw	t1, 12(sp)
	sw	t1, 124(sp)
	li	t1, 1
	sw	t1, 132(sp)
	lw	t2, 124(sp)
	lw	t3, 132(sp)
	add	t1, t2, t3
	sw	t1, 128(sp)
	lw	t3, 128(sp)
	sw	t3, 12(sp)
	j	for.cond.1
for.body.1:
	lw	t1, 12(sp)
	sw	t1, 136(sp)
	lui	t1, %hi(b)
	sw	t1, 144(sp)
	lw	t2, 144(sp)
	lw	t1, %lo(b)(t2)
	sw	t1, 140(sp)
	li	t1, 1
	sw	t1, 160(sp)
	lw	t2, 136(sp)
	lw	t3, 160(sp)
	mul	t1, t2, t3
	sw	t1, 156(sp)
	lw	t2, 140(sp)
	lw	t3, 156(sp)
	add	t1, t2, t3
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	mv	t1, t2
	sw	t1, 148(sp)
	lw	t2, 148(sp)
	lb	t1, 0(t2)
	sb	t1, 164(sp)
	lb	t2, 164(sp)
	mv	t1, t2
	sb	t1, 168(sp)
	lb	t2, 168(sp)
	bne	t2,zero,if.true
	j	if.false
for.exit.1:
	la	t1, anon.strconst.1
	sw	t1, 176(sp)
	lw	t2, 176(sp)
	mv	t1, t2
	sw	t1, 172(sp)
	lui	t1, %hi(resultCount)
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	lw	t1, %lo(resultCount)(t2)
	sw	t1, 180(sp)
	lw	t2, 180(sp)
	mv	a0, t2
	call	toString
	mv	t1, a0
	sw	t1, 188(sp)
	lw	t2, 172(sp)
	mv	a0, t2
	lw	t2, 188(sp)
	mv	a1, t2
	call	_bot_str_cat
	mv	t1, a0
	sw	t1, 192(sp)
	lw	t2, 192(sp)
	mv	a0, t2
	call	println
	sw	zero, 16(sp)
	j	exit.12
if.true:
	li	t1, 2
	sw	t1, 196(sp)
	lw	t3, 196(sp)
	sw	t3, 8(sp)
	lw	t1, 12(sp)
	sw	t1, 200(sp)
	li	t1, 3
	sw	t1, 208(sp)
	lw	t2, 208(sp)
	lw	t3, 200(sp)
	slt	t1, t2, t3
	sb	t1, 204(sp)
	lb	t2, 204(sp)
	mv	t1, t2
	sb	t1, 212(sp)
	lb	t2, 204(sp)
	bne	t2,zero,logic.uncut
	j	logic.exit
if.false:
	j	if.exit
if.exit:
	j	for.incr.1
if.true.1:
	lui	t1, %hi(resultCount)
	sw	t1, 220(sp)
	lw	t2, 220(sp)
	lw	t1, %lo(resultCount)(t2)
	sw	t1, 216(sp)
	li	t1, 1
	sw	t1, 228(sp)
	lw	t2, 216(sp)
	lw	t3, 228(sp)
	add	t1, t2, t3
	sw	t1, 224(sp)
	lui	t1, %hi(resultCount)
	sw	t1, 232(sp)
	lw	t2, 232(sp)
	lw	t3, 224(sp)
	sw	t3, %lo(resultCount)(t2)
	lw	t1, 12(sp)
	sw	t1, 236(sp)
	li	t1, 2
	sw	t1, 244(sp)
	lw	t2, 236(sp)
	lw	t3, 244(sp)
	sub	t1, t2, t3
	sw	t1, 240(sp)
	lw	t2, 240(sp)
	mv	a0, t2
	call	toString
	mv	t1, a0
	sw	t1, 248(sp)
	la	t1, anon.strconst
	sw	t1, 256(sp)
	lw	t2, 256(sp)
	mv	t1, t2
	sw	t1, 252(sp)
	lw	t2, 248(sp)
	mv	a0, t2
	lw	t2, 252(sp)
	mv	a1, t2
	call	_bot_str_cat
	mv	t1, a0
	sw	t1, 260(sp)
	lw	t1, 12(sp)
	sw	t1, 264(sp)
	lw	t2, 264(sp)
	mv	a0, t2
	call	toString
	mv	t1, a0
	sw	t1, 268(sp)
	lw	t2, 260(sp)
	mv	a0, t2
	lw	t2, 268(sp)
	mv	a1, t2
	call	_bot_str_cat
	mv	t1, a0
	sw	t1, 272(sp)
	lw	t2, 272(sp)
	mv	a0, t2
	call	println
	j	if.exit.1
if.false.1:
	j	if.exit.1
if.exit.1:
	j	wh.cond
logic.uncut:
	lw	t1, 12(sp)
	sw	t1, 276(sp)
	li	t1, 2
	sw	t1, 284(sp)
	lw	t2, 276(sp)
	lw	t3, 284(sp)
	sub	t1, t2, t3
	sw	t1, 280(sp)
	lui	t1, %hi(b)
	sw	t1, 292(sp)
	lw	t2, 292(sp)
	lw	t1, %lo(b)(t2)
	sw	t1, 288(sp)
	li	t1, 1
	sw	t1, 308(sp)
	lw	t2, 280(sp)
	lw	t3, 308(sp)
	mul	t1, t2, t3
	sw	t1, 304(sp)
	lw	t2, 288(sp)
	lw	t3, 304(sp)
	add	t1, t2, t3
	sw	t1, 300(sp)
	lw	t2, 300(sp)
	mv	t1, t2
	sw	t1, 296(sp)
	lw	t2, 296(sp)
	lb	t1, 0(t2)
	sb	t1, 312(sp)
	lb	t2, 312(sp)
	mv	t1, t2
	sb	t1, 316(sp)
	lb	t2, 316(sp)
	mv	t1, t2
	sb	t1, 212(sp)
	j	logic.exit
logic.exit:
	lb	t2, 212(sp)
	bne	t2,zero,if.true.1
	j	if.false.1
wh.cond:
	lw	t1, 12(sp)
	sw	t1, 320(sp)
	lw	t1, 8(sp)
	sw	t1, 324(sp)
	lw	t2, 320(sp)
	lw	t3, 324(sp)
	mul	t1, t2, t3
	sw	t1, 328(sp)
	lui	t1, %hi(N)
	sw	t1, 336(sp)
	lw	t2, 336(sp)
	lw	t1, %lo(N)(t2)
	sw	t1, 332(sp)
	lw	t2, 332(sp)
	lw	t3, 328(sp)
	bge	t2,t3,wh.body
	j	wh.exit
wh.body:
	lw	t1, 12(sp)
	sw	t1, 340(sp)
	lw	t1, 8(sp)
	sw	t1, 344(sp)
	lw	t2, 340(sp)
	lw	t3, 344(sp)
	mul	t1, t2, t3
	sw	t1, 348(sp)
	lui	t1, %hi(b)
	sw	t1, 356(sp)
	lw	t2, 356(sp)
	lw	t1, %lo(b)(t2)
	sw	t1, 352(sp)
	li	t1, 1
	sw	t1, 372(sp)
	lw	t2, 348(sp)
	lw	t3, 372(sp)
	mul	t1, t2, t3
	sw	t1, 368(sp)
	lw	t2, 352(sp)
	lw	t3, 368(sp)
	add	t1, t2, t3
	sw	t1, 364(sp)
	lw	t2, 364(sp)
	mv	t1, t2
	sw	t1, 360(sp)
	lw	t2, 360(sp)
	lb	t1, 0(t2)
	sb	t1, 376(sp)
	lb	t2, 376(sp)
	mv	t1, t2
	sb	t1, 380(sp)
	li	t1, 0
	sb	t1, 384(sp)
	lw	t2, 360(sp)
	lb	t3, 384(sp)
	sb	t3, 0(t2)
	lw	t1, 8(sp)
	sw	t1, 388(sp)
	li	t1, 1
	sw	t1, 396(sp)
	lw	t2, 388(sp)
	lw	t3, 396(sp)
	add	t1, t2, t3
	sw	t1, 392(sp)
	lw	t3, 392(sp)
	sw	t3, 8(sp)
	j	wh.cond
wh.exit:
	j	if.exit
                            #function ends.
	.type	N,@object
	.section	.bss
	.globl	N
N:
	.word	0
	.size	N, 4
	.type	b,@object
	.section	.bss
	.globl	b
b:
	.word	0
	.size	b, 4
	.type	resultCount,@object
	.section	.bss
	.globl	resultCount
resultCount:
	.word	0
	.size	resultCount, 4
	.type	anon.strconst,@object
	.section	.rodata
anon.strconst:
	.asciz	" "
	.size	anon.strconst, 1
	.type	anon.strconst.1,@object
	.section	.rodata
anon.strconst.1:
	.asciz	"Total: "
	.size	anon.strconst.1, 7
