package net.keitaito.medipro.top;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;

public class TopController implements ActionListener {
    private TopModel model;

    public TopController(TopModel model) {
        this.model = model;
    }

    public TopModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        App.getSeModel().play();
        switch (command) {
            case "New Game Start":
                App.getLevelModel().setSelectedLevel(1);
                App.getInputModel().loadInputText();
                App.getStageModel().setWorld(App.worldLevel1);
                App.getAppModel().setPageName(AppModel.PAGE_WORKSPACE);
                App.getGameOverModel().setOpen(false);
                App.getGameClearModel().setOpen(false);
                App.getBgmModel().update("nc399501_StageBGM.wav");
                App.getBgmModel().loop();
                break;

            case "Level Select":
                App.getAppModel().setPageName(AppModel.PAGE_LEVEL_SELECT);
                break;

            case "Setting":
                App.getAppModel().setPageName(AppModel.PAGE_SETTING);
                break;

            case "How to Play":
                App.getAppModel().setPageName(AppModel.PAGE_HOW_TO_PLAY);
                break;

            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }
}
