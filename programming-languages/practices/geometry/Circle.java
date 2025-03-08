public class Circle {
    double x;
    double y;
    double radius;

    public void enlarge(double f) {
        this.radius *= f;
    }

    public double getArea() {
        double area = Math.PI * this.radius * this.radius;

        return area;
    }


}