
/**
 * <p> This class contains three constructors that generate a point.  The first constrictor creates a point
 * at origin, the second constructor generates a point at a user defined location, the third creates a point
 * that is a copy of another point. This class also contains two methods that measure the distance between points
 * as well as how far a point is from origin.  This class also converts between Euclidean coordinates vs polar.
 * </p>
 */

public class Point implements Movable, Cloneable {

    private double x;
    private double y;
    private double radius;
    private double angle;

    /**
     * This method returns the value of radius.
     * @return radius Returns the value of radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * This method returns the value of the angle.
     * @return angle Returns the value of the angle.
     */
    public double getAngle() {
        return angle;
    }

    /**
     * This method returns the value of X.
     * @return x Returns the value of X.
     */
    public double getX() {
        return x;
    }

    /**
     * This method returns the value of y.
     * @return y Returns the value of y.
     */
    public double getY() {
        return y;
    }

    /**
     * This method sets the value of x in polar and euclidean.
     */
    public void setX(double x) {
        this.x = x;
        this.radius = Math.sqrt((x * x) + (y * y));
        this.angle = Math.atan2(y, x);
    }

    /**
     * This method sets the value of y in polar and euclidean.
     */
    public void setY(double y) {
        this.y = y;
        this.radius = Math.sqrt((x * x) + (y * y));
        this.angle = Math.atan2(y, x);
    }

    /**
     * This method sets the value of the radius and converts it to euclidean.
     */
    public void setRadius(double radius) {
        this.radius = radius;
        this.x = radius * Math.cos(angle);
        this.y = radius * Math.sin(angle);
    }

    /**
     * This method sets the value of the angle and converts it to euclidean.
     */
    public void setAngle(double angle) {
        this.angle =  angle;
        this.x = radius * Math.cos(angle);
        this.y = radius * Math.sin(angle);
    }

    public void setPosition(double x, double y) {
        setX(x);
        setY(y);
    }

    public void setPolar(double radius, double angle) {
        setRadius(radius);
        setAngle(angle);
    }

    public void move(double dx, double dy) {
        setX(x + dx);
        setY(y + dy);
    }

    public void movePolar(double r, double a) {
        setRadius(radius + r);
        setAngle(angle + a);
    }

    /**
     * This method generates a point at (0,0).
     */
    public Point() {
        this.x = 0;
        this.y = 0;
        this.angle = 0;
        this.radius = 0;
    }

    /**
     * This method generates a point at a user defined point.
     * @param x x value of the custom point
     * @param y y value of the custom point
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
        this.radius = Math.sqrt((x * x) + (y * y));
        this.angle = Math.atan2(y, x);
    }

    /**
     * This method generates a point as a copy of another point.
     * @param p2  Copy of another initialized point
     */
    public Point(Point p2) {
        this.x = p2.x;
        this.y = p2.y;
        this.radius = p2.radius;
        this.angle = p2.angle;
    }

    /**
     * This method calculates the distance between two points
     * @param p2  Copy of another initialized point
     * @return distance Returns the distance between the points.
     */
    public double distance(Point p2) {
        double distance = Math.sqrt(((p2.x - x) * (p2.x - x)) + ((p2.y - y) * (p2.y - y)));
        return distance;
    }

    /**
     * This method calculates the distance between a point and the origin.
     * @return distance returns the distance
     */
    public double distanceFromOrigin() {
        double distance = Math.sqrt(((x) * (x)) + ((y) * (y)));
        return distance;
    }

    /**
     * This method compares 2 points and returns 0 if its the same point, -1 if its to the top right, and returns 1
     * if no other cases are triggered.
     * @return 0,-1,1 depending on the case.
     */
    public int compareTo(Point p2) {

        if(p2.x == x && p2.y == y) {
            return 0;
        }

        if(p2.x > x && p2.y > y) {
            return -1;
        }
        return 1;
    }

    /**
     * This method converts the coordinates into a string.
     */
     public String toString() {
        return "(" + x + "," + y + ")";
    }


    /**
     * This method allows this shape to be cloneable
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}