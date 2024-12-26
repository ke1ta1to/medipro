package models;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class StageModel {

    private final EntityModel entityModel;
    private final LanguageModel languageModel;
    private List<EntityStatusModel> statuses = new ArrayList<>();

    private int tickCount = 0;
    private int tps = 0;
    private long lastTime = System.currentTimeMillis();

    private int index = 0;

    public StageModel(EntityModel entityModel, LanguageModel languageModel) {
        this.entityModel = entityModel;
        this.languageModel = languageModel;
    }

    public void setCommand(String command) {
        languageModel.load(statuses, command);
    }

    public List<EntityStatusModel> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<EntityStatusModel> statuses) {
        this.statuses = statuses;
    }

    public void draw(Graphics g) {
        g.drawImage(entityModel.getImage(), (int) entityModel.getX(), (int) entityModel.getY(), 100, 100, null);
    }

    public void reset() {
        index = 0;
        entityModel.setX(200);
        entityModel.setY(200);
        statuses.clear();
    }

    public synchronized void tick() {
        tickCount++;
        if (System.currentTimeMillis() - lastTime >= 1000) {
            lastTime = System.currentTimeMillis();
            tps = tickCount;
            tickCount = 0;
        }

        EntityStatusModel entityStatuses = getCurrentEntityStatusModel();

        entityModel.setX(entityModel.getX() + (entityStatuses.isMoveRight() ? 1 : 0)
                - (entityStatuses.isMoveLeft() ? 1 : 0));

        if (entityStatuses.getWaiting() > 0) {
            entityStatuses.setWaiting(entityStatuses.getWaiting() - 1);
            return;
        }

        if (index < statuses.size() - 1) {
            index++;
        }
    }

    public EntityStatusModel getCurrentEntityStatusModel() {
        if (index >= statuses.size()) {
            return null;
        }

        return statuses.get(index);
    }

    public int getTps() {
        return tps;
    }

    @Override
    public String toString() {
        return "StageModel [tps=" + tps + ", index=" + index + "]";
    }

}
