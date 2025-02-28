package userstest;

import org.junit.jupiter.api.*;

import book.Book;
import users.Librarian;
import users.Professor;
import users.Student;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    /**
     * Unit tests for User classes
     */

    // Declaring books for unit tests
    private Book book1;
    private Book book2;
    private Book book3;
    private Book book4;
    private Book book5;
    private Book book6;
    private Book book7;
    private Book book8;
    private Book book9;
    private Book book10;


    @BeforeEach
    public void createBooks() {
        // Initializing all book objects
        book1 = new Book("Harry Potter and the Sorcerer's Stone", "J.K. Rowling", "978-0590353427");
        book2 = new Book("Harry Potter and the Chamber of Secrets", "J.K. Rowling", "978-0747538493");
        book3 = new Book("Harry Potter and the Prisoner of Azkaban", "J.K. Rowling", "978-0747542155");
        book4 = new Book("The Hobbit", "J.R.R. Tolkien", "978-0547928227");
        book5 = new Book("The Lord of the Rings", "J.R.R. Tolkien", "978-0618640157");
        book6 = new Book("1984", "George Orwell", "978-0451524935");
        book7 = new Book("To Kill a Mockingbird", "Harper Lee", "978-0060935467");
        book8 = new Book("The Great Gatsby", "F. Scott Fitzgerald", "978-0743273565");
        book9 = new Book("Pride and Prejudice", "Jane Austen", "978-0141439518");
        book10 = new Book("Moby-Dick", "Herman Melville", "978-1503280786");
    }

    // Test users data Student, Professor, Librarian

    @Test
    @DisplayName("Testing student user data retrieval")
    public void StudentUserDataTest() {
        Student student = new Student("John Doe", "UID0001");

        assertEquals("John Doe", student.getName());
        assertEquals("UID0001", student.getUserID());

    }

    @Test
    @DisplayName("Testing professor user data retrieval")
    public void ProfessorUserDataTest() {
        Professor professor = new Professor("John Doe", "UID0002");

        assertEquals("John Doe", professor.getName());
        assertEquals("UID0002", professor.getUserID());
    }

    @Test
    @DisplayName("Testing librarian user data retrieval")
    public void LibrarianUserDataTest() {
        Librarian librarian = new Librarian("John Doe", "UID0003");

        assertEquals("John Doe", librarian.getName());
        assertEquals("UID0003", professor.getUserID());
    }

    // Borrowing book Student, Professor, Librarian

    @Test
    @DisplayName("Testing student borrowing a book")
    public void StudentBorrowBookTest() {
        Student student = new Student("John Doe", "UID0001");

        student.borrowBook(book1);

        assertEquals(book1, student.borrowedBooks.get(0));
        assertTrue(book1.isReserved());
    }

    @Test
    @DisplayName("Testing professor borrowing a book")
    public void ProfessorBorrowBookTest() {
        Professor professor = new Professor("John Doe", "UID0002");

        professor.borrowBook(book1);

        assertEquals(book1, professor.borrowedBooks.get(0));
        assertTrue(book1.isReserved());
    }

    @Test
    @DisplayName("Testing librarian borrowing a book")
    public void LibrarianBorrowBookTest() {
        Librarian librarian = new Librarian("John Doe", "UID0003");

        librarian.borrowBook(book1);

        assertEquals(book1, librarian.borrowedBooks.get(0));
        assertTrue(book1.isReserved());
    }

    // Returning book Student, Professor, Librarian

    @Test
    @DisplayName("Testing student returning a book")
    public void StudentReturnBookTest() {
        Student student = new Student("John Doe", "UID0001");

        student.borrowBook(book1);
        student.returnBook(book1);

        assertFalse(book1.isReserved());
    }

    @Test
    @DisplayName("Testing professor returning a book")
    public void ProfessorReturnBookTest() {
        Professor professor = new Professor("John Doe", "UID0002");

        professor.borrowBook(book1);
        professor.returnBook(book1);

        assertFalse(book1.isReserved());
    }

    @Test
    @DisplayName("Testing librarian returning a book")
    public void LibrarianReturnBookTest() {
        Librarian librarian = new Librarian("John Doe", "UID0003");

        librarian.borrowBook(book1);
        librarian.returnBook(book1);

        assertFalse(book1.isReserved());
    }

    // Bulk borrow books Student, Professor, Librarian

    @Test
    @DisplayName("Testing student borrowing a book")
    public void StudentBorrowBookTest() {
        Student student = new Student("John Doe", "UID0001");

        List<Book> booksToBorrowList = new ArrayList<>();
        booksToBorrowList.add(book1);
        booksToBorrowList.add(book2);
        booksToBorrowList.add(book3);

        student.bulkBorrowBooks(booksToBorrowList);

        assertEquals(3, student.borrowedBooks.size());
        assertTrue(book1.isReserved());
        assertTrue(book2.isReserved());
        assertTrue(book3.isReserved());
    }

    @Test
    @DisplayName("Testing professor borrowing a book")
    public void ProfessorBorrowBookTest() {
        Professor professor = new Professor("John Doe", "UID0002");

        List<Book> booksToBorrowList = new ArrayList<>();
        booksToBorrowList.add(book1);
        booksToBorrowList.add(book2);
        booksToBorrowList.add(book3);

        professor.bulkBorrowBooks(booksToBorrowList);

        assertEquals(3, professor.borrowedBooks.size());
        assertTrue(book1.isReserved());
        assertTrue(book2.isReserved());
        assertTrue(book3.isReserved());
    }

    @Test
    @DisplayName("Testing librarian borrowing a book")
    public void LibrarianBorrowBookTest() {
        Librarian librarian = new Librarian("John Doe", "UID0003");

        List<Book> booksToBorrowList = new ArrayList<>();
        booksToBorrowList.add(book1);
        booksToBorrowList.add(book2);
        booksToBorrowList.add(book3);

        librarian.bulkBorrowBooks(booksToBorrowList);

        assertEquals(3, librarian.borrowedBooks.size());
        assertTrue(book1.isReserved());
        assertTrue(book2.isReserved());
        assertTrue(book3.isReserved());
    }

    // Bulk return books Student, Professor, Librarian

    @Test
    @DisplayName("Testing student bulk returning books")
    public void StudentReturnBookTest() {
        Student student = new Student("John Doe", "UID0001");

        List<Book> booksToBorrowList = new ArrayList<>();
        booksToBorrowList.add(book1);
        booksToBorrowList.add(book2);
        booksToBorrowList.add(book3);

        student.bulkBorrowBooks(booksToBorrowList);
        student.bulkReturnBooks(booksToBorrowList);

        assertFalse(book1.isReserved());
        assertFalse(book2.isReserved());
        assertFalse(book3.isReserved());
    }

    @Test
    @DisplayName("Testing professor bulk returning books")
    public void ProfessorReturnBookTest() {
        Professor professor = new Professor("John Doe", "UID0002");

        List<Book> booksToBorrowList = new ArrayList<>();
        booksToBorrowList.add(book1);
        booksToBorrowList.add(book2);
        booksToBorrowList.add(book3);

        professor.bulkBorrowBooks(booksToBorrowList);
        professor.bulkReturnBooks(booksToBorrowList);

        assertFalse(book1.isReserved());
        assertFalse(book2.isReserved());
        assertFalse(book3.isReserved());
    }

    @Test
    @DisplayName("Testing librarian bulk returning books")
    public void LibrarianReturnBookTest() {
        Librarian librarian = new Librarian("John Doe", "UID0003");

        List<Book> booksToBorrowList = new ArrayList<>();
        booksToBorrowList.add(book1);
        booksToBorrowList.add(book2);
        booksToBorrowList.add(book3);

        librarian.bulkBorrowBooks(booksToBorrowList);
        librarian.bulkReturnBooks(booksToBorrowList);

        assertFalse(book1.isReserved());
        assertFalse(book2.isReserved());
        assertFalse(book3.isReserved());
    }
}
