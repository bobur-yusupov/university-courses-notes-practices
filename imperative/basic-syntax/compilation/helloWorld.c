#include <stdio.h>

int main() {
    int n = 5;

    int* p = &n;

    int *p2 = p++;

    printf("p = %d\n", *p2);
}