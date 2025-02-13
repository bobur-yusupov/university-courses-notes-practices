#include <stdio.h>

#define MAX(a, b) ((a) > (b) ? (a) : (b))


int main() {
    int x = 10;
    int y = 12;

    #ifdef DEBUG
        #define DEBUG_PRINTmsg

    int max_value = MAX(x, y);

    printf("%d\n", max_value);

    return 0;
}