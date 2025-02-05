package net.keitaito.medipro.menu_bar;

import java.awt.event.ActionEvent;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;

public class MenuBarController {

    private final MenuBarModel model;

    public MenuBarController(MenuBarModel model) {
        this.model = model;
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
                break;

            case "2":
                App.getStageModel().setWorld(App.worldLevel2);
                break;

            case "3":
                App.getStageModel().setWorld(App.worldLevel3);
                break;

            case "4":
                App.getStageModel().setWorld(App.worldLevel4);
                break;

            case "5":
                App.getStageModel().setWorld(App.worldLevel5);
                break;

            case "6":
                App.getStageModel().setWorld(App.worldLevel6);
                break;

            case "7":
                App.getStageModel().setWorld(App.worldLevel7);
                break;

            case "8":
                App.getStageModel().setWorld(App.worldLevel8);
                break;

            default:
                break;
        }
    }

}
