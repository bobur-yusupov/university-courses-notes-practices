package famous.sequence;

public class TriangularNumbers {
    public static int getTriangularNumber(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Triangular number is not defined for negative values.");
        }

        int triangularNumber = (n * (n + 1)) / 2;

        return triangularNumber;
    }
}