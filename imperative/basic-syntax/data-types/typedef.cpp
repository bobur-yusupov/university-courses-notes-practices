/*
    Used to create alternative names to existing data types 
*/

#include <iostream>
#include <string>

int main() {
    typedef std::string STRING;
    using String = std::string;

    STRING name = "Bobur";

    std::cout << name;
}