/**
 * @file student.c
 * @brief Student functions for the student grade system project.
 * 
 * This file contains the implementation of the student functions for the 
 * student grade system project.
 */

#include <stdio.h>
#include <stdlib.h>

#include "student.h"
#include "utils.h"

/**
 * @brief Initializes a student with the provided information.
 * 
 * This function initializes a root student with the provided name, ID, grades, and length.
 * The root function plays the role of the head of the linked list of students.
 * 
 * @param root_student The pointer to the root student in memory.
 * @param name The name of the student.
 * @param ID The ID of the student.
 * @param grades The array of grades for the student.
 * @param length The number of grades in the array.
 * @return void
 */
void init(student_t* root_student, string name, int student_id, int grades[], int num_grades) {
    snprintf(root_student->name, sizeof(root_student->name), "%s", name);
    root_student->ID = student_id;
    root_student->next = NULL;
    root_student->num_grades = num_grades;
    root_student->capacity = 5;
    root_student->grades = (int*)malloc(root_student->capacity * sizeof(int));
    
    for (int i = 0; i < num_grades; i++) {
        root_student->grades[i] = grades[i];
    }
}

/**
 * @brief Lists all students in the linked list.
 * 
 * This function lists all students in the linked list of students.
 * 
 * @param root The pointer to the root student in memory.
 * @return void
 */
void list_students(student_t* root_student)
{
    student_t* current_student = root_student;
    printf("Students:\n");
    printf("---------\n");
    while (current_student != NULL)
    {
        printf("Name: %s\n", current_student->name); // Add newline after each student's name
        printf("ID: %d\n", current_student->ID); // Add newline after each student's ID
        printf("Average Grade: %.2f\n", average_grade(current_student->grades, current_student->num_grades)); // Add newline after each student's average grade
        printf("\n");
        current_student = current_student->next;
    }
}

/**
 * @brief Adds a student to the linked list.
 * 
 * This function adds a student to the linked list of students.
 * 
 * @param root The pointer to the root student in memory.
 * @param name The name of the student.
 * @param ID The ID of the student.
 * @return The pointer to the newly added student.
 */
student_t* add_student(student_t* root_student, string name, int student_id)
{
    student_t* current_student = root_student;

    while (current_student != NULL)
    {
        if (current_student->ID == student_id)
        {
            log_error("Student with provided ID already exists.", ERR_INVALID_INPUT);
            return NULL; // Return NULL to indicate failure
        }

        if (current_student->next == NULL)
            break;

        current_student = current_student->next;
    }

    student_t* new_student = (student_t*)malloc(sizeof(student_t));

    snprintf(new_student->name, sizeof(new_student->name), "%s", name);
    new_student->ID = student_id;
    new_student->next = NULL;
    new_student->num_grades = 0;
    new_student->capacity = 5;
    new_student->grades = (int*)malloc(new_student->capacity * sizeof(int));

    current_student->next = new_student;

    return new_student;
}

/**
 * @brief Modifies a student's name with the provided ID.
 * 
 * This function modifies a student's name with the provided ID.
 * 
 * @param root The pointer to the root student in memory.
 * @param ID The ID of the student.
 * @param new_name The new name of the student.
 * @return void
 */
void modify_student(student_t* root, int student_id, string new_name) {
    student_t* current_student = root;

    while (current_student != NULL)
    {
        if (current_student->ID == student_id)
        {
            snprintf(current_student->name, sizeof(current_student->name), "%s", new_name);
            
            log_error("Student name successfully modified.", SUCCESS);
        }

        current_student = current_student->next;
    }

    log_error("Student not found.", ERR_STUDENT_NOT_FOUND);
}

/**
 * @brief Adds a grade to a student with the provided student ID.
 * 
 * This function adds a grade to array of grades of a student with the provided ID.
 * 
 * @param root The pointer to the root student in memory.
 * @param ID The ID of the student.
 * @param grade The grade to add.
 * @return void
 */
void add_grade(student_t* root, int student_id, int grade) {
    student_t* current_student = root;

    while (current_student != NULL)
    {
        if (current_student->ID == student_id)
        {
            if (current_student->num_grades < current_student->capacity)
            {
                current_student->grades[current_student->num_grades] = grade;
                current_student->num_grades++;
            }
            else
            {
                current_student->capacity += 5;
                current_student->grades = (int*)realloc(current_student->grades, current_student->capacity * sizeof(int));
                current_student->grades[current_student->num_grades] = grade;
                current_student->num_grades++;
            }

            log_error("Grade successfully added.", SUCCESS);

            return;
        }

        current_student = current_student->next;
    }

    log_error("Student with provided ID could not found.", ERR_STUDENT_NOT_FOUND);
}

/**
 * @brief Shows the average grade of a student with the provided student ID.
 * 
 * This function shows the average grade of a student with the provided student ID.
 * 
 * @param root The pointer to the root student in memory.
 * @param ID The ID of the student.
 * @return The average grade of the student.
 */

float show_average_grade(student_t* root, int student_id) {
    student_t* current_student = root;

    while (current_student != NULL)
    {
        if (current_student->ID == student_id)
        {
            return average_grade(current_student->grades, current_student->num_grades);
        }

        current_student = current_student->next;
    }
    
    log_error("Student with provided ID could not found.", ERR_STUDENT_NOT_FOUND);

    return 0.0f;
}

/**
 * @brief Displays the information of a student with the provided student ID.
 * 
 * This function displays the information of a student with the provided student ID.
 * 
 * @param root The pointer to the root student in memory.
 * @param ID The ID of the student.
 * @return void
 */
void display_student_info(student_t* root, int student_id) {
    student_t* current_student = root;

    while (current_student != NULL)
    {
        if (current_student->ID == student_id)
        {
            printf("Name: %s\n", current_student->name);
            printf("ID: %d\n", current_student->ID);
            printf("Grades: ");
            for (int i = 0; i < current_student->num_grades; i++)
            {
                printf("%d, ", current_student->grades[i]);
            }
            printf("\n");
            printf("Average Grade: %.2f\n", average_grade(current_student->grades, current_student->num_grades));
            return;
        }

        current_student = current_student->next;
    }

    log_error("Student with provided ID could not found.", ERR_STUDENT_NOT_FOUND);
}