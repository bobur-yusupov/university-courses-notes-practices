# Lecture 2: Programming Languages "Java"

contructor does not have return and return type

```java
class Point {
    int x, y; // 0, 0 by default when Point object is created

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

Q1: Can we have more than one constructor in a class?
A1: Yes, we can have more than one constructor in a class. This is called constructor overloading.

## Name reuse in Java

```java
class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x; // when we use same variable name in contructor we need to use this.x to refer to the class variable
        this.y = y;
    }
}
```

If we do not initialize a contructor then the class will have implicit constructor which will initialize the class variables to default values.

Q2: Under which circumstances is a default constructor generated at compilation time?
A2: If no constructor is explicitly defined in a class.

## Information hiding in Java

(?) Type invariance

We need to use Exceptions to alert programmer about the error in the code.

```java
class Time {
    int hour, minute;

    Time(int hour, int minute)
    {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid time");
        }
        else {
            this.hour = hour;
            this.minute = minute;
        }
    }
}
```

Exception occurs during runtime.
Indicate that execution of the program is not normal.

Dynamic semantic rules of the language are checked at runtime.
Static semantic rules are checked at compile time.

There is no algorithm to check the dynamic semantic rules at compile time. Therefore these rules are checked at runtime.

### Hiding fields: private access modifier

```java
class Time {
    private int hour, minute;

    Time(int hour, int minute)
    {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid time");
        }
        else {
            this.hour = hour;
            this.minute = minute;
        }
    }
}
```

`hour` and `minute` are private fields. They cannot be accessed from outside the class.

getters and setters are used to access the private fields.

```java
class Time {
    private int hour, minute;

    Time(int hour, int minute)
    {
        if (hour < 0 || hour > 23 || minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid time");
        }
        else {
            this.hour = hour;
            this.minute = minute;
        }
    }

    int getHour() {
        return hour;
    }

    int getMinute() {
        return minute;
    }

    void setHour(int hour) {
        if (hour < 0 || hour > 23) {
            throw new IllegalArgumentException("Invalid hour");
        }
        this.hour = hour;
    }

    void setMinute(int minute) {
        if (minute < 0 || minute > 59) {
            throw new IllegalArgumentException("Invalid minute");
        }
        this.minute = minute;
    }
}
```

## Packages

If I have a large codebase I may have thousands of classes. It is difficult to manage all the classes in a single directory. Therefore we use packages.

Classes are related or do similar things are grouped together in a package.

Package declaration

```java
package geometry;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}
```

The official name of the class `Point` is `geometry.Point`.

Namespace heriarachy

```java

package geometry.basics;

class Point {
    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void move(int dx, int dy) {
        x += dx;
        y += dy;
    }
}

```

`geometry.basics` is a subpackage of `geometry`.

How to compile program with packages?
