package array.main;

import array.util.ArrayUtil;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements in the array: ");
        int arrayLen = scanner.nextInt();

        int[] array = new int[arrayLen];

        System.out.println("Enter " + arrayLen + " integers:");
        for (int i = 0; i < arrayLen; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.println("The array: " + Arrays.toString(array));

        System.out.println("Maximum value using max method: " + ArrayUtil.max(array));
        System.out.println("Maximum value using max2 method: " + ArrayUtil.max2(array));
        System.out.println("Maximum value using max3 method: " + ArrayUtil.max3(array));
        System.out.println("Maximum value using max4 method: " + ArrayUtil.max4(array));
    }
}
