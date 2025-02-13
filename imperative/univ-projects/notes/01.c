#include <stdio.h>

int main() {
    int x = 10;

    int* ptr1 = &x;
    int* ptr2 = &x;
    int* ptr3 = &x;

    int** ptp1 = &ptr1;
    int*** ptp2 = &ptp1;

    ** ptp1 = 20;
    
    printf("x=%d\n", x);
    printf("ptr1=%d", *ptr1);

    return 0;
}