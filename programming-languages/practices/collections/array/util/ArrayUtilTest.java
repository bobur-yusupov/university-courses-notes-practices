package array.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import array.util.ArrayUtil;


public class ArrayUtilTest {
    @Test
    public void maxLength0() {
        int[] testArray = {};

        assertEquals(0, ArrayUtil.max(testArray));
        assertEquals(0, ArrayUtil.max2(testArray));
        assertEquals(0, ArrayUtil.max3(testArray));
        assertEquals(0, ArrayUtil.max4(testArray));
    }

    @ParameterizedTest
    @CsvSource({
        "'0', 0",
        "'1', 1",
        "'2000003', 2000003",
        "'-3', -3"
    })

    public void maxLength1(String input, int expected) {
        int[] numbers = parseInput(input);

        assertEquals(expected, ArrayUtil.max(numbers));
        assertEquals(expected, ArrayUtil.max2(numbers));
        assertEquals(expected, ArrayUtil.max3(numbers));
        assertEquals(expected, ArrayUtil.max4(numbers));
    }

    @ParameterizedTest
    @CsvSource({
        "'1, 2', 2",
        "'2, 1', 2"
    })
    public void maxLength2(String input, int expected) {
        int[] numbers = parseInput(input);

        assertEquals(expected, ArrayUtil.max(numbers));
        assertEquals(expected, ArrayUtil.max2(numbers));
        assertEquals(expected, ArrayUtil.max3(numbers));
        assertEquals(expected, ArrayUtil.max4(numbers));
    }

    private int[] parseInput(String input) {
        if (input.isEmpty()) {
            return new int[0];
        }
        String[] split = input.split(",");
        int[] numbers = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            numbers[i] = Integer.parseInt(split[i].trim());
        }
        return numbers;
    }
}
