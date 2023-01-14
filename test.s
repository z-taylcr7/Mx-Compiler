	.text
	.globl	main
	.p2align	1
	.type	main,@function
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
	.globl	main
	.p2align	1
	.type	main,@function
main:
%entry.12:
	addi	sp, sp, -320
	mv	t1, ra
	sw	t1, 8(sp)
	mv	t1, s0
	sw	t1, 12(sp)
	addi	s0, sp, 320
	call	_global_init
	sw	zero, 4(sp)
	lui	t1, %hi(n)
	sw	t1, 20(sp)
	lw	t2, 20(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 16(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 24(sp)
	lui	t1, %hi(n)
	sw	t1, 28(sp)
	lw	t2, 28(sp)
	lw	t3, 24(sp)
	sw	t3, %lo(n)(t2)
	lui	t1, %hi(p)
	sw	t1, 36(sp)
	lw	t2, 36(sp)
	lw	t1, %lo(p)(t2)
	sw	t1, 32(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 40(sp)
	lui	t1, %hi(p)
	sw	t1, 44(sp)
	lw	t2, 44(sp)
	lw	t3, 40(sp)
	sw	t3, %lo(p)(t2)
	lui	t1, %hi(k)
	sw	t1, 52(sp)
	lw	t2, 52(sp)
	lw	t1, %lo(k)(t2)
	sw	t1, 48(sp)
	call	getInt
	mv	t1, a0
	sw	t1, 56(sp)
	lui	t1, %hi(k)
	sw	t1, 60(sp)
	lw	t2, 60(sp)
	lw	t3, 56(sp)
	sw	t3, %lo(k)(t2)
	lui	t1, %hi(p)
	sw	t1, 68(sp)
	lw	t2, 68(sp)
	lw	t1, %lo(p)(t2)
	sw	t1, 64(sp)
	lui	t1, %hi(k)
	sw	t1, 76(sp)
	lw	t2, 76(sp)
	lw	t1, %lo(k)(t2)
	sw	t1, 72(sp)
	lw	t2, 64(sp)
	lw	t3, 72(sp)
	sub	t1, t2, t3
	sw	t1, 80(sp)
	li	t1, 1
	sw	t1, 84(sp)
	lw	t2, 84(sp)
	lw	t3, 80(sp)
	blt	t2,t3,%if.true
	j	%if.false
%exit.12:
	lw	t1, 4(sp)
	sw	t1, 88(sp)
	lw	t2, 88(sp)
	mv	a0, t2
	lw	t2, 8(sp)
	mv	ra, t2
	lw	t2, 12(sp)
	mv	s0, t2
	addi	sp, sp, 320
	ret
%if.true:
	la	t1, anonym.strconst
	sw	t1, 96(sp)
	lw	t2, 96(sp)
	mv	t1, t2
	sw	t1, 92(sp)
	lw	t2, 92(sp)
	mv	a0, t2
	call	print
	j	%if.exit
%if.false:
	j	%if.exit
%if.exit:
	lui	t1, %hi(i)
	sw	t1, 104(sp)
	lw	t2, 104(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 100(sp)
	lui	t1, %hi(p)
	sw	t1, 112(sp)
	lw	t2, 112(sp)
	lw	t1, %lo(p)(t2)
	sw	t1, 108(sp)
	lui	t1, %hi(k)
	sw	t1, 120(sp)
	lw	t2, 120(sp)
	lw	t1, %lo(k)(t2)
	sw	t1, 116(sp)
	lw	t2, 108(sp)
	lw	t3, 116(sp)
	sub	t1, t2, t3
	sw	t1, 124(sp)
	lui	t1, %hi(i)
	sw	t1, 128(sp)
	lw	t2, 128(sp)
	lw	t3, 124(sp)
	sw	t3, %lo(i)(t2)
	j	%for.cond
%for.cond:
	lui	t1, %hi(i)
	sw	t1, 136(sp)
	lw	t2, 136(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 132(sp)
	lui	t1, %hi(p)
	sw	t1, 144(sp)
	lw	t2, 144(sp)
	lw	t1, %lo(p)(t2)
	sw	t1, 140(sp)
	lui	t1, %hi(k)
	sw	t1, 152(sp)
	lw	t2, 152(sp)
	lw	t1, %lo(k)(t2)
	sw	t1, 148(sp)
	lw	t2, 140(sp)
	lw	t3, 148(sp)
	add	t1, t2, t3
	sw	t1, 156(sp)
	lw	t2, 156(sp)
	lw	t3, 132(sp)
	bge	t2,t3,%for.body
	j	%for.exit
%for.incr:
	lui	t1, %hi(i)
	sw	t1, 164(sp)
	lw	t2, 164(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 160(sp)
	li	t1, 1
	sw	t1, 172(sp)
	lw	t2, 160(sp)
	lw	t3, 172(sp)
	add	t1, t2, t3
	sw	t1, 168(sp)
	lui	t1, %hi(i)
	sw	t1, 176(sp)
	lw	t2, 176(sp)
	lw	t3, 168(sp)
	sw	t3, %lo(i)(t2)
	j	%for.cond
%for.body:
	lui	t1, %hi(i)
	sw	t1, 184(sp)
	lw	t2, 184(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 180(sp)
	li	t1, 1
	sw	t1, 192(sp)
	lw	t2, 180(sp)
	lw	t3, 192(sp)
	slt	t1, t2, t3
	sb	t1, 188(sp)
	lb	t2, 188(sp)
	xori	t1, t2, 1
	sb	t1, 188(sp)
	lui	t1, %hi(i)
	sw	t1, 200(sp)
	lw	t2, 200(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 196(sp)
	lui	t1, %hi(n)
	sw	t1, 208(sp)
	lw	t2, 208(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 204(sp)
	lw	t2, 204(sp)
	lw	t3, 196(sp)
	slt	t1, t2, t3
	sb	t1, 212(sp)
	lb	t2, 212(sp)
	xori	t1, t2, 1
	sb	t1, 212(sp)
	lb	t2, 188(sp)
	lb	t3, 212(sp)
	and	t1, t2, t3
	sb	t1, 216(sp)
	lb	t2, 216(sp)
	bne	t2,zero,%if.true.1
	j	%if.false.1
%for.exit:
	lui	t1, %hi(p)
	sw	t1, 224(sp)
	lw	t2, 224(sp)
	lw	t1, %lo(p)(t2)
	sw	t1, 220(sp)
	lui	t1, %hi(k)
	sw	t1, 232(sp)
	lw	t2, 232(sp)
	lw	t1, %lo(k)(t2)
	sw	t1, 228(sp)
	lw	t2, 220(sp)
	lw	t3, 228(sp)
	add	t1, t2, t3
	sw	t1, 236(sp)
	lui	t1, %hi(n)
	sw	t1, 244(sp)
	lw	t2, 244(sp)
	lw	t1, %lo(n)(t2)
	sw	t1, 240(sp)
	lw	t2, 236(sp)
	lw	t3, 240(sp)
	blt	t2,t3,%if.true.3
	j	%if.false.3
%if.true.1:
	lui	t1, %hi(i)
	sw	t1, 252(sp)
	lw	t2, 252(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 248(sp)
	lui	t1, %hi(p)
	sw	t1, 260(sp)
	lw	t2, 260(sp)
	lw	t1, %lo(p)(t2)
	sw	t1, 256(sp)
	lw	t2, 248(sp)
	lw	t3, 256(sp)
	beq	t2,t3,%if.true.2
	j	%if.false.2
%if.false.1:
	j	%if.exit.1
%if.exit.1:
	j	%for.incr
%if.true.2:
	la	t1, anonym.strconst.2
	sw	t1, 268(sp)
	lw	t2, 268(sp)
	mv	t1, t2
	sw	t1, 264(sp)
	lw	t2, 264(sp)
	mv	a0, t2
	call	print
	lui	t1, %hi(i)
	sw	t1, 276(sp)
	lw	t2, 276(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 272(sp)
	lw	t2, 272(sp)
	mv	a0, t2
	call	toString
	mv	t1, a0
	sw	t1, 280(sp)
	lw	t2, 280(sp)
	mv	a0, t2
	call	print
	la	t1, anonym.strconst.3
	sw	t1, 288(sp)
	lw	t2, 288(sp)
	mv	t1, t2
	sw	t1, 284(sp)
	lw	t2, 284(sp)
	mv	a0, t2
	call	print
	j	%if.exit.2
%if.false.2:
	lui	t1, %hi(i)
	sw	t1, 296(sp)
	lw	t2, 296(sp)
	lw	t1, %lo(i)(t2)
	sw	t1, 292(sp)
	lw	t2, 292(sp)
	mv	a0, t2
	call	printInt
	la	t1, anonym.strconst.1
	sw	t1, 304(sp)
	lw	t2, 304(sp)
	mv	t1, t2
	sw	t1, 300(sp)
	lw	t2, 300(sp)
	mv	a0, t2
	call	print
	j	%if.exit.2
%if.exit.2:
	j	%if.exit.1
%if.true.3:
	la	t1, anonym.strconst.4
	sw	t1, 312(sp)
	lw	t2, 312(sp)
	mv	t1, t2
	sw	t1, 308(sp)
	lw	t2, 308(sp)
	mv	a0, t2
	call	print
	j	%if.exit.3
%if.false.3:
	j	%if.exit.3
%if.exit.3:
	sw	zero, 4(sp)
	j	%exit.12
                            #function ends.
	.type	n,@object
	.section	.bss
	.globl	n
n:
	.word	0
	.size	n, 4
	.type	p,@object
	.section	.bss
	.globl	p
p:
	.word	0
	.size	p, 4
	.type	k,@object
	.section	.bss
	.globl	k
k:
	.word	0
	.size	k, 4
	.type	i,@object
	.section	.bss
	.globl	i
i:
	.word	0
	.size	i, 4
	.type	anonym.strconst,@object
	.section	.rodata
anonym.strconst:
	.asciz	"<< "
	.size	anonym.strconst, 3
	.type	anonym.strconst.1,@object
	.section	.rodata
anonym.strconst.1:
	.asciz	" "
	.size	anonym.strconst.1, 1
	.type	anonym.strconst.2,@object
	.section	.rodata
anonym.strconst.2:
	.asciz	"("
	.size	anonym.strconst.2, 1
	.type	anonym.strconst.3,@object
	.section	.rodata
anonym.strconst.3:
	.asciz	") "
	.size	anonym.strconst.3, 2
	.type	anonym.strconst.4,@object
	.section	.rodata
anonym.strconst.4:
	.asciz	">> "
	.size	anonym.strconst.4, 3
