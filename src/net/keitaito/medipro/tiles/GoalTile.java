package net.keitaito.medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import net.keitaito.medipro.Entity;
import net.keitaito.medipro.worlds.World;

public class GoalTile extends Tile {

    private Image image;

    public GoalTile(int x, int y) {
        super(x, y);

        image = loadImage("GoalTile.png");
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
        g.drawImage(image, getX(), getY(), World.TILE_SIZE * 3, World.TILE_SIZE * 3, null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public boolean onCollide(Entity target) {
        target.setGoal(true);
        target.targetGoalAction();

        return true;
    }
}
