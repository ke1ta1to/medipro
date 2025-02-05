package net.keitaito.medipro;

import java.awt.CardLayout;

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
import net.keitaito.medipro.how_to_play.HowToPlayController;
import net.keitaito.medipro.how_to_play.HowToPlayModel;
import net.keitaito.medipro.how_to_play.HowToPlayPage1Controller;
import net.keitaito.medipro.how_to_play.HowToPlayPage1Model;
import net.keitaito.medipro.how_to_play.HowToPlayPage1View;
import net.keitaito.medipro.how_to_play.HowToPlayPage2Controller;
import net.keitaito.medipro.how_to_play.HowToPlayPage2Model;
import net.keitaito.medipro.how_to_play.HowToPlayPage2View;
import net.keitaito.medipro.how_to_play.HowToPlayView;
import net.keitaito.medipro.input.InputController;
import net.keitaito.medipro.input.InputModel;
import net.keitaito.medipro.input.InputView;
import net.keitaito.medipro.level.LevelController;
import net.keitaito.medipro.level.LevelModel;
import net.keitaito.medipro.level.LevelView;
import net.keitaito.medipro.menu_bar.MenuBarController;
import net.keitaito.medipro.menu_bar.MenuBarModel;
import net.keitaito.medipro.menu_bar.MenuBarView;
import net.keitaito.medipro.setting.SettingController;
import net.keitaito.medipro.setting.SettingModel;
import net.keitaito.medipro.setting.SettingView;
import net.keitaito.medipro.stage.StageController;
import net.keitaito.medipro.stage.StageModel;
import net.keitaito.medipro.stage.StageView;
import net.keitaito.medipro.stage_menu.StageMenuController;
import net.keitaito.medipro.stage_menu.StageMenuModel;
import net.keitaito.medipro.stage_menu.StageMenuView;
import net.keitaito.medipro.stage_menu_bar.StageMenuBarModel;
import net.keitaito.medipro.top.TopController;
import net.keitaito.medipro.top.TopModel;
import net.keitaito.medipro.top.TopView;
import net.keitaito.medipro.workspace.WorkspaceController;
import net.keitaito.medipro.workspace.WorkspaceModel;
import net.keitaito.medipro.workspace.WorkspaceView;
import net.keitaito.medipro.worlds.World;
import net.keitaito.medipro.worlds.WorldLoader;

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
    private StageModel stageModel;
    private InputModel inputModel;
    private StageMenuBarModel stageMenuBarModel;
    private WorkspaceModel workspaceModel;
    private AppModel appModel;
    private TopModel topModel;
    private LevelModel levelModel;
    private SettingModel settingModel;
    private HowToPlayModel howToPlayModel;

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

        stageMenuModel = new StageMenuModel();
        StageMenuController stageMenuController = new StageMenuController(stageMenuModel);
        StageMenuView stageMenuView = new StageMenuView(stageMenuModel, stageMenuController);

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
        StageView stageView = new StageView(stageModel, stageController, levelModel);
        stageView.setStageMenuView(stageMenuView);

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
