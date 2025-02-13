// Static variables

#include <iostream>

void addOne() {
    static int number = 1; // Assign static variable
    int num = 1; // Assign local variable

    std::cout << "Static: " << number << std::endl;
    std::cout << "Local: " << num << std::endl;

    number++; // Increase static variable for one
    num++; // Increase local variable for one
}

int main() {
    // Call functions
    addOne(); 
    addOne();
    addOne();

    return 0;
}