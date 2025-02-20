package studentgradingtest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;

import studentgrading.Student;
import studentgrading.StudentGradingSystem;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentClassTest {
    private Student student1;
    private Student student2;
    private Student student3;

    private StudentGradingSystem gradingSystem;

    @BeforeEach
    public void setUp() {
        student1 = new Student("Alice", 20);
        student2 = new Student("Bob", 21);

        student1.setNewStudentGrades(List.of(95.0, 87.5, 91.0));
        student2.setNewStudentGrades(List.of(78.0, 80.0, 85.0));

        List<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);

        gradingSystem = new StudentGradingSystem(students);
    }

    @Test
    public void testAddStudent() {
        // Add a new student and verify
        Student student3 = new Student("Charlie", 22);
        gradingSystem.addStudent(student3);
        assertEquals(3, gradingSystem.getStudents().size());
        assertTrue(gradingSystem.getStudents().contains(student3));
    }
}
