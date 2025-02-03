package medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import medipro.App;
import medipro.Entity;
import medipro.World;

public class GoalTile extends AirTile {

    private Image image = new ImageIcon(getClass().getResource(
            "/medipro/images/GoalFlag.png")).getImage();

    public GoalTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
        g.drawImage(image, getX(), getY(), World.TILE_SIZE, World.TILE_SIZE, null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

    @Override
    public void onCollide(Entity target) {
        // TODO: ゴールした際の処理
        System.out.println("Goal!");
        App.getStageModel().reset();
    }
}
