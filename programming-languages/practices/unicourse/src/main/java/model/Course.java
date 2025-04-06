package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseIDString;
    private String courseTitle;
    private List<Student> enrolledStudentsList = new ArrayList<>();

    public Course(String courseIDString, String courseTitle) {
        this.courseIDString = courseIDString;
        this.courseTitle = courseTitle;
    }

    public String getCourseIDString() {
        return courseIDString;
    }

    public void setCourseIDString(String courseIDString) {
        this.courseIDString = courseIDString;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public List<Student> getEnrolledStudentsList() {
        return enrolledStudentsList;
    }

    public void setEnrolledStudentsList(List<Student> enrolledStudentsList) {
        this.enrolledStudentsList = enrolledStudentsList;
    }

    public void addStudent(Student student) {
        this.enrolledStudentsList.add(student);
    }

    public boolean removeStudent(Student student) {
        return this.enrolledStudentsList.remove(student);
    }
}
