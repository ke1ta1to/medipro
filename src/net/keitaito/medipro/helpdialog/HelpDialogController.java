package net.keitaito.medipro.helpdialog;

import java.awt.event.ActionEvent;

public class HelpDialogController {

    private final HelpDialogModel model;

    public HelpDialogController(HelpDialogModel model) {
        this.model = model;
    }

    public HelpDialogModel getModel() {
        return model;
    }

    public void handleClickCloseButton(ActionEvent event) {
        model.setOpen(false);
    }

}
