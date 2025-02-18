public class Complex
{
    double re, im;

    double abs() {
        return Math.sqrt(re * re + im * im);
    }

    public Complex add(Complex c) {
        re += c.re;
        im += c.im;

        return this;
    }

    public Complex subtract(Complex c) {
        re -= c.re;
        im -= c.im;

        return this;
    }

    public Complex mul(Complex c) {
        double re = this.re * c.re - im * c.im;
        im = this.re * c.im + im * c.re;

        this.re = re;

        return this;
    }

    public static void main(String[] args) {
        Complex alpha = new Complex(), beta = new Complex();

        alpha.re = 3;
        alpha.im = 2;

        beta.re = 1;
        beta.im = 4;

        System.out.println(alpha.re == 3 && alpha.im == 2 && beta.re == 1 && beta.im == 4);

        alpha.add(beta).subtract(beta).mul(beta);
    }
}