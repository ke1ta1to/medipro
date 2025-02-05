package net.keitaito.medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import net.keitaito.medipro.Entity;
import net.keitaito.medipro.worlds.World;

public class GoalTile extends AirTile {

    private Image image = new ImageIcon(getClass().getClassLoader().getResource(
            "net/keitaito/medipro/images/GoalFlag.png")).getImage();

    public GoalTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, getX(), getY(), World.TILE_SIZE, World.TILE_SIZE, null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void onCollide(Entity target) {
        target.setAlive(false);
        target.targetGoalAction();
    }
}
