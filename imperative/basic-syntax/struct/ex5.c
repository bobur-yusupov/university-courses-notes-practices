/*
Write a function (student_init) which, receiving aType parameter, 
creates a Student instance on the heap with the appropriate Type, 
fills the corresponding data members with random data, and then returns a pointer to the instance. 
Fill an array with pointers to such `Student' instances, 
then modify the function written in task 3 to return a pointer to the instance instead of an identifier. 
Be careful to avoid memory leaks.
*/

#include <stdio.h>
#include <stdlib.h>

typedef enum Type {
    BACHELOR,
    MASTER,
    PHD
} level_t;

// Define a struct Student with the following fields:
typedef struct Student {
    char id[10];
    double average;
    unsigned short int age;
    level_t level;
} student_t;

// student_init function prototype
student_t* student_init(level_t level) {
    student_t* student = (student_t*)malloc(sizeof(student_t));

    // Fill the corresponding data members with random data
    student->average = (double)rand() / RAND_MAX * 100;
    student->age = rand() % 100;
    student->level = level;

    return student;
}
