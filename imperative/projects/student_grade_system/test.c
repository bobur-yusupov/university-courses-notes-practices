#include <stdio.h>
#include <string.h> // Include string.h for strcmp and strstr

#include "testlib/testlib.h"
#include "student.h"

// Test cases
int test_init_student() {
    student_t* student = (student_t*)malloc(sizeof(student_t)); // Allocate memory for root_student
    int grades[] = {90, 80, 70};
    init(student, "John", 101, grades, 3);

    ASSERT_EQUAL(101, student->ID);
    ASSERT_EQUAL(3, student->num_grades);
    ASSERT_EQUAL(90, student->grades[0]);
    ASSERT_EQUAL(80, student->grades[1]);
    ASSERT_EQUAL(70, student->grades[2]);

    free(student);

    return 1; // Test passed
}

int test_add_grade() {
    student_t* student = (student_t*)malloc(sizeof(student_t)); // Allocate memory for root_student
    int grades[] = {80, 85};
    init(student, "Jane", 102, grades, 2);

    add_grade(student, 102, 95);
    ASSERT_EQUAL(3, student->num_grades);
    ASSERT_EQUAL(95, student->grades[2]);

    free(student);

    return 1; // Test passed
}

int test_modify_student() {
    student_t* student = (student_t*)malloc(sizeof(student_t));
    int grades[] = {85, 90};
    init(student, "Alice", 103, grades, 2);

    modify_student(student, 103, "Alicia");
    ASSERT_EQUAL(strcmp(student->name, "Alicia"), 0);

    free(student);

    return 1; // Test passed
}

int test_show_average_grade() {
    student_t* student = (student_t*)malloc(sizeof(student_t));
    int grades[] = {75, 85, 95};
    init(student, "Bob", 104, grades, 3);

    float avg = show_average_grade(student, 104);
    ASSERT_EQUAL(avg, 85.0f);

    free(student);

    return 1; // Test passed
}

// Test runner
int main() {
    test_function_t tests[] = {
        test_init_student, 
        test_add_grade, 
        test_modify_student, 
        test_show_average_grade,
    };
    const char *test_names[] = {
        "test_init_student", 
        "test_add_grade", 
        "test_modify_student", 
        "test_show_average_grade",
    };
    run_tests(tests, test_names, 4);

    return 0;
}
