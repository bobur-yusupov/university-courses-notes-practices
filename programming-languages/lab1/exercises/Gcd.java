public class Gcd {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[0]);
        

        while (a != b) {
            int c = b % a;
            b = a;
            a = c;
        }

        System.out.println(b);
    }
}