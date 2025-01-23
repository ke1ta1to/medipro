package medipro;

import java.awt.CardLayout;
import java.io.File;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import medipro.app.AppController;
import medipro.app.AppFrame;
import medipro.app.AppModel;
import medipro.app.AppView;
import medipro.commands.CommandStore;
import medipro.commands.HookCommand;
import medipro.commands.JumpCommand;
import medipro.commands.LeftCommand;
import medipro.commands.RightCommand;
import medipro.commands.StopCommand;
import medipro.commands.UnhookCommand;
import medipro.commands.WaitCommand;
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
import medipro.stage_menu.StageMenuController;
import medipro.stage_menu.StageMenuModel;
import medipro.stage_menu.StageMenuView;
import medipro.stage_menu_bar.StageMenuBarController;
import medipro.stage_menu_bar.StageMenuBarModel;
import medipro.stage_menu_bar.StageMenuBarView;
import medipro.subjects.CardSubject;
import medipro.top.TopController;
import medipro.top.TopModel;
import medipro.top.TopView;

public class App {

    private static App app;

    public static final String TOP_VIEW = "StartScreen";
    public static final String GAME_VIEW = "GameViewLevel1";
    public static final String LEVEL_VIEW = "levelPanel";
    public static final String SETTING_VIEW = "setting";

    public static World worldLevel1;
    public static World worldLevel2;
    public static World worldLevel3;
    public static World worldLevel4;
    public static World worldLevel5;
    public static World worldLevel6;
    public static World worldLevel7;
    public static World worldLevel8;

    private CommandStore commandStore;

    private StageMenuModel stageMenuModel;
    private StageModel stageModel;
    private InputModel inputModel;
    private StageMenuBarModel stageMenuBarModel;
    private AppModel appModel;
    private TopModel topModel;
    private LevelModel levelModel;
    private SettingModel settingModel;

    public void start() {
        System.out.println("Application started");
        commandStore = new CommandStore();
        commandStore.addCommand(new RightCommand());
        commandStore.addCommand(new LeftCommand());
        commandStore.addCommand(new WaitCommand());
        commandStore.addCommand(new StopCommand());
        commandStore.addCommand(new HookCommand());
        commandStore.addCommand(new UnhookCommand());
        commandStore.addCommand(new JumpCommand());

        AppFrame appFrame = new AppFrame();
        appFrame.add(createPanel());
        appFrame.pack();
        appFrame.setLocationRelativeTo(null);
        appFrame.setVisible(true);
    }

    private JPanel createPanel() {
        stageMenuModel = new StageMenuModel();
        StageMenuController stageMenuController = new StageMenuController(stageMenuModel);
        StageMenuView stageMenuView = new StageMenuView(stageMenuModel, stageMenuController);

        stageModel = new StageModel();
        worldLevel1 = stageModel.loadWorld(new File("src/medipro/world.txt"));
        worldLevel2 = stageModel.loadWorld(new File("src/medipro/world2.txt"));
        worldLevel3 = stageModel.loadWorld(new File("src/medipro/world3.txt"));
        worldLevel4 = stageModel.loadWorld(new File("src/medipro/world4.txt"));
        worldLevel5 = stageModel.loadWorld(new File("src/medipro/world5.txt"));
        worldLevel6 = stageModel.loadWorld(new File("src/medipro/world6.txt"));
        worldLevel7 = stageModel.loadWorld(new File("src/medipro/world7.txt"));
        worldLevel8 = stageModel.loadWorld(new File("src/medipro/world8.txt"));

        stageModel.setWorld(worldLevel1);
        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);
        stageView.setStageMenuView(stageMenuView);

        inputModel = new InputModel();
        InputController inputController = new InputController(inputModel);
        InputView inputView = new InputView(inputModel, inputController);

        stageMenuBarModel = new StageMenuBarModel();
        StageMenuBarController stageMenuBarController = new StageMenuBarController(stageMenuBarModel);
        StageMenuBarView stageMenuBarView = new StageMenuBarView(stageMenuBarModel, stageMenuBarController);

        appModel = new AppModel();
        AppController appController = new AppController(appModel);
        AppView appView = new AppView(appModel, appController);
        appView.setStageView(stageView);
        appView.setInputView(inputView);
        appView.setStageMenuBarView(stageMenuBarView);

        topModel = new TopModel();
        TopController topController = new TopController(topModel);
        TopView topView = new TopView(topModel, topController);

        levelModel = new LevelModel();
        LevelController levelController = new LevelController(levelModel);
        LevelView levelView = new LevelView(levelModel, levelController);

        settingModel = new SettingModel();
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

    public static CommandStore getCommandStore() {
        CommandStore commandStore = app.commandStore;
        if (commandStore == null) {
            throw new IllegalStateException("commandStore is null");
        }
        return commandStore;
    }

    public static StageMenuModel getStageMenuModel() {
        StageMenuModel stageMenuModel = app.stageMenuModel;
        if (stageMenuModel == null) {
            throw new IllegalStateException("stageMenuModel is null");
        }
        return stageMenuModel;
    }

    public static StageModel getStageModel() {
        StageModel stageModel = app.stageModel;
        if (stageModel == null) {
            throw new IllegalStateException("stageModel is null");
        }
        return stageModel;
    }

    public static InputModel getInputModel() {
        InputModel inputModel = app.inputModel;
        if (inputModel == null) {
            throw new IllegalStateException("inputModel is null");
        }
        return inputModel;
    }

    public static StageMenuBarModel getStageMenuBarModel() {
        StageMenuBarModel stageMenuBarModel = app.stageMenuBarModel;
        if (stageMenuBarModel == null) {
            throw new IllegalStateException("stageMenuBarModel is null");
        }
        return stageMenuBarModel;
    }

    public static AppModel getAppModel() {
        AppModel appModel = app.appModel;
        if (appModel == null) {
            throw new IllegalStateException("appModel is null");
        }
        return appModel;
    }

    public static TopModel getTopModel() {
        TopModel topModel = app.topModel;
        if (topModel == null) {
            throw new IllegalStateException("topModel is null");
        }
        return topModel;
    }

    public static LevelModel getLevelModel() {
        LevelModel levelModel = app.levelModel;
        if (levelModel == null) {
            throw new IllegalStateException("levelModel is null");
        }
        return levelModel;
    }

    public static SettingModel getSettingModel() {
        SettingModel settingModel = app.settingModel;
        if (settingModel == null) {
            throw new IllegalStateException("settingModel is null");
        }
        return settingModel;
    }

    public static App getApp() {
        return app;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            if (app != null) {
                throw new IllegalStateException("App is already running");
            }
            app = new App();
            app.start();
        });
    }

}
