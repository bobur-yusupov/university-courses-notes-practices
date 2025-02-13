#include <stdio.h>

typedef char String[];

int wordLength(String word) {
    int length = 0;
    
    while (word[length] != '\0') {
        length ++;
    }

    return length;
}

int main() {
    String word = "Test";

    printf("%d", wordLength(word));

    return 0;
}