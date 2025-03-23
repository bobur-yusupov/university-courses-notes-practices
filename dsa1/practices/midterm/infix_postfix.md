# Infix, Prefix and Postfix Expressions

## Examples

### Example 1

Infix: A + B
Prefix: + A B
Postfix: A B +

### Example 2

Infix: (A + B) * C
Postfix:

1) Since Parenthesis `()` has higher power than `*` we A + B => A B+
2) Then final result is A B + C*

Prefix:

1) \(A + B => + A B\)
2) \(* + A  B C\)

### Example 3

Infix: \(A + B * (C - D) / E\)

Postfix:

Parenthesis has the highest power

1) \(C - D => C D -\)
2) \(B*(CD-) => BCD-*\)
3) \((BCD-*) / E => BCD-* E /\)
4) \(A + BCD-*E / => A BCD-*E/+\)

Postfix: \(A BCD-*E/+\)

Prefix:

1) \(C - D => -CD\)
2) \(B*(-CD) =>*B-CD\)
3) \((*B-CD)/E => /*B-CDE\)
4) \(A + /*B-CDE => +A /*B-CDE\)

### Example 4

\A+B*C^D-E = ABCD^+E-
