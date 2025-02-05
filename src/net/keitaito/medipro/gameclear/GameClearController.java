package net.keitaito.medipro.gameclear;

import java.awt.event.ActionEvent;

public class GameClearController {
    private final GameClearModel model;

    public GameClearController(GameClearModel model) {
        this.model = model;
    }

    public GameClearModel getModel() {
        return model;
    }

    public void handleClickCloseButton(ActionEvent event) {
        model.setOpen(false);
    }
}
