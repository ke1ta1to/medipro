package net.keitaito.medipro.howtoplay;

import java.awt.event.ActionEvent;

import net.keitaito.medipro.App;
import net.keitaito.medipro.app.AppModel;

public class HowToPlayController {
    private final HowToPlayModel model;

    public HowToPlayController(HowToPlayModel model) {
        this.model = model;
    }

    public HowToPlayModel getModel() {
        return model;
    }

    public void handleClickBackButton(ActionEvent e) {
        model.previousPage();
    }

    public void handleClickNextButton(ActionEvent e) {
        model.nextPage();
    }

    public void handleClickExitButton(ActionEvent e) {
        App.getAppModel().setPageName(AppModel.PAGE_TITLE);
    }

}
