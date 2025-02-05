package net.keitaito.medipro.menubar;

import java.awt.event.ActionEvent;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;
import net.keitaito.medipro.level.LevelModel;

public class MenuBarController {

    private final MenuBarModel model;
    private final LevelModel levelModel;

    public MenuBarController(MenuBarModel model, LevelModel levelModel) {
        this.model = model;
        this.levelModel = levelModel;
    }

    public MenuBarModel getModel() {
        return model;
    }

    public void handleClickExit(ActionEvent event) {
        System.exit(0);
    }

    public void handleClickGoTitle(ActionEvent event) {
        App.getAppModel().setPageName(AppModel.PAGE_TITLE);
    }

    public void handleChangeStage(ActionEvent event) {
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);

        String stageNumber = event.getActionCommand();
        switch (stageNumber) {
            case "1":
                App.getStageModel().setWorld(App.worldLevel1);
                levelModel.setSelectedLevel(1);
                break;

            case "2":
                App.getStageModel().setWorld(App.worldLevel2);
                levelModel.setSelectedLevel(2);
                break;

            case "3":
                App.getStageModel().setWorld(App.worldLevel3);
                levelModel.setSelectedLevel(3);
                break;

            case "4":
                App.getStageModel().setWorld(App.worldLevel4);
                levelModel.setSelectedLevel(4);
                break;

            case "5":
                App.getStageModel().setWorld(App.worldLevel5);
                levelModel.setSelectedLevel(5);
                break;

            case "6":
                App.getStageModel().setWorld(App.worldLevel6);
                levelModel.setSelectedLevel(6);
                break;

            case "7":
                App.getStageModel().setWorld(App.worldLevel7);
                levelModel.setSelectedLevel(7);
                break;

            case "8":
                App.getStageModel().setWorld(App.worldLevel8);
                levelModel.setSelectedLevel(8);
                break;

            default:
                break;
        }
    }

}
