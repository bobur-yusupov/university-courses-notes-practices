package model;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseIDString;
    private String courseTitle;
    private List<Student> enrolledStudentsList = new ArrayList<>();

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

    public List getEnrolledStudentsList() {
        return enrolledStudentsList;
    }

    public void setEnrolledStudentsList(List enrolledStudentsList) {
        this.enrolledStudentsList = enrolledStudentsList;
    }

    public void addStudent(Student student) {
        this.enrolledStudentsList.add(student);
    }

    public boolean removeStudent(Student student) {
        return this.enrolledStudentsList.remove(student);
    }
}
