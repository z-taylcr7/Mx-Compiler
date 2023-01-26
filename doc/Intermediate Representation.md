## IR 

### SSA destructor
Main method: insert copies at Node's every predecessor
```
Block X       Block Y
a2<-xxx       a3<-yyy
    \           /
  a4<-Phi(a2,X;a3,Y)
  b<-...
  ...
```
to:
```
Block X       Block Y
a2<-xxx       a3<-yyy
a4<-a2        a4<-a3
    \           /
  b<-...
  ...
```
Hazard:
Blocks that begins with PhiInstructions always have multi predecessors,
while blocks that have multi successors can't insert copies at its end, otherwise conflict will be caused. Like:
I don't know whose copy should be executed first.

So,if those blocks has successors that have phi Instructions(have multi predecessors), this method fails.

> Critical Edge:
> An edge whose source has multi successors and whose destinations has multi predecessors is called a critical edge.

A critical edge will cause those kind of blocks thus brings out hazard.

So, we should eliminate the critical edges.

The method is: Split Critical Edges.
```
    A     D
  /   \ /
 B     C
```
A--C is a critical edge.

We add a midBlock between A and C. 
```
    A  
  /   \ 
 B    Mid  D 
        \ /
         C
```
Because MidBlock only has one pred and successor, the critical edge is destructed.

