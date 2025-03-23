package famous.sequence;

public class Fibonacci {
    public static long fib(long n) {
        double goldenRatio = (1 + Math.sqrt(5)) / 2;

        long nElement = (long) Math.round((Math.pow(goldenRatio, n) - Math.pow((1-goldenRatio), n)) / Math.sqrt(5));

        return nElement;
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        System.out.println(fib(n));
    }
}