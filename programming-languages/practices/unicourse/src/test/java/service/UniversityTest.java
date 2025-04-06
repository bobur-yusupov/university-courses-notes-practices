package service;

import model.Course;
import model.Professor;
import model.Student;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class UniversityTest {
    private University university;

    private Student student1;
    private Student student2;
    private Student student3;

    private Course course1;
    private Course course2;
    private Course course3;

    private Professor professor1;
    private Professor professor2;
    private Professor professor3;

    @BeforeEach
    public void setUp() {
        this.university = new University();

        this.student1 = new Student(1, "John", "Doe", "Computer Science");
        this.student2 = new Student(2, "Jane", "Smith", "Mathematics");
        this.student3 = new Student(3, "Alice", "Johnson", "Physics");

        this.course1 = new Course("CS101", "Introduction to Computer Science");
        this.course2 = new Course("MATH101", "Calculus I");
        this.course3 = new Course("PHYS101", "Physics I");

        this.professor1 = new Professor(1, "Dr. Brown", "Smith", "Computer Science");
        this.professor2 = new Professor(2, "Dr. Green", "Johnson", "Mathematics");
        this.professor3 = new Professor(3, "Dr. White", "Williams", "Physics");
    }

    @Test
    public void testAddStudent() {
        university.addStudent(student1);
        assertEquals(1, university.getStudents().get(student1.getIdInt()).getIdInt());
    }

    @Test
    public void testAddCourse() {
        university.addCourse(course1);
        assertEquals("CS101", university.getCourses().get(course1.getCourseIDString()).getCourseIDString());
    }

    @Test
    public void testAddProfessor() {
        university.addProfessor(professor1);
        assertEquals("Dr. Brown", university.getProfessors().get(professor1.getIdInt()).getFirstNameString());
    }

    @Test
    public void testEnrollStudentInCourse() {
        university.addStudent(student1);
        university.addCourse(course1);
        university.enrollStudentInCourse(student1.getIdInt(), course1.getCourseIDString());
        assertTrue(course1.getEnrolledStudentsList().contains(student1));
    }
}
