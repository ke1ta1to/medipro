package models;

import java.util.List;

public class LanguageModel {

    /**
     * waitが来るまでif文で処理を取り、waitが来たらEntityStatusModelをAddする。
     * splitする必要のないものを先に処理し、splitする必要がある場合はsplitして処理する。
     */

    public void load(List<EntityStatusModel> stateLayers, String command) {
        // TODO: 言語の解析（メジェドさん）
        boolean isMoveLeft = false;
        boolean isMoveRight = false;

        stateLayers.clear();
        String[] commands = command.split("\n");
        for (String c : commands) {
            System.out.println(c);
            // TODO:これだとmove leftの後にスペース入れるとダメになるからできれば入れ子構造きつくてもmoveのあとにleftかrightかを判別したい
            if (c.equals("move left")) {
                isMoveLeft = true;
            } else if (c.equals("move right")) {
                isMoveRight = true;
                System.out.println("true");
            } else if (c.equals("jump")) {
                // TODO: jump処理
            } else if (c.equals("stop")) {
                isMoveLeft = false;
                isMoveRight = false;
            } else if (c.equals("hook")) {
                // TODO: hook処理
            } else {
                String[] params = c.split(" ");
                if (params[0].equals("wait")) {
                    int waiting = Integer.parseInt(params[1]);
                    stateLayers.add(new EntityStatusModel(waiting, isMoveRight, isMoveLeft));
                    isMoveLeft = false;
                    isMoveRight = false;
                } else {
                    System.out.println("error");
                    // TODO: 言語のコンパイルに失敗したときの処理
                }
            }
        }
    }

}
