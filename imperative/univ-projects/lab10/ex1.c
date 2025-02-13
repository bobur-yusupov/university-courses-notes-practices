#include <stdio.h>

struct Student
{
    int ID;
    int age;
    double average;
};

typedef struct Student student;

int toStudentID(student students[], int size) {
    if (size <= 0) {
        return NULL;
    }

    int maxStudentID = students[0].ID;
    int maxStudent
}

int main() {
    student s1 = {.age = 10, .ID=1111, .average=4.5};

    student students[5] = {
        {1, 20, 1.5},
        {2, 5, 1.5},
        {3, 10, 1.5},
        {4, 22, 1.5},
        {5, 60, 1.5},
    };

    int length = sizeof(students) / sizeof(student);

    printf("%lu", sizeof(student));

    return 0;
}