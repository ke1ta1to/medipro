package net.keitaito.medipro.commands;

import java.awt.event.KeyEvent;

import net.keitaito.medipro.App;
import net.keitaito.medipro.IKeyAction;

public class HookCommand extends Command {

    public static final String HOOK_REGEX = "^hook (right|left)$";
    public static final String HOOK_RIGHT_REGEX = "^hook right$";
    public static final String HOOK_LEFT_REGEX = "^hook left$";

    public HookCommand() {
        super(HOOK_REGEX);
    }

    @Override
    public void execute(IKeyAction action, String rawText) throws InterruptedException {
        if (App.getStageModel().getEntity().isAlive() && !App.getStageModel().getEntity().isGoal()) {
            if (rawText.matches(HOOK_RIGHT_REGEX)) {
                action.addKey(KeyEvent.VK_K);
                sleep(10);
                action.removeKey(KeyEvent.VK_K);
            } else if (rawText.matches(HOOK_LEFT_REGEX)) {
                action.addKey(KeyEvent.VK_H);
                sleep(10);
                action.removeKey(KeyEvent.VK_H);
            }
        }
    }

}
