grammar Mx;
// Add Package Automatically
@header {
    package undecimber.compiler.frontend.parser;
}
//parser

//coding
mxCode:(classDef|funcDef|varDefStmt)* EOF;

//class
classDef:Class ID LBrace (classConstructorDef|varDefStmt|funcDef)* RBrace SemiColon;
classConstructorDef:ID LParen RParen pack;

//function
funcDef:varDefType ID LParen funcDefArgs? RParen pack;
funcDefArgs:varDefType ID (Comma varDefType ID)*;
funcCallArgs: LParen (expression (Comma expression)*)? RParen;
//variables
basicType:BoolType|IntType|StringType|VoidType;
//arraytype
varDefType:basicType | ID |(basicType|ID)(LBracket RBracket)+;
newExpSizeDeclaration: LBracket expression? RBracket;
varDefObj:varDefType varDefSingle (Comma varDefSingle)*;
varDefSingle:ID (Assign expression)?;

//Statements
pack:LBrace statement* RBrace;
varDefStmt:varDefObj SemiColon;
ifStmt:If LParen expression RParen statement (Else statement)?;
whileStmt: While LParen expression RParen statement;

forInit:(varDefObj|expression);
forStmt:For LParen forInit? SemiColon forCond=expression? SemiColon forIncr=expression? RParen (statement);
returnStmt: Return expression? SemiColon;
controlStmt:(Break|Continue) SemiColon;
pureStmt:expression? SemiColon;
packStmt:pack;


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

    expression:
    basicExp                                                                                 #atomExp
            |LParen expression RParen                                                       #parenExp
            |expression LBracket expression RBracket                                        #indexExp
            |New (ID|basicType) newExpSizeDeclaration* (LParen RParen)?                     #newExp
            |expression Object ID                                                           #memberExp
            |expression funcCallArgs                                                        #functionCallExp
            |LambdaStart (LParen funcDefArgs? RParen)?
             LambdaArrow pack funcCallArgs                                                  #lambdaExp

            |expression suffixOps                                                           #suffixExp
            |<assoc=right> prefixOps expression                                             #prefixExp
            |<assoc=right> unaryOps expression                                              #unaryExp

            |expression supOps expression                                                 # binaryExp//12
            |expression infOps expression                                                # binaryExp  //11
            |expression shiftOps expression                                                 # binaryExp//13
            |expression compareOps expression                                                # binaryExp //14
            |expression equalOps expression                                                 # binaryExp//15
            |   expression And expression                                                  #binaryExp     // 8
            |   expression Xor expression                                                  #binaryExp     // 9
            |   expression Or expression                                                   #binaryExp     // 10
            |   expression LogicAnd expression                                                #binaryExp     // 11
            |   expression LogicOr expression                                                 #binaryExp     // 12



            |<assoc=right> expression Assign expression                                     #assignExp

           // |expression Comma expression                                                    #commaExp
            ;
    basicExp:ID|IntLiteral|StringLiteral|True|False|Null|This;

//lexer

// Comments
Comment :   ( '//' ~[\r\n]* (('\r'? '\n')|EOF)
        | '/*' .*? '*/'
        ) -> skip
    ;

//Symbols
Add:'+';
Minus:'-';
Multiply:'*';
Divide:'/';
Mod:'%';
Greater:'>';
Less:'<';
GEQ:'>=';
LEQ:'<=';
NEQ:'!=';
Equal:'==';

LogicAnd:'&&';
LogicOr:'||';
LogicNegative:'!';

LeftShift:'<<';
RightShift:'>>';
And:'&';
Or:'|';
Xor:'^';
Negative:'~';

Assign:'=';

SelfAdd:'++';
SelfMinus:'--';

Object:'.';
LBracket:'[';
RBracket:']';
LParen:'(';
RParen:')';
SemiColon:';';
Comma:',';
LBrace:'{';
RBrace:'}';
LambdaStart:'[&]';
//todo: Lambda nonGlobals
LambdaArrow:'->';

//keywords

//basic type keywords

IntType:'int';
BoolType:'bool';
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



