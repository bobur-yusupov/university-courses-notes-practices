/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.LibraryManagementOOP;

/**
 *
 * @author dev-yusupov
 */
public class Book {
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;
    
    public Book(String bookID, String title, String author, String genre) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = true;
    }
    
    public boolean isAvailable() {
        return this.availabilityStatus;
    }
    
    public void issueBook() {
        this.availabilityStatus = false;
    }
    
    public void returnBook() {
        this.availabilityStatus = true;
    }
    
}
