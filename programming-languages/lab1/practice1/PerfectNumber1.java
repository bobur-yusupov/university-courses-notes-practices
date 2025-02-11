public class PerfectNumber1 {
    public static boolean isPerfectNumber(int number) {
        int sum = 0;

        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }

        return sum == number || sum == 2 * number;
    }

    public static void main(String[] args) {
        int number = Integer.parseInt(args[0]);
        int totalPerfectNumbers = 0;

        for (int j = 1; j <= number; j++) {
            if (isPerfectNumber(j)) {
                totalPerfectNumbers++;
            }
        }

        System.out.println(totalPerfectNumbers);
    }
}