#include <stdio.h>

int variable = 10;

void func(int num, int num2) { // Scope of num and num2 is only inside this function and it is in stack memory
    return num + num2;
}

int main() {
    variable = 20;

    {
        int x2 = 5;

        {   
            // This x3 cannot be accessed from outside this block
            int x3 = 10;
            int x2 = 15; // This x2 is different from the x2 in the parent block

            printf("x3=%d\n", x3);
            printf("x2=%d\n", x2); // It prints the x2 from this block (15) not the x2 from the parent block (5)
        }
    }

    printf("The value of the variable is: %d\n", variable);

    return 0;
}