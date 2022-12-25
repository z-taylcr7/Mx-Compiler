llvm-link test.ll ./lib/builtIn.ll -o link.bc
llvm-dis link.bc
clang++ link.bc -o test
./test