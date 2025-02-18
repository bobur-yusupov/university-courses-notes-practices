public class Distance {
    public static void main(String[] args) {
        double distance = 0.0;
        Point lastPoint = new Point();

        if (args.length >= 2) {
            lastPoint.x = Double.parseDouble(args[0]);
            lastPoint.y = Double.parseDouble(args[1]);
        }
        for (int i = 0; i < args.length; i+=2) {
            Point p = new Point();

            p.x = Double.parseDouble(args[i]);
            p.y = Double.parseDouble(args[i + 1]);

            distance += p.distance(lastPoint);
            lastPoint = p;
        }

        System.out.println(distance);
    }
}