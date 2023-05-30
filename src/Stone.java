
import java.awt.*;

/**
 * <p>This enum class creates different colors stones with their corresponding attributes.
 * </p>
 */
public enum Stone {

    EMPTY(null),
    BLACK(Color.BLACK),
    WHITE(Color.WHITE);

    private Color color;

    /**
     * This constructor adds stones to the enum.
     * @param color stone color
     */
    Stone(Color color) {
        this.color = color;
    }

    /**
     * This method returns thr color of the stone.
     * @return color
     */
    public Color getColor() {
        return color;
    }
}
