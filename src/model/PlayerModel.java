package model;

import utils.PlayerFigure;

//どこかでStartPosを定義する。
public class PlayerModel {
    public int x, y;
    PlayerFigure player;
    public boolean isMoveLeft;
    public boolean isMoveRight;
    public boolean isJump;
    public boolean isHookLeft;
    public boolean isHookRight;

    public PlayerModel(PlayerFigure player, int x, int y){
        this.x = x;
        this.y = y;
        this.player = player;
        init();
    }
/**
 * boolをすべてfalseに変更する関数
 */
    private void disableAll() {
        isMoveLeft = false;
        isMoveRight = false;
        isJump = false;
        isHookLeft = false;
        isHookRight = false;
    }

    public void init() {
        player = new PlayerFigure();
        player.setX(x);
        player.setY(y);
    }

    public void boolMoveLeft() {
        isMoveLeft = true;
        isMoveRight = false;
    }

    public void boolMoveRight() {
        //System.out.println("Move Right");
        isMoveRight = true;
        isMoveLeft = false;
    }

    public void boolJump(){
        isJump = true;
    }

    public void boolPlayerWait(int num){
        disableAll();
    }

    public void boolHookLeft() {
        isHookLeft = true;
    }

    public void boolHookRight() {
        isHookRight = true;
    }

    // どこかにboolがtrueならutilsを呼び出すものを作る。
}
