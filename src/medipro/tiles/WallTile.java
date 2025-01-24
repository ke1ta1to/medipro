package medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class WallTile extends Tile {
    private final Image wallImage = loadImage("WallTest.png");

    public WallTile(int x, int y) {
        super(x, y);
    }

    private Image loadImage(String name) {
        return new ImageIcon(getClass().getResource(
                "/medipro/images/" + name)).getImage();
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(wallImage, getX(), getY(), null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }
}
