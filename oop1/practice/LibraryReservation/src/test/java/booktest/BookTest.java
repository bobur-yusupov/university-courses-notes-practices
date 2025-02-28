package booktest;

import book.Book;
import org.junit.jupiter.api.*;
import users.Student;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {
    Book book;

    @BeforeEach
    public void createBook() {
        book = new Book("Harry Potter", "J.K. Rowling", "978-0590353427");
    }

    @Test
    public void BookDataRetrievalTest() {
        assertEquals("Harry Potter", book.getName());
        assertEquals("J.K. Rowling", book.getAuthor());
        assertEquals("978-0590353427", book.getISBN());
    }

    @Test
    public void ReserveBookTest() {
        Student student = new Student("John Doe", "UID0001");

        assertTrue(book.reserveBook(student));
    }

    @Test
    public void ReturnBookTest() {
        Student student = new Student("John Doe", "UID0001");

        book.reserveBook(student);
        book.returnBook(student);

        assertFalse(book.isReserved());
    }

    @Test
    public void BookIsAvailableTest() {
        assertTrue(book.isAvailable());
    }
}
