
/**
 * <p> This class contains two constructors that generate circles using the Point class.  This class also included four methods that
 * find the area, perimeter, as well as a method that finds if a user defined point is within the circles bounds.  It
 * also contains a method that creates a bounding box around the generated circle.
 * </p>
 */

public class Circle extends Shape {

    private Point center;
    private double radius;

    /**
     * This method returns the center point.
     * @return c returns the center point.
     */
    public Point getCenter() {
        Point c = new Point(center);
        return c;
    }

    /**
     * This method sets the center point.
     */
    public void setCenter(Point c) {
        center = new Point(c);
    }

    /**
     * This method returns the radius.
     * @return radius returns the radius.
     */
    public double getRadius() {
        return radius;
    }

    /**
     * This method sets the radius
     */
    public void setRadius(double r) {
        double abs = Math.abs(r);
        this.radius = abs;
    }
    /**
     * This method constructs a circle at origin with a radius of 1.
     */
    public Circle() {
        center = new Point();
        radius = 1;
    }

    /**
     * This method constructs a circle with center point c and a radius.
     * @param c The center point
     * @param radius The radius
     */
    public Circle(Point c, double radius) {
        double abs = Math.abs(radius);
        this.radius = abs;
        center = new Point(c);
    }

    /**
     * This method calculates the radius of the circle
     * @return area Returns the area of the circle.
     */
    public double area() {
        double area = Math.PI * (radius * radius);
        return area;
    }

    /**
     * This method calculates the perimeter of the circle.
     * @return perimeter returns the perimeter of the circle.
     */
    public double perimeter() {
        double perimeter = 2 * Math.PI * radius;
        return perimeter;
    }

    /**
     * This method calculates if a point is within the circles bounds.
     * @param user Custom point
     * @return true or false
     */
    public boolean inBounds(Point user) {
        if(((user.getX() - center.getX()) * (user.getX() - center.getX()) + (user.getY() - center.getY()) * (user.getY() - center.getY())) <= (radius * radius)) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * This method generates a bounding box around the circle.
     * @returns one Returns a rectangle constructor.
     */
    public Rectangle getBoundingBox() {
        Point UR = new Point(center.getX() + radius, center.getY() + radius);
        Point LL = new Point(center.getX() - radius, center.getY() - radius);

        Rectangle one = new Rectangle(LL, UR);
        return one;
    }

    /**
     * This method calculates the diameter
     * @returns diameter
     */
    public double diameter() {
        return radius * 2;
    }

    /**
     * This method calculates the width
     * @returns diameter
     */
    public double width() {
        return diameter();
    }

    /**
     * This method calculates the height
     * @returns diameter
     */
    public double height() {
        return diameter();
    }

    /**
     * This resets the position of the shape
     */
    public void setPosition(double x, double y) {
        Point one = new Point(x,y);
        setCenter(one);
    }

    /**
     * This resets the position of the shape using polar coordinates
     */
    public void setPolar(double radius, double angle) {
        Point one = new Point();
        one.setPolar(radius, angle);
        setCenter(one);
    }

    /**
     * This method moves the shape by a certain amount
     */
    public void move(double dx, double dy) {
        Point one = new Point(getCenter().getX()+dx, getCenter().getY() + dy);
        setCenter(one);
    }

    /**
     * This method moves the shape by a certain amount using polar coordinates
     */
    public void movePolar(double radius, double angle) {
        Point one = new Point(getCenter().getX(), getCenter().getY());
        one.movePolar(radius, angle);
        setCenter(one);
    }

    /**
     * This method allows this shape to be cloneable
     */
    @Override
    public Circle clone() throws CloneNotSupportedException {
        Circle copy = (Circle) super.clone();
        copy.center = (Point) center.clone();

        return copy;
    }
}
