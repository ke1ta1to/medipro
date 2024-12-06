package model;

import utils.PlayerFigure;

//どこかでStartPosを定義する。
public class PlayerModel {
    private int x, y;
    PlayerFigure player;

    public void init() {
        player = new PlayerFigure();
        player.setX(x);
        player.setY(y);
    }
}
