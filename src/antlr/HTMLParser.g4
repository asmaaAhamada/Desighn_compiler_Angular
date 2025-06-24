// ==========================================
// القسم: تعريف البرنامج Program
// ==========================================
parser grammar HTMLParser;

options { tokenVocab=HTMLLexer; }

program
    : (statement+)? EOF                        #ProgramRoot
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
   : serviceDeclaration
   | componentDeclaration
   ;


componentDeclaration
   : DECORATOR COMPONENT LPAREN LBRACE componentBody* RBRACE RPAREN  #Componentdefinition
   ;

componentBody
   : SELECTOR COLON STRING_CONTENT COMMA?                                   #SelectorProp
   | TEMPLATE COLON BACKTICK htmlProgram BACKTICK COMMA?                   #InlineTemplateProp
   | TEMPLATE_URL COLON STRING_CONTENT COMMA?                              #TemplateUrlProp
   | STYLE_URLS COLON arrayLiteral COMMA?                                  #StyleUrlsProp
   | STYLES COLON LBRACKET BACKTICK (cssProgram)* BACKTICK RBRACKET COMMA? #StylesProp
   | IMPORTS COLON LBRACKET (IDENTIFIER COMMA?)* RBRACKET COMMA?           #ImportsProp
   | STANDALONE COLON (TRUE | FALSE) COMMA?                                #StandaloneProp
   ;
serviceDeclaration
   : DECORATOR INJECTABLE LPAREN LBRACE PROVIDED_IN COLON STRING_CONTENT RBRACE RPAREN  #InjectableDefinition
   ;

// ==========================================
// القسم: HTML
// ==========================================
htmlProgram
   : HTML_OPEN_TAG (htmlElement)* HTML_CLOSE_TAG        #Htmlblock
   | htmlElement                                        #Htmlelement
   ;


htmlElement
   : OPEN_TAG HTML_ELEMENT (attribute | ngDirective)* SLASH CLOUSE_TAG                          #SelfClosingHtml
   | OPEN_TAG HTML_ELEMENT (attribute | ngDirective)* CLOUSE_TAG                                #OpenTagOnlyHtml
   | OPEN_TAG HTML_ELEMENT (attribute | ngDirective)* CLOUSE_TAG (htmlElement | htmlContent)* TAG_OPEN_SLASH HTML_ELEMENT CLOUSE_TAG #NestedHtml
   ;

htmlContent
   : INTERPOLATION ((DASH | COLON) INTERPOLATION)*       #InterpolationContent
   | STRING_CONTENT                                      #StringContent
   | IDENTIFIER                                          #IdentifierContent
   | IDENTIFIER COLON                                    #ColonIdentifierContent
   ;

attribute
   : (IDENTIFIER | CLASS) ASSIGN STRING_CONTENT           #SimpleAttribute
   | IDENTIFIER ASSIGN QUOTE .*? QUOTE                    #QuotedAttribute
   | LBRACKET IDENTIFIER RBRACKET ASSIGN STRING_CONTENT   #BoundAttribute
   | LPAREN IDENTIFIER RPAREN ASSIGN STRING_CONTENT       #EventAttribute
   | IDENTIFIER COLON                                     #ColonOnlyAttribute
   ;

// ==========================================
// القسم: CSS
// ==========================================
cssProgram
   : STYLE_OPEN_TAG (cssRule)* STYLE_CLOSE_TAG            #CssBlockWithTag
   | cssRule+                                             #CssMultipleRules
   ;


cssRule
   : selector HTML_ELEMENT? LBRACE (cssProperty COLON (VALUE* (callFunctios)? | cssProperty VALUE?) SEMICOLON?)* RBRACE #CssBasicRule
   | selector COLON IDENTIFIER LBRACE (CSS_PROPERTY COLON (VALUE | CSS_PROPERTY VALUE? | VALUE LPAREN VALUE RPAREN) SEMICOLON)* RBRACE #CssNestedRule
   ;


cssProperty
   : CSS_PROPERTY                                         #CssPropertyName
   ;

selector
   : DOT (IDENTIFIER | HTML_ELEMENT | LOG | AS)           #DotSelector
   | HASH IDENTIFIER                                      #HashSelector
   | IDENTIFIER                                           #SimpleSelector
   ;

// ==========================================
// القسم: الاستيراد والتصدير
// ==========================================
 importModelDeclaration
    : IMPORT LBRACE (IDENTIFIER | COMPONENT | INJECTABLE) RBRACE FROM STRING_CONTENT SEMICOLON  #ImportModel
    ;

exportModelDeclaration
   : EXPORT (CLASS | FUNCTION | CONST | INTERFACE | ENUM) IDENTIFIER (ASSIGN expression)? SEMICOLON  #ExportSimple
   | EXPORT classDeclaration                                    #ExportClass
   ;

// ==========================================
// القسم: التعاريف العامة
// ==========================================
variableDeclaration
   : (LET | PUBLIC | PRIVATE | PROTECTED | CONST)? IDENTIFIER COLON type? (ASSIGN? (VALUE | TRUE | FALSE | STRING_CONTENT | arrayLiteral | tupleLiteral | enumValue | typeAssertion))? (SEMICOLON | COMMA)? #VariableTyped
   | IDENTIFIER ASSIGN arrayLiteral SEMICOLON                  #VariableArrayAssignment
   | IDENTIFIER COLON (SDOLAR LBRACE THIS DOT IDENTIFIER RBRACE) #VariableThisBinding
   | decorator                                                 #VariableDecorator
   ;
decorator
   : DECORATOR IDENTIFIER LPAREN RPAREN IDENTIFIER ASSIGN NEW IDENTIFIER OPEN_TAG type CLOUSE_TAG LPAREN RPAREN SEMICOLON #DecoratorDefinition
   ;

typeAssertion
   : LPAREN (IDENTIFIER AS type | OPEN_TAG type CLOUSE_TAG IDENTIFIER) RPAREN DOT IDENTIFIER #TypeAssertionExpr
   ;
// ==========================================
// القسم: التعداد (Enum)
// ==========================================
enumDeclaration
   : ENUM IDENTIFIER LBRACE enumeratorList RBRACE           #EnumDef
   ;
enumeratorList
   : IDENTIFIER (COMMA IDENTIFIER)*                         #EnumValues
   ;

enumValue
   : IDENTIFIER DOT IDENTIFIER                              #EnumValueRef
   ;
// ==========================================
// القسم: الكلاسات
// ==========================================
classDeclaration
   : CLASS IDENTIFIER (EXTENDS IDENTIFIER)? block           #ClassDef
   ;

objectClass
   : LET IDENTIFIER ASSIGN NEW IDENTIFIER LPAREN (expression (COMMA expression)*)? RPAREN SEMICOLON  #ObjectClassInstance
   ;

// ==========================================
// القسم: الواجهات
// ==========================================
interfaceDeclaration
   : INTERFACE IDENTIFIER block                             #InterfaceDef
   ;

objectInterface
   : LET IDENTIFIER COLON IDENTIFIER ASSIGN LBRACE objectInterfaceBody RBRACE SEMICOLON #ObjectInterfaceInit
   ;

objectInterfaceBody
   : IDENTIFIER COLON (VALUE | TRUE | FALSE) (COMMA IDENTIFIER COLON (VALUE | TRUE | FALSE))* #ObjectInterfaceProps
   ;
// ==========================================
// القسم: الدوال
// ==========================================

functionDeclaration
   : FUNCTION IDENTIFIER LPAREN parameterList? RPAREN (COLON type)? block                                 #FunctionFull
   | IDENTIFIER ASSIGN FUNCTION? LPAREN parameterList? RPAREN ARROW? (type)? (ARROW expression | block) SEMICOLON? #FunctionArrow
   | IDENTIFIER LPAREN parameterList? RPAREN block                                                        #FunctionShorthand
   ;

parameterList
   : (variableDeclaration) (COMMA variableDeclaration)*   #ParamVars
   | IDENTIFIER (COMMA IDENTIFIER)*                       #ParamIdentifiers
   | VALUE (COMMA VALUE)*                                 #ParamValues
   ;

callFunctios
   : IDENTIFIER LPAREN (expression (COMMA expression)*)? RPAREN                          #CallNormal
   | IDENTIFIER LPAREN BACKTICK (expression (COMMA expression)*)? BACKTICK RPAREN SEMICOLON #CallBacktick
   ;

// ==========================================
// القسم: الكونسول والرجوع والرمي
// ==========================================
consolDeclaration
   : CONSOL DOT LOG LPAREN expression (COMMA expression)* RPAREN SEMICOLON               #ConsoleLog
   ;

returnStatement
   : RETURN expression SEMICOLON                     #ReturnExpr
   ;

throwStatement
   : THROW NEW IDENTIFIER LPAREN STRING_CONTENT RPAREN SEMICOLON #ThrowError
   ;
// ==========================================
// القسم: التعابير والكتل
// ==========================================

expressionStatement
   : expression SEMICOLON                             #ExprStmt
   ;

expression
   : IDENTIFIER                                       #ExprIdentifier
   | VALUE                                            #ExprValue
   | STRING_CONTENT                                   #ExprString
   | TRUE                                             #ExprTrue
   | FALSE                                            #ExprFalse
   | callFunctios                                     #ExprCall
   | variableDeclaration                              #ExprVarDecl
   ;

block
   : LBRACE statement* RBRACE                         #BlockStatements
   ;

// ==========================================
// القسم: this و emit
// ==========================================
thisStatement
   : THIS DOT IDENTIFIER ASSIGN IDENTIFIER SEMICOLON  #ThisAssignment
   ;

emitStatement
   : THIS DOT IDENTIFIER DOT EMIT LPAREN objectLiteral RPAREN SEMICOLON? #EmitCall
   ;

objectLiteral
   : LBRACE objectProperty (COMMA objectProperty)* RBRACE #ObjectLiteralDef
   ;

objectProperty
   : IDENTIFIER COLON (STRING_CONTENT | VALUE)            #ObjectPropertyPair
   ;

// ==========================================
// القسم: المصفوفات والـ Tuples
// ==========================================

arrayLiteral
   : LBRACKET (VALUE (COMMA VALUE)*)? RBRACKET            #ArrayValues
   | LBRACKET (STRING_CONTENT (COMMA STRING_CONTENT)*)? RBRACKET  #ArrayStrings
   | LBRACKET mapLiteral (COMMA mapLiteral COMMA?)*  RBRACKET     #ArrayOfMaps
   ;

mapLiteral
   : LBRACE IDENTIFIER COLON (VALUE | STRING_CONTENT) (COMMA IDENTIFIER COLON (VALUE | STRING_CONTENT))* RBRACE #  Mapliteral
   ;

tupleLiteral
   : LBRACKET VALUE (COMMA VALUE)* RBRACKET              #Tupleliteral
   ;

// ==========================================
// القسم: if/for في HTML
// ==========================================
ngDirective
   : NG_FOR ASSIGN STRING_CONTENT                        #NgForDirective
   | NG_IF ASSIGN STRING_CONTENT                         #NgIfDirective
   ;

// ==========================================
// القسم: الأنواع Type
// ==========================================
type
   : NUMBER                                              #TypeNumber
   | NUMBER LBRACKET RBRACKET                            #TypeNumberArray
   | STRING                                              #TypeString
   | BOOLEAN                                             #TypeBoolean
   | ARRAY OPEN_TAG type CLOUSE_TAG                      #TypeGenericArray
   | LBRACKET type (COMMA type)* RBRACKET                #TypeTuple
   | ENUM                                                #TypeEnum
   | ANY (LBRACKET RBRACKET)?                            #TypeAny
   | VOID                                                #TypeVoid
   | IDENTIFIER                                          #TypeCustom
   ;

// ==========================================
// القسم: الإسناد Assignment
// ==========================================
assignment
   : IDENTIFIER* ASSIGN expression SEMICOLON             #AssignExpression
   | IDENTIFIER* ASSIGN any_type*                        #AssignAnyType
   ;


any_type
   : VALUE | COLOR_CODE | IDENTIFIER | NUMBER | STRING | ANY | LBRACKET product (COMMA product*)* RBRACKET
   ;

product
   : LBRACE IDENTIFIER* COLON NUMBER* COMMA IDENTIFIER* COLON STRING COMMA IDENTIFIER* COLON STRING RBRACE #ProductType
   ;


objectCreation
   : LET IDENTIFIER ASSIGN NEW IDENTIFIER LPAREN (expression (COMMA expression)*)? RPAREN SEMICOLON  #ObjectNew
   ;
