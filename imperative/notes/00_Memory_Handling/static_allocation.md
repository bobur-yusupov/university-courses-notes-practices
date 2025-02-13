# Static Memory allocation

Static memory allocation is allocating memory for variables during compile time, and the memory is taken for entire program execution time.

For example

```c
int main() {
    int a = 5;

    return 0;
}
```

in the code above we declared variable `a` and assigned `5` as its value. When we run the code a constant memory block will be splitted for `a` and remains during program runtime.Therefore, we need to know memory requirements before. As static memory allocation is fixed and won't be changed, it results to better _performance_ rather than dynamic allocation.

Another clearer example for static memory allocation:

```c
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

```

At the end we get

```text
0 10 20 30 40 50 60 70 80 90
```

Compiler delared `20 bytes` for `arr` which will be required for program execution. You can see the C code by clicking the [link](./examples/static_allocation.c)
