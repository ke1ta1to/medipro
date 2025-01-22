package medipro.tiles;

import java.awt.Color;
import java.awt.Graphics;

import medipro.Entity;
import medipro.World;

public class WarpTile extends Tile {

    private WarpTile otherPoint;
    private boolean isCollided = false;

    public WarpTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.MAGENTA);
        g.fillRect(getX(), getY(), World.TILE_SIZE, World.TILE_SIZE);

        g.setColor(Color.BLACK);
        g.drawRect(getX(), getY(), World.TILE_SIZE, World.TILE_SIZE);
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
        target.setPosX(otherPoint.getX());
        target.setPosY(otherPoint.getY());
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
