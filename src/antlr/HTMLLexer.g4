lexer grammar HTMLLexer;

NG_FOR           : '*ngFor';
NG_IF            : '*ngIf';
INTERPOLATION    : DOUBLE_CURLY_OPEN (~('}' | '\n'))* DOUBLE_CURLY_CLOSE;
DOUBLE_CURLY_OPEN : '{{';
DOUBLE_CURLY_CLOSE : '}}';
HTML_ELEMENT    : 'div'
                | 'h1'
                | 'h2'
                | 'h3'
                | 'h4'
                | 'h5'
                | 'h6'
                | 'p'
                | 'button'
                | 'img'
                | 'ul'
                | 'li'
                | 'span'
                | 'a'
                | 'table'
                | 'tr'
                | 'td'
                | 'th'
                | 'thead'
                | 'tbody'
                | 'form'
                | 'label'
                | 'input'
                | 'br'
                | 'main'
                | 'app' DASH IDENTIFIER
                ;
CSS_PROPERTY    : 'border'
                | 'padding'
                | 'width'
                | 'margin-top'
                | 'border-radius'
                | 'margin-Left'
                | 'text-align'
                | 'cursor'
                | 'background-color'
                | 'box-shadow'
                | 'flex'
                | 'flex-direction'
                | 'height'
                | 'display'
                | 'justify-content'
                | 'transition'
                | 'border-right'
                | 'align-items'
                | 'max-width'
                | 'margin-bottom'
                | 'gap'
                | 'transform'
                | 'background'
                | 'font-size'
                | 'align-self'
                | 'color'
                ;
COMPONENT       : 'Component';
SELECTOR        : 'selector' ;
TEMPLATE_URL    : 'templateUrl' ;
TEMPLATE        : 'template' ;
STYLE_URLS      : 'styleUrls' ;
STYLES           : 'styles' ;
STANDALONE      : 'standalone' ;
INJECTABLE      : 'Injectable' ;
ROOT            : 'root' ;
PLATFORM        : 'platform' ;
PROVIDED_IN     : 'providedIn' ;
HTML_OPEN_TAG   : '<html>';
HTML_CLOSE_TAG  : '</html>';
STYLE_OPEN_TAG  : '<style>';
CONSOL          : 'console';
LOG             : 'log' ;
STYLE_CLOSE_TAG : '</style>';
FUNCTION        : 'function';
CLASS           : 'class' ;
NEW             : 'new' ;
NUMBER          : 'number';
STRING          : 'string';
BOOLEAN         : 'boolean';
ARRAY           : 'Array';
ENUM            : 'enum';
ANY             : 'any';
VOID            : 'void';
LET             : 'let' | 'Let';
TRUE            : 'true';
FALSE           : 'false';
AS              : 'as' ;
RETURN          : 'return' ;
INTERFACE       : 'interface';
THIS            : 'this' ;
CONSTRUCTOR     : 'constructor' ;
EXTENDS         : 'extends' ;
SUPER           : 'super' ;
PUBLIC          : 'public' ;
PRIVATE         : 'private' ;
PROTECTED       : 'protected' ;
CONST           : 'const' ;
EXPORT          : 'export' ;
IMPORT          : 'import' ;
IMPORTS         : 'imports' ;
FROM            : 'from' ;
SHOW            : 'show';
THROW           : 'throw';
EMIT            : 'emit' ;
DECORATOR       : '@' ;
DASH            : '-';
UNDERSCORE      : '_';
COLON           : ':';
SEMICOLON       : ';';
COMMA           : ',';
LBRACKET        : '[';
RBRACKET        : ']';
LBRACE          : '{';
RBRACE          : '}';
LPAREN          : '(';
RPAREN          : ')';
ASSIGN          : '=';
QUOTE           : '"';
BACKTICK        : '`' ;
SINGLE_QUOTE    : '\'' ;
OPEN_TAG        : '<';
CLOUSE_TAG      : '>';
ARROW           : '=>' ;
DOT             : '.';
PLUS            : '+' ;
TAG_OPEN_SLASH  : '</';
HASH            : '#';
SDOLAR          :'$';
SLASH           : '/' ;
FOR_LOOP: 'for';
STRING_CONTENT
                : '\'' (~['\\])* '\''
                | QUOTE (~["\\])* QUOTE
                | '\'' ROOT | PLATFORM | ANY | IDENTIFIER '\''
                ;
VALUE           : [0-9]+ | '"' (~["\\])* '"'
                | [0-9]+ DOT [0-9]+ LETTER?
                | NUMBER_WITH_UNIT WHITESPACE? KEYWORD WHITESPACE? COLOR_CODE
                | NUMBER_WITH_UNIT
                | COLOR_CODE
                | KEYWORD
                ;
NUMBER_WITH_UNIT : [0-9]+ ('px' | 'em' | '%' | 'vh' | 'rem');
KEYWORD : 'solid' | 'dashed' | 'dotted' | 'double' | 'scale' | 'center' | 'row' | 'pointer' | 'column' | 'auto' | 'null'
                  |'blue' | 'gray' | 'white' | 'none' | 'darkblue' | 'green';
IDENTIFIER      : [a-zA-Z_][a-zA-Z0-9_]*
                | [a-zA-Z_][a-zA-Z0-9_]* DASH [a-zA-Z_][a-zA-Z0-9_]*
                ;
COLOR_CODE : '#' [0-9a-fA-F]+;
fragment LETTER : [a-zA-Z\u0600-\u06FF];
fragment DIGIT  : [0-9];
WHITESPACE      : [ \t\r\n]+ -> skip;
SINGLE_LINE_COMMENT : '//' ~[\r\n]* -> skip;
MULTI_LINE_COMMENT  : '/*' .*? '*/' -> skip;
COMMENT             : '<!--' .*? '-->' -> skip;

