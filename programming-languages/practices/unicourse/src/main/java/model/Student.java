package model;

public class Student extends Person {
    private String major;

    public Student(int idInt, String firstNameString, String lastNameString, String major) {
        super(idInt, firstNameString, lastNameString);

        this.major = major;
    }

    @Override
    public void showInfo() {
        System.out.println("Student ID: " + this.idInt);
        System.out.println("Student first name: " + this.firstNameString);
        System.out.println("Student last name: " + this.lastNameString);
        System.out.println("Major: " + this.major);
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}
