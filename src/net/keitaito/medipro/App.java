package net.keitaito.medipro;

import java.awt.CardLayout;
import java.io.IOException;

import javax.swing.SwingUtilities;

import net.keitaito.medipro.app.AppController;
import net.keitaito.medipro.app.AppFrame;
import net.keitaito.medipro.app.AppModel;
import net.keitaito.medipro.app.AppView;
import net.keitaito.medipro.commands.CommandStore;
import net.keitaito.medipro.commands.HookCommand;
import net.keitaito.medipro.commands.JumpCommand;
import net.keitaito.medipro.commands.LeftCommand;
import net.keitaito.medipro.commands.RightCommand;
import net.keitaito.medipro.commands.StopCommand;
import net.keitaito.medipro.commands.UnhookCommand;
import net.keitaito.medipro.commands.WaitCommand;
import net.keitaito.medipro.gameclear.GameClearController;
import net.keitaito.medipro.gameclear.GameClearModel;
import net.keitaito.medipro.gameclear.GameClearView;
import net.keitaito.medipro.gameover.GameOverController;
import net.keitaito.medipro.gameover.GameOverModel;
import net.keitaito.medipro.gameover.GameOverView;
import net.keitaito.medipro.helpdialog.HelpDialogController;
import net.keitaito.medipro.helpdialog.HelpDialogModel;
import net.keitaito.medipro.helpdialog.HelpDialogView;
import net.keitaito.medipro.howtoplay.HowToPlayController;
import net.keitaito.medipro.howtoplay.HowToPlayModel;
import net.keitaito.medipro.howtoplay.HowToPlayPage1Controller;
import net.keitaito.medipro.howtoplay.HowToPlayPage1Model;
import net.keitaito.medipro.howtoplay.HowToPlayPage1View;
import net.keitaito.medipro.howtoplay.HowToPlayPage2Controller;
import net.keitaito.medipro.howtoplay.HowToPlayPage2Model;
import net.keitaito.medipro.howtoplay.HowToPlayPage2View;
import net.keitaito.medipro.howtoplay.HowToPlayView;
import net.keitaito.medipro.input.InputController;
import net.keitaito.medipro.input.InputModel;
import net.keitaito.medipro.input.InputView;
import net.keitaito.medipro.level.LevelController;
import net.keitaito.medipro.level.LevelModel;
import net.keitaito.medipro.level.LevelView;
import net.keitaito.medipro.menubar.MenuBarController;
import net.keitaito.medipro.menubar.MenuBarModel;
import net.keitaito.medipro.menubar.MenuBarView;
import net.keitaito.medipro.save.SaveManager;
import net.keitaito.medipro.setting.SettingController;
import net.keitaito.medipro.setting.SettingModel;
import net.keitaito.medipro.setting.SettingView;
import net.keitaito.medipro.sound.SoundModel;
import net.keitaito.medipro.stage.StageController;
import net.keitaito.medipro.stage.StageModel;
import net.keitaito.medipro.stage.StageView;
import net.keitaito.medipro.stagemenu.StageMenuController;
import net.keitaito.medipro.stagemenu.StageMenuModel;
import net.keitaito.medipro.stagemenu.StageMenuView;
import net.keitaito.medipro.stagemenubar.StageMenuBarModel;
import net.keitaito.medipro.top.TopController;
import net.keitaito.medipro.top.TopModel;
import net.keitaito.medipro.top.TopView;
import net.keitaito.medipro.workspace.WorkspaceController;
import net.keitaito.medipro.workspace.WorkspaceModel;
import net.keitaito.medipro.workspace.WorkspaceView;
import net.keitaito.medipro.worlds.World;
import net.keitaito.medipro.worlds.WorldLoader;
import net.keitaito.medipro.sound.SoundModel;

public class App {

    private static App app;

    public static World voidWorld;
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
    private HelpDialogModel helpDialogModel;
    private StageModel stageModel;
    private InputModel inputModel;
    private StageMenuBarModel stageMenuBarModel;
    private WorkspaceModel workspaceModel;
    private AppModel appModel;
    private TopModel topModel;
    private LevelModel levelModel;
    private SettingModel settingModel;
    private HowToPlayModel howToPlayModel;
    private SaveManager saveManager;
    private GameOverModel gameOverModel;
    private GameClearModel gameClearModel;
    private SoundModel soundModel;

    public void start() {
        System.out.println("Application started");

        saveManager = new SaveManager();

        commandStore = new CommandStore();
        commandStore.addCommand(new RightCommand());
        commandStore.addCommand(new LeftCommand());
        commandStore.addCommand(new WaitCommand());
        commandStore.addCommand(new StopCommand());
        commandStore.addCommand(new HookCommand());
        commandStore.addCommand(new UnhookCommand());
        commandStore.addCommand(new JumpCommand());

        AppFrame appFrame = new AppFrame();

        stageMenuModel = new StageMenuModel();
        StageMenuController stageMenuController = new StageMenuController(stageMenuModel);
        StageMenuView stageMenuView = new StageMenuView(stageMenuModel, stageMenuController);

        helpDialogModel = new HelpDialogModel();
        HelpDialogController helpDialogController = new HelpDialogController(helpDialogModel);
        HelpDialogView helpDialogView = new HelpDialogView(helpDialogModel, helpDialogController);

        gameOverModel = new GameOverModel();
        GameOverController gameOverController = new GameOverController(gameOverModel);
        GameOverView gameOverView = new GameOverView(gameOverModel, gameOverController);

        gameClearModel = new GameClearModel();
        GameClearController gameClearController = new GameClearController(gameClearModel);
        GameClearView gameClearView = new GameClearView(gameClearModel, gameClearController);

        stageModel = new StageModel();
        voidWorld = WorldLoader.loadWorld(stageModel, "0_void");
        worldLevel1 = WorldLoader.loadWorld(stageModel, "1_tutorial");
        worldLevel2 = WorldLoader.loadWorld(stageModel, "2_walking");
        worldLevel3 = WorldLoader.loadWorld(stageModel, "3_spike");
        worldLevel4 = WorldLoader.loadWorld(stageModel, "4_hook");
        worldLevel5 = WorldLoader.loadWorld(stageModel, "5_portal");
        worldLevel6 = WorldLoader.loadWorld(stageModel, "6_null");
        worldLevel7 = WorldLoader.loadWorld(stageModel, "7_null");
        worldLevel8 = WorldLoader.loadWorld(stageModel, "8_null");
        stageModel.setWorld(voidWorld);

        levelModel = new LevelModel();
        levelModel.setSelectedLevel(1);
        LevelController levelController = new LevelController(levelModel);
        LevelView levelView = new LevelView(levelModel, levelController);

        stageModel.setWorld(worldLevel1);
        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);
        stageView.setStageMenuView(stageMenuView);
        stageView.setHelpDialogView(helpDialogView);
        stageView.setGameOverView(gameOverView);
        stageView.setGameClearView(gameClearView);

        inputModel = new InputModel();
        InputController inputController = new InputController(inputModel);
        InputView inputView = new InputView(inputModel, inputController);

        workspaceModel = new WorkspaceModel();
        WorkspaceController workspaceController = new WorkspaceController(workspaceModel);
        WorkspaceView workspaceView = new WorkspaceView(workspaceModel, workspaceController);
        workspaceView.setInputView(inputView);
        workspaceView.setStageView(stageView);

        topModel = new TopModel();
        TopController topController = new TopController(topModel);
        TopView topView = new TopView(topModel, topController);

        settingModel = new SettingModel();
        SettingController settingController = new SettingController(settingModel);
        SettingView settingView = new SettingView(settingModel, settingController);

        HowToPlayPage1Model howToPlayPage1Model = new HowToPlayPage1Model();
        HowToPlayPage1Controller howToPlayPage1Controller = new HowToPlayPage1Controller(howToPlayPage1Model);
        HowToPlayPage1View howToPlayPage1View = new HowToPlayPage1View(howToPlayPage1Model, howToPlayPage1Controller);

        HowToPlayPage2Model howToPlayPage2Model = new HowToPlayPage2Model();
        HowToPlayPage2Controller howToPlayPage2Controller = new HowToPlayPage2Controller(howToPlayPage2Model);
        HowToPlayPage2View howToPlayPage2View = new HowToPlayPage2View(howToPlayPage2Model, howToPlayPage2Controller);

        howToPlayModel = new HowToPlayModel();
        HowToPlayController howToPlayController = new HowToPlayController(howToPlayModel);
        HowToPlayView howToPlayView = new HowToPlayView(howToPlayModel, howToPlayController);
        howToPlayView.addPage(howToPlayPage1View, HowToPlayModel.PAGE_NO1);
        howToPlayView.addPage(howToPlayPage2View, HowToPlayModel.PAGE_NO2);

        appModel = new AppModel();
        AppController appController = new AppController(appModel);
        AppView appView = new AppView(appModel, appController);
        appFrame.add(appView);
        appView.addView(workspaceView, AppModel.PAGE_WORKSPACE);
        appView.addView(topView, AppModel.PAGE_TITLE);
        appView.addView(levelView, AppModel.PAGE_LEVEL_SELECT);
        appView.addView(howToPlayView, AppModel.PAGE_HOW_TO_PLAY);
        appView.addView(settingView, AppModel.PAGE_SETTING);
        ((CardLayout) appView.getLayout()).show(appView, AppModel.PAGE_TITLE);

        MenuBarModel menuBarModel = new MenuBarModel();
        MenuBarController menuBarController = new MenuBarController(menuBarModel);
        MenuBarView menuBarView = new MenuBarView(menuBarModel, menuBarController);
        appFrame.setJMenuBar(menuBarView);

        appFrame.pack();
        appFrame.setLocationRelativeTo(null);
        appFrame.setVisible(true);

        soundModel = new SoundModel("nc400405_BGM.wav");
        soundModel.loop();
    }

    public static SoundModel getSoundModel() {
        SoundModel soundModel = app.soundModel;
        if (soundModel == null) {
            throw new IllegalStateException("soundModel is null");
        }
        return soundModel;
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

    public static HelpDialogModel getHelpDialogModel() {
        HelpDialogModel helpDialogModel = app.helpDialogModel;
        if (helpDialogModel == null) {
            throw new IllegalStateException("helpDialogModel is null");
        }
        return helpDialogModel;
    }

    public static GameOverModel getGameOverModel() {
        GameOverModel gameOverModel = app.gameOverModel;
        if (gameOverModel == null) {
            throw new IllegalStateException("gameOverModel is null");
        }
        return gameOverModel;
    }

    public static GameClearModel getGameClearModel() {
        GameClearModel gameClearModel = app.gameClearModel;
        if (gameClearModel == null) {
            throw new IllegalStateException("gameClearModel is null");
        }
        return gameClearModel;
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

    public static HowToPlayModel getHowToPlayModel() {
        HowToPlayModel howToPlayModel = app.howToPlayModel;
        if (howToPlayModel == null) {
            throw new IllegalStateException("howToPlayModel is null");
        }
        return howToPlayModel;
    }

    public static App getApp() {
        return app;
    }

    public static SaveManager getSaveManager() {
        SaveManager save = app.saveManager;
        if (save == null) {
            throw new IllegalStateException("save is null");
        }
        return save;
    }

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(() -> {
            if (app != null) {
                throw new IllegalStateException("App is already running");
            }
            app = new App();
            app.start();
        });
    }

}
