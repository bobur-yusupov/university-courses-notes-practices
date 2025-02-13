#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_LINE_LENGTH 512
#define MAX_FIELD_LENGTH 128

void process_line(const char *line, unsigned int *info_count, unsigned int *warning_count, unsigned int *error_count, int *line_count) {
    // Declare variables inside this function
    char date[MAX_FIELD_LENGTH];
    char time[MAX_FIELD_LENGTH];
    char status[MAX_FIELD_LENGTH];
    char description[MAX_LINE_LENGTH];

    // Parse the line
    if (sscanf(line, "%s %s %s %[^\n]", date, time, status, description) == 4) {
        (*line_count)++; // Increment line count

        if (strcmp(status, "INFO") == 0) {
            (*info_count)++;
        } else if (strcmp(status, "WARNING") == 0) {
            (*warning_count)++;
        } else if (strcmp(status, "ERROR") == 0) {
            printf("Error on date %s time %s. Description: %s\n", date, time, description);
            (*error_count)++;
        } else {
            printf("Unexpected status: %s\n", status);
        }
    } else {
        printf("Error parsing line: %s\n", line);
    }
}

int main() {
    FILE *fp = fopen("log.log", "r");

    if (fp == NULL) {
        perror("Failed to open file");
        exit(EXIT_FAILURE);
    }

    int line_count = 0;
    unsigned int info_count = 0;
    unsigned int warning_count = 0;
    unsigned int error_count = 0;

    char line[MAX_LINE_LENGTH];

    // Read and process the file line by line
    while (fgets(line, sizeof(line), fp)) {
        process_line(line, &info_count, &warning_count, &error_count, &line_count);
    }

    fclose(fp); // Close the file

    // Print summary
    printf("\nLog Summary:\n");
    printf("Total lines processed: %d\n", line_count);
    printf("INFO count: %u\n", info_count);
    printf("WARNING count: %u\n", warning_count);
    printf("ERROR count: %u\n", error_count);

    return 0;
}
