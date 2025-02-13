/*
Create a program where you compute the area of a square and a circle. Get the length of the square and the radius of the circle from the user.
Use the function scanf("%f", &a). Use the operator & which returns the address of a variable. The value of pi should be 3.1415.
*/

#include <stdio.h>

int main() {
    // Declare a float variable for the length of the square
    float length;

    // Declare a float variable for the radius of the circle
    float radius;

    // Declare a float variable for the area of the square
    float square_area;

    // Declare a float variable for the area of the circle
    float circle_area;

    // Get the length of the square from the user
    printf("Enter the length of the square: ");
    scanf("%f", &length);

    // Ge the radius of the circle from the user

    printf("Enter the radius of the circle: ");
    scanf("%f", &radius);

    // Calculate the area of the square
    square_area = length * length;

    // Calculate the area of the circle

    circle_area = 3.1415 * radius * radius;

    // Print the area of the square
    printf("Area of a square is %.2f\n", square_area);
    
    // Print the area of the circle
    printf("Area of a circle is %.2f\n", circle_area);
}