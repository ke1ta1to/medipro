package medipro;

import java.io.File;

import javax.swing.JFrame;

import medipro.controllers.AppController;
import medipro.controllers.InputController;
import medipro.controllers.StageController;
import medipro.models.AppModel;
import medipro.models.InputModel;
import medipro.models.StageModel;
import medipro.views.AppView;
import medipro.views.InputView;
import medipro.views.StageView;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("medipro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        File worldFile = new File(getClass().getResource("world.txt").getFile());

        StageModel stageModel = new StageModel();
        stageModel.loadWorld(worldFile);
        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);

        InputModel inputModel = new InputModel();
        InputController inputController = new InputController(inputModel);
        InputView inputView = new InputView(inputModel, inputController);

        AppModel appModel = new AppModel();
        AppController appController = new AppController(appModel);
        AppView appView = new AppView(appModel, appController);

        appView.setStageView(stageView);
        appView.setInputView(inputView);

        getContentPane().add(appView);

        pack();
        setLocationRelativeTo(null);
    }

}
