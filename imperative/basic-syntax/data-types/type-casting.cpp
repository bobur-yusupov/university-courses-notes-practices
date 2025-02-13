#include <iostream>

/*

int main() {
    int a = 9;

    float sum = (float)a + 0.7;

    std::cout << sum;

    return 0;
}

*/

int main() {
    float a = 6.5;

    int casted = static_cast<int>(a);

    std::cout << a << std::endl;
    std::cout << casted << std::endl;

    return 0;
}