package medipro.app;

import java.awt.CardLayout;
import java.io.File;

import javax.swing.JPanel;

import medipro.cardobserver.CardObserver;
import medipro.cardobserver.CardSubject;
import medipro.input.InputController;
import medipro.input.InputModel;
import medipro.input.InputView;
import medipro.stage.StageController;
import medipro.stage.StageModel;
import medipro.stage.StageView;
import medipro.top.TopModel;
import medipro.top.TopController;
import medipro.top.TopFrame;

import javax.swing.JFrame;

public class AppFrame extends JFrame implements CardObserver {

    private CardLayout cardLayout;
    private JPanel mainPanel;
    private AppController appController;

    public AppFrame() {
        super("medipro");

        CardSubject.addObserver(this);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        mainPanel = new JPanel(cardLayout);

        AppModel appModel = new AppModel();
        appController = new AppController(appModel, cardLayout, mainPanel);

        TopModel topModel = new TopModel();
        TopController topController = new TopController(topModel);
        TopFrame topFrame = new TopFrame(topModel, topController);

        JPanel topPanel = topFrame.getPanel();
        JPanel gamePanel = getGamePanel();

        mainPanel.add(topPanel, "StartScreen");
        mainPanel.add(gamePanel, "AppView");

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void update() {
        cardLayout.show(mainPanel, CardSubject.getCardNumber());
    }

    private JPanel getGamePanel() {
        File worldFile = new File("src/medipro/world.txt");

        StageModel stageModel = new StageModel();
        stageModel.loadWorld(worldFile);
        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);

        InputModel inputModel = new InputModel();
        InputController inputController = new InputController(inputModel);
        InputView inputView = new InputView(inputModel, inputController);

        AppModel appModel = appController.getModel();
        AppView appView = new AppView(appModel, appController);

        appView.setStageView(stageView);
        appView.setInputView(inputView);

        return appView;
    }
}
