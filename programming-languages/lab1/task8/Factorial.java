public class Factorial {
    public static long factorial(long n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

    public static void main(String[] args) {
        int num = Integer.parseInt(args[0]);

        int result = 1;

        for (int i = 2; i <= num; i++) {
            result *= i;
        }

        System.out.println(result);
        System.out.println(Factorial.factorial(num));
    }
}