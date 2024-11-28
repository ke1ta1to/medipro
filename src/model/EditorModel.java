package model;

public class EditorModel {
    private PlayerModel playerModel;

    public EditorModel(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    /**
     * 文字列を改行ごとに分ける関数。
     */
    public void compileText(String text) {
        String[] EditorText = text.split("\n", 0);
        for (String line : EditorText) {
            compile(line);
        }
    }
    /**
     * splitした文字列のコンパイル関数
     * @param text
     */
    public void compile(String text) {
        if (text.isEmpty()) {
            //空白文字なら無視
            return;
        }
        if (text.equals("move left")) {
            playerModel.boolMoveLeft();
        }else if (text.equals("move right")){
            playerModel.boolMoveRight();
        } else if (text.equals("wait")) {
            //System.out.println("wait " + word[1] + "\n");
            int num = Integer.parseInt("1");
            //このプログラムだけをn*1000ミリ秒止めたい!!
            playerModel.boolPlayerWait(num);
        } else if (text.equals("jump")) {
            playerModel.boolJump();
        } else if (text.equals("hook left")) {
            playerModel.boolHookLeft();
        } else if (text.equals("hook right")) {
            playerModel.boolHookRight();
        } else {
            System.out.println("compile Error");
        }
    }
}
