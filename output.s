	.globl	_global_init
	.p2align	1
	.type	_global_init,@function
_global_init:
%entry.11:
	addi	sp, sp, -48
	mv	t1, ra
	sw	t1, 0(sp)
	mv	t1, s0
	sw	t1, 4(sp)
	addi	s0, sp, 48
	lui	t1, %hi(MAX)
	sw	t1, 8(sp)
	li	t1, 1000000
	sw	t1, 12(sp)
	lw	t2, 8(sp)
	lw	t3, 12(sp)
	sw	t3, %lo(MAX)(t2)
	lui	t1, %hi(tot)
	sw	t1, 16(sp)
	lw	t2, 16(sp)
	sw	zero, %lo(tot)(t2)
	lui	t1, %hi(ans)
	sw	t1, 20(sp)
	lw	t2, 20(sp)
	sw	zero, %lo(ans)(t2)
	lui	t1, %hi(pick)
	sw	t1, 24(sp)
	lw	t2, 24(sp)
	sw	zero, %lo(pick)(t2)
	lui	t1, %hi(fst)
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	sw	zero, %lo(fst)(t2)
	lui	t1, %hi(dis)
	sw	t1, 32(sp)
	lw	t2, 32(sp)
	sw	zero, %lo(dis)(t2)
	lui	t1, %hi(ed)
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	sw	zero, %lo(ed)(t2)
	j	%exit.11
%exit.11:
	lw	t2, 0(sp)
	mv	ra, t2
	lw	t2, 4(sp)
	mv	s0, t2
	addi	sp, sp, 48
	ret
                            #function ends.
	.globl	Edge.Edge
	.p2align	1
	.type	Edge.Edge,@function
Edge.Edge:
%entry.12:
	addi	sp, sp, -16
	mv	t1, ra
	sw	t1, 4(sp)
	mv	t1, s0
	sw	t1, 8(sp)
	addi	s0, sp, 16
	mv	t1, a0
	sw	t1, 0(sp)
	j	%exit.12
%exit.12:
	lw	t2, 4(sp)
	mv	ra, t2
	lw	t2, 8(sp)
	mv	s0, t2
	addi	sp, sp, 16
	ret
                            #function ends.
	.globl	addedge
	.p2align	1
	.type	addedge,@function
addedge:
%entry.13:
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
	mv	t1, a2
	sw	t1, 8(sp)
	lw	t3, 0(sp)
	sw	t3, 20(sp)
	lw	t3, 4(sp)
	sw	t3, 16(sp)
	lw	t3, 8(sp)
	sw	t3, 12(sp)
	lui	t1, %hi(tot)
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	lw	t1, %lo(tot)(t2)
	sw	t1, 32(sp)
	li	t1, 1
	sw	t1, 44(sp)
	lw	t2, 32(sp)
	lw	t3, 44(sp)
	add	t1, t2, t3
	sw	t1, 40(sp)
	lui	t1, %hi(tot)
	sw	t1, 48(sp)
	lw	t2, 48(sp)
	lw	t3, 40(sp)
	sw	t3, %lo(tot)(t2)
	lui	t1, %hi(tot)
	sw	t1, 56(sp)
	lw	t2, 56(sp)
	lw	t1, %lo(tot)(t2)
	sw	t1, 52(sp)
	lui	t1, %hi(ed)
	sw	t1, 64(sp)
	lw	t2, 64(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 60(sp)
	li	t1, 8
	sw	t1, 80(sp)
	lw	t2, 52(sp)
	lw	t3, 80(sp)
	mul	t1, t2, t3
	sw	t1, 76(sp)
	lw	t2, 60(sp)
	lw	t3, 76(sp)
	add	t1, t2, t3
	sw	t1, 72(sp)
	lw	t2, 72(sp)
	mv	t1, t2
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	lw	t1, 0(t2)
	sw	t1, 84(sp)
	li	t1, 16
	sw	t1, 88(sp)
	lw	t2, 88(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	mv	t1, t2
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	mv	a0, t2
	call	Edge.Edge
	lw	t2, 68(sp)
	lw	t3, 96(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(tot)
	sw	t1, 104(sp)
	lw	t2, 104(sp)
	lw	t1, %lo(tot)(t2)
	sw	t1, 100(sp)
	lui	t1, %hi(ed)
	sw	t1, 112(sp)
	lw	t2, 112(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 108(sp)
	li	t1, 8
	sw	t1, 128(sp)
	lw	t2, 100(sp)
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
	lw	t2, 132(sp)
	mv	t1, t2
	sw	t1, 140(sp)
	lw	t2, 140(sp)
	mv	t1, t2
	sw	t1, 136(sp)
	lw	t2, 136(sp)
	lw	t1, 0(t2)
	sw	t1, 144(sp)
	lw	t1, 20(sp)
	sw	t1, 148(sp)
	lw	t2, 136(sp)
	lw	t3, 148(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(tot)
	sw	t1, 156(sp)
	lw	t2, 156(sp)
	lw	t1, %lo(tot)(t2)
	sw	t1, 152(sp)
	lui	t1, %hi(ed)
	sw	t1, 164(sp)
	lw	t2, 164(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 160(sp)
	li	t1, 8
	sw	t1, 180(sp)
	lw	t2, 152(sp)
	lw	t3, 180(sp)
	mul	t1, t2, t3
	sw	t1, 176(sp)
	lw	t2, 160(sp)
	lw	t3, 176(sp)
	add	t1, t2, t3
	sw	t1, 172(sp)
	lw	t2, 172(sp)
	mv	t1, t2
	sw	t1, 168(sp)
	lw	t2, 168(sp)
	lw	t1, 0(t2)
	sw	t1, 184(sp)
	li	t1, 4
	sw	t1, 196(sp)
	lw	t2, 184(sp)
	lw	t3, 196(sp)
	add	t1, t2, t3
	sw	t1, 192(sp)
	lw	t2, 192(sp)
	mv	t1, t2
	sw	t1, 188(sp)
	lw	t2, 188(sp)
	lw	t1, 0(t2)
	sw	t1, 200(sp)
	lw	t1, 16(sp)
	sw	t1, 204(sp)
	lw	t2, 188(sp)
	lw	t3, 204(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(tot)
	sw	t1, 212(sp)
	lw	t2, 212(sp)
	lw	t1, %lo(tot)(t2)
	sw	t1, 208(sp)
	lui	t1, %hi(ed)
	sw	t1, 220(sp)
	lw	t2, 220(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 216(sp)
	li	t1, 8
	sw	t1, 236(sp)
	lw	t2, 208(sp)
	lw	t3, 236(sp)
	mul	t1, t2, t3
	sw	t1, 232(sp)
	lw	t2, 216(sp)
	lw	t3, 232(sp)
	add	t1, t2, t3
	sw	t1, 228(sp)
	lw	t2, 228(sp)
	mv	t1, t2
	sw	t1, 224(sp)
	lw	t2, 224(sp)
	lw	t1, 0(t2)
	sw	t1, 240(sp)
	li	t1, 12
	sw	t1, 252(sp)
	lw	t2, 240(sp)
	lw	t3, 252(sp)
	add	t1, t2, t3
	sw	t1, 248(sp)
	lw	t2, 248(sp)
	mv	t1, t2
	sw	t1, 244(sp)
	lw	t2, 244(sp)
	lw	t1, 0(t2)
	sw	t1, 256(sp)
	lw	t1, 12(sp)
	sw	t1, 260(sp)
	lw	t2, 244(sp)
	lw	t3, 260(sp)
	sw	t3, 0(t2)
	lui	t1, %hi(tot)
	sw	t1, 268(sp)
	lw	t2, 268(sp)
	lw	t1, %lo(tot)(t2)
	sw	t1, 264(sp)
	lui	t1, %hi(ed)
	sw	t1, 276(sp)
	lw	t2, 276(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 272(sp)
	li	t1, 8
	sw	t1, 292(sp)
	lw	t2, 264(sp)
	lw	t3, 292(sp)
	mul	t1, t2, t3
	sw	t1, 288(sp)
	lw	t2, 272(sp)
	lw	t3, 288(sp)
	add	t1, t2, t3
	sw	t1, 284(sp)
	lw	t2, 284(sp)
	mv	t1, t2
	sw	t1, 280(sp)
	lw	t2, 280(sp)
	lw	t1, 0(t2)
	sw	t1, 296(sp)
	li	t1, 8
	sw	t1, 308(sp)
	lw	t2, 296(sp)
	lw	t3, 308(sp)
	add	t1, t2, t3
	sw	t1, 304(sp)
	lw	t2, 304(sp)
	mv	t1, t2
	sw	t1, 300(sp)
	lw	t2, 300(sp)
	lw	t1, 0(t2)
	sw	t1, 312(sp)
	lw	t1, 20(sp)
	sw	t1, 316(sp)
	lui	t1, %hi(fst)
	sw	t1, 324(sp)
	lw	t2, 324(sp)
	lw	t1, %lo(fst)(t2)
	sw	t1, 320(sp)
	li	t1, 4
	sw	t1, 340(sp)
	lw	t2, 316(sp)
	lw	t3, 340(sp)
	mul	t1, t2, t3
	sw	t1, 336(sp)
	lw	t2, 320(sp)
	lw	t3, 336(sp)
	add	t1, t2, t3
	sw	t1, 332(sp)
	lw	t2, 332(sp)
	mv	t1, t2
	sw	t1, 328(sp)
	lw	t2, 328(sp)
	lw	t1, 0(t2)
	sw	t1, 344(sp)
	lw	t2, 300(sp)
	lw	t3, 344(sp)
	sw	t3, 0(t2)
	lw	t1, 20(sp)
	sw	t1, 348(sp)
	lui	t1, %hi(fst)
	sw	t1, 356(sp)
	lw	t2, 356(sp)
	lw	t1, %lo(fst)(t2)
	sw	t1, 352(sp)
	li	t1, 4
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
	lw	t1, 0(t2)
	sw	t1, 376(sp)
	lui	t1, %hi(tot)
	sw	t1, 384(sp)
	lw	t2, 384(sp)
	lw	t1, %lo(tot)(t2)
	sw	t1, 380(sp)
	lw	t2, 360(sp)
	lw	t3, 380(sp)
	sw	t3, 0(t2)
	j	%exit.13
%exit.13:
	lw	t2, 24(sp)
	mv	ra, t2
	lw	t2, 28(sp)
	mv	s0, t2
	addi	sp, sp, 400
	ret
                            #function ends.
	.globl	main
	.p2align	1
	.type	main,@function
main:
%entry.14:
	addi	sp, sp, -1248
	mv	t1, ra
	sw	t1, 40(sp)
	mv	t1, s0
	sw	t1, 44(sp)
	addi	s0, sp, 1248
	call	_global_init
	sw	zero, 36(sp)
	lui	t1, %hi(n)
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 48(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 56(sp)
	lui	t1, %hi(n)
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	lw	t3, 56(sp)
	sw	t3, %lo(n)(t2)
	lui	t1, %hi(m)
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	lw	t1, %lo(m)(t2)
	sw	t1, 64(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 72(sp)
	lui	t1, %hi(m)
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	lw	t3, 72(sp)
	sw	t3, %lo(m)(t2)
	lui	t1, %hi(pick)
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	lw	t1, %lo(pick)(t2)
	sw	t1, 80(sp)
	lui	t1, %hi(n)
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 88(sp)
	li	t1, 1
	sw	t1, 100(sp)
	lw	t2, 88(sp)
	lw	t3, 100(sp)
	add	t1, t2, t3
	sw	t1, 96(sp)
	li	t1, 4
	sw	t1, 108(sp)
	lw	t2, 96(sp)
	lw	t3, 108(sp)
	mul	t1, t2, t3
	sw	t1, 104(sp)
	li	t1, 4
	sw	t1, 116(sp)
	lw	t2, 104(sp)
	lw	t3, 116(sp)
	add	t1, t2, t3
	sw	t1, 112(sp)
	lw	t2, 112(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	mv	t1, t2
	sw	t1, 124(sp)
	lw	t2, 124(sp)
	lw	t3, 96(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 136(sp)
	lw	t2, 124(sp)
	lw	t3, 136(sp)
	add	t1, t2, t3
	sw	t1, 132(sp)
	lw	t2, 132(sp)
	mv	t1, t2
	sw	t1, 128(sp)
	lw	t2, 128(sp)
	mv	t1, t2
	sw	t1, 140(sp)
	lui	t1, %hi(pick)
	sw	t1, 144(sp)
	lw	t2, 144(sp)
	lw	t3, 140(sp)
	sw	t3, %lo(pick)(t2)
	lui	t1, %hi(fst)
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	lw	t1, %lo(fst)(t2)
	sw	t1, 148(sp)
	lui	t1, %hi(n)
	sw	t1, 160(sp)
	lw	t2, 160(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 156(sp)
	li	t1, 1
	sw	t1, 168(sp)
	lw	t2, 156(sp)
	lw	t3, 168(sp)
	add	t1, t2, t3
	sw	t1, 164(sp)
	li	t1, 4
	sw	t1, 176(sp)
	lw	t2, 164(sp)
	lw	t3, 176(sp)
	mul	t1, t2, t3
	sw	t1, 172(sp)
	li	t1, 4
	sw	t1, 184(sp)
	lw	t2, 172(sp)
	lw	t3, 184(sp)
	add	t1, t2, t3
	sw	t1, 180(sp)
	lw	t2, 180(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 188(sp)
	lw	t2, 188(sp)
	mv	t1, t2
	sw	t1, 192(sp)
	lw	t2, 192(sp)
	lw	t3, 164(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 204(sp)
	lw	t2, 192(sp)
	lw	t3, 204(sp)
	add	t1, t2, t3
	sw	t1, 200(sp)
	lw	t2, 200(sp)
	mv	t1, t2
	sw	t1, 196(sp)
	lw	t2, 196(sp)
	mv	t1, t2
	sw	t1, 208(sp)
	lui	t1, %hi(fst)
	sw	t1, 212(sp)
	lw	t2, 212(sp)
	lw	t3, 208(sp)
	sw	t3, %lo(fst)(t2)
	lui	t1, %hi(dis)
	sw	t1, 220(sp)
	lw	t2, 220(sp)
	lw	t1, %lo(dis)(t2)
	sw	t1, 216(sp)
	lui	t1, %hi(n)
	sw	t1, 228(sp)
	lw	t2, 228(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 224(sp)
	li	t1, 1
	sw	t1, 236(sp)
	lw	t2, 224(sp)
	lw	t3, 236(sp)
	add	t1, t2, t3
	sw	t1, 232(sp)
	li	t1, 4
	sw	t1, 244(sp)
	lw	t2, 232(sp)
	lw	t3, 244(sp)
	mul	t1, t2, t3
	sw	t1, 240(sp)
	li	t1, 4
	sw	t1, 252(sp)
	lw	t2, 240(sp)
	lw	t3, 252(sp)
	add	t1, t2, t3
	sw	t1, 248(sp)
	lw	t2, 248(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 256(sp)
	lw	t2, 256(sp)
	mv	t1, t2
	sw	t1, 260(sp)
	lw	t2, 260(sp)
	lw	t3, 232(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 272(sp)
	lw	t2, 260(sp)
	lw	t3, 272(sp)
	add	t1, t2, t3
	sw	t1, 268(sp)
	lw	t2, 268(sp)
	mv	t1, t2
	sw	t1, 264(sp)
	lw	t2, 264(sp)
	mv	t1, t2
	sw	t1, 276(sp)
	lui	t1, %hi(dis)
	sw	t1, 280(sp)
	lw	t2, 280(sp)
	lw	t3, 276(sp)
	sw	t3, %lo(dis)(t2)
	lui	t1, %hi(ed)
	sw	t1, 288(sp)
	lw	t2, 288(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 284(sp)
	lui	t1, %hi(m)
	sw	t1, 296(sp)
	lw	t2, 296(sp)
	lw	t1, %lo(m)(t2)
	sw	t1, 292(sp)
	li	t1, 2
	sw	t1, 304(sp)
	lw	t2, 304(sp)
	lw	t3, 292(sp)
	mul	t1, t2, t3
	sw	t1, 300(sp)
	li	t1, 1
	sw	t1, 312(sp)
	lw	t2, 300(sp)
	lw	t3, 312(sp)
	add	t1, t2, t3
	sw	t1, 308(sp)
	li	t1, 8
	sw	t1, 320(sp)
	lw	t2, 308(sp)
	lw	t3, 320(sp)
	mul	t1, t2, t3
	sw	t1, 316(sp)
	li	t1, 4
	sw	t1, 328(sp)
	lw	t2, 316(sp)
	lw	t3, 328(sp)
	add	t1, t2, t3
	sw	t1, 324(sp)
	lw	t2, 324(sp)
	mv	a0, t2
	call	_bot_malloc
	mv	t1, a0
	sw	t1, 332(sp)
	lw	t2, 332(sp)
	mv	t1, t2
	sw	t1, 336(sp)
	lw	t2, 336(sp)
	lw	t3, 308(sp)
	sw	t3, 0(t2)
	li	t1, 4
	sw	t1, 348(sp)
	lw	t2, 336(sp)
	lw	t3, 348(sp)
	add	t1, t2, t3
	sw	t1, 344(sp)
	lw	t2, 344(sp)
	mv	t1, t2
	sw	t1, 340(sp)
	lw	t2, 340(sp)
	mv	t1, t2
	sw	t1, 352(sp)
	lui	t1, %hi(ed)
	sw	t1, 356(sp)
	lw	t2, 356(sp)
	lw	t3, 352(sp)
	sw	t3, %lo(ed)(t2)
	lw	t1, 32(sp)
	sw	t1, 360(sp)
	sw	zero, 32(sp)
	j	%for.cond
%exit.14:
	lw	t1, 36(sp)
	sw	t1, 364(sp)
	lw	t2, 364(sp)
	mv	a0, t2
	lw	t2, 40(sp)
	mv	ra, t2
	lw	t2, 44(sp)
	mv	s0, t2
	addi	sp, sp, 1248
	ret
%for.cond:
	lw	t1, 32(sp)
	sw	t1, 368(sp)
	lui	t1, %hi(n)
	sw	t1, 376(sp)
	lw	t2, 376(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 372(sp)
	lw	t2, 372(sp)
	lw	t3, 368(sp)
	bge	t2,t3,%for.body
	j	%for.exit
%for.incr:
	lw	t1, 32(sp)
	sw	t1, 380(sp)
	li	t1, 1
	sw	t1, 388(sp)
	lw	t2, 380(sp)
	lw	t3, 388(sp)
	add	t1, t2, t3
	sw	t1, 384(sp)
	lw	t3, 384(sp)
	sw	t3, 32(sp)
	j	%for.cond
%for.body:
	lw	t1, 32(sp)
	sw	t1, 392(sp)
	lui	t1, %hi(pick)
	sw	t1, 400(sp)
	lw	t2, 400(sp)
	lw	t1, %lo(pick)(t2)
	sw	t1, 396(sp)
	li	t1, 4
	sw	t1, 416(sp)
	lw	t2, 392(sp)
	lw	t3, 416(sp)
	mul	t1, t2, t3
	sw	t1, 412(sp)
	lw	t2, 396(sp)
	lw	t3, 412(sp)
	add	t1, t2, t3
	sw	t1, 408(sp)
	lw	t2, 408(sp)
	mv	t1, t2
	sw	t1, 404(sp)
	lw	t2, 404(sp)
	lw	t1, 0(t2)
	sw	t1, 420(sp)
	lw	t2, 404(sp)
	sw	zero, 0(t2)
	lw	t1, 32(sp)
	sw	t1, 424(sp)
	lui	t1, %hi(fst)
	sw	t1, 432(sp)
	lw	t2, 432(sp)
	lw	t1, %lo(fst)(t2)
	sw	t1, 428(sp)
	li	t1, 4
	sw	t1, 448(sp)
	lw	t2, 424(sp)
	lw	t3, 448(sp)
	mul	t1, t2, t3
	sw	t1, 444(sp)
	lw	t2, 428(sp)
	lw	t3, 444(sp)
	add	t1, t2, t3
	sw	t1, 440(sp)
	lw	t2, 440(sp)
	mv	t1, t2
	sw	t1, 436(sp)
	lw	t2, 436(sp)
	lw	t1, 0(t2)
	sw	t1, 452(sp)
	lw	t2, 436(sp)
	sw	zero, 0(t2)
	lw	t1, 32(sp)
	sw	t1, 456(sp)
	lui	t1, %hi(dis)
	sw	t1, 464(sp)
	lw	t2, 464(sp)
	lw	t1, %lo(dis)(t2)
	sw	t1, 460(sp)
	li	t1, 4
	sw	t1, 480(sp)
	lw	t2, 456(sp)
	lw	t3, 480(sp)
	mul	t1, t2, t3
	sw	t1, 476(sp)
	lw	t2, 460(sp)
	lw	t3, 476(sp)
	add	t1, t2, t3
	sw	t1, 472(sp)
	lw	t2, 472(sp)
	mv	t1, t2
	sw	t1, 468(sp)
	lw	t2, 468(sp)
	lw	t1, 0(t2)
	sw	t1, 484(sp)
	lui	t1, %hi(MAX)
	sw	t1, 492(sp)
	lw	t2, 492(sp)
	lw	t1, %lo(MAX)(t2)
	sw	t1, 488(sp)
	lw	t2, 468(sp)
	lw	t3, 488(sp)
	sw	t3, 0(t2)
	j	%for.incr
%for.exit:
	lw	t1, 32(sp)
	sw	t1, 496(sp)
	li	t1, 1
	sw	t1, 500(sp)
	lw	t3, 500(sp)
	sw	t3, 32(sp)
	j	%for.cond.1
%for.cond.1:
	lw	t1, 32(sp)
	sw	t1, 504(sp)
	lui	t1, %hi(m)
	sw	t1, 512(sp)
	lw	t2, 512(sp)
	lw	t1, %lo(m)(t2)
	sw	t1, 508(sp)
	lw	t2, 508(sp)
	lw	t3, 504(sp)
	bge	t2,t3,%for.body.1
	j	%for.exit.1
%for.incr.1:
	lw	t1, 32(sp)
	sw	t1, 516(sp)
	li	t1, 1
	sw	t1, 524(sp)
	lw	t2, 516(sp)
	lw	t3, 524(sp)
	add	t1, t2, t3
	sw	t1, 520(sp)
	lw	t3, 520(sp)
	sw	t3, 32(sp)
	j	%for.cond.1
%for.body.1:
	lw	t1, 28(sp)
	sw	t1, 528(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 532(sp)
	lw	t3, 532(sp)
	sw	t3, 28(sp)
	lw	t1, 24(sp)
	sw	t1, 536(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 540(sp)
	lw	t3, 540(sp)
	sw	t3, 24(sp)
	lw	t1, 20(sp)
	sw	t1, 544(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 548(sp)
	lw	t3, 548(sp)
	sw	t3, 20(sp)
	lw	t1, 28(sp)
	sw	t1, 552(sp)
	lw	t1, 24(sp)
	sw	t1, 556(sp)
	lw	t1, 20(sp)
	sw	t1, 560(sp)
	lw	t2, 552(sp)
	mv	a0, t2
	lw	t2, 556(sp)
	mv	a1, t2
	lw	t2, 560(sp)
	mv	a2, t2
	call	addedge
	lw	t1, 24(sp)
	sw	t1, 564(sp)
	lw	t1, 28(sp)
	sw	t1, 568(sp)
	lw	t1, 20(sp)
	sw	t1, 572(sp)
	lw	t2, 564(sp)
	mv	a0, t2
	lw	t2, 568(sp)
	mv	a1, t2
	lw	t2, 572(sp)
	mv	a2, t2
	call	addedge
	j	%for.incr.1
%for.exit.1:
	lw	t1, 28(sp)
	sw	t1, 576(sp)
	li	t1, 1
	sw	t1, 580(sp)
	lw	t3, 580(sp)
	sw	t3, 28(sp)
	lw	t1, 32(sp)
	sw	t1, 584(sp)
	li	t1, 1
	sw	t1, 588(sp)
	lw	t3, 588(sp)
	sw	t3, 32(sp)
	j	%for.cond.2
%for.cond.2:
	lw	t1, 32(sp)
	sw	t1, 592(sp)
	lui	t1, %hi(n)
	sw	t1, 600(sp)
	lw	t2, 600(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 596(sp)
	li	t1, 1
	sw	t1, 608(sp)
	lw	t2, 596(sp)
	lw	t3, 608(sp)
	sub	t1, t2, t3
	sw	t1, 604(sp)
	lw	t2, 604(sp)
	lw	t3, 592(sp)
	bge	t2,t3,%for.body.2
	j	%for.exit.2
%for.incr.2:
	lw	t1, 32(sp)
	sw	t1, 612(sp)
	li	t1, 1
	sw	t1, 620(sp)
	lw	t2, 612(sp)
	lw	t3, 620(sp)
	add	t1, t2, t3
	sw	t1, 616(sp)
	lw	t3, 616(sp)
	sw	t3, 32(sp)
	j	%for.cond.2
%for.body.2:
	lw	t1, 28(sp)
	sw	t1, 624(sp)
	lui	t1, %hi(pick)
	sw	t1, 632(sp)
	lw	t2, 632(sp)
	lw	t1, %lo(pick)(t2)
	sw	t1, 628(sp)
	li	t1, 4
	sw	t1, 648(sp)
	lw	t2, 624(sp)
	lw	t3, 648(sp)
	mul	t1, t2, t3
	sw	t1, 644(sp)
	lw	t2, 628(sp)
	lw	t3, 644(sp)
	add	t1, t2, t3
	sw	t1, 640(sp)
	lw	t2, 640(sp)
	mv	t1, t2
	sw	t1, 636(sp)
	lw	t2, 636(sp)
	lw	t1, 0(t2)
	sw	t1, 652(sp)
	li	t1, 1
	sw	t1, 656(sp)
	lw	t2, 636(sp)
	lw	t3, 656(sp)
	sw	t3, 0(t2)
	lw	t1, 16(sp)
	sw	t1, 660(sp)
	lw	t1, 28(sp)
	sw	t1, 664(sp)
	lui	t1, %hi(fst)
	sw	t1, 672(sp)
	lw	t2, 672(sp)
	lw	t1, %lo(fst)(t2)
	sw	t1, 668(sp)
	li	t1, 4
	sw	t1, 688(sp)
	lw	t2, 664(sp)
	lw	t3, 688(sp)
	mul	t1, t2, t3
	sw	t1, 684(sp)
	lw	t2, 668(sp)
	lw	t3, 684(sp)
	add	t1, t2, t3
	sw	t1, 680(sp)
	lw	t2, 680(sp)
	mv	t1, t2
	sw	t1, 676(sp)
	lw	t2, 676(sp)
	lw	t1, 0(t2)
	sw	t1, 692(sp)
	lw	t3, 692(sp)
	sw	t3, 16(sp)
	j	%for.cond.3
%for.exit.2:
	lui	t1, %hi(ans)
	sw	t1, 700(sp)
	lw	t2, 700(sp)
	lw	t1, %lo(ans)(t2)
	sw	t1, 696(sp)
	lw	t2, 696(sp)
	mv	a0, t2
	call	printInt
	sw	zero, 36(sp)
	j	%exit.14
%for.cond.3:
	lw	t1, 16(sp)
	sw	t1, 704(sp)
	lw	t2, 704(sp)
	bne	t2,zero,%for.body.3
	j	%for.exit.3
%for.incr.3:
	lw	t1, 16(sp)
	sw	t1, 708(sp)
	lw	t1, 16(sp)
	sw	t1, 712(sp)
	lui	t1, %hi(ed)
	sw	t1, 720(sp)
	lw	t2, 720(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 716(sp)
	li	t1, 8
	sw	t1, 736(sp)
	lw	t2, 712(sp)
	lw	t3, 736(sp)
	mul	t1, t2, t3
	sw	t1, 732(sp)
	lw	t2, 716(sp)
	lw	t3, 732(sp)
	add	t1, t2, t3
	sw	t1, 728(sp)
	lw	t2, 728(sp)
	mv	t1, t2
	sw	t1, 724(sp)
	lw	t2, 724(sp)
	lw	t1, 0(t2)
	sw	t1, 740(sp)
	li	t1, 8
	sw	t1, 752(sp)
	lw	t2, 740(sp)
	lw	t3, 752(sp)
	add	t1, t2, t3
	sw	t1, 748(sp)
	lw	t2, 748(sp)
	mv	t1, t2
	sw	t1, 744(sp)
	lw	t2, 744(sp)
	lw	t1, 0(t2)
	sw	t1, 756(sp)
	lw	t3, 756(sp)
	sw	t3, 16(sp)
	j	%for.cond.3
%for.body.3:
	lw	t1, 16(sp)
	sw	t1, 760(sp)
	lui	t1, %hi(ed)
	sw	t1, 768(sp)
	lw	t2, 768(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 764(sp)
	li	t1, 8
	sw	t1, 784(sp)
	lw	t2, 760(sp)
	lw	t3, 784(sp)
	mul	t1, t2, t3
	sw	t1, 780(sp)
	lw	t2, 764(sp)
	lw	t3, 780(sp)
	add	t1, t2, t3
	sw	t1, 776(sp)
	lw	t2, 776(sp)
	mv	t1, t2
	sw	t1, 772(sp)
	lw	t2, 772(sp)
	lw	t1, 0(t2)
	sw	t1, 788(sp)
	li	t1, 4
	sw	t1, 800(sp)
	lw	t2, 788(sp)
	lw	t3, 800(sp)
	add	t1, t2, t3
	sw	t1, 796(sp)
	lw	t2, 796(sp)
	mv	t1, t2
	sw	t1, 792(sp)
	lw	t2, 792(sp)
	lw	t1, 0(t2)
	sw	t1, 804(sp)
	lw	t3, 804(sp)
	sw	t3, 12(sp)
	lw	t1, 12(sp)
	sw	t1, 808(sp)
	lui	t1, %hi(pick)
	sw	t1, 816(sp)
	lw	t2, 816(sp)
	lw	t1, %lo(pick)(t2)
	sw	t1, 812(sp)
	li	t1, 4
	sw	t1, 832(sp)
	lw	t2, 808(sp)
	lw	t3, 832(sp)
	mul	t1, t2, t3
	sw	t1, 828(sp)
	lw	t2, 812(sp)
	lw	t3, 828(sp)
	add	t1, t2, t3
	sw	t1, 824(sp)
	lw	t2, 824(sp)
	mv	t1, t2
	sw	t1, 820(sp)
	lw	t2, 820(sp)
	lw	t1, 0(t2)
	sw	t1, 836(sp)
	lw	t2, 836(sp)
	xor	t1, t2, zero
	sw	t1, 840(sp)
	lw	t2, 840(sp)
	seqz	t1, t2
	sb	t1, 844(sp)
	lb	t2, 844(sp)
	bne	t2,zero,%logic.uncut
	j	%logic.exit
%for.exit.3:
	lw	t1, 28(sp)
	sw	t1, 848(sp)
	sw	zero, 28(sp)
	lw	t1, 16(sp)
	sw	t1, 852(sp)
	li	t1, 1
	sw	t1, 856(sp)
	lw	t3, 856(sp)
	sw	t3, 16(sp)
	j	%for.cond.4
%if.true:
	lw	t1, 12(sp)
	sw	t1, 860(sp)
	lui	t1, %hi(dis)
	sw	t1, 868(sp)
	lw	t2, 868(sp)
	lw	t1, %lo(dis)(t2)
	sw	t1, 864(sp)
	li	t1, 4
	sw	t1, 884(sp)
	lw	t2, 860(sp)
	lw	t3, 884(sp)
	mul	t1, t2, t3
	sw	t1, 880(sp)
	lw	t2, 864(sp)
	lw	t3, 880(sp)
	add	t1, t2, t3
	sw	t1, 876(sp)
	lw	t2, 876(sp)
	mv	t1, t2
	sw	t1, 872(sp)
	lw	t2, 872(sp)
	lw	t1, 0(t2)
	sw	t1, 888(sp)
	lw	t1, 16(sp)
	sw	t1, 892(sp)
	lui	t1, %hi(ed)
	sw	t1, 900(sp)
	lw	t2, 900(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 896(sp)
	li	t1, 8
	sw	t1, 916(sp)
	lw	t2, 892(sp)
	lw	t3, 916(sp)
	mul	t1, t2, t3
	sw	t1, 912(sp)
	lw	t2, 896(sp)
	lw	t3, 912(sp)
	add	t1, t2, t3
	sw	t1, 908(sp)
	lw	t2, 908(sp)
	mv	t1, t2
	sw	t1, 904(sp)
	lw	t2, 904(sp)
	lw	t1, 0(t2)
	sw	t1, 920(sp)
	li	t1, 12
	sw	t1, 932(sp)
	lw	t2, 920(sp)
	lw	t3, 932(sp)
	add	t1, t2, t3
	sw	t1, 928(sp)
	lw	t2, 928(sp)
	mv	t1, t2
	sw	t1, 924(sp)
	lw	t2, 924(sp)
	lw	t1, 0(t2)
	sw	t1, 936(sp)
	lw	t2, 872(sp)
	lw	t3, 936(sp)
	sw	t3, 0(t2)
	j	%if.exit
%if.false:
	j	%if.exit
%if.exit:
	j	%for.incr.3
%logic.uncut:
	lw	t1, 16(sp)
	sw	t1, 940(sp)
	lui	t1, %hi(ed)
	sw	t1, 948(sp)
	lw	t2, 948(sp)
	lw	t1, %lo(ed)(t2)
	sw	t1, 944(sp)
	li	t1, 8
	sw	t1, 964(sp)
	lw	t2, 940(sp)
	lw	t3, 964(sp)
	mul	t1, t2, t3
	sw	t1, 960(sp)
	lw	t2, 944(sp)
	lw	t3, 960(sp)
	add	t1, t2, t3
	sw	t1, 956(sp)
	lw	t2, 956(sp)
	mv	t1, t2
	sw	t1, 952(sp)
	lw	t2, 952(sp)
	lw	t1, 0(t2)
	sw	t1, 968(sp)
	li	t1, 12
	sw	t1, 980(sp)
	lw	t2, 968(sp)
	lw	t3, 980(sp)
	add	t1, t2, t3
	sw	t1, 976(sp)
	lw	t2, 976(sp)
	mv	t1, t2
	sw	t1, 972(sp)
	lw	t2, 972(sp)
	lw	t1, 0(t2)
	sw	t1, 984(sp)
	lw	t1, 12(sp)
	sw	t1, 988(sp)
	lui	t1, %hi(dis)
	sw	t1, 996(sp)
	lw	t2, 996(sp)
	lw	t1, %lo(dis)(t2)
	sw	t1, 992(sp)
	li	t1, 4
	sw	t1, 1012(sp)
	lw	t2, 988(sp)
	lw	t3, 1012(sp)
	mul	t1, t2, t3
	sw	t1, 1008(sp)
	lw	t2, 992(sp)
	lw	t3, 1008(sp)
	add	t1, t2, t3
	sw	t1, 1004(sp)
	lw	t2, 1004(sp)
	mv	t1, t2
	sw	t1, 1000(sp)
	lw	t2, 1000(sp)
	lw	t1, 0(t2)
	sw	t1, 1016(sp)
	lw	t2, 984(sp)
	lw	t3, 1016(sp)
	slt	t1, t2, t3
	sb	t1, 1020(sp)
	j	%logic.exit
%logic.exit:
	lb	t2, 1024(sp)
	bne	t2,zero,%if.true
	j	%if.false
%for.cond.4:
	lw	t1, 16(sp)
	sw	t1, 1028(sp)
	lui	t1, %hi(n)
	sw	t1, 1036(sp)
	lw	t2, 1036(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 1032(sp)
	lw	t2, 1032(sp)
	lw	t3, 1028(sp)
	bge	t2,t3,%for.body.4
	j	%for.exit.4
%for.incr.4:
	lw	t1, 16(sp)
	sw	t1, 1040(sp)
	li	t1, 1
	sw	t1, 1048(sp)
	lw	t2, 1040(sp)
	lw	t3, 1048(sp)
	add	t1, t2, t3
	sw	t1, 1044(sp)
	lw	t3, 1044(sp)
	sw	t3, 16(sp)
	j	%for.cond.4
%for.body.4:
	lw	t1, 16(sp)
	sw	t1, 1052(sp)
	lui	t1, %hi(pick)
	sw	t1, 1060(sp)
	lw	t2, 1060(sp)
	lw	t1, %lo(pick)(t2)
	sw	t1, 1056(sp)
	li	t1, 4
	sw	t1, 1076(sp)
	lw	t2, 1052(sp)
	lw	t3, 1076(sp)
	mul	t1, t2, t3
	sw	t1, 1072(sp)
	lw	t2, 1056(sp)
	lw	t3, 1072(sp)
	add	t1, t2, t3
	sw	t1, 1068(sp)
	lw	t2, 1068(sp)
	mv	t1, t2
	sw	t1, 1064(sp)
	lw	t2, 1064(sp)
	lw	t1, 0(t2)
	sw	t1, 1080(sp)
	lw	t2, 1080(sp)
	xor	t1, t2, zero
	sw	t1, 1084(sp)
	lw	t2, 1084(sp)
	seqz	t1, t2
	sb	t1, 1088(sp)
	lb	t2, 1088(sp)
	bne	t2,zero,%logic.uncut.1
	j	%logic.exit.1
%for.exit.4:
	lw	t1, 28(sp)
	sw	t1, 1092(sp)
	lw	t2, 1092(sp)
	beq	t2,zero,%if.true.2
	j	%if.false.2
%if.true.1:
	lw	t1, 28(sp)
	sw	t1, 1096(sp)
	lw	t1, 16(sp)
	sw	t1, 1100(sp)
	lw	t3, 1100(sp)
	sw	t3, 28(sp)
	j	%if.exit.1
%if.false.1:
	j	%if.exit.1
%if.exit.1:
	j	%for.incr.4
%logic.uncut.1:
	lw	t1, 16(sp)
	sw	t1, 1104(sp)
	lui	t1, %hi(dis)
	sw	t1, 1112(sp)
	lw	t2, 1112(sp)
	lw	t1, %lo(dis)(t2)
	sw	t1, 1108(sp)
	li	t1, 4
	sw	t1, 1128(sp)
	lw	t2, 1104(sp)
	lw	t3, 1128(sp)
	mul	t1, t2, t3
	sw	t1, 1124(sp)
	lw	t2, 1108(sp)
	lw	t3, 1124(sp)
	add	t1, t2, t3
	sw	t1, 1120(sp)
	lw	t2, 1120(sp)
	mv	t1, t2
	sw	t1, 1116(sp)
	lw	t2, 1116(sp)
	lw	t1, 0(t2)
	sw	t1, 1132(sp)
	lw	t1, 28(sp)
	sw	t1, 1136(sp)
	lui	t1, %hi(dis)
	sw	t1, 1144(sp)
	lw	t2, 1144(sp)
	lw	t1, %lo(dis)(t2)
	sw	t1, 1140(sp)
	li	t1, 4
	sw	t1, 1160(sp)
	lw	t2, 1136(sp)
	lw	t3, 1160(sp)
	mul	t1, t2, t3
	sw	t1, 1156(sp)
	lw	t2, 1140(sp)
	lw	t3, 1156(sp)
	add	t1, t2, t3
	sw	t1, 1152(sp)
	lw	t2, 1152(sp)
	mv	t1, t2
	sw	t1, 1148(sp)
	lw	t2, 1148(sp)
	lw	t1, 0(t2)
	sw	t1, 1164(sp)
	lw	t2, 1132(sp)
	lw	t3, 1164(sp)
	slt	t1, t2, t3
	sb	t1, 1168(sp)
	j	%logic.exit.1
%logic.exit.1:
	lb	t2, 1172(sp)
	bne	t2,zero,%if.true.1
	j	%if.false.1
%if.true.2:
	li	t1, 1
	sw	t1, 1180(sp)
	lw	t3, 1180(sp)
	sub	t1, zero, t3
	sw	t1, 1176(sp)
	lw	t2, 1176(sp)
	mv	a0, t2
	call	printInt
	sw	zero, 36(sp)
	j	%exit.14
%if.false.2:
	j	%if.exit.2
%if.exit.2:
	lui	t1, %hi(ans)
	sw	t1, 1188(sp)
	lw	t2, 1188(sp)
	lw	t1, %lo(ans)(t2)
	sw	t1, 1184(sp)
	lui	t1, %hi(ans)
	sw	t1, 1196(sp)
	lw	t2, 1196(sp)
	lw	t1, %lo(ans)(t2)
	sw	t1, 1192(sp)
	lw	t1, 28(sp)
	sw	t1, 1200(sp)
	lui	t1, %hi(dis)
	sw	t1, 1208(sp)
	lw	t2, 1208(sp)
	lw	t1, %lo(dis)(t2)
	sw	t1, 1204(sp)
	li	t1, 4
	sw	t1, 1224(sp)
	lw	t2, 1200(sp)
	lw	t3, 1224(sp)
	mul	t1, t2, t3
	sw	t1, 1220(sp)
	lw	t2, 1204(sp)
	lw	t3, 1220(sp)
	add	t1, t2, t3
	sw	t1, 1216(sp)
	lw	t2, 1216(sp)
	mv	t1, t2
	sw	t1, 1212(sp)
	lw	t2, 1212(sp)
	lw	t1, 0(t2)
	sw	t1, 1228(sp)
	lw	t2, 1192(sp)
	lw	t3, 1228(sp)
	add	t1, t2, t3
	sw	t1, 1232(sp)
	lui	t1, %hi(ans)
	sw	t1, 1236(sp)
	lw	t2, 1236(sp)
	lw	t3, 1232(sp)
	sw	t3, %lo(ans)(t2)
	j	%for.incr.2
                            #function ends.
	.type	MAX,@object
	.section	.bss
	.globl	MAX
MAX:
	.word	0
	.size	MAX, 4
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
	.type	tot,@object
	.section	.bss
	.globl	tot
tot:
	.word	0
	.size	tot, 4
	.type	ans,@object
	.section	.bss
	.globl	ans
ans:
	.word	0
	.size	ans, 4
	.type	pick,@object
	.section	.bss
	.globl	pick
pick:
	.word	0
	.size	pick, 4
	.type	fst,@object
	.section	.bss
	.globl	fst
fst:
	.word	0
	.size	fst, 4
	.type	dis,@object
	.section	.bss
	.globl	dis
dis:
	.word	0
	.size	dis, 4
	.type	ed,@object
	.section	.bss
	.globl	ed
ed:
	.word	0
	.size	ed, 4
