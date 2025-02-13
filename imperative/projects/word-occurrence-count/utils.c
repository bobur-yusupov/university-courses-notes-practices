#include <string.h>
#include <ctype.h>

#include "utils.h"

void init_array(words_array* array)
{
    array->capacity = 5;
    array->size = 0;
    array->words = (word_t*)malloc(sizeof(word_t) * array->capacity);
}

void to_lowercase(char *word)
{
    for (int i = 0; word[i]; i++)
    {
        word[i] = tolower(word[i]);
    }
}

char* clean_word(char* word, char* result)
{
    int j = 0;

    for (int i = 0; word[i] != '\0'; i++)
    {
        if(isalpha(word[i]))
        {
            result[j++] = word[i];
        }
    }

    result[j] = '\0';

    to_lowercase(result);

    return result;
}


word_t* add_word(words_array* array, char* word)
{
    if (array->size == array->capacity)
    {
        array->capacity += 5;
        array->words = (word_t *)realloc(array->words, sizeof(word_t)*array->capacity);

        if (array->words == NULL)
        {
            perror("Memory reallocation failed");
            exit(EXIT_FAILURE);
        }
    }


    for (int i = 0; i < array->size; i++)
    {
        if (strcmp(array->words[i].word, word) == 0)
        {
            array->words[i].occurrence += 1;

            return &array->words[i];
        }
    }

    array->words[array->size].word = strdup(word);
    if (array->words[array->size].word == NULL)
    {
        perror("Memory allocation for word failed");
        exit(EXIT_FAILURE);
    }
    array->words[array->size].occurrence = 1;
    array->size ++;

    return &array->words[array->size - 1];
}

void free_array(words_array* array)
{
    for (int i = 0; i < array->size; i++)
    {
        free(array->words[i].word);
    }

    free(array->words);
    free(array);
}

int compare_by_occurrence(const void* a, const void* b)
{
    const word_t* word1 = (const word_t*)a;
    const word_t* word2 = (const word_t*)b;

    if (word1->occurrence < word2->occurrence)
        return 1;
    else if (word1->occurrence > word2->occurrence)
        return -1;
    else
        return 0;
}

int compare_alphabetically(const void* a, const void* b)
{
    const word_t* word1 = (const word_t*)a;
    const word_t* word2 = (const word_t*)b;

    return strcmp(word1->word, word2->word);
}
