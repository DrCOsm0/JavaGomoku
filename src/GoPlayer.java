
/**
 * <p>This interface class constructs 2 AI methods for the gomoku AI.
 * </p>
 */
public interface GoPlayer {

    public Stone checkWinner(Stone[][] stone);
    public int[] getMove(Stone[][] stone);

}
