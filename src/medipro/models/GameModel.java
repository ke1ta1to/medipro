package medipro.models;

import java.util.ArrayList;
import java.util.List;

import medipro.entities.Entity;
import medipro.entities.EntityAction;

public class GameModel {

    private final Entity entity;
    private final List<EntityAction> entityActions = new ArrayList<>();

    private int frame

    public GameModel() {
        entity = new Entity();
    }

    public Entity getEntity() {
        return entity;
    }

    public List<EntityAction> getEntityActions() {
        return entityActions;
    }

}
