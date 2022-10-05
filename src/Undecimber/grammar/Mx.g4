grammar Mx;
// Add Package Automatically
@header {
    package Undecimber.Compiler.frontend.parser;
}
//parser

//coding
mxCode:(funcDef|classDef|varDefStmt)* EOF;

//class
classDef:Class ID LBrace (varDefStmt|funcDef|classConstructorDef)* RBrace SemiColon;
classConstructorDef:ID LParen RParen pack;

//function
funcDef:varDefType ID LParen funcDefArgs? RParen pack;
funcDefArgs:varDefType ID (Comma varDefType ID)*;
funcCallArgs: LParen (expression (Comma expression)*)? RParen;
//variables
basicType:BoolType|IntType|StringType|VoidType;
//arraytype
varDefType:basicType | ID |(basicType|ID)(LBracket RBracket)*;
varDefObj:varDefType varDefSingle (Comma varDefSingle)*;
varDefSingle:(basicType|ID) (Assign expression)?;
newExpSizeDeclaration: LBracket expression? RBracket;

//Statements
pack:LBrace statement* RBrace;
ifStmt:If LParen expression RParen statement (Else statement)?;
whileStmt: While LParen expression RParen (statement);
varDefStmt:varDefObj SemiColon;
forInit:(varDefObj|expression);
returnStmt: Return expression? SemiColon;
forStmt:For LParen forInit? SemiColon forCond=expression? SemiColon forIncr=expression? RParen (statement);
packStmt:pack;
controlStmt:(Break|Continue) SemiColon;
pureStmt:expression? SemiColon;
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
    unaryOps:LogicNegative|Negative|Add|Minus|LogicNegative;
    shiftOps:LeftShift|RightShift;
    supOps:Multiply|Divide|Mod;
    infOps:Add|Minus;
    compareOps:Greater|Less|GEQ|LEQ;
    equalOps:NEQ|Equal;
    bitOps:Or|Xor|And;
    logicOps:LogicAnd|LogicOr;

    expression:
            basicExp                                                                        //atomExp
            |LParen expression RParen                                                       //parenExo
            |New (ID|basicType) newExpSizeDeclaration* (LParen RParen)?                     //newExp
            |expression LBracket expression RBracket                                        //ArrayExp
            |expression Object ID                                                           //memberExp
            |expression funcCallArgs                                                        //functionCallExp
            |LambdaStart (LParen funcDefArgs? RParen)?
             LambdaArrow pack funcCallArgs                                                  //lambdaExp
            |expression suffixOps
            |<assoc=right> prefixOps expression                                             //prefixExp
            |<assoc=right> unaryOps expression                                              //unaryExp

            |expression infOps expression
            |expression supOps expression
            |expression shiftOps expression
            |expression compareOps expression
            |expression equalOps expression
            |expression logicOps expression
            |expression bitOps expression                                                   //binaryExp

            |<assoc=right> expression Assign expression                                     //assignExp

            |expression Comma expression                                                    //commaExp
            ;
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
LambdaStart:'[&]';
LambdaArrow:'->';

//keywords

//basic type keywords
BoolType:'bool';
IntType:'int';
StringType:'string';
VoidType:'void';
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
fragment IdentifierCharacter: 'a'..'z'|'A'..'Z'|'0'..'9'|'_';
ID: Letter IdentifierCharacter*;
//literal

IntLiteral: '0'|([1-9] [0-9]*);
BoolLiteral:True|False;

EscapeEnter: '\\n';
EscapeBackslash: '\\\\';
EscapeQuote: '\\"';
StringContent: [ -~];
StringLiteral
    :   '"' (EscapeEnter | EscapeBackslash | EscapeQuote | StringContent)*? '"';

NullLiteral:Null;
//fragments
fragment Digit: '0'..'9';
fragment DigitExceptZero: '1'..'9';
fragment Letter: 'a'..'z'|'A'..'Z';
fragment Symbol: [!"#$%&'()*+,-./:;=><?[\]^_`{|}~];


fragment EscapeCharacter
    : '\\n'
    | '\\\\'
    | '\\"';
fragment StringCharacter
    : Digit
    | Letter
    | Symbol
    | EscapeCharacter;



