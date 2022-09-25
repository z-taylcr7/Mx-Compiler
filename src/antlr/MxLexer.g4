lexer grammar MxLexer;
// Comments
Comment
    :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> skip
    ;
//void, bool, int, string, new, class, null, true, false, this, if, else, for, while, break, continue, return
Void:'void';
Bool:'bool';
Int:'int';
String:'string';
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

//Symbols
SelfAdd:'++';
Add:'+';
SelfMinus:'--';
Minus:'-';
Multiply:'*';
Divide:'/';
Mod:'%';
LogicAnd:'&&';
LogicOr:'||';
LogicNegative:'!';
LeftShift:'<<';
RightShift:'>>';
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
fragment Digit: '0'..'9';
fragment DigitExceptZero: '1'..'9';
fragment Letter: 'a'..'z'|'A'..'Z';
fragment Symbol: [!"#$%&'()*+,-./:;=><?[\]^_`{|}~];
fragment IdentifierCharacter: 'a'..'z'|'A'..'Z'|'0'..'9'|'_';
fragment EscapeCharacter
    : '\n'
    | '\\'
    | '"';
fragment StringCharacter
    : Digit
    | Letter
    | Symbol
    | EscapeCharacter;

//ID
Identifier: Letter IdentifierCharacter*;

//literal
BoolLiteral:True|False;
IntLiteral: '0'|DigitExceptZero Digit*;
StringLiteral:'"' StringCharacter+ '"';
NullLiteral:Null;


//seperator
WhiteSpace: (' '|'\t'|'\n'|'//')->skip;

Enter:('\r'|'\n');

//variables
INT:IntLiteral|'-' IntLiteral;
BOOL:True|False;
VOID:'NULL';//Dont know what to do
STRING:StringLiteral;//how to get immutable?

