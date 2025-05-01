package wildlifesimulation.util;

import java.util.Random;

/**
 * Utility class for generating random numbers.
 */
public class RandomUtil {
    private static final Random RANDOM = new Random();

    /**
     * Generates a random integer within the specified range.
     *
     * @param min The minimum value (inclusive).
     * @param max The maximum value (inclusive).
     * @return A random integer between min and max (inclusive).
     */
    public static int getRandomInt(int min, int max) {
        return RANDOM.nextInt((max - min + 1)) + min;
    }
}
