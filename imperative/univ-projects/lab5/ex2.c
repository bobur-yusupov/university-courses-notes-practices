// Change the value of a pointer through a pointer to a pointer. Then change the value pointed by the pointed pointer as well!

#include <stdio.h>

int main() {
    int x = 10;
    int *ptr = &x;
    int **pptr = &ptr;

    printf("%d\n", x);
    printf("%d\n", *ptr);
    printf("%d\n", **pptr);

    *pptr = NULL;

    printf("%d\n", x);
    printf("%p\n", (void *)ptr);
    printf("%d\n", (void **)pptr);

    return 0;
}