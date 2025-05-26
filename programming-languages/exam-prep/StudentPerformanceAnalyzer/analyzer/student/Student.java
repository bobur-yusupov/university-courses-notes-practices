package analyzer.student;

import java.lang.Comparable;

public class Student implements Comparable<Student> {
    private final int id;
    private String name;
    private double grade;

    public Student(int id, String name, double grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public double getGrade() {
        return this.grade;
    }

    public void setGrade(double newGrade) {
        if (0 > newGrade || 100 < newGrade) {
            throw new IllegalArgumentException("Grade is invalid. It should be between 0 and 100.");
        }

        this.grade = newGrade;
    }

    @Override
    public int compareTo(Student that) {
        if (that == null) {
            throw new NullPointerException("Provided student is null.");
        }

        int gradeComp = Double.compare(this.grade, that.grade);

        if (gradeComp == 0) {
            return this.name.compareTo(that.name);
        }

        return gradeComp;
    }

    @Override
    public String toString() {
        return "Student(id=" + this.id + ", name=" + this.name + ", grade=" + this.grade + ")";
    }
}