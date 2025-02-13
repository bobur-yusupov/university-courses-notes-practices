#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

typedef struct Box box_t;

// Create a Box structure
struct Box
{

    int weight; // Value of element in a stack
    box_t* previous; // Pointer to the previous element

};

box_t* top; // Define a new top variable

void init() { // Initializer function for stack
    top = NULL; // Set top global variable NULL
}

bool isEmpty() { // Function to check stack is empty or not
    if (top == NULL) {
        return true;
    }

    return false;
}

int peek() { // Function to return the first element of the stack
    if (!isEmpty()) {
        return top->weight;
    }
    else {
        return -1; // if stack is empty function returns -1
    }
}

box_t* push(int value) { // Function to create a new instance in the top of the element
    box_t* newItem = (box_t*)malloc(sizeof(box_t)); // Allocate in memory

    // Set values

    newItem->weight = value;
    newItem->previous = top;

    top = newItem;
}

void pop() { // Deletes the first element in the stack
    if (!isEmpty()) {
        box_t* current = top;
        top = top->previous;

        free(current); // Frees up empty memory
    }
}

void copyTop() { // Function to copy the top element and set current one as previous of new one
    if (isEmpty()) {
        return;
    }

    box_t* newTop = (box_t *)malloc(sizeof(box_t));

    newTop->weight = top->weight;
    newTop->previous = top;

    top = newTop;
}

// Implementation

int main() {

    init();

    push(6);
    copyTop();
    pop();

    if (isEmpty())
    {
        printf("Stack is empty!\n");
    } else {
        printf("Stack is not empty\n");
    }

    printf("%d", peek());

    return 0;
}