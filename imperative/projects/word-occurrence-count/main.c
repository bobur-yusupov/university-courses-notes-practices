#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#include "utils.h"

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        fprintf(stderr, "Usage: %s <filename>\n", argv[0]);
        printf("\n");

        exit(EXIT_FAILURE);
    }

    FILE* file = fopen(argv[1], "r");

    if (file == NULL)
    {
        perror("Error opening file\n");
        exit(EXIT_FAILURE);
    }

    words_array* array = (words_array *)malloc(sizeof(words_array));

    if (array == NULL)
    {
        perror("Failed to allocate memory for array");

        exit(EXIT_FAILURE);
    }

    init_array(array);

    char word[MAX_WORD_LENGTH];
    int total_words = 0;

    while (fscanf(file, "%99s", word) == 1)
    {
        char cleaned_word[MAX_WORD_LENGTH] = "";

        clean_word(word, cleaned_word);

        if (strlen(cleaned_word) > 0)
        {
            total_words++;
            add_word(array, cleaned_word);
        }
    }

    fclose(file);

    qsort(array->words, array->size, sizeof(word_t), compare_by_occurrence);

    printf("Words and their occurrences:\n");
    for (int i = 0; i < 5; i++)
    {
        printf("%s: %u\n", array->words[i].word, array->words[i].occurrence);
    }

    free_array(array);

    return 0;
}