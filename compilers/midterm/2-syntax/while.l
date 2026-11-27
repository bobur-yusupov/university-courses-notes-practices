%option noyywrap c++ yylineno

%{
#include <iostream>
#include <stdlib.h>
#include "Parserbase.h"
%}

DIGIT  		[0-9]
WS          [ \t\n]
LETTER      [a-zA-Z]
LITERAL     [a-zA-Z0-9]
OCTET       (25[0-5]|2[0-4][0-9]|1[0-9]{2}|[1-9]?[0-9])
H       [0-9a-fA-F]{1,4}
IPV4        {OCTET}(\.{OCTET}){3}
IPV6        ({H}(:{H}){7}|"::"({H}(:{H}){0,6})?|{H}"::"({H}(:{H}){0,5})?|{H}(:{H}){1}"::"({H}(:{H}){0,4})?|{H}(:{H}){2}"::"({H}(:{H}){0,3})?|{H}(:{H}){3}"::"({H}(:{H}){0,2})?|{H}(:{H}){4}"::"({H}(:{H}){0,1})?|{H}(:{H}){5}"::"{H}?|{H}(:{H}){6}"::")

%%

program     return Parser::T_PROGRAM;
begin       return Parser::T_BEGIN;
end         return Parser::T_END;
integer     return Parser::T_INTEGER; 
boolean     return Parser::T_BOOLEAN;
skip        return Parser::T_SKIP;
if          return Parser::T_IF;
then        return Parser::T_THEN;
else        return Parser::T_ELSE;
endif       return Parser::T_ENDIF;
while       return Parser::T_WHILE;
do          return Parser::T_DO;
done        return Parser::T_DONE;
read        return Parser::T_READ;
write       return Parser::T_WRITE;
";"         return Parser::T_SEMICOLON;
":="        return Parser::T_ASSIGN;
"="         return Parser::T_EQ;
"<"         return Parser::T_LESS;
">"         return Parser::T_GR;
"+"         return Parser::T_ADD;
"-"         return Parser::T_SUB;
"*"         return Parser::T_MUL;
and         return Parser::T_AND;
or          return Parser::T_OR;
not         return Parser::T_NOT;
div         return Parser::T_DIV; 
mod         return Parser::T_MOD;
"("         return Parser::T_OPEN;
")"         return Parser::T_CLOSE;

{DIGIT}+	return Parser::T_NUM;
true        return Parser::T_TRUE;
false       return Parser::T_FALSE;

address                           return Parser::T_ADDRESS;
\({IPV4}\)"@IPv4"                 return Parser::T_IPV4;
\({IPV6}\)"@IPv6"                 return Parser::T_IPV6;
"."                               return Parser::T_DOT;
version                           return Parser::T_VERSION;
isLoopback                        return Parser::T_ISLOOPBACK;
isPrivate                         return Parser::T_ISPRIVATE;

"#".*\n    // nothing to do

{LETTER}({LETTER}|{DIGIT}|_)*    return Parser::T_ID;

{WS}+   // nothing to do

. {
    std::cerr << "Line " << lineno() << ": Lexical error on token (" << YYText() << ")." << std::endl;
    exit(1);
}

%%
