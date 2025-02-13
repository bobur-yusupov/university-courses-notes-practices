#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;

    scanf("%d", &n);

    int *pt1 = (int *)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++) {
        scanf("%d", &pt1[i]);
    }

    for (int i = 0; i < n; i++) {
        printf("%d ", pt1[i]);
    }

    return 0;
}