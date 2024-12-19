package models;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class StageModel {

    private final StateModel stateModel;
    private List<StateLayerModel> stateLayers = new ArrayList<>();

    private int index = 0;

    public StageModel(StateModel stateModel) {
        this.stateModel = stateModel;

        stateLayers.add(new StateLayerModel(1000, true, false));
        stateLayers.add(new StateLayerModel(500, false, false));
        stateLayers.add(new StateLayerModel(500, false, true));
        stateLayers.add(new StateLayerModel(1000, false, false));
        stateLayers.add(new StateLayerModel(500, false, true));
        stateLayers.add(new StateLayerModel(0, false, false));
    }

    public List<StateLayerModel> getStateLayers() {
        return stateLayers;
    }

    public void setStateLayers(List<StateLayerModel> stateLayers) {
        this.stateLayers = stateLayers;
    }

    public void draw(Graphics g) {
        g.drawImage(stateModel.getImage(), (int) stateModel.getX(), (int) stateModel.getY(), 100, 100, null);
    }

    public synchronized void tick() {
        StateLayerModel currentStateLayer = stateLayers.get(index);

        stateModel.setX(stateModel.getX() + (currentStateLayer.isMoveRight() ? 0.1 : 0)
                - (currentStateLayer.isMoveLeft() ? 0.1 : 0));

        if (currentStateLayer.getWaiting() > 0) {
            currentStateLayer.setWaiting(currentStateLayer.getWaiting() - 1);
            return;
        }

        if (index < stateLayers.size() - 1) {
            index++;
        }
    }

    public StateLayerModel getCurrentStateLayer() {
        return stateLayers.get(index);
    }

    @Override
    public String toString() {
        return "StageModel [index=" + index + "]";
    }

}
