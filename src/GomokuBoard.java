
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
/**
 * <p>This class handles all the game logic for the gomoku board.  It keeps track of player turns, AI, and positions
 * on the board.
 * </p>
 */
public class GomokuBoard extends JComponent {

    private GoPlayer ai;
    private Stone[][] stones;
    private int blackScore;
    private int whiteScore;
    private boolean gameOver;

    /**
     * This method returns black score
     * @return blackScore
     */
    public int getBlackScore() {
        return blackScore;
    }

    /**
     * This method returns white score
     * @return white score
     */
    public int getWhiteScore() {
        return whiteScore;
    }

    /**
     * This method returns game over status
     * @return game over
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * This constructor initializes the board and sets all cells to empty.  It also resets the scores and sets up
     * a new mouse listener.
     * @param player AI player
     */
    public GomokuBoard(GoPlayer player){
       this.ai = player;
       setPreferredSize(new Dimension(720,720));
       addMouseListener(new PlayHandler());
        this.blackScore = 0;
        this.whiteScore = 0;
        this.gameOver = false;
        this.stones = new Stone[19][19];

        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                stones[i][j] = Stone.EMPTY;
            }
        }
    }
    /**
     * This method paints the Go board on a graphical interface
     * @param g Graphics Interface
     */
    public void paintComponent(Graphics g) {

        try {
            BufferedImage bg = ImageIO.read(new File("bamboo.jpg"));
            g.drawImage(bg,0,0,null);
            Graphics2D g2 = (Graphics2D) g;

            Point LL = new Point(45,45);
            Point UR = new Point(80,80);
            Rectangle rectangle = new Rectangle(LL,UR);
            DrawShape.drawRectangle(g2,rectangle,Color.black);

            for(int i = 0; i < 18; i++) {

                if(i >= 1){
                    rectangle.move(-595,35);
                    DrawShape.drawRectangle(g2,rectangle,Color.black);
                }

                for(int j = 0; j < 17; j++) {
                    rectangle.move(35,0);
                    DrawShape.drawRectangle(g2,rectangle,Color.black);
                }
            }

            for(int i = 0; i < 19; i++) {
                for(int j = 0; j < 19; j++) {

                    if(stones[i][j] != Stone.EMPTY) {
                        Point center = new Point(45 + j * 35, 45 + i * 35);
                        Circle circle = new Circle(center, 16);

                        if(stones[i][j] == Stone.BLACK){
                            DrawShape.drawCircle(g2,circle,Color.black);
                        }

                        if(stones[i][j] == Stone.WHITE){
                            DrawShape.drawCircle(g2,circle,Color.white);
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method checks if black played a valid move.
     * @param i i coordinate
     * @param j j coordinate
     * @return true or false
     */
    public boolean playBlack(int i, int j) {
        if((i >= 0 && i <= 18 && j >= 0 && j <= 18) && stones[j][i] == Stone.EMPTY && !gameOver) {
            stones[j][i] = Stone.BLACK;
            repaint();
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method checks if white played a valid move.
     * @return true or false
     */
    public boolean playWhite() {
        int[] c = ai.getMove(stones);

        if(c == null) {
            return false;
        }

        if((c[0] >= 0 && c[0] <= 18 && c[1] >= 0 && c[1] <= 18) && stones[c[0]][c[1]] == Stone.EMPTY && !gameOver) {
            stones[c[0]][c[1]] = Stone.WHITE;
            repaint();
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method resets the game and sets all the cells to empty.
     */
    public void resetGame() {
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                stones[i][j] = Stone.EMPTY;
            }
        }
        this.gameOver = false;
        repaint();
    }

    /**
     * This class handles the game play between white and black.
     */
    private class PlayHandler extends MouseAdapter {
        /**
         * This method checks if the mouse has been clicked and continues the game when the player makes a move.
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = (int) Math.floor((e.getX() - 27.5) / 35.0);
            int y = (int) Math.floor((e.getY() - 27.5) / 35.0);

            if(playBlack(x,y)) {
                if(ai.checkWinner(stones) == Stone.BLACK) {
                    blackScore += 1;
                    gameOver = true;
                }
            }

            if(!gameOver) {
                if(playWhite()) {
                    if(ai.checkWinner(stones) == Stone.WHITE) {
                        whiteScore += 1;
                        gameOver = true;
                    }
                }else{
                    resetGame();
                }
            }
        }
    }
}
