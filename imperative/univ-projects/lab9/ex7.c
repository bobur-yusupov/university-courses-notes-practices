// Modify the solution of the previous task so that the program no longer asks the user
//  for a command line argument,
// but reads words from the user until the input is not EOF,
//  and then writes them out in reverse order. Use an array.
//  Take care not to create memory garbage.
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
char *reverse(char *str)
{
    int length = strlen(str);
    char *reversed = (char *)malloc((length + 1) * sizeof(char));
    for (int i = 0; i < length; i++)
    {
        reversed[i] = str[length - i - 1];
    }
    reversed[length] = '\0';
    return reversed;
}
int main()
{
    char **words = NULL;
    int count = 0;
    char temp[20];
    while (scanf("%s", temp) != EOF)
    {
        words = (char **)realloc(words, (count + 1) * sizeof(char *));
        // words[count] = (char *)malloc((strlen(temp) + 1) * sizeof(char));
        // strcpy(words[count], temp);
        words[count] = strdup(temp); // Uses Malloc internally
        count++;
    }
    printf("Reveresed words are :\n");
    for (int i = count - 1; i >= 0; --i)
    {
        char *reversedWord = reverse(words[i]);
        printf("%s\n", reversedWord);
        free(reversedWord);
    }
    for (int i = 0; i < count; i++)
    {
        free(words[i]);
    }
    free(words);
}
 