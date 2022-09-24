lexer grammar MxLexer;
<<<<<<< HEAD
// Comments
COMMENT
    :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> skip
    ;
=======

>>>>>>> a2b1b15694424b9256ae9521c16f0ad8e8a0cc4f
//void, bool, int, string, new, class, null, true, false, this, if, else, for, while, break, continue, return
Void:'void';
Bool:'bool';
Int:'int';
Stirng:'string';
New:'new';
Class:'class';
Null:'null';
True:'true';
False:'false';
This:'this';
If:'if';
Else:'else';
For:'for';
While:'while';
Break:'break';
Continue:'continue';
Return:'return';
<<<<<<< HEAD
//Symbols
Add:'+';
SelfAdd:'++';
Minus:'-';
SelfMinus:'--';
Multiply:'*';
Divide:'/';
Mod:'%';
LogicAnd:'&&';
LogicOr:'||';
LogicNegative:'!';
Greater:'>';
Less:'<';
Equal:'==';
GEQ:'>=';
LEQ:'<=';
NEQ:'!=';
And:'&';
Or:'|';
Xor:'^';
Negative:'~';
LeftShift:'<<';
RightShift:'>>';
Assign:'=';
Object:'.';
LBlanket:'[';
RBlanket:']';
LParel:'(';
RParel:')';
LBrace:'{';
RBrace:'}';
SemiColon:';';
Comma:',';


//fragments
fragment Digit: [0-9];
fragment Symbol: [!"#$%&'()*+,-./:;<=>?@[\]^_`{|}~];
fragment DigitExceptZero: [1-9];
fragment Letter: [a-zA-Z];
fragment IdentifierCharacter: [a-zA-Z0-9_];
fragment EscapeCharacter
    : '\n'
    | '\\'
    | '"';
fragment StringCharacter
    : Digit
    | Letter
    | Symbol
    | '\\' EscapeCharacter;

// whitespace
WhiteSpace
:(' '
|'\t'
|'\n'
|'//')->skip;
Identifier: Letter IdentifierCharacter*;

=======
>>>>>>> a2b1b15694424b9256ae9521c16f0ad8e8a0cc4f
