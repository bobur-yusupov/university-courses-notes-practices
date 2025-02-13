#include <stdio.h>
#include <stdlib.h>

#include "utils.h"

int main()
{
    LibraryInventory inventory;

    initialize(&inventory, 10);

    loadFromFile(&inventory, "books.txt");

    borrowBook(&inventory, "The_Hobbit");

    borrowBook(&inventory, "The_Hobbit");

    returnBook(&inventory, "The_Hobbit");

    saveToFile(&inventory, "books_updated.txt");

    destroy(&inventory);

    return 0;
}