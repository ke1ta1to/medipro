package model;

public class EditorModel {
    private PlayerModel playerModel;

    public EditorModel(PlayerModel playerModel) {
        this.playerModel = playerModel;
    }

    public void compiletext(String text) {
        String[] EditorText = text.split("\n", 0);
        // System.out.println("行数: " + EditorText.length);
        for (String line : EditorText) {
            // System.out.println("中身: " + line);
            compile(line);
        }
    }

    public void compile(String text) {
        if (text.isEmpty()) {
            return;// 空文字列なら無視
        }
        String[] word = text.split(" ");
        if (word[0].equals("move")) {
            if (word[1].equals("left")) {
                playerModel.boolMoveLeft();
            } else if (word[1].equals("right")) {
                playerModel.boolMoveRight();
            } else {
                System.out.println("compile Error");
            }
        } else if (word[0].equals("wait")) {
            System.out.println("wait " + word[1] + "\n");
            int num = Integer.parseInt(word[1]);
            //このプログラムだけをn*1000ミリ秒止めたい
            playerModel.boolPlayerWait(num);
        } else if (word[0].equals("jump")) {
            System.out.println("jump\n");
            playerModel.boolJump();
        } else if (word[0].equals("hook")) {
            if (word[1].equals("left")) {
                playerModel.boolHookLeft();
            } else if (word[1].equals("right")) {
                playerModel.boolHookRight();
            } else {
                System.out.println("compile Error");
            }
        } else {
            System.out.println("compile Error");
        }
    }
}
