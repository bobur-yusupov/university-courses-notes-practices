#include <stdio.h>

int main() {
    int arr[5] = { 1, 6, 2, 4, 6};

    int sum = 0;

    for (int i = 0; i < 5; i ++) {
        sum += arr[i];
    }

    printf("%d\n", sum);
}