package models;

import java.awt.Image;

public class EntityModel {

    private double x;
    private double y;
    private Image image;

    public EntityModel(double x, double y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public EntityModel() {
        this(0, 0, null);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "StateModel [x=" + x + ", y=" + y + "]";
    }

    public String toShortString() {
        return "StateModel [x=" + Math.round(x * 100.0) / 100.0 + ", y=" + Math.round(y * 100.0) / 100.0 + "]";
    }

}
