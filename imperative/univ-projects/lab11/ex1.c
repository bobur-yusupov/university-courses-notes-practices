#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

typedef struct Box {
    int weight;
    struct Box* previous;
} Box;

Box* topBox;

void init() {
    topBox = NULL;
}

bool isEmpty() {
    return topBox == NULL;
}

int peek() {
    if (isEmpty()) {
        return -1;
    }
    return topBox->weight;
}

void push(int weight) {
    Box* newBox = (Box*) malloc(sizeof(Box));
    newBox->weight = weight;
    newBox->previous = topBox;
    topBox = newBox;
}

void pop() {
    if (!isEmpty()) {
        Box* tempBox = topBox;
        topBox = topBox->previous;
        free(tempBox);
    }
}

int main() {
    init();

    push(5);
    push(10);
    push(15);

    printf("Top box weight: %d\n", peek());  // This should print 15

    pop();
    printf("Top box weight after pop: %d\n", peek());  // This should print 10

    pop();
    printf("Top box weight after another pop: %d\n", peek());  // This should print 5

    pop();
    printf("Top box weight after final pop: %d\n", peek());  // This should print -1, as the stack is empty

    return 0;
}
