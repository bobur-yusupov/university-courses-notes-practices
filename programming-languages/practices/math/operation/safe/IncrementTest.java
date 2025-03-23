package math.operation.safe;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class IncrementTest {
    @Test
    public void testZero() {
        assertEquals(1, Increment.increment(0));
    }

    /*
    As input, use zero.
    As input, use the smallest possible value of an int.
    As input, use the largest possible value of an int.
    As input, use a common positive number.
    As input, use a common negative number.
    As input, use -1.
    */

    @Test
    public void testMinValue() {
        assertEquals(Integer.MIN_VALUE + 1, Increment.increment(Integer.MIN_VALUE));
    }

    @Test
    public void testMaxValue() {
        assertEquals(Integer.MAX_VALUE, Increment.increment(Integer.MAX_VALUE));
    }

    @Test
    public void testCommonPositive() {
        assertEquals(100, Increment.increment(99));
    }

    @Test
    public void testCommonNegative() {
        assertEquals(-99, Increment.increment(-100));
    }

    @Test
    public void testMinusOne() {
        assertEquals(0, Increment.increment(-1));
    }

    @Test
    public void testCommonPositive2() {
        assertEquals(101, Increment.increment(100));
    }
}