package medipro.tiles;

import java.awt.Color;
import java.awt.Graphics;

import medipro.World;

public class GoalTile extends AirTile {

    public GoalTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLUE);
        g.fillRect(getX(), getY(), World.TILE_SIZE, World.TILE_SIZE);

        g.setColor(Color.BLACK);
        g.drawRect(getX(), getY(), World.TILE_SIZE, World.TILE_SIZE);
    }
}
