package net.keitaito.medipro.tiles;

import java.awt.Graphics;

public class AirTile extends Tile {

    public AirTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
    }

    @Override
    public boolean isSolid() {
        return false;
    }

}
