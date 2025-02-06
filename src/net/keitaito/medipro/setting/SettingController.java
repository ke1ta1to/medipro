package net.keitaito.medipro.setting;

import java.awt.event.ActionEvent;
import java.io.IOException;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;
import net.keitaito.medipro.save.SaveData;
import net.keitaito.medipro.save.SaveManager;

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

    public void handleClickDestroySave(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "destroy":
                SaveData saveData = new SaveData();
                saveData.destroySave();
                try {
                    SaveManager.save(saveData);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
