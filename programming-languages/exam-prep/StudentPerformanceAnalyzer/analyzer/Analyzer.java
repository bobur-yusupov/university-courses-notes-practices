package analyzer;

import java.util.Collections;

public class Analyzer { 
    private final StudentCollection students;

    public Analyzer(StudentCollection students) {
        this.students = students;
    }

    public double averageGrade() {
        return students.stream().average().orElse(0.0);
    }

    public double highestGrade() {
        return students.stream().max().orElse(0.0);
    }

    public double lowestGrade() {
        return students.stream().min().orElse(0.0);
    }

    public Student topStudent() {
        return Collections.max(students);
    }

    public Student bottomStudent() {
        return Collections.min(students);
    }

    public long countPassing(double passingGrade) {
        return students.stream()
                .filter(s -> s.getGrade() >= passingGrade)
                .count();
    }

    public void printSummary() {
        System.out.println("Grade Summary:");
        System.out.println("Average Grade: " + averageGrade());
        System.out.println("Highest Grade: " + highestGrade());
        System.out.println("Lowest Grade: " + lowestGrade());
        System.out.println("Top Student: " + topStudent().getName());
        System.out.println("Bottom Student: " + bottomStudent().getName());
        System.out.println("Number of Passing Students: " + countPassing(50));
    }
}