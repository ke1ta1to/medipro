package medipro.stage_menu;

import java.awt.event.ActionEvent;

import medipro.App;
import medipro.app.AppModel;

public class StageMenuController {

    private final StageMenuModel model;

    public StageMenuController(StageMenuModel model) {
        this.model = model;
    }

    public StageMenuModel getModel() {
        return model;
    }

    public void handleClose(ActionEvent event) {
        App.getStageModel().setOpenedMenu(false);
    }

    public void handleClickGoLevelSelect(ActionEvent e) {
        App.getAppModel().setPageName(AppModel.PAGE_LEVEL_SELECT);
        App.getStageModel().setOpenedMenu(false);
    }

    public void handleClickGoSetting(ActionEvent e) {
        App.getAppModel().setPageName(AppModel.PAGE_SETTING);
        App.getStageModel().setOpenedMenu(false);
    }

    public void handleClickExit(ActionEvent e) {
        App.getAppModel().setPageName(AppModel.PAGE_TITLE);
        App.getStageModel().setOpenedMenu(false);
    }

}
