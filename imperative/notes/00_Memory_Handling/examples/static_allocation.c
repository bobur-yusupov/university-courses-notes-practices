#include <stdio.h>

int main() {
    int arr[10]; // Memory is taken for the array.

    for (int i = 0; i < 10; i++) {
        arr[i] = i * 10;
    }

    for (int i = 0; i < 10; i++) {
        printf("%d ", arr[i]);
    }
}