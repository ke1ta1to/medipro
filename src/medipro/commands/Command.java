package medipro.commands;

import medipro.App;
import medipro.IKeyAction;
import medipro.stage.StageModel;

public abstract class Command {

    private final String regex;

    public Command(String regex) {
        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public boolean matches(String input) {
        return input.matches(regex);
    }

    protected void sleep(int time) {
        StageModel stageModel = App.getStageModel("sleep");
        // 100tpsのとき、何tick待つか
        int tick = time / 10;
        // スタート時
        int startTick = stageModel.getTickCount();
        while (stageModel.getTickCount() - startTick < tick) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public abstract void execute(IKeyAction action, String rawText) throws InterruptedException;

}
