package studentgrading;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    private List<Double> grades = new ArrayList<>();

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    Student(String name, int age, List<Double> grades) {
        this.name = name;
        this.age = age;
        this.grades = grades;
    }

    public String getStudentName() {
        return this.name;
    }

    public void setNewStudentName(String newNameString) {
        if (newNameString != null && !newNameString.trim().isEmpty()) {
            this.name = newNameString;
        } else {
            throw new IllegalArgumentException("Name must be a non-empty string.");
        }
    }

    public int getStudentAge() {
        return this.age;
    }

    public void setNewStudentAge(int newStudentAge) {
        if (newStudentAge > 0) {
            this.age = newStudentAge;
        } else {
            throw new IllegalArgumentException("Age must be bigger than 0");
        }
    }

    public List<Double> getStudentGrades() {
        return this.grades;
    }

    public void setNewStudentGrades(List<Double> newStudentGrades) {
        if (newStudentGrades.isEmpty()) {
            throw new IllegalArgumentException("Student grades should be non-empty array");
        } else {
            this.grades = newStudentGrades;
        }
    }

    public void setSpecificGrade(int index, double grade) {
        if (index >= grades.size()) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        } else {
            this.grades.set(index, grade);
        }
    }

    public double calculateAverage() {
        double total = 0;
        for (double number : this.grades) {
            total += number;
        }

        return total / this.grades.size();
    }

}
