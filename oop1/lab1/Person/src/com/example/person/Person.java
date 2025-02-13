package com.example.person;

public class Person {
    private String name;
    private int age;
    private String gender;

    public Person(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return this.name;
    }

    public void introduce() {
        System.out.println("My name is " + this.name + ". I am " + this.age + " old. I am a " + this.gender);
    }

    public void birthday() {
        this.age++;
    }
}
