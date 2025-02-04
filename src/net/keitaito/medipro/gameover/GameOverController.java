package net.keitaito.medipro.gameover;

import java.awt.event.ActionEvent;

public class GameOverController {
    private final GameOverModel model;

    public GameOverController(GameOverModel model) {
        this.model = model;
    }

    public GameOverModel getModel() {
        return model;
    }

    public void handleClickCloseButton(ActionEvent event) {
        model.setOpen(false);
    }
}
