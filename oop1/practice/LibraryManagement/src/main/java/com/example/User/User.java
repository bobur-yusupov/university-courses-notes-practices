package com.example.User;

public class User {
    private String userID;
    private String name;
    private String email;
    private String userType;

    public User(String userID, String name, String email, String userType) {
        this.userID = userID;
        this.name = name;
        this.email = email;
        this.userType = userType;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String newName) {
        this.name = newName;
    }

    public String getUserID() {
        return this.userID;
    }
    public void setUserID(String newUserID) {
        this.userID = newUserID;
    }

    public String getEmail() {
        return this.email;
    }
    public void setEmail(String newName) {
        this.email = newName;
    }

    public String getUserType() {
        return this.userType;
    }
    public void setUserType(String newUserType) {
        this.userType = newUserType;
    }
}
