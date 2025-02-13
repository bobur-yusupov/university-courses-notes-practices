/*
Pointers used to store memory location of a variable
*/

#include <iostream>

int main() {
    int number = 4;

    int* ptr = &number;

    std::cout << ptr;

    return 0;
}