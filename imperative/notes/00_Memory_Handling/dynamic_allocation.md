# Dynamic Memory Allocation

Dynamic memory allocation refers to the process of allocating memory at runtime rather than compile time. It offers manual manipulation of memory management. We can resize, free and request memory as needed during execution time of program.

Here is the list of specific functions for flexibily using memory:

1. `malloc()`
2. `calloc()`
3. `realloc()`
4. `free()`

Here are the sample uses of each function:

1. `malloc()` Manual memory allocation

```c
#include <stdio.h>
#include <stdlib.h>

int main() {
    int n;

    printf("Enter the number of elements: ");
    scanf("%d", &n);

    int *arr = (int *)malloc(n * sizeof(int)); // Manually allocate memory

    if (arr == NULL) {
        printf("Memory allocation failed");
        return 1;
    }

    for (int i = 0; i < n; i++) {
        arr[i] = i * 2;
        printf("%d ", i, arr[i]);
    }

    free(arr); // Free up memory

    return 0;

}
```

You can find another example related to dynamic array through [here](./examples/dynamic_array.c)
