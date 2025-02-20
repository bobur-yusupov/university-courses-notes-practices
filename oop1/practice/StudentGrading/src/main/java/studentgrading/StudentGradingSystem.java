package studentgrading;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class StudentGradingSystem {
    private List<Student> students = new ArrayList<>();

    StudentGradingSystem(List<Student> students) {
        if (students.isEmpty())
        {
            throw new IllegalArgumentException("Students should not be empty");
        } else {
            this.students = students;
        }
    }

    public void addStudent(Student student)
    {
        if (student == null)
        {
            throw new IllegalArgumentException("Student should not be null");
        } else {
            this.students.add(student);
        }
    }

    public boolean removeStudent(Student student)
    {
        return this.students.remove(student);
    }

    public Student getStudent(String studentName) throws NoSuchElementException
    {
        for (Student student : students)
        {
            if (student.getStudentName().equalsIgnoreCase(studentName)) {
                return student;
            }
        }
        // The exception should be thrown here, after the loop if no match is found.
        throw new NoSuchElementException("Student with the given name not found!");
    }

    public List<Student> getStudents()
    {
        return this.students;
    }

    public Student getTopStudent()
    {
        Student topStudent = this.students.getFirst();

        for (Student student : this.students)
        {
            if (topStudent.calculateAverage() < student.calculateAverage())
            {
                topStudent = student;
            }
        }

        return  topStudent;
    }


}

