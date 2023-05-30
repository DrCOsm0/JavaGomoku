
/**
 * <p> This class contains three constructors that generate a rectangle using the Point class.  This class also contains
 * four methods.  These methods find the area, perimeter, other corner points, and if a point is within the rectangles
 * bounds. Multiple getters and setters area also included to manipulate the private data types.
 * </p>
 */

public class Rectangle extends Shape {

    private Point lowerLeft;
    private Point upperRight;

    /**
     * Returns a lower left point.
     * @return LL lower left point.
     */
    public Point getLowerLeft() {

        Point LL = new Point(lowerLeft);
        return LL;
    }

    /**
     * Returns a upper right point.
     * @return UR upper right point.
     */
    public Point getUpperRight() {
        Point UR = new Point(upperRight);
        return UR;
    }

    /**
     * Returns a lower right point.
     * @return LR lower right point.
     */
    public Point getLowerRight() {

        double LowerRightX = upperRight.getX();
        double LowerRightY = lowerLeft.getY();

        Point LR = new Point(LowerRightX, LowerRightY);

        return LR;
    }

    /**
     * Returns a upper left point.
     * @return UL upper left point.
     */
    public Point getUpperLeft() {

        double UpperLeftX = lowerLeft.getX();
        double UpperLeftY = upperRight.getY();

        Point UL = new Point(UpperLeftX, UpperLeftY);
        return UL;

    }

    /**
     * This method generates a rectangle with a lower left point at (0,0) and an upper
     * right coordinate of (1,1).
     */
    public Rectangle() {
        this.lowerLeft = new Point(0,0);
        this.upperRight = new Point(1,1);
    }

    /**
     * This method generates a rectangle with a lower left point at (0,0) and an upper coordinate using width
     * and height.
     * @param height height of rectangle
     * @param width width of rectangle.
     */
    public Rectangle(double width, double height) {
        Point LL = new Point(0,0);
        Point UR = new Point(width, height);

        Rectangle one = new Rectangle(LL, UR);

        lowerLeft = one.getLowerLeft();
        upperRight = one.getUpperRight();
    }

    /**
     * This method generates a rectangle with two generated points lower left and upper right.
     * @param LL lower left point
     * @param UR upper right point
     */
    public Rectangle(Point LL, Point UR) {

        this.lowerLeft = new Point(LL);
        this.upperRight = new Point(UR);

        if(LL.getX() > UR.getX()) {
            upperRight.setX(LL.getX());
            lowerLeft.setX(UR.getX());
        }

        if(LL.getY() > UR.getY()) {
            upperRight.setY(LL.getY());
            lowerLeft.setY(UR.getY());
        }
    }
    /**
     * This method calculates the area of the rectangle.
     * @return area Returns the area of the rectangle.
     */
    public double area() {
        double area = ((upperRight.getX() - lowerLeft.getX()) * (upperRight.getY() - lowerLeft.getY()));
        return area;
    }

    /**
     * This method calculates the perimeter of the rectangle.
     * @return perimeter Returns the perimeter of the rectangle.
     */
    public double perimeter() {
        double perimeter = (((upperRight.getX() - lowerLeft.getX()) * 2) + ((upperRight.getY() - lowerLeft.getY()) * 2));
        return perimeter;
    }

    /**
     * This method calculates if a point is within the rectangles bounds.
     * @return true or false.
     */
    public boolean inBounds(Point user) {

        if(user.getX() >= lowerLeft.getX() && user.getX() <= upperRight.getX() && user.getY() >= lowerLeft.getY() && user.getY() <= upperRight.getY()) {
            return true;
        }else{
            return false;
        }
    }

    /**
     * This method calculates the width
     * @returns width
     */
    public double width() {
        double width = upperRight.getX() - lowerLeft.getX();
        return width;
    }

    /**
     * This method calculates the height
     * @returns height
     */
    public double height() {
        double height = upperRight.getY() - lowerLeft.getY();
        return height;
    }

    /**
     * This resets the position of the shape
     */
    public void setPosition(double x, double y) {

        double mx = width();
        double my = height();

        Point LL = new Point(x,y);
        Point UR = new Point(x + mx, y + my);

        Rectangle one = new Rectangle(LL, UR);

        this.lowerLeft = one.getLowerLeft();
        this.upperRight = one.getUpperRight();
    }

    /**
     * This resets the position of the shape using polar coordinates
     */
    public void setPolar(double radius, double angle) {
        double mx = width();
        double my = height();

        Point LL = new Point();
        LL.setPolar(radius, angle);

        Point UR = new Point(LL.getX() + mx, LL.getY() + my);

        Rectangle one = new Rectangle(LL, UR);

        this.lowerLeft = one.getLowerLeft();
        this.upperRight = one.getUpperRight();
    }

    /**
     * This method moves the shape by a certain amount
     */
    public void move(double dx, double dy) {
        Point LL = new Point(getLowerLeft().getX() + dx, getLowerLeft().getY() + dy);
        Point UR = new Point(getUpperRight().getX() + dx, getUpperRight().getY() + dy);

        Rectangle one = new Rectangle(LL, UR);

        this.lowerLeft = one.getLowerLeft();
        this.upperRight = one.getUpperRight();
    }

    /**
     * This method moves the shape by a certain amount using polar coordinates
     */
    public void movePolar(double radius, double angle) {
        Point LL = new Point(getLowerLeft().getX(), getLowerLeft().getY());
        Point UR = new Point(getUpperRight().getX(), getUpperRight().getY());

        LL.setPolar(LL.getRadius() + radius, LL.getAngle() + angle);
        UR.setPolar(UR.getRadius() + radius, UR.getAngle() + angle);

        Rectangle one = new Rectangle(LL, UR);

        this.lowerLeft = one.getLowerLeft();
        this.upperRight = one.getUpperRight();
    }

    /**
     * This method allows this shape to be cloneable
     */
    @Override
    public Rectangle clone() throws CloneNotSupportedException {
        Rectangle copy = (Rectangle) super.clone();
        copy.lowerLeft = (Point) lowerLeft.clone();
        copy.upperRight = (Point) upperRight.clone();

        return copy;
    }
}
