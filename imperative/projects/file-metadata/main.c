#include <stdio.h>
#include <stdlib.h>

#include "utils.h"

int main()
{
    // declare filename
    string filename;

    // get filename as input
    scanf("%s", &filename);

    // checking the file in read mode
    FILE* fp = fopen(filename, "r");

    // Check whether file exists
    if (fp == NULL)
    {
        printf("Failed to open file");
        exit(EXIT_FAILURE);
    }

    fseek(fp, 0L, SEEK_END);

    long int size = ftell(fp); // Get the size of the file

    printf("Size of %s is %d bytes", filename, size); // Print the size of the file

    fclose(fp);

    return 0;
}