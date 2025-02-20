# Student Grading Management System

## Overview

The **Student Grading Management System** is a Java project designed to manage student records, including their personal information, grades, and the calculation of their average grade. The system will provide a user-friendly interface to add student records, set and retrieve grades, and calculate the overall performance of students.

## Features

- **Student Management**: Store student details such as name, age, and grades.
- **Grade Management**: Set, update, and retrieve grades for each student.
- **Average Calculation**: Compute the average grade for each student.
- **Validation**: Validate grades to ensure they fall within the valid range (0–100).
- **Exception Handling**: Handle invalid inputs using exceptions.
- **Encapsulation**: Hide sensitive information using getters and setters.

## Class Structure

### 1. `Student` Class
The `Student` class will store information about a student such as their name, age, and grades.

#### Fields:
- `String name` - The name of the student.
- `int age` - The age of the student.
- `double[] grades` - An array that holds the student's grades.

#### Methods:
- **Constructors**:
  - `Student(String name, int age)` - Initializes a new student with a name and age.
  - `Student(String name, int age, double[] grades)` - Initializes a student with name, age, and grades.

- **Setters and Getters**:
  - `setName(String name)` - Sets the student's name.
  - `getName()` - Gets the student's name.
  - `setAge(int age)` - Sets the student's age.
  - `getAge()` - Gets the student's age.
  - `setGrades(double[] grades)` - Sets the student's grades.
  - `getGrades()` - Gets the student's grades.

- **Methods**:
  - `setGrade(int index, double grade)` - Sets a specific grade for the student.
  - `getGrade(int index)` - Gets a specific grade.
  - `calculateAverage()` - Calculates the average grade of the student.

### 2. `StudentGradingSystem` Class
The `StudentGradingSystem` class is responsible for managing multiple students. It allows adding students, retrieving student data, and calculating their average grades.

#### Fields:
- `List<Student> students` - A list that holds all the student records.

#### Methods:
- **Constructors**:
  - `StudentGradingSystem()` - Initializes an empty list of students.

- **Methods**:
  - `addStudent(Student student)` - Adds a new student to the system.
  - `removeStudent(String studentName)` - Removes a student from the system by name.
  - `getStudent(String studentName)` - Retrieves a student based on their name.
  - `getAllStudents()` - Returns a list of all students.
  - `getTopStudent()` - Returns the student with the highest average grade.

### 3. `StudentGradingSystemMain` Class
This class contains the `main` method and serves as the entry point of the program. It interacts with users (either via command line or through a simple UI) to manage student data.

#### Methods:
- **`main(String[] args)`** - The entry point of the program, where you can interact with the user and invoke methods from `Student` and `StudentGradingSystem`.

## Example Usage

```java
public class StudentGradingSystemMain {
    public static void main(String[] args) {
        // Create a grading system instance
        StudentGradingSystem system = new StudentGradingSystem();

        // Create new students
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Bob", 21);

        // Set grades for the students
        student1.setGrades(new double[] {95.0, 87.5, 91.0});
        student2.setGrades(new double[] {78.0, 80.0, 85.0});

        // Add students to the system
        system.addStudent(student1);
        system.addStudent(student2);

        // Calculate and display average grades
        System.out.println(student1.getName() + " Average Grade: " + student1.calculateAverage());
        System.out.println(student2.getName() + " Average Grade: " + student2.calculateAverage());

        // Display top student
        Student topStudent = system.getTopStudent();
        System.out.println("Top Student: " + topStudent.getName());
    }
}
