package medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

import medipro.Entity;
import medipro.World;

public class ThornTile extends Tile {
    private Image thornImage = loadImage("Temp_Thorn.png", 1);

    public ThornTile(int x, int y) {
        super(x, y);
    }

    private Image loadImage(String name, int stageNo) {
        return new ImageIcon(getClass().getResource("/medipro/images/" + stageNo + "/" + name)).getImage();
    }

    private Image loadImage(String name) {
        return new ImageIcon(getClass().getResource("/medipro/images/" + name)).getImage();
    }

    @Override
    public void draw(Graphics g, int stageNo) {
        thornImage = loadImage("Temp_Thorn.png", stageNo);
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
        target.resetStageModel();
    }

}
