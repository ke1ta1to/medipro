package medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import medipro.worlds.World;

public class RockTile extends Tile {

    private Image image = new ImageIcon(getClass().getResource(
            "/medipro/images/Rock.png")).getImage();

    public RockTile(int x, int y) {
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

}
