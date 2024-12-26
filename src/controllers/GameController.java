package controllers;

import models.EntityModel;
import models.StageModel;

public class GameController {

    private final EntityModel entityModel;
    private final StageModel stageModel;
    private final StageController stageController;

    public GameController(EntityModel entityModel, StageModel stageModel, StageController stageController) {
        this.entityModel = entityModel;
        this.stageModel = stageModel;
        this.stageController = stageController;
    }

    public void start() {
        stageController.start();
    }

}
