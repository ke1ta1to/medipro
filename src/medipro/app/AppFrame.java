package medipro.app;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import medipro.cardobserver.CardObserver;
import medipro.cardobserver.CardSubject;
import medipro.input.InputController;
import medipro.input.InputModel;
import medipro.input.InputView;
import medipro.level.LevelController;
import medipro.level.LevelModel;
import medipro.level.LevelView;
import medipro.stage.StageController;
import medipro.stage.StageModel;
import medipro.stage.StageView;
import medipro.top.TopController;
import medipro.top.TopModel;
import medipro.top.TopView;

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
        TopView topView = new TopView(topModel, topController);

        File Level1 = new File("src/medipro/world.txt");
        JPanel gamePanel1 = getGamePanel(Level1);
        File Level2 = new File("src/medipro/world2.txt");
        JPanel gamePanel2 = getGamePanel(Level2);

        LevelModel levelModel = new LevelModel();
        LevelController levelController = new LevelController(levelModel);
        LevelView levelView = new LevelView(levelModel, levelController);

        mainPanel.add(topView, "StartScreen");
        mainPanel.add(gamePanel1, "GameViewLevel1");
        mainPanel.add(gamePanel2, "GameViewLevel2");
        mainPanel.add(levelView, "levelPanel");

        getContentPane().add(mainPanel);

        pack();
        setLocationRelativeTo(null);
    }

    @Override
    public void update() {
        cardLayout.show(mainPanel, CardSubject.getCardNumber());
    }

    /**
     * worldFileを読み取って新しく生成するように設計。
     * TODO: りさじゅうの位置を引数にしないと、レベル別の位置設定ができない。
     */
    private JPanel getGamePanel(File worldFile) {
        JPanel mainPanel = new JPanel(new BorderLayout());
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

        mainPanel.add(appView, BorderLayout.CENTER);
        JButton topRightButton = new JButton("三");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.add(topRightButton);
        mainPanel.add(buttonPanel, BorderLayout.NORTH);

        return mainPanel;
    }
}
