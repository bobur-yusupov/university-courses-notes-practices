#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;

    printf("Enter the size of array: ");
    scanf("%d", &n);

    if (n<=0) {
        printf("Please enter positive integer!");

        return 1;
    }

    int *array = (int *)malloc(n * sizeof(int)); // Manual memory allocation. Dynamically handled the size

    if (array == NULL) {
        printf("Memory allocation failed");

        return 1;
    }

    for (int i = 0; i < n; i++) {
        printf("Enter number %d: ", i);
        scanf("%d", &array[i]); // User input
    }

    printf("You entered: ");
    for (int j = 0; j < n; j++) {
        printf("%d ", array[j]);
    }
    printf("\n");

    free(array);

    return 0;
}