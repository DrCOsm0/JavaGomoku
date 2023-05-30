

/**
 * <p> This subclass uses the Circle class to create ellipses with custom dimensions.
 */
public class Ellipse extends Circle {


    private double minorRadius;

    /**
     * This method returns the minor radius
     */
    public double getMinorRadius() {
        return minorRadius;
    }

    /**
     * This method sets the minor radius
     */
    public void setMinorRadius(double minorRadius) {
        this.minorRadius = minorRadius;
    }

    /**
     * This method generates an ellipse with radius one at (0,0)
     */
    public Ellipse() {
        super();
        this.minorRadius = 1;
    }

    /**
     * This method generates an ellipse with custom center point and
     * custom minor radius and normal radius
     */
    public Ellipse(Point center, double minorRadius, double radius) {
        super(center, radius);
        this.minorRadius = minorRadius;
    }

    /**
     * This method calculates the width
     */
    @Override
    public double width() {
        return getRadius() * 2;
    }

    /**
     * This method calculates the height
     */
    @Override
    public double height() {
        return minorRadius * 2;
    }

    /**
     * This method calculates the diameter
     */
    @Override
    public double diameter() {
        if(height() > width()) {
            return height();
        }else{
            return width();
        }
    }

    /**
     * This method calculates the area
     */
    @Override
    public double area() {
        return Math.PI * getRadius() * getMinorRadius();
    }

    /**
     * This method calculates the perimeter
     */
    @Override
    public double perimeter(){
        return (Math.sqrt(2) * Math.PI) * Math.sqrt(Math.pow(getRadius(), 2) + Math.pow(getMinorRadius(), 2));
    }

    /**
     * This method calculates if a user defined point is within the ellipse bounds
     */
    @Override
    public boolean inBounds(Point user) {
        if((((Math.pow(user.getX() - getCenter().getX(), 2)) / Math.pow(getRadius(), 2)) + ((Math.pow(user.getY() -
                getCenter().getY(), 2)) / Math.pow(getMinorRadius(), 2))) <= 1) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method returns a bounding box around the ellipse
     */
    @Override
    public Rectangle getBoundingBox() {
        Point LL = new Point(getCenter().getX() - getRadius(), getCenter().getY() - getMinorRadius());
        Point UR = new Point(getCenter().getX() + getRadius(), getCenter().getY() + getMinorRadius());
        Rectangle one = new Rectangle(LL, UR);
        return one;
    }

    /**
     * This method calculates the focal distance
     */
    public double focalDistance() {
        return Math.sqrt(Math.abs(Math.pow(getRadius(),2) - Math.pow(getMinorRadius() , 2)));
    }

    /**
     * This method calculates the eccentricity
     */
    public double eccentricity() {
        return focalDistance() / (Math.max(getRadius(), getMinorRadius()));
    }
}
