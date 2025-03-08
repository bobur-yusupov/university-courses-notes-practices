public class Point {
    public double x;
    public double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public Point mirror(Point reflection) {
        double mirroredX = 2 * reflection.x - x;
        double mirroredY = 2 * reflection.y - y;

        return new Point(mirroredX, mirroredY);
    }

    public double distance(Point p) {
        double dx = this.x - p.x;
        double dy = this.y - p.y;

        double d = Math.sqrt(dx*dx + dy*dy);
        return d;
    }
}