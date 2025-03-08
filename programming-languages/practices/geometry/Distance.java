public class Distance {
    public static void main(String[] args) {
        double totalDistance = 0;
        for (int i = 2; i < args.length - 1; i+=2) {
            double x1 = Double.parseDouble(args[i-2]);
            double y1 = Double.parseDouble(args[i-1]);
            double x2 = Double.parseDouble(args[i]);
            double y2 = Double.parseDouble(args[i+1]);
            
            Point p1 = new Point(x1, y1);
            Point p2 = new Point(x2, y2);

            totalDistance += p1.distance(p2);
        }

        System.out.println(totalDistance);
    }
}