package net.keitaito.medipro.commands;

import java.awt.event.KeyEvent;

import net.keitaito.medipro.App;
import net.keitaito.medipro.IKeyAction;

public class LeftCommand extends Command {

    public LeftCommand() {
        super("^left$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) {
        if (App.getStageModel().getEntity().isAlive() && !App.getStageModel().getEntity().isGoal()) {
            action.removeKey(KeyEvent.VK_D);
            action.addKey(KeyEvent.VK_A);
        }
    }

}
