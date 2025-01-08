package medipro.controllers;

import medipro.models.InputModel;

public class InputController {

    private final InputModel inputModel;

    public InputController(InputModel inputModel) {
        this.inputModel = inputModel;
    }

    public InputModel getModel() {
        return inputModel;
    }

}
