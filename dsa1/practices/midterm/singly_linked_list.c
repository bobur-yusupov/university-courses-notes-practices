#include <stdio.h>
#include <stdlib.h>

// create struct for node of Singly Linked List
typedef struct Node {
    int data;
    struct Node* next;
} node_t;

node_t* createNewNode(int data, node_t* next) {
    node_t* newNode = (node_t*)malloc(sizeof(node_t));

    newNode->data = data;
    newNode->next = next;

    return newNode;
}

void appendNode(node_t* head, int data) {
    node_t* current = head;
    node_t* newNode = (node_t*)malloc(sizeof(node_t));
    newNode->data = data;
    newNode->next = NULL;

    // Traverse the linked list
    while (current->next != NULL)
    {
        current=current->next;
    }

    current->next = newNode;
}

node_t* insertAt(node_t* head, int data, int position) {
    // Handle invalid cases
    if (position < 1) {
        return head;
    }

    // inserting to beginning
    if (position == 1) {
        node_t* newNode = createNewNode(data, NULL);
        newNode->next = head;
        return newNode;
    }

    node_t* current = head;

    // Traverse the linked list to the node that is present just before the node
    for (int i = 0; i < position - 1 && current != NULL; i++) {
        current = current -> next;
    }

    if (current == NULL) {
        return head;
    }

    node_t* newNode = createNewNode(data, NULL);
    newNode->next = current->next;
    current->next = newNode;

    return head;
}

node_t* deleteLast(node_t* head) {
    node_t* current = head;

    if (head == NULL) {
        exit(-1);
    }

    if (head->next == NULL) {
        free(head);
        exit(-1);
    }

    while (current->next != NULL && current->next->next != NULL)
    {
        current = current->next;
    }

    node_t* temp = current->next;
    current->next = NULL;
    free(temp);

    return head;
}

node_t* deleteAt(node_t* head, int position) {
    if (position < 1) {
        printf("Linked list starts from 1. Position should be greater or equal to 1.");
        exit(-1);
    }

    if (position == 1) {
        node_t* temp = head;
        head = head->next;

        free(temp);

        return head;
    }

    node_t* current = head;

    for (int i = 1; i < position - 1; i++) {
        current = current->next;
    }

    node_t* temp = current->next;
    current->next = current->next->next;

    free(temp);

    return head;
}

int main() {
    node_t* head = createNewNode(1, NULL);

    for (int i = 2; i < 100; i++) {
        appendNode(head, i);
    }

    node_t* current = head;

    while (current != NULL) {
        printf("%d->", current->data);
        current = current->next;
    }
    printf("\n");

    // insertAt(head, 5, 5);

    // for (int i = 2; i < 100; i++) {
    //     deleteLast(head);
    // }

    // node_t* current1 = head;

    // while (current1 != NULL) {
    //     printf("%d->", current1->data);
    //     current1 = current1->next;
    // }
    
    deleteLast(head);
    deleteAt(head, 49);

    node_t* current1 = head;

    while (current1 != NULL) {
        printf("%d->", current1->data);
        current1 = current1->next;
    }

    return 0;
}