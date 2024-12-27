package medipro;

import javax.swing.JFrame;

import medipro.views.GameView;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("medipro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameView gameView = new GameView();
        getContentPane().add(gameView);

        pack();
        setLocationRelativeTo(null);
    }

}
