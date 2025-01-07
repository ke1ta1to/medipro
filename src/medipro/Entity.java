package medipro;

import java.awt.Image;

import medipro.models.StageModel;

public class Entity {

    private final StageModel stageModel;

    /**
     * 最大速度の大きさ（Y方向）
     */
    public static final double MAX_VEL_Y = 5.0;

    private double posX = 0;
    private double posY = 0;
    private double velX = 0;
    private double velY = 0;
    private double accX = 0;
    private double accY = 0;

    private Image image = null;

    private int width = 0;
    private int height = 0;

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
        if (Math.abs(velX) > MAX_VEL_Y) {
            this.velX = MAX_VEL_Y * (velX / Math.abs(velX));
        } else {
            this.velX = velX;
        }

        if (this.posX + this.velX < 0 || this.posX + this.velX + this.width > stageModel.getWorld().getWidth()) {
            this.velX = 0;
        }
    }

    public double getVelY() {
        return velY;
    }

    public void setVelY(double velY) {
        if (Math.abs(velY) > MAX_VEL_Y) {
            this.velY = MAX_VEL_Y * (velY / Math.abs(velY));
        } else {
            this.velY = velY;
        }

        if (this.posY + this.velY < 0 || this.posY + this.velY + this.height > stageModel.getWorld().getHeight()) {
            this.velY = 0;
        }
    }

    public double getAccX() {
        return accX;
    }

    public void setAccX(double accX) {
        this.accX = accX;
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

    @Override
    public String toString() {
        return "Entity [stageModel=" + stageModel + ", posX=" + posX + ", posY=" + posY + ", velX=" + velX + ", velY="
                + velY + ", accX=" + accX + ", accY=" + accY + ", width=" + width + ", height=" + height + "]";
    }

}
