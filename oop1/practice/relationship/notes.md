# Relationship

There are three types of relationship in Object-Oriented Programming

1. Association
2. Aggression
3. Composition

## Association

Association is a generic term and can mean one-to-one, one-to-many and many-to-many, but it does not indicate ownership.

Association can be in two different forms:

- **Unidirectional** - only one of two classes has relationship with another. As an example Student and LibraryCard. Student is related to LibraryCard while LibraryCard does not need to 'know about' student.
- **Bidirectional** - two different classes interact with each other. For example Teacher and Student. A teacher might be assigned to a student and teacher may have list of other students.

```java
class Bank {
    private String bankName;
    private Set<Employee> employees;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public String getBankName() {
        return this.bankName;
    }

    public void setEmployee(Set<Employee> employees) {
        this.employees = employees;
    }

    public Set<Employee> getEmployees() {
        return this.employees;
    }
}

class Employee {
    private String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getEmployeeName() {
        return this.name;
    }   
}
```

Here Bank and Employee is in unidirectional relationship. Also one bank can have many employees. Therefore these classes are in one-to-many relationship

## Aggression

Aggression is a form of association in which one class, whole, contain all classes. However lifecycle of member classes does not depend on whole. For example books are part of library, even library does not exist books can be somewhere else.

```java
class Student {
    private String studentName;
    private int studentId;

    public Student(String studentName, int studentId) {
        this.studentName = studentName;
        this.studentId = studentId;
    }

    public int getStudentId() {
        return this.studentId;
    }

    public String getStudentName() {
        return this.studentName;
    }
}

class Department {
    private String depName;
    private List<Student> students;

    public Department(String depName, List<Student> students) {
        this.depName = depName;
        this.students = students;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }
}
```

Here is an example of aggression. Student objects are in one-to-many relationship with Department.

## Compostion

Composition is a stronger form of aggression. In this relationship lifecycle of member classes depend on whole. For example house and rooms inside the house. If house gets destroyed, then rooms do not exist anymore.
