public class Complex {
    int re;
    int im;

    public double abs() {
        int d = re*re + im*im;

        return Math.sqrt(d);
    }
}