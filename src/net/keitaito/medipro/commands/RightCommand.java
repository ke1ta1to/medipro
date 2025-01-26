package net.keitaito.medipro.commands;

import java.awt.event.KeyEvent;

import net.keitaito.medipro.IKeyAction;

public class RightCommand extends Command {

    public RightCommand() {
        super("^right$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) {
        action.removeKey(KeyEvent.VK_A);
        action.addKey(KeyEvent.VK_D);
    }
}
