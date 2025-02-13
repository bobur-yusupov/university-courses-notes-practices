# Pointers

The main task of pointer is not storing data, but storing address of a variable.

C code

```c
#include <stdio.h>

int main() {
    int x = 10;


    printf("value of x is %d\n", x);

    int* ptr = &x;

    *ptr = 20;

    printf("Value of ptr is %d\n", ptr);
}

```

Output

```text
value of x is 10
Value of ptr is 6422036
```

`6422036` is the location of `x` in *memory*

## Printing value of pointed variable

```c
#include <stdio.h>

int main() {
    int x = 10;


    printf("value of x is %d\n", x);

    int* ptr = &x;

    printf("Value of x is %d\n", *ptr);
}
```

Output

```text
value of x is 10
Value of x is 10
```

Because we are pointing directly to unchanged value of `x` in memory.

## Changing value

We can change value of pointed variable as shown in the following code

```c
#include <stdio.h>

int main() {
    int x = 10;

    int* ptr1 = &x;
    int* ptr2 = &x;
    int* ptr3 = &x;

    int** ptp1 = &ptr1;
    int*** ptp2 = &ptp1;

    ** ptp1 = 20;
    
    printf("x=%d\n", x);
    printf("ptr1=%d", *ptr1);

    return 0;
}
```
