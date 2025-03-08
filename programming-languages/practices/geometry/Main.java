public class Main {
    public static void main(String[] args) {
        Complex a = new Complex();
        a.re = 1;
        a.im = 2;

        Complex b = new Complex();
        b.re = 2;
        b.im = 4;

        Complex result = a.add(b);
        Complex resultSub = a.sub(b);
        Complex resultMul = a.mul(b);

        System.out.println("Resultant real part: " + result.re);
        System.out.println("Resultant imaginary part: " + result.im);

        System.out.println("Resultant real part of sub: " + resultSub.re);
        System.out.println("Resultant imaginary part of sub: " + resultSub.im);

        System.out.println("Result of mult: " + resultMul.re + " + " + resultMul.im + "i");

        Circle circle = new Circle();
        circle.x = 0;
        circle.y = 0;
        circle.radius = 2;

        circle.enlarge(3);

        System.out.println("Circle radius: " + circle.radius);
        System.out.println("Area: " + circle.getArea());
    }
}