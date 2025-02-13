/*
    Experiement to see the memory usage of type modifiers
*/

#include <iostream>

int main() {
    int a = 5;
    unsigned int b = 52;

    std::cout << sizeof(a) << std::endl;
    std::cout << sizeof(b) << std::endl;
    std::cout << b << std::endl;
}