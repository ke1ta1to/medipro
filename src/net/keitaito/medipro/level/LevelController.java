package net.keitaito.medipro.level;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;

public class LevelController implements ActionListener {

    private final LevelModel model;

    public LevelController(LevelModel model) {
        this.model = model;
    }

    public LevelModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "1":
                App.getStageModel().setWorld(App.worldLevel1);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "2":
                App.getStageModel().setWorld(App.worldLevel2);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "3":
                App.getStageModel().setWorld(App.worldLevel3);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "4":
                App.getStageModel().setWorld(App.worldLevel4);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "5":
                App.getStageModel().setWorld(App.worldLevel5);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "6":
                App.getStageModel().setWorld(App.worldLevel6);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "7":
                App.getStageModel().setWorld(App.worldLevel7);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "8":
                App.getStageModel().setWorld(App.worldLevel8);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "exit":
                App.getAppModel().setPageName(AppModel.PAGE_TITLE);
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
