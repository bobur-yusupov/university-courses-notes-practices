/**
 * @brief Small testing framework for the student grade system.
 * 
 */
#include <stdio.h>

#include "testlib.h"

void run_tests(test_function_t tests[], const char *test_names[], int num_tests)
{
    for (int i = 0; i < num_tests; i++)
    {
        int result = tests[i]();
        if (result == 1)
        {
            printf("+ ");
        }
        else
        {
            printf("\n- %s\n", test_names[i]);
        }
    }
}