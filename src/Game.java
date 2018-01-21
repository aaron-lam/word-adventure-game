import java.awt.*;
import javax.swing.*;

class Game {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            GameFrame gameFrame = new GameFrame();
            gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            gameFrame.setVisible(true);
        });
    }
}