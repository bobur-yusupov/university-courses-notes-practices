/*
Function is derived data type, meaning it is built using basic data types like int, float double

Function is also block of code that perform a specific task and improves code readablity
*/

#include <iostream>

int func() {
    int num = 0;

    num ++;

    return num;
}

int main() {
    std::cout << func();

    return 0;
}