package com.example;

import java.util.List;
import java.util.ArrayList;

import com.example.User.User;
import com.example.Library;

public class App {
    public static void main(String[] args)
    {
        User user1 = new User("U0001", "Test Testov", "test@testov.com", "sample");
        Book book1 = new Book("B0001", "Hamsa", "Navoiy", "Doston");

        List<Book> bookList = new ArrayList<>();
        List<User> userList = new ArrayList<>();

        bookList.add(book1);
        userList.add(user1);


        Library library = new Library(bookList, userList);

        System.out.println(library.findBookByTitle("Hamsa").getBookAuthor());
    }
}
