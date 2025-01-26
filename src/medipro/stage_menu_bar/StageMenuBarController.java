package medipro.stage_menu_bar;

import java.awt.event.ActionListener;

import medipro.App;
import medipro.app.AppModel;

public class StageMenuBarController {

    private final StageMenuBarModel model;

    public StageMenuBarController(StageMenuBarModel model) {
        this.model = model;
    }

    public StageMenuBarModel getModel() {
        return model;
    }

    public ActionListener handleGoToTop() {
        return e -> {
            App.getAppModel().setPageName(AppModel.PAGE_TITLE);
        };
    }

    public ActionListener handleGoToStageLevel1() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel1);
            App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        };
    }

    public ActionListener handleGoToStageLevel2() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel2);
            App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        };
    }

    public ActionListener handleGoToStageLevel3() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel3);
            App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        };
    }

    public ActionListener handleGoToStageLevel4() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel4);
            App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        };
    }

    public ActionListener handleGoToStageLevel5() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel5);
            App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        };
    }

    public ActionListener handleGoToStageLevel6() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel6);
            App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        };
    }

    public ActionListener handleGoToStageLevel7() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel7);
            App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        };
    }

    public ActionListener handleGoToStageLevel8() {
        return e -> {
            App.getStageModel().setWorld(App.worldLevel8);
            App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        };
    }

}
