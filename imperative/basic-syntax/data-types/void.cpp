/*
Void data type does not return value in functions
*/

#include <iostream>

void greet() {
    std::cout << "Hello, World!";
}

int main() {
    greet();

    return 0;
}