#ifndef TEST_H
#define TEST_H

#include <stdio.h>
#include <stdlib.h>

/**
 * @brief Asserts that two integers are equal.
 * 
 * @param expected The expected integer value.
 * @param actual The actual integer value.
 */
#define ASSERT_EQUAL(expected, actual) \
    if (expected != actual) \
    {\
        fprintf(stderr, "Test failed at line %d in %s: expected %d but got %d\n", __LINE__, __FILE__, expected, actual); \
        exit(1); \
    }

/**
 * @brief Asserts that two floating-point numbers are equal.
 * 
 * @param expected The expected floating-point value.
 * @param actual The actual floating-point value.
 */ 
#define ASSERT_NOT_NULL(ptr) \
    if (ptr == NULL) \
    {\
        fprintf(stderr, "Test failed at line %d in %s: expected non-null pointer\n", __LINE__, __FILE__); \
        exit(1); \
    }

/**
 * @brief Asserts that a condition is true.
 * 
 * @param condition The condition to assert.
 */
#define ASSERT_TRUE(condition) \
    if (!condition) \
    {\
        fprintf(stderr, "Test failed at line %d in %s: expected true but got false\n", __LINE__, __FILE__); \
        exit(1); \
    }

// Test Function Type
typedef int (*test_function_t)();

// Test Runner
void run_tests(test_function_t tests[], const char *test_names[], int num_tests);

#endif