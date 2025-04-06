package service;

import java.util.HashMap;

import model.Course;
import model.Professor;
import model.Student;

public class University {
    private HashMap<Integer, Student> students = new HashMap<>();
    private HashMap<String, Course> courses = new HashMap<>();
    private HashMap<Integer, Professor> professors = new HashMap<>();

    public void addStudent(Student student) {
        this.students.put(student.getIdInt(), student);
    }

    public void addCourse(Course course) {
        this.courses.put(course.getCourseIDString(), course);
    }

    public void addProfessor(Professor professor) {
        this.professors.put(professor.getIdInt(), professor);
    }

    public void enrollStudentInCourse(int studentID, String courseCode) {
        Student student = students.get(studentID);
        Course course = courses.get(courseCode);

        if (student == null) {
            throw new IllegalArgumentException("Student with ID " + studentID +" not found.");
        }

        if (course == null) {
            throw new IllegalArgumentException("Course with ID " + courseCode +" not found.");
        }

        course.addStudent(student);
    }

    public void showEnrolledStudents(String courseCode) {
        Course course = courses.get(courseCode);

        if (course != null) {
            for (Student student : course.getEnrolledStudentsList()) {
                student.showInfo();
            }
        }
    }
}
