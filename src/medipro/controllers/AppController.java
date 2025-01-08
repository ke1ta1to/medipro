package medipro.controllers;

import medipro.models.AppModel;

public class AppController {

    private final AppModel model;

    public AppController(AppModel model) {
        this.model = model;
    }

    public AppModel getModel() {
        return model;
    }

}
