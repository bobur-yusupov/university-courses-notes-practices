public class Circle 
{
    double x, y;
    double radius;

    public void enlarge(double f) {
        radius *= f;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public static void main(String[] args) {
        Circle c = new Circle();

        c.radius = 10;
        c.enlarge(10);

        System.out.println(c.getArea());
    }
}