public class Half {
    public static void main(String[] args) {
        int i;

        int low = Integer.parseInt(System.console().readLine());
        int high = Integer.parseInt(System.console().readLine());

        for(i = low; i <= high; i++) {
            System.out.println(i/2.0);
        }

        System.out.println("Altogether " + (i - low) + " numbers are printed.");
    }
}