#include <stdio.h>

struct Student {
    char id[10];
    double average;
    unsigned short int age;
};

typedef struct Student student_t;

char* getTopStudent(student_t students[], int size) {
    student_t *topStudent = &students[0];

    for (int i = 0; i < size; i++) {
        if (students[i].average > topStudent->average) {
            topStudent = &students[i];
        }
    }

    return topStudent->id;
}

int main() {
    student_t students[5] = {
        {"123456", 8.5, 20},
        {"654321", 7.5, 21},
        {"111111", 9.0, 19},
        {"222222", 6.5, 22},
        {"333333", 5.5, 23}
    };

    int length = sizeof(students) / sizeof(student_t);

    printf("Top student: %s\n", getTopStudent(students, length));
}