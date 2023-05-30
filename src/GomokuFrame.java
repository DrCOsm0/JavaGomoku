
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * <p>This class creates the frame in which the gomoku board will run on.
 * </p>
 */
public class GomokuFrame extends JFrame {

    private GomokuBoard board;
    private JLabel blackScore;
    private JLabel whiteScore;

    /**
     * This method sets up the frame and creates 2 JLabels for score keeping, a reset button, and a JPanel for the game.
     */
    public GomokuFrame() {

        board = new GomokuBoard(new GomokuAI());

        JPanel scorePannel = new JPanel();
        JPanel gamePannel = new JPanel();
        JPanel buttonPanel = new JPanel();

        scorePannel.setBackground(Color.decode("#ffd294"));
        gamePannel.setBackground(Color.decode("#ffd294"));
        buttonPanel.setBackground(Color.decode("#ffd294"));

        blackScore = new JLabel("Black: " + board.getBlackScore(), SwingConstants.CENTER);
        blackScore.setFont(new Font("SansSerif", Font.BOLD,25));
        whiteScore = new JLabel("White: " + board.getWhiteScore(), SwingConstants.CENTER);
        whiteScore.setFont(new Font("SansSerif", Font.BOLD,25));
        whiteScore.setForeground(Color.white);

        JButton resetButton = new JButton("New Game");
        resetButton.addActionListener(event -> board.resetGame());

        scorePannel.setLayout(new GridLayout(1,2));
        scorePannel.add(blackScore);
        scorePannel.add(whiteScore);
        gamePannel.add(board);
        buttonPanel.add(resetButton);

        setSize(735,820);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(scorePannel, BorderLayout.NORTH);
        add(gamePannel, BorderLayout.CENTER);
        //add(buttonPanel, BorderLayout.SOUTH);
        add(resetButton, BorderLayout.SOUTH);
        setVisible(true);

        board.addMouseListener(new MouseAdapter() {});

        board.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                blackScore.setText("Black: " + board.getBlackScore());
                whiteScore.setText("White: " + board.getWhiteScore());
            }
        });
    }

    public static void main(String[] args) {
        new GomokuFrame();
    }
}
