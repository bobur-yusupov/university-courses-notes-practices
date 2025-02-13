#include <stdio.h>

int main() {
    int arr1[5] = { 1, 6, 2, 4, 6};
    int arr2[5] = { 1, 4, 8, 1, 2};

    int sum = 0;

    for (int i = 0; i < 5; i ++) {
        sum += (arr1[i] * arr2[i]);
    }

    printf("%d\n", sum);
}