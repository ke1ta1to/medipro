package models;

import java.util.List;

public class LanguageModel {

    public void load(List<StateLayerModel> stateLayers, String command) {
        // TODO: 言語の解析（メジェドさん）

        stateLayers.clear();
        String[] commands = command.split("\n");
        for (String c : commands) {
            String[] params = c.split(" ");
            int waiting = Integer.parseInt(params[0]);
            boolean moveRight = Boolean.parseBoolean(params[1]);
            boolean moveLeft = Boolean.parseBoolean(params[2]);
            stateLayers.add(new StateLayerModel(waiting, moveRight, moveLeft));
        }
    }

}
