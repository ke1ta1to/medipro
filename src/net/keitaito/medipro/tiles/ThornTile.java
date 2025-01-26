package net.keitaito.medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import net.keitaito.medipro.Entity;
import net.keitaito.medipro.worlds.World;

public class ThornTile extends Tile {
    private final Image thornImage = loadImage("Temp_Thorn.png");

    public ThornTile(int x, int y) {
        super(x, y);
    }

    private Image loadImage(String name) {
        return new ImageIcon(getClass().getResource("/medipro/images/" + name)).getImage();
    }

    @Override
    public void draw(Graphics g) {
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
    }

}
