### **Project: Library Management System**

#### **Overview:**
A Library Management System (LMS) is a program where users can manage books, issue them, return them, and maintain a catalog of available books. It involves multiple objects interacting with each other, demonstrating key OOP concepts like inheritance, polymorphism, encapsulation, and abstraction.

#### **Key Features:**
1. **Book Catalog Management:**
   - Add, remove, or update books in the library.
   - Each book should have attributes like `bookID`, `title`, `author`, `genre`, `availabilityStatus`.
   
2. **User Management:**
   - Admin can add, remove, and update users.
   - Users can be of two types: Regular users and Admins.
   - Admin can issue and return books for users, while regular users can only issue and return books.

3. **Book Issue and Return:**
   - Users can issue a book if it is available.
   - Books are to be returned after a certain period.
   - Track overdue books and calculate fines based on overdue days.
   
4. **Search and Filter Books:**
   - Users can search for books by title, author, or genre.
   - Display a list of available books filtered by category or availability.

5. **Reports:**
   - Admin can view reports on issued books, overdue books, and fines collected.

---

### **OOP Concepts to Implement:**
- **Classes and Objects:** You'll create classes like `Book`, `User`, `Library`, etc. with relevant attributes and methods.
- **Inheritance:** Create subclasses like `Admin` and `RegularUser` extending a common superclass `User`.
- **Polymorphism:** Use polymorphism to allow a common method (e.g., `issueBook()`) to behave differently for different types of users.
- **Encapsulation:** Ensure that the internal data (like book availability or user details) is hidden from external classes, exposing only necessary information via getter and setter methods.
- **Abstraction:** Use abstract classes or interfaces for operations like issuing a book or returning a book.

---

### **Class Structure:**
1. **Book Class**
   - Attributes: `bookID`, `title`, `author`, `genre`, `availabilityStatus`.
   - Methods: `isAvailable()`, `issueBook()`, `returnBook()`.
   
2. **User Class (Abstract Class)**
   - Attributes: `userID`, `name`, `email`, `userType`.
   - Methods: `viewCatalog()`, `searchBook()`, `issueBook()`, `returnBook()`.
   
3. **Admin Class (Inherits from User)**
   - Additional Methods: `addBook()`, `removeBook()`, `updateBook()`, `viewReports()`.

4. **RegularUser Class (Inherits from User)**
   - Methods: `issueBook()`, `returnBook()`.
   
5. **Library Class**
   - Attributes: A collection of `Book` objects and a collection of `User` objects.
   - Methods: `addUser()`, `removeUser()`, `findBookByTitle()`, `listAvailableBooks()`, etc.

---

### **Additional Requirements:**
- Use **collections** like `ArrayList` or `HashMap` to manage books and users.
- Include **error handling** for situations like trying to issue an unavailable book.
- Implement **data persistence** (e.g., saving and loading the catalog to/from a file).
- For the fines, you can create a method that calculates overdue fees based on the number of days the book is overdue.
