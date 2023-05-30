
import java.util.ArrayList;
import java.util.Random;
/**
 * <p>This class handles all the win detection as well and the AI move.
 * </p>
 */
public class GomokuAI implements GoPlayer {

    /**
     * This method checks for 5 in a row of ant color and returns the count of any repeating string it encounters.
     * @param stone stone array
     * @param startRow starting row
     * @param startColumn starting column
     * @param vStep vertical step
     * @param hStep horizontal step
     * @param numItem number of items to find in a row
     * @param valItem the value of item to find in a row.
     */
    public static int checkCell( Stone[][] stone, int startRow, int startColumn, int vStep, int hStep, int numItem, Stone valItem ) {

        int count = 0;

        for(int i = 0; i < numItem; i++) {
            int row = startRow + i * vStep;
            int column = startColumn + i * hStep;


            if(row < 0 || column < 0 || row >= 19 || column >= 19 || stone[row][column] != valItem){
                break;
            }

            if(stone[row][column] == valItem) {
                count++;
            }else{
                break;
            }
        }
        return count;
    }

    /**
     * This method checks for if black or white has 5 in a row.
     * @param stone stone arrau
     * @return stone color.
     */
    public Stone checkWinner(Stone[][] stone) {

        for(int i = 0; i < 19; i++) {
            for(int j = 0; j < 19; j++) {

                Stone p = stone[i][j];

                if(p == Stone.EMPTY) {
                    continue;
                }

                if(checkCell(stone, i, j, 0, 1, 5, p) == 5){
                    System.out.println();
                    return p;
                }

                if(checkCell(stone, i, j, 1, 0, 5, p) == 5){
                    return p;
                }

                if(checkCell(stone, i, j, 1, 1, 5, p) == 5){
                    return p;
                }

                if(checkCell(stone, i, j, 1, -1, 5, p) == 5){
                    return p;
                }
            }
        }
        return Stone.EMPTY;
    }

    /**
     * This method calculates a move for the AI
     * @param stone stone array
     * @return pair of coordinates
     */
    public int[] getMove(Stone[][] stone) {

        ArrayList<int []> emptyList = new ArrayList<int []>();

        int[] pair;
        int[] empty = null;

        for(int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {

                if(stone[j][i] == Stone.EMPTY) {
                    emptyList.add(pair = new int[]{j, i});
                }

            }
        }

        if(emptyList.size() != 0) {
            Random rand = new Random();
            int bound = emptyList.size() ;
            int random = rand.nextInt(bound);

            return emptyList.get(random);
        }else{
            return empty;
        }

    }
}
