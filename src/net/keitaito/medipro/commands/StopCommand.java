package net.keitaito.medipro.commands;

import net.keitaito.medipro.IKeyAction;

public class StopCommand extends Command {

    public StopCommand() {
        super("^stop$");
    }

    @Override
    public void execute(IKeyAction action, String rawText) {
        action.clearKeys();
    }

}
