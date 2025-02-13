#include <stdio.h>
#include "my_utils.h"

int main() {
    int num1 = 4, num2 = 5;

    printf("before swap: num1=%d, num2=%d\n", num1, num2);

    swap(&num1, &num2);

    printf("after swap: num1=%d, num2=%d\n", num1, num2);

    printf("The larger number is: %d\n", *larger(&num1, &num2));

}