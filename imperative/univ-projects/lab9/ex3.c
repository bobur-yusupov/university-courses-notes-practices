// Modify the previous reverse() function so that it does not replace the characters locally, 
// but creates another string and returns with it. Reserve the necessary memory dynamically!
#include <stdio.h>
#include <string.h>
#include <stdlib.h>

char* reverse(char* word) {
    int len = strlen(word);
    char* reversed = (char*)malloc((len + 1) * sizeof(char));

    for (int i = 0; i < len; i++) {
        reversed[i] = word[len - i - 1];
    }

    return reversed;
}

int main() {
    char str[20];

    scanf("%s", str);

    char* reversed = reverse(str);

    printf("Original %s\n", str);
    printf("reversed: %s\n", reversed);

    free(reversed);
}