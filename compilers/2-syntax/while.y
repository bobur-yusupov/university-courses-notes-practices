%baseclass-preinclude <iostream>

%lsp-needed


%token T_PROGRAM T_BEGIN T_END

%token T_INTEGER T_BOOLEAN

%token T_SEMICOLON
%token T_SKIP
%token T_IF T_THEN T_ELSE T_ENDIF
%token T_WHILE T_DO T_DONE
%token T_READ T_WRITE
%token T_ASSIGN

%token T_OPEN T_CLOSE
%token T_TRUE T_FALSE
%token T_NUM
%token T_ID

%token T_DEC
%token T_FOR T_TO
%token T_TIME T_HOUR T_MINUTE T_TIME_LITERAL
%token T_ARRAY T_LBRACKET T_RBRACKET T_LBRACE T_RBRACE T_COMMA
%token T_FUNCTION T_RETURN

%token T_QUESTION_MARK T_DOUBLE_DOT
%token T_PARALLELIZATION T_DUPLICATE T_LIST T_ADDITION_ASSIGNMENT
%token T_DOT

// later line = the operator has higher priority
%left T_SHIFT
%left T_OR T_AND
%left T_EQ
%left T_LESS T_GR
%left T_ADD T_SUB T_INC
%left T_MUL T_DIV T_MOD
%nonassoc T_NOT

%start program

%%

program:
    T_PROGRAM T_ID declarations T_BEGIN statements T_END
    {
        std::cout << "start -> T_PROGRAM T_ID declarations T_BEGIN statements T_END" << std::endl;
    }
;

declarations:
    // empty
    {
        std::cout << "declarations -> (epsilon)" << std::endl;
    }
|
    declaration declarations
    {
        std::cout << "declarations -> declaration declarations" << std::endl;
    }
;

declaration:
    type variables T_SEMICOLON
    {
        std::cout << "declaration -> type variables T_SEMICOLON" << std::endl;
    }
|
    T_INTEGER T_ARRAY T_ID T_LBRACKET T_NUM T_RBRACKET T_SEMICOLON
    {
        std::cout << "declaration -> T_INTEGER T_ARRAY T_ID T_LBRACKET T_NUM T_RBRACKET T_SEMICOLON" << std::endl;
    }
|
    function_declaration
    {
        std::cout << "declaration -> function_declaration" << std::endl;
    }
|
    list_declaration
    {
        std::cout << "declaration -> list_declaration" << std::endl;
    }
|
    tuple_declaration
    {
        std::cout << "declaration -> tuple_declaration" << std::endl;
    }
;

statements:
    statement
    {
        std::cout << "statements -> statement" << std::endl;
    }
|
    statement statements
    {
        std::cout << "statements -> statement statements" << std::endl;
    }
;

statement:
    T_SKIP T_SEMICOLON
    {
        std::cout << "statement -> T_SKIP T_SEMICOLON" << std::endl;
    }
|
    assignment
    {
        std::cout << "statement -> assignment" << std::endl;
    }
|
    read
    {
        std::cout << "statement -> read" << std::endl;
    }
|
    write
    {
        std::cout << "statement -> write" << std::endl;
    }
|
    branch
    {
        std::cout << "statement -> branch" << std::endl;
    }
|
    loop
    {
        std::cout << "statement -> loop" << std::endl;
    }
|
    increment
    {
        std::cout << "statement -> increment" << std::endl;
    }
|
    decrement
    {
        std::cout << "statement -> decrement" << std::endl;
    }
|
    for_loop
    {
        std::cout << "statement -> for_loop" << std::endl;
    }
|
    c_for_loop
    {
        std::cout << "statement -> c_for_loop" << std::endl;
    }
|
    array_initialization
    {
        std::cout << "statement -> array_initialization" << std::endl;
    }
|
    return_statement
    {
        std::cout << "statement -> return_statement" << std::endl;
    }
|
    function_call T_SEMICOLON
    {
        std::cout << "statement -> function T_SEMICOLON" << std::endl;
    }
|
    parallel_statement
    {
        std::cout << "statement -> parallel_statement" << std::endl;
    }
|
    duplicate_statement
    {
        std::cout << "statement -> duplicate_statement" << std::endl;
    }
;

statement_core:
    T_SKIP
|
    assignment_core
|
    increment_core
|
    decrement_core
|
    T_READ T_OPEN T_ID T_CLOSE
|
    T_READ T_OPEN array_access T_CLOSE
|
    T_WRITE T_OPEN expression T_CLOSE
|
    function_call
|
    T_RETURN expression
|
    branch
|
    loop
|
    for_loop
|
    c_for_loop
|
    parallel_core
;

assignment_core:
    T_ID T_ASSIGN expression
|
    array_access T_ASSIGN expression
|
    T_ID T_ADDITION_ASSIGNMENT expression
    {
        std::cout << "assignment_core -> T_ID T_ADDITION_ASSIGNMENT expression" << std::endl;
    }
|
    tuple_access T_ASSIGN expression
    {
        std::cout << "assignment_core -> tuple_access T_ASSIGN expression" << std::endl;
    }
;

assignment:
    assignment_core T_SEMICOLON
    {
        std::cout << "assignment -> assignment_core T_SEMICOLON" << std::endl;
    }
;

read:
    T_READ T_OPEN T_ID T_CLOSE T_SEMICOLON
    {
        std::cout << "read -> T_READ T_OPEN T_ID T_CLOSE T_SEMICOLON" << std::endl;
    }
|
    T_READ T_OPEN array_access T_CLOSE T_SEMICOLON
    {
        std::cout << "read -> T_READ T_OPEN array_access T_CLOSE T_SEMICOLON" << std::endl;
    }
;

write:
    T_WRITE T_OPEN expression T_CLOSE T_SEMICOLON
    {
        std::cout << "write -> T_WRITE T_OPEN expression T_CLOSE T_SEMICOLON" << std::endl;
    }
;

branch:
    T_IF expression block
    {
        std::cout << "branch -> T_IF expression block" << std::endl;
    }
|
    T_IF expression block T_ELSE block
    {
        std::cout << "branch -> T_IF expression block T_ELSE block" << std::endl;
    }
|
    T_IF expression T_THEN statements T_ENDIF
    {
        std::cout << "branch -> T_IF expression T_THEN statements T_ENDIF" << std::endl;
    }
|
    T_IF expression T_THEN statements T_ELSE statements T_ENDIF
    {
        std::cout << "branch -> T_IF expression T_THEN statements T_ELSE statements T_ENDIF" << std::endl;
    }
;

loop:
    T_WHILE expression block
    {
        std::cout << "loop -> T_WHILE expression block" << std::endl;
    }
|
    T_WHILE expression T_DO statements T_DONE
    {
        std::cout << "loop -> T_WHILE expression T_DO statements T_DONE" << std::endl;
    }
;

expression:
    T_NUM
    {
        std::cout << "expression -> T_NUM" << std::endl;
    }
|
    T_TRUE
    {
        std::cout << "expression -> T_TRUE" << std::endl;
    }
|
    T_FALSE
    {
        std::cout << "expression -> T_FALSE" << std::endl;
    }
|
    T_ID
    {
        std::cout << "expression -> T_ID" << std::endl;
    }
|
    expression T_ADD expression
    {
        std::cout << "expression -> expression T_ADD expression" << std::endl;
    }
|
    expression T_SUB expression
    {
        std::cout << "expression -> expression T_SUB expression" << std::endl;
    }
|
    expression T_MUL expression
    {
        std::cout << "expression -> expression T_MUL expression" << std::endl;
    }
|
    expression T_DIV expression
    {
        std::cout << "expression -> expression T_DIV expression" << std::endl;
    }
|
    expression T_MOD expression
    {
        std::cout << "expression -> expression T_MOD expression" << std::endl;
    }
|
    expression T_LESS expression
    {
        std::cout << "expression -> expression T_LESS expression" << std::endl;
    }
|
    expression T_GR expression
    {
        std::cout << "expression -> expression T_GR expression" << std::endl;
    }
|
    expression T_EQ expression
    {
        std::cout << "expression -> expression T_EQ expression" << std::endl;
    }
|
    expression T_AND expression
    {
        std::cout << "expression -> expression T_AND expression" << std::endl;
    }
|
    expression T_OR expression
    {
        std::cout << "expression -> expression T_OR expression" << std::endl;
    }
|
    T_NOT expression
    {
        std::cout << "expression -> T_NOT expression" << std::endl;
    }
|
    T_OPEN expression T_CLOSE
    {
        std::cout << "expression -> T_OPEN expression T_CLOSE" << std::endl;
    }
|
    T_TIME_LITERAL
    {
        std::cout << "expression -> T_TIME_LITERAL" << std::endl;
    }
|
    T_HOUR T_OPEN expression T_CLOSE
    {
        std::cout << "expression -> T_HOUR T_OPEN expression T_CLOSE" << std::endl;
    }
|
    T_MINUTE T_OPEN expression T_CLOSE
    {
        std::cout << "expression -> T_MINUTE T_OPEN expression T_CLOSE" << std::endl;
    }
|
    array_access
    {
        std::cout << "expression -> array_access" << std::endl;
    }
|
    function_call
    {
        std::cout << "expression -> function_call" << std::endl;
    }
|
    expression T_SHIFT expression
    {
        std::cout << "expression -> expression T_SHIFT expression" << std::endl;
    }
|
    T_OPEN expression T_QUESTION_MARK expression T_DOUBLE_DOT expression T_CLOSE
    {
        std::cout << "expression -> T_OPEN expression ? expression : expression T_CLOSE" << std::endl;
    }
|
    T_LBRACKET initializer_values T_RBRACKET
    {
        std::cout << "expression -> T_LBRACKET initializer_values T_RBRACKET" << std::endl;
    }
|
    expression T_INC expression
    {
        std::cout << "expression -> expression T_INC expression" << std::endl;
    }
|
    tuple_access
    {
        std::cout << "expression -> tuple_access" << std::endl;
    }
;

increment_core:
    T_ID T_INC
    |
    T_INC T_ID
;

increment:
    increment_core T_SEMICOLON
;

decrement_core:
    T_ID T_DEC
    |
    T_DEC T_ID
;

decrement:
    decrement_core T_SEMICOLON
;

for_loop:
    T_FOR T_ID T_ASSIGN expression T_TO expression block
;

c_for_loop:
    T_FOR T_OPEN
    assignment_core T_SEMICOLON
    expression T_SEMICOLON
    for_update T_CLOSE
    block
;

for_update:
    increment_core
    |
    decrement_core
    |
    assignment_core
;

block:
    T_BEGIN statements T_END
;

array_access:
    T_ID T_LBRACKET expression T_RBRACKET
;

initializer_values:
    expression
|
    expression T_COMMA initializer_values
;

array_initialization:
    T_ID T_LBRACKET T_RBRACKET T_EQ T_LBRACE initializer_values T_RBRACE T_SEMICOLON
;

type:
    T_INTEGER
    {
        std::cout << "type -> T_INTEGER" << std::endl;
    }
|
    T_BOOLEAN
    {
        std::cout << "type -> T_BOOLEAN" << std::endl;
    }
|
    T_TIME
    {
        std::cout << "type -> T_TIME" << std::endl;
    }
;

parameter:
    type T_ID
;

parameters:
    parameter
|
    parameter T_COMMA parameters
;

optional_parameters:
    /* empty */
|
    parameters
;

function_declaration:
    T_FUNCTION type T_ID T_OPEN optional_parameters T_CLOSE
    declarations block T_SEMICOLON
|
    T_FUNCTION T_ID T_OPEN optional_parameters T_CLOSE
    declarations block T_SEMICOLON
;

return_statement:
    T_RETURN expression T_SEMICOLON
;

arguments:
    expression
|
    expression T_COMMA arguments
;

optional_arguments:
    /* empty */
|
    arguments
;

function_call:
    T_ID T_OPEN optional_arguments T_CLOSE
;

parallel_core:
    T_LBRACKET statement_core T_PARALLELIZATION statement_core T_RBRACKET
    {
        std::cout << "parallel_core -> T_LBRACKET statement_core T_PARALLELIZATION statement_core T_RBRACKET" << std::endl;
    }
;

parallel_statement:
    parallel_core T_SEMICOLON
    {
        std::cout << "parallel_statement -> parallel_core T_SEMICOLON" << std::endl;
    }
;

variable:
    T_ID
    {
        std::cout << "variable -> T_ID" << std::endl;
    }
;

variables:
    variable
|
    variable T_COMMA variables
;

duplicate_statement:
    T_DUPLICATE statement
    {
        std::cout << "duplicate_statement -> T_DUPLICATE statement" << std::endl;
    }
;

list_declaration:
    type T_LIST T_ID T_SEMICOLON
    {
        std::cout << "list_declaration -> type T_LIST T_ID T_SEMICOLON" << std::endl;
    }
;

types:
    type
|
    type T_COMMA types
;

tuple_declaration:
    T_LESS types T_GR T_ID T_SEMICOLON
    {
        std::cout << "tuple_declaration -> T_LESS types T_GR T_ID T_SEMICOLON" << std::endl;
    }
;

tuple_access:
    T_ID T_DOT T_NUM
    {
        std::cout << "tuple_access -> T_ID T_DOT T_NUM" << std::endl;
    }
;
