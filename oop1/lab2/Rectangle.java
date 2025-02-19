package warrior;

/**
 *
 * @author ytajdi
 */
public class Rectangle {
    private Point topLeft;
    private Point bottomRight;
    
    public Rectangle(Point topLeft, Point bottomRight)
    {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }
    
    public double height()
    {
        return topLeft.distance(new Point(topLeft.getX(), 0));
    }
    
    public double width()
    {
        return bottomRight.distance(new Point(0, bottomRight.getY()));
    }
    
    public double area()
    {
        return this.height() * this.width();
    }
    
    public void offset(double dx, double dy)
    {
        this.topLeft.setX(this.topLeft.getX() + dx);
        this.topLeft.setY(this.topLeft.getY() + dy);
        
        this.bottomRight.setX(this.bottomRight.getX() + dx);
        this.bottomRight.setY(this.bottomRight.getY() + dy);
    }
    
    public boolean checkPoint(Point p)
    {
        return topLeft.getX() >= p.getX() && topLeft.getY() >= p.getY() && bottomRight.getX() <= p.getX() && bottomRight.getY() <= p.getY();
    }
}
