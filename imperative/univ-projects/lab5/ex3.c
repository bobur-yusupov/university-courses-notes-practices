// Can you create a pointer to itself? What would be its type? Why not? 
// Compare the sizes of pointers to different types of variables. Explain why the result is logical!

#include <stdio.h>

int main() {
    int* int_ptr;

    printf("%d", sizeof(int_ptr));

    return 0;
}