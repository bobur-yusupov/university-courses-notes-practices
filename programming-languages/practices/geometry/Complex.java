public class Complex {
    double re;
    double im;

    public double abs() {
        double d = re*re + im*im;

        return Math.sqrt(d);
    }

    public Complex add(Complex c) {
        double real = this.re + c.re;
        double imaginary = this.im + c.im;

        Complex result = new Complex();
        result.re = real;
        result.im = imaginary;

        return result;
    }

    public Complex sub(Complex c) {
        double real = this.re - c.re;
        double imaginary = this.im - c.im;

        Complex result = new Complex();
        result.re = real;
        result.im = imaginary;

        return result;
    }

    public Complex mul(Complex c) {
        double real = this.re * c.re - this.im * c.im;
        double imaginary = this.re * c.im + this.im * c.re;

        Complex result = new Complex();
        result.re = real;
        result.im = imaginary;

        return result;
    }
}