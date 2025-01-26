package net.keitaito.medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import net.keitaito.medipro.worlds.World;

public class WallTile extends Tile {
    private final Image wallImage = loadImage("Temp_Wall.png");

    public WallTile(int x, int y) {
        super(x, y);
    }

    private Image loadImage(String name) {
        return new ImageIcon(getClass().getClassLoader().getResource(
                "net/keitaito/medipro/images/" + name)).getImage();
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
