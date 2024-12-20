package controllers;

import models.EntityModel;
import models.StageModel;

public class GameController {

    private final EntityModel stateModel;
    private final StageModel stageModel;
    private final StageController stageController;

    public GameController(EntityModel stateModel, StageModel stageModel, StageController stageController) {
        this.stateModel = stateModel;
        this.stageModel = stageModel;
        this.stageController = stageController;
    }

    public void start() {
        stageController.start();
    }

}
