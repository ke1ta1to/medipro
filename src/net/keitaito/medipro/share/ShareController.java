package net.keitaito.medipro.share;

import java.awt.event.ActionEvent;

import net.keitaito.medipro.App;

public class ShareController {

    private ShareModel model;

    public ShareController(ShareModel model) {
        this.model = model;
    }

    public ShareModel getModel() {
        return model;
    }

    public void handleClickTryButton(ActionEvent event) {
        model.setOpen(false);
        App.getInputModel().setText(event.getActionCommand());
    }

    public void handleClickCloseButton(ActionEvent event) {
        model.setOpen(false);
    }

}
