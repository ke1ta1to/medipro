package controllers;

import models.StageModel;
import models.StateModel;

public class GameController {

    private final StateModel stateModel;
    private final StageModel stageModel;
    private final StageController stageController;

    public GameController(StateModel stateModel, StageModel stageModel, StageController stageController) {
        this.stateModel = stateModel;
        this.stageModel = stageModel;
        this.stageController = stageController;
    }

    public void start() {
        stageController.start();
    }

}
