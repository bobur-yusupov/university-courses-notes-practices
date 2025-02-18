package com.example.LibraryManagementOOP;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.example.LibraryManagementOOP.User.User;
/**
 *
 * @author dev-yusupov
 */
public class Library 
{
    private List<Book> collectionOfBooks = new ArrayList();
    private List<User> collectionOfUsers = new ArrayList();
    
    public Library(List<Book> collectionOfBooks, List<User> collectionOfUsers) {
        this.collectionOfBooks = collectionOfBooks;
        this.collectionOfUsers = collectionOfUsers;
    }
    
    public void addUser(User newUser) 
    {
        collectionOfUsers.add(newUser);
    }
    
    public void removeUser(User userToRemove)
    {
        collectionOfUsers.remove(userToRemove);
    }
    
    public Book findBookByTitle(String stringTitleOfBook)
    {
        for (int index = 0; index < collectionOfBooks.size(); index++)
        {
            if (collectionOfBooks.get(index).getBookTitle().toLowerCase().equals(stringTitleOfBook.toLowerCase()))
            {
                return collectionOfBooks.get(index);
            }
        }
        
        return null;
    }
    
    public List<Book> listAvailableBooks()
    {
        return this.collectionOfBooks.stream()
                .filter(Book::isAvailable)
                .collect(Collectors.toList());
    }
}
