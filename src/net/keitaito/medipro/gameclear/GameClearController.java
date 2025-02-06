package net.keitaito.medipro.gameclear;

import java.awt.event.ActionEvent;

import net.keitaito.medipro.App;
import net.keitaito.mediproserver.Inputs;

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

    public void handleClickRegisterButton(String name) {
        Inputs input = new Inputs();
        input.setName(name);
        input.setWorld_name(App.getLevelModel().getSelectedLevel() + "");
        input.setInput_text(App.getInputModel().getText());
        App.getShareModel().registerInputs(input);

        model.setRegistered(true);
    }
}
