package famous.sequence;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class TriangularNumbersTest {
    @ParameterizedTest
    @CsvSource({
        "0, 0",
        "1, 1",
        "2, 3",
        "3, 6",
        "4, 10",
        "5, 15",
        "6, 21",
        "7, 28",
        "8, 36",
        "9, 45",
        "10, 55"
    })
    public void testAll(int n, int expected) {
        assertEquals(expected, TriangularNumbers.getTriangularNumber(n));
    }

    @Test
    public void testNegative() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            TriangularNumbers.getTriangularNumber(-5);
        });

        assertEquals("Triangular number is not defined for negative values.", exception.getMessage());
    }
}