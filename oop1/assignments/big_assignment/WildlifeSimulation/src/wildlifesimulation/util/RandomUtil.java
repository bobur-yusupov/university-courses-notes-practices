package wildlifesimulation.util;

public class RandomUtil {
    public static int getRandomInt(int min, int max) {
        return (int) (Math.random() * (max - min + 1)) + min;
    }
}
