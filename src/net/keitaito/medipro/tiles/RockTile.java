package net.keitaito.medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import net.keitaito.medipro.worlds.World;

public class RockTile extends Tile {

    private Image image;

    public RockTile(int x, int y) {
        super(x, y);

        image = loadImage("RockTile.png");
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
        g.drawImage(image, getX(), getY(), World.TILE_SIZE, World.TILE_SIZE, null);
    }

    @Override
    public boolean isSolid() {
        return true;
    }

}
