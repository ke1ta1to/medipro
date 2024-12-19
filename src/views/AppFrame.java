package views;

import javax.swing.JFrame;

import views.game.GamePanel;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("Game Name");
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel panel = new GamePanel();
        setContentPane(panel);

        pack();
    }

}
