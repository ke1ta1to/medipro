package net.keitaito.medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import medipro.Entity;
import medipro.World;
import javax.swing.ImageIcon;

import net.keitaito.medipro.Entity;
import net.keitaito.medipro.worlds.World;

public class ThornTile extends Tile {
    private Image thornImage;

    public ThornTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
        thornImage = loadImage("ThornTile.png", stageLevel);
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
