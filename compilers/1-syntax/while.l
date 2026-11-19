%option noyywrap c++ yylineno

%{
#include <iostream>
#include <stdlib.h>
%}

DIGIT  		  [0-9]
WS            [ \t\n]
LETTER        [a-zA-Z]
ID_PREFIX     ({LETTER}|_)+
EVEN_SUFFIX   [02468]{DIGIT}({DIGIT}{DIGIT})*
ODD_SUFFIX    [13579]({DIGIT}{DIGIT})*

/* Binary components */
BINARY_PREFIX   "0b"
BINARY_SUFFIX   [01]+

/* Octal literal components */
OCTAL_PREFIX    "0o"
OCTAL_SUFFIX    [0-7]+

/* Hexadecimal literal components */
HEXAL_PREFIX    "0x"
HEXAL_SUFFIX    [0-9a-fA-F]+

/* 14-base literal components */
BASE14_PREFIX   "14"
BASE14_SUFFIX   [0-9a-dA-D]+

/* 60-base literal components */
BASE60_PREFIX  "60"
BASE60_DIGIT   [0-5][0-9]

%%

program     std::cout << "T_PROGRAM" << std::endl;
begin       std::cout << "T_BEGIN" << std::endl;
end         std::cout << "T_END" << std::endl;
integer     std::cout << "T_INTEGER" << std::endl; 
boolean     std::cout << "T_BOOLEAN" << std::endl;
skip        std::cout << "T_SKIP" << std::endl;
if          std::cout << "T_IF" << std::endl;
then        std::cout << "T_THEN" << std::endl;
else        std::cout << "T_ELSE" << std::endl;
endif       std::cout << "T_ENDIF" << std::endl;
while       std::cout << "T_WHILE" << std::endl;
do          std::cout << "T_DO" << std::endl;
done        std::cout << "T_DONE" << std::endl;
read        std::cout << "T_READ" << std::endl;
write       std::cout << "T_WRITE" << std::endl;
";"         std::cout << "T_SEMICOLON" << std::endl;
":="        std::cout << "T_ASSIGN" << std::endl;
"="         std::cout << "T_EQ" << std::endl;
"<"         std::cout << "T_LESS" << std::endl;
">"         std::cout << "T_GR" << std::endl;
"+"         std::cout << "T_ADD" << std::endl;
"-"         std::cout << "T_SUB" << std::endl;
"*"         std::cout << "T_MUL" << std::endl;
and         std::cout << "T_AND" << std::endl;
or          std::cout << "T_OR" << std::endl;
not         std::cout << "T_NOT" << std::endl;
div         std::cout << "T_DIV" << std::endl; 
mod         std::cout << "T_MOD" << std::endl;
"("         std::cout << "T_OPEN" << std::endl;
")"         std::cout << "T_CLOSE" << std::endl;

true        std::cout << "T_TRUE" << std::endl;
false       std::cout << "T_FALSE" << std::endl;

"#".*\n    // nothing to do


{ID_PREFIX}({EVEN_SUFFIX}|{ODD_SUFFIX})?   std::cout << "T_ID" << std::endl;
{BINARY_PREFIX}{BINARY_SUFFIX} {
    std::cout << "T_BINARY" << std::endl;
}
{BINARY_PREFIX}{DIGIT}* {
    std::cerr << "Line " << lineno() << ": Invalid binary literal." << std::endl;
    exit(1);
}
{OCTAL_PREFIX}{OCTAL_SUFFIX} {
    std::cout << "T_OCTAL" << std::endl;
}
{OCTAL_PREFIX}{DIGIT}* {
    std::cerr << "Line " << lineno() << ": Invalid octal literal." << std::endl;
    exit(1);
}
{HEXAL_PREFIX}{HEXAL_SUFFIX} {
    std::cout << "T_HEXAL" << std::endl;
}
{HEXAL_PREFIX}[0-9a-zA-Z]* {
    std::cerr << "Line " << lineno() << ": Invalid hexal literal." << std::endl;
    exit(1);
}
{BASE14_PREFIX}{BASE14_SUFFIX} {
    std::cout << "T_BASE14" << std::endl;
}
{BASE14_PREFIX}[0-9a-zA-Z]* {
    std::cerr << "Line " << lineno() << ": Invalid base-14 literal." << std::endl;
    exit(1);
}
{BASE60_PREFIX}{BASE60_DIGIT}+ {
    std::cout << "T_BASE60" << std::endl;
}
{BASE60_PREFIX}{DIGIT}* {
    std::cerr << "Line " << lineno() << ": Invalid base-60 literal." << std::endl;
    exit(1);
}
{DIGIT}+	                               std::cout << "T_NUM" << std::endl;
"/*"([^*]|"*"+[^*/])*"*"+"/"      {}
\"([^"][^"][^"])+\"                                                std::cout << "T_STRING" << std::endl;
(2[2-9]|[3-9][0-9])-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])       std::cout << "T_DATE" << std::endl;
{DIGIT}{DIGIT}-{DIGIT}{DIGIT}-{DIGIT}{DIGIT} {
    std::cerr << "Line " << lineno() << ": Invalid date literal." << std::endl;
    exit(1);
}


{WS}+   // nothing to do

. {
    std::cerr << "Line " << lineno() << ": Lexical error." << std::endl;
    exit(1);
}

%%
