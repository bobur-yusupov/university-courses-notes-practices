/*
Create a function called reverse() that has a string parameter. The function should reverse the characters of the string locally. 
That is, the function returns the result in the same memory area that it received as a parameter. 
For example, the characters of a palindrome string are not changed in the function.
 */

#include <stdio.h>
#include <string.h>

char* reverse(char* word) {
    int len = strlen(word);
    for (int i = 0; i < len / 2; i++) {
        char temp = word[i];
        word[i] = word[len - i - 1];
        word[len - i - 1] = temp;
    }

    return word;
}

int main() {
    char str[20] = "Hello";

    printf("Original %s\n", str);
    printf("reversed: %s\n", str, reverse(str));
}