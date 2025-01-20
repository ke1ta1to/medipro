package medipro;

import java.awt.CardLayout;
import java.io.File;

import javax.swing.JPanel;

import medipro.app.AppController;
import medipro.app.AppFrame;
import medipro.app.AppModel;
import medipro.app.AppView;
import medipro.input.InputController;
import medipro.input.InputModel;
import medipro.input.InputView;
import medipro.level.LevelController;
import medipro.level.LevelModel;
import medipro.level.LevelView;
import medipro.setting.SettingController;
import medipro.setting.SettingModel;
import medipro.setting.SettingView;
import medipro.stage.StageController;
import medipro.stage.StageModel;
import medipro.stage.StageView;
import medipro.stage_menu_bar.StageMenuBarController;
import medipro.stage_menu_bar.StageMenuBarModel;
import medipro.stage_menu_bar.StageMenuBarView;
import medipro.subjects.CardSubject;
import medipro.top.TopController;
import medipro.top.TopModel;
import medipro.top.TopView;

public class App {

    public static final String TOP_VIEW = "StartScreen";
    public static final String GAME_VIEW = "GameViewLevel1";
    public static final String LEVEL_VIEW = "levelPanel";
    public static final String SETTING_VIEW = "setting";

    public static World worldLevel1;
    public static World worldLevel2;

    public void start() {
        System.out.println("Application started");
        AppFrame appFrame = new AppFrame();
        appFrame.add(createPanel());
        appFrame.pack();
        appFrame.setLocationRelativeTo(null);
        appFrame.setVisible(true);
    }

    private JPanel createPanel() {
        StageModel stageModel = new StageModel();
        worldLevel1 = stageModel.loadWorld(new File("src/medipro/world.txt"));
        worldLevel2 = stageModel.loadWorld(new File("src/medipro/world2.txt"));
        stageModel.setWorld(worldLevel1);
        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);

        InputModel inputModel = new InputModel();
        InputController inputController = new InputController(inputModel);
        InputView inputView = new InputView(inputModel, inputController);

        StageMenuBarModel stageMenuBarModel = new StageMenuBarModel();
        StageMenuBarController stageMenuBarController = new StageMenuBarController(stageMenuBarModel);
        StageMenuBarView stageMenuBarView = new StageMenuBarView(stageMenuBarModel, stageMenuBarController);

        AppModel appModel = new AppModel();
        AppController appController = new AppController(appModel);
        AppView appView = new AppView(appModel, appController);
        appView.setStageView(stageView);
        appView.setInputView(inputView);
        appView.setStageMenuBarView(stageMenuBarView);

        TopModel topModel = new TopModel();
        TopController topController = new TopController(topModel);
        TopView topView = new TopView(topModel, topController);

        LevelModel levelModel = new LevelModel();
        LevelController levelController = new LevelController(levelModel);
        LevelView levelView = new LevelView(levelModel, levelController);

        SettingModel settingModel = new SettingModel();
        SettingController settingController = new SettingController(settingModel);
        SettingView settingView = new SettingView(settingModel, settingController);

        CardLayout cardLayout = new CardLayout();
        JPanel panel = new JPanel(cardLayout);
        CardSubject.addObserver(() -> {
            cardLayout.show(panel, CardSubject.getCardNumber());
        });
        panel.add(topView, App.TOP_VIEW);
        panel.add(appView, App.GAME_VIEW);
        panel.add(levelView, App.LEVEL_VIEW);
        panel.add(settingView, App.SETTING_VIEW);

        return panel;
    }

    public static void main(String[] args) {
        App app = new App();
        app.start();
    }

}
