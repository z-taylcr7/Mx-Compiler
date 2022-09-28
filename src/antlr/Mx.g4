grammar Mx;

//parser

//coding
MxCode:(funcDef|classDef|varDefStmt)*EOF;

//class

//function
//variables

//arraytype
varDefType:BasicType | ID |(BasicType|ID)(LBracket RBracket)*;
varDefBody:varDefType varDefSingle (comma varDefObj)*;
varDefSingle:ID (Assign expression)?;
newExpSizeDeclaration: LeftBracket expression? RightBracket;

//Statements
pack:LBrace statement* RBrace;
ifStmt:If LParen expression RParen statement (Else statement)?;
whileStmt: While LParen expression RParen pack;
varDefStmt:varDefBody SemiColon;//todo:
forInit:varDefType varDefObj (comma varDefObj)*;
returnStmt: Return expression? SemiColon;
forStmt:For LBrace forInit? SemiColon forCond=expression? SemiColon forIncr=expression? RBrace pack;
packStmt:pack;
pureStmt:expression?SemiColon;
statement
    :   packStmt
    |   ifStmt
    |   whileStmt
    |   forStmt
    |   controlStmt
    |   returnStmt
    |   varDefStmt
    |   pureStmt
    ;

//expressions

//operators
prefixOps:SelfAdd|SelfMinus;
suffixOps:SelfAdd|SelfMinus;
unaryOps:Negative|Add|Minus|LogicNegative;
shiftOps:LeftShift|RightShift;
supOps:Multiply|Divide;
infOps:Add|Minus;
compareOps:Greater|Less|GEQ|LEQ;
equalOps:NEQ|Equal;


expression:
        basicExp                                                                        //atomExp
        |LParen expression RParen                                                       //parenExo
        |New (ID|BasicType) newExpSizeDeclaration* (LParen RParen)?//todo: not good     //newExp
        |expression LBracket expression RBracket                                        //ArrayExp
        |expression Object ID                                                           //memberExp
        |
basicExp:ID|True|False|This|IntLiteral|StringLiteral|Null;


//lexer

// Comments
Comment :   ( '//' ~[\r\n]* '\r'? '\n'
        | '/*' .*? '*/'
        ) -> skip
    ;

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
LBracket:'[';
RBracket:']';
LParen:'(';
RParen:')';
LBrace:'{';
RBrace:'}';
SemiColon:';';
Comma:',';

//keywords

//basic type keywords
BoolType:'bool';
IntType:'int';
StringType:'string';
VoidType:'void';
BasicType:BoolType|IntType|StringType|VoidType;
//class keywords
New:'new';
Class:'class';
This:'this';

//const keywords
Null:'null';
True:'true';
False:'false';

//control keywords
If:'if';
Else:'else';
For:'for';
While:'while';
Break:'break';
Continue:'continue';
Return:'return';





//blank eater
WhiteSpace: ([ \t]+)->skip;
NewLine:('\r' '\n'?| '\n') -> skip;


//ID
ID: Letter IdentifierCharacter*;
//literal
Literal:BoolLiteral|IntLiteral|StringLiteral|NullLiteral;
BoolLiteral:True|False;
IntLiteral: '0'|DigitExceptZero Digit*;
StringLiteral:'"' StringCharacter* ?'"';
NullLiteral:Null;
//fragments
fragment Digit: '0'..'9';
fragment DigitExceptZero: '1'..'9';
fragment Letter: 'a'..'z'|'A'..'Z';
fragment Symbol: [!"#$%&'()*+,-./:;=><?[\]^_`{|}~];

fragment IdentifierCharacter: 'a'..'z'|'A'..'Z'|'0'..'9'|'_';

fragment EscapeCharacter
    : '\\n'
    | '\\\\'
    | '\\"';
fragment StringCharacter
    : Digit
    | Letter
    | Symbol
    | EscapeCharacter;



