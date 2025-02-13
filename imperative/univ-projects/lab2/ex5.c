/*
Create a program which greets your name. Store your name in a variable.
Use the type char[] and %s formatting character. Pay attention on the usage of string type: char name[32].
*/

#include <stdio.h>

typedef char string[32];

int main() {
    // Declare a string variable for the name of the user
    string name;

    // Get the name of the user
    scanf("%s", &name);

    printf("Hello, %s!\n", name);

    return 0;
}