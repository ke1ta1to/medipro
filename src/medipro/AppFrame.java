package medipro;

import javax.swing.JFrame;

import medipro.controllers.GameController;
import medipro.controllers.StageController;
import medipro.models.GameModel;
import medipro.models.StageModel;
import medipro.views.GameView;
import medipro.views.StageView;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("medipro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StageModel stageModel = new StageModel();
        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);

        GameModel gameModel = new GameModel();
        GameController gameController = new GameController(gameModel);
        GameView gameView = new GameView(gameModel, gameController);

        gameView.setView(stageView);

        getContentPane().add(gameView);

        pack();
        setLocationRelativeTo(null);
    }

}
