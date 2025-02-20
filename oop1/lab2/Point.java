package warrior;

/**
 *
 * @author dev-yusupov
 */
public class Point 
{
    private double x;
    private double y;
    
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public double getX()
    {
        return this.x;
    }
    
    public void setX(double newX)
    {
        this.x = newX;
    }
    
    public double getY()
    {
        return this.y;
    }
    
    public void setY(double newY)
    {
        this.x = newY;
    }
    
    public double distance(Point p)
    {
        return Math.sqrt(Math.pow((this.getX() - p.getX()), 2) + Math.pow((this.getY() - p.getY()), 2));
    }
}
