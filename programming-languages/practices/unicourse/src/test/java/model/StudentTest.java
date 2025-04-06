package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class StudentTest {
    private Student student;

    @BeforeEach
    public void createStudent() {
        this.student = new Student(0, "Jane", "John", "Mechanical Engineering");
    }

    @Test
    public void testStudedentId() {
        assertEquals(0, this.student.getIdInt());
    }

    @Test
    public void testStudentFirstName() {
        assertEquals("Jane", this.student.getFirstNameString());
    }

    @Test
    public void testStudentLastName() {
        assertEquals("John", this.student.getLastNameString());
    }

    @Test
    public void testStudentMajor() {
        assertEquals("Mechanical Engineering", this.student.getMajor());
    }

    @Test
    public void testSetStudentFirstName() {
        this.student.setFirstNameString("Janet");
        assertEquals("Janet", this.student.getFirstNameString());
    }

    @Test
    public void testSetStudentLastName() {
        this.student.setLastNameString("Smith");
        assertEquals("Smith", this.student.getLastNameString());
    }

    @Test
    public void testSetStudentMajor() {
        this.student.setMajor("Electrical Engineering");
        assertEquals("Electrical Engineering", this.student.getMajor());
    }
}
