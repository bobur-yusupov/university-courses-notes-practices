#include <stdio.h>

int main(int argc, char** argv) {
    int n = 0;

int a = 2;

int* p = &n;

*p = a = 4 - n;

    printf("%d\n",n);

    return 0;
}