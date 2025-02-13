#include <stdio.h>

typedef enum Type {
    BACHELOR,
    MASTER,
    PHD
} level_t;

union LevelData {
    int totalCourses;
    double adjustedCreditIndex;
    double highestImpactFactor;
};

struct Student {
    char id[10];
    double average;
    unsigned short int age;
    level_t level;
    union LevelData data;
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
        {"123456", 8.5, 20, BACHELOR, .data.totalCourses = 40},
        {"654321", 7.5, 21, MASTER, .data.adjustedCreditIndex = 4.2},
        {"111111", 9.0, 19, PHD, .data.highestImpactFactor = 3.8},
        {"222222", 6.5, 22, BACHELOR, .data.totalCourses = 35},
        {"333333", 5.5, 23, MASTER, .data.adjustedCreditIndex = 3.5}
    };

    student_t topStudent = students[0];

    int length = sizeof(students) / sizeof(student_t);

    printf("Top student: %s\n", getTopStudent(students, length));


    printf("Memory of Student: %d", sizeof(student_t));
}