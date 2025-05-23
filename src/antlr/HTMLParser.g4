// ==========================================
// القسم: تعريف البرنامج Program
// ==========================================
parser grammar HTMLParser;

options { tokenVocab=HTMLLexer; }

program
    : statement+
    ;

// ==========================================
// القسم: جميع أنواع الجمل في البرنامج
// ==========================================
statement
    : declaration
    | htmlProgram
    | cssProgram
    | variableDeclaration
    | importModelDeclaration
    | exportModelDeclaration
    | functionDeclaration
    | classDeclaration
    | interfaceDeclaration
    | objectCreation
    | enumDeclaration
    | consolDeclaration
    | expressionStatement
    | returnStatement
    | throwStatement
    | objectClass
    | objectInterface
    | callFunctios
    | assignment
    | emitStatement
    | thisStatement
    ;

// ==========================================
// القسم: تعريفات Angular
// ==========================================
declaration
   :serviceDeclaration
   |componentDeclaration
   ;

componentDeclaration
   : DECORATOR COMPONENT LPAREN LBRACE (componentBody COMMA?)* RBRACE RPAREN
   ;

componentBody
   : SELECTOR COLON STRING_CONTENT
   | TEMPLATE COLON BACKTICK htmlProgram BACKTICK
   | TEMPLATE_URL COLON STRING_CONTENT
   | STYLE_URLS COLON arrayLiteral
   | STYLES COLON LBRACKET BACKTICK (cssProgram)* BACKTICK RBRACKET
   | IMPORTS COLON LBRACKET (IDENTIFIER COMMA?)* RBRACKET
   | STANDALONE COLON (TRUE | FALSE)
   ;

serviceDeclaration
   : DECORATOR INJECTABLE LPAREN LBRACE PROVIDED_IN COLON STRING_CONTENT RBRACE RPAREN
   ;

// ==========================================
// القسم: HTML
// ==========================================
htmlProgram
   : HTML_OPEN_TAG (htmlElement)* HTML_CLOSE_TAG
   | htmlElement
   ;

htmlElement
   : OPEN_TAG HTML_ELEMENT (attribute | ngDirective)* SLASH CLOUSE_TAG
   | OPEN_TAG HTML_ELEMENT (attribute | ngDirective)*  CLOUSE_TAG
   | OPEN_TAG HTML_ELEMENT (attribute | ngDirective)* CLOUSE_TAG
   (htmlElement | htmlContent)* TAG_OPEN_SLASH HTML_ELEMENT CLOUSE_TAG
   ;

htmlContent
   : INTERPOLATION ((DASH | COLON) INTERPOLATION)*
   | STRING_CONTENT
   | IDENTIFIER
   | IDENTIFIER COLON
   ;

attribute
   : (IDENTIFIER | CLASS) ASSIGN STRING_CONTENT
   | IDENTIFIER ASSIGN QUOTE .*? QUOTE
   | LBRACKET IDENTIFIER RBRACKET ASSIGN STRING_CONTENT
   | LPAREN IDENTIFIER RPAREN ASSIGN STRING_CONTENT
   | IDENTIFIER COLON
   ;

// ==========================================
// القسم: CSS
// ==========================================
cssProgram
   : STYLE_OPEN_TAG (cssRule)* STYLE_CLOSE_TAG
   |cssRule+
   ;

cssRule
   : selector HTML_ELEMENT? LBRACE (cssProperty COLON (VALUE* (callFunctios)?  | cssProperty VALUE?) SEMICOLON?)* RBRACE
   | selector COLON IDENTIFIER LBRACE (CSS_PROPERTY COLON (VALUE | CSS_PROPERTY VALUE? | VALUE LPAREN VALUE RPAREN ) SEMICOLON)* RBRACE
   ;

cssProperty
   : CSS_PROPERTY
   ;

selector
   : DOT (IDENTIFIER | HTML_ELEMENT | LOG | AS)
   | HASH IDENTIFIER
   | IDENTIFIER
   ;

// ==========================================
// القسم: الاستيراد والتصدير
// ==========================================
 importModelDeclaration
    : IMPORT LBRACE (IDENTIFIER | COMPONENT | INJECTABLE) RBRACE FROM STRING_CONTENT SEMICOLON
    ;

exportModelDeclaration
    : EXPORT (CLASS | FUNCTION | CONST | INTERFACE | ENUM) IDENTIFIER (ASSIGN expression)? SEMICOLON
    | EXPORT classDeclaration
    ;

// ==========================================
// القسم: التعاريف العامة
// ==========================================
variableDeclaration
   : (LET | PUBLIC | PRIVATE | PROTECTED | CONST)? IDENTIFIER COLON type? (ASSIGN? (VALUE | TRUE | FALSE | STRING_CONTENT | arrayLiteral | tupleLiteral | enumValue | typeAssertion))? (SEMICOLON | COMMA)?
   | IDENTIFIER ASSIGN arrayLiteral SEMICOLON
   | IDENTIFIER COLON (SDOLAR LBRACE THIS DOT IDENTIFIER RBRACE)
   | decorator
   ;

decorator
   : DECORATOR IDENTIFIER LPAREN RPAREN IDENTIFIER ASSIGN NEW IDENTIFIER OPEN_TAG type CLOUSE_TAG LPAREN RPAREN SEMICOLON
   ;

typeAssertion
    : LPAREN (IDENTIFIER AS type | OPEN_TAG type CLOUSE_TAG IDENTIFIER) RPAREN DOT IDENTIFIER
    ;

// ==========================================
// القسم: التعداد (Enum)
// ==========================================
enumDeclaration
   : ENUM IDENTIFIER LBRACE enumeratorList RBRACE
   ;

enumeratorList
   : IDENTIFIER (COMMA IDENTIFIER)*
   ;

enumValue
   : IDENTIFIER DOT IDENTIFIER
   ;

// ==========================================
// القسم: الكلاسات
// ==========================================
classDeclaration
   :CLASS IDENTIFIER (EXTENDS IDENTIFIER)? block
   ;

objectClass
   : LET IDENTIFIER ASSIGN NEW IDENTIFIER LPAREN (expression (COMMA expression)*)? RPAREN SEMICOLON
   ;

// ==========================================
// القسم: الواجهات
// ==========================================
interfaceDeclaration
   : INTERFACE IDENTIFIER block
   ;

objectInterface
   : LET IDENTIFIER COLON IDENTIFIER ASSIGN LBRACE objectInterfaceBody RBRACE SEMICOLON
   ;

objectInterfaceBody
   : IDENTIFIER COLON (VALUE | TRUE | FALSE) (COMMA IDENTIFIER COLON (VALUE | TRUE | FALSE))*
   ;

// ==========================================
// القسم: الدوال
// ==========================================
functionDeclaration
   : FUNCTION IDENTIFIER LPAREN parameterList? RPAREN (COLON type)? block
   | IDENTIFIER ASSIGN FUNCTION? LPAREN parameterList? RPAREN ARROW? (type)? (ARROW expression | block) SEMICOLON?
   | IDENTIFIER LPAREN parameterList? RPAREN block
   ;

parameterList
   : (variableDeclaration) (COMMA variableDeclaration)*
   | IDENTIFIER (COMMA IDENTIFIER)*
   | VALUE (COMMA VALUE)*
   ;

callFunctios
   : IDENTIFIER LPAREN (expression (COMMA expression)*)? RPAREN
   | IDENTIFIER LPAREN BACKTICK (expression (COMMA expression)*)? BACKTICK RPAREN SEMICOLON
   ;

// ==========================================
// القسم: الكونسول والرجوع والرمي
// ==========================================
consolDeclaration
   : CONSOL DOT LOG LPAREN expression (COMMA expression)* RPAREN SEMICOLON
   ;

returnStatement
   : RETURN expression SEMICOLON
   ;

throwStatement
   : THROW NEW IDENTIFIER LPAREN STRING_CONTENT RPAREN SEMICOLON
   ;

// ==========================================
// القسم: التعابير والكتل
// ==========================================
expressionStatement
   : expression SEMICOLON
   ;

expression
   : IDENTIFIER
   | VALUE
   | STRING_CONTENT
   | TRUE
   | FALSE
   | callFunctios
   | variableDeclaration
   ;

block
   : LBRACE statement* RBRACE
   ;

// ==========================================
// القسم: this و emit
// ==========================================
thisStatement
   :THIS DOT IDENTIFIER ASSIGN IDENTIFIER SEMICOLON
   ;

emitStatement
   : THIS DOT IDENTIFIER DOT EMIT LPAREN objectLiteral RPAREN SEMICOLON?
   ;

objectLiteral
   : LBRACE objectProperty (COMMA objectProperty)* RBRACE
   ;

objectProperty
   : IDENTIFIER COLON (STRING_CONTENT | VALUE)
   ;

// ==========================================
// القسم: المصفوفات والـ Tuples
// ==========================================
arrayLiteral
   : LBRACKET (VALUE (COMMA VALUE)*)? RBRACKET
   | LBRACKET (STRING_CONTENT (COMMA STRING_CONTENT)*)? RBRACKET
   | LBRACKET mapLiteral (COMMA mapLiteral COMMA?)*  RBRACKET
   ;
mapLiteral
   :LBRACE IDENTIFIER COLON (VALUE |STRING_CONTENT) (COMMA IDENTIFIER COLON (VALUE | STRING_CONTENT))* RBRACE
   ;

tupleLiteral
   : LBRACKET VALUE (COMMA VALUE)* RBRACKET
   ;

// ==========================================
// القسم: if/for في HTML
// ==========================================
ngDirective
   : NG_FOR ASSIGN STRING_CONTENT
   | NG_IF ASSIGN STRING_CONTENT
   ;

// ==========================================
// القسم: الأنواع Type
// ==========================================
type
   : NUMBER
   | NUMBER LBRACKET RBRACKET
   | STRING
   | BOOLEAN
   | ARRAY OPEN_TAG type CLOUSE_TAG
   | LBRACKET type (COMMA type)* RBRACKET
   | ENUM
   | ANY (LBRACKET RBRACKET)?
   | VOID
   | IDENTIFIER
   ;

// ==========================================
// القسم: الإسناد Assignment
// ==========================================
assignment
   : IDENTIFIER* ASSIGN expression SEMICOLON
   | IDENTIFIER* ASSIGN any_type*
   ;

any_type
   : VALUE | COLOR_CODE |IDENTIFIER | NUMBER | STRING|ANY| LBRACKET product (COMMA product*)* RBRACKET
   ;

product
   : LBRACE IDENTIFIER* COLON NUMBER* COMMA IDENTIFIER* COLON STRING COMMA IDENTIFIER* COLON STRING RBRACE
   ;

objectCreation
   : LET IDENTIFIER ASSIGN NEW IDENTIFIER LPAREN (expression (COMMA expression)*)? RPAREN SEMICOLON
   ;
