public class Gcd {
    public static long gcd(long a, long b) {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }

    public static void main(String[] args) {
        int len = args.length;

        if (len == 0) {
            System.out.println("Please provide at least one number.");
            return;
        }

        long gcdivisor = Long.parseLong(args[0]);

        for (int i = 1; i < len; i++) {
            long a = Long.parseLong(args[i]);

            gcdivisor = gcd(gcdivisor, a);
        }

        System.out.println(gcdivisor);
    }
}