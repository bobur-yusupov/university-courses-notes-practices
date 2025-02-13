#include <stdio.h>
#include <stdlib.h>

#include "include/student.h"

student_t* root_student;

void program_info() {
    printf("\n");
    printf("Student Grade System\n");
    printf("--------------------\n");
    printf("This program allows you to manage student grades.\n");

    printf("Developed by: Bobur Yusupov.\n");
}

void display_info() {
    printf("\n");
    printf("Student Grade System\n");
    printf("--------------------\n");

    printf("1. Add Student\n");
    printf("2. Add Grade\n");
    printf("3. Show Average Grade\n");
    printf("4. Display Student Info\n");
    printf("5. Student List\n");
    printf("6. Exit\n");

    printf("Enter your choice: ");
}

int main() {
    program_info();

    root_student = (student_t*)malloc(sizeof(student_t)); // Allocate memory for root_student
    init(root_student, "John Doe", 1, (int[]){90, 80, 70, 60}, 4); // Initialize root_student with name "John Doe", ID 1, and grades 90, 80, 70, 60

    int choice;
    int student_id, grade;
    string name;

    while (1)
    {
        display_info();
        scanf("%d", &choice);

        switch (choice)
        {
            case 1: // Add Student
                printf("Enter student name: ");
                scanf("%s", name);
                printf("Enter student ID: ");
                scanf("%d", &student_id);
                
                if (add_student(root_student, name, student_id) == NULL) {
                    printf("Error: Student with provided ID already exists.\n");
                }
                break;

            case 2: // Add Grade
                printf("Enter student ID: ");
                scanf("%d", &student_id);
                printf("Enter grade: ");
                scanf("%d", &grade);
                add_grade(root_student, student_id, grade);
                break;

            case 3: // Show Average Grade
                printf("Enter student ID: ");
                scanf("%d", &student_id);
                printf("Average Grade: %.2f\n", show_average_grade(root_student, student_id));
                break;

            case 4: // Display Student Info
                printf("Enter student ID: ");
                scanf("%d", &student_id);
                display_student_info(root_student, student_id);
                break;

            case 5: // Student List
                list_students(root_student);
                break;

            case 6: // Exit
                free(root_student);
                return 0;

            default:
                printf("Invalid choice. Please try again.\n");
                break;
        }
    }

    return 0;
}