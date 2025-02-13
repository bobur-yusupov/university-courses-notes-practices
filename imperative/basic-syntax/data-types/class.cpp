/*

Class is a building block in C++ which contains its own data members and member functions.

these members can be accessed through creating an instance of class

*/

// Example of class

#include <iostream>

class Animal {

// Access specifier
public:
    // Data members
    std::string animalName;

    // Method - Member function()
    void printName() {
        std::cout << "Animal: " << animalName << std::endl;
    }
};

int main() {
    Animal dog; // Initializing Animal class instance

    dog.animalName = "Dog"; // Specifing animalName data member

    dog.printName(); // Calling printName method

    return 0;
}