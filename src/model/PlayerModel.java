package model;

import utils.PlayerFigure;

//どこかでStartPosを定義する。
public class PlayerModel {
    public int X, Y;
    PlayerFigure player;
    public boolean IsMoveLeft;
    public boolean IsMoveRight;
    public boolean IsJump;
    public boolean IsHookLeft;
    public boolean IsHookRight;

    public PlayerModel(PlayerFigure player, int x, int y){
        this.X = x;
        this.Y = y;
        this.player = player;
        init();
    }
    private void falseBool() {
        IsMoveLeft = false;
        IsMoveRight = false;
        IsJump = false;
        IsHookLeft = false;
        IsHookRight = false;
    }

    public void init() {
        player = new PlayerFigure();
        falseBool();
    }

    public void boolMoveLeft() {
        IsMoveLeft = true;
        IsMoveRight = false;
    }

    public void boolMoveRight() {
        System.out.println("Move Right");
        IsMoveRight = true;
        IsMoveLeft = false;
    }

    public void boolJump(){
        IsJump = true;
    }

    public void boolPlayerWait(int num){
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
