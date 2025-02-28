# Library Reservation System - Technical Requirements (TDD)

## Overview
The Library Reservation System will manage users (students, professors, librarians), book reservations, and book returns. It will be built using **Test-Driven Development (TDD)**. This approach will require writing tests first and then implementing the code to pass those tests.

## Key Features
### 1. Users
- **Student**: Can borrow up to 5 books.
- **Professor**: Can borrow up to 10 books.
- **Librarian**: Can borrow books and manage the library (add/remove books, view inventory).

### 2. Books
Each book has the following properties:
- Title
- Author
- ISBN (unique identifier)
- Availability status (available or reserved)
- Due date (if reserved)

### 3. Reservations
- Users can reserve books if they are available.
- If a book is already reserved, users will have to wait for its return.
- Reservation details include:
    - User
    - Book
    - Reservation date
    - Due date

### 4. Overdue Books
- Books that are not returned on time will be flagged as overdue.
- The system should track overdue books and calculate fines.

---

## Test-Driven Development (TDD) Flow

In TDD, you will follow the **Red-Green-Refactor** cycle:
1. **Red**: Write a test for a functionality that you want to implement.
2. **Green**: Write the minimal code necessary to pass the test.
3. **Refactor**: Refactor your code to improve it while ensuring the tests still pass.

## Step-by-Step TDD Approach

### 1. **Define Tests for the Core Functionalities**
Before you write any implementation code, we will define the test cases for the system.

#### **Tests for User Class**
- **Test 1**: A student can borrow a book if they have not exceeded the limit of 5 books.
- **Test 2**: A professor can borrow a book if they have not exceeded the limit of 10 books.
- **Test 3**: A user cannot borrow a book if they have already borrowed the maximum allowed books (5 for students, 10 for professors).
- **Test 4**: A student and professor can return books, and their borrowed count should decrease accordingly.

#### **Tests for Book Class**
- **Test 1**: A book can be marked as reserved and should be unavailable for borrowing when reserved.
- **Test 2**: A book can be returned, making it available again.
- **Test 3**: A book can be checked for availability (whether it's available or reserved).

#### **Tests for Reservation Class**
- **Test 1**: A reservation can be created for an available book.
- **Test 2**: A reservation cannot be created for an unavailable book.
- **Test 3**: A reservation can be canceled, and the book should become available again.

#### **Tests for Library Class**
- **Test 1**: A librarian can add a book to the library.
- **Test 2**: A librarian can remove a book from the library.
- **Test 3**: A user can search for books by title or ISBN.

---

### 2. **Write the Code to Pass the Tests**
For each test, write the minimal code to make it pass. Ensure you write clean, simple code, and focus on passing the test first before improving it.

### 3. **Refactor the Code**
Once all tests are passing, refactor the code to improve its structure, performance, or readability. Always run the tests again after refactoring to ensure everything still works as expected.

---

## Class Design with TDD Focus

### 1. **User** (Abstract Class)
#### **Properties**:
- `name`: String
- `userID`: String
- `borrowedBooks`: List<Book>

#### **Methods**:
- `borrowBook(Book book)`: Abstract method for borrowing a book.
- `bulkBorrowBooks(List<Book> books)`: Abstract method for borrowing multiple books.
- `returnBook(Book book)`: Abstract method for returning a book.

### 2. **Student**, **Professor**, **Librarian** (Subclasses of `User`)
#### **Properties**:
- `borrowLimit`: Integer (5 for Student, 10 for Professor)

#### **Methods**:
- `borrowBook(Book book)`: Check if user has exceeded borrow limit and borrow the book.
- `returnBook(Book book)`: Return a borrowed book and update book's availability.
- Librarian class will have additional methods:
    - `addBook(Book book)`
    - `removeBook(Book book)`
    - `viewAllBooks()`

### 3. **Book**
#### **Properties**:
- `title`: String
- `author`: String
- `ISBN`: String
- `isReserved`: boolean
- `dueDate`: Date (for reserved books)

#### **Methods**:
- `reserveBook(User user)`: Reserve a book for a user.
- `returnBook()`: Return a book and update its status.
- `isAvailable()`: Check if the book is available for borrowing.

### 4. **Reservation**
#### **Properties**:
- `user`: User
- `book`: Book
- `reservationDate`: Date
- `dueDate`: Date

#### **Methods**:
- `createReservation()`: Create a new reservation.
- `cancelReservation()`: Cancel an existing reservation.

### 5. **Library**
#### **Properties**:
- `books`: List<Book>
- `reservations`: List<Reservation>

#### **Methods**:
- `addBook(Book book)`: Add a book to the library.
- `removeBook(Book book)`: Remove a book from the library.
- `findBookByTitle(String title)`: Search for a book by title.
- `findBookByISBN(String isbn)`: Search for a book by ISBN.
- `reserveBook(User user, Book book)`: Reserve a book for a user.
- `returnBook(Book book)`: Return a borrowed book and update its status.

---

## Example TDD Workflow

### **Step 1**: Write a Test for Borrowing a Book
- **Test**: A student can borrow a book if they have not exceeded the limit of 5 books.

```java
@Test
public void testStudentCanBorrowBookWithinLimit() {
    User student = new Student("John Doe", "12345");
    Book book = new Book("Java Programming", "Author Name", "123-456-789");
    
    assertTrue(student.borrowBook(book));  // Test if the student can borrow the book
    assertEquals(1, student.getBorrowedBooks().size());  // Ensure the book is added to borrowed list
}
