package com.example;
import com.example.person.Person;
import com.example.Student;

public class Main {
    public static void main(String[] args) {
        Person p1 = new Person("John Tomas", 32, "male");
        Student student = new Student("John Tomas", 25, "male", "57555534", "Mechanical Engineering");

        student.introduce();
        student.study();
    }
}
