/**
 * @file utils.c
 * @brief Utility functions for the student grade system project.
 *
 * This file contains various utility functions used throughout the
 * student grade system project, including error handling mechanisms.
 */

#include <stdio.h>

#include "utils.h"

/**
 * @brief Logs an error message to the standard error output.
 *
 * This function logs an error message based on the provided error code.
 *
 * @param message The error message to log.
 * @param code The error code indicating the type of error.
 */
void log_error(const char *message, error_code code)
{
    switch (code)
    {
    case ERR_MEMORY_ALLOCATION:
        fprintf(stderr, "Memory allocation error: %s\n", message);
        break;
    case ERR_INVALID_INPUT:
        fprintf(stderr, "Invalid input error: %s\n", message);
        break;
    case ERR_STUDENT_NOT_FOUND:
        fprintf(stderr, "Student not found error: %s\n", message);
        break;
    case ERR_FILE_IO:
        fprintf(stderr, "File I/O error: %s\n", message);
        break;
    case SUCCESS:
        fprintf(stderr, "Success: %s\n", message);
        break;
    default:
        fprintf(stderr, "Unknown error: %s\n", message);
        break;
    }
}

// Calculate Average Grade
/**
 * @brief Calculates the average grade from an array of grades.
 *
 * This function takes an array of grades and its length, then calculates
 * and returns the average grade. If the length is zero, it returns 0.0f
 * to avoid division by zero.
 *
 * @param grades The array of grades.
 * @param length The number of grades in the array.
 * @return The average grade as a float.
 */
float average_grade(int grades[], int length)
{
    if (length == 0) {
        return 0.0f; // Avoid division by zero
    }

    int sum = 0;
    
    for (int i = 0; i < length; i++)
    {
        sum += grades[i];
    }

    return (float)sum / (float)length;
}