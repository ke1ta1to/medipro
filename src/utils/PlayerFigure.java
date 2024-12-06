package utils;

public class PlayerFigure {
    private int x, y;// 中心の座標

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void moveRight() {
        x++;
        //System.out.println("Move Right");
    }

    public void moveLeft() {
        x--;
        //System.out.println("Move Left");
    }

    public void moveUp() {
        y++;
    }

    public void moveDown() {
        y--;
    }
}
