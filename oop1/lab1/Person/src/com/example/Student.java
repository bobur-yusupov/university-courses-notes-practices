package com.example;

import com.example.person.Person;

public class Student extends Person {
    private String studentId;
    private String major;

    public Student(String name, int age, String gender, String studentId, String major) {
        super(name, age, gender);
        this.studentId = studentId;
        this.major = major;
    }

    public void study() {
        System.out.println("I study " + this.major);
    }
}
