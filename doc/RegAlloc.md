### RegisterAlloc Disciplines

| REG    | ABI NAME | Description.              | Saver |
|--------|----------|---------------------------|-------|
| x0     | zero     | hard-wired zero           |       |
| x1     | ra       | Ret address               | er    |
| x2     | sp       | Stack pointer             | ee    |
| x3     | gp       | Global pointer            |       |
| x4     | tp       | Thread pointer            |       |
| x5     | t0       | link Reg/Temporary        | er    |
| x6-7   | t1-2     | Temporaries               | er    |
| x8     | s0/fp    | Saved Reg / frame pointer | ee    |
| x9     | s1       | Saved Reg                 | ee    |
| x10-11 | a0-1     | Func Args / Ret Values    | er    |
| x12-17 | a2-7     | Func Args                 | er    |
| x18-27 | s2-11    | Saved Regs                | ee    |
| x28-31 | t3-6     | Temporaries               | er    |
a: args 
s: saves 
t: temps




    利用相交图（interference graph）来表示程序变量的生命期是否相交，将寄存器分配给变量的问题，可以近似地看成是给相交图着色：相交图中，相交的节点不能着同一颜色；每一种颜色对应一个寄存器。Chaitin等人最早提出了基于图着色的寄存器分配方法其着色思路采用了Kempe的着色方法，即，任意一个邻居节点数目少于k的节点，都能够被k着色。判断一个图是否能够被k(k>=3)种颜色着色，即k着色问题，被Karp证明是一个NP-complete问题。
 
    但是，寄存器分配不仅仅是图着色的问题。当寄存器数目不足以分配某些变量时，就必须将这些变量溢出到内存中，该过程成为spill。最小化溢出代价的问题，也是一个NP-complete问题。如果简化该问题——假设所有溢出代价相等，那么最小化溢出代价的问题，等价于k着色问题，仍然是NP-complete问题。
    此外，如果两个变量的生命期仅仅因为出现在同一个拷贝指令中而相邻，那么，通过将这两个变量分配到同一个寄存器，就可以消除该拷贝指令，成为coalescing
    为了降低相交图的聚簇现象，提高相交图的可着色性，可以通过将变量拷贝给一个临时变量，并将以后对该变量的使用替换成对该临时变量的使用，从而将一个变量的生命期分解成两个变量的生命期，称为live range splitting。显然，这是一个与coalescing的作用相反的过程。Bouchez等人考虑了该方法的复杂度。
