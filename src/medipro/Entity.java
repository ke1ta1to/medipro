package medipro;

public class Entity {

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

    public Entity() {
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

    @Override
    public String toString() {
        return "Entity [posX=" + posX + ", posY=" + posY + ", velX=" + velX + ", velY=" + velY + ", accX=" + accX
                + ", accY=" + accY + "]";
    }

}
