# Notes from Lab 1

compilation unit

```ps1

javac <filename>.java # Compile

javap <filename>.class 
javap -p -c <filename>.class 

```

signature of a function is returning and argument types of function

Method signature of a function (or method) is the name and type & order of parameters.

```java

public class Example {
    // printName() is signature of function
    public void printName() {
        System.out.println("Hello, name!");
    }

    // add(int, int) is the signature of function
    public int add(int a, int b) {
        return a + b;
    }
}

```

Signature does NOT include:

- return type
- throws clause
- Access modifiers
- `static`, `final` and `synchronized`

I need to learn `static` in java and `System`

`static` variables, functions, blocks and nested classes are related to CLASS ITSELF rather than its instance.

```java

class Example {
    static int count = 0;

    Example() {
        count++;
    }

    void showCount() {
        System.out.println(count);
    }
}

public class Main {
    public static void main(String[] args) {
        Example ex1 = new Example();
        Example ex2 = new Example();

        ex1.showCount();
        ex2.showCount();
    }
}

```

What is difference between `console()` and `in\out`

`console()` - returns Console object which provide secure input reading

`in` - Standard user input stream (keyboard input)
`out` - Standard user output stream (console printing)

Console is keyboard and screen

Function-level, class-level scope, loop-body scope

- Stronger data type wins

## Javap

it helps to see how Java compiler compiled the `.java` file into bytecode. It needed to show developers how code is compiled.

```ps1
javap -verbose Example

javap -c Example # View bytecode instructions
```
