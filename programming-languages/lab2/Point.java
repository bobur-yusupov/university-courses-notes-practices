class Point {
    double x, y;

    void move(double dx, double dy) {
        x += dx; // It uses nearest variable in the scope thats way it uses parameter x of function
        y += dy;
    }

    void mirror(double cx, double cy) {
        x = 2 * cx - x;
        y = 2 * cy - y;
    }

    void mirror(Point p) {
        mirror(p.x, p.y);
    }

    public double distance(Point p) {
        double dx = p.x - x;
        double dy = p.y - y;

        return Math.sqrt(dx * dx + dy * dy);
    }
}

class PointMain {
    public static void main(String[] args) {
        Point p = new Point(); // x and y values will be 0
        p.x = 1;
        p.y = 2;
        // int, float, double, byte, boolean, char, short, long -> primitive data types in Java
        // reference type initializer ? -> in local variables for classes we need to initialize with values compiler does error

        System.out.println("(" + p.x + ", "+ p.y + ")");
        p.move(-1, 1);
        System.out.println("(" + p.x + ", "+ p.y + ")");

        Point p2 = new Point();
        p2.x = 2;
        p2.y = 1;

        p.mirror(p2);
        System.out.println("(" + p.x + ", "+ p.y + ")");

        System.out.println(p.distance(new Point()));
    }   
}