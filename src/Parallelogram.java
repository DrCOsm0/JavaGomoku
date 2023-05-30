
/**
 * <p> This subclass uses the Rectangle class to create parallelograms with custom dimensions.
 * </p>
 */
public class Parallelogram extends Rectangle {

    private double skewAngle;

    /**
     * This method returns the skew angle
     */
    public double getSkewAngle() {
        return skewAngle;
    }


    /**
     * This method constructs a parallelogram with the corners at (0,0) and
     * (1,1) with a skew angle of pi/2 (90)
     */
    public Parallelogram() {
        super();
        this.skewAngle = Math.PI / 2;
    }

    /**
     * This method constructs a parallelogram with the corners at custom spots
     * and a user defined skew angle.
     */
    public Parallelogram(Point LL, Point UR, double angle) {

        super(LL, UR);

        this.skewAngle = angle;

        if (angle > Math.atan2(UR.getY() - LL.getY(), UR.getX() - LL.getX()) && angle < Math.PI) {
            this.skewAngle = angle;
        } else {
            this.skewAngle = Math.PI / 2;
        }
    }

    /**
     * This method calculates the base length
     */
    public double baseLength() {
        return height() / Math.tan(skewAngle);
    }

    /**
     * This method calculate and returns the lower right point
     */
    @Override
    public Point getLowerRight() {
        double LowerRightX = getUpperRight().getX() - baseLength();
        double LowerRightY = getLowerLeft().getY();
        Point LR = new Point(LowerRightX, LowerRightY);
        return LR;
    }

    /**
     * This method calculate and returns the upper left point
     */
    @Override
    public Point getUpperLeft() {
        double UpperLeftX = getLowerLeft().getX() + baseLength();
        double UpperLeftY = getUpperRight().getY();
        Point UL = new Point(UpperLeftX, UpperLeftY);
        return UL;
    }

    /**
     * This method calculates the width
     */
    @Override
    public double width() {
        if (skewAngle <= (Math.PI / 2)) {
            return getUpperRight().getX() - getLowerLeft().getX();
        } else {
            return (getUpperRight().getX() - getLowerLeft().getX()) - (2 * baseLength());
        }
    }

    /**
     * This method calculate the area
     */
    @Override
    public double area() {
        return (getUpperRight().getX() - getLowerLeft().getX() - baseLength()) * height();
    }

    /**
     * This method calculate the perimeter
     */
    @Override
    public double perimeter() {
        return ((getUpperRight().getX() - getLowerLeft().getX() - baseLength()) * 2) + ((height() / Math.sin(skewAngle) * 2));
    }

    /**
     * This method calculates of a user defined point is in the shapes bounds
     *
     * @return true or false
     */
    @Override
    public boolean inBounds(Point user) {


        if (skewAngle < Math.PI / 2) {

            if ((user.getY() - getLowerLeft().getY() <= (height() / baseLength()) * (user.getX() - getLowerLeft().getX())) && (user.getY() - getUpperRight().getY()
                    >= (height() / baseLength()) * (user.getX() - getUpperRight().getX()))) {

                return true;
            } else {
                return false;
            }
        } else {

            if ((user.getY() - getLowerLeft().getY() >= (height() / baseLength()) * (user.getX() - getLowerLeft().getX())) && (user.getY() - getUpperRight().getY()
                    <= (height() / baseLength()) * (user.getX() - getUpperRight().getX()))) {

                return true;
            } else {
                return false;
            }
        }
    }
}
