/*
Double and Float
*/

#include <iostream>
#include <iomanip>

int main() {
    double num1 = 123.456789012345;  // Double precision
    float num2 = 123.456789f;        // Float precision
    
    std::cout << std::setprecision(15);
    std::cout << "Double: " << num1 << std::endl;  // Output: 123.456789012345

    std::cout << std::setprecision(7);
    std::cout << "Float: " << num2 << std::endl;   // Output: 123.456787

    return 0;
}
