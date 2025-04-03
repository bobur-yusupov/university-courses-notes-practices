import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter number of elements: ");
        int arrLen = scanner.nextInt();
        int[] array = new int[arrLen];

        System.out.println("Enter " + arrLen + " elements");
        for (int i = 0; i < arrLen; i++) {
            array[i] = scanner.nextInt();
        }

        for (int n : array) {
            System.out.println(n);
        }

    }
}
