
/**
 * <p> This class is the interface of the geometry calculator.
 * </p>
 */
public interface Movable {

    void setPosition(double x, double y);
    void setPolar(double radius, double angle);
    void move(double dx, double dy);
    void movePolar(double radius, double angle);
}
