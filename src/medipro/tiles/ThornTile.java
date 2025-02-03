package medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import medipro.Entity;
import medipro.World;

public class ThornTile extends Tile {
    private Image thornImage = loadImage("Temp_Thorn.png");

    public ThornTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
        g.drawImage(thornImage, getX(), getY(), World.TILE_SIZE, World.TILE_SIZE, null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void onCollide(Entity target) {
        target.setAlive(false);
        target.targetDeathAction();
    }

}
