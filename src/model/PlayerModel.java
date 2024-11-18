package model;

import utils.PlayerFigure;

//どこかでStartPosを定義する。
public class PlayerModel {
    int X, Y;
    PlayerFigure player;
    boolean IsMoveLeft;
    boolean IsMoveRight;
    boolean IsJump;
    boolean IsHookLeft;
    boolean IsHookRight;

    private void falseBool() {
        IsMoveLeft = false;
        IsMoveRight = false;
        IsJump = false;
        IsHookLeft = false;
        IsHookRight = false;
    }

    public void init() {
        player = new PlayerFigure();
        player.setX(X);
        player.setY(Y);
        falseBool();
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
        falseBool();
    }

    public void boolHookLeft() {
        IsHookLeft = true;
    }

    public void boolHookRight() {
        IsHookRight = true;
    }

    // どこかにboolがtrueならutilsを呼び出すものを作る。
}
