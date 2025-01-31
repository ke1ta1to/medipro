package net.keitaito.medipro.input_command_menu;

import java.awt.event.ActionEvent;

import net.keitaito.medipro.App;

public class InputCommandMenuController {

    private final InputCommandMenuModel model;

    public InputCommandMenuController(InputCommandMenuModel model) {
        this.model = model;
    }

    public InputCommandMenuModel getModel() {
        return model;
    }

    public void handleClose(ActionEvent event) {
        App.getInputModel().setOpenedMenu(false);
    }

    public void handleCommand(String command) {
        switch (command) {
            case "mainPanel":
                model.setPage("mainPanel");
                break;
            case "left":
                model.setPage("left");
                break;
            case "right":
                model.setPage("right");
                break;
            case "stop":
                model.setPage("stop");
                break;
            case "jump":
                model.setPage("jump");
                break;
            case "wait":
                model.setPage("wait");
                break;
            case "hook":
                model.setPage("hook");
                break;
            case "unhook":
                model.setPage("unhook");
                break;
            // Add more cases as needed
            default:
                throw new IllegalArgumentException("Unknown command: " + command);
        }
    }

}
