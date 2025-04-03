package array.util;

import java.util.List;
import java.util.ArrayList;

public class ArrayUtil {
    public ArrayUtil() {

    }

    public static int max(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            if (maximum < numbers[i]) {
                maximum = numbers[i];
            }
        }

        return maximum;
    }

    public static int max2(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            maximum = maximum < numbers[i] ? numbers[i] : maximum;
        }

        return maximum;
    }

    public static int max3(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int maximum = Integer.MIN_VALUE;

        for (int i = 0; i < numbers.length; i++) {
            maximum = Math.max(maximum, numbers[i]);
        }

        return maximum;
    }

    public static int max4(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        int maximum = Integer.MIN_VALUE;

        for (int number : numbers) {
            maximum = Math.max(maximum, number);
        }

        return maximum;
    }

    public static int[] minMax(int[] numbers) {
        int maximum = max4(numbers);
        int minimum = Integer.MAX_VALUE;

        for (int number : numbers) {
            minimum = minimum > number ? number : minimum;
        }

        int[] result = {minimum, maximum};

        return result;
    }
}
