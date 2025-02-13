// Declare and define a variable outside the main function. Change its value and write it out!

#include <stdio.h>
int variable = 10; // Declare and define a variable outside the main function
int main() {
    variable = 20; // Change its value
    printf("The value of the variable is: %d\n", variable); // Write it out
    return 0;
}