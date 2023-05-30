
/**
 * <p> This abstract class contains the function declarations for the subclasses
 * </p>
 */

public abstract class Shape implements Movable, Cloneable {

    abstract double width();
    abstract double height();
    abstract double area();
    abstract double perimeter();
    abstract boolean inBounds(Point point);

}
