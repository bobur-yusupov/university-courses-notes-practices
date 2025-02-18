package com.example;

import com.example.exceptions.UnavailableBookException;

public class Book
{
    private String bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;

    public Book(String bookID, String title, String author, String genre)
    {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = true;
    }

    public boolean isAvailable()
    {
        return this.availabilityStatus;
    }

    public void issueBook() throws UnavailableBookException
    {
        if (this.availabilityStatus)
        {
            this.availabilityStatus = false;
        } else {
            throw new UnavailableBookException("This book is already issued and not available.");
        }
    }

    public void returnBook()
    {
        this.availabilityStatus = true;
    }

    public String getBookID()
    {
        return this.bookID;
    }

    public void setNewBookID(String newBookID)
    {
        this.bookID = newBookID;
    }

    public String getBookTitle()
    {
        return this.title;
    }

    public void setNewBookTitle(String newBookTitle)
    {
        this.title = newBookTitle;
    }

    public String getBookAuthor()
    {
        return this.author;
    }

    public void setNewBookAuthor(String newBookAuthorName)
    {
        this.author = newBookAuthorName;
    }

    public String getBookGenre()
    {
        return this.genre;
    }

    public void setBookGenre(String newBookGenre)
    {
        this.genre = newBookGenre;
    }
}