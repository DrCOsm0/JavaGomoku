
import java.util.Comparator;

/**
 * <p> This class contains methods to compare different shapes by their area.
 * </p>
 */
public class ShapeAreaComparator implements Comparator<Shape> {

    /**
     * This method compares areas of 2 shapes
     * @param o1 shape 1
     * @param o2 shape 2
     * @return -1,1,0
     */
    @Override
    public int compare(Shape o1, Shape o2) {

        if(o1.area() < o2.area()) {
            return -1;

        } else if(o1.area() > o2.area()) {
            return 1;

        } else {
            return 0;
        }
    }
}
