/*

Create a program which takes its first command-line argument as an integer number, and decides whether this number is a perfect number. 
In number theory, a natural number is called perfect, if the sum of its positive divisors (excluding the number itself) 
is equal to the number. (Or, equivalently, the sum of the positive divisors equals to two times the number.) 
The first four perfect numbers are: 6, 28, 496 and 8128.

 */

public class PerfectNumber {
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

        System.out.println(PerfectNumber.isPerfectNumber(number));
    }
}