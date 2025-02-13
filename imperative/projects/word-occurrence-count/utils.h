#ifndef UTILS_H
#define UTILS_H

#define MAX_WORD_LENGTH 100

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct
{
    char *word;
    unsigned int occurrence;
} word_t;

typedef struct
{
    word_t* words;
    int capacity;
    int size;
} words_array;

void init_array(words_array* array);

void to_lowercase(char *word);

char* clean_word(char* word, char* result);

word_t* add_word(words_array* array, char* word);

void free_array(words_array* array);

int compare_by_occurrence(const void* a, const void* b);

int compare_alphabetically(const void* a, const void* b);

#endif