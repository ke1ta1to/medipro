package net.keitaito.medipro.achievement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;

public class AchievementController implements ActionListener {

    private final AchievementModel model;

    public AchievementController(AchievementModel model) {
        this.model = model;
    }

    public AchievementModel getModel() {
        return model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        switch (command) {
            case "exit":
                App.getAppModel().setPageName(AppModel.PAGE_TITLE);
                break;
        }
    }
}
