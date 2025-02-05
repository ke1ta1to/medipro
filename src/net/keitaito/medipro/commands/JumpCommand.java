package net.keitaito.medipro.commands;

import java.awt.event.KeyEvent;

import net.keitaito.medipro.App;
import net.keitaito.medipro.IKeyAction;

public class JumpCommand extends Command {

    public JumpCommand() {
        super("^jump$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) throws InterruptedException {
        if (App.getStageModel().getEntity().isAlive()) {
            action.addKey(KeyEvent.VK_SPACE);
            sleep(10);
            action.removeKey(KeyEvent.VK_SPACE);
        }
    }

}
