package views;

import javax.swing.JFrame;

import views.game.GameView;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("Game Name");
        setLocation(100, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameView view = new GameView();
        setContentPane(view);

        pack();
    }

}
