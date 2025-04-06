package model;

public class Professor extends Person {
    private String department;

    public Professor(int idInt, String firstNameString, String lastNameString, String department) {
        super(idInt, firstNameString, lastNameString);

        this.department = department;
    }

    @Override
    public void showInfo() {
        System.out.println("Professor ID: " + this.idInt);
        System.out.println("Professor first name: " + this.firstNameString);
        System.out.println("Professor last name: " + this.lastNameString);
        System.out.println("Department: " + this.department);
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
