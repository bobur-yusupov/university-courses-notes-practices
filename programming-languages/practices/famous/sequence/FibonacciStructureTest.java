package famous.sequence;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FibonacciStructureTest {
    @ParameterizedTest
    @CsvSource({
        "1, 1",
        "1, 2",
        "2, 3",
        "3, 4",
        "5, 5",
        "8, 6"
    })
    public void testFibonacci(long expected, long n) {
        assertEquals(expected, Fibonacci.fib(n));
    }
}