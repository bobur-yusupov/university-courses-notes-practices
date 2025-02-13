#include <iostream>

void referenceTest(int &ref) {
    std::cout << "Address of ref in function: " << &ref << std::endl;
}

void valueTest(int val) {
    std::cout << "Address of val inside function: " << &val << std::endl;
}

int main() {
    int num = 10;

    std::cout << "Address of num: " << &num << std::endl;

    referenceTest(num);
    valueTest(num);

    return 0;
}