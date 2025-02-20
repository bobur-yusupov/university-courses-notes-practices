package studentgrading;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creating students
        Student student1 = new Student("Alice", 20);
        Student student2 = new Student("Bob", 21);

        // Creating a list to store students
        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        // Creating the grading system
        StudentGradingSystem system = new StudentGradingSystem(students);

        // Set grades for the students
        student1.setNewStudentGrades(List.of(95.0, 87.5, 91.0)); // Correct way to set grades
        student2.setNewStudentGrades(List.of(78.0, 80.0, 85.0));

        // Add students to the system
        system.addStudent(student1);
        system.addStudent(student2);

        // Calculate and display average grades
        System.out.println(student1.getStudentName() + " Average Grade: " + student1.calculateAverage());
        System.out.println(student2.getStudentName() + " Average Grade: " + student2.calculateAverage());

        // Display top student
        Student topStudent = system.getTopStudent();
        System.out.println("Top Student: " + topStudent.getStudentName());
    }
}
