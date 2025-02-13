#include <stdio.h>

int main() {
    int x = 10;


    printf("value of x is %d\n", x);

    int* ptr = &x;

    printf("Value of x is %d\n", *ptr);
}