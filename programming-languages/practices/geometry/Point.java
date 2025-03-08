public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    public Point mirror(Point reflection) {
        int mirroredX = 2 * reflection.x - x;
        int mirroredY = 2 * reflection.y - y;

        return new Point(mirroredX, mirroredY);
    }

    public double distance(Point p) {
        int dx = this.x - p.x;
        int dy = this.y - p.y;

        double d = Math.sqrt(dx*dx + dy*dy);
        return d;
    }
}