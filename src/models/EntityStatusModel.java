package models;

public class EntityStatusModel {

    private int waiting;
    private boolean moveRight;
    private boolean moveLeft;

    public EntityStatusModel(int waiting, boolean moveRight, boolean moveLeft) {
        this.waiting = waiting;
        this.moveRight = moveRight;
        this.moveLeft = moveLeft;
    }

    public EntityStatusModel() {
        this(0, false, false);
    }

    public int getWaiting() {
        return waiting;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }

    public boolean isMoveRight() {
        return moveRight;
    }

    public void setMoveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public boolean isMoveLeft() {
        return moveLeft;
    }

    public void setMoveLeft(boolean moveLeft) {
        this.moveLeft = moveLeft;
    }

    @Override
    public String toString() {
        return "EntityStatusModel [waiting=" + waiting + ", moveRight=" + moveRight + ", moveLeft=" + moveLeft + "]";
    }

}
