#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "utils.h"


void initialize(LibraryInventory *inventory, int size)
{
    inventory->books = (Book *)malloc(sizeof(Book) * size);

    if (inventory->books == NULL)
    {
        printf("Failed to allocate memory");
        exit(EXIT_FAILURE);
    }

    inventory->size = size;

    printf("Allocated Successfully!\n");
}

void destroy(LibraryInventory *inventory)
{
    free(inventory->books);
    inventory->size = 0;

    printf("Freed up successfully!\n");
}

void loadFromFile(LibraryInventory *inventory, char *filename)
{
    FILE* fp = fopen(filename, "r");

    if (fp == NULL)
    {
        printf("Failed to open file: %s\n", filename);
        exit(EXIT_FAILURE);
    }

    unsigned int size = 0;

    while (fscanf(fp, "%s %s %f %d %d %d", 
        inventory->books[size].title,
        inventory->books[size].author,
        &inventory->books[size].price,
        &inventory->books[size].borrowed_count,
        &inventory->books[size].available_copies,
        &inventory->books[size].total_copies) == 6)
    {
        size++;
    }

    inventory->size = size;

    printf("%d books loaded.\n", size);

    fclose(fp);
}

bool borrowBook(LibraryInventory *inventory, string title)
{
    for (int i = 0; i < inventory->size; i++)
    {
        if (strcmp(inventory->books[i].title, title) == 0)
        {
            if (inventory->books[i].available_copies == 0)
            {
                printf("Book is NOT available!\n");
                return false;
            }

            inventory->books[i].borrowed_count += 1;
            inventory->books[i].available_copies -= 1;

            printf("Book %s has been borrowed\n", title);

            return true;
        }
    }

    printf("%s is not found in the library\n", title);

    return false;
}

bool returnBook(LibraryInventory *inventory, string title)
{
    for (int i = 0; i < inventory->size; i++)
    {
        if (strcmp(inventory->books[i].title, title) == 0)
        {
            if (inventory->books[i].borrowed_count == 0)
            {
                printf("Book is NOT borrowed!\n");
                return false;
            }

            inventory->books[i].borrowed_count -= 1;
            inventory->books[i].available_copies += 1;

            printf("Book %s has been returned\n", title);

            return true;
        }
    }

    printf("%s is not found in the library\n", title);

    return false;
}


void displayBooks(LibraryInventory *inventory, Category category)
{
    switch (category)
    {
    case MOST_BORROWED:
        displayMostBorrowed(inventory);
        break;
    case AVAILABLE:
        displayAvailable(inventory);
        break;
    case OUT_OF_STOCK:
        displayOutOfStock(inventory);
        break;
    case ALL:
        displayAll(inventory);
        break;
    default:
        printf("Invalid category\n");
        break;
    }
}

void displayAll(LibraryInventory *inventory)
{
    for (int i = 0; i < inventory->size; i++)
    {
        printf("Title: %s ", inventory->books[i].title);
        printf("Author: %s ", inventory->books[i].author);
        printf("Price: %.2f ", inventory->books[i].price);
        printf("Borrowed Count: %d ", inventory->books[i].borrowed_count);
        printf("Available Copies: %d ", inventory->books[i].available_copies);
        printf("Total Copies: %d ", inventory->books[i].total_copies);
        printf("\n");
    }
}

void displayMostBorrowed(LibraryInventory *inventory)
{
    int max = 0;
    int index = 0;

    for (int i = 0; i < inventory->size; i++)
    {
        if (inventory->books[i].borrowed_count > max)
        {
            max = inventory->books[i].borrowed_count;
            index = i;
        }
    }

    printf("Most borrowed book is %s with %d borrows\n", inventory->books[index].title, max);
}

void displayOutOfStock(LibraryInventory *inventory)
{
    for (int i = 0; i < inventory->size; i++)
    {
        if (inventory->books[i].available_copies == 0)
        {
            printf("Book %s is out of stock\n", inventory->books[i].title);
        }
    }
}

void displayAvailable(LibraryInventory *inventory)
{
    for (int i = 0; i < inventory->size; i++)
    {
        if (inventory->books[i].available_copies > 0)
        {
            printf("Book %s is available\n", inventory->books[i].title);
        }
    }
}

void saveToFile(LibraryInventory *inventory, char *filename)
{
    FILE* fp = fopen(filename, "w");

    if (fp == NULL)
    {
        printf("Failed to open file: %s\n", filename);
        exit(EXIT_FAILURE);
    }

    for (int i = 0; i < inventory->size; i++)
    {
        fprintf(fp, "%s %s %.2f %d %d %d\n",
            inventory->books[i].title,
            inventory->books[i].author,
            inventory->books[i].price,
            inventory->books[i].borrowed_count,
            inventory->books[i].available_copies,
            inventory->books[i].total_copies);
    }

    fclose(fp);
}