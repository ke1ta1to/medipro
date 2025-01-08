package medipro.tiles;

import java.awt.Graphics;

import medipro.Entity;

public abstract class Tile {

    private int x;
    private int y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public abstract void draw(Graphics g);

    /**
     * このタイルに衝突判定があるかどうか
     * 
     * @return 衝突判定がある場合はtrue
     */
    public abstract boolean isSolid();

    /**
     * このタイルに衝突した際の処理
     * 
     * @param target 衝突したエンティティ
     */
    public void onCollide(Entity target) {
    }
}
