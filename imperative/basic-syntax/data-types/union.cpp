/*
    Union is a user-defined data type. It is same to struct but it shares same memory location to all variables.
*/

#include <iostream>

union Point {
    int x, y;
};

int main() {
    Point point;

    point.x = 1;

    std::cout << point.y;
}