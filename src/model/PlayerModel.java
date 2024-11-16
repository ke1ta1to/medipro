package model;
import utils.PlayerFigure;

    //どこかでStartPosを定義する。
public class PlayerModel{
    int X,Y;
    PlayerFigure player;
    
    public void init(){
        player = new PlayerFigure();
        player.setX(X);
        player.setY(Y);
    }
}
