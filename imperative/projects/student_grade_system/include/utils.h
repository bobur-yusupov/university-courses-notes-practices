#ifndef UTILS_H
#define UTILS_H

#include <stdio.h>

// Error Types
/**
 * @brief Enumeration of error codes used in the student grade system.
 */
typedef enum
{
    SUCCESS = 0,
    ERR_MEMORY_ALLOCATION = 1,
    ERR_INVALID_INPUT = 2,
    ERR_STUDENT_NOT_FOUND = 3,
    ERR_FILE_IO = 4,
} error_code;

/**
 * @brief Logs an error message to the standard error output.
 *
 * @param message The error message to log.
 * @param code The error code indicating the type of error.
 */
void log_error(const char *message, error_code code);

// Calculate Average Grade
/**
 * @brief Calculates the average grade from an array of grades.
 *
 * @param grades The array of grades.
 * @param length The number of grades in the array.
 * @return The average grade as a float.
 */
float average_grade(int grades[], int length);

#endif