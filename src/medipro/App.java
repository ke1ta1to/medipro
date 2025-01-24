package medipro;

import java.awt.CardLayout;

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
import medipro.how_to_play.HowToPlayController;
import medipro.how_to_play.HowToPlayModel;
import medipro.how_to_play.HowToPlayView;
import medipro.input.InputController;
import medipro.input.InputModel;
import medipro.input.InputView;
import medipro.level.LevelController;
import medipro.level.LevelModel;
import medipro.level.LevelView;
import medipro.menu_bar.MenuBarController;
import medipro.menu_bar.MenuBarModel;
import medipro.menu_bar.MenuBarView;
import medipro.observers.CardSubject;
import medipro.observers.InputTextSubject;
import medipro.observers.WorldSubject;
import medipro.setting.SettingController;
import medipro.setting.SettingModel;
import medipro.setting.SettingView;
import medipro.stage.StageController;
import medipro.stage.StageModel;
import medipro.stage.StageView;
import medipro.stage_menu.StageMenuController;
import medipro.stage_menu.StageMenuModel;
import medipro.stage_menu.StageMenuView;
import medipro.stage_menu_bar.StageMenuBarModel;
import medipro.top.TopController;
import medipro.top.TopModel;
import medipro.top.TopView;
import medipro.utils.WorldLoader;

public class App {

    private static App app;

    private final CardSubject cardSubject;
    private final WorldSubject worldSubject;
    private final InputTextSubject inputTextSubject;

    public static final String TOP_VIEW = "StartScreen";
    public static final String GAME_VIEW = "GameViewLevel1";
    public static final String LEVEL_VIEW = "levelPanel";
    public static final String SETTING_VIEW = "setting";
    public static final String HOW_TO_PLAY = "howToPlay";

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
    private HowToPlayModel howToPlayModel;

    public App() {
        cardSubject = new CardSubject();
        worldSubject = new WorldSubject();
        inputTextSubject = new InputTextSubject();
    }

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

        MenuBarModel menuBarModel = new MenuBarModel();
        MenuBarController menuBarController = new MenuBarController(menuBarModel);
        MenuBarView menuBarView = new MenuBarView(menuBarModel, menuBarController);
        appFrame.setJMenuBar(menuBarView);

        appFrame.pack();
        appFrame.setLocationRelativeTo(null);
        appFrame.setVisible(true);

    }

    private JPanel createPanel() {
        stageMenuModel = new StageMenuModel();
        StageMenuController stageMenuController = new StageMenuController(stageMenuModel);
        StageMenuView stageMenuView = new StageMenuView(stageMenuModel, stageMenuController);

        stageModel = new StageModel();
        worldLevel1 = WorldLoader.loadWorld(stageModel, "world1");
        worldLevel2 = WorldLoader.loadWorld(stageModel, "world2");
        worldLevel3 = WorldLoader.loadWorld(stageModel, "world3");
        worldLevel4 = WorldLoader.loadWorld(stageModel, "world4");
        worldLevel5 = WorldLoader.loadWorld(stageModel, "world5");
        worldLevel6 = WorldLoader.loadWorld(stageModel, "world6");
        worldLevel7 = WorldLoader.loadWorld(stageModel, "world7");
        worldLevel8 = WorldLoader.loadWorld(stageModel, "world8");

        stageModel.setWorld(worldLevel1);
        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);
        stageView.setStageMenuView(stageMenuView);

        inputModel = new InputModel();
        InputController inputController = new InputController(inputModel);
        InputView inputView = new InputView(inputModel, inputController);

        // stageMenuBarModel = new StageMenuBarModel();
        // StageMenuBarController stageMenuBarController = new
        // StageMenuBarController(stageMenuBarModel);
        // StageMenuBarView stageMenuBarView = new StageMenuBarView(stageMenuBarModel,
        // stageMenuBarController);

        appModel = new AppModel();
        AppController appController = new AppController(appModel);
        AppView appView = new AppView(appModel, appController);
        appView.setStageView(stageView);
        appView.setInputView(inputView);
        // appView.setStageMenuBarView(stageMenuBarView);

        topModel = new TopModel();
        TopController topController = new TopController(topModel);
        TopView topView = new TopView(topModel, topController);

        levelModel = new LevelModel();
        LevelController levelController = new LevelController(levelModel);
        LevelView levelView = new LevelView(levelModel, levelController);

        settingModel = new SettingModel();
        SettingController settingController = new SettingController(settingModel);
        SettingView settingView = new SettingView(settingModel, settingController);

        howToPlayModel = new HowToPlayModel();
        HowToPlayController howToPlayController = new HowToPlayController(howToPlayModel);
        HowToPlayView howToPlayView = new HowToPlayView(howToPlayModel, howToPlayController);

        CardLayout cardLayout = new CardLayout();
        JPanel panel = new JPanel(cardLayout);
        getCardSubject().addObserver((cardNumber) -> {
            cardLayout.show(panel, cardNumber);
        });
        panel.add(topView, App.TOP_VIEW);
        panel.add(appView, App.GAME_VIEW);
        panel.add(levelView, App.LEVEL_VIEW);
        panel.add(settingView, App.SETTING_VIEW);
        panel.add(howToPlayView, App.HOW_TO_PLAY);

        return panel;
    }

    public static CardSubject getCardSubject() {
        CardSubject cardSubject = app.cardSubject;
        if (cardSubject == null) {
            throw new IllegalStateException("cardSubject is null");
        }
        return cardSubject;
    }

    public static WorldSubject getWorldSubject() {
        WorldSubject worldSubject = app.worldSubject;
        if (worldSubject == null) {
            throw new IllegalStateException("worldSubject is null");
        }
        return worldSubject;
    }

    public static InputTextSubject getInputTextSubject() {
        InputTextSubject inputTextSubject = app.inputTextSubject;
        if (inputTextSubject == null) {
            throw new IllegalStateException("inputTextSubject is null");
        }
        return inputTextSubject;
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
