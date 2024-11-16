package utils;


public class PlayerFigure {
    private int x,y;//中心の座標
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    void MoveRight(){
        x++;
    }
    void MoveLeft(){
        x--;
    }
    void MoveUp(){
        y++;
    }
    void MoveDown(){
        y--;
    }
}
