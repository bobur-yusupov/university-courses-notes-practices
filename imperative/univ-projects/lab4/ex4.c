#include <stdio.h>

int main() {
    int arr[5] = { 1, 6, 2, 4, 6};

    int least = 0;

    for (int i = 0; i < 5; i ++) {
        if (arr[i] < least) {
            least = arr[i];
        }
    }

    printf("%d\n", least);
}