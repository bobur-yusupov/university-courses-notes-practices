/*
Write a program that asks the user for a text of up to 20 characters and makes a copy of it. 
Make sure that the copy only uses as much memory space as is absolutely necessary.
*/

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

int main() {
    char string[21];

    if (fgets(string, 21, stdin) != NULL) {
        int indexOfNewLine = strcspn(string, "\n");
        string[indexOfNewLine] = '\0';
    }

    printf("%s\n", string);

    int len = strlen(string);

    char *copy = (char*)malloc((len + 1) * sizeof(char));

    strcpy(copy, string);

    printf("original %s, copy: %s\n", string, copy);

    free(copy);
}
