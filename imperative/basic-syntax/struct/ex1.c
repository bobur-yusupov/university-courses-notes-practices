#include <stdio.h>
#include <string.h>

struct Student {
    char id[10];
    double average;
    unsigned short int age;
};

typedef struct Student student_t;

int main() {
    student_t student1;
    strcpy(student1.id, "123456");
    student1.average = 8.5;
    student1.age = 20;

    printf("Size of student1: %ld\n", sizeof(student1));

    return 0;
}
