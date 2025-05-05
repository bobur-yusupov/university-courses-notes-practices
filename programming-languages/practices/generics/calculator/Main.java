package calculator;

public class Main {
    public static void main(String[] args) {
        Operations<Integer> intOps = new Operations<>();
        System.out.println("Integer Addition: " + intOps.add(5, 3));
        System.out.println("Integer Subtraction: " + intOps.subtract(5, 3));
        System.out.println("Integer Multiplication: " + intOps.multiply(5, 3));
        System.out.println("Integer Division: " + intOps.divide(5, 3));

        Operations<Double> doubleOps = new Operations<>();
        System.out.println("Double Addition: " + doubleOps.add(5.0, 3.0));
        System.out.println("Double Subtraction: " + doubleOps.subtract(5.0, 3.0));
        System.out.println("Double Multiplication: " + doubleOps.multiply(5.0, 3.0));
        System.out.println("Double Division: " + doubleOps.divide(5.0, 3.0));
    }
}