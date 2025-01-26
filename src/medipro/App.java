package medipro;

import java.awt.CardLayout;

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
import medipro.how_to_play.HowToPlayPage1Controller;
import medipro.how_to_play.HowToPlayPage1Model;
import medipro.how_to_play.HowToPlayPage1View;
import medipro.how_to_play.HowToPlayPage2Controller;
import medipro.how_to_play.HowToPlayPage2Model;
import medipro.how_to_play.HowToPlayPage2View;
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
import medipro.workspace.WorkspaceController;
import medipro.workspace.WorkspaceModel;
import medipro.workspace.WorkspaceView;

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
        voidWorld = WorldLoader.loadWorld(stageModel, "void");
        worldLevel1 = WorldLoader.loadWorld(stageModel, "world1");
        worldLevel2 = WorldLoader.loadWorld(stageModel, "world2");
        worldLevel3 = WorldLoader.loadWorld(stageModel, "world3");
        worldLevel4 = WorldLoader.loadWorld(stageModel, "world4");
        worldLevel5 = WorldLoader.loadWorld(stageModel, "world5");
        worldLevel6 = WorldLoader.loadWorld(stageModel, "world6");
        worldLevel7 = WorldLoader.loadWorld(stageModel, "world7");
        worldLevel8 = WorldLoader.loadWorld(stageModel, "world8");
        stageModel.setWorld(voidWorld);

        StageController stageController = new StageController(stageModel);
        StageView stageView = new StageView(stageModel, stageController);
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

        levelModel = new LevelModel();
        LevelController levelController = new LevelController(levelModel);
        LevelView levelView = new LevelView(levelModel, levelController);

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

        settingModel = new SettingModel();
        SettingController settingController = new SettingController(settingModel);
        SettingView settingView = new SettingView(settingModel, settingController);

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
