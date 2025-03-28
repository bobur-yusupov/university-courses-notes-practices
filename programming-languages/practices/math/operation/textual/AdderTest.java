package math.operation.textual;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class AdderTest {

    @Test
    public void wrongInput() {
        String result = Adder.addAsText("t", "s");
        assertEquals("Operands are not numbers.", result);
    }

    @Test
    public void addZero() {
        String result1 = Adder.addAsText("0", "0");
        String result2 = Adder.addAsText("0.0", "1");

        assertEquals("0", result1);
        assertEquals("1.0", result2);
    }

    @Test
    public void addIntegers() {
        // Adding two integers
        String result1 = Adder.addAsText("5", "3");
        String result2 = Adder.addAsText("3", "5"); // Swapping order

        assertEquals("8", result1);  // 5 + 3 = 8
        assertEquals("8", result2);  // 3 + 5 = 8 (order should not matter)
    }

    @Test
    public void addDoubles() {
        // Adding two doubles
        String result1 = Adder.addAsText("5.5", "3.2");
        String result2 = Adder.addAsText("3.2", "5.5"); // Swapping order

        assertEquals("8.7", result1);  // 5.5 + 3.2 = 8.7
        assertEquals("8.7", result2);  // 3.2 + 5.5 = 8.7 (order should not matter)
    }

    @Test
    public void addIntAndDouble() {
        // Adding an integer and a double
        String result1 = Adder.addAsText("5", "3.5");
        String result2 = Adder.addAsText("3.5", "5");  // Swapping order

        assertEquals("8.5", result1);  // 5 + 3.5 = 8.5
        assertEquals("8.5", result2);  // 3.5 + 5 = 8.5 (order should not matter)
    }

    @Test
    public void addNegativeNumbers() {
        // Adding negative numbers
        String result1 = Adder.addAsText("-5", "-3");
        String result2 = Adder.addAsText("-3", "-5"); // Swapping order

        assertEquals("-8", result1);  // -5 + -3 = -8
        assertEquals("-8", result2);  // -3 + -5 = -8 (order should not matter)
    }

    @Test
    public void addDoubleAndNegativeInt() {
        // Adding a negative integer and a positive double
        String result1 = Adder.addAsText("-5", "3.5");
        String result2 = Adder.addAsText("3.5", "-5"); // Swapping order

        assertEquals("-1.5", result1);  // -5 + 3.5 = -1.5
        assertEquals("-1.5", result2);  // 3.5 + -5 = -1.5 (order should not matter)
    }
}
