def is_operand(A):
    return A.isalnum()

def precedence(operator):
    if operator == "^":
        return 3
    
    elif operator in ("*", "/"):
        return 2
    
    elif operator in ("+", "-"):
        return 1
    
    return 0

def infix_to_postfix(expression):
    stack = []
    output = []

    for char in expression:
        if is_operand(char):
            output.append(char)

        elif char == "(":
            stack.append(char)

        elif char == ")":
            while stack and stack[-1] != "(":
                output.append(stack.pop())

            stack.pop()

        else:
            while (stack and stack[-1] != '(' and
                   (precedence(stack[-1]) > precedence(char) or
                   (precedence(stack[-1]) == precedence(char) and char != '^'))):
                output.append(stack.pop())

            stack.append(char)

    while stack:
        output.append(stack.pop())

    return ''.join(output)


print(infix_to_postfix("A+B-C"))