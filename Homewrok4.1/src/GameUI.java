import javax.swing.*;
import java.awt.*;

public class GameUI {
    private static final int BALL_RADIUS = 20;
    private static final int PANEL_WIDTH = 1500;
    private static final int PANEL_HEIGHT = 1200;

    private int ballX;

    public GameUI() {
        ballX = PANEL_WIDTH / 2 - BALL_RADIUS;
    }

    public static void main(String[] args) {
        GameUI game = new GameUI();
        game.start();
    }

    private void start() {

        JFrame frame = new JFrame("Игровое поле");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(PANEL_WIDTH, PANEL_HEIGHT);


        JPanel gamePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);


                Image gameFieldImage = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Tushkan\\Desktop\\Fussballfeld.gif");
                g.drawImage(gameFieldImage, 0, 0, this);


                g.setColor(Color.RED);
                g.fillOval(ballX, PANEL_HEIGHT / 2 - BALL_RADIUS, BALL_RADIUS * 2, BALL_RADIUS * 2);
            }
        };

        frame.getContentPane().add(gamePanel);

   

        Timer animationTimer = new Timer(10, e -> {

            ballX += 1;

            if (ballX > PANEL_WIDTH - BALL_RADIUS) {
                ballX = -BALL_RADIUS;
            }

            gamePanel.repaint();
        });
        animationTimer.start();


        frame.setVisible(true);
    }
}