package models;

public class StateModel {

    private double x;
    private double y;

    public StateModel(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public StateModel() {
        this(0, 0);
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

    @Override
    public String toString() {
        return "StateModel [x=" + x + ", y=" + y + "]";
    }

    public String toShortString() {
        return "StateModel [x=" + Math.round(x * 100.0) / 100.0 + ", y=" + Math.round(y * 100.0) / 100.0 + "]";
    }

}
