package model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;


public class CourseTest {
    private Course course;

    @BeforeEach
    public void setUp() {
        course = new Course("CS101", "Introduction to Computer Science");
    }

    @Test
    public void testGetCourseIDString() {
        assertEquals("CS101", course.getCourseIDString());
    }

    @Test
    public void testSetCourseIDString() {
        course.setCourseIDString("CS102");
        assertEquals("CS102", course.getCourseIDString());
    }

    @Test
    public void testGetCourseTitle() {
        assertEquals("Introduction to Computer Science", course.getCourseTitle());
    }

    @Test
    public void testSetCourseTitle() {
        course.setCourseTitle("Advanced Computer Science");
        assertEquals("Advanced Computer Science", course.getCourseTitle());
    }

    @Test
    public void testGetEnrolledStudentsList() {
        assertNotNull(course.getEnrolledStudentsList());
        assertTrue(course.getEnrolledStudentsList().isEmpty());
    }
}
