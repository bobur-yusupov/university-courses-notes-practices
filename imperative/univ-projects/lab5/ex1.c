// Change the value of a variable via pointer

#include <stdio.h>

int main() {
    int a = 5;

    int* ptr;

    ptr = &a;

    printf("%d\n", a);

    *ptr = 20;

    printf("%d\n", a);

    return 0;
}