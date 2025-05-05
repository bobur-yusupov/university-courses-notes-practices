package calculator;

interface IOperations<T> {
    T add(T a, T b);
    T subtract(T a, T b);
    T multiply(T a, T b);
    T divide(T a, T b);
}

public class Operations<T extends Number> implements IOperations<T> {
    @Override
    public T add(T a, T b) {
        return createResult(a.doubleValue() + b.doubleValue());
    }

    @Override
    public T subtract(T a, T b) {
        return createResult(a.doubleValue() - b.doubleValue());
    }

    @Override
    public T multiply(T a, T b) {
        return createResult(a.doubleValue() * b.doubleValue());
    }

    @Override
    public T divide(T a, T b) {
        if (b.doubleValue() == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return createResult(a.doubleValue() / b.doubleValue());
    }

    // Helper method to create the result as type T
    private T createResult(double result) {
        if (result % 1 == 0) {
            // If result is an integer, return an Integer
            return (T) Integer.valueOf((int) result);
        } else {
            // If result is a floating-point number, return a Double
            return (T) Double.valueOf(result);
        }
    }
}
