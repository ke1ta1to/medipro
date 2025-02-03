package medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import medipro.World;

public class WallTile extends Tile {
    private final Image wallImage = loadImage("maptile_jimen_hyojo_center.png");

    public WallTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
        g.drawImage(wallImage, getX(), getY(), World.TILE_SIZE, World.TILE_SIZE, null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
