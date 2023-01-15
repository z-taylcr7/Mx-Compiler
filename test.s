# fileName: test	 compiled by @Masterball.
	.text
	.globl	main
	.p2align	1
	.type	main,@function
main:
entry.12:
	addi	sp, sp, -16
	sw	s0, 8(sp)
	sw	s1, 4(sp)
	sw	s2, 0(sp)
	sw	ra, 12(sp)
	la	t0, anon.strconst
	mv	s0, t0
	la	t0, anon.strconst.1
	mv	s1, t0
	la	t0, anon.strconst.2
	mv	s2, t0
	mv	a0, s2
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	call	print
	mv	a0, s2
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	call	print
	mv	a0, s1
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	call	print
	mv	a0, s1
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	call	print
	mv	a0, s1
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	call	print
	mv	a0, s0
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	call	print
	mv	a0, s1
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	call	print
	mv	a0, s0
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	call	print
	mv	a0, s2
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s0
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	call	print
	mv	a0, s0
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	mv	a1, s1
	call	_bot_str_cat
	mv	a1, s2
	call	_bot_str_cat
	call	print
	li	a0, 0
	lw	s0, 8(sp)
	lw	s1, 4(sp)
	lw	s2, 0(sp)
	lw	ra, 12(sp)
	addi	sp, sp, 16
	ret
	.size	main, .-main
                                        # -- End function
	.type	anon.strconst,@object
	.section	.rodata
anon.strconst:
	.asciz	"\"\nbda\\\"\ndbd\\c\"\\\"c\\c\""
	.size	anon.strconst, 20

	.type	anon.strconst.1,@object
	.section	.rodata
anon.strconst.1:
	.asciz	"\\ab\nac\"\"add\n\"\nac\ndb\""
	.size	anon.strconst.1, 20

	.type	anon.strconst.2,@object
	.section	.rodata
anon.strconst.2:
	.asciz	"\nabbdbdd\\\\\"d\"c\\adc\"c"
	.size	anon.strconst.2, 20


