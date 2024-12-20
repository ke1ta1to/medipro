package models;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class StageModel {

    private final EntityModel stateModel;
    private final LanguageModel languageModel;
    private List<EntityStatusModel> statuses = new ArrayList<>();

    private int index = 0;

    public StageModel(EntityModel stateModel, LanguageModel languageModel) {
        this.stateModel = stateModel;
        this.languageModel = languageModel;
    }

    public void setCommand(String command) {
        languageModel.load(statuses, command);
    }

    public List<EntityStatusModel> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<EntityStatusModel> stateLayers) {
        this.statuses = stateLayers;
    }

    public void draw(Graphics g) {
        g.drawImage(stateModel.getImage(), (int) stateModel.getX(), (int) stateModel.getY(), 100, 100, null);
    }

    public void reset() {
        index = 0;
        stateModel.setX(200);
        stateModel.setY(200);
        statuses.clear();
    }

    public synchronized void tick() {
        EntityStatusModel currentStateLayer = getCurrentStateLayer();

        stateModel.setX(stateModel.getX() + (currentStateLayer.isMoveRight() ? 0.1 : 0)
                - (currentStateLayer.isMoveLeft() ? 0.1 : 0));

        if (currentStateLayer.getWaiting() > 0) {
            currentStateLayer.setWaiting(currentStateLayer.getWaiting() - 1);
            return;
        }

        if (index < statuses.size() - 1) {
            index++;
        }
    }

    public EntityStatusModel getCurrentStateLayer() {
        if (index >= statuses.size()) {
            return null;
        }

        return statuses.get(index);
    }

    @Override
    public String toString() {
        return "StageModel [index=" + index + "]";
    }

}
