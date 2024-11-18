package model;

import utils.PlayerFigure;

//どこかでStartPosを定義する。
public class PlayerModel {
    int X, Y;
    PlayerFigure player;
    boolean IsMoveLeft;
    boolean IsMoveRight;
    boolean IsJump;

    public void init() {
        player = new PlayerFigure();
        player.setX(X);
        player.setY(Y);
        IsMoveLeft = false;
        IsMoveRight = false;
    }

    public void boolMoveLeft() {
        IsMoveLeft = true;
    }

    public void boolMoveRight() {
        IsMoveRight = true;
    }

    public void boolJump() {
        IsJump = true;
    }

    public void boolPlayerWait(int num) {
        // n秒待つ
        IsMoveLeft = false;
        IsMoveRight = false;
        IsJump = false;
    }

    // どこかにboolがtrueならutilsを呼び出すものを作る。
}
