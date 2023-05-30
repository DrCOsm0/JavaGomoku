
import java.awt.*;
/**
 * <p>This class has 3 methods that assist in the grapgical creation of a shape.  These shapes include Points,
 * Rectangles, and Circles.
 * </p>
 */

public class DrawShape {

    /**
     * This method draws a Point
     * @param g Graphics Processor
     * @param point Geometry Point
     * @param color color
     */
    public static void drawPoint(Graphics2D g, Point point, Color color) {
        Color o_color = g.getColor();
        g.setColor(color);
        g.drawOval((int) Math.round(point.getX()), (int) Math.round(point.getY()), 1,1);
        g.setColor(o_color);
    }

    /**
     * This method draws a Rectangle
     * @param g Graphics Processor
     * @param rectangle Geometry Rectangle
     * @param color color
     */
    public static void drawRectangle(Graphics2D g, Rectangle rectangle, Color color) {
        Color o_color = g.getColor();
        g.setColor(color);
        g.drawRect((int) Math.round(rectangle.getLowerLeft().getX()) ,(int) Math.round(rectangle.getLowerLeft().getY()),
                (int) Math.round(rectangle.width()), (int) Math.round(rectangle.height()));
        g.setColor(o_color);
    }

    /**
     * This method draws a Circle
     * @param g Graphics Processor
     * @param circle Geometry Circle
     * @param color color
     */
    public static void drawCircle(Graphics2D g, Circle circle, Color color) {
        Color o_color = g.getColor();
        g.setColor(color);
        g.fillOval((int) Math.round(circle.getBoundingBox().getLowerLeft().getX()), (int) Math.round(circle.getBoundingBox().getLowerLeft().getY()),
                (int) Math.round(circle.width()), (int) Math.round(circle.height()));
        g.setColor(o_color);
    }
}
