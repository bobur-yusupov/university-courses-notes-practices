package model;

abstract public class Person {
    protected int idInt;
    protected String firstNameString;
    protected String lastNameString;

    public Person(int idInt, String firstNameString, String lastNameString) {
        this.idInt = idInt;
        this.firstNameString = firstNameString;
        this.lastNameString = lastNameString;
    }

    abstract public void showInfo();

    public int getIdInt() {
        return idInt;
    }

    public void setIdInt(int idInt) {
        this.idInt = idInt;
    }
    
    public String getFirstNameString() {
        return firstNameString;
    }

    public void setFirstNameString(String firstNameString) {
        this.firstNameString = firstNameString;
    }

    public String getLastNameString() {
        return lastNameString;
    }

    public void setLastNameString(String lastNameString) {
        this.lastNameString = lastNameString;
    }
}
