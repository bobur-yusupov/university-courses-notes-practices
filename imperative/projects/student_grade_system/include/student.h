#ifndef STUDENT_H
#define STUDENT_H

typedef char string[128];
typedef struct Student student_t;

struct Student
{
    int ID;
    string name;
    int* grades;
    student_t* next;
    int num_grades;
    int capacity;
};

// init student
void init(student_t* root_student, string name, int ID, int grades[], int length);
// list students
void list_students(student_t* root);
// add student
student_t* add_student(student_t* root_student, string name, int student_id);
// modify student with ID
void modify_student(student_t* root, int student_id, string new_name);
// add grade
void add_grade(student_t* root, int student_id, int grade);
// show average grade
float show_average_grade(student_t* root, int student_id);
// display student info
void display_student_info(student_t* root, int student_id);

#endif