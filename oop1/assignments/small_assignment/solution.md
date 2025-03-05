
# UML Diagrams for OOP Project

## Class Diagram

A class diagram represents the static structure of a system by showing its classes, attributes, operations, and the relationships among objects.

```plaintext
+--------------------------------+
|          ParkingSpot           |
+--------------------------------+
| - spotNumber: int              |
| - sizeLimit: String            |
| - isAvailable: boolean         |
+--------------------------------+
| + getSpotNumber(): int         |
| + getSizeLimit(): String       |
| + isAvailable(): boolean       |
| + setSpotNumber(int): void     |
| + setSizeLimit(String): void   |
| + setAvailable(boolean): void  |
+--------------------------------+
          |
          |
          V
+-----------------+
|    Student      |
+-----------------+
| - studentId: int|
+-----------------+
| + getStudentId(): int |
+-----------------+
```

## Sequence Diagram

A sequence diagram shows how objects interact in a particular scenario of a use case.

```
+---------+      +---------+      +---------+
|  User   |      |  System |      | Database|
+---------+      +---------+      +---------+
     |                |                |
     |    Login       |                |
     |--------------->|                |
     |                | Validate User  |
     |                |--------------->|
     |                |                |
     |                |  User Valid    |
     |                |<---------------|
     |   Access       |                |
     |<---------------|                |
```

## Use Case Diagram

A use case diagram represents the functionality of a system using actors and use cases.

```plaintext
+-------------------+
|      User         |
+-------------------+
          |
          |
          V
+-------------------+
|  Login            |
+-------------------+
          |
          |
          V
+-------------------+
|  Access Dashboard |
+-------------------+
```

These diagrams provide a visual representation of the system's structure and behavior, making it easier to understand and communicate the design.
