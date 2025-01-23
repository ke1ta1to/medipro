package medipro;

import java.awt.Image;

import medipro.stage.StageModel;
import medipro.tiles.Tile;

public class Entity {

    private final StageModel stageModel;

    private double posX = 0;
    private double posY = 0;
    private double velX = 0;
    private double velY = 0;
    private double accX = 0;
    private double accY = 0;

    private Image image = null;

    private int width = 0;
    private int height = 0;

    private boolean isOnGround = false;
    private boolean isAlive = true;

    public Entity(StageModel stageModel) {
        this.stageModel = stageModel;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }

    public double getVelX() {
        return velX;
    }

    public void setVelX(double velX) {
        this.velX = velX;

        if (this.posX + this.velX < 0) {
            this.velX = 0;
        }

        if (this.posX + this.velX + this.width > stageModel.getWorld().getWidth()) {
            this.velX = 0;
        }

        Tile leftTile = getCollisionTileOnLeft(this.posX + this.velX);
        if (leftTile != null) {
            this.velX = 0;
            leftTile.onCollide(this);
        }

        Tile rightTile = getCollisionOnRight(this.posX + this.velX);
        if (rightTile != null) {
            this.velX = 0;
            rightTile.onCollide(this);
        }
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        this.velY = velY;

        if (this.posY + this.velY < 0) {
            this.velY = 0;
            this.posY = 0;
        }

        if (this.posY + this.velY + this.height > stageModel.getWorld().getHeight()) {
            this.velY = 0;
        }

        Tile topTile = getCollisionOnTop(this.posY + this.velY);
        if (topTile != null) {
            this.velY = 0;
            topTile.onCollide(this);
        }

        Tile groundTile = getCollisionOnBottom(this.posY + this.velY);
        if (groundTile != null) {
            this.velY = 0;
            groundTile.onCollide(this);
            this.isOnGround = true;
        } else {
            this.isOnGround = false;
        }

        if (this.posY + this.height > 599) {
            setAlive(false);
            targetDeathAction();
            resetStageModel();
        }
    }

    public double getAccX() {
        return accX;
    }

    public void setAccX(double accX) {
        this.accX = accX + (-0.025 * this.velX);

        if (this.isOnGround && Math.abs(this.velX) > 0.05) {
            if (this.velX > 0) {
                this.accX -= 0.1;
            } else if (this.velX < 0) {
                this.accX += 0.1;
            }
        }
    }

    public double getAccY() {
        return accY;
    }

    public void setAccY(double accY) {
        this.accY = accY;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isOnGround() {
        return this.isOnGround;
    }

    public boolean isAlive() {
        return this.isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }

    public void resetStageModel() {
        stageModel.reset();
    }

    public void targetDeathAction() {
        // TODO: ターゲットが死んだときのアクションを追加する。
    }

    @Override
    public String toString() {
        return "Entity [stageModel=" + stageModel + ", posX=" + posX + ", posY=" + posY + ", velX=" + velX + ", velY="
                + velY + ", accX=" + accX + ", accY=" + accY + ", width=" + width + ", height=" + height + "]";
    }

    public Tile getCollisionTileOnLeft(double newPosX) {
        double[] checkPointsY = {
                this.posY, // 上端
                this.posY + this.height / 3, // 高さの1/3位置
                this.posY + this.height / 3 * 2, // 高さの2/3位置
                this.posY + this.height // 下端
        };
        for (double checkPointY : checkPointsY) {
            Tile tile = stageModel.getWorld().getTileAt(newPosX, checkPointY);
            if (tile != null && tile.isSolid()) {
                return tile;
            }
        }
        return null;
    }

    public Tile getCollisionOnRight(double newPosX) {
        double[] checkPointsY = {
                this.posY, // 上端
                this.posY + this.height / 3, // 高さの1/3位置
                this.posY + this.height / 3 * 2, // 高さの2/3位置
                this.posY + this.height // 下端
        };
        for (double checkPointY : checkPointsY) {
            Tile tile = stageModel.getWorld().getTileAt(newPosX + this.width, checkPointY);
            if (tile != null && tile.isSolid()) {
                return tile;
            }
        }
        return null;
    }

    public Tile getCollisionOnTop(double newPosY) {
        double[] checkPointsX = {
                this.posX, // 左端
                this.posX + this.width / 3, // 幅の1/3位置
                this.posX + this.width / 3 * 2, // 幅の2/3位置
                this.posX + this.width // 右端
        };
        for (double checkPointX : checkPointsX) {
            Tile tile = stageModel.getWorld().getTileAt(checkPointX, newPosY);
            if (tile != null && tile.isSolid()) {
                return tile;
            }
        }
        return null;
    }

    public Tile getCollisionOnBottom(double newPosY) {
        double[] checkPointsX = {
                this.posX, // 左端
                this.posX + this.width / 3, // 幅の1/3位置
                this.posX + this.width / 3 * 2, // 幅の2/3位置
                this.posX + this.width // 右端
        };
        for (double checkPointX : checkPointsX) {
            Tile tile = stageModel.getWorld().getTileAt(checkPointX, newPosY + this.height);
            if (tile != null && tile.isSolid()) {
                return tile;
            }
        }
        return null;
    }

}
