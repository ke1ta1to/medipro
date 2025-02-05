package net.keitaito.medipro.stagemenu;

import java.awt.event.ActionEvent;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;

public class StageMenuController {

    private final StageMenuModel model;

    public StageMenuController(StageMenuModel model) {
        this.model = model;
    }

    public StageMenuModel getModel() {
        return model;
    }

    public void handleClose(ActionEvent event) {
        model.setOpen(false);
    }

    public void handleClickGoLevelSelect(ActionEvent e) {
        App.getAppModel().setPageName(AppModel.PAGE_LEVEL_SELECT);
        model.setOpen(false);

    }

    public void handleClickGoSetting(ActionEvent e) {
        App.getAppModel().setPageName(AppModel.PAGE_SETTING);
        model.setOpen(false);

    }

    public void handleClickExit(ActionEvent e) {
        App.getAppModel().setPageName(AppModel.PAGE_TITLE);
        model.setOpen(false);

    }

}
