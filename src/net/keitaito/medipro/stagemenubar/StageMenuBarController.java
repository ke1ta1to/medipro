package net.keitaito.medipro.stagemenubar;

import java.awt.event.ActionEvent;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;
import net.keitaito.medipro.level.LevelModel;

public class StageMenuBarController {

    private final StageMenuBarModel model;
    private final LevelModel levelModel = App.getLevelModel();

    public StageMenuBarController(StageMenuBarModel model) {
        this.model = model;
    }

    public StageMenuBarModel getModel() {
        return model;
    }

    public void handleGoToTop(ActionEvent event) {
        App.getAppModel().setPageName(AppModel.PAGE_TITLE);
    }

    public void handleGoToStageLevel1(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel1);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        levelModel.setSelectedLevel(1);
    }

    public void handleGoToStageLevel2(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel2);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        levelModel.setSelectedLevel(2);
    }

    public void handleGoToStageLevel3(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel3);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        levelModel.setSelectedLevel(3);
    }

    public void handleGoToStageLevel4(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel4);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        levelModel.setSelectedLevel(4);
    }

    public void handleGoToStageLevel5(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel5);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        levelModel.setSelectedLevel(5);
    }

    public void handleGoToStageLevel6(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel6);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        levelModel.setSelectedLevel(6);
    }

    public void handleGoToStageLevel7(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel7);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        levelModel.setSelectedLevel(7);
    }

    public void handleGoToStageLevel8(ActionEvent event) {
        App.getStageModel().setWorld(App.worldLevel8);
        App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
        levelModel.setSelectedLevel(8);
    }

}
