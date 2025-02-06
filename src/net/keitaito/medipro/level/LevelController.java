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
        App.getGameOverModel().setOpen(false);
        App.getGameClearModel().setOpen(false);
        String command = e.getActionCommand();
        switch (command) {
            case "1":
                model.setSelectedLevel(1);
                App.getInputModel().loadInputText();
                App.getStageModel().setWorld(App.worldLevel1);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "2":
                model.setSelectedLevel(2);
                App.getInputModel().loadInputText();
                App.getStageModel().setWorld(App.worldLevel2);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "3":
                model.setSelectedLevel(3);
                App.getInputModel().loadInputText();
                App.getStageModel().setWorld(App.worldLevel3);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "4":
                model.setSelectedLevel(4);
                App.getInputModel().loadInputText();
                App.getStageModel().setWorld(App.worldLevel4);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "5":
                model.setSelectedLevel(5);
                App.getInputModel().loadInputText();
                App.getStageModel().setWorld(App.worldLevel5);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "6":
                model.setSelectedLevel(6);
                App.getInputModel().loadInputText();
                App.getStageModel().setWorld(App.worldLevel6);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "7":
                model.setSelectedLevel(7);
                App.getInputModel().loadInputText();
                App.getStageModel().setWorld(App.worldLevel7);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                break;

            case "8":
                model.setSelectedLevel(8);
                App.getInputModel().loadInputText();
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
