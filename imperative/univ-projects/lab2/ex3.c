/*
Create a program in which you divide two numbers. Print the result. What happens if the divisor is 0? What happens if we use int or float variables?
Use %f formatting character. Print the result with two decimals.
Use %d formatting character. Check what happens.
Use -W, -Wall, -Wextra and -pedantic flags. Does it result a compilation error when a wrong formatting character is used?

*/

#include <stdio.h>

int main() {
    // Declare two integer variables

    int a = 10;
    int b = 2;

    // Declare a float variable
    float c = 5.0;
    float d = 0.0;

    // Calculate the division of two numbers
    float division = a / d;

    printf("The division of %d and %d is: %.1f\n", a, b, division); // Prints the division of two numbers

    return 0;
}