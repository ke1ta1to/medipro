package net.keitaito.medipro.tiles;

import java.awt.Graphics;

import net.keitaito.medipro.Entity;

public class GoalDummyTile extends Tile {

    public GoalDummyTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public boolean onCollide(Entity target) {
        // target.setGoal(true);
        // target.targetGoalAction();

        return false;
    }
}
