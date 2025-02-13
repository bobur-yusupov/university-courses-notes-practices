#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int currentSize;
    int capacity;
    int *data;
} DynamicArray;

void init_array(DynamicArray *array) {
    array->capacity = 5;
    array->currentSize = 0;
    array->data = (int *) malloc(sizeof(int) * array->capacity);
}

void add_element(DynamicArray* array, int elem)
{
    if (array->currentSize == array->capacity)
    {
        array->capacity *= 2;
        array->data = (int *) realloc(array->data, sizeof(int) * array->capacity);
    }

    array->data[array->currentSize++] = elem;
}

int main() {
    DynamicArray* arr = (DynamicArray*) malloc(sizeof(DynamicArray));

    init_array(arr);


    add_element(arr, 50);
    add_element(arr, 30);
    add_element(arr, 40);
    add_element(arr, 20);
    add_element(arr, 10);
    add_element(arr, 80);

    printf("Capacity: %d, Current size: %d\n", arr->capacity, arr->currentSize);
    for (int i = 0; i<arr->capacity; i++) {
        printf("%d\n", arr->data[i]);
    }

    free(arr->data);
    free(arr);

    return 0;
}