package medipro;

import javax.swing.JFrame;

import medipro.controllers.GameController;
import medipro.models.GameModel;
import medipro.views.GameView;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("medipro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GameModel gameModel = new GameModel();
        GameController gameController = new GameController(gameModel);
        GameView gameView = new GameView(gameModel, gameController);
        getContentPane().add(gameView);

        pack();
        setLocationRelativeTo(null);
    }

}
