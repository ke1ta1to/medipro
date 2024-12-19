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
    }

    public void setCommand(String command) {
        stateLayers.clear();
        String[] commands = command.split("\n");
        for (String c : commands) {
            String[] params = c.split(" ");
            int waiting = Integer.parseInt(params[0]);
            boolean moveRight = Boolean.parseBoolean(params[1]);
            boolean moveLeft = Boolean.parseBoolean(params[2]);
            stateLayers.add(new StateLayerModel(waiting, moveRight, moveLeft));
        }
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

    public void reset() {
        index = 0;
        stateModel.setX(200);
        stateModel.setY(200);
        stateLayers.clear();
    }

    public synchronized void tick() {
        StateLayerModel currentStateLayer = getCurrentStateLayer();

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
        if (index >= stateLayers.size()) {
            return null;
        }

        return stateLayers.get(index);
    }

    @Override
    public String toString() {
        return "StageModel [index=" + index + "]";
    }

}
