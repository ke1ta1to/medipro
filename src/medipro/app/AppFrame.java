package medipro.app;

import java.io.File;

import javax.swing.JFrame;

import medipro.input.InputController;
import medipro.input.InputModel;
import medipro.input.InputView;
import medipro.stage.StageController;
import medipro.stage.StageModel;
import medipro.stage.StageView;

public class AppFrame extends JFrame {

    public AppFrame() {
        super("medipro");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        File worldFile = new File("src/medipro/world.txt");

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
