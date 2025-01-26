package medipro.setting;

import java.awt.event.ActionEvent;

import medipro.App;
import medipro.app.AppModel;

public class SettingController {
    private final SettingModel model;

    public SettingController(SettingModel model) {
        this.model = model;
    }

    public SettingModel getModel() {
        return model;
    }

    public void handleClickExit(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "exit":
                App.getAppModel().setPageName(AppModel.PAGE_TITLE);
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
