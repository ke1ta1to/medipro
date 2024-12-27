package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entities.EntityAction;

public class LanguageModel {
    private Pattern waitPattern = Pattern.compile("^wait\\s+(\\d+)$");

    /**
     * waitが来るまでif文で処理を取り、waitが来たらEntityStatusModelをAddする。splitする必要のないものを先に処理し、splitする必要がある場合はsplitして処理する。
     * 
     * @param entityStatusLayers EntityStatusModelのリスト
     * @param command            ユーザーが入力したコマンド
     */
    public void load(List<EntityAction> entityStatusLayers, String command) {
        double speed = 0;

        entityStatusLayers.clear();
        List<String> commands = new ArrayList<>(Arrays.asList(command.split("\n")));
        commands.add("wait 0");
        for (String c : commands) {
            c = c.trim();
            Matcher waitMatcher = waitPattern.matcher(c);
            if (c.equals("move left")) {
                speed = -1;
            } else if (c.equals("move right")) {
                speed = 1;
            } else if (c.equals("jump")) {
                // TODO: jump処理
            } else if (c.equals("stop")) {
                speed = 0;
            } else if (c.equals("hook")) {
                // TODO: hook処理
            } else if (waitMatcher.matches()) {
                int delay = Integer.parseInt(waitMatcher.group(1));
                EntityAction entityAction = new EntityAction();
                entityAction.setSpeed(speed);
                entityAction.setDelay(delay);
                entityStatusLayers.add(entityAction);
                speed = 0;
            } else {
                System.out.println("error");
                // TODO: 言語のコンパイルに失敗したときの処理
            }
        }
    }

}
