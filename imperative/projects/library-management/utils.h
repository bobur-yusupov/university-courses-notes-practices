#ifndef UTILS_H
#define UTILS_H

#include <stdbool.h>

typedef char string[128];

typedef struct
{
    string title;
    string author;
    float price;
    int borrowed_count;
    int available_copies;
    int total_copies;
} Book;

typedef struct
{
    Book* books;
    int size;
} LibraryInventory;

typedef enum
{
    MOST_BORROWED = 1,
    AVAILABLE = 11,
    OUT_OF_STOCK = 101,
    ALL = 1001
} Category;

/**
 * @breif Initializes the inventory with the given size of books
 * 
 * @param inventory pointer of inventory which should be initialized
 * @param size integer value of the size of the inventory
 */
void initialize(LibraryInventory *inventory, int size);

/**
 * @brief Destroys the inventory and frees memory which was taken for inventory
 * 
 * @param inventory pointer of inventory which should be destroyed
 */
void destroy(LibraryInventory *inventory);

/**
 * @brief loads raw data from file to memory
 * 
 * @param inventory pointer to Library Inventory
 * @param filename is a string parameter which is name of a file which should be opened
 */
void loadFromFile(LibraryInventory *inventory, char *filename);

/**
 * @brief Function allows users to borrow a book
 * 
 * @param inventory pointer to Library Inventory
 * @param title - title of book to borrow
 */

bool borrowBook(LibraryInventory *inventory, string title);

/**
 * @brief Function allows users to return a book
 * 
 * @param inventory pointer to Library Inventory
 * @param title - title of book to return
 */
bool returnBook(LibraryInventory *inventory, string title);

/**
 * @brief Displays books with the provided parameter
 * 
 * @param inventory pointer to Library Inventory
 * @param category - category to print the book
 */

void displayBooks(LibraryInventory *inventory, Category category);

void displayAll(LibraryInventory *inventory);

void displayMostBorrowed(LibraryInventory *inventory);

void displayAvailable(LibraryInventory *inventory);

void displayOutOfStock(LibraryInventory *inventory);

/**
 * @brief Saves the inventory to a file
 * 
 * @param inventory pointer to Library Inventory
 * @param filename is a string parameter which is name of a file which should be opened
 */
void saveToFile(LibraryInventory *inventory, char *filename);

#endif