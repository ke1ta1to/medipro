package net.keitaito.medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import net.keitaito.medipro.Entity;
import net.keitaito.medipro.worlds.World;

public class WarpTile extends Tile {

    private Image image = new ImageIcon(getClass().getClassLoader().getResource(
            "net/keitaito/medipro/images/WarpGate.png")).getImage();

    private WarpTile otherPoint;
    private boolean isCollided = false;

    public WarpTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
        g.drawImage(image, getX(), getY(), 2 * World.TILE_SIZE, 2 * World.TILE_SIZE, null);
    }

    @Override
    public boolean isSolid() {
        if (isCollided) {
            return false;
        }
        return true;
    }

    @Override
    public void onCollide(Entity target) {
        target.setPosX(otherPoint.getX() - (target.getWidth() / 2));
        target.setPosY(otherPoint.getY() - (target.getHeight() / 2));
        this.isCollided = true;
        otherPoint.setIsCollided(true);

    }

    public void setWarpPoint(WarpTile otherPoint) {
        this.otherPoint = otherPoint;
    }

    public void setIsCollided(boolean isCollided) {
        this.isCollided = isCollided;
    }

}
