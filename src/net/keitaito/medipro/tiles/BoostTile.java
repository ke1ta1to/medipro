package net.keitaito.medipro.tiles;

import java.awt.Graphics;
import java.awt.Image;

import net.keitaito.medipro.Entity;
import net.keitaito.medipro.worlds.World;

public class BoostTile extends Tile {
    private Image thornImage = loadImage("GoalFlag.png");
    private boolean isBoosted = false;

    public BoostTile(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(Graphics g, int stageLevel) {
        // thornImage = loadImage("ThornTile.png", stageLevel);
        if (!isBoosted) {
            g.drawImage(thornImage, getX(), getY(), World.TILE_SIZE, World.TILE_SIZE, null);
        }
    }

    @Override
    public boolean isSolid() {
        if (isBoosted) {
            return false;
        }
        return true;
    }

    @Override
    public boolean onCollide(Entity target) {
        // 速度と加速度を変更
        /*
         * if (target.getVelX() < 0.5) {
         * target.setVelX(1);
         * } else {
         * target.setVelX(target.getVelX() * 2);
         * }
         */
        // ブーストされている場合は何もしない
        if (isBoosted) {
            return false;
        }
        System.out.println("BoostTile!!!");
        target.setVelX(target.getVelX() * 2);
        if (target.getVelY() > 0) {
            target.setVelY(target.getVelY() * 2);
        }
        isBoosted = true;

        return false;
    }

    public void reset() {
        isBoosted = false;
    }

}
