package medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import medipro.World;

public class WallInTile extends Tile {
    private final Image wallImage = loadImage("IceInBlock.png");

    public WallInTile(int x, int y) {
        super(x, y);
    }

    private Image loadImage(String name) {
        return new ImageIcon(getClass().getResource(
                "/medipro/images/" + name)).getImage();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(wallImage, getX(), getY(), World.TILE_SIZE, World.TILE_SIZE, null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
