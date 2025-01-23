package medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import medipro.Entity;
import medipro.World;

public class ThornTile extends Tile {

    private Image image = new ImageIcon(getClass().getResource(
            "/medipro/images/Throne.png")).getImage();

    public ThornTile(int x, int y) {
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
        target.targetDeathAction();
        target.resetStageModel();
    }

}
