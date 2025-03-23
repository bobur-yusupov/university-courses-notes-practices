import java.util.*;

class Student {
    private String studentName;
    private int studentId;

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }
}

class Department {
    private String depName;
    private List<Student> students;

    public Department(String depName, List<Student> students) {
        this.depName = depName;
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}